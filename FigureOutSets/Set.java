package FigureOutSets;

import java.util.Objects;

public class Set {
    private Card card0;
    private Card card1;
    private Card card2;

    public Set(Card card0, Card card1, Card card2) {
        this.card0 = card0;
        this.card1 = card1;
        this.card2 = card2;
    }

    public Card getCard0() {
        return card0;
    }

    public Card getCard1() {
        return card1;
    }

    public Card getCard2() {
        return card2;
    }

    @Override
    public String toString() {
        return "Set{" +
                "\n\tcard0=" + card0 +
                "\n\tcard1=" + card1 +
                "\n\tcard2=" + card2 +
                "\n}";
    }

    public boolean isValidSet() {
        for(int i = 0; i < 4; i++) {
            if(!propertyAllDifferent(i) && !propertyAllSame(i)) {
                return false;
            }
        }

        return true;
    }

    private boolean propertyAllDifferent(int propNum) {
        if(card0.getProperty(propNum) == 0) {
            if(card1.getProperty(propNum) == 1 && card2.getProperty(propNum) == 2) {
                return true;
            }
            if(card2.getProperty(propNum) == 1 && card1.getProperty(propNum) == 2) {
                return true;
            }
        }
        if(card1.getProperty(propNum) == 0) {
            if(card0.getProperty(propNum) == 1 && card2.getProperty(propNum) == 2) {
                return true;
            }
            if(card2.getProperty(propNum) == 1 && card0.getProperty(propNum) == 2) {
                return true;
            }
        }

        if(card2.getProperty(propNum) == 0) {
            if(card1.getProperty(propNum) == 1 && card0.getProperty(propNum) == 2) {
                return true;
            }
            if(card0.getProperty(propNum) == 1 && card1.getProperty(propNum) == 2) {
                return true;
            }
        }

        return false;
    }

    private boolean propertyAllSame(int propNum) {
        if(card0.getProperty(propNum) == 0 &&
                card1.getProperty(propNum) == 0 &&
                card2.getProperty(propNum) == 0) {
                return true;
        }

        if(card0.getProperty(propNum) == 1 &&
                card1.getProperty(propNum) == 1 &&
                card2.getProperty(propNum) == 1) {
            return true;
        }

        if(card0.getProperty(propNum) == 2 &&
                card1.getProperty(propNum) == 2 &&
                card2.getProperty(propNum) == 2) {
            return true;
        }

        return false;
    }
}
