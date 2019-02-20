package com.algo.kk.twopointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClosestStraightCity {

	public static List<String> closesStraightCity(List<String> cityName, List<Integer> x,List<Integer>y, List<String> querycities){
		List<String> closestCityNames = new ArrayList<String>();
	    Map<Integer, List<Integer>>	xCommonCityIndex = new HashMap<Integer, List<Integer>>();
	    Map<Integer, List<Integer>>	yCommonCityIndex = new HashMap<Integer, List<Integer>>();
	    
	    for(int i=0;i<x.size();i++){
	    	int xI = x.get(i);
	    	if(xCommonCityIndex.containsKey(xI)){
	    		List<Integer> cityIndex = xCommonCityIndex.get(xI);
	    		cityIndex.add(i);
	    	}else{
	    		List<Integer> cityIndex = new ArrayList<Integer>();
	    		cityIndex.add(i);
	    		xCommonCityIndex.put(xI, cityIndex);
	    	}
	    }
	    
	    for(int i=0;i<y.size();i++){
	    	int yI = y.get(i);
	    	if(yCommonCityIndex.containsKey(yI)){
	    		List<Integer> cityIndex = yCommonCityIndex.get(yI);
	    		cityIndex.add(i);
	    	}else{
	    		List<Integer> cityIndex = new ArrayList<Integer>();
	    		cityIndex.add(i);
	    		yCommonCityIndex.put(yI, cityIndex);
	    	}
	    }
	    
	    
	    for(String qCity : querycities){
	    	int index = cityName.indexOf(qCity);
	    	int xQ = x.get(index);
	    	int yQ = y.get(index);
	    	
	    	int closestDistance = Integer.MAX_VALUE;
	    	int closestIndex = -1;
	    	List<Integer> commonXI = xCommonCityIndex.get(xQ);
	    	for(int ind : commonXI){
	    		
	    		if(ind != index){
	    			int yInd = y.get(ind);
	    			int dist = Math.abs(yQ - yInd);
	    			if(dist < closestDistance){
	    				closestDistance = dist;
	    				closestIndex = ind;
	    			}
	    		}
	    	}
	    	
	    	List<Integer> commonYI = yCommonCityIndex.get(yQ);
	    	for(int ind : commonYI){
	    		
	    		if(ind != index){
	    			int xInd = x.get(ind);
	    			int dist = Math.abs(xQ - xInd);
	    			if(dist < closestDistance){
	    				closestDistance = dist;
	    				closestIndex = ind;
	    			}
	    		}
	    	}
	    	closestCityNames.add(cityName.get(closestIndex));
	    }
	    return closestCityNames;
	}
	
	
	public static void main(String[] args) {
		List<String> cityNames = new ArrayList<String>();
		cityNames.add("f");
		cityNames.add("b");
		cityNames.add("x");
		
		List<Integer> x = new ArrayList<Integer>();
		x.add(23);
		x.add(23);
		x.add(23);
		
		List<Integer> y = new ArrayList<Integer>();
		y.add(1);
		y.add(10);
		y.add(20);
		
		System.out.println(closesStraightCity(cityNames, x, y, cityNames));
	}

}
