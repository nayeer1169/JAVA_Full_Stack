abstract class Payment{
	abstract void pay();
	abstract void refund();
}

class CreditCard extends Payment{
	@Override
	void pay() {
		System.out.println("Payment made using credit card");
	}
	@Override
	void refund() {
		System.out.println("Refund sent to credit card");
		System.out.println("----------------------------");
	}
}

class Upi extends Payment{
	@Override
	void pay() {
		System.out.println("Payment made using upi");
	}
	@Override
	void refund() {
		System.out.println("Refund sent through upi");
		System.out.println("----------------------------");
	}
}

class Cash extends Payment{
	@Override
	void pay() {
		System.out.println("Payment made using cash ");
	}
	@Override
	void refund() {
		System.out.println("Cash refunded");
		System.out.println("----------------------------");
	}
}			

class PaymentGateway{
	static void process(Payment p) {
		p.pay();
		p.refund();
	}
}
public class Abstraction3 {

	public static void main(String[] args) {
		CreditCard c = new CreditCard();
		Upi u = new Upi();
		Cash ch  = new Cash();
		
		PaymentGateway.process(c);
		PaymentGateway.process(u);
		PaymentGateway.process(ch);
	}

}
