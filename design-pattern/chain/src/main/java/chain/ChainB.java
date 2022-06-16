package chain;

public class ChainB extends ChainHandler {
    @Override
    public void doHandle(String msg) {
        System.out.println("ChainB.doHandle");

        nextDoHandle(msg);
    }
}
