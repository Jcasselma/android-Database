package com.example.jcasselm.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.*;
import static
        android.arch.persistence.room.OnConflictStrategy.REPLACE;
import java.util.List;


@Dao
public interface BankAccountDao
{
    @Query("select * from BankAccount")
    LiveData<List<BankAccount>> getAllAccounts();
    @Query("select * from BankAccount where id = :id")
    BankAccount findById(int id);

    @Insert
    void insert(BankAccount account);
    @Insert
    void insertAll(BankAccount... accounts);
    @Update(onConflict = REPLACE)
    void update (BankAccount account);
    @Delete
    void delete(BankAccount account);
    @Delete
    void deleteSeveral(BankAccount... accounts);

    @Query("delete from BankAccount")
    void deleteAll();
}