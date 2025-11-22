package com.example.myscheduleapp.ui;

import android.content.Intent;                // מאפשר מעבר בין Activities
import android.os.Bundle;                   // מאפשר עבודה עם מצב האפליקציה
import android.view.View;                   // מאפשר זיהוי לחיצות על כפתורים
import android.widget.Button;               // רכיב כפתור
import android.widget.EditText;             // רכיב קלט טקסט
import android.widget.Toast;                // הודעות קופצות למסך
import androidx.appcompat.app.AppCompatActivity;

import com.example.myscheduleapp.R;         // גישה לקבצי XML

public class SignupActivity extends AppCompatActivity {

    // הגדרת משתנים שייצגו את שדות הקלט והכפתור במסך
    private EditText emailInput, passwordInput;
    private Button signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);                           // הפעלת ה־Activity
        setContentView(R.layout.activity_signup);                     // קישור ל־XML של מסך ההרשמה

        // חיבור בין אובייקטים בקוד לרכיבים ב־XML לפי ה־ID
        emailInput = findViewById(R.id.emailInput);                   // שדה אימייל
        passwordInput = findViewById(R.id.passwordInput);             // שדה סיסמה
        signupButton = findViewById(R.id.signupButton);               // כפתור הרשמה

        // פעולה שמתרחשת כשלוחצים על כפתור ההרשמה
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = emailInput.getText().toString().trim();        // לוקח את האימייל שהמשתמש כתב
                String password = passwordInput.getText().toString().trim();  // לוקח את הסיסמה שהמשתמש כתב

                // בדיקה שהשדות לא ריקים
                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(SignupActivity.this,
                            "אנא מלא את כל השדות", Toast.LENGTH_SHORT).show();
                    return;
                }

                // במקרה שאין Firebase — נרשום סתם כאילו הצליח
                Toast.makeText(SignupActivity.this,
                        "נרשמת בהצלחה!", Toast.LENGTH_SHORT).show();

                // אחרי הרשמה עוברים למסך ההתחברות
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
                finish(); // סוגר את מסך ההרשמה שלא יחזור אליו
            }
        });
    }
}
