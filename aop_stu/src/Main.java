public class Main {
    public static void main(String[] args) {
        Cal cal = new CalImpl();
        MyInvocationHandler myInvocationHandler= new MyInvocationHandler();
        Cal proxy = (Cal) myInvocationHandler.bind(cal);
        proxy.add(10,2);
        proxy.div(10,2);
        proxy.sub(10,2);
        proxy.mul(10,2);
    }
}
