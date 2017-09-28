package com.example.aleksandrakorolczuk1.dtravel.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;


import com.example.aleksandrakorolczuk1.dtravel.database.GoalDbSchema.GoalTable;

/**
 * Created by aleksandrakorolczuk1 on 2017-07-06.
 */

public class GoalBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "crimeBase.db";


    public GoalBaseHelper(Context context){
        super(context, DATABASE_NAME, null, VERSION);

    }

    @Override
    public void onCreate (SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + GoalDbSchema.GoalTable.NAME + "("
                + " _id INTEGER primary key autoincrement, "
                + GoalTable.Cols.UUID + ", " + GoalTable.Cols.TITLE + ", "
                + GoalTable.Cols.BUDGET + ", " +
                 GoalTable.Cols.LONGTERM + ", " + GoalTable.Cols.SAVING +
                ", " + GoalTable.Cols.FLIGHT +
                ", " + GoalTable.Cols.INSURANCE +
                ", " + GoalTable.Cols.FOOD +
                ", " + GoalTable.Cols.TRANSPORT +
                ", " + GoalTable.Cols.ENTRANCE +
                ", " + GoalTable.Cols.OTHER +
                ", " + GoalTable.Cols.MOREWORK +
                ", " + GoalTable.Cols.SELLING +
                ", " + GoalTable.Cols.SHOPPING +
                ", " + GoalTable.Cols.LOAN +
                ", " + GoalTable.Cols.BILLS +
                ", " + GoalTable.Cols.OTHERSAVE +
                ")");



    }
    @Override
    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion){

    }
}


