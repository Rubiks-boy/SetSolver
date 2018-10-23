package FigureOutSets;

import java.util.ArrayList;
import java.util.List;

public class TestManualCardList {
    public static void main (String [] args) {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.ONE_THING, Card.RED, Card.SQUIGGLE, Card.EMPTY));
        cards.add(new Card(Card.THREE_THINGS, Card.RED, Card.CIRCLE, Card.FILLED));
        cards.add(new Card(Card.TWO_THINGS, Card.GREEN, Card.CIRCLE, Card.EMPTY));
        cards.add(new Card(Card.THREE_THINGS, Card.GREEN, Card.CIRCLE, Card.FILLED));
        cards.add(new Card(Card.ONE_THING, Card.GREEN, Card.DIAMOND, Card.EMPTY));
        cards.add(new Card(Card.ONE_THING, Card.RED, Card.SQUIGGLE, Card.FILLED));
        cards.add(new Card(Card.TWO_THINGS, Card.RED, Card.SQUIGGLE, Card.FILLED));
        cards.add(new Card(Card.ONE_THING, Card.RED, Card.SQUIGGLE, Card.EMPTY));
        cards.add(new Card(Card.ONE_THING, Card.GREEN, Card.CIRCLE, Card.SEMI));
        cards.add(new Card(Card.THREE_THINGS, Card.GREEN, Card.SQUIGGLE, Card.EMPTY));
        cards.add(new Card(Card.TWO_THINGS, Card.GREEN, Card.SQUIGGLE, Card.FILLED));
        cards.add(new Card(Card.THREE_THINGS, Card.GREEN, Card.SQUIGGLE, Card.FILLED));

        Solver solver = new Solver();
        List<Set> sets = solver.findSets(cards);

        System.out.println("Number of sets found: " + sets.size());

        for(Set set : sets) {
            System.out.println(set.toString());
        }
    }
}
