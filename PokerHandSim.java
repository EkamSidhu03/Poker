
public class PokerHandSim {

	public static void main(String[] args) {

        Deck deck = new Deck();
        int numCards = 5, numPlayers = 4;
        deck.shuffle();
        for (int i=1; i<=numPlayers; i++){
            System.out.println("Player " + i + ":");    
            Hand hand = new Hand();
            for (int j=0; j<numCards; j++){
                hand.addCard(deck.deal());              
            }
            System.out.println(hand);
            System.out.println(hand.evaluate() + "\n");
        }
        System.out.println("Number of cards remaining in deck: " + 
            deck.getCards().size());
	}
}
