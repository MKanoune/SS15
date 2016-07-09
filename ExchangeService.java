
public class ExchangeService {
	CurrencyConverter exchangeService;
	ChangeConditions conditions = new ChangeConditions(100, 0.1f);
	
	public ExchangeService(CurrencyConverter exchangeService){
		this.exchangeService=exchangeService;
	}
	
	public Money change(Money money, Money.Currency targetCurrency){
		conditions = conditions.load();
		float rate = exchangeService.getRate(money.getCurrency(), targetCurrency);
		long amount = money.getAmount();
		float ratedAmount = amount * rate;
		long newAmount = (long)ratedAmount - conditions.getBasicCharge();
		
		if(amount > conditions.getBasicChargeLimit()){
			float percentage = amount * conditions.getPercantageCharge();
			newAmount -= (long) percentage;  
			
		}
		
		Money newMoney = new Money(targetCurrency, newAmount);
		
		
		return newMoney;
	}
}

