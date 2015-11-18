package comstoresearchqmobotech.google.httpsplay.activeandroid.utils;

import android.app.Application;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;

import comstoresearchqmobotech.google.httpsplay.activeandroid.database.DataItems;
import comstoresearchqmobotech.google.httpsplay.activeandroid.log.MyLog;

/**
 * Created by Dell on 11/17/2015.
 */
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
//        ActiveAndroid.initialize(this);

        Configuration.Builder configurationBuilder = new Configuration.Builder(this).setDatabaseName("my_database.db");
        configurationBuilder.addModelClass(DataItems.class);
        ActiveAndroid.initialize(configurationBuilder.create());

        MyLog.showLog("Active android initialize");
    }
}
