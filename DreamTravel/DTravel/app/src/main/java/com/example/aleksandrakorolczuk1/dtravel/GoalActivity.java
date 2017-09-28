package com.example.aleksandrakorolczuk1.dtravel;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

/**
 * Created by aleksandrakorolczuk1 on 2017-07-04.
 */

public class GoalActivity extends SingleFragmentActivity {

    public static final String EXTRA_GOAL_ID = "com.example.aleksandrakorolczuk1.dtravel.goal_id";

    public static Intent newIntent(Context context, UUID goalId) {
        Intent intent = new Intent(context, GoalActivity.class);
        intent.putExtra(EXTRA_GOAL_ID, goalId);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        UUID goalId = (UUID) getIntent().getSerializableExtra(EXTRA_GOAL_ID);
        return GoalFragment.newInstance(goalId);
    }

}


