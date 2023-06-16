
public class Card {
		private Suit suit;
	    private Rank rank;
	    public Card(Rank r, Suit s){
	        suit = s;
	        rank = r;
	    } 
	    public Suit getSuit(){
	        return suit;
	    }
	    public Rank getRank(){
	        return rank;
	    }   
	    public String toString(){
	        return rank + " of " + suit;
	}
}
