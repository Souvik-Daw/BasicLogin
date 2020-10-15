package com.example.basiclogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class HomeActivity extends AppCompatActivity {

    private Spinner spin1;
    private TextView txData;
    private ArrayAdapter adapter;

    private String []data={"wwdww","wcwdcw","wdcwdcwc","wdwdwdcw"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        spin1=findViewById(R.id.spinner1);
        txData=findViewById(R.id.txtSpValue);
        adapter=new ArrayAdapter(HomeActivity.this,R.layout.support_simple_spinner_dropdown_item,data);
        spin1.setAdapter(adapter);

        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position>0)
                txData.setText("item selected is"+spin1.getSelectedItem());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
    //add menu in action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    //to perform action against menu item

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.logout:
                    showLogOutDialog();
                break;
            case R.id.extra:
                    startActivity(new Intent(HomeActivity.this,ExtraActivity.class));
                break;
            case R.id.feedback:
                    getfeedback();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void getfeedback() {
        final Dialog dialog=new Dialog(HomeActivity.this);
        View fView= LayoutInflater.from(HomeActivity.this).inflate(R.layout.feedback,null);
        dialog.setContentView(fView);
        final RatingBar rBar=fView.findViewById(R.id.ratingPoint);
        Button btn=fView.findViewById(R.id.btnRating);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float rating=rBar.getRating();
                dialog.dismiss();
                Toast.makeText(HomeActivity.this, "Your feedback", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
        dialog.setCancelable(false);

    }

    private void showLogOutDialog()//alert to log out
    {
        AlertDialog.Builder alertBuilder =new AlertDialog.Builder(HomeActivity.this);
        alertBuilder.create();
        alertBuilder.setMessage("Are you sure to exit");
        alertBuilder.setCancelable(false);//auto cancel
        alertBuilder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new CentralStorage(HomeActivity.this)
                        .clearData();
                Toast.makeText(HomeActivity.this, "Logged Out", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(HomeActivity.this,MainActivity.class));
                HomeActivity.this.finish();
            }
        });
        alertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(HomeActivity.this, "Operation canceled", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        alertBuilder.show();
    }
}
