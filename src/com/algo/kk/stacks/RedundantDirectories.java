package com.algo.kk.stacks;

import java.util.Stack;

public class RedundantDirectories {

	public static void main(String[] args) {
		String path ="/a/./b/../../c/";
		String[] folders = path.split("/");
		Stack<String> stk = new Stack<String>();
		for(int i=1;i<folders.length;i++){
			String folder = folders[i];
			if(folder.equals(".")|| folder.equals("")){
				continue;
			} else if(folder.equals("..")){
				if(!stk.isEmpty()){
					stk.pop();
				}
			}else{
				stk.push(folder);
			}
		}
		StringBuilder ans = new StringBuilder("");
		
	
		System.out.println(ans);

	}

}
