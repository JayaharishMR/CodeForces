import java.util.Arrays;

class Solution {
    public long[] resultArray(int[] nums, int mod) {
        // 1. Return immediately for modulo 1 since all products map to zero remainder.
        if (mod == 1) {
            long numsSz = nums.length;
            return new long[]{(numsSz * (numsSz + 1)) / 2L};
        }

        // 2. Initialize accumulator to store total subarray counts per remainder.
        long[] subarrTotCntPerRem = new long[mod];

        // State arrays maintaining subarray frequencies ending at current and next index.
        long[] currSubarrCntPerRem = new long[mod];
        long[] nextSubarrCntPerRem = new long[mod];

        // 3. Process sequence linearly to build subarray combinations dynamically.
        for (int num : nums) {
            int currRem = num % mod;

            Arrays.fill(nextSubarrCntPerRem, 0L);

            // 4. Begin a standalone subarray utilizing only the current element.
            ++nextSubarrCntPerRem[currRem];
            ++subarrTotCntPerRem[currRem];

            // 5. Expand existing contiguous segments with the new element multiplier.
            for (int prevRem = 0; prevRem < mod; ++prevRem) {
                long prevSubarrCnt = currSubarrCntPerRem[prevRem];
                if (prevSubarrCnt > 0) {
                    int nextRem = (int)(((long)prevRem * currRem) % mod);

                    // 6. Accumulate configurations matching the derived product remainder.
                    nextSubarrCntPerRem[nextRem] += prevSubarrCnt;
                    subarrTotCntPerRem[nextRem] += prevSubarrCnt;
                }
            }

            // 7. Advance the dynamic programming window for the next iteration.
            long[] temp = currSubarrCntPerRem;
            currSubarrCntPerRem = nextSubarrCntPerRem;
            nextSubarrCntPerRem = temp;
        }

        return subarrTotCntPerRem;
    }
}