package com.mulganov.test_task.bestwebsoft.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mulganov.test_task.bestwebsoft.R;
import com.mulganov.test_task.bestwebsoft.db.User;
import com.mulganov.test_task.bestwebsoft.ui.add.AddActivity;
import com.mulganov.test_task.bestwebsoft.ui.main.util.BoxAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MainPresent present;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        present = new MainPresent(this);

        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        reloadList(present.room.users);
    }

    public void reloadList(ArrayList<User> users){
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);

        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        final BoxAdapter adapter = new BoxAdapter(this, users);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                recyclerView.setAdapter(adapter);
            }
        });

    }

}
