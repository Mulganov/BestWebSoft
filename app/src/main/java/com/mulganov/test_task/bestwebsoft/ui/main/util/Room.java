package com.mulganov.test_task.bestwebsoft.ui.main.util;

import com.mulganov.test_task.bestwebsoft.db.DB;
import com.mulganov.test_task.bestwebsoft.db.User;
import com.mulganov.test_task.bestwebsoft.ui.main.MainPresent;

import java.util.ArrayList;

public class Room {

    private MainPresent present;

    public static ArrayList<User> users = new ArrayList<>();

    public Room(MainPresent mainPresent ) {
        present = mainPresent;

        new Thread(new Runnable() {
            @Override
            public void run() {
                DB db = androidx.room.Room.databaseBuilder(present.activity,
                        DB.class, "bws_coworkers").build();

                // Чтения всех юзеров
                users = (ArrayList<User>) db.getElementDoa().getAllElement();

                // Возвращаемся в MainPresent и заканчиваем инициализацию
                present.initFinish();
            }
        }).start();
    }
}
