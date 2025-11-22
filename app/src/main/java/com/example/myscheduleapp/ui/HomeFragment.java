package com.example.myscheduleapp.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentTransaction;

import com.example.myscheduleapp.R;

public class HomeFragment extends Fragment {

    TextView welcomeText;
    Button btnSchedule, btnTasks, btnReminders, btnMessages, btnSettings, logoutButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // קישור בין קובץ ה-XML לקוד
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // קישור רכיבים לפי ה-ID שלהם
        welcomeText = view.findViewById(R.id.welcomeText);
        btnSchedule = view.findViewById(R.id.btnSchedule);
        btnTasks = view.findViewById(R.id.btnTasks);
        btnReminders = view.findViewById(R.id.btnReminders);
        btnMessages = view.findViewById(R.id.btnMessages);
        btnSettings = view.findViewById(R.id.btnSettings);
        logoutButton = view.findViewById(R.id.logoutButton);

        // שינוי טקסט פתיחה
        welcomeText.setText("ברוך הבא למערכת היומית שלך!");

        // ניווט למסכים אחרים
        btnSchedule.setOnClickListener(v -> openFragment(new ScheduleFragment()));
        btnTasks.setOnClickListener(v -> openFragment(new TasksFragment()));
        btnReminders.setOnClickListener(v -> openFragment(new RemindersFragment()));
        btnMessages.setOnClickListener(v -> openFragment(new MessagesFragment()));
        btnSettings.setOnClickListener(v -> openFragment(new SettingsFragment()));
        logoutButton.setOnClickListener(v -> {
            // מחיקת מצב התחברות
            SharedPreferences prefs = requireActivity().getSharedPreferences("MyAppPrefs", getContext().MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("isLoggedIn", false);
            editor.apply();

            // הודעת הצלחה
            Toast.makeText(getContext(), "התנתקת בהצלחה!", Toast.LENGTH_SHORT).show();

            // מעבר למסך ההתחברות
            // openFragment(new LoginFragment());
        });


        return view;
    }

    // פונקציה שמבצעת את המעבר בפועל בין המסכים
    private void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null); // מאפשר לחזור אחורה
        transaction.commit();
    }
}
