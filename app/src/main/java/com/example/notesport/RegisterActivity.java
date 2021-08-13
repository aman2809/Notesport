package com.example.notesport;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    ImageView back_btn;
    TextView signIn;
    Button signup_button;
    EditText full_name,login_email,login_password;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        back_btn = findViewById(R.id.back_btn);
        signIn = findViewById(R.id.signIn);
        signup_button = findViewById(R.id.signup_button);
        login_password = findViewById(R.id.login_password);
        login_email = findViewById(R.id.login_email);
        full_name = findViewById(R.id.full_name);

        back_btn.setOnClickListener(v -> {
            Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        });
        signIn.setOnClickListener(v -> {
            Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
        });

        firebaseAuth = FirebaseAuth.getInstance();

        signup_button.setOnClickListener(v -> {

            String fullName = full_name.getText().toString().trim();
            String email = login_email.getText().toString().trim();
            String password = login_password.getText().toString().trim();
            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(fullName) || TextUtils.isEmpty(password))
            {
                Toast.makeText(RegisterActivity.this,"Please Enter Complete Details !!!",Toast.LENGTH_SHORT).show();
                return;
            }
            if (password.length()<8 || password.length()>16)
            {
                Toast.makeText(RegisterActivity.this,"Password should be within 8 to 16 characters",Toast.LENGTH_SHORT).show();
            }
            firebaseAuth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(RegisterActivity.this, task -> {
                        if (task.isSuccessful()) {

                            startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                            Toast.makeText(RegisterActivity.this, "Authentication Success.",
                                    Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    });

        });

    }
}