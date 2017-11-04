package payment;

/**
 * It is a concrete strategy
 *
 */
public class Ticket implements Payment{

	@Override
	public boolean paymnet(float value) {
		System.out.println("Payment in ticket");
		System.out.println("Value: " + value);
		return true;
	}
	
	@Override
	public String getName() {
		return "Ticket";
	}
	
	

}
