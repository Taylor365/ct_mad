package course.assignment.gotmap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button locButton = (Button) findViewById(R.id.loc_button);
        locButton.setOnClickListener(new OnClickListener() {
            @Override

            public void onClick(View v) {
                Intent locIntent = new Intent(MainActivity.this, Map.class);

                startActivityForResult(locIntent, 1);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                Toast.makeText(MainActivity.this,
                        data.getStringExtra("marker") + " is your favourite location in Westeros.", Toast.LENGTH_LONG).show();
            }
            if (resultCode == Activity.RESULT_CANCELED) {

            }
        }
    }
}
