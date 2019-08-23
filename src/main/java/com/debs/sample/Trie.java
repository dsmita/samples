package com.debs.sample;

import java.util.HashMap;

public class Trie {
	
	private TrieNode root;
	
	public Trie(){
		root = new TrieNode();
	}
	
	public void insert(String word){
		HashMap<Character, TrieNode> children= root.children;
		
		for(int i=0;i < word.length();i++){
			char c = word.charAt(i);
			
			TrieNode t;
			if(children.containsKey(c)){
				t = children.get(c);
			} else{
				t = new TrieNode(c);
				children.put(c,t);
			}
			
			children = t.children;
			if(i == (word.length()-1)){
				t.isLeaf =true;
			}
		}
	}
	
	public boolean searchString(String word){
		TrieNode t = search(word);
		if(t != null && t.isLeaf)
			return true;
		return false;
	}
	
	public TrieNode search(String word){
		HashMap<Character, TrieNode> children= root.children;
		TrieNode t = null;
		for(int i=0; i< word.length();i++){
			char c = word.charAt(i);
			
			if(children.containsKey(c)){
				t= children.get(c);
				children = t.children;
			} else{
				return  null;
			}
		}
		return t;
	}
	
	public boolean startsWith(String prefix){
		TrieNode t = search(prefix);
		if(t == null){
			return false;
		}
		return true;
	}

	
	
}
