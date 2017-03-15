package com.xyz.activityswitcher;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends Activity {

    private Button btnSecondButton;
    private TextView lblDatafromfirstActivity;
    private EditText txtPassed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        lblDatafromfirstActivity = (TextView) findViewById(R.id.DatafromFirstActivity);
        txtPassed = (EditText) findViewById(R.id.editTextSecond);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            String thestring = extras.getString("data");

            if (thestring.isEmpty()){
                lblDatafromfirstActivity.setText("Nothing Provided");

            }

            else
            {
                lblDatafromfirstActivity.setText(thestring);
            }

        }
        btnSecondButton = (Button) findViewById(R.id.BTNFirstActivity);
        btnSecondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String passedString = txtPassed.getText().toString();
                Intent intent = new Intent(SecondActivity.this, FirstActivity.class);
                intent.putExtra("data", passedString);
                startActivity(intent);


            }
        });
    }
}
