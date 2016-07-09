
public class Money {
	private long amount;
	

	private Currency currency;
	
	public Money(Currency currency, long amount){
		if(amount < 0){
			throw new IllegalArgumentException("Money darf keinen negativen Wert haben");
		}
		this.currency = currency;
		this.amount = amount;
	}
	
	public enum Currency{
		Euro,Dollar,Drachme;
	}
	
	public void sub(long value){
		if(amount - value < 0){
			throw new IllegalArgumentException("Money darf keinen negativen Wert haben");
		}else if(value < 0){
			throw new IllegalArgumentException("Parameter value darf keinen negativen Wert haben");
		}else{
			amount-=value;
		}
	}
	
	public void add(long value){
		if(value < 0){
			throw new IllegalArgumentException("Parameter value darf keinen negativen Wert haben");
		}else{
			amount+=value;
		}
	}
	
	public void add(Money money) throws WrongCurrencyException{
		if(!(money.getCurrency().equals(currency))){
			throw new WrongCurrencyException("falsche Währung");
		}
	}
	
	
	
	public long getAmount() {
		return amount;
	}

	public Currency getCurrency() {
		return currency;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj == null) return false;
		if(obj == this) return true;
		if(getClass() != obj.getClass())return false;
		return false;
	}
	
}
