package course.assignment.dishes;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by User on 18/09/17.
 */

public class Address extends Activity {
    public void onCreate(Bundle savedInstanceState) {

        // Required call through to Activity.onCreate()
        // Restore any saved instance state
        super.onCreate(savedInstanceState);

        // Set up the application's user interface (content view)
        setContentView(R.layout.address);

        final EditText address = (EditText) findViewById(R.id.address_edittext);

        final Button addressButton = (Button) findViewById(R.id.Address_button);
        addressButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(Address.this);
                sp.edit().putString("delivery address", address.getText().toString()).apply();

                Intent i = new Intent(Address.this, Eat.class);
                startActivity(i);
            }
        });
    }
}
