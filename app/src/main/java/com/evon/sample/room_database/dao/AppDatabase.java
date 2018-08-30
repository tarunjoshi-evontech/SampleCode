package com.evon.sample.room_database.dao;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.evon.sample.room_database.entity.ModelD;
import com.evon.sample.room_database.entity.Model;

/**
 * The type App database.
 */
@Database(entities = {Model.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    /**
     * Gets database.
     *
     * @param context the context
     * @return the database
     */
    public static AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "evon_db")
                            .build();
        }
        return INSTANCE;
    }

    /**
     * Destroy instance.
     */
    public static void destroyInstance() {
        INSTANCE = null;
    }

    /**
     * Item and person model model d.
     *
     * @return the model d
     */
    public abstract ModelD itemAndPersonModel();

}
