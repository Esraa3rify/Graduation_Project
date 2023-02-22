package com.example.graduationprojectjavamain;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Sign_UpActivity extends AppCompatActivity {
//
    private Button createAccount;

    private EditText registerName, registerEmail, registerPassNum;
    private ProgressDialog loadingBar;

    private FirebaseAuth auth;
    private TextView loginRedirectText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        createAccount=findViewById(R.id.btn_signUp);
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sign_UpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        auth = FirebaseAuth.getInstance();
        createAccount = (Button) findViewById(R.id.btn_signUp);
        registerName = (EditText) findViewById(R.id.etName);
        registerEmail = (EditText) findViewById(R.id.etemail);
        registerPassNum = (EditText) findViewById(R.id.etPass);
        loadingBar = new ProgressDialog(this);
        loginRedirectText=(TextView) findViewById(R.id.loginTV);

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userEmail = registerEmail.getText().toString().trim();
                String pass =  registerPassNum.getText().toString().trim();


                if ( userEmail.isEmpty()){
                    registerEmail.setError("Email cannot be empty");
                }
                if (pass.isEmpty()){
                    registerPassNum.setError("Password cannot be empty");
                } else{
                    auth.createUserWithEmailAndPassword(userEmail, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Sign_UpActivity.this, "SignUp Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Sign_UpActivity.this, LoginActivity.class));
                            } else {
                                Toast.makeText(Sign_UpActivity.this, "SignUp Failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });


        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sign_UpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}










