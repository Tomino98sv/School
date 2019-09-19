package com.company;

/*Tomas Pavlik*/

public class English extends Subject {

    public String translate(String animal){
        if (animal != null){
            animal = animal.toLowerCase();
        }else {
            animal = "";
        }

        switch (animal){
            case "pes":
                animal = "dog";
                break;
            case "macka":
                animal = "cat";
                break;
            case "kohut":
                animal = "dick";
                break;
            case "kon":
                animal = "horse";
                break;
            case "mys":
                animal = "mouse";
                break;
            case "lev":
                animal = "lion";
                break;
            case "havran":
                animal = "raven";
                break;
            case "orol":
                animal = "eagle";
                break;
             default:
                 animal = "not recognize";
                 break;
        }

        return animal;
    }

    public String cryptingWord(String  word){
        String temp = "";
        for (int a=0;a<word.length();a++){
            System.out.println(" current char "+word.charAt(a));
            temp += cryptingChar(word.charAt(a));
        }
        return temp;
    }


    public char cryptingChar(char input){
        System.out.println("number "+(byte)input);
        byte firstHalf = (byte) (240&input);
        byte secondHalf = (byte) (15&input);
        System.out.println("fistHalf: "+firstHalf+"secondHalf: "+secondHalf);
        secondHalf = (byte) (secondHalf<<4);
        secondHalf = (byte) (~secondHalf);
        secondHalf = (byte) (secondHalf>>4);
        secondHalf = (byte) (secondHalf&15);

        System.out.println("SecondHalf RESULT: "+secondHalf);

        int result = (byte) (firstHalf|secondHalf);

        System.out.println("current result char "+result);
        return (char) result;
    }

    //prijme char a zmeni posledneho jeho bytove cisla (01101010) = (01100101) a vrati vysledny znak
    //240 = 1111 0000
    //15 = 0000 1111
}
