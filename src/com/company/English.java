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
}
