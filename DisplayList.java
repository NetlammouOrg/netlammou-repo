package esprit.tn.netlammou10.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import esprit.tn.netlammou10.consumption.BackTasks;
import esprit.tn.netlammou10.R;
import esprit.tn.netlammou10.adapters.RecyclerAdapter;
import esprit.tn.netlammou10.entities.Action;

public class DisplayList extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Action> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        BackTasks backTasks = new BackTasks(DisplayList.this);

        backTasks.getList(new BackTasks.arrayCallBack() {
           @Override
           public void onSuccess(ArrayList<Action> actions) {
               adapter = new RecyclerAdapter(actions);
               recyclerView.setAdapter(adapter);
           }

           @Override
           public void onFail(String msg) {
               // Do Stuff
           }
       });
        adapter = new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(adapter);

    }


}
