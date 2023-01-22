import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int origin = Integer.parseInt(str);
        int cnt = 0;
        str = getNumber(str);

        while(true) {
            int newNum = (int)str.charAt(0) + (int)str.charAt(1) - 96;
            str = str.charAt(1) + "" + getNumber(String.valueOf(newNum)).charAt(1);            cnt++;
            if(origin == Integer.parseInt(str)) {
                System.out.println(cnt);
                return;
            }
        }
    }

    public static String getNumber(String s) {
        return s.length() == 1 ? "0" + s : s;
    }
}
