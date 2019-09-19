package com.company;

import java.util.regex.Pattern;

public class Other {

    public boolean isEuro(String eur){

        return Pattern.matches("^(([0][.|,][0-9]{2})|([1-9]+([.|,][0-9]{2})?))([\\s]?(€|EUR|eur))?$", eur);
    }

}
