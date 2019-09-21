package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        SlovakLang slovakLang = new SlovakLang();
        Other other = new Other();
        English english = new English();
        Math math = new Math();

//        System.out.println(slovakLang.formatText("DnES je PiaTok"));
//        System.out.println(slovakLang.formatText("dNES je streda."));
//        System.out.println(english.translate(null));
//        System.out.println(math.reverse(-203));
//        System.out.println(math.isPrimeNumber(77));
////        for (int a=-2;a<=999;a++){
//            if (math.isPrimeNumberFasterMethod(a)){
//                System.out.println( "PROOCISLO                               =====   " + a+"  :  "+math.isPrimeNumberFasterMethod(a));
//            }else {
//                System.out.println(a+" : "+math.isPrimeNumberFasterMethod(a));
//            }
//        }

        System.out.println(english.cryptingCharThird('Z'));
    }
}

//49 | 91 | 119 | 121 | 133 | 143
