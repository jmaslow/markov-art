//Eli Rosenberg & Evan Lowy


import java.util.*;
import java.util.Map.Entry;
public class Markov {
    ArrayList<Integer> locations = new ArrayList<Integer>();
    boolean last = false;
    int k; // sub length
    String sub;
    int count = 0; //num times substring appears
   // char firstK;
    
    TreeMap<Character,Integer> suffixes = new TreeMap<Character,Integer>();
    
    public Markov(String substring) {
	sub = substring;
	k = substring.length();
	count = 1;
    }
    
    public Markov(String substring, Integer l) {
	sub = substring;
	k = substring.length();
	count = 1;
	locations.add(l);
    }
    
    public void add() {
	count++;
    }
    
    public void add(char c) {
	if(!suffixes.containsKey(c)) {
	    suffixes.put(c, 1);
	    //count++;
    }
	else 
	    suffixes.put(c, suffixes.get(c) + 1);
	//count++;
    }
    
    public String toString() {
	return ((Integer)count).toString(); 
    }
    
    public char[] randomHelper() {
	TreeMap<Character,Integer> suffixCopy = (TreeMap<Character, Integer>) suffixes.clone();
	MyHashMap<Character,Double> probs = new MyHashMap<Character,Double>();
	char[] returns = new char[100];
	int arrayLocation = 0;
	suffixCopy = (TreeMap<Character, Integer>) suffixes.clone();
	for(int i = 0; i <= suffixCopy.size(); i++) {
	   Entry<Character, Integer> e = suffixCopy.pollFirstEntry();
	   //System.out.println(e);
	   //if(e != null)
	   probs.put(e.getKey(), (((double)e.getValue() / (double) count) *100));
	   
    }
	Iterator<Character> kitr = probs.keys();
	while(kitr.hasNext()) {
	    Character c = kitr.next(); 
	    for(int i = 0; i < probs.get(c) ; i++) {
		returns[arrayLocation + i ] = c;
	    }
	    arrayLocation += probs.get(c);
	}
	
	return returns;
    }
    public Character random() {
	char[] c = randomHelper(); 
	double r = Math.random()*100;
	return c[(int)r];

}
    /*
    public static void main(String[] args) {
	SuffixCounter sc = new SuffixCounter(2, "agggcagcgggcg");
	sc.generateSuffixes();
	Iterator<Markov> vitr = sc.FrequencyTable.values();
	//while(vitr.hasNext()) {
	    System.out.println(vitr.next().random()); 
	//}
    }
    */
    }

