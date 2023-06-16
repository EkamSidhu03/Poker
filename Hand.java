import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Hand extends SetOfCards {
    public Hand(){
        max = 5;
    } 
    public Hand(ArrayList<Card> cards){
        max = 5;
       this.cards = cards;
    }
    public Hand (Card[] cards){
        Collections.addAll(this.cards, cards);
    }
    public String evaluate(){
        if (checkFlush())
            if (checkStraight())
                return"Straight Flush!";
            else
                return "Flush";
        else if (checkStraight())
            return "Straight";
        else return checkMatches();            
    }
    private boolean checkFlush(){
        Suit s = cards.get(0).getSuit();
        if (s == cards.get(1).getSuit() && s == cards.get(2).getSuit() && 
            s == cards.get(3).getSuit() && s == cards.get(4).getSuit())
            return true;
        else return false;    
    }
    private boolean checkStraight(){
        Rank[] ranks = Rank.values();
        int[] rank = new int[5];
        for (int i=0; i<5; i++)
            for (int j=0; j< ranks.length; j++)
                if (cards.get(i).getRank() == ranks[j]){
                    rank[i] = j;    
                    break;
                }    
        Arrays.sort(rank);
        boolean isStraight = true;
        for (int i=4; i>0 && isStraight; i--)
            if (rank[i] - rank[i-1] !=1)
                isStraight = false;
        return isStraight;
    }
    private String checkMatches(){
        int[] dupes = new int[5]; 
        for (int i=0; i<cards.size(); i++)
            for (int j=0; j<cards.size(); j++)
                if (cards.get(i).getRank() == cards.get(j).getRank())
                    dupes[i]++;                    
        int fourOfAKind = 0, threeOfAKind = 0, pair = 0;
        for (int i : dupes)
            switch(i){
                case 2: pair++; break;
                case 3: threeOfAKind++; break;
                case 4: fourOfAKind++; break;
            }
        if (threeOfAKind == 3)
            if (pair == 2)
                return "Full House";
            else 
                return "Three of a Kind";
        else if (pair == 4)
            return "Two Pair";
        else if (pair == 2)
            return "One Pair";
        else if (fourOfAKind == 4)
            return "Four of a Kind";       
        return "Nothing " + "(" + findHigh() + " high)";
    }
    private String findHigh(){
        Card high = cards.get(0);
        for (Card c : cards)
            if (c.getRank().getValue() > high.getRank().getValue())
                high = c;
        return (high.getRank().toString());
    }
}