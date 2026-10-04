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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setText("Login");
        loginButton.setOnClickListener(view -> checkLogin());

        Button createAccountButton = findViewById(R.id.createAccountButton);
        createAccountButton.setText("Create Account");
        createAccountButton.setOnClickListener(view -> createAccount());

        TextView forgotPasswordButton = findViewById(R.id.forgotPassword);
        forgotPasswordButton.setText("Forgot Password");
        forgotPasswordButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;

        intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
        startActivity(intent);
    }

    // check if login credentials are valid
    public void checkLogin() {
        Intent intent;

        String user = username.getText().toString().trim();
        String pass = password.getText().toString().trim();

        if (user.isEmpty() || pass.isEmpty()) {
            Toast.makeText(LoginActivity.this, "Please fill in all fields.", Toast.LENGTH_SHORT).show();
            //Log.d("LoginActivity", "*** WORKING IF FIELDS NOT FILLED IN FOR LOGIN ***");
        }
        else {
            File path = getApplicationContext().getFilesDir();
            File readFrom = new File(path, "credentials.csv");

            try {
                FileInputStream inputStream = new FileInputStream(readFrom);
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                boolean credsFound = false;

                while ((line = reader.readLine()) != null) {
                    String[] creds = line.split(",");
                    String fileUsername = creds[0].trim();
                    String filePassword = creds[1].trim();

                    Log.d("LoginActivity", "*** USER: " + fileUsername + " PASS: " + filePassword + " ***");

                    // Check if entered credentials match the ones in the file
                    if (fileUsername.equals(user) && filePassword.equals(pass)) {
                        intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        credsFound = true;
                        break;
                    }
                }

                if (!credsFound) {
                    Toast.makeText(LoginActivity.this, "Username or Password not found.", Toast.LENGTH_SHORT).show();

                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // creates an account with user input
    public void createAccount() {
        Intent intent;

        String user = username.getText().toString().trim();
        String pass = password.getText().toString().trim();

        if (user.isEmpty() || pass.isEmpty()) {
            Toast.makeText(LoginActivity.this, "Please fill in all fields.", Toast.LENGTH_SHORT).show();
        } else {
            File path = getApplicationContext().getFilesDir();
            File credentialsFile = new File(path, "credentials.csv");

            try {
                // Writing the data to "credentials.csv"
                FileWriter writer = new FileWriter(credentialsFile, true);
                writer.append(user).append(",").append(pass).append("\n");
                writer.close();

                //sends user to MainActivity
                Toast.makeText(LoginActivity.this, "Account successfully created", Toast.LENGTH_SHORT).show();
                intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(LoginActivity.this, "Error creating account.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
