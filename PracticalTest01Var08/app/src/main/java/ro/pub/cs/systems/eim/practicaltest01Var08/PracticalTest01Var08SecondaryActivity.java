package ro.pub.cs.systems.eim.practicaltest01Var08;

import android.widget.TextView;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by student on 04.04.2017.
 */

public class PracticalTest01Var08SecondaryActivity extends AppCompatActivity {

    private TextView EditText1;
    private TextView EditText2;
    private TextView EditText3;
    private TextView EditText4;
    private Button sumButton, productButton;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int firstNumber = Integer.parseInt(EditText1.getText().toString());
            int secondNumber = Integer.parseInt(EditText2.getText().toString());
            int thirdNumber = Integer.parseInt(EditText3.getText().toString());
            int fourthNumber = Integer.parseInt(EditText4.getText().toString());

            switch (view.getId()) {
                case R.id.sumButton:
                    int sum = firstNumber + secondNumber + thirdNumber + fourthNumber;
                    Toast.makeText(getApplicationContext(), "Sum is " + sum, Toast.LENGTH_LONG).show();
                    setResult(RESULT_OK, null);
                    break;
                case R.id.productButton:
                    int product = firstNumber * secondNumber *thirdNumber * fourthNumber;
                    Toast.makeText(getApplicationContext(), "Product is " + product, Toast.LENGTH_LONG).show();
                    setResult(RESULT_CANCELED, null);
                    break;
            }
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var08_second);

        EditText1 = (TextView)findViewById(R.id.editText1);
        EditText2 = (TextView)findViewById(R.id.editText2);
        EditText3 = (TextView)findViewById(R.id.editText3);
        EditText4 = (TextView)findViewById(R.id.editText4);
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.getExtras().containsKey(Constants.UNU)) {
                int firstnumber = intent.getIntExtra(Constants.UNU, -1);
                if (firstnumber == -1)
                    EditText1.setText(String.valueOf(0));
                else
                    EditText1.setText(String.valueOf(firstnumber));
            }
            if (intent.getExtras().containsKey(Constants.DOI)) {
                int secondnumber = intent.getIntExtra(Constants.DOI, -1);
                if (secondnumber == -1)
                    EditText2.setText(String.valueOf(0));
                else
                    EditText2.setText(String.valueOf(secondnumber));
            }
            if (intent.getExtras().containsKey(Constants.TREI)) {
                int thirdnumber = intent.getIntExtra(Constants.TREI, -1);
                if (thirdnumber == -1)
                    EditText3.setText(String.valueOf(0));
                else
                    EditText3.setText(String.valueOf(thirdnumber));
            }
            if (intent.getExtras().containsKey(Constants.PATRU)) {
                int fourthnumber = intent.getIntExtra(Constants.PATRU, -1);
                if (fourthnumber == -1)
                    EditText4.setText(String.valueOf(0));
                else
                    EditText4.setText(String.valueOf(fourthnumber));
            }
        }

        sumButton = (Button)findViewById(R.id.sumButton);
        sumButton.setOnClickListener(buttonClickListener);
        productButton = (Button)findViewById(R.id.productButton);
        productButton.setOnClickListener(buttonClickListener);
    }
}