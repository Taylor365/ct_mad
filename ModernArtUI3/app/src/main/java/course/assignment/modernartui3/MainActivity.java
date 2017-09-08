package course.assignment.modernartui3;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final SeekBar sBar = (SeekBar) findViewById(R.id.seekBar);
        sBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            TextView r1 = (TextView) findViewById(R.id.rectangle1);
            TextView r2 = (TextView) findViewById(R.id.rectangle2);
            TextView r3 = (TextView) findViewById(R.id.rectangle3);
            TextView r4 = (TextView) findViewById(R.id.rectangle4);
            TextView r5 = (TextView) findViewById(R.id.rectangle5);

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int diffProg = (int)(progress * 0.75);

                r1.setBackgroundColor(Color.rgb(204 - diffProg, 255 - diffProg, 255)); //204, 255, 255
                r2.setBackgroundColor(Color.rgb(255, 153 + diffProg, 204 - diffProg)); //255, 153, 204
                r4.setBackgroundColor(Color.rgb(213, 255 - diffProg, 128 - diffProg));//213, 255, 128
                r5.setBackgroundColor(Color.rgb(255, 170 + diffProg, 128 - diffProg));//255, 170, 128
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
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
        if (id == R.id.action_info) {
            //INSERT DIALOG HERE
            AlertDialogFragment aFrag = new AlertDialogFragment();
            aFrag.show(getFragmentManager(), "dialog_fragment");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}


