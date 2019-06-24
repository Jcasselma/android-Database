package com.example.jcasselm.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

@Database(entities = {BankAccount.class}, version = 1)
public abstract class BankAccountDB extends RoomDatabase
{
    public abstract BankAccountDao getBankAccountDao();
    private static BankAccountDB instance = null;
    public static synchronized BankAccountDB
    getInstance(Context context)
    {
        if (instance == null)
        {
            instance = Room.databaseBuilder(context,
                    BankAccountDB.class,
                    "bank.db")
                    .build();
        }
        return instance;
    }

    private static BankAccount[] initialAccounts =
            {
                    new BankAccount(0, "Ron White", "4432244"),
                    new BankAccount(0, "Andrew Black", "5562365"),
                    new BankAccount(0, "Hugh Mungus", "10612577"),

    };

    private static class InitDbCallback extends RoomDatabase.Callback
    {
        private Context context;
        InitDbCallback(Context context)
        {
            this.context = context;
        }

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db)
        {
            super.onCreate(db);
            Thread backgroundThread = new Thread(() ->
                    getInstance(context).getBankAccountDao()
                            .insertAll(initialAccounts));
            backgroundThread.start();

        }

    }



}

