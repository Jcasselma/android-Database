package com.example.jcasselm.database;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executors;

public class BankAccountRepository
{
    private BankAccountDao dao;
    private LiveData<List<BankAccount>> allAccounts;
    BankAccountRepository(Application application)
    {
        BankAccountDB db
                = BankAccountDB.getInstance(application);
        dao = db.getBankAccountDao();
        allAccounts = dao.getAllAccounts();
    }
    LiveData<List<BankAccount>> getAllAccounts()
    {
        return allAccounts;
    }

    public void insert(BankAccount account)
    {
        Executors.newSingleThreadExecutor().execute(() ->
        {
            dao.insert(account);
        });
    }
    public void insertAll(BankAccount... accounts)
    {
        Executors.newSingleThreadExecutor().execute(() ->
        {
            dao.insertAll(accounts);
        });
    }

    public void update (BankAccount account)
    {
        Executors.newSingleThreadExecutor().execute(() ->
        {
            dao.update(account);
        });
    }
    public void delete(BankAccount account)
    {
        Executors.newSingleThreadExecutor().execute(() ->
        {
            dao.delete(account);
        });
    }

    public void deleteSeveral(BankAccount... accounts)
    {
        Executors.newSingleThreadExecutor().execute(() ->
        {
            dao.deleteSeveral(accounts);
        });
    }
    public void deleteAll()
    {
        Executors.newSingleThreadExecutor().execute(() ->
        {
            dao.deleteAll();
        });
    }
}

