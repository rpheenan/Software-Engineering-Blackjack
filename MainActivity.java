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

/**
 * This is the MainActivity class that displays the game on the app and displays the cards and result
 * @author BrocBurger
 * @author RyanHeenan
 * @version 1.0 09/29/19
 */

public class MainActivity extends AppCompatActivity {

    //Blackjack object
    private BlackJack blackJack;
    //int Array of cards
    private int cardArray[];
    //int Count for hit button
    private int count = 0;

    /*
     * When app is first launch this displays the players and dealers first 2 cards
     * @param
     *      Bundle savedInstanceState of the app at first launch
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Sets the view for the app
        setContentView(R.layout.activity_main);

        //Creates the blackjack object
        blackJack = new BlackJack();
        //Gets the hit button
        Button btn = (Button) findViewById(R.id.hitBtn);
        //Gets the stop button
        Button btn2 = (Button) findViewById(R.id.stopBtn);
        //Enables to click the Hit button
        btn.setEnabled(true);
        //Enables to click the Stop button
        btn2.setEnabled(true);
        //creates a random object
        Random rand = new Random();
        //creates a random int for 4 values
        int n1 = rand.nextInt(52);
        int n2 = rand.nextInt(52);
        int n3 = rand.nextInt(52);
        int n4 = rand.nextInt(52);
        //card array of a 52 card deck
        cardArray = new int[]{11,2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10,
        11,2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10};
        //Creates the start of game giving player and dealer 2 cards each
        blackJack.startGame(cardArray[n1], cardArray[n2], cardArray[n3], cardArray[n4]);

        //Accessing the player and dealer's 2 cards
        TextView player1Card = (TextView) findViewById(R.id.playerCard1);
        TextView player2Card = (TextView) findViewById(R.id.playerCard2);
        TextView dealer1Card = (TextView) findViewById(R.id.dealerCard1);
        TextView dealer2Card = (TextView) findViewById(R.id.dealerCard2);

        //Setting the player and dealer's 2 cards with values
        player1Card.setText(findCard(cardArray[n1], n1));
        player2Card.setText(findCard(cardArray[n2], n2));
        dealer1Card.setText(findCard(cardArray[n3], n3));
        dealer2Card.setText(findCard(cardArray[n4], n4));

        //Outputting result of game after first 2 cards appear
        EditText editText = (EditText) findViewById(R.id.editText3);
        editText.setText(blackJack.result());
        //Checking if either player or dealer have won of their first 2 cards and disabling buttons
        if(blackJack.check21() > 0){
            btn.setEnabled(false);
            btn2.setEnabled(false);
        }


    }

    /*
     * Finding the card value and checking if it is a face card or ace and having them display face value
     * @param
     *      int cardValue value of card from array
     * @param
     *      int n2 value of index of array
     * @return
     *      String either of face value or actual value of card
     */
    public String findCard(int cardValue, int n2){
        //checking if card is an ace
        if(cardValue == 11){
            return "A";
        }
        //checking if card is under 10
        else if (cardValue != 10){
            return "" + cardValue;
        }
        //Dealing with face value cards
        else
            //checking index of array to see if it is a queen
            if(n2 == 11 || n2 == 24 || n2 == 37 || n2 == 50){
            return "Q";
        }
        //Checking if index of array to see if it is a jack
        else if ( n2 == 10 || n2 == 23 || n2 == 36 || n2 == 49){
            return "J";
        }
        //Checking if index of array to see if it is a king
        else{
            return "K";
        }

    }


    /*
     * when user clicks hit button to take another card
     * @param
     *      View v is hit button being clicked
     */
    public void hit(View v)
    {
        //keeping track of how many clicks
        count++;
        //running player method to affect the cards
        player_run(count);
    }

    /*
     * when user clicks stop button stops user from taking card and is dealers turn
     * @param
     *      View v is stop button being clicked
     */
    public void stop(View v)
    {
        //When user hits stop runs dealer method
        dealer_run();
    }

