package course.assignment.dishes;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends Activity {


    private DatabaseOpenHelper dbHelper;
    private SimpleCursorAdapter cAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button eatButton = (Button) findViewById(R.id.eat_button);
        eatButton.setOnClickListener(new OnClickListener() {
            @Override

            public void onClick(View v) {
                Intent eatIntent = new Intent(MainActivity.this, Address.class);

                startActivity(eatIntent);
            }
        });

        final Button cookButton = (Button) findViewById(R.id.cook_button);
        cookButton.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Intent cookIntent = new Intent(MainActivity.this, LoginScreen.class);

                startActivity(cookIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            //INSERT DIALOG HERE
            AlertDialogFragment aFrag = new AlertDialogFragment();
            aFrag.show(getFragmentManager(), "dialog_fragment");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
