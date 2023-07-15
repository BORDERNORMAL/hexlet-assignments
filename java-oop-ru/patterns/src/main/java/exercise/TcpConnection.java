package exercise;
import exercise.connections.Connected;
import exercise.connections.Connection;
import exercise.connections.Disconnected;

import java.util.List;
import java.util.ArrayList;

// BEGIN
public class TcpConnection implements Connection {
    private Connection connection;
    private String ip;
    private int port;

    public TcpConnection(String ip, int port) {
        this.ip = ip;
        this.port = port;
        this.connection = new Disconnected(this);
    }

    public String getCurrentState() {
        return this.connection.getCurrentState();
    }

    public void connect() {
        this.connection.connect();
    }

    public void disconnect() {
        this.connection.disconnect();
    }

    public void write(String data) {
        this.connection.write(data);
    }

    public void setState(Connection connection) {
        this.connection = connection;
    }
}
// END
