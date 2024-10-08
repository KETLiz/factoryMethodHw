package org.example.factoryMethod;

import org.example.LogEntry;
import org.example.LogReader;
import org.example.PoemReader;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static String str = "Мороз и солнце; день чудесный!\n" +
            "Еще ты дремлешь, друг прелестный -\n" +
            "Пора, красавица, проснись:\n" +
            "Открой сомкнуты негой взоры\n" +
            "Навстречу северной Авроры,\n" +
            "Звездою севера явись!";

    static String fileName = "C:\\Users\\Liza\\IdeaProjects\\Architecture\\factoryMethodHw\\" +
            "src\\main\\java\\org\\example\\factoryMethod\\file.txt";

    static String connectToMysqlAddress = "jdbc:mysql://localhost:3306?user=root&password=qwer";

    public static void main(String[] args) throws IOException, SQLException {

        LogReader reader = new ConcreateReaderCretor()
                .createLogReader(LogType.Poem, str);

        for(LogEntry log : reader.readLogEntry()) {
            System.out.println(log.getText());
        }

        System.out.println();

        LogReader reader2 = new ConcreateReaderCretor()
                .createLogReader(LogType.Text, fileName);

        Iterable<LogEntry> log = reader2.readLogEntry();

        for(LogEntry l : log) {
            System.out.println(l.getText());
        }

        System.out.println();

        LogReader dbReader = new ConcreateReaderCretor()
                .createLogReader(LogType.DataBase, connectToMysqlAddress);

        Iterable<LogEntry> dbLog = dbReader.readLogEntry();

        for(LogEntry l : dbLog) {
            System.out.println(l.getText());
        }

    }
}
