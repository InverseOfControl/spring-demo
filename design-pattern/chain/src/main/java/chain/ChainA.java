package chain;

public class ChainA extends ChainHandler {
    @Override
    public void doHandle(String msg) {
        System.out.println("ChainA.doHandle");

        nextDoHandle(msg);
    }
}
