package com.example.brocburger.blackjack;

import android.content.pm.PackageManager;

/**
 * This is the BlackJack class that describes the rules of Blackjack and calculates the score of the game
 * @author BrocBurger
 * @author RyanHeenan
 * @version 1.0 09/29/19
 */

public class BlackJack {
    
    // Int representing value of dealer's hand.
    public int Dealervalue;
    // Int representing value of Player's hand.
    public int Playervalue;
    // Int representing number of Aces in Dealer's hand.
    private int DealernumAces;
    // Int representing number of Aces in Player's hand
    private int PlayernumAces;

    // Declares initial values of Blackjack's attributes.
    public BlackJack()
    {
        Dealervalue = 0;
        Playervalue = 0;
        DealernumAces = 0;
        PlayernumAces = 0;
    }

    /**
     * sets up start of game with giving both player and dealer 2 cards
     * @param Playerval1
     *          value of player card 1
     * @param Playerval2 
     *          value of player card 2
     * @param Dealerval1
     *          value of dealer card 1
     * @param Dealerval2
     *          value of dealer card 2
     * @return No Return
     */
    public void startGame(int Playerval1, int Playerval2, int Dealerval1, int Dealerval2)
    {
        Playervalue += (Playerval1 + Playerval2);
        Dealervalue += (Dealerval1 + Dealerval2);
        //Checking if card is an ace and if it is adding one to the number of aces variable for player
        if (Playerval1  == 11)
            PlayernumAces += 1;
        //Checking if card is an ace and if it is adding one to the number of aces variable for player
        if (Playerval2 == 11)
            PlayernumAces +=1;
        //Checking if card is an ace and if it is adding one to the number of aces variable for dealer
        if (Dealerval1 == 11)
            DealernumAces += 1;
        //Checking if card is an ace and if it is adding one to the number of aces variable for dealer
        if (Dealerval2  == 11)
            DealernumAces +=1;
    }

    /*
     * When player hits does the math for the new card and adds it to value of hand
     * @param val
     *      New value of card to add to total hand
     * @return None
     */
    public void playerHit(int val)
    {
        Playervalue += val;
        //Checks if new card is an ace and adds that to total number of aces
        if (val == 11)
            PlayernumAces += 1;
        Playervalue = PlayercheckAces();
    }

    /*
     * Checks if player has aces and does the math for whether value of Ace needs to be 1 or 11
     * 
     * @returns
     *      new value of hand with aces fixed
     */
    public int PlayercheckAces()
    {
        //Changes value of Ace if the value of total hand is over 21 from 11 to 1
        while(Playervalue > 21 && PlayernumAces > 0)
        {
            Playervalue -= 10;
            PlayernumAces -=1;
        }
        return Playervalue;
    }

    /*
     * When dealer hits does the math for the new card and adds it to value of hand
     * @param val
     *      New value of card to add to total hand
     * @return None
     */
    public void dealerHit(int val)
    {
        Dealervalue += val;
        //Checks if new card is an ace and adds that to total number of aces
        if (val == 11)
            DealernumAces += 1;
        Dealervalue = DealercheckAces();
    }

    /*
     * Checks if dealer has aces and does the math for whether value of Ace needs to be 1 or 11
     *
     * @returns
     *      new value of hand with aces fixed
     */
    public int DealercheckAces()
    {
        //Changes value of Ace if the value of total hand is over 21 from 11 to 1
        while(Dealervalue > 21 && DealernumAces > 0)
        {
            Dealervalue -= 10;
            DealernumAces -=1;
        }
        return Dealervalue;
    }

    /*
     * Checks in beginning of game if either dealer or player has 21 or if both
     * @returns
     *      int representing game won(1) loss(2) or tied(3)
     */
    public int check21()
    {
        //Checks if player beats dealer
        if (Playervalue == 21 && Dealervalue !=21)
            return 1;
        //Checks if dealer beats player
        else if (Dealervalue == 21 && Playervalue != 21)
            return 2;
        //checks if tied
        else if (Dealervalue == 21 && Playervalue == 21)
            return 3;
        //continue to play game
        else
            return 0;

    }

    /*
     * Checks if dealer has beaten player or tied them
     * @returns
     *      boolean true if dealer is winning or tied false if not
     */
    public boolean check_Win(){
        //If dealer beats player or ties player
        if(Dealervalue > Playervalue || Dealervalue == Playervalue){
            return true;
        }
        else
            return false;
    }

    /*
     * Checks if player value is over 21
     * @returns
     *      returns true if player has busts false if not
     */
    public boolean player_bust()
    {
        //Checks if hand value is over 21
        if(Playervalue > 21)
            return true;
        else
            return false;
    }
    
    /*
     * Checks if dealer value is over 21
     * @returns
     *      returns true if dealer has busts false if not
     */
    public boolean dealer_bust()
    {
        //Checks if hand value is over 21
        if(Dealervalue > 21)
            return true;
        else
            return false;
    }

    /*
     * Checks if player still is winning while dealer hits
     * @ returns 
     *      Returns true if player is still have higher value false if not
     */
    public boolean ifPlayerWinning()
    {
        //Checks if player value is higher than dealers
        if (Playervalue > Dealervalue)
            return true;
        else
            return false;
    }
    
    /*
     * Outputs result of game if dealer or player have won or if there was a tie
     * @returns
     *      returns a string of win lost or tie depending on result of game 
     */
    public String finalCheck(){
        //Checks if player value is higher than dealers resulting in a win for player
        if(Playervalue > Dealervalue){
            return "You have Won";
        }
        //Checks if dealer value is higher than players resulting in a lost for player
        else if (Dealervalue> Playervalue){
            return "You have Lost";
        }
        //Else is a tie
        else
            return "You have Tied";
    }

    /*
     * Checks result of game in beginning
     * @returns
     *      String value of win lost or tie for the start of game
     */
    public String result()
    {
        int val = check21();
        //If player has won 
        if (val == 1)
            return "You have won";
        //If player has lost
        else if (val == 2)
            return "You have lost";
        //If a tie
        else if (val == 3)
            return "You have tied";
        //if game is still happening
        else
            return "Continue";
    }
}
