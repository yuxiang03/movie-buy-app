package recursion;

/*
啤酒2元1瓶，4哥盖子可以换1瓶，2个空瓶可以换1瓶
请问10元钱可以和多少瓶酒，剩余多少空瓶子和盖子
 */
public class recursionDemo3 {
    private static int totalNumber;  //总数量
    private static int lastBoTTleNumber;  //记录每次剩余的瓶子个数
    private static int lastCoverNumber;  //记录每次剩余的盖子个数

    public static void main(String[] args) {
        buy(10);
        System.out.println("总数："+totalNumber);
        System.out.println("剩余盖子数："+lastCoverNumber);
        System.out.println("剩余瓶子数："+lastBoTTleNumber);
    }

    public static void buy(int money){
        //立马能购买的数量
        int buyNumber = money/2;
        totalNumber += buyNumber;
        //统计可以换算的钱
        int coverNumber = lastCoverNumber + buyNumber;
        int bottleNumber = lastBoTTleNumber + buyNumber;

        //统计可以换算的钱
        int allMoney = 0;
        if (coverNumber >= 4){
            allMoney += (coverNumber / 4) * 2;
        }
        lastCoverNumber = coverNumber % 4;
        if (bottleNumber >=2){
            allMoney +=(bottleNumber / 2) * 2;
        }
        lastBoTTleNumber = bottleNumber % 2;
        if (allMoney >= 2){
            buy(allMoney);
        }
    }

}
