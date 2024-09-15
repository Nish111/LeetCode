package medium;

import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate {
// // https://leetcode.com/problems/dota2-senate/?envType=study-plan-v2&envId=leetcode-75
	public String predictPartyVictoryBest(String senate) {
        return voting(senate.toCharArray(), 0);
    }

    public String voting(char[] senate, int vote) {
        int d = 0;
        int r = 0;

        for (int i = 0; i < senate.length; i++) {
            if (senate[i] == 'R') {
                if (vote >= 0) {
                    r++;
                } else {
                    senate[i] = '0';
                }
                vote++;
            } else if (senate[i] == 'D') {
                if (vote <= 0) {
                    d++;
                } else {
                    senate[i] = '0';
                }
                vote--;
            }
        }
        if (d != 0 && r == 0) {
            return "Dire";
        } else if (r != 0 && d == 0) {
            return "Radiant";
        } else {
            return voting(senate, vote);
        }
    }
	public String predictPartyVictory(String senate) {
        Queue<Integer> qr = new LinkedList<>();
        Queue<Integer> qd = new LinkedList<>();
        int n = senate.length();
        for(int i = 0;i < n;i++){
            if(senate.charAt(i) == 'R') qr.add(i);
            else qd.add(i);
        }
        for(;!qr.isEmpty() && !qd.isEmpty();){
            int r_i = qr.poll();
            int d_i = qd.poll();
            if(r_i < d_i) qr.add(r_i + n);
            else qd.add(d_i + n);
        }
        return qr.size() > qd.size() ? "Radiant" : "Dire";
    }
	public String predictPartyVictory2(String senate) {// Wrong
		   int countD=0, countR=0;
		   char temp = senate.charAt(0);
		   for(int i=0; i<senate.length(); i++) {
			   if(senate.charAt(i)=='D') {
				   if(countD>=0) {
					   countR--; countD++;
					   //if(i==senate.length()-1)countD--;
				   }
				   else countD++;
			   }
			   else if(senate.charAt(i)=='R') {
				   if(countR>=0) {
					   countD--; countR++;
					   //if(i==senate.length()-1)countR--;
				   }
				   else countR++;
			   }
		
			   
		   }
		   if(countD==countR) {
			   if(temp=='D') return "Dire";
			   else return "Radiant";
		   }
		   if(countD>countR) return "Dire";
		   else return "Radiant";
	   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dota2Senate ds = new Dota2Senate();
		String s = "DDRRR";
		System.out.println(ds.predictPartyVictory(s));// Dire
		String s2 = "DRDRDRR";
		System.out.println(ds.predictPartyVictory(s2));// Dire
		String s3 = "DRRDRDRDRDDRDRDR";
		System.out.println(ds.predictPartyVictory(s3));// Radiant
	}

}
