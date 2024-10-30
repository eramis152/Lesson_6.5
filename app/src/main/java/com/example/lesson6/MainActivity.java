package com.example.lesson6;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.fragment.app.FragmentTransaction;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragment_container_one) != null &&
                findViewById(R.id.fragment_container_two) != null) {

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container_one, new FragmentOne())
                    .replace(R.id.fragment_container_two, new FragmentTwo())
                    .commit();
        } else {
            Button buttonOne = findViewById(R.id.button_one);
            Button buttonTwo = findViewById(R.id.button_two);

            buttonOne.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getSupportFragmentManager().beginTransaction()
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .replace(R.id.fragment_container, new FragmentOne())
                            .commit();
                }
            });

            buttonTwo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getSupportFragmentManager().beginTransaction()
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
                            .replace(R.id.fragment_container, new FragmentTwo())
                            .commit();
                }
            });
        }
    }
}

