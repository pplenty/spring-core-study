//package com.jason.springcorestudy.aop;
//
//import org.aopalliance.intercept.MethodInterceptor;
//import org.aopalliance.intercept.MethodInvocation;
//import org.junit.Test;
//import org.springframework.aop.framework.ProxyFactoryBean;
//
//import static org.junit.Assert.assertEquals;
//
//public class DynamicProxyTest {
//
//    @Test
//    public void proxyFactoryBean() {
//        ProxyFactoryBean pfBean = new ProxyFactoryBean();
//        pfBean.setTarget(new HelloTarget()); //타깃 설정
//        pfBean.addAdvice(new UppercaseAdvice()); //부가기능 추가
//        Hello proxiedHello = (Hello) pfBean.getObject(); //FacotryBean이므로 생성된 프록시를 가져온다.
//
//        assertEquals("HELLO HAVI", proxiedHello.sayHello("Havi"));
//    }
//
//    static class UppercaseAdvice implements MethodInterceptor {
//        public Object invoke(MethodInvocation invocation) throws Throwable {
//            String ret = (String)invocation.proceed(); //타깃을 알고 있기에 타깃 오브젝트를 전달할 필요가 없다.
//            return ret.toUpperCase(); //부가기능 적용
//        }
//    }
//
//    interface Hello {
//        String sayHello(String name);
//        String sayHi(String name);
//        String sayThankYor(String name);
//    }
//
//    static class HelloTarget implements Hello {
//        public String sayHello(String name) { return "Hello " + name; }
//
//        @Override
//        public String sayHi(String name) {
//            return null;
//        }
//
//        @Override
//        public String sayThankYor(String name) {
//            return null;
//        }
//    }
//}