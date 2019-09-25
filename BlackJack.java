package com.example.brocburger.blackjack;

public class BlackJack {


    public int Dealervalue;
    public int Playervalue;
    private int DealernumAces;
    private int PlayernumAces;

    public BlackJack()
    {
        Dealervalue = 0;
        Playervalue = 0;
        DealernumAces = 0;
        PlayernumAces = 0;
    }

    public void startGame(int Playerval1, int Playerval2, int Dealerval1, int Dealerval2)
    {
        Playervalue += (Playerval1 + Playerval2);
        Dealervalue += (Dealerval1 + Dealerval2);
        if (Playerval1  == 11)
            PlayernumAces += 1;
        if (Playerval2 == 11)
            PlayernumAces +=1;
        if (Dealerval1 == 11)
            DealernumAces += 1;
        if (Dealerval2  == 11)
            DealernumAces +=1;
    }

    // ace 2 3 4 5 6 7 8 9 10 J Q K
    public void playerHit(int val)
    {
        Playervalue += val;
        if (val == 11)
            PlayernumAces += 1;
        Playervalue = PlayercheckAces();
    }

    public int PlayercheckAces()
    {
        while(Playervalue > 21 && PlayernumAces > 0)
        {
            Playervalue -= 10;
            PlayernumAces -=1;
        }
        return Playervalue;
    }

    public void dealerHit(int val)
    {
        Dealervalue += val;
        if (val == 11)
            DealernumAces += 1;
        Dealervalue = DealercheckAces();
    }

    public int DealercheckAces()
    {
        while(Dealervalue > 21 && DealernumAces > 0)
        {
            Dealervalue -= 10;
            DealernumAces -=1;
        }
        return Dealervalue;
    }

    public boolean isGameOver()
    {
        return bust() > 0;
    }

    public int check21()
    {
        if (Playervalue == 21 && Dealervalue !=21)
            return 1;
        else if (Dealervalue == 21 && Playervalue != 21)
            return 2;
        else if (Dealervalue == 21 && Playervalue == 21)
            return 3;
        else
            return 0;

    }

    public int bust()
    {
        if (Playervalue > 21)
            return 2;
        if (Dealervalue > 21)
            return 1;
        else
            return 0;
    }

    public int final_check()
    {
        if (Playervalue > Dealervalue)
            return 1;
        else if (Playervalue < Dealervalue)
            return 2;
        else
            return 3;
    }

    public String result()
    {
        int val = check21();
        if (val == 1)
            return "You have won";
        else if (val == 2)
            return "You have lost";
        else if (val == 3)
            return "You have tied";
        else
            return "Continue";
    }
}
