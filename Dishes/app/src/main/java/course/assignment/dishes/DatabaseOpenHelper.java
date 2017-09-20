package course.assignment.dishes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseOpenHelper extends SQLiteOpenHelper {
	
	final static String TABLE_NAME = "cooks";
	final static String COOK_EMAIL = "email";
	final static String COOK_PASS = "password";
	final static String COOK_NAME = "name";
	final static String COOK_ADDRESS = "address";
	final static String COOK_DISH = "dish";
	final static String _ID = "_id";
	final static String[] columns = {_ID, COOK_NAME, COOK_DISH, COOK_ADDRESS};

	final private static String CREATE_CMD =

	"CREATE TABLE cooks (" + _ID
			+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ COOK_NAME + " TEXT NOT NULL,"
			+ COOK_DISH + " TEXT NOT NULL,"
			+ COOK_EMAIL + " TEXT NOT NULL,"
			+ COOK_ADDRESS + " TEXT NOT NULL,"
			+ COOK_PASS + " TEXT NOT NULL)";

	final private static String INSERT_CMD =

			"INSERT INTO cooks ("
					+ COOK_NAME + ","
					+ COOK_DISH + ","
					+ COOK_EMAIL + ","
					+ COOK_ADDRESS + ","
					+ COOK_PASS + ")"
					+ "VALUES('George', 'Lasagna', 'george.lasagna@gmail.com', '22 Shanowen Avenue, Santry, Dublin 9', '12345'),"
					+ "('Peter', 'Burgers', 'Peter@gmail.com', '55 Home Farm Road, Drumcondra, Dublin 9', '12345'),"
					+ "('Sarah', 'Chinese Hot Curry', 'Sarah@gmail.com', '1 OConnell Street, Dublin, Dublin 1', '12345'),"
					+ "('Frank', 'Thai Curry', 'Frank@gmail.com', '66 Mobhi Road, Drumcondra, Dublin 9', '12345'),"
					+ "('Jane', 'Veggie Lasagna', 'Jane@gmail.com', '36 Shanowen Avenue, Santry, Dublin 9', '12345'),"
					+ "('Francesco', 'Meatballs', 'Francesco@gmail.com', '15 Sherrif Street, Dublin, Dublin 1', '12345')";

	final private static String NAME = "cook_db";
	final private static Integer VERSION = 1;
	final private Context mContext;

	public DatabaseOpenHelper(Context context) {
		super(context, NAME, null, VERSION);
		this.mContext = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_CMD);
		db.execSQL(INSERT_CMD);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// N/A
	}

	void deleteDatabase() {
		mContext.deleteDatabase(NAME);
	}
}
