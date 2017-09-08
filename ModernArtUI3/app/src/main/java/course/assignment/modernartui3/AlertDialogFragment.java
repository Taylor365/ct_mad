package course.assignment.modernartui3;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/**
 * Created by User on 07/09/17.
 */

public class AlertDialogFragment extends DialogFragment {

    public static AlertDialogFragment newInstance(){
        return new AlertDialogFragment();
    }

    public Dialog onCreateDialog(Bundle savedInstanceState){
        return new AlertDialog.Builder(getActivity())
                .setMessage(getString(R.string.title_visit_moma))
                .setCancelable(false)

                //Set up Negative
                .setNegativeButton("Not now",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.dismiss();
                            }
                        })

                //Set up Positive
                .setPositiveButton(getString(R.string.action_visit_moma),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent goToWeb = new Intent(Intent.ACTION_VIEW);
                                goToWeb.setData(Uri.parse(getString(R.string.web_address_moma)));
                                startActivity(goToWeb);
                            }
                        }).create();
    }

}