package com.example.dialogactivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class SimpleListActivity extends AppCompatActivity {

    Context context;
    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    String[] Items={"INIDA","PAKISTAN","CHINA","SRI LANKA","JAPAN","USA","UK"};

    TextView setData;
    ImageView close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list);
        listView=findViewById(R.id.MyList);
        arrayAdapter=new ArrayAdapter<>(this,R.layout.custom_text,R.id.MyText,Items);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                alertMethod(position);
            }
        });
    }

    private void alertMethod(int position) {
        AlertDialog.Builder builder=new AlertDialog.Builder(SimpleListActivity.this);
        View view=getLayoutInflater().inflate(R.layout.custom_alert,null);
        builder.setView(view);
        builder.setCancelable(false);

        setData=view.findViewById(R.id.setText);
        close=view.findViewById(R.id.close);

        AlertDialog alertDialog=builder.create();
        alertDialog.show();

        setData.setText("You've have selected "+Items[position]+" for Jobs");

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

    }
}