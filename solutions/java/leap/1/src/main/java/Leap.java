class Leap {

    boolean isLeapYear(int year) {
        /**
        * Every year divisible by 4...
        * EXCEPT years divisible by 100...
        * UNLESS they are also divisible by 400.
        */
        return (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0);
    }

}
