import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Scanner;

/**
 * @author TODO: B0444238 ��l�^
 *  �@�}�l �w�q�F���ArrayList 
 *  ��ӫ��A�Ҭ�Card �W��usedCard,cards
 *  �A�s�W�ܼƥs��nUsed ��ܵo�P������
 *  ��Random�o���Źϰ���Object �W�٥s��ran
 * 
 *  �bDeck��Constructor�̭� ����ƨ��ArrayList
 *  �@�ӬOcards ���٨S���o�X�h���P
 *  �@�ӬOusedCard ���w�g�o�X�h���P
 *  
 *  ��nDeck�h�ݻݭn�]�X�ƵP
 *  y �����   z ���Ʀr
 *  
 *  �s�W�@��Card���A���ܼ�card 
 *  �L�̭��Ҧs�b���ȷ|�̷�y�����P�ܧ���
 *  ���O�bCard.java�̭���Suit�̭����쪺
 *  �έ��o�쪺�ȷs�W��cards�̭�
 *  �]���Ѯv�W�w�bDeck��Constructor���̫�ݭn�i��@���~�P �ҥH�b�̫�[�JShuffle()
 *  
 *  �bshuffle��Method�̭�
 *  �i�J�o��Method�N�|���o�L�P�����ƪ����k�s
 *  �N�Ҧ��o�L���P�ƻs�����a(cards)
 *  �A�N�o�L���P�M��(usedCard)
 *  �H���qcards�̭��D��@�Ӧ�m��loc�x�s�_��
 *  ��쥻�bloc���Ȩ��X�x�s��val
 *  �A����loc��m����val�M���b�i��j�骺����i��m���ȶi��洫'
 *  
 *  �bgetOneCard��Mehtod�̭�
 *  ��cards ���a���P�k�s���ɭԴN�i��~�P���ʧ@
 *  �s�W�@��card���L�x�scards�̭����Ĥ@�Ӧ�m����
 *  �ò����쥻�bcards��m����
 *  �busedCard�̭��s�W��讳�쪺�P
 *  �s�W�@���o�P������
 *  �^�ǭ�讳�쪺��
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
