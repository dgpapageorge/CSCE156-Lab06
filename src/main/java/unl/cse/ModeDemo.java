package unl.cse;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ModeDemo {

	/**
	 * This method should return a map of integers x in the given list
	 * mapping to the multiplicity of x (the number of times x appears
	 * in the list).
	 * @param list
	 * @return
	 */
	public static Map<Integer, Integer> computeMultiplicities(List<Integer> list) {
		Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
		for (int i = 0;i<list.size();i++)
		{
			if (counts.get(list.get(i)) == null)
			{
				counts.put(list.get(i), 1);
			}
			else
			{
				counts.put(list.get(i),counts.get(list.get(i))+1);
			}
		}
		return counts;
	}
	
	/**
	 * This method takes a map (assumed to be a list of integers mapping
	 * to their multiplicity) and returns a set of all modes.
	 * @param m
	 * @return
	 */
	public static Set<Integer> findModes(Map<Integer, Integer> m) {
		Set<Integer> result = new HashSet<Integer>();
		int high = 0;
		
		for (Map.Entry<Integer, Integer> num : m.entrySet())
		{
			if (num.getValue() > high)
			{
				high = num.getValue();
				result.clear();
				result.add(num.getKey());
			}
			else if (num.getValue() == high)
			{
				result.add(num.getKey());
			}
		}
		
		return result;
	}
	
	public static List<Integer> loadFile() {
		
		List<Integer> numbers = new ArrayList<Integer>();
		try (Scanner s = new Scanner(new File("data/numbers.dat"))) {
			while(s.hasNext()) {
				numbers.add(s.nextInt());
			}
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
		return numbers;
	}
	
	public static void printMap(Map<Integer, Integer> m) {
		List<Integer> sortedKeys = new ArrayList<Integer>(m.keySet());
		Collections.sort(sortedKeys);
		for(Integer x : sortedKeys) {
			System.out.println(String.format("%4d appears %4d times", x, m.get(x)));
		}
	}
	
	public static void main(String args[]) {
		Map<Integer, Integer> m = computeMultiplicities(loadFile());
		printMap(m);
		Set<Integer> modes = findModes(m);
		System.out.println("modes: " + modes);
	}
}
