package com.lz.springjdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lz.springjdbc.bean.Department;
import com.lz.springjdbc.dao.DepartmentDAO;

public class App 
{
	public static void main(String[] args) throws Exception {
	       ApplicationContext context = new ClassPathXmlApplicationContext(
	               "spring-module.xml");

	       DepartmentDAO deptDAO = (DepartmentDAO) context
	               .getBean("departmentDAO");

	       List<Department> depts = deptDAO.queryDepartment();

	       for (Department dept : depts) {
	           System.out.println("Dept ID " + dept.getDeptId());
	           System.out.println("Dept No " + dept.getDeptNo());
	           System.out.println("Dept Name " + dept.getDeptName());
	       }
	       
	       //不释放数据库连接
	       System.out.println("111");
//	       
//	       ApplicationContext context1 = new ClassPathXmlApplicationContext(
//	               "spring-module.xml");
//
//	       DepartmentDAO deptDAO1 = (DepartmentDAO) context1
//	               .getBean("departmentDAO");

	       List<Department> depts1 = deptDAO.queryDepartment();

	       for (Department dept1 : depts1) {
	           System.out.println("Dept ID " + dept1.getDeptId());
	           System.out.println("Dept No " + dept1.getDeptNo());
	           System.out.println("Dept Name " + dept1.getDeptName());
	       }

	       //((AbstractApplicationContext) context).registerShutdownHook();
	      // ((AbstractApplicationContext) context).close();
	   }
}
