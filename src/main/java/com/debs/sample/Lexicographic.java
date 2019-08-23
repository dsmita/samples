package com.debs.sample;

import java.util.Arrays;
import java.util.List;

public class Lexicographic {

	public static void insert(CustomTrie head, String str) {
		CustomTrie curr = head;

		for (int i = 0; i < str.length(); i++) {
			if (curr.character[str.charAt(i) - 'a'] == null) {
				curr.character[str.charAt(i) - 'a'] = new CustomTrie();
			}
			curr = curr.character[str.charAt(i) - 'a'];
		}
		curr.key = str;
	}

	public static void preorder(CustomTrie curr) {
		if (curr == null)
			return;
		for (int i = 0; i < 26; i++) {
			if (curr.character[i] != null) {
				if (curr.character[i].key != null) {
					System.out.println(curr.character[i].character[i]);
				}
				preorder(curr.character[i]);
			}
		}
	}

	public static void main(String[] args) {
		List<String> dict = Arrays.asList("lexicographic", "sorting", "of", "a", "set", "of", "keys", "can", "be",
				"accomplished", "with", "a", "simple", "trie", "based", "algorithm", "we", "insert", "all", "keys",
				"in", "a", "trie", "output", "all", "keys", "in", "the", "trie", "by", "means", "of", "preorder",
				"traversal", "which", "results", "in", "output", "that", "is", "in", "lexicographically", "increasing",
				"order", "preorder", "traversal", "is", "a", "kind", "of", "depth", "first", "traversal");
		CustomTrie head = new CustomTrie();

		// insert all keys of dictionary into trie
		for (String word : dict) {
			insert(head, word);
		}

		// print keys in lexicographic order
		preorder(head);

	}

}
