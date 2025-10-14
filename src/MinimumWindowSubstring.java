import java.util.HashMap;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {

        if(s.isEmpty() || t.isEmpty() || s.length()<t.length()){
            return "";
        }

        HashMap<Character,Integer> mapT=new HashMap<>();

        for(char ch:t.toCharArray()){
            mapT.put(ch,mapT.getOrDefault(ch,0)+1);
        }

        int required=mapT.size();  // unique
        int left=0;
        int right=0;
        int create=0;  // count
        int[] ans={-1,0,0}; // length,left,right
        HashMap<Character,Integer> subStr=new HashMap<>();

        while(right<s.length()){
            char c=s.charAt(right);
            subStr.put(c,subStr.getOrDefault(c,0)+1);

            if(mapT.containsKey(c) && subStr.get(c).intValue()== mapT.get(c).intValue()){
                create++;
            }
            while(left<=right && required==create){
                c=s.charAt(left);
                if(ans[0]==-1 || ans[0]>right-left+1){
                    ans[0]=right-left+1;
                    ans[1]=left;
                    ans[2]=right;
                }
                subStr.put(c,subStr.get(c)-1);
                if(mapT.containsKey(c) && subStr.get(c).intValue()<mapT.get(c).intValue()){
                    create--;
                }
                left++;
            }
            right++;
        }
        if(ans[0]==-1){
            return "";
        }
        return s.substring(ans[1],ans[2]+1);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring mws = new MinimumWindowSubstring();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(mws.minWindow(s, t));
    }

}
