package course.assignment.dishes;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

/**
 * Created by User on 21/09/17.
 */

public class SearchArea extends ListActivity {

    private DatabaseOpenHelper mDbHelper;
    private SimpleCursorAdapter mAdapter;
    private EditText sArea;
    public void onCreate(Bundle savedInstanceState) {

        // Required call through to Activity.onCreate()
        // Restore any saved instance state
        super.onCreate(savedInstanceState);

        // Set up the application's user interface (content view)
        setContentView(R.layout.searcharea);

        // Create a new DatabaseHelper
        mDbHelper = new DatabaseOpenHelper(this);

        // start with an empty database
        //clearAll();

        sArea = (EditText) findViewById(R.id.sArea_edittext);

        final Button sDishButton = (Button) findViewById(R.id.sArea_button);
        sDishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor c = selectCook();
                mAdapter = new SimpleCursorAdapter(SearchArea.this, R.layout.list_layout, c,
                        DatabaseOpenHelper.columns, new int[] {R.id.id, R.id.name, R.id.dish, R.id.address },
                        0);
                setListAdapter(mAdapter);
            }
        });

        final ListView lv = getListView();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long arg3)
            {
                Cursor c = ((Cursor) lv.getItemAtPosition(position));
                String val = c.getString(c.getColumnIndex(DatabaseOpenHelper.COOK_ADDRESS));
                //String selection = DatabaseOpenHelper.COOK_ADDRESS + " = ?";

                Toast.makeText(SearchArea.this, c.toString(), Toast.LENGTH_LONG).show();

            }
        });

    }

    private Cursor selectCook() {

        String selection = DatabaseOpenHelper.COOK_ADDRESS + " LIKE ?";
        String[] conditions = {"%" + sArea.getText().toString()+ "%"};

        return mDbHelper.getWritableDatabase().query(DatabaseOpenHelper.TABLE_NAME,
                DatabaseOpenHelper.columns, selection, conditions, null, null,
                null);
    }

    // Modify the contents of the database
    private void order() {


    }

    // Delete all records
    private void clearAll() {

        mDbHelper.getWritableDatabase().delete(DatabaseOpenHelper.TABLE_NAME, null, null);

    }

    // Close database
    @Override
    protected void onDestroy() {

        mDbHelper.getWritableDatabase().close();
        mDbHelper.deleteDatabase();

        super.onDestroy();

    }
}
