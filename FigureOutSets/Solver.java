package FigureOutSets;

import java.util.ArrayList;
import java.util.List;

public class Solver {
    //Returns a list of sets given the list of cards
    public List<Set> findSets(List<Card> cards) {
        List<Set> validSets = new ArrayList<>();
        for(int i = 0; i < cards.size() - 1; i++) {
            for(int j = i+1; j < cards.size(); j++) {
                Card card2 = findThirdCard(cards.get(i), cards.get(j));

                for(int k = j+1; k < cards.size(); k++) {
                    if(card2.equals(cards.get(k))) {
                        validSets.add(new Set(cards.get(i), cards.get(j), cards.get(k)));
                        break;
                    }
                }
            }
        }

        return validSets;
    }

    //Given two cards, finds the third card that would make a set
    public Card findThirdCard(Card card1, Card card2) {
        return new Card(getThirdProperty(card1, card2, 0),
                getThirdProperty(card1, card2, 1),
                getThirdProperty(card1, card2, 2),
                getThirdProperty(card1, card2, 3));
    }

    //given two properties, finds the third property
    public int getThirdProperty(Card card1, Card card2, int propNum) {
        int prop1 = card1.getProperty(propNum);
        int prop2 = card2.getProperty(propNum);

        if(prop1 == prop2) {
            return prop1;
        }
        else {
            return 3 - prop1 - prop2;
        }
    }
}
