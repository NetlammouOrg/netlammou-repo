package esprit.tn.netlammou10.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.noussa.crowd.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class List_activit extends AppCompatActivity {

    ListView lstMessage;
    List<String> messages;
    int actuality_name;
    EditText actualityname;

    String[] from = {"php_key", "c_key", "android_key", "hacking_key"};
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_activit);
        messages = new ArrayList<>();
        lstMessage = (ListView) findViewById(R.id.lst_msg);

        arrayAdapter = new ArrayAdapter(this, R.layout.item_message, R.id.tvMessage, messages);

        lstMessage.setAdapter(arrayAdapter);

        checkMessages();
    }

    private void checkMessages() {
        String url = "http://10.0.2.2:18080/pidev-web/rest/actionspast";
        Volley.newRequestQueue(this).add(new JsonArrayRequest(Request.Method.GET, url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    JSONObject json = response.optJSONObject(i);
                    try {
                        String chaine = " " + " " + json.getString("name") + "  " + " " + json.getString("date");
                        //String chaine1 = " " + " " + json.getString("type");
                       // String chaine2 = "";
                        messages.add(chaine);
                       // messages.add(chaine1);

                       // messages.add(chaine2);
                        arrayAdapter.notifyDataSetChanged();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }));
    }






    public void click_Find_Actuality(View view) {

        actualityname = (EditText) findViewById(R.id.actualityname);

        actuality_name = actualityname.getInputType();
        System.out.println("name is =" + actuality_name);


        messages = new ArrayList<>();
        lstMessage = (ListView) findViewById(R.id.lst_msg);

        arrayAdapter = new ArrayAdapter(this, R.layout.item_message, R.id.tvMessage, messages);

        lstMessage.setAdapter(arrayAdapter);


        String url = "http://10.0.2.2:18080/pidev-web/rest/actionsfind/" + actuality_name;
        Volley.newRequestQueue(this).add(new JsonArrayRequest(Request.Method.GET, url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    JSONObject json = response.optJSONObject(i);
                    try {

                        String chaine = " " + " " + json.getString("name") + "  " + " " + json.getString("type");
                        messages.add(chaine);
                        arrayAdapter.notifyDataSetChanged();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }));


    }
}
