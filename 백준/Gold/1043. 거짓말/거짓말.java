import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static boolean knowReally[];
    static boolean isChanged = true;
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int countOfKnown = scan.nextInt();

        // 진싱을 아는 사람 목록
        // n+1은 헷갈리지 방지용.
        knowReally = new boolean[n+1];

        // 진실을 아는 사람 체크
        for (int i = 0; i < countOfKnown; i++) {
            knowReally[scan.nextInt()] = true; 
        }

        // 모든 파티를 일단 저장
        List<List<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> temp = new ArrayList<>();
            int partyPeople = scan.nextInt();
            for (int j = 0; j < partyPeople; j++) {
                temp.add(scan.nextInt());
            }
            parties.add(temp);
        }
        
        // 진실을 아는 사람이 없을 경우 모든 곳에서 과장 가능
        if (countOfKnown == 0) {
            System.out.println(m);
            return;
        }

        // 진실을 알고있는 사람 기준으로 탐색을 하며 진실을 알게될 사람들을 추가
        while(isChanged) {
            isChanged = false;
            for (int i = 1; i <= n; i++) {
                checkKnown(parties);
            }
        }

        int answer = 0;
        for (List<Integer> party : parties) {
            if (!checkKnownParty(party)) answer++;
        }

        System.out.println(answer);
    }

    private static boolean checkKnownParty(List<Integer> party) {
        for (int i : party) {
            if (knowReally[i]) return true;
        }
        return false;
    }

    private static void checkKnown(List<List<Integer>> parties) {
        for (List<Integer> party : parties) {
            boolean isKnown = checkKnownParty(party);
            if(!isKnown) continue;
            for (int i : party) {
                if(!knowReally[i]) {
                    knowReally[i] = true;
                    isChanged = true;
                }
            }
        }
    }
}
