import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long building[] = new long[n];
        for (int i = 0; i < building.length; i++) {
            building[i] = scan.nextLong();
        }

        if ( n <= 3 ) {
            System.out.println(n-1);
            return;
        }

        // 중간 지점에서 좌 우로 하나씩 퍼짐.
        // 만약 자신보다 2개 우측에 있는 빌딩이 보이려면
        // 그 사이에 있는 빌딩은 (자신 + 2개 우측에 위치한 빌딩)의 높이의 합 / 2 
        // 보다 작아야 함. 같아도 보이지 않음.
        // Key : 기울기의 증가 또는 감소 여부!

        int max = -1;
        int now = 0;
        double widthGap, heightGap;
        double nowInclination;
        double beforeInclination;
        for (int i = 0; i < n; i++) {
            //System.out.println("---- " + i + " ----");
            now = 0;
            nowInclination = 0;
            if(i != n-1) { // 오른쪽 진행방향 - 기울기가 증가해야함
                beforeInclination = -2147483647;
                for (int j = i + 1; j < n; j++) {
                    widthGap = j - i;
                    heightGap = building[j] - building[i];
                    nowInclination = heightGap / widthGap;
                    //System.out.println("j : " + j + ", ni : " + nowInclination + ", bi : " + beforeInclination + ", " + (nowInclination > beforeInclination));
                    if(nowInclination > beforeInclination) {
                        now++;
                        beforeInclination = nowInclination;
                    } 
                }
            }
            if(i != 0) { // 왼쪽 진행방향 - 기울기가 감소해야함
                beforeInclination = Double.MAX_VALUE;
                for (int j = i - 1; j >= 0; j--) {
                    widthGap = j - i;
                    heightGap = building[j] - building[i];
                    nowInclination = heightGap / widthGap;
                    //System.out.println("j : " + j + ", ni : " + nowInclination + ", bi : " + beforeInclination + ", " + (nowInclination < beforeInclination));
                    if(nowInclination < beforeInclination) {
                        now++;
                        beforeInclination = nowInclination;
                    } 
                }
            }
            //System.out.println("now : " + now);
            max = Math.max(now, max);
        }

        System.out.println(max);
    }
}
