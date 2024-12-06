
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand implements Comparable<Hand> {
    private List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void add(Card card) {
        cards.add(card);
    }

    public void print() {
        for (Card card : cards) {
            System.out.println(card);
        }
    }

    public void sort() {
        Collections.sort(cards);
    }

    public void sortBySuit() {
        Collections.sort(cards, new BySuitInValueOrder());
    }

    @Override
    public int compareTo(Hand other) {
        int sum1 = cards.stream().mapToInt(Card::getValue).sum();
        int sum2 = other.cards.stream().mapToInt(Card::getValue).sum();
        return Integer.compare(sum1, sum2);
    }
}
