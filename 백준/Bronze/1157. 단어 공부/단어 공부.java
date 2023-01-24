import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String str = scan.next().toLowerCase();
        int count[] = new int[26];
        
        for (int i = 0; i < str.length(); i++) {
            count[(int)str.charAt(i) - (int)'a']++;
        }

        int max_count = 1;
        int max_pos = 0;
        for (int i = 1; i < count.length; i++) {
            if(count[max_pos] < count[i]) {
                max_pos = i;
                max_count = 1;
            } else if (count[max_pos] == count[i]) {
                max_count += 1;
            }
        }
        if (max_count != 1) System.out.println("?");
        else System.out.println((char)((int)'A' + max_pos));
    }
}
