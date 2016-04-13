package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import manager.BankingManager;
import vo.Account;
import vo.Customer;

public class BankingClientManager implements BankingManager {
	
	private ObjectInputStream ois;
	private ObjectOutputStream oos;

	public BankingClientManager() {
		try {
			Socket client = new Socket("localhost", 1799);
			ois = new ObjectInputStream(client.getInputStream());
			oos = new ObjectOutputStream(client.getOutputStream());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean signIn(Customer c) {
		Object[] request = {"signI", c};
		boolean result = (boolean) sendReturn(request);
		return result;
	}

	@Override
	public boolean openAccount(Customer c, String accNo) {
		Object[] request = {"openA", c, accNo};
		boolean result = (boolean) sendReturn(request);
		return result;
	}

	@Override
	public Account deposit(String accNo, double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account withdraw(String accNo, double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean transfer(String myAccNo, String targetAccNo, double amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Customer searchCustomerByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer searchCustomerByJumin(String jumin) {
		Object[] request = {"searchCBJ", jumin};
		Customer result = (Customer) sendReturn(request);
		return result;
	}

	@Override
	public Account searchAccountByNo(String accNo) {		//test¡ﬂ..
		Object[] request = {"searchABN", accNo};
		Account result = (Account) sendReturn(request);
		return result;
	}

	@Override
	public ArrayList<Account> searchAccountListByJumin(String jumin) {
		Object[] request = {"searchALBJ", jumin};
		ArrayList<Account> result = (ArrayList<Account>) sendReturn(request);
		return result;
	}

	@Override
	public ArrayList<Account> deleteAccount(String jumin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteCustomer(String jumin) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Customer updateCustomer(String jumin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void printAll() {
		// TODO Auto-generated method stub

	}
	
	public Object sendReturn(Object[] o){
		Object result = null;
		try {
			oos.writeObject(o);
			result = (Object) ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}//sendReturn()

}//class
