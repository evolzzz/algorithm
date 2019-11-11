package com.lucifel.algorithm.dp;

/*描述
        最近天气炎热，小Ho天天宅在家里叫外卖。他常吃的一家餐馆一共有N道菜品，价格分别是A1, A2, ... AN元。并且如果消费总计满X元，还能享受优惠。小Ho是一个不薅羊毛不舒服斯基的人，他希望选择若干道不同的菜品，使得总价在不低于X元的同时尽量低。

        你能算出这一餐小Ho最少消费多少元吗？

        输入
        第一行包含两个整数N和X，(1 <= N <= 20, 1 <= X <= 100)

        第二行包含N个整数A1, A2, ...， AN。(1 <= Ai <= 100)

        输出
        输出最少的消费。如果小Ho把N道菜都买了还不能达到X元的优惠标准，输出-1。

        样例输入
        10 50
        9 9 9 9 9 9 9 9 9 8
        样例输出
        53

        如果只是价格从小到大排序然后顺序选入，会出现如下情况：★x=6时, 1+2+2+2并没有2+2+2更好★，所以采用动态规划：

        ★先获取总额sum，得到sum与x的差值，再看这个差值是否能变到最小*/

public class 满减优惠最优价格 {
    public static void main(String[] args) {
        int n = 5,x = 12, sum = 22;
        int price[] =new int[]{3,4,1,6,8};


        //背包情境：尽可能多放，相当于从差值中去掉没必要加入的菜品
        int m = sum - x;
        int[] dp = new int[m+1];
        for(int i = 0; i<n; i++){ //WLL：涉及到子问题的对象 vs 背包中的商品
            for(int j = m; j>=0; j--){ //WLL：子问题划分
                if(price[i]>j) {
                    break;//该菜品必须添加
                }
                dp[j] = Math.max(dp[j-price[i]] + price[i], dp[j]);
                //dp[9] = Math.max(dp[除去当前涉及物品的价格] + 当前涉及物品的价格, dp[9]);  ★这里的dp为j元超额金额中最大能扣除的金额
                //一个i要求出dp[0]-dp[9]，然后会被后面的利用到
            }
        }
        System.out.println(sum - dp[m]);

    }
}
