package edu.ags.timedifference;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public static final String TAG = "myDebug";
    EditText etInput;
    EditText etInput2;
    TextView tvOutput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: Finished");

        //Instantiate the button from the XML
        Button btnDisplay = findViewById(R.id.btnDisplay);
        //Instantiate the edittext from the XML
        etInput = findViewById(R.id.etInput);
        etInput2 = findViewById(R.id.etInput2);
        //Instantiate the textview from the XML
        tvOutput = findViewById(R.id.tvOutput);



        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //assignment reference
                String startTime = "2:00:00";
                String[] parts = startTime.split(":");

                int hr = Integer.parseInt(parts[0]);
                int min = Integer.parseInt(parts[1]);
                int sec = Integer.parseInt(parts[2]);

                int startSeconds = hr * 3600 + min * 60 + sec;

                String endTime = etInput2.getText().toString();
                String[] parts2 = endTime.split(":");

                int hr2 = Integer.parseInt(parts2[0]);
                int min2 = Integer.parseInt(parts2[1]);
                int sec2 = Integer.parseInt(parts2[2]);

                int endSeconds = hr2 * 3600 + min2 * 60 + sec2;

                Log.d(TAG, "onCreate: " + startSeconds);

                int secondsDif = startSeconds - endSeconds;

                // Display the text in the textview
                //String message = etInput.getText().toString();
                String message = "" + secondsDif ;
                tvOutput.setText(message);

                Log.d(TAG, "onClick: " + message);
                showMessage(message);
            }
        });
    }

    //returns a string
    private void showMessage(String msg)
    {
        //Show a messagebox
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
    }
}