    /*
     * when user clicks NewGame button restarts the game
     * @param
     *      View v is NewGame button being clicked
     */
    public void newGame(View v)
    {
        //Accessing hit and stop button
        Button btn = (Button) findViewById(R.id.hitBtn);
        Button btn2 = (Button) findViewById(R.id.stopBtn);
        //Enabling both buttons to be clicked
        btn.setEnabled(true);
        btn2.setEnabled(true);
        //reseting count of buttons clicked for new game
        count = 0;
        //Creating blackjack object
        blackJack = new BlackJack();
        //Creating random object
        Random rand = new Random();
        //Creating 4 random ints
        int n1 = rand.nextInt(52);
        int n2 = rand.nextInt(52);
        int n3 = rand.nextInt(52);
        int n4 = rand.nextInt(52);
        //Creating an array of 52 cards
        cardArray = new int[]{11,2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10,
                11,2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10};
        //Starting blackjack game giving player and dealer 2 cards each
        blackJack.startGame(cardArray[n1], cardArray[n2], cardArray[n3], cardArray[n4]);

        //accessing player and dealer card
        TextView player1Card = (TextView) findViewById(R.id.playerCard1);
        TextView player2Card = (TextView) findViewById(R.id.playerCard2);
        TextView dealer1Card = (TextView) findViewById(R.id.dealerCard1);
        TextView dealer2Card = (TextView) findViewById(R.id.dealerCard2);

        //Setting player and dealer cards with new values
        player1Card.setText(findCard(cardArray[n1], n1));
        player2Card.setText(findCard(cardArray[n2], n2));
        dealer1Card.setText(findCard(cardArray[n3], n3));
        dealer2Card.setText(findCard(cardArray[n4], n4));

        //Resetting all of cards 3-5 back to invisible for new game to begin
        TextView player3Card = (TextView) findViewById(R.id.playerCard3);
        player3Card.setVisibility(View.INVISIBLE);

        TextView player4Card = (TextView) findViewById(R.id.playerCard4);
        player4Card.setVisibility(View.INVISIBLE);

        TextView player5Card = (TextView) findViewById(R.id.playerCard5);
        player5Card.setVisibility(View.INVISIBLE);

        TextView dealer3Card = (TextView) findViewById(R.id.dealerCard3);
        dealer3Card.setVisibility(View.INVISIBLE);

        TextView dealer4Card = (TextView) findViewById(R.id.dealerCard4);
        dealer4Card.setVisibility(View.INVISIBLE);

        TextView dealer5Card = (TextView) findViewById(R.id.dealerCard5);
        dealer5Card.setVisibility(View.INVISIBLE);

        //Setting result of new game
        EditText editText = (EditText) findViewById(R.id.editText3);
        editText.setText(blackJack.result());

        //Checking if new game has a instant winner with a blackjack and disabling buttons if so
        if(blackJack.check21() > 0){
            btn.setEnabled(false);
            btn2.setEnabled(false);
        }



    }

    /*
     * if Player hits for another card goes one card at a time giving new card and
     * adding value to overall score
     * @params
     *      int n for count of number of clicks for each new card
     */
    public void player_run( int n){
        //Accessing output of result of game
        EditText editText = (EditText) findViewById(R.id.editText3);
        //creating random object
        Random rand = new Random();
        //creating 3 random ints for the 3 new player cards
        int n1 = rand.nextInt(52);
        int n2 = rand.nextInt(52);
        int n3 = rand.nextInt(52);
        //Card array of 52 cards
        cardArray = new int[]{11,2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10,
                11,2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10};
        //Accessing both hit and stop button
        Button btn = (Button) findViewById(R.id.hitBtn);
        Button btn2 = (Button) findViewById(R.id.stopBtn);
        //Enabling both buttons to be clicked
        btn.setEnabled(true);
        btn2.setEnabled(true);
        //If user clicks hit button once gives new player card and add value to overall score
        if(n == 1) {
            //Calculates overall score
            blackJack.playerHit(cardArray[n1]);
            //Accesses player card 3
            TextView player3Card = (TextView) findViewById(R.id.playerCard3);
            //Makes player card 3 visible
            player3Card.setVisibility(View.VISIBLE);
            //Sets player 3 card with new value
            player3Card.setText(findCard(cardArray[n1], n1));
            //Checks if new card makes player bust outputs lost and disables both buttons
            if(blackJack.player_bust()) {
                editText.setText("You Have Lost");
                btn.setEnabled(false);
                btn2.setEnabled(false);
            }
        }
        //If player wants a 4th card after clicking hit button 2 times
        else if( n == 2) {
            //adds 4th card to overall score
            blackJack.playerHit(cardArray[n2]);
            //access player 4th card
            TextView player4Card = (TextView) findViewById(R.id.playerCard4);
            //Make visible player 4th card
            player4Card.setVisibility(View.VISIBLE);
            //Sets players 4th card with value
            player4Card.setText(findCard(cardArray[n2], n2));
            //Checks if 4th card makes player bust and disables both buttons
            if(blackJack.player_bust()) {
                editText.setText("You Have Lost");
                btn.setEnabled(false);
                btn2.setEnabled(false);
            }
        }
        //If player wants 5th card and clicks hit button 3 times
        else if (n == 3) {
            //takes 5th card and adds it to overall score
            blackJack.playerHit(cardArray[n3]);
            //Accesses player 5th card
            TextView player5Card = (TextView) findViewById(R.id.playerCard5);
            //sets 5th player card visible
            player5Card.setVisibility(View.VISIBLE);
            //Sets 5th player card with value
            player5Card.setText(findCard(cardArray[n3], n3));
            //Checks if player 5th card makes player bust and disables both buttons
            if(blackJack.player_bust()){
                editText.setText("You Have Lost");
                btn.setEnabled(false);
                btn2.setEnabled(false);
            }
            //Checks if you lose after 5 cards drawn
            if(blackJack.Playervalue < blackJack.Dealervalue){
                editText.setText("You Have Lost");
                btn.setEnabled(false);
                btn2.setEnabled(false);
            }
        }
        //If hit button is clicked more than 3 times disables hit button
        else{
            btn.setEnabled(false);
        }
    }

