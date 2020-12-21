package com.lijienode.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {

    private static SqlSessionFactory sqlSessionFactory;

    private SqlSessionUtil(){};

    static {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    private static ThreadLocal<SqlSession> t = new ThreadLocal<>();

    //取得sqlSession对象
    public static SqlSession getSession(){
        SqlSession sqlSession = t.get();
        if(sqlSession == null){
            sqlSession = sqlSessionFactory.openSession();
            t.set(sqlSession);
        }
        return sqlSession;
    }

    //关闭sqlSession对象
    public static void myClose(SqlSession sqlSession){
        if(sqlSession != null){
            //连接返回连接池
            sqlSession.close();
            //线程返回线程池
            t.remove();
        }
    }
}
