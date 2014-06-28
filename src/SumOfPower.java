import java.util.*;

public class SumOfPower {
   public int findSum(int[] array) {
	int answer = 0;
        for(int s = 0; s < array.length; s++)
            for(int e = s + 1; e <= array.length; e++){
                for(int k = s; k < e; k++) answer += array[k];
            }
        
        return answer;
   }















// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			SumOfPowerHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				SumOfPowerHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class SumOfPowerHarness {
	public static void run_test(int casenum) {
		if (casenum != -1) {
			if (runTestCase(casenum) == -1)
				System.err.println("Illegal input! Test case " + casenum + " does not exist.");
			return;
		}
		
		int correct = 0, total = 0;
		for (int i=0;; ++i) {
			int x = runTestCase(i);
			if (x == -1) {
				if (i >= 100) break;
				continue;
			}
			correct += x;
			++total;
		}
		
		if (total == 0) {
			System.err.println("No test cases run.");
		} else if (correct < total) {
			System.err.println("Some cases FAILED (passed " + correct + " of " + total + ").");
		} else {
			System.err.println("All " + total + " tests passed!");
		}
	}
	
	static boolean compareOutput(int expected, int result) { return expected == result; }
	static String formatResult(int res) {
		return String.format("%d", res);
	}
	
	static int verifyCase(int casenum, int expected, int received) { 
		System.err.print("Example " + casenum + "... ");
		if (compareOutput(expected, received)) {
			System.err.println("PASSED");
			return 1;
		} else {
			System.err.println("FAILED");
			System.err.println("    Expected: " + formatResult(expected)); 
			System.err.println("    Received: " + formatResult(received)); 
			return 0;
		}
	}

	static int runTestCase(int casenum__) {
		switch(casenum__) {
		case 0: {
			int[] array               = {1,2};
			int expected__            = 6;

			return verifyCase(casenum__, expected__, new SumOfPower().findSum(array));
		}
		case 1: {
			int[] array               = {1,1,1};
			int expected__            = 10;

			return verifyCase(casenum__, expected__, new SumOfPower().findSum(array));
		}
		case 2: {
			int[] array               = {3,14,15,92,65};
			int expected__            = 1323;

			return verifyCase(casenum__, expected__, new SumOfPower().findSum(array));
		}
		case 3: {
			int[] array               = {1,2,3,4,5,6,7,8,9,10};
			int expected__            = 1210;

			return verifyCase(casenum__, expected__, new SumOfPower().findSum(array));
		}

		// custom cases

/*      case 4: {
			int[] array               = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new SumOfPower().findSum(array));
		}*/
/*      case 5: {
			int[] array               = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new SumOfPower().findSum(array));
		}*/
/*      case 6: {
			int[] array               = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new SumOfPower().findSum(array));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
