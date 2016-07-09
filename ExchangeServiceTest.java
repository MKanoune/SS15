import static org.junit.Assert.*;
import org.junit.Test;

public class ExchangeServiceTest {
	ExchangeService service;
	Money money = new Money(Money.Currency.Euro,10000);
	long test = (long) ((money.getAmount() * 1.5f)-10);
	
	@Test
	public void testChange() {
		CurrencyConverter converter = new CurrencyConverter() {

			@Override
			public float getRate(Money.Currency sourceCurrency, Money.Currency targetCurrency) {
				float rate =  1.5f;
				return rate;
			}
		};
		
		service = new ExchangeService(converter);
		Money newMoney = service.change(money, Money.Currency.Dollar);
		System.out.println(newMoney.getAmount());
		System.out.println(test);

		assertTrue("test",newMoney.getAmount()== test);
	}

}
