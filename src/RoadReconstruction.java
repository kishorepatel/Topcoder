import java.util.*;

public class RoadReconstruction {
    //DSU
    
    int[] p;
    public void dsu(int N){
        p = new int[N];
        for(int i = 0; i < N; i++) p[i] = i;
    }
    public int getParent(int x){
        if(p[x] == x) return x;
        else return p[x] = getParent(p[x]);
    }
    public void connect(int x, int y){
        x = getParent(x);
        y = getParent(y);
        if(x != y){
            p[x] = y;
        }
    }
    
   class Destroy implements Comparable<Destroy>{
       String id;
       int from, to, cost;
       Destroy(String id, int f, int t, int c){
           this.id = id;
           from = f; to =t ; cost = c;
       }
       public int compareTo(Destroy b){
           if(cost == b.cost) return id.compareTo(b.id);
           return cost - b.cost;
       }
   } 
   
   
   public String selectReconstruction(String[] roads) {
       String[][] parse = new String[roads.length][4];
       for(int i = 0; i < roads.length; i++){
           Arrays.fill(parse[i], "");
           parse[i] = roads[i].split(" ");
       }
       
       Map<String, Integer> cityId = new HashMap<String , Integer>();
       int N = 0;
       for(int i = 0; i < roads.length; i++){
           for(int j = 1; j <= 2; j++){
               if(! cityId.containsKey(parse[i][j])){
                   cityId.put(parse[i][j], N++);
               }
           }
       }
        
       dsu(N);
       PriorityQueue<Destroy> pqd = new PriorityQueue<>();
       for(int i = 0; i < roads.length; i++){
           if(parse[i].length == 3 || parse[i][3].length() == 0){
               connect(cityId.get(parse[i][1]), cityId.get(parse[i][2]));
           }
           else{
               pqd.add(new Destroy(parse[i][0],cityId.get(parse[i][1]), cityId.get(parse[i][2]), Integer.parseInt(parse[i][3]) ));
           }
       }
       
       int sz = pqd.size();
       ArrayList<String> codes = new ArrayList<>();
       for(int i = 0; i < sz; i++){
           Destroy now = pqd.poll();
           if(getParent(now.from) != getParent(now.to)){
               connect(now.from, now.to);
               codes.add(now.id);
           }
       }
       
       
       for(int i = 0 ; i< N; i++){
           for(int j = i+1; j < N; j++){
               if(getParent(i) != getParent(j)) return "IMPOSSIBLE";
           }
       }
       
       String ans = "";
       Collections.sort(codes);
       for(int i = 0; i < codes.size(); i++) ans += " " + codes.get(i);
       
       if(codes.size() == 0) return ans;
       else return ans.substring(1);
       
   }















// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			RoadReconstructionHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				RoadReconstructionHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class RoadReconstructionHarness {
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
	
	static boolean compareOutput(String expected, String result) { return expected.equals(result); }
	static String formatResult(String res) {
		return String.format("\"%s\"", res);
	}
	
	static int verifyCase(int casenum, String expected, String received) { 
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
			String[] roads            = {"M1 Moscow Kiev 1", "M2 Minsk Kiev", "M3 Minsk Warsaw"};
			String expected__         = "M1";

			return verifyCase(casenum__, expected__, new RoadReconstruction().selectReconstruction(roads));
		}
		case 1: {
			String[] roads            = {"R1 NY Washington", "M1 Moscow StPetersburg 1000"};
			String expected__         = "IMPOSSIBLE";

			return verifyCase(casenum__, expected__, new RoadReconstruction().selectReconstruction(roads));
		}
		case 2: {
			String[] roads            = {"B1 Bratislava Havka"};
			String expected__         = "";

			return verifyCase(casenum__, expected__, new RoadReconstruction().selectReconstruction(roads));
		}
		case 3: {
			String[] roads            = {"M1 Moscow StPetersburg 1", "M2 Moscow Saratov 2", "S0 Saratov StPetersburg"};
			String expected__         = "M1";

			return verifyCase(casenum__, expected__, new RoadReconstruction().selectReconstruction(roads));
		}
		case 4: {
			String[] roads            = {"O1 Beetown Fearnot 6","N7 Fearnot Hornytown","M8 Hornytown Belcher 10",
 "L5 Belcher Fearnot 8","C7 Fearnot Beetown 4","K7 Quiggleville Beetown 12",
 "H4 Beetown DryFork 6","Z0 Hornytown Belcher 1","O5 Belcher Quiggleville 10",
 "U7 Quiggleville Fearnot 2","A8 Fearnot Quiggleville 8","T6 Beetown DryFork 17",
 "E8 Quiggleville DryFork 8","Y4 DryFork Quiggleville 4","Q8 Hornytown DryFork 2",
 "J9 Quiggleville DryFork 19","M4 DryFork Quiggleville 7","T1 DryFork Fearnot 9",
 "G4 Fearnot DryFork 6","V9 Hornytown Beetown 5","O6 Quiggleville Beetown 4",
 "L8 Beetown Roachtown 5","D5 Belcher DryFork 8","W5 Belcher DryFork 1"};
			String expected__         = "C7 L8 U7 W5 Z0";

			return verifyCase(casenum__, expected__, new RoadReconstruction().selectReconstruction(roads));
		}

		// custom cases

/*      case 5: {
			String[] roads            = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new RoadReconstruction().selectReconstruction(roads));
		}*/
/*      case 6: {
			String[] roads            = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new RoadReconstruction().selectReconstruction(roads));
		}*/
/*      case 7: {
			String[] roads            = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new RoadReconstruction().selectReconstruction(roads));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
