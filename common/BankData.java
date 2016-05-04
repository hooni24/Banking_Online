package common;

public class BankData {
	public final static int LOG_IN = 1;
	public final static int LOG_OUT = 2;
	public final static int SIGN_UP = 3;
	public final static int LEAVE = 4;
	public final static int OPEN_ACCOUNT = 5;
	public final static int CLOSE_ACCOUNT = 6;
	public final static int DEPOSIT = 7;
	public final static int WITHDRAW = 8;
	
	private int command;

	public int getCommand() {
		return command;
	}

	public void setCommand(int command) {
		this.command = command;
	}
	
	
	

}
