package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Connected implements Connection {
    private TcpConnection connection;

    public Connected(TcpConnection connection) {
        this.connection = connection;
    }

    @Override
    public void disconnect() {
        this.connection.setState(new Disconnected(this.connection));
    }

    @Override
    public void connect() {
        System.out.println("Error");
    }

    @Override
    public void write(String data) {

    }

    @Override
    public String getCurrentState() {
        return "connected";
    }
}
// END
