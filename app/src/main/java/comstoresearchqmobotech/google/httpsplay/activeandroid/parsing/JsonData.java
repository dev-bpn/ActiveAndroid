package comstoresearchqmobotech.google.httpsplay.activeandroid.parsing;

import org.json.JSONException;
import org.json.JSONObject;

import comstoresearchqmobotech.google.httpsplay.activeandroid.database.DataItems;
import comstoresearchqmobotech.google.httpsplay.activeandroid.log.MyLog;

/**
 * Created by Dell on 11/18/2015.
 */
public class JsonData {

    public static void saveData(JSONObject jsonObject){

        try {
            String title = jsonObject.getString("title/_text");
            String description = jsonObject.getString("description");
            String image = jsonObject.getString("image");
            String title_link = jsonObject.getString("title");

            DataItems dataItems = new DataItems(title , description , image , title_link);
            dataItems.save();
            MyLog.showLog("Saved data to the database");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
