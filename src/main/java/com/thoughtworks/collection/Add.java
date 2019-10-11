package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        int min = Math.min(leftBorder, rightBorder);
        int max = Math.max(leftBorder, rightBorder);

        IntStream numbers = IntStream.rangeClosed(min, max);

        return numbers.filter(num -> num%2 == 0).sum();
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        int min = Math.min(leftBorder, rightBorder);
        int max = Math.max(leftBorder, rightBorder);

        IntStream numbers = IntStream.rangeClosed(min, max);

        return numbers.filter(num -> num%2 != 0).sum();
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().mapToInt(a -> a * 3 + 2).sum();
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return (arrayList.stream()
                .mapToInt(a -> a%2 != 0 ? a * 3 + 2 : a)
                .boxed().collect(Collectors.toList()));
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(a -> a%2 != 0)
                .mapToInt(a -> a * 3 + 5)
                .sum();
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(num -> num%2 == 0)
                .mapToDouble(num -> num)
                .sum()/2;
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(a -> a%2 == 0)
                .mapToDouble(a -> a)
                .average().getAsDouble();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return arrayList.stream()
                .filter(num -> num%2==0)
                .collect(Collectors.toList()).contains(specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream().filter(num -> num%2==0).distinct().collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> result = new ArrayList<>();
        result.addAll(arrayList.stream()
                .filter(num -> num%2 == 0)
                .collect(Collectors.toList()));
        result.addAll(arrayList.stream()
                .filter(odd -> odd%2 != 0)
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList()));
        return result;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> result = new ArrayList<>();

        List<Integer> tempList = arrayList.stream()
                .map(a -> a * 3).collect(Collectors.toList());

        tempList.forEach(num -> {
            if(tempList.indexOf(num) < tempList.size()-1){
                result.add(num + tempList.get(tempList.indexOf(num)+1));
            }
        });
        return result;
    }
}
