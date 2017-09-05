package course.assignment.dishes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Eat extends Activity {
    public void onCreate(Bundle savedInstanceState) {

        // Required call through to Activity.onCreate()
        // Restore any saved instance state
        super.onCreate(savedInstanceState);

        // Set up the application's user interface (content view)
        setContentView(R.layout.eat);

        final Button sDishButton = (Button) findViewById(R.id.searchDish_button);
        sDishButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent sDishIntent = new Intent(Eat.this, searchDish.class); //Use UITabLayout

                startActivity(sDishIntent);
            }
        });
    }
}
