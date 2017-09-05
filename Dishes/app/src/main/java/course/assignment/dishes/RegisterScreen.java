package course.assignment.dishes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by User on 05/09/17.
 */

public class RegisterScreen extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registerscreen);

        final EditText email = (EditText) findViewById(R.id.email_edittext);
        final EditText passwd = (EditText) findViewById(R.id.password_edittext);
        final EditText address = (EditText) findViewById(R.id.address_edittext);

        final Button registerButton = (Button) findViewById(R.id.register_button);
        registerButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                // Create an explicit Intent for starting the LoginScreen Activity
                Intent regIntent = new Intent(RegisterScreen.this, LoginScreen.class);

                // Use the Intent to start the HelloAndroid Activity
                startActivity(regIntent);
            }
        });
    }
}
