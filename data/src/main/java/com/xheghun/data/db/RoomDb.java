package com.xheghun.data.db;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.xheghun.data.entities.CryptoCoinEntity;

@Database(entities = {CryptoCoinEntity.class}, version = 1, exportSchema = false)
public abstract class RoomDb extends RoomDatabase {
    private static final String DATABASE_NAME = "market_data";
    private static RoomDb INSTANCE;
    public abstract CoinDao coinDao();
    public static RoomDb getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE= Room.databaseBuilder(context.getApplicationContext(),
                    RoomDb.class, DATABASE_NAME).build();
        }
        return INSTANCE;
    }
}