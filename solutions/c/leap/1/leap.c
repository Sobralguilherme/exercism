#include "leap.h"
#include <stdbool.h>

bool leap_year(int year) {
    // A year is a leap year if it is divisible by 4
    // AND (not divisible by 100 OR divisible by 400)
    if (year % 4 == 0) {
        if (year % 100 !=0 || year % 400 == 0){
            return true;
        }
    }
    return false;
}