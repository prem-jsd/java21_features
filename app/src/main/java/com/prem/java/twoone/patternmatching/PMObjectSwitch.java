package com.prem.java.twoone.patternmatching;

public class PMObjectSwitch {

    public static void main(String[] args) {
        //todo:: old style
//        oldStylePatternMatching(Object obj)
        oldStylePatternMatching("PK");
        oldStylePatternMatching(123456);
        oldStylePatternMatching(-87.9);

        //todo:: new style
        patternMatchingSwitch("PK");
        patternMatchingSwitch(123456);
        patternMatchingSwitch(-87.9);


        //todo:: old style switch for null
//        oldStyleSwitchNull(Object obj)
        oldStyleSwitchNull(null);

//        switchNull(Object obj)
        switchNull(null);
    }

    private static void oldStylePatternMatching(Object obj) {
        if (obj instanceof Integer i) {
            System.out.println("Object is an integer:" + i);
        } else if (obj instanceof String s) {
            System.out.println("Object is a string:" + s);
        } else if (obj instanceof FruitType f) {
            System.out.println("Object is a fruit: " + f);
        } else {
            System.out.println("Object is not recognized");
        }
    }

    private static void patternMatchingSwitch(Object obj) {
        switch(obj) {
            case Integer i   -> System.out.println("Object is an integer:" + i);
            case String s    -> System.out.println("Object is a string:" + s);
            case FruitType f -> System.out.println("Object is a fruit: " + f);
            default -> System.out.println("Object is not recognized");
        }
    }

    enum  FruitType {
        APPLE, AVOCADO, PEAR, ORANGE;

        String type;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    private static void oldStyleSwitchNull(Object obj) {
        try {
            switch (obj) {
                case Integer i -> System.out.println("Object is an integer:" + i);
                case String s -> System.out.println("Object is a string:" + s);
                case FruitType f -> System.out.println("Object is a fruit: " + f);
                default -> System.out.println("Object is not recognized");
            }
        } catch (NullPointerException npe) {
            System.out.println("NullPointerException thrown");
        }
    }

    private static void switchNull(Object obj) {
        switch (obj) {
            case Integer i -> System.out.println("Object is an integer:" + i);
            case String s -> System.out.println("Object is a string:" + s);
            case FruitType f -> System.out.println("Object is a fruit: " + f);
            case null -> System.out.println("Object is null");
            default -> System.out.println("Object is not recognized");
        }
    }


    private static void inefficientCaseRefinement(Object obj) {
        switch (obj) {
            case String s -> System.out.println("Object is a string:" + s);
            case FruitType f -> {
                if (f == FruitType.APPLE) {
                    System.out.println("Object is an apple");
                }
                if (f == FruitType.AVOCADO) {
                    System.out.println("Object is an avocado");
                }
                if (f == FruitType.PEAR) {
                    System.out.println("Object is a pear");
                }
                if (f == FruitType.ORANGE) {
                    System.out.println("Object is an orange");
                }
            }
            case null -> System.out.println("Object is null");
            default -> System.out.println("Object is not recognized");
        }
    }

    //todo:: This type of problem is solved by allowing when-clauses in switch blocks to
    // specify guards to pattern case labels. The case label is called a guarded case label and the boolean expression is called the guard
    private static void caseRefinement(Object obj) {
        switch (obj) {
            case String s -> System.out.println("Object is a string:" + s);
            case FruitType f when (f == FruitType.APPLE) -> {
                System.out.println("Object is an apple");
            }
            case FruitType f when (f == FruitType.AVOCADO) -> {
                System.out.println("Object is an avocado");
            }
            case FruitType f when (f == FruitType.PEAR) -> {
                System.out.println("Object is a pear");
            }
            case FruitType f when (f == FruitType.ORANGE) -> {
                System.out.println("Object is an orange");
            }
            case null -> System.out.println("Object is null");
            default -> System.out.println("Object is not recognized");
        }
    }

}
