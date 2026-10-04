package cs4393.contrail;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent; // Import for Intent
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cs4393.contrail.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//a test
        // Home Buttons
        Button seeLogsButton = findViewById(R.id.btn_see_logs);
        seeLogsButton.setText("See Flight Logs");
        seeLogsButton.setOnClickListener(this);

        Button compareLogsButton = findViewById(R.id.btn_compare_logs);
        compareLogsButton.setText("Compare Flights");
        compareLogsButton.setOnClickListener(this);

        Button settingsButton = findViewById(R.id.btn_settings);
        settingsButton.setText("Settings");
        settingsButton.setOnClickListener(this);

        Button addFlight = findViewById(R.id.btn_add_flight);
        addFlight.setText("Add Flight");
        addFlight.setOnClickListener(this);

        Button logoutButton = findViewById(R.id.btn_logout);
        logoutButton.setText("Logout");
        logoutButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Button click = (Button) v;
        Intent intent;

        if (click.getText().equals("See Flight Logs")) {
            intent = new Intent(MainActivity.this, SeeLogsActivity.class);
            startActivity(intent);
        } else if (click.getText().equals("Compare Flights")) {
            intent = new Intent(MainActivity.this, LogCompareActivity.class);
            startActivity(intent);
        } else if (click.getText().equals("Settings")) {
            intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        }
        else if (click.getText().equals("Add Flight")) {
            intent = new Intent(MainActivity.this, LogDetailsActivity.class);
            startActivity(intent);
        }
        else if (click.getText().equals("Logout")) {
            intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
