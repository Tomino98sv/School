package com.company;
/*Tomas Pavlik*/

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
}
