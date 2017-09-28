package com.example.aleksandrakorolczuk1.dtravel;

import android.content.Intent;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;

/**
 * Created by aleksandrakorolczuk1 on 2017-07-04.
 */

public class GoalListFragment extends Fragment {

    private RecyclerView mGoalRecyclerView;
    private GoalAdapter mAdater;
    private TextView mYourGoals;
    private Button mAddGoal;
private static final String TAG ="progress bar";

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }


    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

      View view = inflater.inflate(R.layout.fragment_goal_list, container, false);


        mGoalRecyclerView = (RecyclerView) view.findViewById(R.id.goal_recycler_view);
        mGoalRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mYourGoals = (TextView) view.findViewById(R.id.yourdreams);
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "font/Amatic-Bold.ttf");
        mYourGoals.setTypeface(typeface);
        mAddGoal = (Button) view.findViewById(R.id.add_goal);
        mAddGoal.setTypeface(typeface);
        mAddGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Goal goal = new Goal();
                GoalLab.get(getActivity()).addCrime(goal);
                Intent intent = GoalActivity.newIntent(getActivity(), goal.getId());
                startActivity(intent);
            }
        });
        updateUI();

        return view;
    }

    private void updateUI() {
        GoalLab crimeLab = GoalLab.get(getActivity());
        List<Goal> goals = crimeLab.getGoals();
        mAdater = new GoalAdapter(goals);
        mGoalRecyclerView.setAdapter(mAdater);
        mAdater.setGoals(goals);
    }

    private class GoalHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTitleTextView;
        private TextView mSumBudget;
        private ProgressBar mProgressBar;


        private Goal mGoal;

        public GoalHolder(final LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_goal, parent, false));

            itemView.setOnClickListener(this);
            mTitleTextView = (TextView) itemView.findViewById(R.id.goal_name);
            mSumBudget = (TextView) itemView.findViewById(R.id.list_sum_budget);
            mProgressBar = (ProgressBar) itemView.findViewById(R.id.progressBar);
        }


        @Override
        public void onClick(View v) {

            Intent intent = GoalActivity.newIntent(getActivity(), mGoal.getId());
            startActivity(intent);
        }

        public void bind(Goal goal) {
            mGoal = goal;
            mTitleTextView.setText(mGoal.getTitle());
            if(mGoal.getmBudget() == null) {
                mGoal.setmBudget("0");
            }
           mSumBudget.setText(mGoal.getmBudget());
            updateProgressBar();
        }

        public void updateProgressBar() {
            if (mGoal.getmSaving() == null) {
                mGoal.setmSaving("0");
                mProgressBar.setProgress(0);
                Log.d(TAG,"Saving is null");
            }
            int budget = Integer.parseInt(mGoal.getmBudget());
            int saving = Integer.parseInt(mGoal.getmSaving());
            if (saving <= budget && saving != 0) {
                float progress = (float) (saving * 100 / budget);
                int pro = Math.round(progress);
                mProgressBar.setProgress(pro);
                Log.d(TAG,"Setting progress bar");

            } else if (saving > budget)
                mProgressBar.setProgress(100);
        }
        }

    private class GoalAdapter extends RecyclerView.Adapter<GoalHolder> {
        private List<Goal> mCrimes;

        public GoalAdapter(List<Goal> goals) {
            mCrimes = goals;
        }

        @Override
        public GoalHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new GoalHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(GoalHolder holder, int position) {
            Goal goal = mCrimes.get(position);
            holder.bind(goal);
        }

        @Override
        public int getItemCount() {
            return mCrimes.size();
        }

        public void setGoals(List<Goal> goals) {
            mCrimes = goals;
        }

    }

}

