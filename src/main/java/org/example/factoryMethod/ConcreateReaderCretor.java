package org.example.factoryMethod;

import org.example.LogReader;
import org.example.PoemReader;

public class ConcreateReaderCretor extends BaseLogReaderCreator{
    @Override
    protected LogReader createLogReaderInstance(LogType logType) {
        return switch (logType) {
            case Poem -> new PoemReader();
            case Text -> new TextFileReader();
            case DataBase -> new DataBaseReader();
        };
    }
}
