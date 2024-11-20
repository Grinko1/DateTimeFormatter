package ru.practice.itkacademy.itkacademy.countOfElements;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = {1,2,2,3,4,5,7,3,5,78,5,3,78,65,6,8,9,10};
        String[] arr2 = {"a","a","a", "b","b","c","c","c","c"};

        System.out.println(countOfEl(arr));
        System.out.println(countOfEl(arr2));
    }
    private static <T> Map<T,Integer> countOfEl(T[] array){
        Map<T,Integer> map = new HashMap<>();
        for (T num: array) {
            map.merge(num, 1, Integer::sum);
        }
        return map;
    }
}
