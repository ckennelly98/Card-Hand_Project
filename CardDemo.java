public class CardDemo {
    public static void main(String[] args) {

        // Card ranks are 1 (ace), 2, 3, 4, 5, 6, 7, 8, 9, 10,
        // 11 (jack), 12 (queen), 13 (king).

        // Card suits are 0 (diamonds), 1 (hearts), 2 (clubs), 3 (spades).

        // Card values vary according to the game.  Often we use values
        // for ace of 1, for number cards of the same number value,
        // and for face cards of 10.

        // creates a Card object 10 of clubs with value of 10
        Card c1 = new Card(7, 1);
        Card c2 = new Card(11, 3, 10);
        Card c3 = new Card(1, 2);
        Card c4 = new Card(1, 0, 11);
        Card c5 = new Card(11, 3, 11);

        System.out.println("c1: " + c1.toString());
        System.out.println(c1.getRank());
        System.out.println(c1.getSuit());
        System.out.println(c1.getValue());
        System.out.println(c1.getAbbrev());
        System.out.println(c1.isAce());
        System.out.println(c1.isFaceCard());

        System.out.println();

        System.out.println("c2: " + c2.toString());
        System.out.println(c2.getRank());
        System.out.println(c2.getSuit());
        System.out.println(c2.getValue());
        System.out.println(c2.getAbbrev());
        System.out.println(c2.isAce());
        System.out.println(c2.isFaceCard());

        System.out.println();

        System.out.println("c3: " + c3.toString());
        System.out.println(c3.getRank());
        System.out.println(c3.getSuit());
        System.out.println(c3.getValue());
        System.out.println(c3.getAbbrev());
        System.out.println(c3.isAce());
        System.out.println(c3.isFaceCard());

        System.out.println();

        System.out.println("c4: " + c4.toString());
        System.out.println(c4.getRank());
        System.out.println(c4.getSuit());
        System.out.println(c4.getValue());
        System.out.println(c4.getAbbrev());
        System.out.println(c4.isAce());
        System.out.println(c4.isFaceCard());

        System.out.println();

        System.out.println("c5: " + c5.toString());
        System.out.println(c5.getRank());
        System.out.println(c5.getSuit());
        System.out.println(c5.getValue());
        System.out.println(c5.getAbbrev());
        System.out.println(c5.isAce());
        System.out.println(c5.isFaceCard());

        System.out.println();

        System.out.println(c1.equals(c1));
        System.out.println(c1.equals(c2));
        System.out.println(c3.equals(c4));
        System.out.println(c2.equals(c5));
    }
}
