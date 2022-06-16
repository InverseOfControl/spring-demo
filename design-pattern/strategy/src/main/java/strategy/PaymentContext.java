package strategy;

import java.util.HashMap;
import java.util.Map;

public class PaymentContext {
    public static final String ALI_PAY = "aliPay";
    public static final String WECHAT_PAY = "wechatay";

    private final IPayment payment;

    private static Map<String, IPayment> map = new HashMap<>();

    static {
        map.put(ALI_PAY, new AliPayment());
        map.put(WECHAT_PAY, new WechatPayment());
    }

    public PaymentContext(IPayment payment) {
        this.payment = payment;
    }

    public void pay() {
        this.payment.doPay();
    }

    public static IPayment getPayMode(String key) {
        return map.get(key);
    }
}
