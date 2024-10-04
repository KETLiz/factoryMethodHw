package org.example.factoryMethod;

import org.example.LogEntry;
import org.example.LogReader;
import org.example.PoemReader;

import java.util.List;

public class Main {

    static String str = "Мороз и солнце; день чудесный!\n" +
            "Еще ты дремлешь, друг прелестный -\n" +
            "Пора, красавица, проснись:\n" +
            "Открой сомкнуты негой взоры\n" +
            "Навстречу северной Авроры,\n" +
            "Звездою севера явись!";

    static String fileName = "factoryMethodHw/src/main/org/example/file.txt";

    public static void main(String[] args) {

//        LogReader reader = new ConcreateReaderCretor()
//                .createLogReader(LogType.Poem, str);
//
//        for(LogEntry log : reader.readLogEntry()) {
//            System.out.println(log.getText());
//        }

        System.out.println();

        LogReader reader2 = new ConcreateReaderCretor()
                .createLogReader(LogType.Text, fileName);

        for(LogEntry log : reader2.readLogEntry()) {
            System.out.println(log.getText());
        }
    }
}
