package course.assignment.dishes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;


public class LoginScreen extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginscreen);

        final EditText uname = (EditText) findViewById(R.id.username_edittext);
        final EditText passwd = (EditText) findViewById(R.id.password_edittext);

        final Button loginButton = (Button) findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (checkPassword(uname.getText().toString(), passwd.getText().toString())) {
                    Intent loginIntent = new Intent(LoginScreen.this, Cook.class);

                    startActivity(loginIntent);

                } else {
                    uname.setText("");
                    passwd.setText("");
                }
            }
        });
    }

    private boolean checkPassword(String uname, String passwd) {
        // Just pretending to extract text and check password
        if (uname.equals("carl") && passwd.equals("taylor")){
            return true;
        }
        else
            return false;
    }
}
