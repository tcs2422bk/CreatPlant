package com.example.leon.creatplant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Leon on 2016/6/19.
 */
public class CreatPlant2 extends Activity{
    private Button CreatPlant2_edit,CreatPlant2_save;
    private TextView CreatPlant2_name,CreatPlant2_birthday,CreatPlant2_note;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creatplant2);

        CreatPlant2_name = (TextView) findViewById(R.id.CreatPlant2_name);
        CreatPlant2_birthday = (TextView) findViewById(R.id.CreatPlant2_birthday);
        CreatPlant2_note = (TextView) findViewById(R.id.CreatPlant2_note);

        //  接收intent資料,依照key值取那筆資料
        Intent it = getIntent();
        CreatPlant2_name.setText(it.getStringExtra("1"));
        CreatPlant2_birthday.setText(it.getStringExtra("2"));
        CreatPlant2_note.setText(it.getStringExtra("3"));



        CreatPlant2_edit = (Button) findViewById(R.id.CreatPlant2_edit);
        CreatPlant2_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreatPlant2.this,CreatPlant1.class);
                startActivity(intent);
            }
        });


        CreatPlant2_save = (Button) findViewById(R.id.CreatPlant2_save);

        CreatPlant2_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //以下為ＰＨＰ傳值
                new Thread(){
                    @Override
                    public void run() {
                        doSend();
                    }
                }.start();
            }
        });


    }
    private void doSend(){
        //  getIntent();接收上一頁資料
        Intent it = getIntent();

        //  mu.addFormField("要和ＰＨＰの值一樣",要傳ㄉ值);
        try {
            MultipartUtility mu = new MultipartUtility("http://10.2.12.104/send02.php","UTF-8");
            mu.addFormField("accou",it.getStringExtra("1"));
            mu.addFormField("passwo",it.getStringExtra("2"));
            mu.addFormField("passwor",it.getStringExtra("3"));
            List<String> ret = mu.finish();

            for(String line : ret){

                Log.i("Jack",line);
            }
        } catch (Exception e) {
            Log.i("Jack",e.toString());
        }

    }
}
