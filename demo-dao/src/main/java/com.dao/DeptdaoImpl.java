package com.dao;

import com.entity.Dept;
import com.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class DeptdaoImpl implements Deptdao {
    @Override
    public List<Dept> getAll(int pageNum ,int pageSize) {
        try(SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true)){
            return sqlSession.getMapper(Deptdao.class).getAll(pageNum,pageSize);
        }
    }
}
