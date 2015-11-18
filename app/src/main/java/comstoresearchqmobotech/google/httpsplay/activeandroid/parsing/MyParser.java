package comstoresearchqmobotech.google.httpsplay.activeandroid.parsing;

import android.app.ProgressDialog;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import comstoresearchqmobotech.google.httpsplay.activeandroid.log.MyLog;
import comstoresearchqmobotech.google.httpsplay.activeandroid.toast.MyToast;
import comstoresearchqmobotech.google.httpsplay.activeandroid.utils.MyUtils;

/**
 * Created by Dell on 10/29/2015.
 */
public class MyParser {

    private static ProgressDialog progressDialog;

    public static void performVolleyRequest(final Context context , String url){
        progressDialog(context);
        if(MyUtils.isNetworkConnected(context)){
            RequestQueue requestQueue = Volley.newRequestQueue(context);

            StringRequest stringRequest = new StringRequest(
                    Request.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String result) {
                    if(result != null){
                        performJsonTask(context , result);
                        progressDialog.dismiss();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    MyLog.showLog("Result: " + volleyError);
                    MyToast.showToast(context, "Error while parsing. Please reload again...");
                    progressDialog.dismiss();
                }
            });
            requestQueue.add(stringRequest);
        }else{
            MyToast.showToast(context , "No Internet Connection");
            progressDialog.dismiss();
        }
    }

    private static void performJsonTask(Context context, String result){
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(result);
            JSONArray results = jsonObject.getJSONArray("results");
            for(int i = 0 ; i < results.length() ; i ++){
                JSONObject jsonObject1 = results.getJSONObject(i);
//                MyDays.getDays(jsonObject1 , i);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }finally {
            MyToast.showToast(context , "Successfully updated");
        }
    }

    private static void progressDialog(Context context){

        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading your location and schedule...");
        progressDialog.setCancelable(false);
        progressDialog.show();

    }
}
