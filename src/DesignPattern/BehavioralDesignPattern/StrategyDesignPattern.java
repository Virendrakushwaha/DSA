package DesignPattern.BehavioralDesignPattern;

/*
You’re building a Payment System.

User can pay using:


Credit Card
UPI
Net Banking
        (Tomorrow: Wallet, Crypto, EMI )
Core issue:

Same action (pay) but multiple interchangeable algorithms.
*/

interface PaymentStrategy{
    void pay(int amount);
}

//concrete class for all payment type
class CreditCard implements PaymentStrategy{

    @Override
    public void pay(int amount) {
        System.out.println(amount+"paid by credit card");
    }
}

class PayU implements PaymentStrategy{

    @Override
    public void pay(int amount) {
        System.out.println(amount+"paid by PayU");
    }
}

class UPI implements PaymentStrategy{

    @Override
    public void pay(int amount) {
        System.out.println(amount+"paid through UPI");
    }
}

class PaymentContext{
    private PaymentStrategy paymentStrategy;

    PaymentContext(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(int amount){
        paymentStrategy.pay(amount);
    }
}

public class StrategyDesignPattern {

    static void main() {
        PaymentContext paymentContext = new PaymentContext(new CreditCard());
        paymentContext.pay(100);
    }


}
