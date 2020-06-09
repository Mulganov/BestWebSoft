package com.mulganov.test_task.bestwebsoft.ui.main;

import com.mulganov.test_task.bestwebsoft.ui.main.util.Room;

public class MainPresent {
    public MainActivity activity;
    public Room room;

    public MainPresent(MainActivity mainActivity) {
        activity = mainActivity;

        // Создания\инициализация бд
        room = new Room(this);
    }

    // Событие которое означает что все данные подтянутые и можно приступать к показу данных
    public void initFinish(){
        activity.reloadList(room.users);
    }

}
