package chain;

public class Test {
    public static void main(String[] args) {
        ChainHandler.Builder builder = new ChainHandler.Builder();
        ChainHandler handler = builder
                .add(new ChainA())
                .add(new ChainB())
                .add(new ChainC())
                .build();
        handler.doHandle("chain");
    }
}
