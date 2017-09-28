package com.example.aleksandrakorolczuk1.dtravel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aleksandrakorolczuk1.dtravel.database.GoalBaseHelper;
import com.example.aleksandrakorolczuk1.dtravel.database.GoalCursorWrapper;
import com.example.aleksandrakorolczuk1.dtravel.database.GoalDbSchema;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by aleksandrakorolczuk1 on 2017-07-04.
 */

public class GoalLab {

    private static GoalLab sGoalLab;

    private Context mContex;
    private SQLiteDatabase mDatabase;

    public static GoalLab get(Context context) {
        if (sGoalLab == null) {
            sGoalLab = new GoalLab(context);
        }
        return sGoalLab;
    }

    private GoalLab(Context context) {

        mContex = context.getApplicationContext();
        mDatabase = new GoalBaseHelper(mContex).getWritableDatabase();
    }

    private static ContentValues getContentValues(Goal goal) {
        ContentValues values = new ContentValues();
        values.put(GoalDbSchema.GoalTable.Cols.UUID, goal.getId().toString());
        values.put(GoalDbSchema.GoalTable.Cols.TITLE, goal.getTitle());
        values.put(GoalDbSchema.GoalTable.Cols.BUDGET, goal.getmBudget());
        values.put(GoalDbSchema.GoalTable.Cols.LONGTERM, goal.ismLongTerm() ? 1 : 0);
        values.put(GoalDbSchema.GoalTable.Cols.SAVING, goal.getmSaving());
        values.put(GoalDbSchema.GoalTable.Cols.FLIGHT, goal.getmFlight());
        values.put(GoalDbSchema.GoalTable.Cols.INSURANCE, goal.getmInsurance());
        values.put(GoalDbSchema.GoalTable.Cols.FOOD, goal.getmFood());
        values.put(GoalDbSchema.GoalTable.Cols.TRANSPORT, goal.getmTransport());
        values.put(GoalDbSchema.GoalTable.Cols.ENTRANCE, goal.getmTransport());
        values.put(GoalDbSchema.GoalTable.Cols.OTHER, goal.getmOther());
        values.put(GoalDbSchema.GoalTable.Cols.MOREWORK, goal.getmMorework());
        values.put(GoalDbSchema.GoalTable.Cols.SELLING, goal.getmSelling());
        values.put(GoalDbSchema.GoalTable.Cols.SHOPPING, goal.getmShopping());
        values.put(GoalDbSchema.GoalTable.Cols.LOAN, goal.getmLoan());
        values.put(GoalDbSchema.GoalTable.Cols.BILLS, goal.getmBills());
        values.put(GoalDbSchema.GoalTable.Cols.OTHERSAVE, goal.getmOtherSave());


        return values;
    }

    public void addCrime(Goal c) {
        ContentValues values = getContentValues(c);
        mDatabase.insert(GoalDbSchema.GoalTable.NAME, null, values);
    }

    public void updateGoal(Goal goal) {
        String uuidString = goal.getId().toString();
        ContentValues values = getContentValues(goal);
        mDatabase.update(GoalDbSchema.GoalTable.NAME, values, GoalDbSchema.GoalTable.Cols.UUID + " = ?", new String[]{uuidString});
    }

    private GoalCursorWrapper queryGoals(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(GoalDbSchema.GoalTable.NAME, null, whereClause, whereArgs, null, null, null);
        return new GoalCursorWrapper(cursor);
    }

    public void deleteCrime(Goal goal) {
        String uuidString = goal.getId().toString();
        mDatabase.delete(GoalDbSchema.GoalTable.NAME, GoalDbSchema.GoalTable.Cols.UUID + " = ?", new String[]{uuidString});

    }


    public List<Goal> getGoals() {
        List<Goal> goals = new ArrayList<>();
        GoalCursorWrapper cursor = queryGoals(null, null);

        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                goals.add(cursor.getGoal());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return goals;
    }


    public Goal getGoal(UUID id) {
        GoalCursorWrapper cursor = queryGoals(GoalDbSchema.GoalTable.Cols.UUID + " = ?", new String[]{id.toString()});
        try {
            if (cursor.getCount() == 0) {
                return null;
            }
            cursor.moveToFirst();
            return cursor.getGoal();
        } finally {
            cursor.close();
        }
    }

    }


