package com.lijienode.util;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TransactionInvocationHandler implements InvocationHandler {

    private Object target;

    public TransactionInvocationHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        SqlSession sqlSession = null;
        Object obj = null;
        try{
            sqlSession = SqlSessionUtil.getSession();
            //处理业务逻辑
            obj = method.invoke(target, args);
            //提交事务
            sqlSession.commit();
        }catch (Exception e){
            //事务回滚
            sqlSession.rollback();
            e.printStackTrace();
        }finally {
            SqlSessionUtil.myClose(sqlSession);
        }
        return obj;
    }

    //取得代理类对象
    public Object getProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),this);
    }
}
