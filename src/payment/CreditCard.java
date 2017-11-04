package payment;

/**
 * It is a concrete strategy
 */
public class CreditCard implements Payment{

	@Override
	public boolean paymnet(float value) {
		System.out.println("Payment in credit card");
		System.out.println("Value: " + value);
		return true;
	}

	@Override
	public String getName() {
		return "Credit Card";
	}
	
}
