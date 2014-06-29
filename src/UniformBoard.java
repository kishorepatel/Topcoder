import java.util.*;

public class UniformBoard {
   public int getBoard(String[] board, int K) {
	int R = board.length;
        int C = board[0].length();
        int INF = 9999999;
        int answer = 0;
        int cntApples = 0, cntDots = 0;
        for(int i = 0; i < R; i++)
            for(int j = 0; j < C; j++) 
                if(board[i].charAt(j) == 'A') cntApples++;
                else if(board[i].charAt(j) == '.') cntDots++;
        
        for(int r1 = 0; r1 < R; r1++)
            for(int c1 = 0; c1 < C; c1++)
                for(int r2 = r1 + 1; r2 <= R; r2++)
                    for(int c2 = c1 + 1; c2 <= C; c2++){
                        if((c2 - c1) * (r2 - r1) > cntApples) continue;
                        int ca = 0, cp = 0, cd = 0;
                        for(int r = r1; r < r2; r++)
                            for(int c = c1; c < c2; c++){
                                char cc = board[r].charAt(c);
                                if(cc == 'A') ca++;
                                else if(cc == 'P') cp++;
                                else cd++;
                            }
                        
                        int curK = cd + ((cntDots > 0) ? (cp * 2) : INF);
                        if(curK <= K || (r2 - r1) * (c2 - c1) == ca){
                            answer = Math.max(answer, (r2 - r1) * (c2 - c1));
                        }
                    }
        
        return answer;
   }















// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			UniformBoardHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				UniformBoardHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class UniformBoardHarness {
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
			String[] board            = {"AP",
 ".A"};
			int K                     = 0;
			int expected__            = 1;

			return verifyCase(casenum__, expected__, new UniformBoard().getBoard(board, K));
		}
		case 1: {
			String[] board            = {"AP",
 ".A"};
			int K                     = 1;
			int expected__            = 2;

			return verifyCase(casenum__, expected__, new UniformBoard().getBoard(board, K));
		}
		case 2: {
			String[] board            = {"PPP",
 "APA",
 "A.P"};
			int K                     = 2;
			int expected__            = 3;

			return verifyCase(casenum__, expected__, new UniformBoard().getBoard(board, K));
		}
		case 3: {
			String[] board            = {"AAA",
 "PPP",
 "AAA"};
			int K                     = 10;
			int expected__            = 3;

			return verifyCase(casenum__, expected__, new UniformBoard().getBoard(board, K));
		}
		case 4: {
			String[] board            = {"."};
			int K                     = 1000;
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new UniformBoard().getBoard(board, K));
		}
		case 5: {
			String[] board            = {"PPAAPA..AP",
 "PPA.APAP..",
 "..P.AA.PPP",
 "P.P..APAA.",
 "P.P..P.APA",
 "PPA..AP.AA",
 "APP..AAPAA",
 "P.P.AP...P",
 ".P.A.PAPPA",
 "..PAPAP..P"};
			int K                     = 10;
			int expected__            = 15;

			return verifyCase(casenum__, expected__, new UniformBoard().getBoard(board, K));
		}

		// custom cases

/*      case 6: {
			String[] board            = ;
			int K                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new UniformBoard().getBoard(board, K));
		}*/
/*      case 7: {
			String[] board            = ;
			int K                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new UniformBoard().getBoard(board, K));
		}*/
/*      case 8: {
			String[] board            = ;
			int K                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new UniformBoard().getBoard(board, K));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
