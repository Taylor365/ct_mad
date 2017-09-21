package course.assignment.dishes;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by User on 05/09/17.
 */

public class RegisterScreen extends Activity {

    private DatabaseOpenHelper mDbHelper;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.registerscreen);
        mDbHelper = new DatabaseOpenHelper(this);

        final EditText name = (EditText) findViewById(R.id.name_edittext);
        final EditText email = (EditText) findViewById(R.id.email_edittext);
        final EditText passwd = (EditText) findViewById(R.id.password_edittext);
        final EditText address = (EditText) findViewById(R.id.address_edittext);
        final EditText dish = (EditText) findViewById(R.id.dish_edittext);

        final Button registerButton = (Button) findViewById(R.id.register_button);
        registerButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                insertIntoDB(email.getText().toString(), passwd.getText().toString(), name.getText().toString(), address.getText().toString(), dish.getText().toString());
                // Create an explicit Intent for starting the LoginScreen Activity
                Intent regIntent = new Intent(RegisterScreen.this, LoginScreen.class);

                // Use the Intent to start the HelloAndroid Activity
                startActivity(regIntent);
            }
        });
    }

    private void insertIntoDB(String email, String passwd, String name, String address, String dish) {

        ContentValues values = new ContentValues();

        values.put(DatabaseOpenHelper.COOK_NAME, name);
        values.put(DatabaseOpenHelper.COOK_EMAIL, email);
        values.put(DatabaseOpenHelper.COOK_ADDRESS, address);
        values.put(DatabaseOpenHelper.COOK_PASS, passwd);
        values.put(DatabaseOpenHelper.COOK_DISH, dish);
        mDbHelper.getWritableDatabase().insert(DatabaseOpenHelper.TABLE_NAME, null, values);

        values.clear();
    }
}
