package cs4393.contrail;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import cs4393.contrail.R;

public class LogDetailsActivity extends AppCompatActivity {

    private TextView logDate;
    private EditText logFlightNumber, logPlaceFrom, logAircraft, logPlaceTo, logAID, logFlight_Time, logRemarks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_details);

        // Initialize the views
        logDate = findViewById(R.id.log_date);
        logFlightNumber = findViewById(R.id.log_flightNumber);
        logPlaceFrom = findViewById(R.id.log_placefrom);
        logPlaceTo = findViewById(R.id.log_placeto);
        logAircraft = findViewById(R.id.log_aircraft);
        logAID = findViewById(R.id.log_aid);
        logFlight_Time = findViewById(R.id.log_flighttime);
        logRemarks = findViewById(R.id.log_remarks);

        Button saveButton = findViewById(R.id.btn_save_log);
        Button cancelButton = findViewById(R.id.btn_cancel_log);

        saveButton.setOnClickListener(v -> saveLog());
        cancelButton.setOnClickListener(v -> finish());
    }

    private void saveLog() {
        String date = logDate.getText().toString().trim();
        String flightNumber = logFlightNumber.getText().toString().trim();
        String placeFrom = logPlaceFrom.getText().toString().trim();
        String placeTo = logPlaceTo.getText().toString().trim();
        String aircraft = logAircraft.getText().toString().trim();
        String AID = logAID.getText().toString().trim();
        String Flight_Time = logFlight_Time.getText().toString().trim();
        String Remarks = logRemarks.getText().toString().trim();

        // Check if all fields are filled
        if (!date.isEmpty() && !flightNumber.isEmpty() && !placeFrom.isEmpty() &&
                !placeTo.isEmpty() && !aircraft.isEmpty() && !AID.isEmpty() &&
                !Flight_Time.isEmpty() && !Remarks.isEmpty()) {

            File path = getApplicationContext().getFilesDir();
            try {
                // Writing the data to "logs.csv"
                FileOutputStream writer = new FileOutputStream(new File(path, "logs.csv"), true);

                // Write content in the correct order
                String content = date + "," + flightNumber + "," + placeFrom + "," + placeTo + "," +
                        aircraft + "," + AID + "," + Flight_Time + "," + Remarks + "\n";

                writer.write(content.getBytes());
                writer.close();
                // Flight record contents must not be written to diagnostic logs.
                finish(); // Close the activity
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(LogDetailsActivity.this, "Error saving log.", Toast.LENGTH_SHORT).show();
            }
        } else {
            // Show message if any field is empty
            Toast.makeText(LogDetailsActivity.this, "Please fill all fields.", Toast.LENGTH_SHORT).show();
        }
    }
}
