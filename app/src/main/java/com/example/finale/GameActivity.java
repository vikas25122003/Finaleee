package com.example.finale;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class GameActivity extends AppCompatActivity implements FragmentListener {

    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Load the start fragment initially
        loadFragment(new StartGameFragment());
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(
                android.R.anim.fade_in,
                android.R.anim.fade_out
        );
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onStartGame() {
        loadFragment(new ColorGameFragment());
    }

    @Override
    public void onGameComplete(int points) {
        score += points;
        Bundle bundle = new Bundle();
        bundle.putInt("score", score);

        ResultFragment resultFragment = new ResultFragment();
        resultFragment.setArguments(bundle);
        loadFragment(resultFragment);
    }

    @Override
    public void onPlayAgain() {
        loadFragment(new ColorGameFragment());
    }
}

