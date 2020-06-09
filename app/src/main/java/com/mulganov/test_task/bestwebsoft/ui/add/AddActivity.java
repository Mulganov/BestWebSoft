package com.mulganov.test_task.bestwebsoft.ui.add;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mulganov.test_task.bestwebsoft.R;
import com.mulganov.test_task.bestwebsoft.db.DB;
import com.mulganov.test_task.bestwebsoft.db.User;
import com.mulganov.test_task.bestwebsoft.ui.main.util.Room;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        findViewById(R.id.button_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Собераем все инфу с форм, решил не делать проверки на пустые формы
                String name = ((TextView)findViewById(R.id.name)).getText().toString();
                String age = ((TextView)findViewById(R.id.age)).getText().toString();
                String phone = ((TextView)findViewById(R.id.phone)).getText().toString();
                String gender = ((TextView)findViewById(R.id.gender)).getText().toString();

                // Создания пустого юзера
                User user = new User();

                // Заполняем юзера
                user.age = age;
                user.gender = gender;
                user.name = name;
                user.phone = phone;

                // "Кидаем" юзера в общий списко юзеров
                Room.users.add(user);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        DB db = androidx.room.Room.databaseBuilder(getApplicationContext(),
                                DB.class, "bws_coworkers").build();

                        // Добавляем юзера в БД
                        db.getElementDoa().insertAll(user);
                    }
                }).start();


                // Ждем пол секунды и возвращаемся на гланую активность
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                AddActivity.super.onBackPressed();
                            }
                        });
                    }
                }).start();
            }
        });

    }

}
