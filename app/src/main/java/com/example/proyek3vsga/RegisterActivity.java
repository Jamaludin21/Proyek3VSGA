package com.example.proyek3vsga;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;


import com.google.android.material.textfield.TextInputLayout;

import java.io.File;
import java.io.FileOutputStream;


public class RegisterActivity extends AppCompatActivity {
    TextInputLayout Username,Password,Email,Nama_Lengkap,Asal_Sekolah,Alamat;

    public boolean isValidation(){
        if (Username.getEditText().getText().toString().equals("") ||
                Password.getEditText().getText().toString().equals("") ||
                Email.getEditText().getText().toString().equals("") ||
                Nama_Lengkap.getEditText().getText().toString().equals("") ||
                Asal_Sekolah.getEditText().getText().toString().equals("") ||
                Alamat.getEditText().getText().toString().equals("")) {
            return false;
        }else {
            return true;
        }
    }

    void simpanFileData(){
        String isiFile = Username.getEditText().getText().toString() + ";" +
                Password.getEditText().getText().toString() + ";" +
                Email.getEditText().getText().toString() + ";" +
                Nama_Lengkap.getEditText().getText().toString() + ";" +
                Asal_Sekolah.getEditText().getText().toString() + ";" +
                Alamat.getEditText().getText().toString();

        File file = new File(getFilesDir(), Username.getEditText().getText().toString());
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
        Toast.makeText(this, "Register Success!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onNavigateUp() {
        onBackPressed();
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

         Username = findViewById(R.id.textInputLayout);
         Password = findViewById(R.id.textInputLayout2);
         Email = findViewById(R.id.textInputLayout3);
         Nama_Lengkap = findViewById(R.id.textInputLayout4);
         Asal_Sekolah = findViewById(R.id.textInputLayout5);
         Alamat = findViewById(R.id.textInputLayout6);

        Button btn_register = findViewById(R.id.btn_register);

        btn_register.setOnClickListener(view -> {
            if (isValidation()){
                simpanFileData();
            }else {
                Toast.makeText(this, "Please Fulfill All Data!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}