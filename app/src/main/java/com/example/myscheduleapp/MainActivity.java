package com.example.myscheduleapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.myscheduleapp.R;
import com.example.myscheduleapp.ui.HomeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // אם זו הפתיחה הראשונה – נטען את מסך הבית
        if (savedInstanceState == null) {
            loadFragment(new HomeFragment());
        }
    }

    // פונקציה לטעינת פרגמנט למסך
    public void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
    }
}
