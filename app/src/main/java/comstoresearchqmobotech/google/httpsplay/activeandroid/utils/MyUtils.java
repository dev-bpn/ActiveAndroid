package comstoresearchqmobotech.google.httpsplay.activeandroid.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.activeandroid.query.Select;

import java.util.List;

import comstoresearchqmobotech.google.httpsplay.activeandroid.database.DataItems;

/**
 * Created by Dell on 11/3/2015.
 */
public class MyUtils {

    public static boolean isNetworkConnected(Context context) {

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo == null) {
            return false;
        } else {
            return networkInfo.getType() == ConnectivityManager.TYPE_WIFI ||
                    networkInfo.getType() == ConnectivityManager.TYPE_MOBILE ||
                    networkInfo.getType() == ConnectivityManager.TYPE_WIMAX;
        }
    }

    public static boolean isTableDataExists(){

        List<DataItems> queryResults = new Select().from(DataItems.class).execute();
        boolean check = queryResults.isEmpty();
        if(check){
            return false;
        }else{
            return true;
        }

    }
}
