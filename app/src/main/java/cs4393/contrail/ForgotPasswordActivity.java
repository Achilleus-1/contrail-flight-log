package cs4393.contrail;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ForgotPasswordActivity extends AppCompatActivity implements View.OnClickListener{
    EditText usernameToFind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        usernameToFind = findViewById(R.id.forgotPassInput);

        Button submitButton = findViewById(R.id.submitButton);
        submitButton.setText("Submit");
        submitButton.setOnClickListener(this);

        Button cancelButton = findViewById(R.id.cancelButton);
        cancelButton.setText("Cancel");
        cancelButton.setOnClickListener(v -> finish());
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        String user = usernameToFind.getText().toString().trim();

        if (user.isEmpty()) {
            Toast.makeText(ForgotPasswordActivity.this, "Please fill in username.", Toast.LENGTH_SHORT).show();
            //Log.d("LoginActivity", "*** WORKING IF FIELDS NOT FILLED IN FOR LOGIN ***");
        }
        else {
            File path = getApplicationContext().getFilesDir();
            File readFrom = new File(path, "credentials.csv");

            try {
                FileInputStream inputStream = new FileInputStream(readFrom);
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                boolean usernameFound = false;

                while ((line = reader.readLine()) != null) {
                    String[] creds = line.split(",");
                    String fileUsername = creds[0].trim();
                    String filePassword = creds[1].trim();

                    Log.d("LoginActivity", "*** USER: " + fileUsername + " PASS: " + filePassword + " ***");

                    // Check if entered credentials match the ones in the file
                    if (fileUsername.equals(user)) {
                        Toast.makeText(ForgotPasswordActivity.this, "Password is: " + filePassword, Toast.LENGTH_SHORT).show();
                        intent = new Intent(ForgotPasswordActivity.this, LoginActivity.class);
                        startActivity(intent);
                        usernameFound = true;
                        break;
                    }
                }

                if (!usernameFound) {
                    Toast.makeText(ForgotPasswordActivity.this, "Username not Found", Toast.LENGTH_SHORT).show();

                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
