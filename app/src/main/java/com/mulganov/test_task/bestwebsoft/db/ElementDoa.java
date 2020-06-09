package com.mulganov.test_task.bestwebsoft.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ElementDoa {

    // Добавление Element в бд
    @Insert
    void insertAll(User... users);

    // Удаление Element из бд
    @Delete
    void delete(User... users);

    // Получение всех Element из бд
    @Query("SELECT * FROM User")
    List<User> getAllElement();

}