package chain;

public class ChainC extends ChainHandler {
    @Override
    public void doHandle(String msg) {

        System.out.println("ChainC.doHandle");

        nextDoHandle(msg);
    }
}
