package com.raju.numberstofigure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText enteredNumberText;
    private EditText numberInWordsText;
    private Button findNumberInWordsBtn;

    private final String[] tensNames = {
            "",
            " ten",
            " twenty",
            " thirty",
            " forty",
            " fifty",
            " sixty",
            " seventy",
            " eighty",
            " ninety"
    };

    private final String[] numNames = {
            "",
            " one",
            " two",
            " three",
            " four",
            " five",
            " six",
            " seven",
            " eight",
            " nine",
            " ten",
            " eleven",
            " twelve",
            " thirteen",
            " fourteen",
            " fifteen",
            " sixteen",
            " seventeen",
            " eighteen",
            " nineteen"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enteredNumberText = findViewById(R.id.activity_main_entered_number);
        numberInWordsText = findViewById(R.id.activity_main_number_in_words);
        findNumberInWordsBtn = findViewById(R.id.activity_main_find_number_btn);

        findNumberInWordsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int enteredNumber = 0;
                try{
                    enteredNumber = Integer.parseInt(enteredNumberText.getText().toString());
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Not a valid number", Toast.LENGTH_SHORT).show();
                }
                if(enteredNumber >= 1000 || enteredNumber < 0){
                    Toast.makeText(getApplicationContext(), "Not a valid number", Toast.LENGTH_SHORT).show();
                }
                else{
                    numberInWordsText.setText(findNumberInWords(enteredNumber));
                }
            }
        });
    }

    private String findNumberInWords(Integer enteredNumber){
        String words;

        if (enteredNumber % 100 < 20){
            words = numNames[enteredNumber % 100];
            enteredNumber /= 100;
        }
        else {
            words = numNames[enteredNumber % 10];
            enteredNumber /= 10;

            words = tensNames[enteredNumber % 10] + words;
            enteredNumber /= 10;
        }
        if (enteredNumber == 0) return words;
        return numNames[enteredNumber] + " hundred" + words;
    }
}
