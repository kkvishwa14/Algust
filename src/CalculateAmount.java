import java.util.ArrayList;
import java.util.List;


public class CalculateAmount {

	
	/*
	* Complete the 'calculateAmount' function below.
	*
	* The function is expected to return a LONG_INTEGER.
	* The function accepts INTEGER_ARRAY prices as parameter.
	*/

	public static long calculateAmount(List<Integer> prices) {
	// Write your code here
		if(prices == null || prices.size() == 0){
			return 0l;
		}
		int minimumYet = 0;
		long answer = 0;
		int discountedPrice = 0;
		boolean takenFirstItem = false;
		for(int price : prices) {
			if(takenFirstItem) {
				discountedPrice = price - minimumYet;
				if(discountedPrice > 0){
					answer += discountedPrice;
				}
				if(price < minimumYet){
					minimumYet = price;
				}
			} else {
				answer += price;
				minimumYet = price;
				takenFirstItem = true;
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(5);
		list.add(1);
		//list.add(3);
		
		System.out.println(calculateAmount(list));
	}

}
