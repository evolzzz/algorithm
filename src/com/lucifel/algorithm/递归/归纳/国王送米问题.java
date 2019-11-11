package com.lucifel.algorithm.递归.归纳;

class Result{
    public long wheatNum=0;
    public long wheatTotalNum=0;
}

public class 国王送米问题 {

    public static boolean prove(int k, Result result){
        //证明n=1时成立
        if (k == 1) {
            if((Math.pow(2,1)-1)==1){
                result.wheatNum=1;
                result.wheatTotalNum=1;
                return true;
            }
        }
        else
        {
            //证明k-1成立
            boolean proveOfPreviousOne=prove(k-1,result);

            //证明k成立
            result.wheatNum*=2;
            result.wheatTotalNum+=result.wheatNum;

            boolean proveOfCurrentOne=false;
            if (result.wheatTotalNum == (Math.pow(2, k) - 1)) {
                proveOfCurrentOne = true;
            }
            if (proveOfCurrentOne && proveOfPreviousOne) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Result result=new Result();
        prove(63,result);
        System.out.println("wheatNum："+result.wheatNum);
        System.out.println("wheatTotalNum："+result.wheatTotalNum);
    }
}
