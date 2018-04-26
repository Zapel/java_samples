package DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) {
        InvocationHandler handler = new MyProxy(new Integer(5));
        Class[] classes = new Class[]{Comparable.class, Callable.class};
        Object proxy = Proxy.newProxyInstance(null, classes, handler);
        //proxy.getClass();
        //proxy.toString();
        System.out.println(((Comparable)proxy).compareTo(3));
    }

    static class MyProxy implements InvocationHandler {
        Object target;

        public MyProxy(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println(args);
            return method.invoke(target, args);
        }
    }
}
