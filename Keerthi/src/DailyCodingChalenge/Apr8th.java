package DailyCodingChalenge;

class Apr8th {
	public int countStudents(int[] students, int[] sandwiches) {
		int noOfRoundedSanReq = 0, noOfSquareSanReq = 0;
		for (int s : students) {
			if (s == 0) {
				noOfRoundedSanReq++;
			} else {
				noOfSquareSanReq++;
			}
		}

		for (int i = 0; i < sandwiches.length; i++) {
			int sandwichType = sandwiches[i];
			if (sandwichType == 0) {
				if (noOfRoundedSanReq == 0)
					return sandwiches.length - i;
				noOfRoundedSanReq--;
			} else {
				if (noOfSquareSanReq == 0)
					return sandwiches.length - i;
				noOfSquareSanReq--;
			}
		}

		return 0;
	}
}