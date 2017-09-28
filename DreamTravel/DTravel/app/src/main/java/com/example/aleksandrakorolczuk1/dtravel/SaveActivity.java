package com.example.aleksandrakorolczuk1.dtravel;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

/**
 * Created by aleksandrakorolczuk1 on 2017-07-12.
 */

public class SaveActivity extends SingleFragmentActivity {

    public static final String EXTRA_SAVE_ID = "com.example.aleksandrakorolczuk1.dtravel.save_id";


    public static Intent newIntent(Context context, UUID saveId) {
        Intent intent = new Intent(context, SaveActivity.class);
        intent.putExtra(EXTRA_SAVE_ID, saveId);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        UUID saveId = (UUID) getIntent().getSerializableExtra(EXTRA_SAVE_ID);
        return SaveFragment.newInstance(saveId);
    }

}