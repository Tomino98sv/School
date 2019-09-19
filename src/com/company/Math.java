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

    public boolean isPrimeNumber(int number){
        int delitel = 1;
        int count = 1;

        int countSteps = 0;

        if (number<=1){
            System.out.println("Count of Steps is : "+countSteps);
            return false;
        }else {
            while(delitel!=number){
                countSteps++;
                if (number%delitel == 0){
                    count++;
                }
                delitel++;
            }
            System.out.println("Count of Steps is : "+countSteps);
            return count == 2;
        }
    }

    public boolean isPrimeNumberFasterMethod(int numb){
        if (numb<=1){ return false; }
        else if(numb % 2 == 0 && numb!=2){ return false; }
        else if(numb % 5 == 0 && numb!=5){ return false; }
        int count=0;
        int tempNum = numb;
        while (tempNum!=0){
            count+=tempNum%10;
            tempNum /=10;
        }
        if (count%3 == 0 && numb!=3){ return false; }
        if (numb == 2 || numb == 3 || numb == 5 || numb%11 ==0 || numb%13 == 0){ return true; }

//        if (numb % 2 ==1){return true;}

        int delitel =1;
        int countSteps=1;

        System.out.println("USING WHILE ");
        while(delitel!=numb){
            if (numb%delitel == 0){
                countSteps++;
            }
            delitel++;
        }
        return countSteps == 2;
    }
}
