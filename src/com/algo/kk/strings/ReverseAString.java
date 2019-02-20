package com.algo.kk.strings;

public class ReverseAString {

	public static String reveseStr(String str) {
		if(str == null ||str.trim().isEmpty()){
			return "";
		}
		str = str.trim();
		String ansStr = "";
		String word = "";
		boolean spaceEncountered = false;
		for(int i=str.length() -1 ; i>=0;i--){
			char c = str.charAt(i);
			if(c == ' '){
				if(!spaceEncountered){
					
					ansStr += word + c;
					word = "";
					spaceEncountered = true;
				}
			} else{
				if(spaceEncountered){					
					spaceEncountered = false;
				}
				word = c + word;
			}
		}
		ansStr=ansStr + word;
		return ansStr;
	}
	public static void main(String[] args) {
		
     System.out.println(reveseStr("the sky is blue"));
     System.out.println(reveseStr("the    sky  is            blue"));
	}

}
