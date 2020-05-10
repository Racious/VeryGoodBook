package uuu.vgb.test;

import uuu.vgb.entity.Check_Customer;

public class Test_Check_Customer {
    public static void main(String[] args) {
        Check_Customer check=new Check_Customer();
        String id="a129128471";
        String phone="0910234567";
        String mail="A-enr@gmail.com";
        try{
            check.checkid(id);
            check.checkphone(phone);
            check.checkmail(mail);
        }catch (Exception e){
            System.out.println(e.getMessage());
           // e.printStackTrace();
            return;
        }
        System.out.println("身分證字號:"+id.toUpperCase()+" 正確");
        System.out.println("手機號碼:"+phone+" 正確");
        System.out.println("電子信箱:"+mail+" 正確");
    }
}
