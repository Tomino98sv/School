package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        SlovakLang slovakLang = new SlovakLang();
        System.out.println(slovakLang.formatText("DnES je PiaTok"));
        System.out.println(slovakLang.formatText("dNES je streda."));
        English english = new English();
        System.out.println(english.translate(null));
        Math math = new Math();
        System.out.println(math.reverse(-203));
        System.out.println("Prime number "+math.isPrimeNumber(997));
    }
}
