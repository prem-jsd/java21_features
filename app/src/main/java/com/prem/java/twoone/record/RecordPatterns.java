package com.prem.java.twoone.record;

import java.awt.*;

/**
 * todo:: JEP440: Record Patterns
 *
 * todo:: Record patterns enhance the java programming language in order to deconstruct record values. This will
 * todo::  make it easier to navigate into the data
 */
public class RecordPatterns {

    public static void main(String[] args) {

        singleRecordPatternOldStyle();
        singleRecordPattern();
        nestedRecordPattern();

    }

    record GrapeRecord(Color color, Integer nbrOfPits) {}

    private static void singleRecordPatternOldStyle() {
        Object o = new GrapeRecord(Color.BLUE, 2);
        if (o instanceof GrapeRecord grape) {
            System.out.println("This grape has " + grape.nbrOfPits() + " pits.");
        }
    }

    //todo:: With Record Patterns, you can add the record members as part of the instanceof check and access them directly.
    private static void singleRecordPattern() {
        Object o = new GrapeRecord(Color.BLUE, 2);
        if (o instanceof GrapeRecord(Color color, Integer nbrOfPits)) {
            System.out.println("This grape has " + nbrOfPits + " pits.");
        }
    }

    record SpecialGrapeRecord(GrapeRecord grape, boolean special) {}

    private static void nestedRecordPattern() {
        Object o = new SpecialGrapeRecord(new GrapeRecord(Color.BLUE, 2), true);
        if (o instanceof SpecialGrapeRecord(GrapeRecord grape, boolean special)) {
            System.out.println("This grape has " + grape.nbrOfPits() + " pits.");
        }
        if (o instanceof SpecialGrapeRecord(GrapeRecord(Color color, Integer nbrOfPits), boolean special)) {
            System.out.println("This grape has " + nbrOfPits + " pits.");
        }
    }

}
