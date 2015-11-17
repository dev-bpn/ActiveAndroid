package comstoresearchqmobotech.google.httpsplay.activeandroid.utils;

import android.app.Application;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;

import comstoresearchqmobotech.google.httpsplay.activeandroid.log.MyLog;

/**
 * Created by Dell on 11/17/2015.
 */
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
//        ActiveAndroid.initialize(this);

        Configuration configuration = new Configuration.Builder(this).setDatabaseName("my_database.db").create();
        ActiveAndroid.initialize(configuration);

        MyLog.showLog("Active android initialize");
    }
}
