package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        SlovakLang slovakLang = new SlovakLang();
//        System.out.println(slovakLang.formatText("DnES je PiaTok"));
//        System.out.println(slovakLang.formatText("dNES je streda."));
        English english = new English();
//        System.out.println(english.translate(null));
        Math math = new Math();
//        System.out.println(math.reverse(-203));
//        System.out.println(math.isPrimeNumber(77));
////        for (int a=-2;a<=999;a++){
//            if (math.isPrimeNumberFasterMethod(a)){
//                System.out.println( "PROOCISLO                               =====   " + a+"  :  "+math.isPrimeNumberFasterMethod(a));
//            }else {
//                System.out.println(a+" : "+math.isPrimeNumberFasterMethod(a));
//            }
//        }

        Other other = new Other();
//        System.out.println("0,52 € "+" "+other.isEuro("0,52 €"));
//        System.out.println("0,00 € "+" "+other.isEuro("0,00 €"));

        System.out.println(english.cryptingWord("K"));
        System.out.println("second code: "+english.cryptingWord("trieda"));

    }
}

//49 | 91 | 119 | 121 | 133 | 143
