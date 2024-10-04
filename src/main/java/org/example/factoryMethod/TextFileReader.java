package org.example.factoryMethod;

import org.example.LogEntry;
import org.example.LogReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextFileReader extends LogReader {

    String fileName;

    public TextFileReader() {

    }

    @Override
    public Object getDataSourse() {
        return fileName;
    }

    @Override
    public void setDataSource(Object data) {
        this.fileName = data.toString();
    }

    @Override
    protected Iterable<String> readEntries(Integer position) {
        List<String> text = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File(fileName));
            while(sc.hasNextLine()) {
                text.add(sc.nextLine());
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Файл с именем " + fileName + " не найден");
        }
        return text;
    }

    @Override
    protected LogEntry parseLogEntry(String stringEntry) {
        return new LogEntry(stringEntry);
    }
}
