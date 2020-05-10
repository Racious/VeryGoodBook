package uuu.vgb.test;

public class Test_immutable {

	public static void main(String[] args) {
		//不可變更的類別，表示內容建立的時候就無法再變更，要變更需重新建立
		String name=" John ";
		name.trim();//回傳新的字串內容，字串內容建立後無法變更
		System.out.println(name.trim());
		System.out.println(name);
		
		String s="Hello";
		String s2=s;
		System.out.println(s==s2);
		s+="World";
		System.out.println(s);
		System.out.println(s2);
		
		int i=1;
		int j=i;
		i++;
		System.out.println(i);
		System.out.println(j);
		
		Integer x=1;//建立後就不會改變
		Integer y=x;
		x++;//新建立並指派
		System.out.println(x);
		System.out.println(y);
	}

}
