package uuu.vgb.test;

public class Test_Wrapper_Class {

	public static void main(String[] args) {
		Byte fiveObj=127;
		short sixObj=32767;
		//JAVA資料庫資料允許null，但Java int不行，故需要boxing
		int one =1;
		Integer oneObj=new Integer(one); //boxing，為了放在集合中，故需變成參考型別
		//Integer oneObj2=1; //等同new Integer(1);因數字預設是int
		//Double twoOjb2=2; //因數字預設是int，不能給Double，不建議用auto-boxing，自己new
		double two=2D;
		Double twoObj=new Double(two);//boxing
		//Double twoObj2=two;//anto-boxing，等同new Double(two)
		long four=4L;
		Long fourObj =new Long(four);
		
		
		double three=oneObj.intValue()+twoObj.doubleValue()/fourObj.floatValue();//unboxing，解開包裝
		double three2=oneObj+twoObj/fourObj;//auto-unboxing
		Double threeOjb =new Double(three);//boxing
		System.out.println(Boolean.TRUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(threeOjb);
		System.out.println(Integer.parseInt("123"));
		System.out.println(Double.parseDouble("123.4"));
		System.out.println(three);
		System.out.println(three2);
		
		
		

		
		
	}

}
