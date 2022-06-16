package strategy;

public class WechatPayment implements IPayment {
    @Override
    public void doPay() {
        System.out.println("微信支付");
    }
}
