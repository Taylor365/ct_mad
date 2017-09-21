package course.assignment.dishes;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by User on 19/09/17.
 */

public class Delivery extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery);

        try {

            // Process text for network transmission
            /*Intent in = getIntent();
            String destination = in.getExtras().getString("delivery address");
            destination = destination.replace(' ', '+');*/

            Intent out = getIntent();
            String origin = out.getExtras().getString("cook address");
            origin = origin.replace(' ', '+');

            // Create Intent object for starting Google Maps application
            Intent geoIntent = new Intent(
                    android.content.Intent.ACTION_VIEW, Uri
                    .parse("geo:0,0?q=" + origin));

            // Use the Intent to start Google Maps application using Activity.startActivity()
            startActivity(geoIntent);

        } catch (Exception e) {
            // Log any error messages to LogCat using Log.e()
            Log.e("What", e.toString());
        }
    }
}
