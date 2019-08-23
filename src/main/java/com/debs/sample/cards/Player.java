package com.debs.sample.cards;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	List<Card> hand;
	
	public Player(){
		hand = new ArrayList<>();
	}
	
	public void addCard(Card card){
		hand.add(card);
	}
	
	public void removeCard(Card card){
		hand.remove(card);
	}
	
	public int getCardsValue(){
		int value =0;
		for(Card card:hand){
			value = value + card.getRank().getValue();
		}
		return value;
	}

}
