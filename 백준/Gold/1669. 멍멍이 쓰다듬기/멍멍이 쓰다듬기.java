import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int monkey = scan.nextInt();
        int dog = scan.nextInt();
        scan.close();
        int gap = dog - monkey;

        long answer = 0;
        long n = 0;

        if (gap == 0) {
            System.out.println(0);
            return;
        }

        // 최대 제곱수 찾기
        // gap : 1 = 1, 2~4 = 2, 5~9 = 3, 10~16 = 4,
        while (n * n < gap) n++;
        
        // 제곱근보다 낮은 값들은 n을 하나 빼줘야 함.
        // 1~3 = 1, 4~8 = 2, 9~15 = 3 ...
        if (n * n != gap) n--;

        answer = 2 * n -1;
        gap -= n * n; // 5인 경우 1이, 6인 경우 2가, 7인 경우 3, 8인경우 4가 남음

        // n과 남은 차이값 중 작은 값을 빼서 남은 일수를 채움
        while (gap > 0) {
            gap -= Math.min(n, gap);
            answer++;
        }

        System.out.println(answer);
    }
}
