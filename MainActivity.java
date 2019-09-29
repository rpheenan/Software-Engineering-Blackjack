package com.example.brocburger.blackjack;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private BlackJack blackJack;
    private int cardArray[];
    private int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        blackJack = new BlackJack();
        Button btn = (Button) findViewById(R.id.hitBtn);
        Button btn2 = (Button) findViewById(R.id.stopBtn);
        btn.setEnabled(true);
        btn2.setEnabled(true);
        Random rand = new Random();
        int n1 = rand.nextInt(52);
        int n2 = rand.nextInt(52);
        int n3 = rand.nextInt(52);
        int n4 = rand.nextInt(52);
        cardArray = new int[]{11,2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10,
        11,2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10};
        blackJack.startGame(cardArray[n1], cardArray[n2], cardArray[n3], cardArray[n4]);

        TextView player1Card = (TextView) findViewById(R.id.playerCard1);
        TextView player2Card = (TextView) findViewById(R.id.playerCard2);
        TextView dealer1Card = (TextView) findViewById(R.id.dealerCard1);
        TextView dealer2Card = (TextView) findViewById(R.id.dealerCard2);

        player1Card.setText(findCard(cardArray[n1], n1));
        player2Card.setText(findCard(cardArray[n2], n2));
        dealer1Card.setText(findCard(cardArray[n3], n3));
        dealer2Card.setText(findCard(cardArray[n4], n4));

        EditText editText = (EditText) findViewById(R.id.editText3);
        editText.setText(blackJack.result());
        if(blackJack.check21() > 0){
            btn.setEnabled(false);
            btn2.setEnabled(false);
        }


    }

    public String findCard(int cardValue, int n2){
        if(cardValue == 11){
            return "A";
        }
        else if (cardValue != 10){
            return "" + cardValue;
        }
        else
            if(n2 == 11 || n2 == 24 || n2 == 37 || n2 == 50){
            return "Q";
        }
        else if ( n2 == 10 || n2 == 23 || n2 == 36 || n2 == 49){
            return "J";
        }
        else{
            return "K";
        }

    }


    public void hit(View v)
    {
        count++;
        player_run(count);
    }

    public void stop(View v)
    {
        dealer_run();
    }

    public void newGame(View v)
    {
        Button btn = (Button) findViewById(R.id.hitBtn);
        Button btn2 = (Button) findViewById(R.id.stopBtn);
        btn.setEnabled(true);
        btn2.setEnabled(true);
        count = 0;
        blackJack = new BlackJack();
        Random rand = new Random();
        int n1 = rand.nextInt(52);
        int n2 = rand.nextInt(52);
        int n3 = rand.nextInt(52);
        int n4 = rand.nextInt(52);
        cardArray = new int[]{11,2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10,
                11,2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10};
        blackJack.startGame(cardArray[n1], cardArray[n2], cardArray[n3], cardArray[n4]);


        TextView player1Card = (TextView) findViewById(R.id.playerCard1);
        TextView player2Card = (TextView) findViewById(R.id.playerCard2);
        TextView dealer1Card = (TextView) findViewById(R.id.dealerCard1);
        TextView dealer2Card = (TextView) findViewById(R.id.dealerCard2);

        player1Card.setText(findCard(cardArray[n1], n1));
        player2Card.setText(findCard(cardArray[n2], n2));
        dealer1Card.setText(findCard(cardArray[n3], n3));
        dealer2Card.setText(findCard(cardArray[n4], n4));

        TextView player3Card = (TextView) findViewById(R.id.playerCard3);
        player3Card.setVisibility(View.INVISIBLE);
        // player3Card.setText("" + cardArray[n1]);

        TextView player4Card = (TextView) findViewById(R.id.playerCard4);
        player4Card.setVisibility(View.INVISIBLE);

        TextView player5Card = (TextView) findViewById(R.id.playerCard5);
        player5Card.setVisibility(View.INVISIBLE);

        TextView dealer3Card = (TextView) findViewById(R.id.dealerCard3);
        dealer3Card.setVisibility(View.INVISIBLE);
        // player3Card.setText("" + cardArray[n1]);

        TextView dealer4Card = (TextView) findViewById(R.id.dealerCard4);
        dealer4Card.setVisibility(View.INVISIBLE);

        TextView dealer5Card = (TextView) findViewById(R.id.dealerCard5);
        dealer5Card.setVisibility(View.INVISIBLE);

        EditText editText = (EditText) findViewById(R.id.editText3);
        editText.setText(blackJack.result());

        if(blackJack.check21() > 0){
            btn.setEnabled(false);
            btn2.setEnabled(false);
        }



    }

    public void player_run( int n){
        EditText editText = (EditText) findViewById(R.id.editText3);
        Random rand = new Random();
        int n1 = rand.nextInt(52);
        int n2 = rand.nextInt(52);
        int n3 = rand.nextInt(52);
        cardArray = new int[]{11,2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10,
                11,2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10};
        Button btn = (Button) findViewById(R.id.hitBtn);
        Button btn2 = (Button) findViewById(R.id.stopBtn);
        btn.setEnabled(true);
        btn2.setEnabled(true);
        if(n == 1) {
            blackJack.playerHit(cardArray[n1]);
            TextView player3Card = (TextView) findViewById(R.id.playerCard3);
            player3Card.setVisibility(View.VISIBLE);
            player3Card.setText(findCard(cardArray[n1], n1));
            if(blackJack.player_bust()) {
                editText.setText("You Have Lost");
                btn.setEnabled(false);
                btn2.setEnabled(false);
            }
        }
        else if( n == 2) {
            blackJack.playerHit(cardArray[n2]);
            TextView player4Card = (TextView) findViewById(R.id.playerCard4);
            player4Card.setVisibility(View.VISIBLE);
            player4Card.setText(findCard(cardArray[n2], n2));
            if(blackJack.player_bust()) {
                editText.setText("You Have Lost");
                btn.setEnabled(false);
                btn2.setEnabled(false);
            }
        }
        else if (n == 3) {
            blackJack.playerHit(cardArray[n3]);
            TextView player5Card = (TextView) findViewById(R.id.playerCard5);
            player5Card.setVisibility(View.VISIBLE);
            player5Card.setText(findCard(cardArray[n3], n3));
            if(blackJack.player_bust()){
                editText.setText("You Have Lost");
                btn.setEnabled(false);
                btn2.setEnabled(false);
            }
        }
        else{
            btn.setEnabled(false);
            btn2.setEnabled(false);
        }
    }

    public void dealer_run( ){
        EditText editText = (EditText) findViewById(R.id.editText3);
        Random rand = new Random();
        int n1 = rand.nextInt(52);
        int n2 = rand.nextInt(52);
        int n3 = rand.nextInt(52);
        cardArray = new int[]{11,2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10,
                11,2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10};
        Button btn = (Button) findViewById(R.id.hitBtn);
        Button btn2 = (Button) findViewById(R.id.stopBtn);
        btn.setEnabled(true);
        btn2.setEnabled(true);
        if(blackJack.Playervalue == blackJack.Dealervalue) {
            editText.setText("You have Tied");
            btn.setEnabled(false);
            btn2.setEnabled(false);
        }
            if(blackJack.ifPlayerWinning()) {
                blackJack.dealerHit(cardArray[n1]);
                TextView dealer3Card = (TextView) findViewById(R.id.dealerCard3);
                dealer3Card.setVisibility(View.VISIBLE);
                dealer3Card.setText(findCard(cardArray[n1], n1));
                if (blackJack.dealer_bust()) {
                    editText.setText("You Have Won");
                    btn.setEnabled(false);
                    btn2.setEnabled(false);
                }
                else if(blackJack.check_Win()) {
                    editText.setText(blackJack.finalCheck());
                    btn.setEnabled(false);
                    btn2.setEnabled(false);
                }
            }
            if (blackJack.ifPlayerWinning()) {
                blackJack.dealerHit(cardArray[n2]);
                TextView dealer4Card = (TextView) findViewById(R.id.dealerCard4);
                dealer4Card.setVisibility(View.VISIBLE);
                dealer4Card.setText(findCard(cardArray[n2], n2));
                if (blackJack.dealer_bust()) {
                    editText.setText("You Have Won");
                    btn.setEnabled(false);
                    btn2.setEnabled(false);
                }
                else if(blackJack.check_Win()) {
                    editText.setText(blackJack.finalCheck());
                    btn.setEnabled(false);
                    btn2.setEnabled(false);
                }
            }
            if (blackJack.ifPlayerWinning()) {
                blackJack.dealerHit(cardArray[n3]);
                TextView dealer5Card = (TextView) findViewById(R.id.dealerCard5);
                dealer5Card.setVisibility(View.VISIBLE);
                dealer5Card.setText(findCard(cardArray[n3], n3));
                if (blackJack.dealer_bust()){
                    editText.setText("You Have Won");
                    btn.setEnabled(false);
                    btn2.setEnabled(false);
                }
                else if(blackJack.check_Win()) {
                    editText.setText(blackJack.finalCheck());
                    btn.setEnabled(false);
                    btn2.setEnabled(false);
                }
            }

    }


}
