import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class MyInvocationHandler implements InvocationHandler {
    private Object object = null;

    public Object bind(Object object) {
        this.object = object;
        return Proxy.newProxyInstance(
                object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                this
                );
    }

    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName()+"方法的参数为："+ Arrays.toString(args));
        Object result =  method.invoke(this.object,args);
        System.out.println("结果为：result = "+result);
        return result;
    }
}
