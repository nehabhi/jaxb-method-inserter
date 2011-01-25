package jdp.jaxb.pluggin;

import org.apache.commons.beanutils.MethodUtils;

public class MethodInvoker {

   
    public static Object invokeStaticMethod(Object o, String methodName) {
        try {
            Class objectClass = Class.forName(o.getClass().getCanonicalName() + "Ext");
            Object result = MethodUtils.invokeStaticMethod(objectClass, methodName, o);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}