    /*
     * User hits stop button then its dealers turn which then works with dealers cards
     */
    public void dealer_run( ){
        //Access result text for output
        EditText editText = (EditText) findViewById(R.id.editText3);
        //Create random object
        Random rand = new Random();
        //Create 3 int randoms
        int n1 = rand.nextInt(52);
        int n2 = rand.nextInt(52);
        int n3 = rand.nextInt(52);
        //Card array of 52 cards
        cardArray = new int[]{11,2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10,
                11,2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10};
        //Access hit and Stop button
        Button btn = (Button) findViewById(R.id.hitBtn);
        Button btn2 = (Button) findViewById(R.id.stopBtn);
        //Checks if there is a tie and disables buttons
        if(blackJack.Playervalue == blackJack.Dealervalue) {
            editText.setText("You have Tied");
            btn.setEnabled(false);
            btn2.setEnabled(false);
        }
            //Checks if player is still winning to take 3rd card
            if(blackJack.ifPlayerWinning()) {
                //adds 3rd card to dealer overall value
                blackJack.dealerHit(cardArray[n1]);
                //Access dealers 3rd card
                TextView dealer3Card = (TextView) findViewById(R.id.dealerCard3);
                //Make 3rd card visible
                dealer3Card.setVisibility(View.VISIBLE);
                //Set 3rd card value
                dealer3Card.setText(findCard(cardArray[n1], n1));
                //Check if dealer busts and output player has won and disable buttons
                if (blackJack.dealer_bust()) {
                    editText.setText("You Have Won");
                    btn.setEnabled(false);
                    btn2.setEnabled(false);
                }
                //Checks if dealer has won and disables buttons
                else if(blackJack.check_Win()) {
                    editText.setText(blackJack.finalCheck());
                    btn.setEnabled(false);
                    btn2.setEnabled(false);
                }
            }
            //If player is still winning take a 4th dealer card
            if (blackJack.ifPlayerWinning()) {
                //Add 4th card to dealer value
                blackJack.dealerHit(cardArray[n2]);
                //Access dealers 4th card
                TextView dealer4Card = (TextView) findViewById(R.id.dealerCard4);
                //Make 4th card visible
                dealer4Card.setVisibility(View.VISIBLE);
                //Make 4th card have new value
                dealer4Card.setText(findCard(cardArray[n2], n2));
                //Check if dealer new card has made him bust and disable buttons
                if (blackJack.dealer_bust()) {
                    editText.setText("You Have Won");
                    btn.setEnabled(false);
                    btn2.setEnabled(false);
                }
                //Check if dealer has won and disable buttons
                else if(blackJack.check_Win()) {
                    editText.setText(blackJack.finalCheck());
                    btn.setEnabled(false);
                    btn2.setEnabled(false);
                }
            }
            //If player is still winning take 5th card
            if (blackJack.ifPlayerWinning()) {
                //Add 5th card value to overall dealer value
                blackJack.dealerHit(cardArray[n3]);
                //Access dealer's 5th card
                TextView dealer5Card = (TextView) findViewById(R.id.dealerCard5);
                //Make 5th card visible
                dealer5Card.setVisibility(View.VISIBLE);
                //Give 5th card value to display
                dealer5Card.setText(findCard(cardArray[n3], n3));
                //Check if dealer has busted and disable buttons
                if (blackJack.dealer_bust()){
                    editText.setText("You Have Won");
                    btn.setEnabled(false);
                    btn2.setEnabled(false);
                }
                //Check if dealer has won and disable buttons
                else if(blackJack.check_Win()) {
                    editText.setText(blackJack.finalCheck());
                    btn.setEnabled(false);
                    btn2.setEnabled(false);
                }
            }
    }
}
