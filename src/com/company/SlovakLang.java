package com.company;
/*Tomas Pavlik*/

public class SlovakLang extends Subject{

    public String formatText(String text){
        String newText = String.valueOf(text.toUpperCase().charAt(0));
        for (int a=1;a<text.length();a++){
            newText += String.valueOf(text.toLowerCase().charAt(a));
        }

        if (!(newText.charAt(newText.length()-1) == '!' || newText.charAt(newText.length()-1) == '.' || newText.charAt(newText.length()-1) == '?')){
            newText += '.';
        }

        return newText;
    }
}
