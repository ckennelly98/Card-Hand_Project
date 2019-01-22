public class Hand {
    // Constants for types of hands
    // The numbers used for the hand
    // types increase with the value of the hand type.
    // For example, four-of-a-kind is the highest-valued
    // hand type that we support, and it has the highest
    // numeric value.
    private static final int HIGH_CARD = 0;
    private static final int PAIR = 1;
    private static final int TWO_PAIRS = 2;
    private static final int THREE_OF_A_KIND = 3;
    private static final int FLUSH = 4;
    private static final int FOUR_OF_A_KIND = 5;

    // The fields for a hand.
    // The Card objects in the hand are stored in array called cards.
    private Card[] cards;
    // The number of cards in the hand is called numCards.
    private int numCards;

    /* Put a John constructor here to allow client code to specify
     the maximum size of the hand for a given type of card game.
     */

    public Hand(int maxCards){
        numCards = 0;
        cards = new Card[maxCards];
    }

    public int getNumCards(){
        return numCards;
    }

    public void addCard(Card newCard)throws IllegalArgumentException{
        if(numCards == cards.length){
            throw new IllegalArgumentException();
        }
        if(newCard == null){
            throw new IllegalArgumentException();
        }
        cards[numCards] = newCard;
        numCards++;
    }

    public Card getCard(int i) throws IllegalArgumentException{
        if(i > numCards){
            throw new IllegalArgumentException();
        }
        return cards[i];
    }

    public Card playCard(int i)throws IllegalArgumentException{
        Card playedCard =  cards[i];
        for(int k = i; k < numCards - 1; k++) {
            cards[k] = cards[k + 1];
        }
        numCards -= 1;
        return playedCard;
    }

    public Card highCard() {
        Card highestCard = cards[0];
        for(int i = 0; i < numCards; i++) {
            if (cards[i].getValue() > highestCard.getValue()) {
                highestCard = cards[i];
            }
        }
        return highestCard;
    }

    public int numCardsOfRank(int rank){
        int count = 0;
        for (int i = 0; i < numCards; i++){
            if (cards[i].getRank() == rank){
                count += 1;
            }
        }
        return count;
    }

    public boolean hasPair(){
        boolean onePair = false;
        for (int i = 0; i < numCards; i++){
            Card current = cards[i];
            for (int k = i+1; k < numCards; k++) {
                if (current.getRank() == cards[k].getRank()) {
                    onePair = true;
                }
            }
        }
        return onePair;
    }

    public boolean hasThreeOfAKind(){
        boolean threePair = false;
        for (int i = 0; i < numCards; i++){
            Card current = cards[i];
            for (int k = i+1; k < numCards; k++) {
                Card card2 = cards[k];
                for (int l  = k+1; l < numCards; l++) {
                    if (current.getRank() == card2.getRank() && current.getRank() == cards[k].getRank()) {
                        threePair = true;
                    }
                }
            }
        }
        return threePair;
    }

    public boolean hasTwoPairs(){
        boolean twoPaired = false;
        boolean paired1 = false;
        boolean paired2 = false;
        for (int k = 0; k < numCards; k++) {
            Card current1 = cards[k];
            for (int l  = k+1; l < numCards; l++) {
                if (current1.getRank() == cards[l].getRank()) {
                    paired1 = true;
                }
            }
        }

        for (int k = 0; k < numCards; k++) {
            Card current2 = cards[k];
            for (int l  = k+1; l < numCards; l++) {
                if (current2.getRank() == cards[l].getRank()) {
                    paired2 = true;
                }
            }
        }

        if(paired1 && paired2){
            twoPaired = true;
        }

        return twoPaired;
    }

    public boolean hasFlush(){
        boolean flushed = false;
        for (int i = 0; i < numCards; i++){
            Card card1 = cards[i];
            for (int k = i+1; k < numCards; k++) {
                Card card2 = cards[k];
                for (int l  = k+1; l < numCards; l++) {
                    Card card3 = cards[l];
                    for (int j = l+1; j < numCards; j++) {
                        Card card4 = cards[j];
                        for (int m  = j+1; m < numCards; m++) {
                            Card card5 = cards[m];
                            if (card1.getSuit() == card2.getSuit() && card1.getSuit() == card3.getSuit()
                                    && card1.getSuit() == card4.getSuit() && card1.getSuit() == card5.getSuit()) {
                                flushed = true;
                            }
                        }
                    }
                }
            }
        }

        return flushed;
    }

    public boolean hasFourOfAKind(){
        boolean fourPair = false;
        for (int i = 0; i < numCards; i++){
            Card card1 = cards[i];
            for (int k = i+1; k < numCards; k++) {
                Card card2 = cards[k];
                for (int l  = k+1; l < numCards; l++) {
                    Card card3 = cards[l];
                    for (int m = l+1; m < numCards; m++) {
                        Card card4 = cards[m];
                        if (card1.getRank() == card2.getRank() && card1.getRank() == card3.getRank()
                                && card1.getRank() == card4.getRank()) {
                            fourPair= true;
                        }
                    }
                }
            }
        }
        return fourPair;
    }

    public int handType(){
        int type = 0;

        // Four of A Kind
        boolean fourPair = false;
        for (int a = 0; a < numCards; a++){
            Card card1 = cards[a];
            for (int b = a+1; b < numCards; b++) {
                Card card2 = cards[b];
                for (int c  = b+1; c < numCards; c++) {
                    Card card3 = cards[c];
                    for (int d = c+1; d < numCards; d++) {
                        Card card4 = cards[d];
                        if (card1.getRank() == card2.getRank() && card1.getRank() == card3.getRank()
                                && card1.getRank() == card4.getRank()) {
                            fourPair= true;
                        }
                    }
                }
            }
        }

        // Flush
        boolean flushed = false;
        for (int e = 0; e < numCards; e++){
            Card card1 = cards[e];
            for (int f = e+1; f < numCards; f++) {
                Card card2 = cards[f];
                for (int g  = f+1; g < numCards; g++) {
                    Card card3 = cards[g];
                    for (int h = g+1; h < numCards; h++) {
                        Card card4 = cards[h];
                        for (int i  = h+1; i < numCards; i++) {
                            Card card5 = cards[i];
                            if (card1.getSuit() == card2.getSuit() && card1.getSuit() == card3.getSuit()
                                    && card1.getSuit() == card4.getSuit() && card1.getSuit() == card5.getSuit()) {
                                flushed = true;
                            }
                        }
                    }
                }
            }
        }

        // Three of A Kind
        boolean threePair = false;
        for (int j = 0; j < numCards; j++){
            Card current = cards[j];
            for (int k = j+1; k < numCards; k++) {
                Card card2 = cards[k];
                for (int l  = k+1; l < numCards; l++) {
                    if (current.getRank() == card2.getRank() && current.getRank() == cards[k].getRank()) {
                        threePair = true;
                    }
                }
            }
        }

        // Two Pair
        boolean twoPaired = false;
        boolean paired1 = false;
        boolean paired2 = false;
        for (int m = 0; m < numCards; m++) {
            Card current = cards[m];
            for (int n  = m+1; n < numCards; n++) {
                if (current.getRank() == cards[n].getRank()) {
                    paired1 = true;
                }
            }
        }

        for (int o = 0; o < numCards; o++) {
            Card current = cards[o];
            for (int p  = o+1; p < numCards; p++) {
                if (current.getRank() == cards[p].getRank()) {
                    paired2 = true;
                }
            }
        }

        if(paired1 && paired2){
            twoPaired = true;
        }

        // Pair
        boolean onePair = false;
        for (int q = 0; q < numCards; q++){
            Card current = cards[q];
            for (int r = q+1; r < numCards; r++) {
                if (current.getRank() == cards[r].getRank()) {
                    onePair = true;
                }
            }
        }
        int count = 0;
        if(onePair){
            count = 1;
            if(twoPaired){
                count = 2;
                if(threePair){
                    count = 3;
                    if(fourPair){
                        count = 5;
                    }
                }
            }
        }
        if(flushed){
            count = 4;
        }
        return count;
    }

    public boolean isBetterHandThan(Hand other){
        boolean better = false;
        if(handType() > other.handType()){
            better = true;
            if (handType() == HIGH_CARD && other.handType() == HIGH_CARD) {
                if(highCard().getValue() > other.highCard().getValue()){
                    better = true;
                }
            }
        }
        return better;
    }

    public String toString(){
        String retString = "[";
        for(int i = 0; i < numCards - 1; i++){
            retString = retString + cards[i].getAbbrev() + ", ";
        }
        retString = retString + cards[numCards-1].getAbbrev();
        retString = retString + "]";
        return retString;
    }
    /*
     * getTotalValue - computes and returns the total of the
     * values of the cards in the hand.
     */
    public int getTotalValue() {
        int value = 0;
        for (int i = 0; i < numCards; i++) {
            value += cards[i].getValue();
        }
        return value;
    }

}
