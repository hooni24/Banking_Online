package vo;

import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable {
	private String name;
	private String jumin;
	private String address;
	ArrayList<Account> accList = new ArrayList<Account>();
	
	public Customer(String name, String jumin, String address) {
		this.name = name;
		this.jumin = jumin;
		this.address = address;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getJumin() {
		return jumin;
	}
	
	public void setJumin(String jumin) {
		this.jumin = jumin;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public ArrayList<Account> getAccList() {
		return accList;
	}

	public void setAccList(ArrayList<Account> accList) {
		this.accList = accList;
	}
	
}
