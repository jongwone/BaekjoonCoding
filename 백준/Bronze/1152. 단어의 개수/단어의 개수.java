import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine().trim();
        if(str.length() == 0) System.out.println(0);
        else {
            String[] a = str.split(" ");
            System.out.println(a.length);
        }
    }
}