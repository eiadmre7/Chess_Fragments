package com.example.fragments_with_chess;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity implements StoneAdapter.ItemSelected {
    private String[] details;
    FrameLayout listFragmentContainer;
    FrameLayout detailFragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listFragmentContainer = findViewById(R.id.listFragmentContainer);
        detailFragmentContainer = findViewById(R.id.detailFragmentContainer);
        // Add ListFragment initially
        getSupportFragmentManager().beginTransaction()
                .add(R.id.listFragmentContainer, new ListFragment())
                .commit();
        details=getResources().getStringArray(R.array.details);
    }
    // Method to show DetailFragment
    public void showDetailFragment(int itemId) {
        String detail=details[itemId];
        DetailFragment detailFragment = DetailFragment.newInstance(detail);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.detailFragmentContainer, detailFragment)
                .addToBackStack(null)
                .commit();

        // Make detailFragmentContainer visible
        detailFragmentContainer.setVisibility(View.VISIBLE);
        // Hide listFragmentContainer
        listFragmentContainer.setVisibility(View.GONE);
    }

    @Override
    public void onBackPressed() {

        if (detailFragmentContainer.getVisibility() == View.VISIBLE) {
            // Hide detailFragmentContainer and show listFragmentContainer
            detailFragmentContainer.setVisibility(View.GONE);
            listFragmentContainer.setVisibility(View.VISIBLE);

            // If using FragmentManager, pop the back stack
            if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                getSupportFragmentManager().popBackStack();
            }
        } else {
            // Default back navigation behavior
            super.onBackPressed();
        }
    }


    @Override
    public void onItemSelected(int index) {
        showDetailFragment(index);
    }
}