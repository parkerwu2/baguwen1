package com.papa.baguwen1.baguwen1.algorithm;

//50. Pow(x, n)
public class Solution50 {
    public double myPow(double x, int n) {
        if (n >= 0){
            return sqt(x, n);
        } else {
            return 1.0 / sqt(x, -n);
        }

    }
    public double sqt(double x, int n){
        if (n == 0) {
            return 1.0;
        }
        double y = sqt(x, n / 2);
        if (n % 2 == 0){
            return y * y;
        } else {
            return y * y * x;
        }
    }
}
