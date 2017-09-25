package course.assignment.dishes;

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
                .setMessage(getString(R.string.title_about))
                .setCancelable(false)

                //Set up Negative
                .setNegativeButton("Go Back",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.dismiss();
                            }
                        }).create();
    }

}