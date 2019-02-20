package com.algo.kk.strings;

public class ZigZagString {

	public static String ans(String inp, int rows){
		if(rows==1|| inp.isEmpty()){
			return inp;
		}
		if(inp.length()<= rows){
			return inp;
		}
		String ans = "";
		int gap = (rows-1)*2 -1;
		int midGap = -1;
		boolean crossedLength = false;
		int start = 0;
		for(int i=0;i<rows;i++){
			boolean useMidGap = false;
			if(i==rows-1){
				useMidGap = true;
			}
			int ind = start;
			while(!crossedLength){
				if(ind >= inp.length()-1){
					crossedLength = true;
					if(ind > inp.length() -1)
					break;
				}
				ans += inp.charAt(ind);
				if(!useMidGap||midGap == -1){
					ind = ind + gap + 1;
					if(midGap != -1)
					  useMidGap = !useMidGap;
					
				} else {
					ind = ind + midGap + 1;
					if(i!=rows-1)
						useMidGap = !useMidGap;
				}
			}
			crossedLength = false;
			midGap += 2;
			gap -= 2;
			start++;
			
		}
		return ans;
	}
	public static void main(String[] args){
		System.out.println(ans("PAYPALISHIRING",4));
	}
}
