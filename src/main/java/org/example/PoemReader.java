package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PoemReader extends LogReader{

    private String poemText;

    public PoemReader(String poemText) {
        this.poemText = poemText;
    }


    public PoemReader() {
    }

    @Override
    public Object getDataSourse() {
        return poemText;
    }

    @Override
    public void setDataSource(Object data) {
        this.poemText = data.toString();
    }

    @Override
    protected Iterable<String> readEntries(Integer position) {
        Scanner sc = new Scanner(poemText);
        List<String> logList = new ArrayList<>();
        int count = 0;

        while(sc.hasNextLine()) {
            count++;
            if(count >= position) {
                position = count;
                String line = sc.nextLine();
                logList.add(line);
            } else {
                sc.nextLine();
            }
        }
        return logList;
    }

    @Override
    protected LogEntry parseLogEntry(String stringEntry) {
        return new LogEntry(stringEntry);
    }
}
