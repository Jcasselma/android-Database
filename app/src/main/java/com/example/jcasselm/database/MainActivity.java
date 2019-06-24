package com.example.jcasselm.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.*;
import static
        android.arch.persistence.room.OnConflictStrategy.REPLACE;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Entity
    public class EmergencyContact
    {
        @PrimaryKey(autoGenerate = true)
        private long id;

        @ColumnInfo
        private String name;

        @ColumnInfo(name = "phone_num")
        private String phoneNum;

    // constructors, getters, setters, equals(), etc.
    }


}
