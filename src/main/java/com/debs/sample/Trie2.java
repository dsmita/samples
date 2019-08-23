package com.debs.sample;

public class Trie2 {
	
	private TrieNode2 root;
	
	public Trie2(){
		root = new TrieNode2();
	}
	
	public void insert(String word){
		TrieNode2 p = root;
		for(int i=0;i<word.length();i++){
			char c = word.charAt(i);
			int index = c-'a';
			if(p.arr[index]== null){
				TrieNode2 temp= new TrieNode2(c);
				p.arr[index]= temp;
				p=temp;
			} else{
				p=p.arr[index];
			}
		}
		p.leaf=true;
	}
	
	public boolean searchString(String word){
		TrieNode2 node = search(word);
		if(node != null && node.leaf){
			return true;
		}
		return false;
	}
	
	public boolean isPrefix(String word){
		TrieNode2 node = search(word);
		if(node != null){
			return true;
		}
		return false;
	}
	
	public TrieNode2 search(String word){
		TrieNode2 p = root;
		for(int i=0;i<word.length();i++){
			char c = word.charAt(i);
			int index = c-'a';
			if(p.arr[index] != null){
				p=p.arr[index];
			} else
				return null;
		}
		
		if(p==root)
			return null;
		return p;
	}
	

}
