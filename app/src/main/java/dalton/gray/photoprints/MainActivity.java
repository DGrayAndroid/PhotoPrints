package dalton.gray.photoprints;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double rate4x6 = .19;
    double rate5x7 = .49;
    double rate8x10 = .79;

    int numPrints;
    double totalCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final EditText txtNumPrints = (EditText) findViewById(R.id.txtPrintNum);
        final RadioButton rad4x6 = (RadioButton) findViewById(R.id.rad4x6);
        final RadioButton rad5x7 = (RadioButton) findViewById(R.id.rad5x7);
        final RadioButton rad8x10 = (RadioButton) findViewById(R.id.rad8x10);
        final TextView result = (TextView) findViewById(R.id.txtResult);

        Button btnOrder = (Button) findViewById(R.id.btnOrder);
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numPrints = Integer.parseInt(txtNumPrints.getText().toString());

                if(numPrints <= 50) {
                    if(rad4x6.isChecked()) {
                        totalCost = numPrints * rate4x6;
                    }

                    if(rad5x7.isChecked()) {
                        totalCost = numPrints * rate5x7;
                    }

                    if(rad8x10.isChecked()) {
                        totalCost = numPrints * rate8x10;
                    }

                    DecimalFormat currencyUSD = new DecimalFormat("$###,###.##");
                    result.setText("The order cost is " + currencyUSD.format(totalCost));
                } else {
                    Toast.makeText(MainActivity.this, "You cannot order more than 50 prints", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
