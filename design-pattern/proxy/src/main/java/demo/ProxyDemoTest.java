package demo;

public class ProxyDemoTest {
    public static void main(String[] args) {
       MyProxy proxy = new MyProxy<>();
       HelloService helloService = proxy.getInstance(new HelloServiceImplA());
       helloService.hello();
    }
}
