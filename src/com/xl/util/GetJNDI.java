package com.xl.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Properties;

/**
 * @author ����
 * @Decription Ejb, Weblogic����JNDI�Ĺ�����
 * @date 2013-12-21
 */
public class GetJNDI {
    private static int webType = 0;
    // EJB������IP��ַ
    private static String ejbServerIP = "";
    // EJB�������˿�
    private static String ejbServerPort = "";

    // ���ð汾��WebLogic 10g/11g
    public static Object webLogic10(String mappedName, String className) {
        try {
            Properties env = new Properties();
            env.setProperty(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
            env.setProperty(Context.PROVIDER_URL, "t3://" + ejbServerIP + ":" + ejbServerPort);
            InitialContext ctx = new InitialContext(env);
            return ctx.lookup("ejb/" + mappedName + "#" + className);
        } catch (Exception e) {
            return null;
        }
    }

    // ���ð汾��JBoss 4.2.3
    public static Object jBoss4(String mappedName) {
        try {
            Properties env = new Properties();
            env.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
            env.setProperty(Context.PROVIDER_URL, ejbServerIP + ":" + ejbServerPort);
            InitialContext ctx = new InitialContext(env);
            return ctx.lookup(mappedName + "/remote");
        } catch (Exception e) {
            return null;
        }
    }

    // ���ð汾��JBoss 5.0.0/5.0.1/6.0.0/6.1.0
    public static Object jBoss5(String mappedName) {
        try {
            Properties env = new Properties();
            env.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
            env.setProperty(Context.PROVIDER_URL, ejbServerIP + ":" + ejbServerPort);
            InitialContext ctx = new InitialContext(env);
            return ctx.lookup("ejb/" + mappedName);
        } catch (Exception e) {
            return null;
        }
    }

    // ���ð汾��JBoss 7.1.1 �贫��EJB��Jar����
    public static Object jBoss7(String jarName, String mappedName) {
        try {
            Properties env = new Properties();
            env.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.as.naming.InitialContextFactory");
            env.setProperty(Context.PROVIDER_URL, ejbServerIP + ":" + ejbServerPort);
            InitialContext ctx = new InitialContext(env);
            return ctx.lookup("java:global/" + jarName + "/" + mappedName);
        } catch (Exception e) {
            return null;
        }
    }

    // EJB��������ַ�Ͷ˿�����ʱ������Ӧ����
    public Object initLookup(String jarName, String mappedName, String className) {
        if (null != webLogic10(mappedName, className)) {
            webType = 1;
        } else if (null != jBoss4(mappedName)) {
            webType = 2;
        } else if (null != jBoss5(mappedName)) {
            webType = 3;
        } else if (null != jarName && null != jBoss7(jarName, mappedName)) {
            webType = 4;
        }
        return webType == 0 ? null : lookup(jarName, mappedName, className);
    }

    // EJB��������ַ��˿ڲ�ȱʱ������Ӧ����
    public Object autoLookup(String jarName, String mappedName, String className) {
        ejbServerIP = ejbServerIP.length() == 0 ? "localhost" : ejbServerIP;
        ejbServerPort = ejbServerPort.length() == 0 ? "7001" : ejbServerPort;
        if (null != webLogic10(mappedName, className)) {
            webType = 1;
        } else {
            ejbServerPort = "1099";
            if (null != jBoss4(mappedName)) {
                webType = 2;
            } else if (null != jBoss5(mappedName)) {
                webType = 3;
            } else if (null != jarName && null != jBoss7(jarName, mappedName)) {
                webType = 4;
            }
        }
        return webType == 0 ? null : lookup(jarName, mappedName, className);
    }

    public Object lookup(String mappedName, String className) {
        return lookup(null, mappedName, className);
    }

    public Object lookup(String jarName, String mappedName, String className) {
        Object daoImpl = null;
        switch (webType) {
            case 1:
                daoImpl = webLogic10(mappedName, className);
                break;
            case 2:
                daoImpl = jBoss4(mappedName);
                break;
            case 3:
                daoImpl = jBoss5(mappedName);
                break;
            case 4:
                daoImpl = jBoss7(jarName, mappedName);
                break;
            default:
                daoImpl = ejbServerIP.length() == 0 || ejbServerPort.length() == 0 ? autoLookup(jarName, mappedName, className) : initLookup(jarName, mappedName, className);
                break;
        }
        return daoImpl;
    }
}
