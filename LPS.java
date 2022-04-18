import java.util.Scanner;

public class LPS {
    private static String getLPS(String str) {
        int n = str.length();
        int maxLen=1, start=0, end=0;
        for(int i=0;i<n;i++) {
            int l=i, r=i;
            while(l>=0 && r<n && str.charAt(l) == str.charAt(r)) {
                l--;
                r++;
            }
            int len = r-l+1;
            if(len > maxLen) {
                maxLen = len;
                start = l+1;
                end = r-1;
            }
            l=i;
            r=i+1;
            while(l>=0 && r<n && str.charAt(l) == str.charAt(r)) {
                l--;
                r++;
            }
            len = r-l+1;
            if(len > maxLen) {
                maxLen = len;
                start = l+1;
                end = r-1;
            }
        }

        return str.substring(start, end+1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(getLPS(str));
    }
}
