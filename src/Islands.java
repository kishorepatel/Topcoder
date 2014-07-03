import java.util.*;

public class Islands {
   public int beachLength(String[] kingdom) {
	int[] dxe = {+1, -1,  0, 0,  -1, -1};
        int[] dye = { 0,  0, +1, -1, +1, -1};
        int[] dxo = {+1, -1, 0, 0,  +1, +1};
        int[] dyo = { 0,  0, +1, -1, +1, -1};
        
        int R = kingdom.length;
        int C = kingdom[0].length();
        
        int count = 0;
        for(int y = 0; y < R; y++)
            for(int x = 0; x < C; x++){
                if(kingdom[y].charAt(x) == '#'){
                    for(int k = 0; k < 6; k++){
                        int nx = x + ((y % 2 == 0 )? dxe[k] : dxo[k]);
                        int ny = y + ((y % 2 == 0 )? dye[k] : dyo[k]);
                        if(nx >= 0 && nx < C && ny >= 0 && ny < R){
                            if(kingdom[ny].charAt(nx) == '.') 
                                count++;
                        }
                    }
                }
            }
        
        return count;
   }















// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			IslandsHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				IslandsHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class IslandsHarness {
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
			String[] kingdom          = {".#...#.."};
			int expected__            = 4;

			return verifyCase(casenum__, expected__, new Islands().beachLength(kingdom));
		}
		case 1: {
			String[] kingdom          = {"..#.##", 
 ".##.#.", 
 "#.#..."};
			int expected__            = 19;

			return verifyCase(casenum__, expected__, new Islands().beachLength(kingdom));
		}
		case 2: {
			String[] kingdom          = {"#...#.....",
 "##..#...#."};
			int expected__            = 15;

			return verifyCase(casenum__, expected__, new Islands().beachLength(kingdom));
		}
		case 3: {
			String[] kingdom          = {"....#.",
 ".#....",
 "..#..#",
 "####.."};
			int expected__            = 24;

			return verifyCase(casenum__, expected__, new Islands().beachLength(kingdom));
		}

		// custom cases

/*      case 4: {
			String[] kingdom          = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new Islands().beachLength(kingdom));
		}*/
/*      case 5: {
			String[] kingdom          = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new Islands().beachLength(kingdom));
		}*/
/*      case 6: {
			String[] kingdom          = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new Islands().beachLength(kingdom));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
