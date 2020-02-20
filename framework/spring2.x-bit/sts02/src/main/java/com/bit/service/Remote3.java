package com.bit.service;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Remote3 {
	Map<String,String> map;
	
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	
	
	
//	Set<String> set;
//	
//	public void setSet(Set<String> set) {
//		this.set = set;
//	}
	
//	ArrayList<String> alist;
//	
//	public void setAlist(ArrayList<String> alist) {
//		this.alist = alist;
//	}
	
//	String[] arr;
//	
//	public void setArr(String[] arr) {
//		this.arr = arr;
//	}
	
	public void func1() {
//		for(String msg: map.keySet())
//			System.out.println(msg+":"+map.get(msg));
		Set<Entry<String, String>> ent = map.entrySet();
		Iterator<Entry<String, String>> ite = ent.iterator();
		while(ite.hasNext()) {
			Entry<String, String> obj = ite.next();
			System.out.println(obj.getKey()+":"+obj.getValue());
		}
	}
}









