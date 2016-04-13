package client;

import java.util.ArrayList;
import java.util.Scanner;

import vo.Account;
import vo.Customer;

public class BankingUI {
	BankingClientManager clientMgr = new BankingClientManager();
	Scanner sc = new Scanner(System.in);

	public BankingUI(){
		while(true){
			String num = showMainMenu();
			switch(num){
			case "1":
				num = showSignInMenu();
				switch(num){
				case "1"://�ű�ȸ��
					newCustomerMenu();
					break;
				case "2"://����ȸ��
					newAccountMenu();
					break;
				case "3"://�����޴�
					break;
				default:
					System.out.println("��ȣ�� ��Ȯ�� �Է��ϼ���.(ȸ�����Ը޴�)");
				}//ȸ������ switch
				break;
			case "2":
				num = showBankingMenu();
				switch(num){
				case "1"://�Ա�
					break;
				case "2"://���
					break;
				case "3"://��ü
					break;
				case "4"://�����޴�
					break;
				default:
					System.out.println("��ȣ�� ��Ȯ�� �Է��ϼ���.(��������޴�)");
				}//������� switch
				break;
			case "3":
				num = checkMenu();
				switch(num){
				case "1"://��������ȸ
					searchCustomerByJumin();
					break;
				case "2"://������ȸ
					searchAccountListByJumin();
					break;
				case "3"://�����޴�
					break;
				default:
						System.out.println("��ȣ�� ��Ȯ�� �Է��ϼ���.(��ȸ�޴�)");
				}//��ȸ switch
				break;
			case "4":
				num = deleteMenu();
				switch(num){
				case "1"://������
					break;
				case "2"://���»���
					break;
				case "3"://�����޴�
					break;
				default:
						System.out.println("��ȣ�� ��Ȯ�� �Է��ϼ���.(�����޴�)");
				}//���� switch
				break;
			case "5"://����������
				break;
			case "99":
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
			default:
				System.out.println("��ȣ�� ��Ȯ�� �Է��ϼ���.(����)");
			}//���θ޴� switch
		}//while���ѷ���
	}//������
	
	
	public String showMainMenu(){
		System.out.printf("%n=====�η縶�� ����=====%n");
		System.out.println(" 1.���°���");				//1.�ű�ȸ��(signIn) 2.����ȸ��(openAccount)
		System.out.println(" 2.�������");				//1.�Ա� 2.��� 3.��ü
		System.out.println(" 3.��ȸ");					//1.��������ȸ(�ֹι�ȣ�� ã�Ƽ� ������,������������ ��ȸ) 2.�ܾ���ȸ(�ֹι�ȣ�� ������ȸ)
		System.out.println(" 4.����");					//1.������ 2.���»���
		System.out.println(" 5.����������");			//�ֹι�ȣ �޾Ƽ� Ÿ���� ���ϰ� �� ��� ������ �ѹ��� ��� ����
		System.out.println("99.���α׷�����");
		System.out.printf("%n��ȣ�� �����ϼ��� >" );
		String input = sc.nextLine();

		return input;
	}//showMainMenu()
	
	public String showSignInMenu(){
		System.out.printf("%n=====ȸ������=====%n");
		System.out.println(" 1.�ű�ȸ��");
		System.out.println(" 2.����ȸ��");
		System.out.println(" 3.�����޴���");
		System.out.printf("%n��ȣ�� �����ϼ��� >");
		String input = sc.nextLine();
		
		return input;
	}//showSignInMenu()
	
	public void newCustomerMenu(){
		System.out.println("ȸ�������� �����մϴ�.");
		System.out.print("�̸��� �Է��ϼ��� >");
		String name = sc.nextLine();
		System.out.print("�ֹι�ȣ�� �Է��ϼ��� >");
		String jumin = sc.nextLine();
		System.out.print("�ּҸ� �Է��ϼ��� >");
		String address = sc.nextLine();
		Customer c = new Customer(name, jumin, address);
		boolean result = clientMgr.signIn(c);
		
		if(result){
			System.out.println("ȸ�����Կ� �����Ͽ����ϴ�.");
		}else {
			System.out.println("�ֹι�ȣ�� �ߺ��Ǿ����ϴ�.");
		}
	}//newCustomerMenu()
	
	public void newAccountMenu(){
		System.out.println("���°����� �����մϴ�.");
		System.out.print("�ֹι�ȣ�� �Է��ϼ��� >");
		String jumin = sc.nextLine();
		
		Customer findResult = clientMgr.searchCustomerByJumin(jumin);
		
		if(findResult != null){
			boolean result;
			String accNo;
			do{
			int accNoint = (int) (Math.random()*99999) + 1; 
				accNo = String.format("%05d", accNoint); 
				result = clientMgr.openAccount(findResult, accNo);			//�̰� true�� ��������, false�� ������ȣ�ߺ����� ���� ����. ��� ������ ���� �ø���?
			}while(!result);
			System.out.printf("����� ���´� %s�Դϴ�.%n", accNo);
			System.out.println("���»����� �Ϸ�Ǿ����ϴ�.");
		}else {
			System.out.println("�������� �ʴ� ȸ���Դϴ�.");
		}
	}//newAccountMenu()

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String showBankingMenu(){
		System.out.printf("%n=====�������=====%n");
		System.out.println(" 1.�Ա�");
		System.out.println(" 2.���");
		System.out.println(" 3.��ü");
		System.out.println(" 4.�����޴���");
		System.out.printf("%n��ȣ�� �����ϼ��� >");
		String input = sc.nextLine();
		
		return input;
	}//showBankingMenu()
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String checkMenu(){
		System.out.printf("%n=====��ȸ�޴�=====%n");
		System.out.println(" 1.��������ȸ");
		System.out.println(" 2.������ȸ");
		System.out.println(" 3.�����޴���");
		System.out.printf("%n��ȣ�� �����ϼ��� >");
		String input = sc.nextLine();
		
		return input;
	}//checkMenu()
	
	public void searchCustomerByJumin(){
		System.out.print("��ȸ�� �ֹι�ȣ�� �Է��ϼ��� >");
		String jumin = sc.nextLine();
		Customer result = (Customer) clientMgr.searchCustomerByJumin(jumin);
		if(result != null){
			result.showInfo();
		}else {
			System.out.println("ã�� ����� �����ϴ�.");
		}//if-else
	}//searchCustomerByJumin()
	
	public void searchAccountListByJumin(){
		System.out.print("��ȸ�� �ֹι�ȣ�� �Է��ϼ��� >");
		String jumin = sc.nextLine();
		ArrayList<Account> result = clientMgr.searchAccountListByJumin(jumin);
		
		if(result != null){
			for (Account a : result) {
				a.showInfo();
			}
		}else {
			System.out.println("ã�� ����� �����ϴ�.");
		}
	}//searchAccountListByJumin
	
	public void searchTest(){
		System.out.println("��ȸ�� ���¹�ȣ�� �Է��ϼ��� >");
		String accNo = sc.nextLine();
		Account a = clientMgr.searchAccountByNo(accNo);
		
		a.showInfo();
		
	}
	
	
	
	
	
	
	
	
	public String deleteMenu(){
		System.out.printf("%n=====�����޴�=====%n");
		System.out.println(" 1.������");
		System.out.println(" 2.���»���");
		System.out.println(" 3.�����޴���");
		System.out.printf("%n��ȣ�� �����ϼ��� >");
		String input = sc.nextLine();
		
		return input;
	}//deleteMenu()
	
	
	
	
	
	
	
	
}//class
