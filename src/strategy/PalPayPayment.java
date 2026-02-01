package strategy;

public class PalPayPayment implements PaymentStrategy{
    @Override
    public void pay(double amount) {
        System.out.println(
                "PalPay Transfer Payment\n" +
                        "Amount: $" +amount+ "\n"
        );
    }
}
