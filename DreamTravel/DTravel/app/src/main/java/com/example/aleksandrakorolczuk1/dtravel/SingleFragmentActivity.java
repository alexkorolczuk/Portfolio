package com.example.aleksandrakorolczuk1.dtravel;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;



/**
 * Created by aleksandrakorolczuk1 on 2017-07-04.
 */

public abstract class SingleFragmentActivity extends AppCompatActivity {

    protected abstract Fragment createFragment();

    private Handler mHandler = new Handler();
    private boolean mShowingBack = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme); //splash theme
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }

//    private void flipCard() {
//        if (mShowingBack) {
//            getFragmentManager().popBackStack();
//            return;
//        }
//        mShowingBack = true;
//        getFragmentManager()
//                .beginTransaction()
//                .setCustomAnimations(
//                        R.animator.card_flip_right_in,
//                        R.animator.card_flip_right_out,
//                        R.animator.card_flip_left_in, R.animator.card_flip_left_out)
//
//                .replace(R.id.fragment_container, new SaveFragment())
//
//                .addToBackStack(null)
//
//                .commit();
//        mHandler.post(new Runnable() {
//            @Override
//            public void run() {
//                invalidateOptionsMenu();
//            }
//        });
//    }
//
//    public void onBackStackChanged() {
//        mShowingBack = (getFragmentManager().getBackStackEntryCount() > 0);
//
//        invalidateOptionsMenu();
//    }

}

