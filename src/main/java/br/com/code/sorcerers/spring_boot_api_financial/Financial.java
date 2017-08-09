package br.com.code.sorcerers.spring_boot_api_financial;

import java.io.Serializable;

/**
 * @author victor
 *
 */
public class Financial implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
    private String name;
    private String account;
    private Double credit;
    
    
    
	public Financial(long id, String name, String account, Double credit) {
		this.id = id;
		this.name = name;
		this.account = account;
		this.credit = credit;
	}
	
	public Financial(){}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Double getCredit() {
		return credit;
	}

	public void setCredit(Double credit) {
		this.credit = credit;
	}

	
    

}
