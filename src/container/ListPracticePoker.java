package container;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Card{//card类用于定义扑克牌类型
    public int rank;//牌面值
    public String suit;//花色

    @Override
    public String toString(){
        return String.format("[%s,%d]",suit,rank);
    }
}


public class ListPracticePoker {//买一副新的牌
        public static final String[] SUITS = {"♣", "♠", "♦", "♥"};
        //买一副新的牌
        private static List<Card> buyDeck() {
            List<Card> deck = new ArrayList<>(52);

            for (int i = 0; i < 4; i++) {//放入四种花色
                for (int j = 1; j <= 13; j++) {//每种花色13张
                    String suit = SUITS[i];
                    int rank = j;
                    Card card = new Card();
                    card.rank = rank;
                    card.suit = suit;
                    deck.add(card);//把每张牌（card）放入牌盒（deck）中
                }

            }
            return deck;
        }

        private static void swap(List <Card> deck,int i,int j){//交换i,j牌
            Card t=deck.get(i);
            deck.set(i,deck.get(j));
            deck.set(j,t);//把t里的值存放给j
        }
        private static void shuffle(List<Card>deck){//洗牌，与swap方法配合
            Random random=new Random(20200331);//随机数
            for (int i = deck.size()-1; i >0 ; i--) {
               int r = random.nextInt(i);//在[0,i)里面取一个随机数
                swap(deck,i,r);
            }
        }
        public static void main(String[] args){
            List<Card> deck=buyDeck();
            System.out.println("刚买回来的牌：");
            System.out.println(deck);
            shuffle(deck);
            System.out.println("洗过的牌：");
            System.out.println(deck);
            //三个玩家，每人五张牌
            //一个玩家就是一个ArrayList,可以把每个人的手牌放到list中
            List<List<Card> >hands=new ArrayList<>();
            hands.add(new ArrayList<>());
            hands.add(new ArrayList<>());
            hands.add(new ArrayList<>());

            //发牌
            for (int i = 0; i < 5; i++) {//i是牌编号
                for (int j=0;j<3;j++){//j是玩家编号
                    List<Card> hand=hands.get(j);
                    //remove表示删除deck中指定下标的元素
                    //不一定是remove（0），任意值都可以，因为牌在此刻已经被打乱了
                    Card card=deck.remove(0);
                    hand.add(card);
                }
            }
            //发牌结束
           System.out.println("剩余的牌");
            System.out.println(deck);
            System.out.println("A手中的牌："+hands.get(0));
            System.out.println("B手中的牌："+hands.get(1));
            System.out.println("C手中的牌："+hands.get(2));

            //得到不同的数段中任意一个数：
            int i=(int)(Math.random()*171)+30;
            System.out.println(i);//[30,201)
            Random random=new Random(2);
            System.out.println(random.nextInt(201));//[0,201)
            Random random1=new Random(0);
           System.out.println( random1.nextInt((171)+30));//[30,201)
        }
    }

