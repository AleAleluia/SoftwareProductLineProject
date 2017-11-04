package payment;

/**
 * 
 * Stategy desing pattern.
 *
 */
public interface Payment {
	
	public boolean paymnet(float value);
		
	public String getName();
}
