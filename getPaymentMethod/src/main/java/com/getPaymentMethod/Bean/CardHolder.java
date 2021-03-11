package com.getPaymentMethod.Bean;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class CardHolder 
{
	@Id
	private String holdername;
	private String cardtype;
	private int cardbin;
	private int lastdigits;
	public String getHoldername() {
		return holdername;
	}
	public void setHoldername(String holdername) {
		this.holdername = holdername;
	}
	public String getCardtype() {
		return cardtype;
	}
	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}
	public int getCardbin() {
		return cardbin;
	}
	public void setCardbin(int cardbin) {
		this.cardbin = cardbin;
	}
	public int getLastdigits() {
		return lastdigits;
	}
	public void setLastdigits(int lastdigits) {
		this.lastdigits = lastdigits;
	}
	@Override
	public String toString() {
		return "CardHolder [holdername=" + holdername + ", cardtype=" + cardtype + ", cardbin=" + cardbin
				+ ", lastdigits=" + lastdigits + "]";
	}
	
	
}
