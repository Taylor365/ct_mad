package course.assignment.quotesjson;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class JSONActivity extends Activity {

    private String TAG = JSONActivity.class.getSimpleName();
    private ListView lv;

    ArrayList<HashMap<String, String>> quoteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jsonactivity);

        quoteList = new ArrayList<>();
        lv = (ListView) findViewById(R.id.list);

        new GetQuotes().execute();
    }

    private class GetQuotes extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            // Making a request to url and getting response
            String url = "https://raw.githubusercontent.com/btford/philosobot/master/quotes/cats.json";
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);
            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    JSONArray topic = jsonObj.getJSONArray("quotes");

                    for (int i = 0; i < topic.length(); i++) {
                        JSONObject c = topic.getJSONObject(i);
                        String quote = c.getString("quote");
                        String author = null;
                        if(!c.has("author")){
                            author = "No Name Given";
                        }
                        else
                            author = c.getString("author");

                        HashMap<String, String> topicMap = new HashMap<>();

                        topicMap.put("quote", quote);
                        topicMap.put("author", author);

                        quoteList.add(topicMap);
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                    });

                }

            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG).show();
                    }
                });
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            ListAdapter adapter = new SimpleAdapter(JSONActivity.this, quoteList,
                    R.layout.list_item, new String[]{"quote", "author"},
                    new int[]{R.id.quote, R.id.author});
            lv.setAdapter(adapter);
        }
    }
}