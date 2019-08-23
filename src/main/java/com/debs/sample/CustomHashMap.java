package com.debs.sample;

public class CustomHashMap {
	
	private int BUCKET_ARRAY_SIZE = 256;
	private HashMapNode bucketArray[] = new HashMapNode[BUCKET_ARRAY_SIZE];
	
	public String get(String key){
		int hash = Math.abs(key.hashCode()% BUCKET_ARRAY_SIZE);
		HashMapNode node = bucketArray[hash];
		if(node == null){
			return null;
		} else{
			while(node != null){
				if(node.getKey().equals(key)){
					return node.getValue();
				}else{
					node = node.getNext();
				}
			}
		}
		return null;
	}
	
	public void put(String key, String value){
		int hash = Math.abs(key.hashCode()%BUCKET_ARRAY_SIZE);
		HashMapNode node = bucketArray[hash];
		HashMapNode newNode = new HashMapNode(key,value);
		if(node == null){
			bucketArray[hash] = newNode;
		} else{
			while(node.getNext()!=null){
				if(node.getKey().equals(key)){
					node.setValue(value);
					return;
				} else{
					node = node.getNext();
				}
					
			}
			node.setNext(newNode);
		}
	}

}
