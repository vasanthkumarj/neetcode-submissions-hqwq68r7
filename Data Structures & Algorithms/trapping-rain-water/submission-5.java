class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        int left = 0, water = 0;
        
        while (left < height.length) {
            // Move left pointer to the first non-zero height
            while (left < height.length && height[left] == 0) {
                left++;
            }

            int right = left + 1;
            int maxRight = right; // Track the highest right boundary
            
            // Find the next higher OR highest bar on the right
            while (right < height.length) {
                if (height[right] >= height[left]) {
                    maxRight = right; // Update the best right boundary
                    break;
                }
                if (height[right] > height[maxRight]) {
                    maxRight = right; // Keep track of the highest bar
                }
                right++;
            }

            // If we found a valid right boundary
            if (maxRight < height.length) {
                int minHeight = Math.min(height[left], height[maxRight]);

                // Calculate trapped water between left and right
                for (int i = left + 1; i < maxRight; i++) {
                    water += minHeight - height[i];
                }

                // Move left pointer to right boundary
                left = maxRight;
            } else {
                break; // No more boundaries to trap water
            }
        }
        return water;
    }
}
