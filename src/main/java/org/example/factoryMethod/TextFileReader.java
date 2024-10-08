package org.example.factoryMethod;

import org.example.LogEntry;
import org.example.LogReader;

import java.io.*;
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
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while((line = br.readLine()) != null) {
                text.add(line);
            }
        } catch (IOException e) {
            System.out.println("Что-то пошло не так");
        }
        return text;
    }

    @Override
    protected LogEntry parseLogEntry(String stringEntry) {
        return new LogEntry(stringEntry);
    }
}
