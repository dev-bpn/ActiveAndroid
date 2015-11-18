package comstoresearchqmobotech.google.httpsplay.activeandroid.toast;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Dell on 10/28/2015.
 */
public class MyToast {

    public static void showToast(Context context , String message){
        Toast.makeText(context , message , Toast.LENGTH_SHORT).show();
    }
}
