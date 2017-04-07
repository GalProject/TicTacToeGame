package com.example.myfirstapp.tictacgame;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.id.message;

public class MainActivity extends Activity {

    int currentState =1;
    int clicksCounter =0;
    Integer[] btnArray = new Integer[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button Btn0 = (Button) findViewById(R.id.main_button0);
        final Button Btn1 = (Button) findViewById(R.id.main_button1);
        final Button Btn2 = (Button) findViewById(R.id.main_button2);
        final Button Btn3 = (Button) findViewById(R.id.main_button3);
        final Button Btn4 = (Button) findViewById(R.id.main_button4);
        final Button Btn5 = (Button) findViewById(R.id.main_button5);
        final Button Btn6 = (Button) findViewById(R.id.main_button6);
        final Button Btn7 = (Button) findViewById(R.id.main_button7);
        final Button Btn8 = (Button) findViewById(R.id.main_button8);
        final Button BtnRestart = (Button) findViewById(R.id.main_restart);
        final TextView curPlayer = (TextView) findViewById(R.id.main_whoIsPlayingText);

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Restart");
        alertDialogBuilder.setMessage("Are you sure to restart the game?");

        //init Array button with NULL
        for(int i=0 ;i<btnArray.length;i++)
            btnArray[i] = 0;


        BtnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("BTN", "The user clicked on Restart Button");
                alertDialogBuilder.create();

                alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        Log.d("BTN","User clicked on ok restart button");
                        restartTheGame();
                        Toast.makeText(MainActivity.this,"Game Restarted!",Toast.LENGTH_SHORT).show();
                    }
                });

                alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"Keep Playing!",Toast.LENGTH_SHORT).show();
                        Log.d("BTN","User clicked on No restart button");
                    }
                });

                alertDialogBuilder.show();
            }
        });


        Btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getCurrentState() == 1){
                    btnArray[0] = 1;
                    Log.d("BTN","thex");
                    v.setBackgroundResource(R.drawable.thex);
                    setCurrentState(0);
                    if(clicksCounter != 8)
                        curPlayer.setText("Player Y - its your turn!");
                    else
                        curPlayer.setText("Game Over!");
                }
                else if (getCurrentState() == 0){
                    btnArray[0] = 2;
                    Log.d("BTN","O");
                    v.setBackgroundResource(R.drawable.circle);
                    setCurrentState(1);
                    if (clicksCounter != 8)
                    curPlayer.setText("Player X - its your turn!");
                    else
                        curPlayer.setText("Game Over!");
                }
                Log.d("BTN","The user clicked on Btn 0");
                v.setClickable(false);
                clicksCounter++;
                if(checkForTheWinner(v)){
                    curPlayer.setText("Winner!");
                    Btn0.setClickable(false);
                    Btn1.setClickable(false);
                    Btn2.setClickable(false);
                    Btn3.setClickable(false);
                    Btn4.setClickable(false);
                    Btn5.setClickable(false);
                    Btn6.setClickable(false);
                    Btn7.setClickable(false);
                    Btn8.setClickable(false);
                }

            }
        });

        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getCurrentState() == 1){
                    btnArray[1] = 1;
                    Log.d("BTN","thex");
                    setCurrentState(0);
                    v.setBackgroundResource(R.drawable.thex);
                    if(clicksCounter != 8)
                        curPlayer.setText("Player Y - its your turn!");
                    else
                        curPlayer.setText("Game Over!");
                }
                else if (getCurrentState() == 0){
                    btnArray[1] = 2;
                    Log.d("BTN","O");
                    v.setBackgroundResource(R.drawable.circle);
                    setCurrentState(1);
                    if(clicksCounter !=8)
                        curPlayer.setText("Player X - its your turn!");
                    else
                        curPlayer.setText("Game Over!");
                }
                v.setClickable(false);
                Log.d("BTN","The user clicked on Btn 1");
                clicksCounter++;
                if(checkForTheWinner(v)){
                    curPlayer.setText("Winner!");
                    Btn0.setClickable(false);
                    Btn1.setClickable(false);
                    Btn2.setClickable(false);
                    Btn3.setClickable(false);
                    Btn4.setClickable(false);
                    Btn5.setClickable(false);
                    Btn6.setClickable(false);
                    Btn7.setClickable(false);
                    Btn8.setClickable(false);
                }
            }
        });

        Btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getCurrentState() == 1){
                    btnArray[2] = 1;
                    Log.d("BTN","thex");
                    v.setBackgroundResource(R.drawable.thex);
                    setCurrentState(0);
                    if(clicksCounter !=8)
                        curPlayer.setText("Player Y - its your turn!");
                    else
                        curPlayer.setText("Game Over!");
                }
                else if (getCurrentState() == 0){
                    btnArray[2] = 2;
                    Log.d("BTN","O");
                    v.setBackgroundResource(R.drawable.circle);
                    setCurrentState(1);
                    if(clicksCounter != 8)
                        curPlayer.setText("Player X - its your turn!");
                    else
                        curPlayer.setText("Game Over!");
                }
                v.setClickable(false);
                Log.d("BTN","The user clicked on Btn 2");
                clicksCounter++;
                if(checkForTheWinner(v)){
                    curPlayer.setText("Winner!");
                    Btn0.setClickable(false);
                    Btn1.setClickable(false);
                    Btn2.setClickable(false);
                    Btn3.setClickable(false);
                    Btn4.setClickable(false);
                    Btn5.setClickable(false);
                    Btn6.setClickable(false);
                    Btn7.setClickable(false);
                    Btn8.setClickable(false);
                }
            }
        });

        Btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getCurrentState() == 1){
                    btnArray[3] = 1;
                    Log.d("BTN","thex");
                    v.setBackgroundResource(R.drawable.thex);
                    setCurrentState(0);
                    if(clicksCounter !=89)
                        curPlayer.setText("Player Y - its your turn!");
                    else
                        curPlayer.setText("Game Over!");
                }
                else if (getCurrentState() == 0){
                    btnArray[3] = 2;
                    Log.d("BTN","O");
                    v.setBackgroundResource(R.drawable.circle);
                    setCurrentState(1);
                    if(clicksCounter != 8)
                        curPlayer.setText("Player X - its your turn!");
                    else
                        curPlayer.setText("Game Over!");
                }
                v.setClickable(false);
                Log.d("BTN","The user clicked on Btn 3");
                clicksCounter++;
                if(checkForTheWinner(v)){
                    curPlayer.setText("Winner!");
                    Btn0.setClickable(false);
                    Btn1.setClickable(false);
                    Btn2.setClickable(false);
                    Btn3.setClickable(false);
                    Btn4.setClickable(false);
                    Btn5.setClickable(false);
                    Btn6.setClickable(false);
                    Btn7.setClickable(false);
                    Btn8.setClickable(false);
                }
            }
        });

        Btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getCurrentState() == 1){
                    btnArray[4] = 1;
                    Log.d("BTN","thex");
                    v.setBackgroundResource(R.drawable.thex);
                    setCurrentState(0);
                    if(clicksCounter != 8)
                        curPlayer.setText("Player Y - its your turn!");
                    else
                        curPlayer.setText("Game Over!");
                }
                else if (getCurrentState() == 0){
                    btnArray[4] = 2;
                    Log.d("BTN","O");
                    v.setBackgroundResource(R.drawable.circle);
                    setCurrentState(1);
                    if(clicksCounter != 8)
                        curPlayer.setText("Player X - its your turn!");
                    else
                        curPlayer.setText("Game Over!");
            }
                v.setClickable(false);
                Log.d("BTN","The user clicked on Btn 4");
                clicksCounter++;
                if(checkForTheWinner(v)){
                    curPlayer.setText("Winner!");
                    Btn0.setClickable(false);
                    Btn1.setClickable(false);
                    Btn2.setClickable(false);
                    Btn3.setClickable(false);
                    Btn4.setClickable(false);
                    Btn5.setClickable(false);
                    Btn6.setClickable(false);
                    Btn7.setClickable(false);
                    Btn8.setClickable(false);
                }
            }
        });

        Btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getCurrentState() == 1){
                    btnArray[5] = 1;
                    Log.d("BTN","thex");
                    v.setBackgroundResource(R.drawable.thex);
                    setCurrentState(0);
                    if(clicksCounter != 8)
                        curPlayer.setText("Player Y - its your turn!");
                    else
                        curPlayer.setText("Game Over!");
                }
                else if (getCurrentState() == 0){
                    btnArray[5] = 2;
                    Log.d("BTN","O");
                    v.setBackgroundResource(R.drawable.circle);
                    setCurrentState(1);
                    if(clicksCounter != 8)
                        curPlayer.setText("Player X - its your turn!");
                    else
                        curPlayer.setText("Game Over!");
                }
                v.setClickable(false);
                Log.d("BTN","The user clicked on Btn 5");
                clicksCounter++;
                if(checkForTheWinner(v)){
                    curPlayer.setText("Winner!");
                    Btn0.setClickable(false);
                    Btn1.setClickable(false);
                    Btn2.setClickable(false);
                    Btn3.setClickable(false);
                    Btn4.setClickable(false);
                    Btn5.setClickable(false);
                    Btn6.setClickable(false);
                    Btn7.setClickable(false);
                    Btn8.setClickable(false);
                }
            }
        });

        Btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getCurrentState() == 1){
                    btnArray[6] = 1;
                    Log.d("BTN","thex");
                    v.setBackgroundResource(R.drawable.thex);
                    setCurrentState(0);
                    if(clicksCounter != 8)
                        curPlayer.setText("Player Y - its your turn!");
                    else
                        curPlayer.setText("Game Over!");
                }
                else if (getCurrentState() == 0){
                    btnArray[6] = 2;
                    Log.d("BTN","O");
                    v.setBackgroundResource(R.drawable.circle);
                    setCurrentState(1);
                    if(clicksCounter != 8)
                        curPlayer.setText("Player X - its your turn!");
                    else
                        curPlayer.setText("Game Over!");
                }
                v.setClickable(false);
                Log.d("BTN","The user clicked on Btn 6");
                clicksCounter++;
                if(checkForTheWinner(v)){
                    curPlayer.setText("Winner!");
                    Btn0.setClickable(false);
                    Btn1.setClickable(false);
                    Btn2.setClickable(false);
                    Btn3.setClickable(false);
                    Btn4.setClickable(false);
                    Btn5.setClickable(false);
                    Btn6.setClickable(false);
                    Btn7.setClickable(false);
                    Btn8.setClickable(false);
                }
            }
        });

        Btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getCurrentState() == 1){
                    btnArray[7] = 1;
                    Log.d("BTN","thex");
                    v.setBackgroundResource(R.drawable.thex);
                    setCurrentState(0);
                    if(clicksCounter != 8)
                        curPlayer.setText("Player Y - its your turn!");
                    else
                        curPlayer.setText("Game Over!");
                }
                else if (getCurrentState() == 0){
                    btnArray[7] = 2;
                    Log.d("BTN","O");
                    v.setBackgroundResource(R.drawable.circle);
                    setCurrentState(1);
                    if(clicksCounter != 8)
                        curPlayer.setText("Player X - its your turn!");
                    else
                        curPlayer.setText("Game Over!");
                }
                v.setClickable(false);
                Log.d("BTN","The user clicked on Btn 7");
                clicksCounter++;
                if(checkForTheWinner(v)){
                    curPlayer.setText("Winner!");
                    Btn0.setClickable(false);
                    Btn1.setClickable(false);
                    Btn2.setClickable(false);
                    Btn3.setClickable(false);
                    Btn4.setClickable(false);
                    Btn5.setClickable(false);
                    Btn6.setClickable(false);
                    Btn7.setClickable(false);
                    Btn8.setClickable(false);
                }
            }
        });

        Btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getCurrentState() == 1){
                    btnArray[8] = 1;
                    Log.d("BTN","thex");
                    v.setBackgroundResource(R.drawable.thex);
                    setCurrentState(0);
                    if(clicksCounter != 8)
                        curPlayer.setText("Player Y - its your turn!");
                    else
                        curPlayer.setText("Game Over!");
                }
                else if (getCurrentState() == 0){
                    btnArray[8] = 2;
                    Log.d("BTN","O");
                    v.setBackgroundResource(R.drawable.circle);
                    setCurrentState(1);
                    if(clicksCounter != 8)
                        curPlayer.setText("Player X - its your turn!");
                    else
                        curPlayer.setText("Game Over!");
                }
                v.setClickable(false);
                Log.d("BTN","The user clicked on Btn 8");
                clicksCounter++;
                if(checkForTheWinner(v)){
                    curPlayer.setText("Winner!");
                    Btn0.setClickable(false);
                    Btn1.setClickable(false);
                    Btn2.setClickable(false);
                    Btn3.setClickable(false);
                    Btn4.setClickable(false);
                    Btn5.setClickable(false);
                    Btn6.setClickable(false);
                    Btn7.setClickable(false);
                    Btn8.setClickable(false);
                }
            }
        });



    }

    private void restartTheGame() {
        setCurrentState(1);
        clicksCounter=0;
        clicksCounter =0;
        btnArray = new Integer[9];
        //init Array button with NULL
        for(int i=0 ;i<btnArray.length;i++)
            btnArray[i] = 0;
        onCreate(Bundle.EMPTY);
    }

    public boolean checkForTheWinner(View v) {
        //Checking 1
        if(btnArray[0] == 1 && btnArray[1] == 1 && btnArray[2] == 1){
            Log.d("BTN","X is the winner - a on matrix");
            return true;

        }
        if (btnArray[0] == 2 && btnArray[1] == 2 && btnArray[2] == 2){
            Log.d("BTN","Y is the winner a on matrix");
            return true;
        }
        //Checking 2
        if(btnArray[3] == 1 && btnArray[4] == 1 && btnArray[5] == 1){
            Log.d("BTN","X is the winner - 345 on matrix");
            return true;
        }
        if (btnArray[3] == 2 && btnArray[4] == 2 && btnArray[5] == 2){
            Log.d("BTN","Y is the winner - 345 on matrix");
            return true;
        }
        //Checking 3
        if(btnArray[6] == 1 && btnArray[7] == 1 && btnArray[8] == 1){
            Log.d("BTN","X is the winner - 678 on matrix");
            return true;
        }
        if (btnArray[6] == 2 && btnArray[7] == 2 && btnArray[8] == 2){
            Log.d("BTN","Y is the winner - 678 on matrix");
            return true;
        }
        //Checking 4
        if(btnArray[0] == 1 && btnArray[3] == 1 && btnArray[6] == 1){
            Log.d("BTN","X is the winner - 036 on matrix");
            return true;
        }
        if (btnArray[0] == 2 && btnArray[3] == 2 && btnArray[6] == 2){
            Log.d("BTN","Y is the winner - 036 on matrix");
            return true;
        }
        //Checking 5
        if(btnArray[1] == 1 && btnArray[4] == 1 && btnArray[7] == 1){
            Log.d("BTN","X is the winner - 147 on matrix");
            return true;
        }
        if (btnArray[1] == 2 && btnArray[4] == 2 && btnArray[7] == 2){
            Log.d("BTN","Y is the winner - 147 on matrix");
            return true;
        }
        //Checking 6
        if(btnArray[2] == 1 && btnArray[5] == 1 && btnArray[8] == 1){
            Log.d("BTN","X is the winner - 258 on matrix");
            return true;
        }
        if (btnArray[2] == 2 && btnArray[5] == 2 && btnArray[8] == 2){
            Log.d("BTN","Y is the winner - 258 on matrix");
            return true;
        }
        //Checking 7
        if(btnArray[0] == 1 && btnArray[4] == 1 && btnArray[8] == 1){
            Log.d("BTN","X is the winner - 048 on matrix");
            return true;
        }
        if (btnArray[0] == 2 && btnArray[4] == 2 && btnArray[8] == 2){
            Log.d("BTN","Y is the winner - 048 on matrix");
            return true;
        }
        //Checking 8
        if(btnArray[2] == 1 && btnArray[4] == 1 && btnArray[6] == 1){
            Log.d("BTN","X is the winner - 246 on matrix");
            return true;
        }
        if (btnArray[2] == 2 && btnArray[4] == 2 && btnArray[6] == 2){
            Log.d("BTN","Y is the winner - 246 on matrix");
            return true;
        }
        else
            return false;


    }

    public int getCurrentState() {
        return currentState;
    }

    public void setCurrentState(int currentState) {
        this.currentState = currentState;
    }

    public int getClicksCounter() {
        return clicksCounter;
    }

    public void setClicksCounter(int clicksCounter) {
        this.clicksCounter = clicksCounter;
    }

    public Integer[] getBtnArray() {
        return btnArray;
    }

    public void setBtnArray(Integer[] btnArray) {
        this.btnArray = btnArray;
    }

}
