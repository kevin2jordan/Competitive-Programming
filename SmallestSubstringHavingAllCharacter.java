public class SmallestWindow {

    private static final int MAX_LEN = 256;

    private static String findSmallestWindow(String s, String t) {
        if(t.length() > s.length()) {
            return "Not Possible";
        }

        int[] hash_s = new int[MAX_LEN];
        int[] hash_t = new int[MAX_LEN];

        int cnt = 0, start=0, start_ind=-1, minLen = Integer.MAX_VALUE;

        for(int i=0;i<t.length();i++){
            hash_t[t.charAt(i)]++;
        }

        for(int j=0;j<s.length();j++){

            hash_s[s.charAt(j)]++;

            if(hash_t[s.charAt(j)] >= hash_s[s.charAt(j)]){
                cnt++;
            }

            if(cnt == t.length()) {

                while(hash_s[s.charAt(start)] > hash_t[s.charAt(start)] ||
                hash_t[s.charAt(start)] == 0){
                    if(hash_s[s.charAt(start)] > hash_t[s.charAt(start)]){
                        hash_s[s.charAt(start)]--;
                    }
                    start++;
                }
                int len = j-start+1;
                if(len < minLen) {
                    minLen = len;
                    start_ind = start;
                }

            }
        }
        return s.substring(start_ind, minLen+start_ind);
    }

    public static void main(String args[]) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(findSmallestWindow(s,t));
    }
}
