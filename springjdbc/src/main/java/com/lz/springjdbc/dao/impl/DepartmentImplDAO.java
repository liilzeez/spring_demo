package com.lz.springjdbc.dao.impl;

import java.util.List;
import java.util.ArrayList;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

import com.lz.springjdbc.bean.Department;
import com.lz.springjdbc.dao.DepartmentDAO;

public class DepartmentImplDAO implements DepartmentDAO {

   private DataSource dataSource;

   public void setDataSource(DataSource dataSource) {
       this.dataSource = dataSource;
   }

   public List<Department> queryDepartment() throws SQLException {
       Connection conn = dataSource.getConnection();

       String sql = "Select d.dept_id, d.dept_no, d.dept_name from department d";
       Statement smt = conn.createStatement();

       ResultSet rs = smt.executeQuery(sql);
       List<Department> list = new ArrayList<Department>();
       while (rs.next()) {
           Long deptId = rs.getLong("dept_id");
           String deptNo = rs.getString("dept_no");
           String deptName = rs.getString("dept_name");
           Department dept = new Department(deptId, deptNo, deptName);
           list.add(dept);
       }
       if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (smt != null) {
			try {
				smt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
       return list;
   }

}


