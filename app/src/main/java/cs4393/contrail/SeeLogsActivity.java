package cs4393.contrail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import cs4393.contrail.R;

public class SeeLogsActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText enterFlight;
    private LinearLayout logSection;
    private TextView logDate;
    private EditText logflightNumber, logPlaceFrom, logPlaceTo, logAircraftID, logAircraft, logFlight_Time, logRemarks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logs);

        enterFlight = findViewById(R.id.enter_flightNum);
        logSection = findViewById(R.id.log_section);

        buttonSetup();

        logSection.setVisibility(View.GONE); // Hide the log section until something is found
    }

    private void searchLog(String jump) {
        File path = getApplicationContext().getFilesDir();
        File readFrom = new File(path, "logs.csv");

        try {
            FileInputStream inputStream = new FileInputStream(readFrom);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            boolean logFound = false;

            while ((line = reader.readLine()) != null) {
                String[] logDetails = line.split(",");
                String logJump = logDetails[1].trim();
                if (logJump.equals(jump)) {
                    logSection.setVisibility(View.VISIBLE);
                    displayLog(logDetails);
                    logFound = true;
                    break;
                }
            }

            if (!logFound) {
                Toast.makeText(SeeLogsActivity.this, "No log found", Toast.LENGTH_SHORT).show();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayLog(String[] logDetails) {
        logDate = findViewById(R.id.log_date);
        logflightNumber = findViewById(R.id.log_flightNumber);
        logPlaceFrom = findViewById(R.id.log_placefrom);
        logPlaceTo = findViewById(R.id.log_placeto);
        logAircraft = findViewById(R.id.log_aircraft);
        logAircraftID = findViewById(R.id.log_aid);
        logFlight_Time = findViewById(R.id.log_flighttime);
        logRemarks = findViewById(R.id.log_remarks);

        logDate.setText("Date: " + logDetails[0]);
        logflightNumber.setText("Flight Number: " + logDetails[1]);
        logPlaceFrom.setText("Origin: " + logDetails[2]);

        // ✅ Corrected
        logPlaceTo.setText("Destination: " + logDetails[3]);              // destination
        logAircraft.setText("Aircraft Make and Model: " + logDetails[4]); // aircraft

        logAircraftID.setText("AID: " + logDetails[5]);
        logFlight_Time.setText("Flight Time: " + logDetails[6] + " hrs");
        logRemarks.setText("Remarks: " + logDetails[7]);
    }

    @Override
    public void onClick(View v) {
        Button click = (Button) v;

        if (click.getText().equals("Back")) {
            finish();
        } else if (click.getText().equals("Search")) {
            String jumpToSearch = enterFlight.getText().toString().trim();
            if (!jumpToSearch.isEmpty()) {
                searchLog(jumpToSearch);
            } else {
                Toast.makeText(SeeLogsActivity.this, "Please enter a Flight Number.", Toast.LENGTH_SHORT).show();
            }
        } else if (click.getText().equals("Add Flight")) {
            Intent intent = new Intent(SeeLogsActivity.this, LogDetailsActivity.class);
            startActivity(intent);
        }
    }

    public void buttonSetup() {
        Button searchButton = findViewById(R.id.btn_search_log);
        Button back = findViewById(R.id.back_to_main);
        searchButton.setOnClickListener(this);
        back.setOnClickListener(this);
    }
}
