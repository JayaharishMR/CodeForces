public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        int[] arr = new int[20001];
        for (int num: nums) {
            arr[10000+num]++;
        }
        for (int i = 20001-1; i >= 0; i--) {
            if (arr[i] >= k) {
                return i-10000;
            }
            k -= arr[i];
        }
        return -1;
    }
    public static void main(String[] args) {
        KthLargestElement kthLargestElement = new KthLargestElement();
        System.out.println(kthLargestElement.findKthLargest(new int[] {3,2,1,5,6,4}, 2));
    }
}
