package com.example.myscheduleapp.ui; // חבילת הקובץ

import android.os.Bundle; // מאפשר להשתמש במשתנים בין מסכים
import android.view.LayoutInflater; // אחראי לניפוח קובץ XML
import android.view.View; // מייצג את התצוגה על המסך
import android.view.ViewGroup; // הקבוצה של התצוגה
import android.widget.Button; // כפתורים
import android.widget.TextView; // תיבות טקסט
import android.widget.Toast; // הודעות קצרות על המסך
import com.example.myscheduleapp.R;


import androidx.fragment.app.Fragment; // מחלקת בסיס של פרגמנט

import com.example.myscheduleapp.R; // גישה למשאבים (כמו XML)

public class HomeFragment extends Fragment {

    // הכרזה על כל הכפתורים שנשתמש בהם
    private TextView welcomeText;
    private Button btnSchedule, btnTasks, btnReminders, btnMessages, btnPrivateLessons, btnSettings, logoutButton;

    public HomeFragment() {
        // בנאי ריק — חובה שיהיה בפרגמנט
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // מחבר את קובץ ה-XML עם הקוד
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // קישור בין משתנים בקוד לרכיבים ב-XML לפי ה-ID
        welcomeText = view.findViewById(R.id.welcomeText);
        btnSchedule = view.findViewById(R.id.btnSchedule);
        btnTasks = view.findViewById(R.id.btnTasks);
        btnReminders = view.findViewById(R.id.btnReminders);
        btnMessages = view.findViewById(R.id.btnMessages);
        btnPrivateLessons = view.findViewById(R.id.btnPrivateLessons);
        btnSettings = view.findViewById(R.id.btnSettings);
        logoutButton = view.findViewById(R.id.logoutButton);

        // שינוי הטקסט העליון
        welcomeText.setText("ברוך הבא למערכת היום שלך!");

        // האזנה לכל כפתור ולחיצה עליו
        btnSchedule.setOnClickListener(v ->
                Toast.makeText(getContext(), "פתיחת מערכת שעות", Toast.LENGTH_SHORT).show());

        btnTasks.setOnClickListener(v ->
                Toast.makeText(getContext(), "פתיחת מסך משימות", Toast.LENGTH_SHORT).show());

        btnReminders.setOnClickListener(v ->
                Toast.makeText(getContext(), "פתיחת תזכורות", Toast.LENGTH_SHORT).show());

        btnMessages.setOnClickListener(v ->
                Toast.makeText(getContext(), "פתיחת הודעות", Toast.LENGTH_SHORT).show());

        btnPrivateLessons.setOnClickListener(v ->
                Toast.makeText(getContext(), "פתיחת שיעורים פרטיים", Toast.LENGTH_SHORT).show());

        btnSettings.setOnClickListener(v ->
                Toast.makeText(getContext(), "פתיחת הגדרות", Toast.LENGTH_SHORT).show());

        // התנתקות מהמערכת
        logoutButton.setOnClickListener(v -> {
            Toast.makeText(getContext(), "התנתקת בהצלחה!", Toast.LENGTH_SHORT).show();

            // מחזיר את המשתמש למסך ההתחברות
            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new LoginFragment())
                    .commit();
        });

        // מחזיר את התצוגה למסך
        return view;
    }
}
