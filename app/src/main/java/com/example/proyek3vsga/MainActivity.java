package com.example.proyek3vsga;

import static com.example.proyek3vsga.LoginActivity.FILENAME;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText text1,text2,text3,text4,text5;

    void bacaFileLogin(){
        File file = new File(getFilesDir(), FILENAME);
        if(file.exists()) {
            StringBuilder text = new StringBuilder();
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = br.readLine();
                while (line != null) {
                    text.append(line);
                    line = br.readLine();
                }
                br.close();
            } catch (IOException e) {
                System.out.println("Error " + e.getMessage());
            }

            String data = text.toString();
            String[] dataUser = data.split(";");

            bacaDataUser(dataUser[0]);
        }
    }
    void bacaDataUser(String namaFile){
        File file = new File(getFilesDir(), namaFile);

        if(file.exists()){
            StringBuilder text = new StringBuilder();
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = br.readLine();
                while (line != null) {
                    text.append(line);
                    line = br.readLine();
                }
                br.close();
            } catch (IOException e) {
                System.out.println("Error " + e.getMessage());
            }

            String data = text.toString();
            String[] dataUser = data.split(";");

            text1.setText(dataUser[0]);
            text2.setText(dataUser[2]);
            text3.setText(dataUser[3]);
            text4.setText(dataUser[4]);
            text5.setText(dataUser[5]);
        }else{
            Toast.makeText(this, "User Not Found!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = findViewById(R.id.editTextTextPersonName);
        text2 = findViewById(R.id.editTextTextPersonName2);
        text3 = findViewById(R.id.editTextTextPersonName3);
        text4 = findViewById(R.id.editTextTextPersonName4);
        text5 = findViewById(R.id.editTextTextPersonName5);

        bacaFileLogin();
        }

}