package com.lz.springjdbc.dao;

import java.util.List;

import com.lz.springjdbc.bean.Department;

public interface DepartmentDAO {
   
   public List<Department> queryDepartment() throws Exception ;

}
