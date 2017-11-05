package payment;

/**
 * It is a concrete strategy
 *
 */
public class Ticket implements Payment{

	@Override
	public boolean paymnet(float value) {
		System.out.println("Pagamento no boleto");
		System.out.println("Valor: " + value);
		return true;
	}
	
	@Override
	public String getName() {
		return "Boleto";
	}
	
	

}
