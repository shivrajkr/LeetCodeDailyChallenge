package DailyCodingChalenge;

class Apr24 {
	public int tribonacci(int n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		if(n == 2) return 1;
		int zero = 0, one = 1, two = 1;
		for(int i=3; i<=n; i++){
			int temp = zero + one + two;
			zero = one;
			one = two;
			two = temp;
		}

		return two;
	}
}
