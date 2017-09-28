package com.example.aleksandrakorolczuk1.dtravel;

import android.content.Intent;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;




import java.util.ArrayList;
import java.util.UUID;


/**
 * Created by aleksandrakorolczuk1 on 2017-07-04.
 */

public class GoalFragment extends Fragment {

    private Goal mGoal;
    private EditText mTitleField;
    private com.rey.material.widget.CheckBox  mLongTerm;
    private Button mCalculate;
    private static final String ARG_CRIME_ID = "goal_id";
    private EditText mFlight;
    private EditText mInsurance;
    private EditText mFood;
    private EditText mTransport;
    private EditText mEntrance;
    private EditText mOther;
    private Button mSaving;
    private TextView mWhatIsYour;
    private Button mDelete;
    private ArrayList<EditText> EditTextsCalculations = new ArrayList<>();




    public static GoalFragment newInstance(UUID goalId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_CRIME_ID, goalId);
        GoalFragment fragment = new GoalFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID goalId = (UUID) getArguments().getSerializable(ARG_CRIME_ID);
        mGoal = GoalLab.get(getActivity()).getGoal(goalId);


    }

    @Override
    public void onPause() {
        super.onPause();
        GoalLab.get(getActivity()).updateGoal(mGoal);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_goal, container, false);




        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "font/Amatic-Bold.ttf");
        mTitleField = (EditText) v.findViewById(R.id.goal_name);
        mTitleField.setText(mGoal.getTitle());
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mGoal.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                //
            }
        });

        mWhatIsYour = (TextView) v.findViewById(R.id.whatisyour);
        mWhatIsYour.setTypeface(typeface);
        mDelete = (Button) v.findViewById(R.id.delete);
        mDelete.setTypeface(typeface);
        mDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoalLab.get(getActivity()).deleteCrime(mGoal);
                getActivity().finish();
            }
        });

        mFlight = (EditText) v.findViewById(R.id.flights);
        mFlight.setText(mGoal.getmFlight());
        mFlight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mGoal.setmFlight(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        mFood = (EditText) v.findViewById(R.id.food);
        mFood.setText(mGoal.getmFood());
        mFood.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mGoal.setmFood(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        mInsurance = (EditText) v.findViewById(R.id.insurance);
        mInsurance.setText(mGoal.getmInsurance());
        mInsurance.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mGoal.setmInsurance(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        mTransport = (EditText) v.findViewById(R.id.transport);
        mTransport.setText(mGoal.getmTransport());
        mTransport.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mGoal.setmTransport(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        mEntrance = (EditText) v.findViewById(R.id.entrance);
        mEntrance.setText(mGoal.getmEntrance());
        mEntrance.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mGoal.setmEntrance(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        mOther = (EditText) v.findViewById(R.id.other);
        mOther.setText(mGoal.getmOther());
        mOther.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mGoal.setmOther(String.valueOf(s));
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        EditTextsCalculations.add(mFood);
        EditTextsCalculations.add(mFlight);
        EditTextsCalculations.add(mInsurance);
        EditTextsCalculations.add(mEntrance);
        EditTextsCalculations.add(mOther);
        EditTextsCalculations.add(mTransport);
        for (EditText e:EditTextsCalculations){
            e.setTextSize(24);
        }



        mSaving = (Button) v.findViewById(R.id.fragment_goal_saving);
        mSaving.setTypeface(typeface);
        mCalculate = (Button) v.findViewById(R.id.calculate);
        mCalculate.setTypeface(typeface);


        mCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateSum(EditTextsCalculations);
                mCalculate.setText(String.valueOf(updateSum(EditTextsCalculations)));
            }
        });
        mSaving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateSum(EditTextsCalculations);
                Intent intent = SaveActivity.newIntent(getActivity(), mGoal.getId());
                startActivity(intent);
            }
        });

        mLongTerm = (com.rey.material.widget.CheckBox) v.findViewById(R.id.longterm);
        mLongTerm.setChecked(mGoal.ismLongTerm());
        mLongTerm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mGoal.setmLongTerm(isChecked);
            }
        });

        return v;
    }



    public int updateSum(ArrayList list) {

        EditTextsCalculations = list;
        int sum=0;
        for (EditText edit : EditTextsCalculations) {
            if (edit.getText().toString().matches("")) {
                edit.setText("0");
            }
            int data = Integer.parseInt(edit.getText().toString());
            sum += data;
        }
        mGoal.setmBudget(Integer.toString(sum));
        if (sum == 0) {
            Toast.makeText(getActivity(), "Please fulfill your budget",
                    Toast.LENGTH_LONG).show();
        }

        return sum;
}


}




