class Payment {

    public void pay() {
        System.out.println("Payment Processing");
    }
}

class CreditCard extends Payment {

    @Override
    public void pay() {
        System.out.println("Paid using Credit Card");
    }
}

class UPI extends Payment {

    @Override
    public void pay() {
        System.out.println("Paid using UPI");
    }
}

class NetBanking extends Payment {

    @Override
    public void pay() {
        System.out.println("Paid using Net Banking");
    }
}

class PaymentGateway {

    public void process(Payment p) {
        p.pay();
    }
}

public class Polmorphism3 {

    public static void main(String[] args) {

        CreditCard cc = new CreditCard();
        UPI upi = new UPI();
        NetBanking nb = new NetBanking();

        PaymentGateway pg = new PaymentGateway();

        pg.process(cc);
        pg.process(upi);
        pg.process(nb);
    }
}