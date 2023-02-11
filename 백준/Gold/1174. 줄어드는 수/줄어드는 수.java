import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 1174, 줄어드는 수

// N이 주어졌을 때, N번째로 작은 줄어드는 수를 출력함.
// 19 -> 42

// Backtracking, BruteForce
// 9~0까지의 수를 배열로 나타내고, 이를 선택 or 선택하지 않음으로 모든 경우의 수를 만듦
// 이렇게 되면 결국 모든 수는 줄어든다.
// 이를 정렬하여 N(-1)번째에 오는 수를 선택함

public class Main {
    static int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    static List<Long> answerList = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(read.readLine());

        // arr를 사용하는 모든 경우의 수는 2^10 = 1024개,
        // 따라서 index가 1023을 넘어가면 IndexOutOfBoundsException 발생.
        if (n > 1023) {
            System.out.println(-1);
            return;
        }

        dfs(0, 0);
        Collections.sort(answerList);

        System.out.println(answerList.get(n-1));
    }
    public static void dfs(long value, int idx){
        if(!answerList.contains(value)) {
            answerList.add(value);
        }

        if(idx >= 10) { // 현재 자리수가 10자리라면 더 이상 진행 할 필요가 없음
            return;
        }

        dfs(value * 10 + arr[idx], idx + 1); // 현재 idx에 대한 arr값을 선택한 경우
        dfs(value, idx + 1); // 현재 idx에 대한 arr값을 선택하지 않은 경우
    }
}
