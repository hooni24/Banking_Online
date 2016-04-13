package vo;

import java.io.Serializable;

public class Account implements Serializable{
	String accNo;
	double balance;
	Customer owner;
	
	public Account(String accNo, Customer owner) {			//�ܰ�� �ڵ����� 0�̱⸸ ��.
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
		System.out.printf("������ : %s, ���¹�ȣ : %d, �ܾ� : %f", owner.getName(), accNo, balance);
	}
	

}
