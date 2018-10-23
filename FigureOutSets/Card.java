package FigureOutSets;

import java.util.Objects;

public class Card {
    public static final int ONE_THING = 0, TWO_THINGS = 1, THREE_THINGS = 2;
    public static final int GREEN = 0, PURPLE = 1, RED = 2;
    public static final int CIRCLE = 0, SQUIGGLE = 1, DIAMOND = 2;
    public static final int EMPTY = 0, SEMI = 1, FILLED = 2;

    private static final int PROP_NUM = 0, PROP_COLOR = 1, PROP_SHAPE = 2, PROP_SHADING = 3;

    private int numThings;
    private int color;
    private int shape;
    private int shading;

    public Card(int numThings, int color, int shape, int shading) {
        this.numThings = numThings;
        this.color = color;
        this.shape = shape;
        this.shading = shading;
    }

    public int getProperty(int propertyNum) {
        switch (propertyNum) {
            case PROP_NUM: return getNumThings();
            case PROP_COLOR: return getColor();
            case PROP_SHAPE: return getShape();
            case PROP_SHADING: return getShading();
            default: return -1;
        }
    }

    public int getNumThings() {
        return numThings;
    }

    public String getNumThingsStr() {
        return "" + (numThings+1);
    }

    public int getColor() {
        return color;
    }

    public String getColorStr() {
        switch (color) {
            case GREEN: return "Green";
            case PURPLE: return "Purple";
            case RED: return "Red";
            default: return "Oof";
        }
    }

    public int getShape() {
        return shape;
    }

    public String getShapeStr() {
        switch (shape) {
            case CIRCLE: return "Circle";
            case SQUIGGLE: return "Squiggle";
            case DIAMOND: return "Diamond";
            default: return "Oof";
        }
    }

    public int getShading() {
        return shading;
    }

    public String getShadingStr() {
        switch (shading) {
            case EMPTY: return "Empty";
            case SEMI: return "Semi";
            case FILLED: return "Filled";
            default: return "Oof";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return numThings == card.numThings &&
                color == card.color &&
                shape == card.shape &&
                shading == card.shading;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numThings, color, shape, shading);
    }

    @Override
    public String toString() {
        return "Card{" +
                "numThings=" + getNumThingsStr() +
                ", color=" + getColorStr() +
                ", shape=" + getShapeStr() +
                ", shading=" + getShadingStr() +
                '}';
    }
}
