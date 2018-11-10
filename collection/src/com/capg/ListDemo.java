package com.capg;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
	public static void main(String[] args)
	{
		List<Object> list = new ArrayList();
		list.add(new Integer(5));
		list.add(4);
		list.add("Ram");
		
		list.remove(0);
		System.out.println(list);
		System.out.println(list.size());
		
		for (Integer i : list) {
			System.out.println(i);
			
		}
	}

}
