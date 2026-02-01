package strategy;

public class BankOfPalestinePayment implements PaymentStrategy{
    @Override
    public void pay(double amount) {
        System.out.println(
                "Bank of palestine Transfer Payment\n" +
                        "Amount: $" +amount+ "\n"
        );
    }
}
