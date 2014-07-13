import java.util.*;

public class CellRemoval {
   public int cellsLeft(int[] parent, int deletedCell) {
	int N = parent.length;
        int answer = 0;
        
        boolean[] child = new boolean[N];
        Arrays.fill(child, true);
        for(int i = 0; i < N; i++){
            boolean delete = false;
            for(int j = i; j != -1; j = parent[j]){
                if(j == deletedCell) child[i] = false;
                if(j != i) child[j] = false;
            }
        }
        
        for(boolean b : child) if(b) answer++;
        return answer;
   }















// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			CellRemovalHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				CellRemovalHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class CellRemovalHarness {
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
			int[] parent              = {-1,0,0,1,1};
			int deletedCell           = 2;
			int expected__            = 2;

			return verifyCase(casenum__, expected__, new CellRemoval().cellsLeft(parent, deletedCell));
		}
		case 1: {
			int[] parent              = {-1,0,0,1,1};
			int deletedCell           = 1;
			int expected__            = 1;

			return verifyCase(casenum__, expected__, new CellRemoval().cellsLeft(parent, deletedCell));
		}
		case 2: {
			int[] parent              = {-1,0,0,1,1};
			int deletedCell           = 0;
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new CellRemoval().cellsLeft(parent, deletedCell));
		}
		case 3: {
			int[] parent              = {-1,0,0,2,2,4,4,6,6};
			int deletedCell           = 4;
			int expected__            = 2;

			return verifyCase(casenum__, expected__, new CellRemoval().cellsLeft(parent, deletedCell));
		}
		case 4: {
			int[] parent              = {26,2,32,36,40,19,43,24,30,13,21,14,24,21,19,4,30,10,44,12,7,32,17,43, 35,18,7,36,10,16,5,38,35,4,13,-1,16,26,1,12,2,5,18,40,1,17,38,44,14};
			int deletedCell           = 24;
			int expected__            = 14;

			return verifyCase(casenum__, expected__, new CellRemoval().cellsLeft(parent, deletedCell));
		}

		// custom cases

/*      case 5: {
			int[] parent              = ;
			int deletedCell           = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new CellRemoval().cellsLeft(parent, deletedCell));
		}*/
/*      case 6: {
			int[] parent              = ;
			int deletedCell           = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new CellRemoval().cellsLeft(parent, deletedCell));
		}*/
/*      case 7: {
			int[] parent              = ;
			int deletedCell           = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new CellRemoval().cellsLeft(parent, deletedCell));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
