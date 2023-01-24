import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        if (n < 100) {
            System.out.println(n);
            return;
        }

        int gap, gap_a, gap_b, count = 99;
        boolean no_count = false;
        for (int i = 100; i <= n; i++) {
            int temp = i;
            gap_a = temp % 10; // 일의 자리
            gap_b = (temp % 100 - gap_a) / 10; // 십의 자리
            gap = gap_b - gap_a;
            
            while(temp >= 100) {
                temp /= 10;
                gap_a = temp % 10; // 일의 자리
                gap_b = (temp % 100 - gap_a) / 10; // 십의 자리
                if ( gap != gap_b - gap_a ) {
                    no_count = true;
                    break;
                }
            }
            if ( !no_count ) count++;
            no_count = false;
        }
        System.out.println(count);
    }
}
