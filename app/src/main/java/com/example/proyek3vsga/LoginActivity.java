package com.example.proyek3vsga;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class LoginActivity extends AppCompatActivity {
    public static final String FILENAME = "login";
    TextInputLayout Username,Password;

    void simpanFileLogin(){
        String isiFile = Username.getEditText().getText().toString() + ";" +
                Password.getEditText().getText().toString();
        File file = new File(getFilesDir(),FILENAME);
        FileOutputStream outputStream;

        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file, false);
            outputStream.write(isiFile.getBytes());
            outputStream.flush();
            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        Toast.makeText(this, "Login Success!", Toast.LENGTH_SHORT).show();
        onBackPressed();
    }

    void login(){
        File file = new File(getFilesDir(),Username.getEditText().getText().toString());

        if (file.exists()){
            StringBuilder text = new StringBuilder();
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = br.readLine();
                while (line != null){
                    text.append(line);
                    line = br.readLine();
                }
                br.close();
            }catch (IOException e){
                System.out.println("Error" + e.getMessage());
            }
            String data = text.toString();
            String [] dataUser = data.split(";");

            if (dataUser[1].equals(Password.getEditText().getText().toString())){
                simpanFileLogin();
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }else {
                Toast.makeText(this, "Password Incorrect!", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, "Username not Found!", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Username = findViewById(R.id.textInputLayout);
        Password = findViewById(R.id.textInputLayout2);
        Button btn_login = findViewById(R.id.btn_login);
        Button btn_regist = findViewById(R.id.btn_regist);

        btn_login.setOnClickListener(view -> login());
        btn_regist.setOnClickListener(view -> {
            Intent intent = new Intent(this,RegisterActivity.class);
            startActivity(intent);
        });
    }
}