package com.debs.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* This class will be given a list of words (such as might be tokenized
 * from a paragraph of text), and will provide a method that takes two
 * words and returns the shortest distance (in words) between those two
 * words in the provided text.
 * Example:
 *   WordDistanceFinder finder = new WordDistanceFinder(Arrays.asList("the", "quick", "brown", "fox", "quick"));
 *   assert(finder.distance("fox", "the") == 3);
 *   assert(finder.distance("quick", "fox") == 1);
 *
 * "quick" appears twice in the input. There are two possible distance values for "quick" and "fox":
 *     (3 - 1) = 2 and (4 - 3) = 1.
 * Since we have to return the shortest distance between the two words we return 1.
 */
public class WordDistanceFinder {
    static Map<String, ArrayList<Integer>> map= new HashMap<String,ArrayList<Integer>>();
    public WordDistanceFinder (List<String> words) {
        int i=0;
        for(String word:words){
            if(map.containsKey(word)){
                List<Integer> rankList = map.get(word);
                rankList.add(i);
                i++;
            }else{
            	ArrayList<Integer> rankList = new ArrayList<Integer>();
                rankList.add(i);
                map.put(word,rankList);
                i++;
            }
        }
    }
    public int distance (String wordOne, String wordTwo) {
        if(map.containsKey(wordOne) && map.containsKey(wordTwo)){
            List<Integer> rankList1 = map.get(wordOne);
            List<Integer> rankList2 = map.get(wordTwo);

            int length1= rankList1.size();
            int length2=rankList2.size();
            if(length1 ==1 && length2==1){
                return Math.abs(rankList1.get(0) -rankList2.get(0));
            }else{
                int minDiff =Integer.MAX_VALUE;
                for(int i=0;i<length1;i++){
                    for(int j=0; j<length2;j++){
                        minDiff = Math.min(minDiff, Math.abs(rankList1.get(i) -rankList2.get(j)));
                    }
                }
                return minDiff;
            }
        } else
         return -1;
        
    }
    
    public static void main(String[] args) {
    	/*ArrayList<Integer> l1= new ArrayList<Integer>();
    	l1.add(1);
    	ArrayList<Integer> l2= new ArrayList<Integer>();
    	l2.add(2);
    	l2.add(5);
    	ArrayList<Integer> l3= new ArrayList<Integer>();
    	l3.add(3);
    	ArrayList<Integer> l4= new ArrayList<Integer>();
    	l4.add(4);
		map.put("the", l1 );
		map.put("quick", l2);
		map.put("brown", l3);
		map.put("fox", l4);*/
    	List<String> words = new ArrayList<String>();
    	words.add("the");
    	words.add("quick");
    	words.add("brown");
    	words.add("fox");
    	words.add("quick");
    	WordDistanceFinder wordDistanceFinder = new WordDistanceFinder(words);
		System.out.println(wordDistanceFinder.distance("fox", "the"));
	}
}
