package com.example.myscheduleapp.ui;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.myscheduleapp.MainActivity;
import com.example.myscheduleapp.R;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // מחבר את ה-XML לקוד Java
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // חיבור כפתורים ל-Java לפי ID
        Button btnSchedule = view.findViewById(R.id.btnSchedule);
        Button btnTasks = view.findViewById(R.id.btnTasks);
        Button btnReminders = view.findViewById(R.id.btnReminders);
        Button btnInvitations = view.findViewById(R.id.btnInvitations);
        Button btnSettings = view.findViewById(R.id.btnSettings);
        Button btnLogout = view.findViewById(R.id.btnLogout);

        // מעברים למסכים אחרים דרך MainActivity
        btnSchedule.setOnClickListener(v ->
                ((MainActivity) requireActivity()).loadFragment(new ScheduleFragment()));

        btnTasks.setOnClickListener(v ->
                ((MainActivity) requireActivity()).loadFragment(new TasksFragment()));

        btnReminders.setOnClickListener(v ->
                ((MainActivity) requireActivity()).loadFragment(new RemindersFragment()));

        btnInvitations.setOnClickListener(v ->
                ((MainActivity) requireActivity()).loadFragment(new InvitationsFragment()));

        btnSettings.setOnClickListener(v ->
                ((MainActivity) requireActivity()).loadFragment(new SettingsFragment()));

        // כפתור התנתקות
        btnLogout.setOnClickListener(v -> {
            requireActivity().finish();  // מסיים את MainActivity
        });

        return view;
    }
}
