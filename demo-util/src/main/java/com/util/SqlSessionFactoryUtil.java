package com.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtil {
    private static final String RESOURCE ="mybatis-config.xml";
    private static final SqlSessionFactory FACTORY ;
    static {
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(RESOURCE);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("资源加载失败");
        }
        FACTORY = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public static SqlSessionFactory getFactory(){
        return FACTORY;
    }

    public static SqlSession getSqlSession(boolean autoCommit){
        return FACTORY.openSession(autoCommit);
    }


}
