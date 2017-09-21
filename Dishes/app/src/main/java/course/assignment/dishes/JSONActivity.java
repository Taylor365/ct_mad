package course.assignment.dishes;

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

    ArrayList<HashMap<String, String>> cookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jsonactivity);

        cookList = new ArrayList<>();
        lv = (ListView) findViewById(R.id.list);

        new GetCooks().execute();
    }

    private class GetCooks extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            // Making a request to url and getting response
            String url = "https://raw.githubusercontent.com/Taylor365/ct_mad/master/cooks.json";
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);
            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    JSONArray cooks = jsonObj.getJSONArray("cooks");

                    // looping through All Cooks
                    for (int i = 0; i < cooks.length(); i++) {
                        JSONObject c = cooks.getJSONObject(i);
                        String name = c.getString("name");
                        String email = c.getString("email");

                        // Phone node is JSON Object
                        JSONObject dish = c.getJSONObject("dish");
                        String dish1 = dish.getString("dish1");
                        String dish2 = dish.getString("dish2");
                        String dish3 = dish.getString("dish3");

                        // tmp hash map for single contact
                        HashMap<String, String> cook = new HashMap<>();

                        // adding each child node to HashMap key => value
                        cook.put("name", name);
                        cook.put("email", email);
                        cook.put("dish1", dish1);
                        cook.put("dish2", dish2);
                        cook.put("dish3", dish3);
                        // adding contact to contact list
                        cookList.add(cook);
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
            ListAdapter adapter = new SimpleAdapter(JSONActivity.this, cookList,
                    R.layout.list_item, new String[]{"name", "email","dish1","dish2","dish3"},
                    new int[]{R.id.name, R.id.email, R.id.dish1, R.id.dish2, R.id.dish3});
            lv.setAdapter(adapter);
        }
    }
}