package cs4393.contrail;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;
import cs4393.contrail.model.Compare;
import cs4393.contrail.R;

public class LogCompareActivity extends AppCompatActivity implements View.OnClickListener {

    Compare c;
    TextInputEditText op1;
    TextInputEditText op2;

    EditText date1, date2;
    EditText location1, location2;
    EditText destination1, destination2;
    EditText aircraft1, aircraft2;
    EditText aid1, aid2;
    EditText flightTime1, flightTime2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_compare);

        c = new Compare();

        buttons();
        prepInput();
        prepText();
    }

    @Override
    public void onClick(View v) {
        Button click = (Button) v;
        int num1 = Integer.MAX_VALUE;
        int num2 = Integer.MAX_VALUE;

        if (click.getText().equals("Back")) {
            finish();
        } else if (click.getText().equals("Compare")) {
            String input1 = op1.getText().toString();
            String input2 = op2.getText().toString();

            try {
                num1 = Integer.parseInt(input1);
                num2 = Integer.parseInt(input2);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Please enter two integer values", Toast.LENGTH_LONG).show();
                return;
            }

            if (c.findJumps(this, num1, num2)) {
                date1.setText(c.getDate1());
                date2.setText(c.getDate2());

                location1.setText(c.getOrigin1());
                location2.setText(c.getOrigin2());

                destination1.setText(c.getTo1());
                destination2.setText(c.getTo2());

                aircraft1.setText(c.getAc1());
                aircraft2.setText(c.getAc2());

                aid1.setText(c.getAid1());
                aid2.setText(c.getAid2());

                flightTime1.setText(c.getFlightTime1());
                flightTime2.setText(c.getFlightTime2());
            } else {
                Toast.makeText(this, "Flight not found, re-enter values and try again", Toast.LENGTH_LONG).show();
            }
        }
    }


    private void buttons() {
        Button back = findViewById(R.id.goBack);
        back.setText("Back");
        back.setOnClickListener(this);

        Button confirm = findViewById(R.id.compareConfirm);
        confirm.setText("Compare");
        confirm.setOnClickListener(this);
    }

    private void prepInput() {
        op1 = findViewById(R.id.compInput1);
        op2 = findViewById(R.id.compInput2);

        op1.setHint("Flight 1");
        op2.setHint("Flight 2");
    }

    private void prepText() {
        date1 = findViewById(R.id.date1);
        date2 = findViewById(R.id.date2);

        location1 = findViewById(R.id.location1);
        location2 = findViewById(R.id.location2);

        destination1 = findViewById(R.id.destination1);
        destination2 = findViewById(R.id.destination2);

        aircraft1 = findViewById(R.id.aircraft1);
        aircraft2 = findViewById(R.id.aircraft2);

        aid1 = findViewById(R.id.aid1);
        aid2 = findViewById(R.id.aid2);

        flightTime1 = findViewById(R.id.flighttime1);
        flightTime2 = findViewById(R.id.flighttime2);
    }
}
