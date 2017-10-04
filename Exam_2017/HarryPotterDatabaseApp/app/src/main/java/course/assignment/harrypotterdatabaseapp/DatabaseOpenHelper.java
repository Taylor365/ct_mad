package course.assignment.harrypotterdatabaseapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseOpenHelper extends SQLiteOpenHelper {

	final static String TABLE_NAME = "characters";
	final static String CHAR_NAME = "name";
	final static String CHAR_AGE = "age";
	final static String CHAR_WAND = "wand";
	final static String CHAR_BIRTH_PLACE = "birth_place";
	final static String CHAR_DESCRIPTION = "description";
	final static String _ID = "_id";
	final static String[] columns = { _ID, CHAR_NAME, CHAR_AGE, CHAR_WAND, CHAR_BIRTH_PLACE,CHAR_DESCRIPTION};

	final private static String CREATE_CMD =

	"CREATE TABLE characters (" + _ID
			+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ CHAR_NAME + " TEXT NOT NULL,"
			+ CHAR_AGE + " TEXT NOT NULL,"
			+ CHAR_WAND + " TEXT NOT NULL,"
			+ CHAR_BIRTH_PLACE + " TEXT NOT NULL,"
			+ CHAR_DESCRIPTION + " TEXT NOT NULL)";

	final private static String NAME = "harry_db";
	final private static Integer VERSION = 1;
	final private Context mContext;

	public DatabaseOpenHelper(Context context) {
		super(context, NAME, null, VERSION);
		this.mContext = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_CMD);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// N/A
	}

	void deleteDatabase() {
		mContext.deleteDatabase(NAME);
	}
}
