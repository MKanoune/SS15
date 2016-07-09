
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Account {
	Map<Money.Currency,Money> balance = new HashMap<Money.Currency,Money>();
	
	public void deposit(Money money) throws WrongCurrencyException{
		if(balance.containsKey(money.getCurrency())){
			Money other = balance.get(money.getCurrency());
			other.add(money);
			balance.put(other.getCurrency(), other);
		}else {
			balance.put(money.getCurrency(), money);
		}
	}
	
	public List<Money.Currency> getMyCurrency(){
		List <Money.Currency> list = new ArrayList<Money.Currency>(balance.keySet());
		return list;
	}
	
	public Money getMoney(Money.Currency currency){
		if(balance.containsKey(currency)){
			return balance.get(currency);
		}else{
			return null;
		}
	}
	
	
}
