package uuu.vgb.service;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.VGBException;
import uuu.vgb.entity.testproduct;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
	// 代理人模型 方法共用同一個屬性
	private CustomersDAO dao = new CustomersDAO();

	// 資料從外面(前端)傳進來 客戶的類別 這邊仍是後端，故有錯需繼續通知前端
	public Customer login(String id, String pwd) throws VGBException {
		Customer c = null;// 預設找不到客戶 null
		// 資料庫程式不要寫在商業邏輯
		// CustomersDAO dao = new CustomersDAO();
		// 大部分一個Table寫一個DAO
		// CustomerDAO dao=new CustomerDAO();
		// 或是一個entity(類別名稱)寫一個DAO
		c = dao.selectCustomerById(id);// 找出一個客戶
		if (c != null) {
			if (c.getPassword().equals(pwd)) {
				return c;
			}
		}

		throw new VGBException("登入失敗，帳號或密碼不正確");
	}

//設計概念　若是新增刪除修改不會回傳，查詢才會回傳
	public void register(Customer c) throws VGBException {
		dao.insert(c);
	}

	public List<Customer> login(String id, String pwd, String gender) throws VGBException {
		List<Customer> customerList = new ArrayList<Customer>();
		// 資料庫程式不要寫在商業邏輯
		CustomerSearch dao = new CustomerSearch();
		// 大部分一個Table寫一個DAO
		// CustomerDAO dao=new CustomerDAO();
		// 或是一個entity(類別名稱)寫一個DAO
		customerList = dao.selectCustomerByGender(gender);// 找出一個客戶
		if (customerList != null) {
			return customerList;
		}

		throw new VGBException("登入失敗，帳號或密碼不正確");
	}

	public List<testproduct> search(String search) throws VGBException {
		// TODO Auto-generated method stub
		CustomerSearch dao = new CustomerSearch();
		List<testproduct> list = new ArrayList<testproduct>();
		list = dao.search(search);
		if (list.size()!=0) {
				return list;				
		}
		throw new VGBException("抱歉，未查到相關產品");
	}

	public void update(Customer c) throws VGBException {
		dao.update(c);
	}

}
