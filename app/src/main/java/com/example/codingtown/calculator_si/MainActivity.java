package com.example.codingtown.calculator_si;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button clear_bt,year_bt,month_bt,day_bt;
    EditText at, interst, yrm;
    TextView total,chgtext;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        at = (EditText) findViewById(R.id.tv1);
        interst = (EditText) findViewById(R.id.tv2);
        yrm = (EditText) findViewById(R.id.tv3);
        total = (TextView) findViewById(R.id.view1);

        clear_bt = (Button) findViewById(R.id.clr);
        month_bt = (Button) findViewById(R.id.m);
        year_bt = (Button) findViewById(R.id.y);
        day_bt=(Button)findViewById(R.id.day);



        chgtext = (TextView) findViewById(R.id.chgview);



        day_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                double amt = Double.parseDouble(at.getText().toString());
                double intrate = Double.parseDouble(interst.getText().toString());
                int yrmonth = 365;
                double one_ans = (double) (intrate/100);
                double ymd = Double.parseDouble(yrm.getText().toString());
                double ymd1=(ymd/yrmonth);

                double day_ans = amt * one_ans * ymd1;
                chgtext.setText("DAY INTEREST AMOUNT IS...");


                total.setText("Rs."+new DecimalFormat("##.##########").format(day_ans));

            }
        });


        month_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double amt = Double.parseDouble(at.getText().toString());
                double intrate = Double.parseDouble(interst.getText().toString());
                int yrmonth = 12;
                double one_ans = (double) (intrate / 100) / yrmonth;
                double yrandmnth = Double.parseDouble(yrm.getText().toString());

                double month_ans = amt * one_ans * yrandmnth;
                chgtext.setText("MONTH INTEREST AMOUNT IS...");


                total.setText("Rs."+new DecimalFormat("##.##########").format(month_ans));


            }
        });


        year_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double amt = Double.parseDouble(at.getText().toString());
                double intrate = Double.parseDouble(interst.getText().toString());

                double one_ans = (double) (intrate / 100);
                double yrandmnth = Double.parseDouble(yrm.getText().toString());

                double month_ans = amt * one_ans * yrandmnth;
                chgtext.setText("YEAR INTEREST AMOUNT IS...");
                total.setText("Rs."+new DecimalFormat("##.##########").format(month_ans));
            }
        });


        clear_bt.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                at.setText("");
                yrm.setText("");
                chgtext.setText("");
                interst.setText("");
                total.setText("");
            }
        });

    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?").setCancelable(false).setPositiveButton
                ("Yes", new DialogInterface.OnClickListener()


                {
                    public void onClick(DialogInterface dialog, int id)
                    {
                        MainActivity.this.finish();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();

    }
}
