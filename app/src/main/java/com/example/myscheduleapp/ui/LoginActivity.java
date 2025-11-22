package com.example.myscheduleapp.ui;
// מציין לאיזה חבילה (package) הקובץ הזה שייך — חשוב לארגון של הפרויקט.

import android.content.Intent;              // מאפשר לפתוח Activity אחר.
import android.content.SharedPreferences;  // מאפשר לשמור נתונים באופן מקומי על המכשיר.
import android.os.Bundle;                  // מכיל מידע על מצב קודם של Activity.
import android.view.View;                  // מייצג רכיב מסך (View).
import android.widget.Button;              // כפתור UI.
import android.widget.EditText;            // תיבת טקסט למילוי.
import android.widget.Toast;               // הודעה קטנה שקופצת על המסך.

import androidx.appcompat.app.AppCompatActivity;
// Activity בסיסי עם תמיכה בעיצובים חדשים.

import com.example.myscheduleapp.MainActivity;
import com.example.myscheduleapp.R;        // מחלקה אוטומטית שמכילה את כל ה־XML ids.

public class LoginActivity extends AppCompatActivity {
// מחלקה שמייצגת את מסך ההתחברות.

    private EditText emailInput, passwordInput;
    // הגדרת משתנים לטופסי הקלט — אימייל וסיסמה.

    private Button loginButton;
    // משתנה לכפתור ההתחברות.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // onCreate נקרא ברגע שהמסך נטען.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // קובע שהמסך הזה ישתמש בקובץ activity_login.xml

        emailInput = findViewById(R.id.emailInput);
        // מחבר את המשתנה לקלט האימייל שב־XML

        passwordInput = findViewById(R.id.passwordInput);
        // מחבר את המשתנה לקלט הסיסמה

        loginButton = findViewById(R.id.loginButton);
        // מחבר את המשתנה לכפתור ההתחברות

        loginButton.setOnClickListener(new View.OnClickListener() {
            // קובע פעולה שתקרה כאשר לוחצים על הכפתור
            @Override
            public void onClick(View v) {

                String email = emailInput.getText().toString().trim();
                // שומר את הטקסט מהשדה של האימייל + מוריד רווחים

                String password = passwordInput.getText().toString().trim();
                // אותו דבר לסיסמה

                if (email.isEmpty() || password.isEmpty()) {
                    // אם לפחות אחד מהשדות ריק — מציג הודעה ומפסיק
                    Toast.makeText(LoginActivity.this, "נא למלא את כל השדות", Toast.LENGTH_SHORT).show();
                    return;
                }

                SharedPreferences prefs = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);
                // פתיחת זיכרון מקומי שנקרא MyAppPrefs

                String savedEmail = prefs.getString("email", "");
                // שולף מהמכשיר את האימייל שנשמר בהרשמה

                String savedPassword = prefs.getString("password", "");
                // שולף את הסיסמה שנשמרה בהרשמה

                if (email.equals(savedEmail) && password.equals(savedPassword)) {
                    // אם מה שהמשתמש כתב תואם למה ששמור — ההתחברות מצליחה

                    prefs.edit().putBoolean("isLoggedIn", true).apply();
                    // שומר במכשיר שהמשתמש מחובר

                    Toast.makeText(LoginActivity.this, "ברוך הבא!", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    // עובר למסך הבית (MainActivity)

                    startActivity(i);  // מפעיל את המסך החדש
                    finish();          // סוגר את מסך ההתחברות כדי שלא יחזור אחורה

                } else {
                    Toast.makeText(LoginActivity.this, "אימייל או סיסמה שגויים", Toast.LENGTH_SHORT).show();
                    // אם לא תואם — הודעת שגיאה
                }
            }
        });
    }
}
