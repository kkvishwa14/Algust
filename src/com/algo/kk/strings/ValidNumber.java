package com.algo.kk.strings;

public class ValidNumber {

	public static boolean isValidPositiveNumber(String num) {
		for(int i=0;i<num.length();i++){
			if(!(num.charAt(i)>='0' && num.charAt(i)<='9')){
				return false;
			}
		}
		return true;
	}
	public static boolean isValidNumber(String num){
		if(num.contains("-")){
			if(num.charAt(0)!='-'){
				return false;
			}else{
				return isValidPositiveNumber(num.substring(1));
			}
		}
		return isValidPositiveNumber(num);
	}
	public static boolean isValidExponentNumber(String num){
		num = num.trim();
		if(num.isEmpty()){
			return false;
		}
		if(num.contains("e"))
		{
			String parts[] = num.split("e");
			if(parts.length!=2){
				return false;
			}else {
				return isValidDouble(parts[0]) && isValidDouble(parts[1]);
			}
		}else{
			return isValidDouble(num);
		}
			
	}
	public static boolean isValidDouble(String num){
		if(num.contains("."))
		{
			String parts[] = num.split("\\.");
			if(parts.length!=2){
				return false;
			}else {
				return isValidNumber(parts[0]) && isValidPositiveNumber(parts[1]);
			}
		}else{
			return isValidNumber(num);
		}
	}
	public static int validNumber(String num) {
		
		return (isValidExponentNumber(num)?1:0);
	}
	public static void main(String[] args) {
		System.out.println("valid num ");
	}

}
