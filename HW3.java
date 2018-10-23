import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Scanner;

/**
 * @author TODO: B0444238 詹子霆
 *  一開始 定義了兩個ArrayList 
 *  兩個型態皆為Card 名稱usedCard,cards
 *  再新增變數叫做nUsed 表示發牌的次數
 *  把Random這個藍圖做成Object 名稱叫做ran
 * 
 *  在Deck的Constructor裡面 實體化兩個ArrayList
 *  一個是cards 為還沒有發出去的牌
 *  一個是usedCard 為已經發出去的牌
 *  
 *  用nDeck去看需要跑幾副牌
 *  y 為花色   z 為數字
 *  
 *  新增一個Card型態的變數card 
 *  他裡面所存在的值會依照y的不同變更花色
 *  花色是在Card.java裡面的Suit裡面拿到的
 *  用剛剛得到的值新增到cards裡面
 *  因為老師規定在Deck的Constructor的最後需要進行一次洗牌 所以在最後加入Shuffle()
 *  
 *  在shuffle的Method裡面
 *  進入這個Method就會讓發過牌的次數直接歸零
 *  將所有發過的牌複製給莊家(cards)
 *  再將發過的牌清空(usedCard)
 *  隨機從cards裡面挑選一個位置給loc儲存起來
 *  把原本在loc的值取出儲存至val
 *  再把剛剛loc位置的值val和正在進行迴圈的次數i位置的值進行交換'
 *  
 *  在getOneCard的Mehtod裡面
 *  當cards 莊家的牌歸零的時候就進行洗牌的動作
 *  新增一個card讓他儲存cards裡面的第一個位置的值
 *  並移除原本在cards位置的值
 *  在usedCard裡面新增剛剛拿到的牌
 *  新增一次發牌的次數
 *  回傳剛剛拿到的值
 *  
 *  (methods, 10 points)
 */
public class HW3 {
	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		//System.out.println("input N(deck of cards):");
		//String testn= sc.nextLine(); 
		int nDeck=1;
		//TODO: please add new fields and methods to Deck class (35)
		//usedCard (5 points)
		//nUsed (5 points)
		//getOneCard (10 points)
		//shuffle (10 points)
		//constructor (5 points)
		Deck deck=new Deck(nDeck);
			
		//TODO: please check your output, make sure that you print newCard and newCard2 on your screen  (10 points)
		//TODO: please add new fields and methods to Card class (25)
		//Use enumerated type in Card (10 points)
		//Constructor (5 points)
		//printCard (5 points)
		//getSuit (5 points)
		Card newCard=deck.getOneCard();
		newCard.printCard();
		Card newCard2=deck.getOneCard();
		newCard2.printCard();
		deck.shuffle();
		if(isAllCardsCorrect(deck.getAllCards(),nDeck)){
			if(!isShuffleWorking(deck,newCard,newCard2)){
				System.out.println("All Card: Well done! But shufller is not working");
			}else{
				System.out.println("Well done!");
			}
			
		}else{
			System.out.println("All Card: Error, please check your sourse code");
		}

	}
	/**
	 * This method is used for checking your result, not a part of your HW3
	 */
	private static boolean isShuffleWorking(Deck deck,Card newCard,Card newCard2){
		deck.shuffle();
		boolean isCorrect=true;
		if(newCard.getSuit().equals(newCard2.getSuit()) &&
				newCard.getRank()==newCard2.getRank()){
					isCorrect=false;
					return isCorrect;
		}
		for(int i=0;i<53;i++){
			deck.getOneCard();
		}
		if(deck.nUsed!=1){
			isCorrect=false;
		}
		return isCorrect;
	}
	
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){
		//check the output 
		boolean isCorrect=true;;
		HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
		for(Card card:allCards){
			Card.Suit suit= card.getSuit();
			int rank = card.getRank();
			if(rank>13||rank<1){
				isCorrect=false;
				break;
			}
			if(checkHash.containsKey(suit+","+rank)){
				checkHash.put(suit+","+rank, 
						checkHash.get(suit+","+rank)+1);
			}else{
				checkHash.put(suit+","+rank, 1);
			}

		}
		if(checkHash.keySet().size()==52||checkHash.keySet().size()==50){
			for(int value:checkHash.values()){
				if(value!=nDeck){
					isCorrect=false;
					break;
				}
			}
		}else{
			isCorrect=false;
		}
		return isCorrect;
	}

}
