package com.algo.kk.stacks;

import java.util.Stack;

public class EvaluateRPN {

	public static int evalRPN(String[] a) {
	     Stack<Integer> exp = new Stack<Integer>();
	     //Stack<String> operators = new Stack<String>();
	     String operators = "+*-/";
	     for(int i = 0; i < a.length; i++){
	         String c = a[i];
	         
	         if(!operators.contains(c))
	             exp.push(Integer.parseInt(c));
	         else {
	             int x = exp.pop();
	             int y = exp.pop();
	             String op = c;
	             if(op == "+")
	                 exp.push(x + y);
	             else if(op == "-")
	                 exp.push(y - x);
	             else if(op == "*")
	                 exp.push(y * x);
	             else if(op == "/")
	                 exp.push(y / x);
	         }
	     }
	     return exp.pop();
	}
	public static void main(String[] args) {
		String [] exp = {"2","1","+","3","*"};
System.out.println(evalRPN(exp));
	}

}
