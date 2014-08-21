package com.ccit.dao.imp;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.ccit.beans.Customer;
import com.ccit.dao.CustomerDao;
import com.ccit.dao.core.DaoFactory;
import com.ccit.page.PageDiv;

public class TestCustomer {

	@Test
	public void testAddCustomer(){
		CustomerDao<Customer> dao = (CustomerDao<Customer>)DaoFactory.getDao("CustomerDao");
		Customer c = new Customer();
		c.setStaffID(4);
		c.setAreaID(3);
		c.setCustomerno("0010");  // 编号
		c.setName("王丹");
		c.setLegal("刘平");
		c.setService("紫菜");
		c.setDimension("5000人");
		c.setWebsite("http://www.ifeng.com.cn");
		c.setEmail("vicecode@gmail.com");
		c.setTel("18867354451");
		c.setAddress("湖南长沙");
		c.setComment("多人合资，股份制有限公司");		
		c.setCreatetype(0);
		c.setBirth("19790623");
		try {
			dao.addCustomer(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDeleteCustomer(){
		CustomerDao<Customer> dao = (CustomerDao<Customer>)DaoFactory.getDao("CustomerDao");
        try {
			dao.deleteCustomer(2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUpdateCustomer(){
		CustomerDao<Customer> dao = (CustomerDao<Customer>) DaoFactory.getDao("CustomerDao");
		Customer c = new Customer();
		c.setId(3);
		c.setStaffID(7);
		c.setAreaID(3);
		c.setCustomerno("0005");  // 编号
		c.setName("老刘");
		c.setLegal("龙虾");
		c.setService("东瓜");
		c.setDimension("50人");
		c.setWebsite("http://www.ifeng.com.cn");
		c.setEmail("vicecode@gmail.com");
		c.setTel("13867354451");
		c.setAddress("湖南浏阳");
		c.setComment("股份制有限公司");		
		c.setCreatetype(1);
		c.setBirth("19790623");
		try {
			dao.updateCustomer(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@Test
	public void testGetCustomer(){
		CustomerDao<Customer> dao = (CustomerDao<Customer>) DaoFactory.getDao("CustomerDao");
        try {
			Customer c = dao.getCustomer(4);
			System.out.println(c.getName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
	@Test
	public void testGetAllCustomer(){
		CustomerDao<Customer> dao = (CustomerDao<Customer>) DaoFactory.getDao("CustomerDao");
        try {
			PageDiv<Customer> pd = dao.getAllCustomer(3, 1);
			List<Customer> list = pd.list;
		    System.out.println(list.size());
		    for(Customer c:list){
		    	System.out.println(c.getName());
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test 
	public void testGetCustomerByStaff(){
		CustomerDao<Customer> dao = (CustomerDao<Customer>) DaoFactory.getDao("CustomerDao");
        try {
			PageDiv<Customer> pd = dao.getCustomerByStaff(3,2,3);
			List<Customer> list = pd.list;
			System.out.println(list.size());
		    for(Customer c:list){
		    	System.out.println(c.getName());
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test 
	public void testGetCustomerByArea(){
		CustomerDao<Customer> dao = (CustomerDao<Customer>) DaoFactory.getDao("CustomerDao");
        try {
        	PageDiv<Customer> pd = dao.getCustomerByArea(3, 2, 3);
			List<Customer> list = pd.list;
			System.out.println(list.size());
		    for(Customer c:list){
		    	System.out.println(c.getName());
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test 
	public void testGetCustomerByStaffAndArea(){
		CustomerDao<Customer> dao = (CustomerDao<Customer>) DaoFactory.getDao("CustomerDao");
        try {
			PageDiv<Customer> pd = dao.getCustomerByStaffAndArea(3,1
					, 5, 3);
			List<Customer> list = pd.list;
			System.out.println(list.size());
		    for(Customer c:list){
		    	System.out.println(c.getName());
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetCustomerByUnderStaff(){
		CustomerDao<Customer> dao = (CustomerDao<Customer>) DaoFactory.getDao("CustomerDao");
		try {
			PageDiv<Customer> pd = dao.getCustomerByUnderStaff(3, 1, 1);
			List<Customer> list = pd.list;
			System.out.println(list.size());
		    for(Customer c:list){
		    	System.out.println(c.getName());
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
