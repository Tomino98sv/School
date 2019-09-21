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
            temp += cryptingCharSecond(word.charAt(a));
        }
        return temp;
    }


    public char cryptingChar(char input){
        byte firstHalf = (byte) (240&input);
        byte secondHalf = (byte) (15&input);
        secondHalf = (byte) (~secondHalf);
        secondHalf = (byte) (secondHalf&15);

        byte result = (byte) (firstHalf|secondHalf);

        return (char) result;
    }

    public char cryptingCharSecond(char input){
        byte firstHalf = (byte) (240&input);
        byte secondHalf = (byte) (15&input);

        firstHalf = (byte) (firstHalf>>4);
        secondHalf = (byte) (secondHalf<<4);

        byte result = (byte) (firstHalf|secondHalf);
        System.out.println(result);

        return (char) result;
    }

    public char cryptingCharThird(char input){
        //01 01 10 10 = 90 = 'Z'
        //01 10 01 01 = 101 = 'e'

        //01 11 01 10 = 118 = 'v'
        //01 11 10 01 = 121 = 'y'

        //01 10 10 10 = 106 = 'j'
        //01 01 01 01 = 85 = 'U'

        int[] binarCod = convertToBinary(input,8);
        for (int a=binarCod.length;a>2;a=a-2){
            int temp = binarCod[a-1];
            binarCod[a-1]=binarCod[a-2];
            binarCod[a-2]=temp;
        }
        return  (char) convertFromBinary(binarCod);
    }

    private int[] convertToBinary(int number,int bits) {
        int[] binaryArray = new int[bits];
        int sizeCap = (int)java.lang.Math.pow(2.0,bits-1);
        for (int a=0;a<binaryArray.length;a++){
            binaryArray[a] = number/sizeCap;
            number=number-((number/sizeCap)*sizeCap);
            sizeCap/=2;
        }
        return binaryArray;
    }


    private int convertFromBinary(int[] binary){
        int number=0;
        double index=0;
        for (int a=binary.length;a>0;a--){
            number+=Integer.valueOf(binary[a-1])* java.lang.Math.pow(2.0,index);
            index++;
        }
        return number;
    }
}
