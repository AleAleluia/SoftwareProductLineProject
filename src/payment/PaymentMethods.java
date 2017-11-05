package payment;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import properties.PropertiesLoaderVariability;

public class PaymentMethods {

	private final String payment = PropertiesLoaderVariability.getValor("payment").toLowerCase();
	private Map<Integer, Payment> payments = new HashMap<Integer, Payment>();

	public PaymentMethods() {
		int key = 1;
		if (this.payment.contains("creditcard")) {
			this.payments.put(new Integer(key++), new CreditCard());
		} 
		if (this.payment.contains("ticket")) {
			this.payments.put(new Integer(key++), new Ticket());
		}
	}
	
	public Map<Integer, Payment> getPaymentMethods() {
		return this.payments;
	}
	
	public void printPaymentMethods() {
		Map<Integer, Payment> payments = getPaymentMethods();
		Set<Integer> keys = payments.keySet();
		for (Integer integer : keys) {
			System.out.println(integer + " - " + payments.get(integer).getName());
		}
	}
	
	public boolean callPaymentMethods(Integer key, float value) {
		if (this.payments.containsKey(key)) {
			return payments.get(key).paymnet(value);
		} else {
			System.err.println("Does not exist " + key);
			return false;
		}
	}

}
