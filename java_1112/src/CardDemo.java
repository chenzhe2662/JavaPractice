import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class Card {
    private String suit;//花色
    private String rank;//牌面值


    Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "(" + this.suit + " " + this.rank + ")";
    }
}
public  class CardDemo {
    private static final String[] SUITS = {"♠","♥","♣","♦"};
    private static List<Card> buyPoker() {
        List<Card> poker = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            //花色
            poker.add(new Card(SUITS[i],"A"));
            for (int j = 2; j <= 10; j++) {
                poker.add(new Card(SUITS[i],j + ""));
            }
            poker.add(new Card(SUITS[i],"J"));
            poker.add(new Card(SUITS[i],"Q"));
            poker.add(new Card(SUITS[i],"K"));

        }
        return poker;
    }
    private static void swap(List<Card> deck,int i, int j) {
        Card tmp = deck.get(i);
        deck.set(i,deck.get(j));
        deck.set(j,tmp);
    }
    private static void shuffle (List<Card> deck) {
        Random random = new Random();
        for (int i = deck.size() - 1; i > 0; i--) {
            int index = random.nextInt(i);
            swap(deck,i,index);
        }
    }
    public static void main(String[] args) {
        //1.创建一副牌
        System.out.println("创建一副牌：");
        List<Card> poker = buyPoker();
        //  System.out.println(poker);
        //2.洗牌
        //  System.out.println("洗牌后");
        //Collections.shuffle(poker);
        shuffle(poker);
        // System.out.println(poker);
        //3.发牌
        List<List<Card>> players = new ArrayList<>();
        //三个玩家
        players.add(new ArrayList<>());
        players.add(new ArrayList<>());
        players.add(new ArrayList<>());
        players.add(new ArrayList<>());

        //把牌发出去
        for (int cardIndex = 0; cardIndex < 3; cardIndex++) {
            for (int playerIndex = 0; playerIndex < 4; playerIndex++) {
                // players.get(playerIndex).add(poker.remove(0));
                List<Card> playerCards = players.get(playerIndex);
                Card curCard = poker.remove(0);
                playerCards.add(curCard);
            }
        }
        System.out.println("玩家一：");
        System.out.println(players.get(0));
        System.out.println("玩家二：");
        System.out.println(players.get(1));
        System.out.println("玩家三：");
        System.out.println(players.get(2));
        System.out.println("玩家四：");
        System.out.println(players.get(3));
    }
}

