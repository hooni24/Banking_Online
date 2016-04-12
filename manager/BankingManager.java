package manager;

import java.util.ArrayList;

import vo.Account;
import vo.Customer;

public interface BankingManager {
	
	public boolean signIn(Customer c);														//회원가입
	public boolean openAccount(Customer c, String accNo);									//계좌개설
		
	public Account deposit(String accNo, double amount);									//입금
	public Account withdraw(String accNo, double amount);									//출금
	public boolean transfer(String myAccNo, String targetAccNo, double amount);				//이체
	
		
	public Customer searchCustomerByName(String name);										//이름으로 Customer 찾기
	public Customer searchCustomerByJumin(String jumin);									//주민번호로 Customer 찾기
	public Account searchAccountByNo(String accNo);											//계좌번호로 Account 찾기  -> 가입시 계좌중복 방지용
	public ArrayList<Account> searchAccountListByJumin(String jumin);						//주민번호로 Account 찾기

	
	public ArrayList<Account> deleteAccount(String jumin);									//계좌 삭제
	public boolean deleteCustomer(String jumin);											//고객 삭제
		

	public Customer updateCustomer(String jumin);											//고객정보 수정 (주민번호 입력받고(본인확인) 원하는 정보 골라 수정)
		
	
	public void printAll();																	//계좌정보 전체 출력 (주민번호 받아서 Key)
}
