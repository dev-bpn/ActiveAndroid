package comstoresearchqmobotech.google.httpsplay.activeandroid.parsing;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Dell on 11/18/2015.
 */
public class MyData {

    public static void getData(JSONObject jsonObject){

        try {
            String title = jsonObject.getString("title/_text");
            String description = jsonObject.getString("description");
            String image = jsonObject.getString("image");
            String title_link = jsonObject.getString("title");

            

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
