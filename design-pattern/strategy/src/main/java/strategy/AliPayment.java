package strategy;

public class AliPayment implements IPayment {
    @Override
    public void doPay() {
        System.out.println("支付宝支付");
    }
}
