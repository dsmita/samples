package com.debs.sample.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	
	List<Card> totalCards = new ArrayList<Card>();
	
	public Deck() {
		for (Suit suit : Suit.values()) {
			for (int i = 1; i < 13; i++) {
				Card card= new Card(suit, Rank.getRank(i)); 
				totalCards.add(card);
			}
		}
	}
	
	public void shuffle(){
		for(int i=0;i<52;i++){
			double rand1 = Math.random();
			double rand2 = Math.random();
			if(rand1 > 0.52){
				rand1 = Math.floor((rand1/2)*100);
			} else
				rand1 = Math.floor(rand1*100);
			if(rand2 > 0.52){
				rand2 = Math.floor((rand2/2)*100);
			} else
				rand2 = Math.floor(rand2*100);
			
			Collections.swap(totalCards, (int) rand1, (int) rand2);
		}
		
	}
	
	public Card getCard(){
		Card removedCard = totalCards.remove(0);
		return removedCard;
	}

}
