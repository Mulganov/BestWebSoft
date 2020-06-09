package com.mulganov.test_task.bestwebsoft.db;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.File;

@Entity()
public class User {
    @PrimaryKey(autoGenerate = true)
    public int key;

    public String name;
    public String phone;
    public String gender;
    public String age;
}
