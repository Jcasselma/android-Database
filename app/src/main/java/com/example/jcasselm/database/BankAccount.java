package com.example.jcasselm.database;

import android.arch.persistence.room.*;
import android.content.Context;

@Entity
public class BankAccount
{
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private String name;

    @ColumnInfo(name = "phone_num")
    private String routingNumber;

    public BankAccount(int id, String name, String routingNumber) {
        this.id = id;
        this.name = name;
        this.routingNumber = routingNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoutingNumber(String routingNumber) {
        this.routingNumber = routingNumber;
    }

    public String getName(){
        return this.name;
    }

    public int getId() {
        return id;
    }

    public String getRoutingNumber() {
        return routingNumber;
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof BankAccount))
            return false;

        BankAccount accountObj = (BankAccount) obj;

        int objId = accountObj.getId();
        String objName = accountObj.getName();
        String objRouting = accountObj.getRoutingNumber();

        if (objId == getId()){
            return true;
        }

        if (objName == getName()){
            return true;
        }

        if (objRouting == getRoutingNumber()){
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return (id + ", " + name + ", " + routingNumber);
    }
}