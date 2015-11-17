package comstoresearchqmobotech.google.httpsplay.activeandroid.utils;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

/**
 * Created by Dell on 11/17/2015.
 */
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }
}
