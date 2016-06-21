package com.example.leon.creatplant;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class CreatPlant1 extends Activity {
    private Button CreatPlant1_next;
    private EditText CreatPlant1_name,CreatPlant1_birthday,CreatPlant1_note;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creatplant1);

        CreatPlant1_next = (Button) findViewById(R.id.CreatPlant1_next);
        CreatPlant1_name = (EditText) findViewById(R.id.CreatPlant1_name);
        CreatPlant1_birthday = (EditText) findViewById(R.id.CreatPlant1_birthday);
        CreatPlant1_note = (EditText) findViewById(R.id.CreatPlant1_note);

        CreatPlant1_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //  intent.putExtra("key",value);  傳資料到下一頁
                Intent intent = new Intent(CreatPlant1.this,CreatPlant2.class);
                intent.putExtra("1",CreatPlant1_name.getText().toString());
                intent.putExtra("2",CreatPlant1_birthday.getText().toString());
                intent.putExtra("3",CreatPlant1_note.getText().toString());

                startActivity(intent);
                finish();       //讓此頁死亡
                //startActivityForResult(intent,11);
            }
        });
    }

/*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(11, resultCode, data);
    }*/
}

