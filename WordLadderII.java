import java.util.*;

/*
 * Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that: 1) Only one letter can be changed at a time, 2) Each intermediate word must exist in the dictionary.

For example, given: start = "hit", end = "cog", and dict = ["hot","dot","dog","lot","log"], return:

  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
 * 
 * his is an extension of Word Ladder.

The idea is the same. To track the actual ladder, we need to add a pointer that points to 
the previous node in the WordNode class.

In addition, the used word can not directly removed from the dictionary. 
The used word is only removed when steps change.
 */

public class WordLadderII {

	class WordNode {
		String word;
		int numSteps;
		WordNode pre; // points to the previous node
		
		// constructor
		public WordNode(String word, int numSteps, WordNode pre) {
			this.word = word;
			this.numSteps = numSteps;
			this.pre = pre;
		}
	}
	
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		List<List<String>> result = new ArrayList<List<String>>(); // The possible paths in this
		
		LinkedList<WordNode> queue = new LinkedList<WordNode>();
		queue.add(new WordNode(start, 1, null));
		
		dict.add(end);
		int minSteps = 0;
		
		HashSet<String> visited = new HashSet<String>();
		HashSet<String> unvisited = new HashSet<String>();

		unvisited.addAll(dict); //initially all word in the dictionary are unvisited
		
		int preNumSteps = 0;
		while(!queue.isEmpty()) {
			WordNode top = queue.remove();
			String word = top.word;
			int currNumSteps = top.numSteps;
			
			if(word.equals(end)) {
				if(minSteps == 0) {
					minSteps = top.numSteps;
				}
				
				if(top.numSteps == minSteps && minSteps != 0) {
					ArrayList<String> t = new ArrayList<String>();
					t.add(top.word);
					while(top.pre != null) {
						t.add(0, top.pre.word);
						top = top.pre;
					}
					result.add(t);
					continue;
				}
			}
			
			if(preNumSteps < currNumSteps) {
				unvisited.removeAll(visited);
			}
			
			preNumSteps = currNumSteps;
			
			char[] arr = word.toCharArray();
			for(int i=0; i<arr.length; i++) {
				for(char c = 'a'; c < 'z'; c++) {
					char temp = arr[i];
					if(arr[i] != c) {
						arr[i] = c;
					}
					
					String newWord = new String(arr);
					if(unvisited.contains(newWord)) {
						queue.add(new WordNode(newWord, top.numSteps+1, top));
						visited.add(newWord);
					}
					arr[i] = temp;
				}
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		WordLadderII wd2 = new WordLadderII();
		HashSet<String> hs = new HashSet<>();
		hs.add("hot");
		hs.add("dot");
		hs.add("dog");
		hs.add("lot");
		hs.add("log");
		
		System.out.println(wd2.findLadders("hit", "cog", hs));
		
		
	}

}










