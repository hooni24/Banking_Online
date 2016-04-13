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
				case "1"://신규회원
					newCustomerMenu();
					break;
				case "2"://기존회원
					newAccountMenu();
					break;
				case "3"://상위메뉴
					break;
				default:
					System.out.println("번호를 정확히 입력하세요.(회원가입메뉴)");
				}//회원가입 switch
				break;
			case "2":
				num = showBankingMenu();
				switch(num){
				case "1"://입금
					break;
				case "2"://출금
					break;
				case "3"://이체
					break;
				case "4"://상위메뉴
					break;
				default:
					System.out.println("번호를 정확히 입력하세요.(은행업무메뉴)");
				}//은행업무 switch
				break;
			case "3":
				num = checkMenu();
				switch(num){
				case "1"://고객정보조회
					searchCustomerByJumin();
					break;
				case "2"://계좌조회
					searchAccountListByJumin();
					break;
				case "3"://상위메뉴
					break;
				default:
						System.out.println("번호를 정확히 입력하세요.(조회메뉴)");
				}//조회 switch
				break;
			case "4":
				num = deleteMenu();
				switch(num){
				case "1"://고객삭제
					break;
				case "2"://계좌삭제
					break;
				case "3"://상위메뉴
					break;
				default:
						System.out.println("번호를 정확히 입력하세요.(삭제메뉴)");
				}//삭제 switch
				break;
			case "5"://고객정보수정
				break;
			case "99":
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			default:
				System.out.println("번호를 정확히 입력하세요.(메인)");
			}//메인메뉴 switch
		}//while무한루프
	}//생성자
	
	
	public String showMainMenu(){
		System.out.printf("%n=====부루마블 은행=====%n");
		System.out.println(" 1.계좌개설");				//1.신규회원(signIn) 2.기존회원(openAccount)
		System.out.println(" 2.은행업무");				//1.입금 2.출금 3.이체
		System.out.println(" 3.조회");					//1.고객정보조회(주민번호로 찾아서 고객정보,보유계좌정보 조회) 2.잔액조회(주민번호로 계좌조회)
		System.out.println(" 4.삭제");					//1.고객삭제 2.계좌삭제
		System.out.println(" 5.고객정보수정");			//주민번호 받아서 타겟을 정하고 그 사람 정보를 한번에 모두 수정
		System.out.println("99.프로그램종료");
		System.out.printf("%n번호를 선택하세요 >" );
		String input = sc.nextLine();

		return input;
	}//showMainMenu()
	
	public String showSignInMenu(){
		System.out.printf("%n=====회원가입=====%n");
		System.out.println(" 1.신규회원");
		System.out.println(" 2.기존회원");
		System.out.println(" 3.상위메뉴로");
		System.out.printf("%n번호를 선택하세요 >");
		String input = sc.nextLine();
		
		return input;
	}//showSignInMenu()
	
	public void newCustomerMenu(){
		System.out.println("회원가입을 진행합니다.");
		System.out.print("이름을 입력하세요 >");
		String name = sc.nextLine();
		System.out.print("주민번호를 입력하세요 >");
		String jumin = sc.nextLine();
		System.out.print("주소를 입력하세요 >");
		String address = sc.nextLine();
		Customer c = new Customer(name, jumin, address);
		boolean result = clientMgr.signIn(c);
		
		if(result){
			System.out.println("회원가입에 성공하였습니다.");
		}else {
			System.out.println("주민번호가 중복되었습니다.");
		}
	}//newCustomerMenu()
	
	public void newAccountMenu(){
		System.out.println("계좌개설을 진행합니다.");
		System.out.print("주민번호를 입력하세요 >");
		String jumin = sc.nextLine();
		
		Customer findResult = clientMgr.searchCustomerByJumin(jumin);
		
		if(findResult != null){
			boolean result;
			String accNo;
			do{
			int accNoint = (int) (Math.random()*99999) + 1; 
				accNo = String.format("%05d", accNoint); 
				result = clientMgr.openAccount(findResult, accNo);			//이게 true면 개설성공, false면 랜덤번호중복으로 인한 실패. 어떻게 가려서 위로 올리지?
			}while(!result);
			System.out.printf("당신의 계좌는 %s입니다.%n", accNo);
			System.out.println("계좌생성이 완료되었습니다.");
		}else {
			System.out.println("존재하지 않는 회원입니다.");
		}
	}//newAccountMenu()

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String showBankingMenu(){
		System.out.printf("%n=====은행업무=====%n");
		System.out.println(" 1.입금");
		System.out.println(" 2.출금");
		System.out.println(" 3.이체");
		System.out.println(" 4.상위메뉴로");
		System.out.printf("%n번호를 선택하세요 >");
		String input = sc.nextLine();
		
		return input;
	}//showBankingMenu()
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String checkMenu(){
		System.out.printf("%n=====조회메뉴=====%n");
		System.out.println(" 1.고객정보조회");
		System.out.println(" 2.계좌조회");
		System.out.println(" 3.상위메뉴로");
		System.out.printf("%n번호를 선택하세요 >");
		String input = sc.nextLine();
		
		return input;
	}//checkMenu()
	
	public void searchCustomerByJumin(){
		System.out.print("조회할 주민번호를 입력하세요 >");
		String jumin = sc.nextLine();
		Customer result = (Customer) clientMgr.searchCustomerByJumin(jumin);
		if(result != null){
			result.showInfo();
		}else {
			System.out.println("찾는 대상이 없습니다.");
		}//if-else
	}//searchCustomerByJumin()
	
	public void searchAccountListByJumin(){
		System.out.print("조회할 주민번호를 입력하세요 >");
		String jumin = sc.nextLine();
		ArrayList<Account> result = clientMgr.searchAccountListByJumin(jumin);
		
		if(result != null){
			for (Account a : result) {
				a.showInfo();
			}
		}else {
			System.out.println("찾는 대상이 없습니다.");
		}
	}//searchAccountListByJumin
	
	public void searchTest(){
		System.out.println("조회할 계좌번호를 입력하세요 >");
		String accNo = sc.nextLine();
		Account a = clientMgr.searchAccountByNo(accNo);
		
		a.showInfo();
		
	}
	
	
	
	
	
	
	
	
	public String deleteMenu(){
		System.out.printf("%n=====삭제메뉴=====%n");
		System.out.println(" 1.고객삭제");
		System.out.println(" 2.계좌삭제");
		System.out.println(" 3.상위메뉴로");
		System.out.printf("%n번호를 선택하세요 >");
		String input = sc.nextLine();
		
		return input;
	}//deleteMenu()
	
	
	
	
	
	
	
	
}//class
