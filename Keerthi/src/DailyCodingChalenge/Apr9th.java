package DailyCodingChalenge;

class Apr9th {
	// https://leetcode.com/problems/time-needed-to-buy-tickets/description/?envType=daily-question&envId=2024-04-09
	public int timeRequiredToBuy(int[] tickets, int k) {
		int time = 0;
		while(true){
			for(int i=0; i<tickets.length; i++){
				if(tickets[i] > 0){
					time += 1;
					tickets[i]--;
				}

				if(tickets[k] == 0) return time;
			}
		}

		// Time - O(n) , Space - O(1)
		// Since max element in tickets[i] is 100, 100 * n = n.
	}

	// Optimised one saw the solution
	//	public int timeRequiredToBuy(int[] tickets, int k) {
	//		int time = 0;
	//
	//		for (int i = 0; i < tickets.length; i++) {
	//			// If the current person is before or at the desired person 'k'
	//			if (i <= k) {
	//				// Buy the minimum of tickets available at person 'k' and the current person
	//				time += Math.min(tickets[k], tickets[i]);
	//			} else {
	//				// If the current person is after 'k', buy the minimum of
	//				// (tickets available at person 'k' - 1) and the current person
	//				time += Math.min(tickets[k] - 1, tickets[i]);
	//			}
	//		}
	//
	//		return time;
	//	}
}