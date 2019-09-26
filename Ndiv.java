import java.util.ArrayList;
import java.util.Scanner;

public class Ndiv {
    public static void main(String[] args) throws Exception {
        // 从键盘接收数据
        Scanner scan = new Scanner(System.in);

        System.out.print("请输入牌: ");

        String input = null;
        String output_same_suit_higher_rank = null;
        String output_same_min = null;
        String output_all = null;
        String[] cards = new String[5];
        String[] cards_other_suit = new String[5];
        
        String suit = null;
        int rank = 0;

        if (scan.hasNext()){
            input = scan.next();
        }
        scan.close();

        if (input != null){
            cards = input.split(",");
            suit = cards[0].substring(1);
            rank = card_rank(cards[0]);
        }

        int min_same_suit = 14;
        int min_of_all = 14;
        int higher_rank = 14;
        int j = 0;
        for (int i=1;i< cards.length;i++){
            String card = cards[i];
            int val = card_rank(card);

            if (card.substring(1).equals(suit)){
                // 相同花色
                if (val > rank){
                    if (val < higher_rank){
                        higher_rank = val;
                        output_same_suit_higher_rank = card;
                    }
                }

                if  (val < min_same_suit){
                    min_same_suit = val;
                    output_same_min = card;
                }
            } else {
                // 不同花色
                if (val < min_of_all){
                    min_of_all = val;
                }
                cards_other_suit[j] = card;
                j++;
            }
        }
        
        // 输出同一花色较大的
        if (higher_rank < 14){
            System.out.println(output_same_suit_higher_rank);
            return;
        }

        // 输出同一花色最小的
        if (min_same_suit < 14){
            System.out.println(output_same_min);
            return;
        }

        // 输出没有相同花色最小的
        if (min_of_all < 14){
            for (int i=0;i<cards_other_suit.length;i++){
                String card = cards_other_suit[i];
                int val = card_rank(card);

                if (val == min_of_all){
                    if (card.substring(1).equals("C")){
                        output_all = card;
                    } else if (card.substring(1).equals("D")){
                        output_all = card;
                    } else if (card.substring(1).equals("H")){
                        output_all = card;
                    } else if (card.substring(1).equals("S")){
                        output_all = card;
                    }
                }
            }
            System.out.println(output_all);
            return;
        }

    }

    // 获取牌的值
    private static int card_rank(String card){
        switch (card.substring(0, 1)) {
            case "A":
                return 1;
            case "K":
                return 13;
            case "Q":
                return 12;
            case "J":
                return 11;
            case "T":
                return 10;
            default:
                return Integer.parseInt(card.substring(0,1));
        }
    }
}