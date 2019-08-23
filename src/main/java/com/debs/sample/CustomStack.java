package com.debs.sample;

import java.util.List;

public class CustomStack{
	
	Integer count;
	List<Integer> list;
	
	public Integer pushItem(Integer item){
		addElement(item);
		return item;
	}
	
	public void addElement(Integer item){
		list.add(item);
		count++;
	}
	
	public Integer popItem(){
		Integer removed = list.remove(count-1);
		count--;
		return removed;
	}

	public Integer peek(){
		return list.get(count -1);
	}
	
	public Integer search(Integer i){
		if(list.contains(i)){
			return list.indexOf(i);
		}
		return null;
	}
	
	public Integer max(){
		int max =0;
		if(count ==0)
			return 0;
		else if(count ==1 )
			return list.get(0);
		else{
			for(Integer i : list){
				if(list.get(i) > max){
					max = list.get(i);
				}
			}
			return max;
		}
	}
}
