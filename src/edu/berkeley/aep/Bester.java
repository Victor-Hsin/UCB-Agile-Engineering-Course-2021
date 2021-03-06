package edu.berkeley.aep;

// Find the best out of a set of quantities
public class Bester<T extends Bestable> {
    private final Bestable[] thingsToCompare;

    public Bester(T... thingsToCompare) {
        if (thingsToCompare.length < 1) {
            throw new IllegalArgumentException("You must pass in at least one thing");
        }
        this.thingsToCompare = thingsToCompare;
    }

    public T best() {
        var champion = thingsToCompare[0];
        for (var challenger: thingsToCompare) {
            if (challenger.betterThan(champion)) {
                champion = challenger;
            }
        }
        return (T) champion;
    }
}
