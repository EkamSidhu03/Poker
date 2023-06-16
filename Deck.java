import java.util.Collections;

public class Deck extends SetOfCards{
    public Deck(){
       max = 52;
        createCards();
    }
    private void createCards(){
        for (Suit s : Suit.values())
            for (Rank r : Rank.values())
                cards.add(new Card(r, s));
    }
    public void shuffle(){
        Collections.shuffle(cards);
    }
    public Card deal(){
        return cards.remove(0);
    }    
}
