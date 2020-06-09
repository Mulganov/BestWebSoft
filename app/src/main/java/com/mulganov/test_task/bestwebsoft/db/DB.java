package com.mulganov.test_task.bestwebsoft.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class /*, AnotherEntityType.class, AThirdEntityType.class */}, version = 1, exportSchema = false)
public abstract class DB extends RoomDatabase {
    public abstract ElementDoa getElementDoa();
}