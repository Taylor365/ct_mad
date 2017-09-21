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
                Intent sDishIntent = new Intent(Eat.this, SearchDish.class);

                startActivity(sDishIntent);
            }
        });

        final Button sCookButton = (Button) findViewById(R.id.searchCook_button);
        sCookButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent sCookIntent = new Intent(Eat.this, SearchCook.class);

                startActivity(sCookIntent);
            }
        });

        final Button sAreaButton = (Button) findViewById(R.id.searchArea_button);
        sAreaButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent sAreaIntent = new Intent(Eat.this, SearchArea.class);

                startActivity(sAreaIntent);
            }
        });

        final Button legendaryButton = (Button) findViewById(R.id.legendary_button);
        legendaryButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                startActivity(new Intent(Eat.this, JSONActivity.class));
            }
        });
    }
}
