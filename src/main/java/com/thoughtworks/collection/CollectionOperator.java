package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        if(left < right){
            return IntStream.rangeClosed(left, right)
                    .boxed()
                    .sorted()
                    .collect(Collectors.toList());
        }
        return IntStream.rangeClosed(right, left)
                .boxed()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        if(left < right){
            return IntStream.rangeClosed(left, right)
                    .filter(num -> num%2 == 0)
                    .boxed()
                    .sorted()
                    .collect(Collectors.toList());
        }
        return IntStream.rangeClosed(right, left)
                .filter(num -> num%2 == 0)
                .boxed()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
    }

    public List<Integer> popEvenElments(int[] array) {
        return Arrays.stream(array)
                .filter(num -> num%2 == 0)
                .boxed()
                .collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
        return Arrays.stream(array).skip(array.length - 1).findFirst().orElse(-1);
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        return Arrays.stream(firstArray)
                .filter(Arrays.stream(secondArray)
                        .boxed()
                        .collect(Collectors.toList())::contains)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> firstList = Arrays.stream(firstArray).collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(secondArray).collect(Collectors.toList());
        secondList.removeAll(firstList);
        firstList.addAll(secondList);
        return firstList;
    }
}
