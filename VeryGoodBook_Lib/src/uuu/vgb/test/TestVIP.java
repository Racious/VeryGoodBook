package uuu.vgb.test;

import uuu.vgb.entity.Check_Customer;
import uuu.vgb.entity.VIP;

public class TestVIP {

	public static void main(String[] args) {
		Check_Customer check=new Check_Customer();
		VIP vip=new VIP();
		String id="a129128471";
		String email="45aw_en@gamil.com.tw";
		String name="awenb";
		String password="12356g/g";
		try {
			check.checkid(id);
			check.checkmail(email);
			vip.setId(id);
			vip.setEmail(email);
			//vip.setDiscount(0);
			vip.setPassword(password);
			vip.setName(name);
			vip.setGender('F');
			vip.setBirthday("2020-01-01");
			//vip.setBirthday(2020, 01, 30);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return;
		}

		System.out.println(vip.getId());
		System.out.println(vip.getName());
		System.out.println(vip.getEmail());
		System.out.println(vip.getDiscountString());
		System.out.println(vip.getPassword());
		System.out.println(vip.getBirthday());
		System.out.println("\n");
		//System.out.println("vip是: "+vip);//等於+vip.toString()，除非是null
		System.out.println("vip是: "+vip.toString());//將物件內容打包成字串

		//System.out.println("vip是: "+"hello".toString());//hello複寫toString
		/*
		 * 
		 * 
		 * public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    } 
		 *public native int hashCode(); c++語法 顯示記憶體位置
		 * 
		 * 
		 * 
		 *
		 * 
		 */
		 

	}

}
