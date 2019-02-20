package com.algo.kk.strings;

public class MinimumWindowSubstring {


    public String minWindow(String S, String T) {
        int[] tProcessed = new int[256];
        for(int i=0; i<T.length();i++)
            tProcessed[T.charAt(i)]++;
        int begin = 0;
        int lettersFound = 0;
        int end = 0;
        int minWindow = Integer.MAX_VALUE;
        int startMinWindow = -1;
        int[] window = new int[256];
        while(end<S.length())
        {
            window[S.charAt(end)]++;
            if (window[S.charAt(end)]<=tProcessed[S.charAt(end)])
                lettersFound++;
            if (lettersFound>=T.length())
            {
                while(window[S.charAt(begin)]>tProcessed[S.charAt(begin)])
                {
                    window[S.charAt(begin)]--;
                    begin++;
                }
                if(end+1-begin<minWindow)
                {
                    startMinWindow = begin;
                    minWindow = end+1-begin;
                }
            }
            end++;
        }
        if (startMinWindow == -1)
            return "";
        return S.substring(startMinWindow,startMinWindow+minWindow);
    }

	public static void main(String[] args) {
		
		MinimumWindowSubstring mws = new MinimumWindowSubstring();
		mws.minWindow("0mJdGXwLm9AOZ5xA8u92KDYqGJroQ537hoRXjQoUCMOpDYwxoNjexJGWQJAIxSFF3ZbIe27oFxUTJxtv8mORwpuRZn30MDj3kXRW2Ix3lslj7kwmGZPXAKhBW4q5T2BzsqbL0ZETFqRdxVm8GCGfqshvpWzsRvprUcF9vw3VlftqTRzKRzr4zYB2P6C7lg3I7EhGMPukUj8XGGZTXqPqnCqes", "rsm2ty04PYPEOPYO5");
	}

}
