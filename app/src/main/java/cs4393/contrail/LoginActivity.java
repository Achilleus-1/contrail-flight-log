package cs4393.contrail;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

/** Entry point for the local coursework demo; no account or credential storage. */
public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Remove legacy plaintext credentials when an older demo installation is upgraded.
        deleteFile("credentials.csv");
        setContentView(R.layout.activity_login);
        findViewById(R.id.loginButton).setOnClickListener(view ->
                startActivity(new Intent(this, MainActivity.class)));
        findViewById(R.id.aboutDemoButton).setOnClickListener(view ->
                startActivity(new Intent(this, ForgotPasswordActivity.class)));
    }
}
