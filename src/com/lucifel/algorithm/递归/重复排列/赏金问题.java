package com.lucifel.algorithm.递归.重复排列;

import java.util.ArrayList;

//
public class 赏金问题 {
    public static long[] rewards={1,2,5,10};
    public static void getCombination(long totalReward, ArrayList<Long> result){
        //符合条件，输出值并返回
        if(totalReward==0){
            System.out.println(result);
            return;
        }
        //不符合条件，退回重新搜索
        else if(totalReward<0){
            return;
        }

        for (long reward : rewards) {
            result.add(reward);
            getCombination(totalReward-reward,result);
            result.remove(reward);
        }
    }

    public static void getCombination2(long totalReward, ArrayList<Long> result){
        //符合条件，输出值并返回
        if(totalReward==0){
            System.out.println(result);
            return;
        }
        //不符合条件，退回重新搜索
        else if(totalReward<0){
            return;
        }

        for (long reward : rewards) {
            ArrayList<Long> newResult =(ArrayList<Long>)result.clone();
            newResult.add(reward);
            getCombination(totalReward-reward, newResult);
        }
    }

    public static void main(String[] args) {
        ArrayList<Long> result = new ArrayList<>();
        long t1 = System.currentTimeMillis();
        getCombination(10,result);
        long t2= System.currentTimeMillis()-t1;

        long t3 = System.currentTimeMillis();
        getCombination2(10, result);
        long t4 = System.currentTimeMillis()-t3;

        System.out.println("getCombination："+t2);
        System.out.println("getCombination2："+t4);
    }
}
