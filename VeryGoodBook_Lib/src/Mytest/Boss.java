package Mytest;

public class Boss {
	public static void main(String[] args) {
		System.out.println("BOSS:這個下週前完成");
		work(false);
		System.out.println("BOSS:這個中午前要交!");
		work(true);
		Boss boss=new Boss();
		System.out.println("老師:這樣有聽懂嗎?");
		boss.java_class(new Me(),false);
		System.out.println("老師:這樣有聽懂嗎?");
		boss.java_class(new Idiot(),true);

	}
	public static void work(boolean deadline) {
		Boss boss=new Boss();
		boss.crynorth(new Me(),deadline);
		boss.crynorth(new Idiot(),deadline);		
		System.out.println("=============");


	}
	//呼叫介面的窗口
	public void crynorth(Java someone, boolean deadline) {
		String report=someone.code(deadline);
		System.out.println(report);
	}
	public void java_class(Java someone,boolean isok){
		String report=someone.java_class(isok);
		System.out.println(report);
	}
}
