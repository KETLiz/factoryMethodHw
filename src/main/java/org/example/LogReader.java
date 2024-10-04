package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Основа работы алгоритма чтения данных
 */
public abstract class LogReader {
    private int currentPosition = 0;

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setDataPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Iterable<LogEntry> readLogEntry() {
        List<LogEntry> logList = new ArrayList<>();
        for(String str : readEntries(currentPosition)) {
            logList.add(parseLogEntry(str));
        }
        return logList;
    }

    public abstract Object getDataSourse();

    public abstract void setDataSource(Object data);

    protected abstract Iterable<String> readEntries(Integer position);

    protected abstract LogEntry parseLogEntry(String stringEntry);

}
