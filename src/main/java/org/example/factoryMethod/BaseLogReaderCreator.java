package org.example.factoryMethod;

import org.example.LogReader;

public abstract class BaseLogReaderCreator {

    protected LogReader createLogReader(LogType logType, Object data) {
        LogReader logReader = createLogReaderInstance(logType);
        logReader.setDataSource(data);
        return logReader;
    }

    protected abstract LogReader createLogReaderInstance(LogType logType);
}
