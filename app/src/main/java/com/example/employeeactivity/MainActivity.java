package com.example.employeeactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ed1,ed2,ed3,ed4,ed5;
    AppCompatButton b1;

    String getCode,getName,getMob,getEmail,getDes;
    DatabaseHelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1=(EditText) findViewById(R.id.code);
        ed2=(EditText) findViewById(R.id.Emname);
        ed3=(EditText) findViewById(R.id.Mob);
        ed4=(EditText) findViewById(R.id.email);
        ed5=(EditText) findViewById(R.id.des);
        b1=(AppCompatButton) findViewById(R.id.sub);

        dbhelper=new DatabaseHelper(this);
        dbhelper.getWritableDatabase();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getCode=ed1.getText().toString();
                getName=ed2.getText().toString();
                getMob=ed3.getText().toString();
                getEmail=ed4.getText().toString();
                getDes=ed5.getText().toString();


                boolean result=dbhelper.InsertData(getCode,getName,getMob,getEmail,getDes);

                if(result==true){
                    ed1.setText("");
                    ed2.setText("");
                    ed3.setText("");
                    ed4.setText("");
                    ed5.setText("");
                    Toast.makeText(getApplicationContext(), "Successfully Inserted", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_SHORT).show();
                }





            }
        });
    }
}