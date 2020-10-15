package com.example.basiclogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplachActivity extends AppCompatActivity {

    CentralStorage storage;
    String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach);

        storage=new CentralStorage(SplachActivity.this);
        value=storage.getData("USER");

        new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        if(value.isEmpty())
                        {
                            //the code of login nav
                            startActivity(new Intent(SplachActivity.this,MainActivity.class));
                        }
                        else {
                            //code to already logged in user
                            startActivity(new Intent(SplachActivity.this,HomeActivity.class));
                        }
                        SplachActivity.this.finish();
                    }
                },
                5000
        );

    }
}
