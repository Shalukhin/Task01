package main;

import java.util.HashSet;

public class Runner {
	public static void main(String[] args) {
		HashSet<Integer> a = new HashSet<Integer>();
		
		a.add(new Integer(0));
		a.add(null);
		System.out.println(a.size());
		
	}

}
