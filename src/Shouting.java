import java.util.*;

public class Shouting {
   public double shout(int[] x, int[] y) {
       int N = x.length;
	double[][] graph = new double[N][N];
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++){
                if(i == j) graph[i][j] = 0;
                else graph[i][j] = Math.sqrt((x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]));
            }
        
        List<Integer>[] lgraph = new ArrayList[N];
        for(int i = 0; i < N; i++) lgraph[i] = new ArrayList<>();
        
        boolean[] used = new boolean[N];
        used[0] = true;
        while(true){
            int bestp = -1; //best parent
            int bestc = -1; //best child
            double close = Double.MAX_VALUE;
            
            for(int i = 0; i < N; i++){
                if(used[i]){
                    for(int j = 0; j < N; j++){
                        if(!used[j]){
                            if(graph[i][j] < close){
                                close = graph[i][j];
                                bestp = i;
                                bestc = j;
                            }
                        }
                    }
                }
            }
            
            if(bestp == -1) break;
            lgraph[bestp].add(bestc); //making a directed graph
            used[bestc] = true;
        }
       double answer = dfs(0, lgraph, graph);
        
        return answer;
   }
            
private double dfs(int node, List<Integer>[] lgraph, double[][] d){
    double answer = 0;
    for(int i = 0; i < lgraph[node].size(); i++){
        answer = Math.max(answer, d[node][lgraph[node].get(i)]);
    }
    
    for(int i = 0; i < lgraph[node].size(); i++){
        answer = Math.max(answer, dfs(lgraph[node].get(i), lgraph, d));
    }
    
    return answer;
}













// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			ShoutingHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				ShoutingHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class ShoutingHarness {
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
	
	static final double MAX_DOUBLE_ERROR = 1E-9;
	static boolean compareOutput(double expected, double result){ if(Double.isNaN(expected)){ return Double.isNaN(result); }else if(Double.isInfinite(expected)){ if(expected > 0){ return result > 0 && Double.isInfinite(result); }else{ return result < 0 && Double.isInfinite(result); } }else if(Double.isNaN(result) || Double.isInfinite(result)){ return false; }else if(Math.abs(result - expected) < MAX_DOUBLE_ERROR){ return true; }else{ double min = Math.min(expected * (1.0 - MAX_DOUBLE_ERROR), expected * (1.0 + MAX_DOUBLE_ERROR)); double max = Math.max(expected * (1.0 - MAX_DOUBLE_ERROR), expected * (1.0 + MAX_DOUBLE_ERROR)); return result > min && result < max; } }
	static double relativeError(double expected, double result) { if (Double.isNaN(expected) || Double.isInfinite(expected) || Double.isNaN(result) || Double.isInfinite(result) || expected == 0) return 0; return Math.abs(result-expected) / Math.abs(expected); }
	
	static String formatResult(double res) {
		return String.format("%.10g", res);
	}
	
	static int verifyCase(int casenum, double expected, double received) { 
		System.err.print("Example " + casenum + "... ");
		if (compareOutput(expected, received)) {
			System.err.print("PASSED");
			double rerr = relativeError(expected, received);
			if (rerr > 0) System.err.printf(" (relative error %g)", rerr);
			System.err.println();
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
			int[] x                   = {-2000,-2000};
			int[] y                   = {3000,3000};
			double expected__         = 0.0;

			return verifyCase(casenum__, expected__, new Shouting().shout(x, y));
		}
		case 1: {
			int[] x                   = {3,3,3,3,3,3,3};
			int[] y                   = {2,3,4,3,9,8,1};
			double expected__         = 4.0;

			return verifyCase(casenum__, expected__, new Shouting().shout(x, y));
		}
		case 2: {
			int[] x                   = {5,0,-5,0};
			int[] y                   = {0,5,0,-5};
			double expected__         = 7.0710678118654755;

			return verifyCase(casenum__, expected__, new Shouting().shout(x, y));
		}
		case 3: {
			int[] x                   = {17};
			int[] y                   = {1912};
			double expected__         = 0.0;

			return verifyCase(casenum__, expected__, new Shouting().shout(x, y));
		}

		// custom cases

/*      case 4: {
			int[] x                   = ;
			int[] y                   = ;
			double expected__         = ;

			return verifyCase(casenum__, expected__, new Shouting().shout(x, y));
		}*/
/*      case 5: {
			int[] x                   = ;
			int[] y                   = ;
			double expected__         = ;

			return verifyCase(casenum__, expected__, new Shouting().shout(x, y));
		}*/
/*      case 6: {
			int[] x                   = ;
			int[] y                   = ;
			double expected__         = ;

			return verifyCase(casenum__, expected__, new Shouting().shout(x, y));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
