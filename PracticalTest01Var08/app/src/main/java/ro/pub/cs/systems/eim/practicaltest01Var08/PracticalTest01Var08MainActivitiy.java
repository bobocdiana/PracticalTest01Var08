package ro.pub.cs.systems.eim.practicaltest01Var08;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var08MainActivitiy extends AppCompatActivity {

    private EditText EditText1;
    private EditText EditText2;
    private EditText EditText3;
    private EditText EditText4;
    private Button setButton;

    private int serviceStatus = Constants.SERVICE_STOPPED;

    private IntentFilter intentFilter = new IntentFilter();
    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            //int leftNumberOfClicks = Integer.valueOf(leftEditText.getText().toString());
            //int rightNumberOfClicks = Integer.valueOf(rightEditText.getText().toString());

            switch(view.getId()) {
                case R.id.buttonSet:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var08SecondaryActivity.class);
                    String regexStr = "^[0-9]*$";

                    if( EditText1.getText().toString().trim().matches(regexStr) &&
                        EditText2.getText().toString().trim().matches(regexStr) &&
                            EditText3.getText().toString().trim().matches(regexStr) &&
                            EditText4.getText().toString().trim().matches(regexStr))
                    {
                        int firstNumber = Integer.parseInt(EditText1.getText().toString());
                        int secondNumber = Integer.parseInt(EditText2.getText().toString());
                        int thirdNumber = Integer.parseInt(EditText3.getText().toString());
                        int fourthNumber = Integer.parseInt(EditText4.getText().toString());

                        //Toast.makeText(getApplicationContext(), "1: " + firstNumber + "2:" + secondNumber + "3:" + thirdNumber + "4:" + fourthNumber, Toast.LENGTH_LONG).show();
                        System.out.println("1: " + firstNumber + "2:" + secondNumber + "3:" + thirdNumber + "4:" + fourthNumber);
                        intent.putExtra(Constants.UNU, firstNumber);
                        intent.putExtra(Constants.DOI, secondNumber);
                        intent.putExtra(Constants.TREI, thirdNumber);
                        intent.putExtra(Constants.PATRU, fourthNumber);
                        startActivityForResult(intent, Constants.SECONDARY_ACTIVITY_REQUEST_CODE);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Text given is not number", Toast.LENGTH_LONG).show();
                    }

                    break;
            }
            /*if (leftNumberOfClicks + rightNumberOfClicks > Constants.NUMBER_OF_CLICKS_THRESHOLD
                    && serviceStatus == Constants.SERVICE_STOPPED) {
                Intent intent = new Intent(getApplicationContext(), PracticalTest01Service.class);
                intent.putExtra(Constants.FIRST_NUMBER, leftNumberOfClicks);
                intent.putExtra(Constants.SECOND_NUMBER, rightNumberOfClicks);
                getApplicationContext().startService(intent);
                serviceStatus = Constants.SERVICE_STARTED;
            }*/
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var08_main);

        EditText1 = (EditText)findViewById(R.id.editText1);
        EditText2 = (EditText)findViewById(R.id.editText2);
        EditText3 = (EditText)findViewById(R.id.editText3);
        EditText4 = (EditText)findViewById(R.id.editText4);
        setButton = (Button)findViewById(R.id.buttonSet);
        setButton.setOnClickListener(buttonClickListener);


        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(Constants.UNU)) {
                EditText1.setText(savedInstanceState.getString(Constants.UNU));
            } else {
                EditText1.setText(String.valueOf(0));
            }
            if (savedInstanceState.containsKey(Constants.DOI)) {
                EditText2.setText(savedInstanceState.getString(Constants.DOI));
            } else {
                EditText2.setText(String.valueOf(0));
            }
            if (savedInstanceState.containsKey(Constants.TREI)) {
                EditText3.setText(savedInstanceState.getString(Constants.TREI));
            } else {
                EditText3.setText(String.valueOf(0));
            }
            if (savedInstanceState.containsKey(Constants.PATRU)) {
                EditText4.setText(savedInstanceState.getString(Constants.PATRU));
            } else {
                EditText4.setText(String.valueOf(0));
            }
        } else {
            EditText1.setText(String.valueOf(0));
            EditText2.setText(String.valueOf(0));
            EditText3.setText(String.valueOf(0));
            EditText4.setText(String.valueOf(0));
        }

        for (int index = 0; index < Constants.actionTypes.length; index++) {
            intentFilter.addAction(Constants.actionTypes[index]);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    //    registerReceiver(messageBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
     //   unregisterReceiver(messageBroadcastReceiver);
        super.onPause();
    }

    @Override
    protected void onDestroy() {
    //    Intent intent = new Intent(this, PracticalTest01Var08Service.class);
    //    stopService(intent);
        super.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString(Constants.UNU, EditText1.getText().toString());
        savedInstanceState.putString(Constants.DOI, EditText2.getText().toString());
        savedInstanceState.putString(Constants.TREI, EditText3.getText().toString());
        savedInstanceState.putString(Constants.PATRU, EditText4.getText().toString());
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey(Constants.UNU)) {
            EditText1.setText(savedInstanceState.getString(Constants.UNU));
        } else {
            EditText1.setText(String.valueOf(0));
        }
        if (savedInstanceState.containsKey(Constants.DOI)) {
            EditText2.setText(savedInstanceState.getString(Constants.DOI));
        } else {
            EditText2.setText(String.valueOf(0));
        }
        if (savedInstanceState.containsKey(Constants.TREI)) {
            EditText3.setText(savedInstanceState.getString(Constants.TREI));
        } else {
            EditText3.setText(String.valueOf(0));
        }
        if (savedInstanceState.containsKey(Constants.PATRU)) {
            EditText4.setText(savedInstanceState.getString(Constants.PATRU));
        } else {
            EditText4.setText(String.valueOf(0));
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == Constants.SECONDARY_ACTIVITY_REQUEST_CODE) {
            Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
        }
    }
}
