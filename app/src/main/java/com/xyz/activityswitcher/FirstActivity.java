package com.xyz.activityswitcher;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FirstActivity extends Activity {

    private Button BTNFirstAcivity;
    private TextView lblDatafromSecondActivity;
    private EditText txtPassed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);


        lblDatafromSecondActivity = (TextView) findViewById(R.id.DatafromSecondActivity);
        txtPassed = (EditText) findViewById(R.id.editTextFirst);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            String thestring = extras.getString("data");

            if (thestring.isEmpty()){
                lblDatafromSecondActivity.setText("Nothing Provided");

            }

            else
            {
                lblDatafromSecondActivity.setText(thestring);
            }

        }
        BTNFirstAcivity = (Button) findViewById(R.id.BTNFirstActivity);
        BTNFirstAcivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String passedString = txtPassed.getText().toString();
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("data", passedString);
                startActivity(intent);


            }
        });
    }
}
