import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int numPoint = scan.nextInt();
        int lengthOfTape = scan.nextInt();
        int point[] = new int[numPoint];
        int nowTape = 0;
        int answer = 1;
        for (int i = 0; i < numPoint; i++) {
            point[i] = scan.nextInt();
        }
        Arrays.sort(point);
        if(lengthOfTape == 1) {
            System.out.println(numPoint);
            return;
        }
        for (int i = 0; i < point.length-1; i++) {
            if(nowTape + (point[i+1] - point[i]) + 1 <= lengthOfTape) {
                nowTape += (point[i+1] - point[i]);
            } else {
                nowTape = 0;
                answer++;
            }
        }

        System.out.println(answer);

    }
}
