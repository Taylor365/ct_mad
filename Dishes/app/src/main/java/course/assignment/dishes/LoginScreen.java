package course.assignment.dishes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;


public class LoginScreen extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginscreen);

        final EditText email = (EditText) findViewById(R.id.email_edittext);
        final EditText passwd = (EditText) findViewById(R.id.password_edittext);

        final Button loginButton = (Button) findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (checkPassword(email.getText().toString(), passwd.getText().toString())) {
                    Intent loginIntent = new Intent(LoginScreen.this, Cook.class);

                    startActivity(loginIntent);

                } else {
                    email.setText("");
                    passwd.setText("");
                    Toast.makeText(LoginScreen.this, "Incorrect username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        final Button registerButton = (Button) findViewById(R.id.register_button);
        registerButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginScreen.this, RegisterScreen.class);

                startActivity(registerIntent);
            }
        });
    }

    private boolean checkPassword(String email, String passwd) {
        // Just pretending to extract text and check password
        if (email.equals("carl") && passwd.equals("taylor")){
            return true;
        }
        else
            return false;
    }
}
