package course.assignment.dishes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button eatButton = (Button) findViewById(R.id.eat_button);
        eatButton.setOnClickListener(new OnClickListener() {
            @Override

            public void onClick(View v) {
                Intent eatIntent = new Intent(MainActivity.this, Eat.class);

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
}
