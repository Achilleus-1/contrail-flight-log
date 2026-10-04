package cs4393.contrail;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_main);

        // Back button
        findViewById(R.id.back_button).setOnClickListener(v -> finish());

        // Clear Logs button
        Button clearLogsButton = findViewById(R.id.clear_logs_button);
        clearLogsButton.setOnClickListener(v -> {
            File file = new File(getFilesDir(), "logs.csv");
            if (file.exists()) {
                try {
                    FileOutputStream fos = new FileOutputStream(file, false);
                    fos.write("".getBytes()); // Overwrite with empty content
                    fos.close();
                    Toast.makeText(this, "Logs cleared", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(this, "Error clearing logs", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "No logs file found", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
