package esprit.tn.netlammou10.activities;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.noussa.crowd.Connexion.MySingleton;
import com.example.noussa.crowd.R;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by USER on 26/11/2017.
 */

public class AddActivity extends AppCompatActivity {

   Button add;
    EditText t1;
    EditText t2;
    EditText t3;
    String url = "http://10.0.2.2:18080/pidev-web/rest/actions";
    AlertDialog.Builder builder;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inscription_layout);
        add = (Button) findViewById(R.id.inscription);
        t1 = (EditText) findViewById(R.id.username);
        t2 = (EditText) findViewById(R.id.password);
        t3 = (EditText) findViewById(R.id.passwordconfirm);

        builder = new AlertDialog.Builder(AddActivity.this);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String s1, s2 ,s3;
                s1 = t1.getText().toString();
                s2 = t2.getText().toString();
                s3 = t3.getText().toString();
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        builder.setTitle("reponse du serveur");
                        builder.setMessage("Response:"+response);
                        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                t1.setText("");
                                t2.setText("");
                                t3.setText("");
                            }
                        });
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                    }
                }
                        , new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(AddActivity.this, "Error ..", Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> params = new HashMap<String, String>();
                        params.put("name", s1);
                        params.put("description", s2);
                        params.put("desiredVolenteers", s3);
                        return params;
                    }
                };

                MySingleton.getmInstance(AddActivity.this).addToRequestque(stringRequest);
            }
        });
    }
}
