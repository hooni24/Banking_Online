package vo;

import java.io.Serializable;

public class Account implements Serializable{
	String accNo;
	double balance;
	Customer owner;
	
	public Account(String accNo, Customer owner) {			//잔고는 자동으로 0이기만 함.
		this.accNo = accNo;
		this.owner = owner;
	}

	public String getAccNo() {
		return accNo;
	}
	
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Customer getOwner() {
		return owner;
	}
	
	public void setOwner(Customer owner) {
		this.owner = owner;
	}
	
	public void showInfo(){
		System.out.printf("예금주 : %s, 계좌번호 : %d, 잔액 : %f", owner.getName(), accNo, balance);
	}
	

}
