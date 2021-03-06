package com.lucifel.algorithm.dp;
//https://segmentfault.com/a/1190000012769863?utm_source=tag-newest
//对于长度为x的字符串s1和长度为y的字符串s2，从s1改变成s2最少要经过多少次“增加”、“删除”或“替换”？
//
//        为了使用动态规划算法，要先将父问题分解成子问题（父问题和子问题是同一种问题，只不过分解得到的子问题规模更小）。
//        那么现在就需要我们找出父问题和子问题之间的转移关系。推导父子问题之间的转移关系有2中思路：
//
//        要解决父问题，需要先解决哪些子问题
//
//        要求解两个字符串之间的最小编辑距离，需要用到哪些更小的字符串之间的编辑距离？
//        假设已经知道一些子问题的答案，能计算出哪些同一类型、规模更大的父问题
//
//        如果已经知道某一对字符串之间的编辑距离（已经知道一些子问题），能推导出哪些字符串之间的最小编辑距离（这些子问题能求解出哪些父问题）
//        在这个问题中，使用第一种思路更简单。
//        假设要求s3与s4两个字符串之间的最小编辑距离，有下面两种情况：
//
//        如果s3与s4的结尾字符相同，那么答案等于s3与s4都去掉结尾字符以后的最小编辑距离（子问题）
//        如果s3与s4的结尾字符不同，那么先不管前面的那些字符，如何编辑s3使得两个字符串的结尾字符相同呢？测试几个例子能知道，结尾字符最终相同只能有以下3种原因：
//
//        向s3后面拼接s4的结尾字符。此时，原始s3与s4的最小编辑距离=1+拼接以后的最小编辑距离
//        删除s3的结尾字符（可能删除以后结尾字符还是不同，不过没关系，这是子问题要处理的事情）。此时，原始s3与s4的最小编辑距离=1+删除以后的最小编辑距离
//        将s3的结尾字符替换成了s4的结尾字符。此时，原始s3与s4的最小编辑距离=1+替换以后的最小编辑距离
//        除了以上三种手段以外，不管你如何对s3的前面字符如何增加、删除、替换，都不能让结尾字符相同。
//
//        现在将上面结论换成代码表述。假设ed[i][j]表示 word1[0]~word1[i-1]与word2[0]~word2[j-1]之间的最小编辑距离
//
//        if (word1[i - 1] == word2[j - 1]) ed[i][j] = ed[i - 1][j - 1];
//        else ed[i][j] = min(min(ed[i][j - 1] + 1, ed[i - 1][j] + 1), ed[i - 1][j - 1] + 1);    // 将3种方法都尝试，取最小的结果
//        现在有了转移关系，我们只要先计算子问题的结果（较短子串之间的编辑距离）并存储起来，然后用它计算出父问题的结果（较长子串之间的编辑距离），最后就能算出两个完整字符串之间的编辑距离。
public class leetcode72最短编辑距离 {
    public static int getMinEditDistance(String A,String B){
        int dp[][] = new int[A.length()][B.length()];

        if(A.equals(B)){
            return 0;
        }
        if(A.equals("")){
            return B.length();
        }
        if(B.equals("")){
            return A.length();
        }

        //B为空的情况
        for (int i = 0; i < A.length(); i++) {
            dp[i][0]=i;
        }

        //A为空的情况
        for (int j = 0; j < B.length(); j++) {
            dp[0][j]=j;
        }

        for (int i = 1; i < A.length(); i++) {
            for (int j = 1; j < B.length(); j++) {
                if (A.charAt(i)==B.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int temp1=dp[i-1][j]+1;
                    int temp2=dp[i][j-1]+1;
                    int temp3=dp[i-1][j-1]+1;//替换
                    dp[i][j]=Math.min(temp1,Math.min(temp2,temp3));
                }
            }
        }
        return dp[A.length()-1][B.length()-1];
    }

    public static void main(String[] args) {
        System.out.println(getMinEditDistance("hello","hellw123"));
    }
}
