package com.example.dialogactivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class DialogActivity extends AppCompatActivity {

    ImageView close;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }

    public void normal(View view) {
        AlertDialog.Builder alert=new AlertDialog.Builder(DialogActivity.this);
        alert.setTitle("Normal Dailog");
        alert.setMessage("This is Normal Alert Dailog test");
        alert.setIcon(R.drawable.ic_baseline_access_time_24);
        alert.setCancelable(false);

        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

                finish();

            }
        });

        alert.setNegativeButton("CANECL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        alert.setNeutralButton("More", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

            }
        });

        AlertDialog alertDialog=alert.create();
        alertDialog.show();
    }

    public void custom(View view) {

        AlertDialog.Builder alert=new AlertDialog.Builder(DialogActivity.this);

        View customview=getLayoutInflater().inflate(R.layout.custom_alert,null);
        alert.setView(customview);
        alert.setCancelable(false);
        close=customview.findViewById(R.id.close);

        AlertDialog alertDialog=alert.create();
        alertDialog.show();
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

    }
}