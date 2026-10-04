package cs4393.contrail;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

/** Demo information screen; retains the original activity name for compatibility. */
public class ForgotPasswordActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        findViewById(R.id.cancelButton).setOnClickListener(view -> finish());
    }
}
