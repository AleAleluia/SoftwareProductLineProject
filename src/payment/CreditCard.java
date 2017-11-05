package payment;

/**
 * It is a concrete strategy
 */
public class CreditCard implements Payment{

	@Override
	public boolean paymnet(float value) {
		System.out.println("Pagamento no cartao de credito");
		System.out.println("Valor: " + value);
		return true;
	}

	@Override
	public String getName() {
		return "Cartao de Credito";
	}
	
}
