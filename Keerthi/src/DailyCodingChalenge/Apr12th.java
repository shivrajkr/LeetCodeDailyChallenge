package DailyCodingChalenge;

class Apr12th {
	// https://leetcode.com/problems/trapping-rain-water/
	public int trap(int[] height) {
		int l = 0, r = height.length-1;
		int maxL = height[l], maxR = height[r];
		int ans = 0;
		while(l<r){
			if(maxL < maxR){
				ans += maxL - height[l];
				maxL = Math.max(maxL, height[++l]);
			} else {
				ans += maxR - height[r];
				maxR = Math.max(maxR, height[--r]);
			}
		}

		return ans;
	}
}
