import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        boolean alpha[] = new boolean[26];

        int count = 0;
        for (int i = 0; i < n; i++) {
            String str = scan.next();
            for (int j = 0; j < str.length(); j++) {
                if (j > 0 && alpha[(int) str.charAt(j) - (int) 'a'] == true
                        && str.charAt(j) != str.charAt(j - 1)) {
                    break;
                }
                alpha[(int) str.charAt(j) - (int) 'a'] = true;
                if (j == str.length() - 1)
                    count++;
            }
            alpha = new boolean[26];
        }

        System.out.println(count);
    }
}
