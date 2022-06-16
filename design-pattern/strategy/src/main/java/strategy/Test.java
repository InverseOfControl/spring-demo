package strategy;

public class Test {
    public static void main(String[] args) {
        IPayment payment = PaymentContext.getPayMode(PaymentContext.WECHAT_PAY);
        PaymentContext context = new PaymentContext(payment);
        context.pay();
    }

}
