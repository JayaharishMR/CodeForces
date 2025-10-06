import java.util.*;

public class topKfrequencyElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i:nums){
            mp.put(i,mp.getOrDefault(i,0)+1);
        }
        List<Integer> l=new ArrayList<>(mp.values());
        Collections.sort(l);
        int n=l.size()-1;
        int threshold=l.get(n-k+1);
        int[] arr=new int[k];
        int i=0;
        for(var e:mp.entrySet()){
            if(e.getValue()>=threshold){
                arr[i++]=e.getKey();
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        topKfrequencyElements topKfrequencyElements = new topKfrequencyElements();
        System.out.println(topKfrequencyElements.topKFrequent(new int[] {1,1,1,2,2,3}, 2));
    }
}
