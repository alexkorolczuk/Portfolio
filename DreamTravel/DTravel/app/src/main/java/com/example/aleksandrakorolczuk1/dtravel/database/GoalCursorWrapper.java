package com.example.aleksandrakorolczuk1.dtravel.database;

import android.database.Cursor;
import android.database.CursorWrapper;
import android.widget.EditText;

import com.example.aleksandrakorolczuk1.dtravel.Goal;

import java.util.Date;
import java.util.UUID;

/**
 * Created by aleksandrakorolczuk1 on 2017-07-07.
 */

public class GoalCursorWrapper extends CursorWrapper {

    public GoalCursorWrapper(Cursor cursor){
        super(cursor);
    }

    public Goal getGoal(){
        String uuidString = getString(getColumnIndex(GoalDbSchema.GoalTable.Cols.UUID));
        String title = getString(getColumnIndex(GoalDbSchema.GoalTable.Cols.TITLE));
        String budget = getString(getColumnIndex(GoalDbSchema.GoalTable.Cols.BUDGET));
        int isLong = getInt(getColumnIndex(GoalDbSchema.GoalTable.Cols.LONGTERM));
        String saving = getString(getColumnIndex(GoalDbSchema.GoalTable.Cols.SAVING));
        String flight = getString(getColumnIndex(GoalDbSchema.GoalTable.Cols.FLIGHT));
        String insurance = getString(getColumnIndex(GoalDbSchema.GoalTable.Cols.INSURANCE));
        String food = getString(getColumnIndex(GoalDbSchema.GoalTable.Cols.FOOD));
        String transport = getString(getColumnIndex(GoalDbSchema.GoalTable.Cols.TRANSPORT));
        String entrance = getString(getColumnIndex(GoalDbSchema.GoalTable.Cols.ENTRANCE));
        String other = getString(getColumnIndex(GoalDbSchema.GoalTable.Cols.OTHER));
        String morework = getString(getColumnIndex(GoalDbSchema.GoalTable.Cols.MOREWORK));
        String selling = getString(getColumnIndex(GoalDbSchema.GoalTable.Cols.SELLING));
        String shopping = getString(getColumnIndex(GoalDbSchema.GoalTable.Cols.SHOPPING));
        String loan = getString(getColumnIndex(GoalDbSchema.GoalTable.Cols.LOAN));
        String bills = getString(getColumnIndex(GoalDbSchema.GoalTable.Cols.BILLS));
        String othersave = getString(getColumnIndex(GoalDbSchema.GoalTable.Cols.OTHERSAVE));


        Goal goal = new Goal(UUID.fromString(uuidString));
        goal.setTitle(title);
        goal.setmBudget(budget);
        goal.setmLongTerm(isLong !=0);
        goal.setmSaving(saving);
        goal.setmFlight(flight);
        goal.setmInsurance(insurance);
        goal.setmFood(food);
        goal.setmTransport(transport);
        goal.setmEntrance(entrance);
        goal.setmOther(other);
        goal.setmMorework(morework);
        goal.setmSelling(selling);
        goal.setmShopping(shopping);
        goal.setmLoan(loan);
        goal.setmBills(bills);
        goal.setmOtherSave(othersave);


        return goal;


    }

}

