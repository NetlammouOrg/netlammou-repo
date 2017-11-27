package esprit.tn.netlammou10.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.noussa.crowd.Fragment.DetailEvent;
import com.example.noussa.crowd.R;

/**
 * Created by USER on 26/11/2017.
 */

public class detalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_detail_event);

        DetailEvent fragment = new DetailEvent();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.anas, fragment);
        fragmentTransaction.commit();
    }
}
