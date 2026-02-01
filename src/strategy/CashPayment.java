package strategy;

public class CashPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println(
                "Cash Payment\n" +
                        "Amount: $" + amount + "\n"
        );
    }
}
