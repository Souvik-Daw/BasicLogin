package com.example.basiclogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ExtraActivity extends AppCompatActivity {

    private RadioGroup radioGender;
    private TextView txtView;
    private String selectedData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra);
        radioGender=findViewById(R.id.rGroup);
        txtView=findViewById(R.id.txtSelected);

        radioGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.rFemale)
                {
                    selectedData="Female";
                }
                else if(checkedId==R.id.rMale)
                {
                    selectedData="male";
                }
                else{
                    selectedData="Prefer not to specify";
                }
                txtView.setText("Gender-"+selectedData);
            }
        });
    }
}
