package server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import manager.BankingManager;
import vo.Account;
import vo.Customer;

public class BankingServerManager implements BankingManager {
	private ArrayList<Customer> csList = new ArrayList<>();
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private File file = new File("d:/savedata/banking.ser");		///Users/macbookpro/etc/bank.dat
	
	public BankingServerManager() {
		if(file.exists()){
			csList = getFile();
		}else{
			setFile();
		}
	}//생성자
	
	@Override
	public boolean signIn(Customer customer) {
		csList = getFile();
		for (Customer c : csList) {
			if(c.getJumin().equals(customer.getJumin())){			//주민번호 일치 하면(=중복이면, false반환)
				return false;
			}//if
		}//for										//for문이 끝나도록(전체 리스트 다 돌도록 일치 안하면
		
		csList.add(customer);
		setFile();
		return true;
	}//signIn()

	@Override
	public boolean openAccount(Customer c, String accNo) {
		csList = getFile();
		for (int i = 0; i < c.getAccList().size(); i++) {
			if(c.getAccList().get(i).getAccNo().equals(accNo)){
				return false;										//랜덤생성된 계좌번호가 중복이면.
			}//if
		}//for
		Account a = new Account(accNo, c);
		c.getAccList().add(a);
		setFile();
		return true;
	}//openAccount()

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
		for (Customer c : csList) {
			if(c.getJumin().equals(jumin)){
				return c;						//일치하는 고객 찾으면 그 고객 반환
			}//if
		}//for
		return null;							//못찾으면 null
	}//searchCustomerByJumin()

	@Override
	public Account searchAccountByNo(String accNo) {		//test중...
		for (Customer c : csList) {
			c.getAccList();
			for (int i = 0; i < c.getAccList().size(); i++) {
				if(c.getAccList().get(i).getAccNo().equals(accNo)){
					return c.getAccList().get(i);
				}
			}
		}
		
		return null;
	}

	@Override
	public ArrayList<Account> searchAccountListByJumin(String jumin) {
		Customer target = searchCustomerByJumin(jumin);
		if(target != null){
			ArrayList<Account> result = target.getAccList();
			if(result != null){
				return result;
			}//inner if
		}//outter if
		return null;
	}//searchAccountListByJumin()

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
	
	
	public ArrayList<Customer> getFile(){
		ArrayList<Customer> got = new ArrayList<>();
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			got = (ArrayList<Customer>) ois.readObject();
			ois.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return got;
	}//getFile()
	
	public void setFile(){
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(csList);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//setFile()

}//class
