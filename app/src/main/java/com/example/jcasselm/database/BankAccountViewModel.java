package com.example.jcasselm.database;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class BankAccountViewModel extends AndroidViewModel
{
    private BankAccountRepository repository;
    private LiveData<List<BankAccount>> allAccounts;
    public BankAccountViewModel(Application application)
    {
        super(application);
        repository =
                new BankAccountRepository(application);
        allAccounts = repository.getAllAccounts();
    }
    LiveData<List<BankAccount>> getAllAccounts()
    {
        return allAccounts;
    }

    public void insert(BankAccount account)
    {
        repository.insert(account);
    }
    public void delete(BankAccount account)
    {
        repository.delete(account);
    }
}
