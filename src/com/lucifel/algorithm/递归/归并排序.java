package com.lucifel.algorithm.递归;

import java.util.Arrays;

public class 归并排序 {

    public static int[] merge_sort(int[] array){
        if (array == null) {
            return new int[0];
        }
        if (array.length == 1) {
            return array;
        }

        int middle=array.length/2;

        int[] left = Arrays.copyOfRange(array,0,middle);
        int[] right = Arrays.copyOfRange(array,middle,array.length);

        left=merge_sort(left);
        right=merge_sort(right);

        int[] merge=merge(left,right);
        return merge;
    }

    private static int[] merge(int[] left, int[] right) {
        int ai=0;
        int bi=0;
        int mi=0;
        int[] merged = new int[left.length+right.length];
        while (ai < left.length && bi < right.length) {
            if(left[ai]<right[bi]){
                merged[mi]=left[ai];
                ai++;
            }else{
                merged[mi] = right[bi];
                bi++;
            }
            mi++;
        }

        if (ai < left.length) {
            for (int i = ai; ai < left.length; ai++) {
                merged[mi] = left[ai];
                mi++;
            }
        }else{
            for (int i = bi; bi < right.length; bi++) {
                merged[mi] = right[bi];
                mi++;
            }
        }

        return merged;

    }

    public static void main(String[] args) {
        int[] to_sort = {3,5,6,11,2,5,5,11,1,1};
        int[] merged = merge_sort(to_sort);
        System.out.println(Arrays.asList(merged));
    }
}
