package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView language;
    SharedPreferences sharedPreferences;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()){
            case R.id.changeLanguage:
                langAlert();
                return true;
            case R.id.settings:
                return true;
            default:
                return false;

        }
    }




    public void langAlert(){

        final String lang = "Language in ";



        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_btn_speak_now)
                .setTitle("Change Language")
                .setMessage("Do you really wanna change the language???")
                .setPositiveButton("English", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        language.setText(lang + "English");
                        sharedPreferences.edit().putString("lang", lang + "English").apply();



                    }
                })
                .setNegativeButton("French", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        language.setText(lang + "French");
                        sharedPreferences.edit().putString("lang", lang + "French").apply();

                    }
                })
                .show();


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        language = findViewById(R.id.language);
        sharedPreferences = this.getSharedPreferences("com.example.myapplication", Context.MODE_PRIVATE);

        String langSet = sharedPreferences.getString("lang", "...");
        language.setText(langSet);







    }
}
