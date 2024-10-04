package org.example.factoryMethod;

import org.example.LogEntry;
import org.example.LogReader;

public class DataBaseReader extends LogReader {
    @Override
    public Object getDataSourse() {
        return null;
    }

    @Override
    public void setDataSource(Object data) {

    }

    @Override
    protected Iterable<String> readEntries(Integer position) {
        return null;
    }

    @Override
    protected LogEntry parseLogEntry(String stringEntry) {
        return null;
    }
}
