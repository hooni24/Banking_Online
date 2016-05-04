package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import common.BankData;

public class ServerThread implements Runnable {
	private Socket client;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private BankData data;
	private static ArrayList<ServerThread> thList = new ArrayList<>();
	private ServerManager mgr = new ServerManager();

	public ServerThread(Socket client) {
		this.client = client;
		try {
			oos = new ObjectOutputStream(client.getOutputStream());
			ois = new ObjectInputStream(client.getInputStream());
			thList.add(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//constructor

	@Override
	public void run() {
		try {
			data = (BankData) ois.readObject();
			
			switch(data.getCommand()){
			case BankData.SIGN_UP :
				
				break;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}//run()
	
}//class
