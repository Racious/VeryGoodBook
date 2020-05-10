package uuu.vgb.entity;

public class Check_Customer {

    public static void checkid(String id) {
        String id_pattern = "[a-zA-Z][1-2][0-9]{8}";//身分證格式 [a-zA-Z][1-2]\d{8}
        int sum = 0;//計算總和
        char ary[] = new char[10];//字元陣列

        if (id == null || !(id.matches(id_pattern))) { //判斷輸入的id是否為null及是否符合格式
        	throw new DataInvalidException("身分證號碼不正確");
        }
        for (int i = 1; i < 10; i++) {//迴圈，將id放入字元字串並計算總合
            ary[i] = id.charAt(i);
            sum += (ary[i] - 48) * (9 - i);
        }
        id = id.toUpperCase();//統一變大寫
        ary[0] = id.charAt(0);//取首字
        sum += ary[9] - 48;//後九碼總和
        //從總和的餘數去判斷首字英文字母
        switch (sum % 10) {
            case 0:
                if (ary[0] == 'B' || ary[0] == 'N' || ary[0] == 'Z') {
                    return;
                } else {
                    break;
                }
            case 1:
                if (ary[0] == 'C' || ary[0] == 'I' || ary[0] == 'P') {
                    return;
                } else {
                    break;
                }
            case 2:
                if (ary[0] == 'D' || ary[0] == 'O' || ary[0] == 'Q') {
                    return;
                } else {
                    break;
                }
            case 3:
                if (ary[0] == 'E' || ary[0] == 'R') {
                    return;
                } else {
                    break;
                }
            case 4:
                if (ary[0] == 'F' || ary[0] == 'S') {
                    return;
                } else {
                    break;
                }
            case 5:
                if (ary[0] == 'G' || ary[0] == 'T') {
                    return;
                } else {
                    break;
                }
            case 6:
                if (ary[0] == 'H' || ary[0] == 'U') {
                    return;
                } else {
                    break;
                }
            case 7:
                if (ary[0] == 'J' || ary[0] == 'V' || ary[0] == 'X') {
                    return;
                } else {
                    break;
                }
            case 8:
                if (ary[0] == 'K' || ary[0] == 'L' || ary[0] == 'Y') {
                    return;
                } else {
                    break;
                }
            case 9:
                if (ary[0] == 'A' || ary[0] == 'M' || ary[0] == 'W') {
                    return;
                } else {
                    break;
                }
        }
        throw new DataInvalidException("身分證號碼不正確");
    }


    public static void checkphone(String phone) throws Exception {
        String phone_pattern = "(09)[0-9]{8}";
        if (phone == null || !(phone.matches(phone_pattern))) {
            throw new Exception("手機號碼格式錯誤");
        }

    }

    public static void checkmail(String mail) throws Exception {
        String mail_pattern = "[a-z0-9_-]+([.a-z0-9_-])*@[a-z0-9_-]+([.a-z0-9_-]+)*$";
        if (mail == null || !(mail.toLowerCase().matches(mail_pattern))) {
            throw new Exception("電子信箱格式錯誤");
        }

    }
}


