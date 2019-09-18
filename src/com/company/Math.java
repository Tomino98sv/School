package com.company;

public class Math extends Subject {

    public int reverse(int num){
        int newNum=0;
        if (num%10 == 0){
            return 0;
        }
        int negation;

        if (num<0){
            negation=-1;
            num*=-1;
        }else {
            negation=1;
        }

        while(num!=0){
            newNum *= 10;
            newNum += num%10;
            num /= 10;
        }

        return newNum*negation;
    }

    public boolean isPrimeNumber(int number){
        int delitel = 1;
        int count = 1;
        if (number<=1){
            return false;
        }else {
            while(delitel!=number){
                if (number%delitel == 0){
                    count++;
                }
                delitel++;
            }
            return count == 2;
        }
    }
}
