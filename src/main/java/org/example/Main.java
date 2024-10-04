package org.example;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static String str = "Мороз и солнце; день чудесный!\n" +
            "Еще ты дремлешь, друг прелестный -\n" +
            "Пора, красавица, проснись:\n" +
            "Открой сомкнуты негой взоры\n" +
            "Навстречу северной Авроры,\n" +
            "Звездою севера явись!";

    public static void main(String[] args) {
        PoemReader reader = new PoemReader(str);
        Iterable<String> poem = reader.readEntries(3);
        for(String str : poem) {
            System.out.println(str);
        }
    }
}