/*
 * You are playing the following Bulls and Cows game with 
 * your friend: You write down a number and ask your 
 * friend to guess what the number is. Each time your 
 * friend makes a guess, you provide a hint that indicates 
 * how many digits in said guess match your secret number exactly 
 * in both digit and position (called "bulls") and how many digits 
 * match the secret number but locate in the wrong position 
 * (called "cows"). Your friend will use successive guesses and 
 * hints to eventually derive the secret number.

For example:
Secret number: "1807"
Friend's guess: "7810"

Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
Write a function to return a hint according to the secret number and 
friend's guess, use A to indicate the bulls and B to indicate the 
cows. In the above example, your function should return "1A3B".
 */
import java.util.*;
public class BullsNCows {
	//Using HashMap
	public String getHint(String secret, String guess) {
		int countBulls = 0;
		int countCows = 0;
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		// Check bulls
		for(int i=0; i<secret.length(); i++) {
			char c1 = secret.charAt(i);
			char c2 = guess.charAt(i);
			if(c1 == c2) {
				countBulls++;
			}else {
				if(map.containsKey(c1)) {
					map.put(c1, map.get(c1)+1);
				}else {
					map.put(c1, 1);
				}
			}
		}
		
		//Check cow
		for(int i=0; i<secret.length(); i++) {
			char c1 = secret.charAt(i);
			char c2 = guess.charAt(i);
			
			if(c1 != c2) {
				if(map.containsKey(c2)) {
					countCows++;
					if(map.get(c2) == 1) {
						map.remove(c2);
					}else {
						map.put(c2, map.get(c2) - 1);
					}
				}
			}
		}
		
		return countBulls+"A"+countCows+"B";
	}
	
	//Using Array
	/*
	 * Since the secret and guess only contain numbers and there 
	 * are at most 10 possible digits, we can use two arrays to 
	 * track the frequency of each digits in secret and guess.
	 */
	public String getHint1(String secret, String guess) {
		int countBulls = 0;
		int countCows = 0;
		
		int[] arr1 = new int[10];
		int[] arr2 = new int[10];
		
		for(int i = 0; i < secret.length(); i++) {
			char c1 = secret.charAt(i);
			char c2 = guess.charAt(i);
			
			if(c1 == c2) {
				countBulls++;
			}else {
				arr1[c1-'0']++;
				arr2[c2-'0']++;
			}
		}
		
		for(int i=0; i<10; i++) {
			countCows += Math.min(arr1[i], arr2[i]);
		}
		return countBulls+"A"+countCows+"B";
	}
	
	public static void main(String[] args) {
		BullsNCows bnc = new BullsNCows();
		String secret = "1807";
		String guess = "7801";
		System.out.println(bnc.getHint(secret, guess));
		System.out.println(bnc.getHint1(secret, guess));
	}

}
