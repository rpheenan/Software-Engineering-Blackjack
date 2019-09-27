package com.example.brocburger.blackjack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private BlackJack blackJack;
    private int cardArray[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        player1Card.setText("" + cardArray[n1]);
        player2Card.setText("" + cardArray[n2]);
        dealer1Card.setText("" + cardArray[n3]);
        dealer2Card.setText("" + cardArray[n4]);


    }

    public void hit(View v)
    {

        TextView player3Card = (TextView) findViewById(R.id.playerCard3);
        player3Card.setVisibility(View.VISIBLE);
       // player3Card.setText("" + cardArray[n1]);

        TextView player4Card = (TextView) findViewById(R.id.playerCard4);
        player4Card.setVisibility(View.VISIBLE);

        TextView player5Card = (TextView) findViewById(R.id.playerCard5);
        player5Card.setVisibility(View.VISIBLE);

    }

    public void stop(View v)
    {

    }

    public void newGame(View v)
    {

    }


}
