package com.example.aleksandrakorolczuk1.dtravel;

import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.UUID;


/**
 * Created by aleksandrakorolczuk1 on 2017-07-12.
 */

public class SaveFragment extends Fragment {
    private static final String ARG_SAVE_ID = "save_id";
    private TextView mGoalTitle;
    private EditText mMorework;
    private EditText mSelling;
    private EditText mShopping;
    private EditText mOther;
    private EditText mLoan;
    private EditText mBills;
    private Button mCalculate;
    private Goal mGoal;
    private Button mNeed;
    private ArrayList<EditText> EditTextsCalculations = new ArrayList<>();
    public static final String TAG = "ONCLICKLISTENER";


    public static SaveFragment newInstance(UUID saveId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_SAVE_ID, saveId);
        SaveFragment fragment = new SaveFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onPause(){
        super.onPause();
        GoalLab.get(getActivity()).updateGoal(mGoal);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID saveId = (UUID) getArguments().getSerializable(ARG_SAVE_ID);
        mGoal = GoalLab.get(getActivity()).getGoal(saveId);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_save, container, false);
        mGoalTitle = (TextView) v.findViewById(R.id.your_title);
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "font/Amatic-Bold.ttf");
        mGoalTitle.setText(mGoal.getTitle());
        mGoalTitle.setTypeface(typeface);
        mNeed = (Button) v.findViewById(R.id.need);
        mNeed.setVisibility(v.INVISIBLE);
        mNeed.setTypeface(typeface);
        mCalculate = (Button) v.findViewById(R.id.calculate);
        mCalculate.setTypeface(typeface);

        mShopping = (EditText) v.findViewById(R.id.shopping);
        mShopping.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mGoal.setmShopping(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        mShopping.setText(mGoal.getmShopping());
        mSelling = (EditText) v.findViewById(R.id.selling);
        mSelling.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mGoal.setmSelling(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        mSelling.setText(mGoal.getmSelling());
        mMorework = (EditText) v.findViewById(R.id.work);
        mMorework.setText(mGoal.getmMorework());
        mMorework.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mGoal.setmMorework(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        mOther =  (EditText) v.findViewById(R.id.other);
        mOther.setText(mGoal.getmOtherSave());
        mOther.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mGoal.setmOtherSave(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });


        mLoan =  (EditText) v.findViewById(R.id.loan);
        mLoan.setText(mGoal.getmLoan());
        mLoan.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mGoal.setmLoan(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        mBills =  (EditText) v.findViewById(R.id.bills);
        mBills.setText(mGoal.getmBills());
        mBills.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mGoal.setmBills(String.valueOf(s));
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        EditTextsCalculations.add(mSelling);
        EditTextsCalculations.add(mShopping);
        EditTextsCalculations.add(mMorework);
        EditTextsCalculations.add(mOther);
        EditTextsCalculations.add(mLoan);
        EditTextsCalculations.add(mBills);

        for (EditText e:EditTextsCalculations){
            e.setTextSize(24);
        }


        mCalculate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mCalculate.setText(String.valueOf(updateSaving(EditTextsCalculations)));
                Log.d(TAG,"after updateSaving" );
                compareBudgetSaving();
                Log.d(TAG,"after comparebudget" );
                mCalculate.setTextSize(40);
                mNeed.setVisibility(v.VISIBLE);

            }
        });
        return v;
    }


    private int updateSaving(ArrayList list){
        EditTextsCalculations = list;
        int sum = 0;
        for (EditText edit : EditTextsCalculations) {
            if (edit.getText().toString().matches("")) {
                edit.setText("0");
            }
            int data = Integer.parseInt(edit.getText().toString());
            sum += data;
        }
        if (sum == 0) {
            mNeed.setText("Please fulfill your budget first.");
        }
        Log.d(TAG,"in updatesaving" );

        mGoal.setmSaving(String.valueOf(sum));
        Log.d(TAG,"checking msaving on Goal"+ mGoal.getmSaving());
        return sum;
    }

    private void compareBudgetSaving(){
        int budget = Integer.parseInt(mGoal.getmBudget());
        int saving = Integer.parseInt(mGoal.getmSaving());
        if (budget > saving) {
            mNeed.setText("You still need: " + String.valueOf(budget - saving));
        }
        else if (budget == saving && budget!=0 ){
            mNeed.setText("Congrats!!! You achieve your goal!");
        }
        else if (budget==0){
            mNeed.setText("Please fulfill your budget first.");
        }
        else {
            mNeed.setText("You have more money than you need.");        }
    }
}
