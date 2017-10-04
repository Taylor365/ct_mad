package course.assignment.gotfamilyviewer;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.LinearLayout;


/**
 * Created by User on 02/10/17.
 */

public class GotFamilyViewerActivity extends Activity implements FamiliesFragment.ListSelectionListener {

        public static String[] mRaceArray;
        public static String[] mDescArray;


        private final DescriptionFragment mDescFrag = new DescriptionFragment();
        private FragmentManager mFragmentManager;
        private FrameLayout mFamiliesFrameLayout, mDescFrameLayout;

        private static final int MATCH_PARENT = LinearLayout.LayoutParams.MATCH_PARENT;
        private static final String TAG = "QuoteViewerActivity";

        @Override
        protected void onCreate(Bundle savedInstanceState) {

            Log.i(TAG, getClass().getSimpleName() + ":entered onCreate()");

            super.onCreate(savedInstanceState);

            // Get the string arrays with the titles and qutoes
            mRaceArray = getResources().getStringArray(R.array.Families);
            mDescArray = getResources().getStringArray(R.array.Description);

            setContentView(R.layout.main);

            // Get references to the TitleFragment and to the QuotesFragment
            mFamiliesFrameLayout = (FrameLayout) findViewById(R.id.race_fragment_container);
            mDescFrameLayout = (FrameLayout) findViewById(R.id.desc_fragment_container);


            // Get a reference to the FragmentManager
            mFragmentManager = getFragmentManager();

            // Start a new FragmentTransaction
            FragmentTransaction fragmentTransaction = mFragmentManager
                    .beginTransaction();

            // Add the TitleFragment to the layout
            fragmentTransaction.add(R.id.race_fragment_container,
                    new FamiliesFragment());

            // Commit the FragmentTransaction
            fragmentTransaction.commit();

            // Add a OnBackStackChangedListener to reset the layout when the back stack changes
            mFragmentManager
                    .addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
                        public void onBackStackChanged() {
                            setLayout();
                        }
                    });
        }

    private void setLayout() {

        // Determine whether the QuoteFragment has been added
        if (!mDescFrag.isAdded()) {

            // Make the TitleFragment occupy the entire layout
            mFamiliesFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    MATCH_PARENT, MATCH_PARENT));
            mDescFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                    MATCH_PARENT));
        } else {

            // Make the TitleLayout take 1/3 of the layout's width
            mFamiliesFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                    MATCH_PARENT, 1f));

            // Make the QuoteLayout take 2/3's of the layout's width
            mDescFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                    MATCH_PARENT, 2f));
        }
    }

    // Called when the user selects an item in the TitlesFragment
    @Override
    public void onListSelection(int index) {

        // If the QuoteFragment has not been added, add it now
        if (!mDescFrag.isAdded()) {

            // Start a new FragmentTransaction
            FragmentTransaction fragmentTransaction = mFragmentManager
                    .beginTransaction();

            // Add the QuoteFragment to the layout
            fragmentTransaction.add(R.id.desc_fragment_container,
                    mDescFrag);

            // Add this FragmentTransaction to the backstack
            fragmentTransaction.addToBackStack(null);

            // Commit the FragmentTransaction
            fragmentTransaction.commit();

            // Force Android to execute the committed FragmentTransaction
            mFragmentManager.executePendingTransactions();
        }

        if (mDescFrag.getShownIndex() != index) {

            // Tell the QuoteFragment to show the quote string at position index
            mDescFrag.showQuoteAtIndex(index);

        }
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, getClass().getSimpleName() + ":entered onDestroy()");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.i(TAG, getClass().getSimpleName() + ":entered onPause()");
        super.onPause();
    }

    @Override
    protected void onRestart() {
        Log.i(TAG, getClass().getSimpleName() + ":entered onRestart()");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.i(TAG, getClass().getSimpleName() + ":entered onResume()");
        super.onResume();
    }

    @Override
    protected void onStart() {
        Log.i(TAG, getClass().getSimpleName() + ":entered onStart()");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.i(TAG, getClass().getSimpleName() + ":entered onStop()");
        super.onStop();
    }
}
