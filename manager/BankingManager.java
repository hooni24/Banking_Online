package manager;

import java.util.ArrayList;

import vo.Account;
import vo.Customer;

public interface BankingManager {
	
	public boolean signIn(Customer c);														//ȸ������
	public boolean openAccount(Customer c, String accNo);									//���°���
		
	public Account deposit(String accNo, double amount);									//�Ա�
	public Account withdraw(String accNo, double amount);									//���
	public boolean transfer(String myAccNo, String targetAccNo, double amount);				//��ü
	
		
	public Customer searchCustomerByName(String name);										//�̸����� Customer ã��
	public Customer searchCustomerByJumin(String jumin);									//�ֹι�ȣ�� Customer ã��
	public Account searchAccountByNo(String accNo);											//���¹�ȣ�� Account ã��  -> ���Խ� �����ߺ� ������
	public ArrayList<Account> searchAccountListByJumin(String jumin);						//�ֹι�ȣ�� Account ã��

	
	public ArrayList<Account> deleteAccount(String jumin);									//���� ����
	public boolean deleteCustomer(String jumin);											//�� ����
		

	public Customer updateCustomer(String jumin);											//������ ���� (�ֹι�ȣ �Է¹ް�(����Ȯ��) ���ϴ� ���� ��� ����)
		
	
	public void printAll();																	//�������� ��ü ��� (�ֹι�ȣ �޾Ƽ� Key)
}
