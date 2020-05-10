package Mytest;

public class Idiot extends member implements Java {

    @Override
    public String code(boolean isDeadline) {

        System.out.print("Idiot : ");
        return isDeadline == true ?"做不出來啦，都不提醒我" : "時間還早啦，先來玩";
    }

    @Override
    public String java_class(boolean isok) {

        System.out.print("Idiot : ");
        return isok == true ?"疑惑眼神.." : "頭好痛...";
    }

}
