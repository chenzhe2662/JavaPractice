import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Card {
    public String suit;//花色
    public String rank;//牌面值


    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "(" + this.suit + " " + this.rank + ")";
    }
}
    public  class CardDemo {
        public static final String[] SUITS = {"♠","♥","♣","♦"};
        public static List<Card> buyPoker() {
            List<Card> poker = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                //花色
                poker.add(new Card(SUITS[i],"A"));
                for (int j = 2; j <= 10; j++) {
                    poker.add(new Card(SUITS[i],j+""));
                }
                poker.add(new Card(SUITS[i],"J"));
                poker.add(new Card(SUITS[i],"Q"));
                poker.add(new Card(SUITS[i],"K"));

            }
            return poker;
        }
        public static void main(String[] args) {
            //1.创建一副牌
          //  System.out.println("创建一副牌：");
            List<Card> poker = buyPoker();
          //  System.out.println(poker);
            //2.洗牌
        //    System.out.println("洗牌后");
            Collections.shuffle(poker);
           // System.out.println(poker);
            //3.发牌
            List<List<Card>> players = new ArrayList<>();
            //三个玩家
            players.add(new ArrayList<Card>());
            players.add(new ArrayList<Card>());
            players.add(new ArrayList<Card>());
            players.add(new ArrayList<Card>());

            //把牌发出去
            for (int cardIndex = 0; cardIndex < 3; cardIndex++) {
                for (int playerIndex = 0; playerIndex < 4; playerIndex++) {
                   // players.get(playerIndex).add(poker.remove(0));
                    List<Card> playerCards = players.get(playerIndex);
                    Card curCard = poker.remove(0);
                    playerCards.add(curCard);
                }
            }
            System.out.println("冯文智：");
            System.out.println(players.get(0));
            System.out.println("陈哲：");
            System.out.println(players.get(1));
            System.out.println("浩宇：");
            System.out.println(players.get(2));
            System.out.println("老菊：");
            System.out.println(players.get(3));
        }
    }

