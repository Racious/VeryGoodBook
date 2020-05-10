package Mytest;

public class Me extends member implements Java{
 
	@Override
    public String code(boolean isDeadline) {

        System.out.print("ME : ");
        return isDeadline == true ? "快...快好了" : "好唷 等等開始用";

}

	@Override
	public String java_class(boolean isok) {

		System.out.print("ME : ");
		return isok == true ? "點頭" : "恍神中...";
	}
}
