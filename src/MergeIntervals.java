import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        // Step 1: Sort intervals by their start time
        Arrays.sort(intervals , (a, b)-> a[0] - b[0]);

        // Step 2: Create a list to store merged intervals
        List<int[]> merged = new ArrayList<>();

        for(int[] interval : intervals){
            // If merged is empty OR no overlap, add the current interval
            if(merged.isEmpty() || merged.get(merged.size()-1)[1] < interval[0]){
                merged.add(interval);
            }else{
                // There is an overlap → merge intervals by updating the end
                merged.get(merged.size()-1)[1] = Math.max(merged.get(merged.size()-1)[1] , interval[1]);
            }
        }

        // Step 3: Convert list back to 2D array
        return merged.toArray(new int[merged.size()][]);

    }
}
