package com.service;

import com.dao.DeptdaoImpl;
import com.entity.Dept;

import java.util.List;

public class Deptservice {
    DeptdaoImpl impl = new DeptdaoImpl();
    public List<Dept> getAll(int pageNum,int pageSize) {
        return impl.getAll(pageNum,pageSize);
    }
}
