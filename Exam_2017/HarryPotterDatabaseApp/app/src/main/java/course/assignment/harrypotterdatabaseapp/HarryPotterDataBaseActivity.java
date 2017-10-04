package course.assignment.harrypotterdatabaseapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ListActivity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class HarryPotterDataBaseActivity extends ListActivity {

	private DatabaseOpenHelper mDbHelper;
	private SimpleCursorAdapter mAdapter;
	private static String result;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);

		// Create a new DatabaseHelper
		mDbHelper = new DatabaseOpenHelper(this);

		// start with an empty database
		clearAll();

		// Insert records
		insertchars();

		// Create a cursor
		Cursor c = readchars();
		mAdapter = new SimpleCursorAdapter(this, R.layout.list_layout, c,
				DatabaseOpenHelper.columns, new int[] { R.id._id, R.id.name, R.id.age, R.id.wand, R.id.birth_place, R.id.description },
				0);

		setListAdapter(mAdapter);

		final ListView lv = getListView();
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> adapter, View v, int position, long arg3)
			{
				Cursor cItem = ((Cursor) lv.getItemAtPosition(position));
				String name = cItem.getString(cItem.getColumnIndex(DatabaseOpenHelper.CHAR_NAME));
				String wand = cItem.getString(cItem.getColumnIndex(DatabaseOpenHelper.CHAR_WAND));
				String age = cItem.getString(cItem.getColumnIndex(DatabaseOpenHelper.CHAR_AGE));
				String desc = cItem.getString(cItem.getColumnIndex(DatabaseOpenHelper.CHAR_DESCRIPTION));
				String birthplace = cItem.getString(cItem.getColumnIndex(DatabaseOpenHelper.CHAR_BIRTH_PLACE));

				result = "Name: " + name +"\nWand: " + wand + "\nAge: " + age +"\nBirth Place : " + birthplace + "\nDescription: " + desc;

				AlertDialogFragment aFrag = new AlertDialogFragment();
				aFrag.show(getFragmentManager(), "dialog_fragment");
			}
		});

	}

	// Insert several author records
	private void insertchars() {

		ContentValues values = new ContentValues();

		values.put(DatabaseOpenHelper.CHAR_NAME, "Harry Potter");
		values.put(DatabaseOpenHelper.CHAR_AGE, "18");
		values.put(DatabaseOpenHelper.CHAR_WAND, "Holly Wand");
		values.put(DatabaseOpenHelper.CHAR_BIRTH_PLACE, "Engalnd");
		values.put(DatabaseOpenHelper.CHAR_DESCRIPTION, "The orphan Potter, who, on his eleventh birthday, learns he is a wizard. Thus, he attends Hogwarts School of Witchcraft and Wizardry to practise magic.");
		mDbHelper.getWritableDatabase().insert(DatabaseOpenHelper.TABLE_NAME, null, values);

		values.clear();

		values.put(DatabaseOpenHelper.CHAR_NAME, "Hermione Granger");
		values.put(DatabaseOpenHelper.CHAR_AGE, "18");
		values.put(DatabaseOpenHelper.CHAR_WAND, "Dragon heartstring");
		values.put(DatabaseOpenHelper.CHAR_BIRTH_PLACE, "England");
		values.put(DatabaseOpenHelper.CHAR_DESCRIPTION, "After Harry and Ron save her from a mountain troll in the girls' toilets, she becomes best friends with them.");
		mDbHelper.getWritableDatabase().insert(DatabaseOpenHelper.TABLE_NAME, null, values);

		values.clear();
		Sauron:
		values.put(DatabaseOpenHelper.CHAR_NAME, "Severus Snape");
		values.put(DatabaseOpenHelper.CHAR_AGE, "45");
		values.put(DatabaseOpenHelper.CHAR_WAND, "Elder Wand");
		values.put(DatabaseOpenHelper.CHAR_BIRTH_PLACE, "England");
		values.put(DatabaseOpenHelper.CHAR_DESCRIPTION, "An exceptionally skilful wizard, his coldly sarcastic and controlled exterior conceals deep emotions and anguish. A Professor at Hogwarts School of Witchcraft and Wizardry.");
		mDbHelper.getWritableDatabase().insert(DatabaseOpenHelper.TABLE_NAME, null, values);

		values.clear();

		values.put(DatabaseOpenHelper.CHAR_NAME, "Ronald Weasley");
		values.put(DatabaseOpenHelper.CHAR_AGE, "18");
		values.put(DatabaseOpenHelper.CHAR_WAND, "Unicorn");
		values.put(DatabaseOpenHelper.CHAR_BIRTH_PLACE, "The Burrow");
		values.put(DatabaseOpenHelper.CHAR_DESCRIPTION, "The best friend of Harry Potter and Hermione Granger. He is a member of the Weasley family, a pure blood family, who reside in \"The Burrow\" outside Ottery St. Catchpole.");
		mDbHelper.getWritableDatabase().insert(DatabaseOpenHelper.TABLE_NAME, null, values);

		values.clear();

		values.put(DatabaseOpenHelper.CHAR_NAME, "James Potter");
		values.put(DatabaseOpenHelper.CHAR_AGE, "52");
		values.put(DatabaseOpenHelper.CHAR_WAND, "Marauder");
		values.put(DatabaseOpenHelper.CHAR_BIRTH_PLACE, "England");
		values.put(DatabaseOpenHelper.CHAR_DESCRIPTION, "The father of Harry Potter. At school, James is said to have been a talented player on the Gryffindor Quidditch team.");
		mDbHelper.getWritableDatabase().insert(DatabaseOpenHelper.TABLE_NAME, null, values);
	}

	// Returns all author records in the database
	private Cursor readchars() {
		return mDbHelper.getWritableDatabase().query(DatabaseOpenHelper.TABLE_NAME,
				DatabaseOpenHelper.columns, null, new String[] {}, null, null,
				null);
	}

	// Delete all records
	private void clearAll() {

		mDbHelper.getWritableDatabase().delete(DatabaseOpenHelper.TABLE_NAME, null, null);

	}

	// Close database
	@Override
	protected void onDestroy() {

		mDbHelper.getWritableDatabase().close();
		mDbHelper.deleteDatabase();

		super.onDestroy();

	}

	public static class AlertDialogFragment extends DialogFragment {

		/*SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
		String result = sp.getString("nice character", "DefaultValue");*/

		public static AlertDialogFragment newInstance(){
			return new AlertDialogFragment();
		}

		public Dialog onCreateDialog(Bundle savedInstanceState){
			return new AlertDialog.Builder(getActivity())
					.setMessage(result)
					.setCancelable(false)

					//Set up Negative
					.setNegativeButton("Close",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int id) {
									dialog.dismiss();
								}
							}).create();
		}
	}
}

