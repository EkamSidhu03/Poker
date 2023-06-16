import java.util.ArrayList;

public class SetOfCards {
	protected ArrayList<Card> cards;
    protected int max;
    public SetOfCards(){
        cards = new ArrayList<>();
    }
    public void addCard(Card c){
        if (cards.size() < max)
            cards.add(c);
        else System.out.println("Can not add, full set");
    }
    public ArrayList<Card> getCards(){
        return cards;
    }
    public void setCards(ArrayList<Card> cards){
        if (cards.size() <= max)
            this.cards = cards;
        else System.out.println("Can not set, must have less than" + max + " cards.");   
    }
    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        for (Card c : cards)
            sb.append(c.toString() + ", ");
        sb.delete(sb.length()-2, sb.length());
        sb.append("]");
        return sb.toString();  
    }    
}
