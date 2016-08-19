package cn.itcast.transction;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

    private MyOpenHelper myOpenHelper;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      myOpenHelper = new MyOpenHelper(getApplicationContext());
        SQLiteDatabase db = myOpenHelper.getReadableDatabase();
    }
  public void click(View v){
	  SQLiteDatabase db = myOpenHelper.getWritableDatabase();
	  db.beginTransaction();
	   try {
	     db.execSQL("update info set money=money-1000 where name=?", new Object[]{"张三"});
	     db.execSQL("update info set money=money+1000 where name=?", new Object[]{"李斯"});
	     db.setTransactionSuccessful();
	   } finally {
	     db.endTransaction();
	   }
	    }
	   

	  
 
}
