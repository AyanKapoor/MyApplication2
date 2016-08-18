package com.example.ayankapoor.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;



public class HelloAndroid extends AppCompatActivity {


    Button button_yes;
    Button button_no;
    Button button_next;
    TextView text_number;
    TextView textView_score;
    int score = 0;int number;
    static final String STATE_SCORE = "playerScore";
    static final String STATE_LEVEL = "playerLevel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            // Restore value of members from saved state
            score = savedInstanceState.getInt(STATE_SCORE);
            number = savedInstanceState.getInt(STATE_LEVEL);
        }

        setContentView(R.layout.activity_hello_android);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        button_yes = (Button)findViewById(R.id.button_yes);
        button_no = (Button)findViewById(R.id.button_no);
        button_next =(Button)findViewById(R.id.button_next);
        text_number = (TextView) findViewById((R.id.text_number));
        textView_score =(TextView)findViewById((R.id.textView_score));


        int number = getRandomNumberInRange(2,1000);
        text_number.setText(Integer.toString(number));
        textView_score.setText(Integer.toString(score));



        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int number = getRandomNumberInRange(2,1000);
                text_number.setText(Integer.toString(number));

            }
        });
        button_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message;


                String num2 = text_number.getText().toString();
                int num3 = Integer.parseInt(num2);
                if(isPrimeNumber(num3)==1)
                {
                    message = "Wrong Answer";
                    score--;
                }
                else
                {
                    score++;
                    message = "Right Answer";
                }


                Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
                int number = getRandomNumberInRange(2,1000);
                text_number.setText(Integer.toString(number));
                textView_score.setText(Integer.toString(score));

            }
        });
        button_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message;


                String num2 = text_number.getText().toString();
                int num3 = Integer.parseInt(num2);
                if(isPrimeNumber(num3)==1)
                {
                    score++;
                    message = "Right Answer";
                }
                else
                {
                    message = "Wrong Answer";
                    score--;
                }


                Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
                int number = getRandomNumberInRange(2,1000);
                text_number.setText(Integer.toString(number));
                textView_score.setText(Integer.toString(score));
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putInt(STATE_SCORE, score);
        savedInstanceState.putInt(STATE_LEVEL, number);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);

        // Restore state members from saved instance
        score = savedInstanceState.getInt(STATE_SCORE);
        number = savedInstanceState.getInt(STATE_LEVEL);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hello_android, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static int isPrimeNumber(int num){ //method signature. returns Boolean, true if number isPrime, false if not
        if(num==2){ //for case num=2, function returns true. detailed explanation underneath
            return 1;
        }
        for(int i=2;i<=(int)Math.sqrt(num)+1;i++){ //loops through 2 to sqrt(num). All you need to check- efficient
            if(num%i==0){ //if a divisor is found, its not prime. returns false
                return 0;
            }
        }
        return 1; //if all cases don't divide num, it is prime.
    }


    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
