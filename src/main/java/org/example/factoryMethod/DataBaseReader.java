package org.example.factoryMethod;

import org.example.LogEntry;
import org.example.LogReader;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseReader extends LogReader {

    private String connectToMysqlAddress;

    @Override
    public Object getDataSourse() {
        return null;
    }

    @Override
    public void setDataSource(Object data) {
        this.connectToMysqlAddress = data.toString();
    }

    @Override
    protected Iterable<String> readEntries(Integer position) {
        Connection connection = connectToMysql(connectToMysqlAddress);
        useDb(connection);


        return readLog(connection);
    }

    @Override
    protected LogEntry parseLogEntry(String stringEntry) {
        return new LogEntry(stringEntry);
    }

    private Connection connectToMysql(String address) {
        try {
            Connection connection = DriverManager.getConnection(address);
            System.out.println("Подключение к MySQL прошло успешно");
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void useDb(Connection con) {
        String useDb = "USE pet_project;";

        try {
            try (PreparedStatement statement = con.prepareStatement(useDb)) {
                statement.execute();
            }
        } catch (SQLException e) {

        }
    }

    private List<String> readLog(Connection con) {
        String worker = null;
        List<String> workers = new ArrayList<>();
        String readLog = "SELECT * FROM human;";
        try {
            try (PreparedStatement statement = con.prepareStatement(readLog)) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String post = resultSet.getString(3);
                    worker = id + ", " + name + ", " + post;
                    workers.add(worker);
                    worker = null;
                }
            }
        } catch (SQLException e) {
            System.out.println("ups");
        }
        return workers;
    }

}
