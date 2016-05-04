package server;

public class ServerMain {
	public static void main(String[] args) {
		new Thread(new ServerGUI()).start();
	}

}
