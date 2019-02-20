package com.algo.kk.strings;
import java.math.BigInteger;


public class CompareVersions {

	public static int compareVersion(String A, String B) {
        String[] aParts = A.split("\\.");
        String[] bParts = B.split("\\.");
        
        int i=0,j=0;
        while(i<aParts.length && j<bParts.length){
        	BigInteger aVer = new BigInteger(aParts[i]);
        	BigInteger bVer = new BigInteger(bParts[j]);
        	if(aVer.compareTo(bVer)!=0){
        		return aVer.compareTo(bVer);
        	}
        	i++;
        	j++;
        }
        BigInteger zero = new BigInteger("0");
        if(i<aParts.length){
        	if(i==aParts.length-1){
        		BigInteger aVer = new BigInteger(aParts[i]);
        		if(aVer.compareTo(zero)==0){
        			return 0;
        		}
        	}
        	return 1;
        }
        
        if(j<bParts.length){
        	if(j==bParts.length-1){
        		BigInteger bVer = new BigInteger(bParts[j]);
        		if(bVer.compareTo(zero)==0){
        			return 0;
        		}
        	}
        	return -1;
        }
        
        return 0;
    }

	public static void main(String[] args) {
		
		compareVersion("1.34", "1.2.34");
	}

}
