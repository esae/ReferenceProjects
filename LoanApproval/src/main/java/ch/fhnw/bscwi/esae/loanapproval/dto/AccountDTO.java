package ch.fhnw.bscwi.esae.loanapproval.dto;

public class AccountDTO {
	private int ID;
	private String name;
	private long balance;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	
}
