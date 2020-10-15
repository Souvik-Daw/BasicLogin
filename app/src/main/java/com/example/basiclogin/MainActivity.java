package com.example.basiclogin;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText in_userName,in_password;
    Button btnLogin;
    String user,pwd;
    CentralStorage storage;
    static final String USERNAME="Ardent";
    static final String PASSWORD="pass00";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //code below
        storage=new CentralStorage(MainActivity.this);
        in_password=findViewById(R.id.inputPwd);
        in_userName=findViewById(R.id.inputName);
        btnLogin=findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = String.valueOf(in_userName.getText()).trim();
                pwd=String.valueOf(in_password.getText()).trim();

                if(user.isEmpty())
                {
                    in_userName.setError("Enter Valid Username");
                }
                else if (pwd.isEmpty())
                    in_password.setError("Enter Valid pwd");
                else if (user.equals(USERNAME) && pwd.equals(PASSWORD))
                {
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
                    storage.setData("USER",user);
                    Intent intent =new Intent(MainActivity.this,HomeActivity.class);//go to other page
                    startActivity(intent);
                    MainActivity.this.finish();//destroy this activity
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Invalid User", Toast.LENGTH_LONG).show();

                }

            }
        });
    }
}
