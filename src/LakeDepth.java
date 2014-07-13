import java.util.*;

public class LakeDepth {
    int R,C;
    String[] plot;
    boolean[][] was;
   public int depth(String[] plot) {
       R = plot.length;
       C = plot[0].length();
       this.plot = plot;
       
       int answer = 0;
       for(int height = 32; height <= 126; height++){
           was = new boolean[R][C];
                for(int i = 0; i < R; i++)
                    for(int j = 0; j < C; j++){
                        if((i == 0 || i == R-1 || j == 0 || j == C-1) && plot[i].charAt(j) < height)
                            dfs(i, j, height);
                    }
                
               for(int r = 0; r < R; r++)
                   for(int c = 0; c < C; c++)
                       if(!was[r][c])
                           answer = Math.max(answer, height - plot[r].charAt(c));
           
               System.out.println((char)height +" " + answer);
               for(int i = 0; i < R; i++){
                   for(int j = 0; j < C; j++){
                       if(was[i][j])System.out.print(1);
                       else System.out.print(0);
                   }
                   System.out.println();
               }
       }
       return answer;
       
   }

   void dfs(int i, int j, int height){
       if(i < 0 || i >= R || j < 0 || j >= C) return;
       if(was[i][j]) return;
       if(plot[i].charAt(j) >= height) return;
       was[i][j] = true;
       dfs(i-1, j, height);
       dfs(i+1, j, height);
       dfs(i, j-1, height);
       dfs(i, j+1, height);
   }














// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			LakeDepthHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				LakeDepthHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class LakeDepthHarness {
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
			String[] plot             =  {"5255",
  "5225",
  "5525",
  "5515",
  "5555"};
			int expected__            = 1;

			return verifyCase(casenum__, expected__, new LakeDepth().depth(plot));
		}
		case 1: {
			String[] plot             =  {"55555",
  "59995",
  "59595",
  "59195",
  "59995",
  "55555"};
			int expected__            = 8;

			return verifyCase(casenum__, expected__, new LakeDepth().depth(plot));
		}
		case 2: {
			String[] plot             =  {"55555",
  "59995",
  "59A95",
  "59A95",
  "59995",
  "55555"};
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new LakeDepth().depth(plot));
		}
		case 3: {
			String[] plot             = {"55555",
 "52335",
 "53315",
 "45555"};
			int expected__            = 4;

			return verifyCase(casenum__, expected__, new LakeDepth().depth(plot));
		}

		// custom cases

/*      case 4: {
			String[] plot             = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new LakeDepth().depth(plot));
		}*/
/*      case 5: {
			String[] plot             = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new LakeDepth().depth(plot));
		}*/
/*      case 6: {
			String[] plot             = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new LakeDepth().depth(plot));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
