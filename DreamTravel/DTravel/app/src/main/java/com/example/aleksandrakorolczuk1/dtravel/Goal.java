package com.example.aleksandrakorolczuk1.dtravel;


import android.content.Intent;
import android.widget.EditText;


import java.util.UUID;

/**
 * Created by aleksandrakorolczuk1 on 2017-07-04.
 */

public class Goal {
    private UUID mId;
    private String mName;
    private boolean mLongTerm;
    private String mBudget;
    private String mSaving;
    private String mFlight;
    private String mInsurance;
    private String mFood;
    private String mTransport;
    private String mEntrance;
    private String mOther;
    private String mMorework;
    private String mSelling;
    private String mShopping;
    private String mLoan;
    private String mBills;
    private String mOtherSave;

    public String getmMorework() {
        return mMorework;
    }

    public void setmMorework(String mMorework) {
        this.mMorework = mMorework;
    }

    public String getmSelling() {
        return mSelling;
    }

    public void setmSelling(String mSelling) {
        this.mSelling = mSelling;
    }

    public String getmShopping() {
        return mShopping;
    }

    public void setmShopping(String mShopping) {
        this.mShopping = mShopping;
    }

    public String getmLoan() {
        return mLoan;
    }

    public void setmLoan(String mLoan) {
        this.mLoan = mLoan;
    }

    public String getmBills() {
        return mBills;
    }

    public void setmBills(String mBills) {
        this.mBills = mBills;
    }

    public String getmOtherSave() {
        return mOtherSave;
    }

    public void setmOtherSave(String mOtherSave) {
        this.mOtherSave = mOtherSave;
    }

    public Goal() {
       this(UUID.randomUUID());
    }

    public Goal(UUID id){
        mId = id;
    }

    public UUID getId() {
        return mId;
    }

    public boolean ismLongTerm() {
        return mLongTerm;
    }


    public String getTitle() {
        return mName;
    }

    public void setTitle(String title) {
        mName = title;

    }
    public void setmLongTerm(boolean longterm) {
        mLongTerm = longterm;
    }


    public String getmBudget() {
        return mBudget;
    }

    public void setmBudget(String mBudget) {
        this.mBudget = mBudget;
    }

    public String getmSaving() {
        return mSaving;
    }

    public void setmSaving(String mSaving) {
        this.mSaving = mSaving;
    }

    public String getmFlight() {
        return mFlight;
    }

    public void setmFlight(String mFlight) {
        this.mFlight = mFlight;
    }

    public String getmInsurance() {
        return mInsurance;
    }

    public void setmInsurance(String mInsurance) {
        this.mInsurance = mInsurance;
    }

    public String getmFood() {
        return mFood;
    }

    public void setmFood(String mFood) {
        this.mFood = mFood;
    }

    public String getmTransport() {
        return mTransport;
    }

    public void setmTransport(String mTransport) {
        this.mTransport = mTransport;
    }

    public String getmEntrance() {
        return mEntrance;
    }

    public void setmEntrance(String mEntrance) {
        this.mEntrance = mEntrance;
    }

    public String getmOther() {
        return mOther;
    }

    public void setmOther(String mOther) {
        this.mOther = mOther;
    }
}


