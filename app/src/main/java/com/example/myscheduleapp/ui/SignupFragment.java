package com.example.myscheduleapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.myscheduleapp.R;

public class SignupFragment extends Fragment {

    private EditText nameInput, emailInput, passwordInput;
    private Button signupButton, backButton;

    public SignupFragment() {
        // נדרש על ידי Android
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup, container, false);

        // קישור בין הקוד לעיצוב
        nameInput = view.findViewById(R.id.nameInput);
        emailInput = view.findViewById(R.id.emailInput);
        passwordInput = view.findViewById(R.id.passwordInput);
        signupButton = view.findViewById(R.id.signupButton);
        backButton = view.findViewById(R.id.backButton);

        // פעולה בעת לחיצה על כפתור "הרשמה"
        signupButton.setOnClickListener(v -> {
            String name = nameInput.getText().toString();
            String email = emailInput.getText().toString();
            String password = passwordInput.getText().toString();

            if (isValidName(name) && isValidEmail(email) && isValidPassword(password)) {
                Toast.makeText(getContext(), "you successfully registered!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "date is incorrect please try again.", Toast.LENGTH_SHORT).show();
            }
        });

        // פעולה בעת לחיצה על "חזור"
        backButton.setOnClickListener(v -> {
            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new LoginFragment())
                    .commit();
        });

        return view;
    }

    // פונקציות בדיקה לנתוני המשתמש
    private boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    private boolean isValidEmail(String email) {
        return email != null && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isValidPassword(String password) {
        return password != null && password.length() >= 6;
    }
}
