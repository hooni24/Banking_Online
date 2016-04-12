package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import vo.Account;
import vo.Customer;

public class BankingServer {
	private static ObjectOutputStream oos;
	private static ObjectInputStream ois;

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(1799);
			BankingServerManager serverMgr = new BankingServerManager();
			System.out.println("server opened!!!");
			
			while(true){
				System.out.println("waiting client...");
				Socket client = server.accept();
				System.out.println("connected!! clientIP :" + client.getInetAddress());
				oos = new ObjectOutputStream(client.getOutputStream());
				ois = new ObjectInputStream(client.getInputStream());
				
				while(true){
					Object[] request = (Object[]) ois.readObject();
					String cmdValue = (String) request[0];
					
					switch (cmdValue) {
					case "signI":
						boolean result1 = serverMgr.signIn((Customer) request[1]);
						oos.writeObject(result1);
						break;
					case "openA":
						boolean result2 = serverMgr.openAccount((Customer) request[1], (String) request[2]);
						oos.writeObject(result2);
						break;
					case "deposit":
						break;
					case "withdraw":
						break;
					case "transfer":
						break;
					case "searchCBN":
						break;
					case "searchCBJ":
						Customer result7 = serverMgr.searchCustomerByJumin((String) request[1]);
						oos.writeObject(result7);
						break;
					case "searchALBJ":
						ArrayList<Account> result8 = serverMgr.searchAccountListByJumin((String) request[1]);
						oos.writeObject(result8);
						break;
					case "deleteA":
						break;
					case "deleteC":
						break;
					case "updateC":
						break;
					case "printA":
						break;
					case "searchABN":			//test¡ﬂ...
						Account result22 = serverMgr.searchAccountByNo((String) request[1]);
						oos.writeObject(result22);
						break;
					default:
					}//switch					
				}//inner while
			}//outter while
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//try-catch
	}//main
}//class
