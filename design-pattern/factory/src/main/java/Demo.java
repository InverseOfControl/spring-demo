public class Demo {
    public static void main(String[] args) {
        String[] names = {"ABC", "XYZ", "zoo"};
        String[] s=new String[3];
        s[0]=names[0];
        s[1]=names[1];
        s[2]=names[2];
        names[1] = "cat";
        System.out.println(s[1]); // s是"XYZ"还是"cat"?
    }
}
