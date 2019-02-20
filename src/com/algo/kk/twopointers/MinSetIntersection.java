package com.algo.kk.twopointers;

import java.util.Arrays;

public class MinSetIntersection {
public static void main(String args[]) {
	int[][] intervals = new int[5][2];
	intervals[0][0]= 2;
	intervals[0][1]= 4;
	intervals[1][0]= 1;
	intervals[1][1]= 3;
	intervals[2][0]= 2;
	intervals[2][1]= 3;
	intervals[3][0]= 1;
	intervals[3][1]= 2;
	intervals[4][0]= 1;
	intervals[4][1]= 7;
	
	for(int i=0;i<intervals.length;i++){
		System.out.print(intervals[i][0] +" " +intervals[i][1]);
		System.out.println();
	}
	System.out.println("after sorting");
	Arrays.sort(intervals, (a, b) ->
    a[0] != b[0] ? a[0]-b[0] : b[1]-a[1]);
	
	for(int i=0;i<intervals.length;i++){
		System.out.print(intervals[i][0] +" " +intervals[i][1]);
		System.out.println();
	}
	
	
	
/*	
int[] todo = new int[intervals.length];
Arrays.fill(todo, 2);
int ans = 0, t = intervals.length;
while (--t >= 0) {
int s = intervals[t][0];
int e = intervals[t][1];
int m = todo[t];
for (int p = s; p < s+m; ++p) {
for (int i = 0; i <= t; ++i)
    if (todo[i] > 0 && p <= intervals[i][1])
        todo[i]--;
ans++;
}
}*/
//return ans;
}
}
