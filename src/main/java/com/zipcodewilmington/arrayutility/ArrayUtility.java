package com.zipcodewilmington.arrayutility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    T[] inputArray;
    Stream<T> stream;


    public ArrayUtility(T[] inputArray) {
        this.inputArray = inputArray;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        Long first = Arrays.stream(this.inputArray).filter(x -> x == valueToEvaluate).count();
        Integer firstInt = first.intValue();
        Long second = Arrays.stream(arrayToMerge).filter(x -> x == valueToEvaluate).count();
        Integer secondInt = second.intValue();
        return firstInt + secondInt;
    }

    public T[] removeValue(T valueToRemove)   {
        List removedVals = Arrays.stream(inputArray).filter(x -> x != valueToRemove).collect(Collectors.toList());
        return  (T[])removedVals.toArray(Arrays.copyOf(inputArray,removedVals.size()));
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate){
        Long count = Arrays.stream(inputArray).filter(x ->x == valueToEvaluate).count();
        return count.intValue();
    }

    public T getMostCommonFromMerge(T[] arrayToMerge)   {
        int currentElementCount = 0;
        int maxElementCount = 0;
        T mostCommon = null;

        ArrayList<T> list = (ArrayList<T>) Arrays.stream(inputArray).collect(Collectors.toList());;
        ArrayList<T> arrListToMerge = (ArrayList<T>) Arrays.stream(arrayToMerge).collect(Collectors.toList());;
        list.addAll(arrListToMerge);

        for(int i = 1; i < list.size(); i++) {
            if(list.get(i) == list.get(i - 1))  {
                currentElementCount++;
            }
                if(currentElementCount > maxElementCount)   {
                    maxElementCount = currentElementCount;
                    mostCommon = list.get(i);
                }   currentElementCount = 1;
        }
        if(currentElementCount > maxElementCount)   {
            maxElementCount = currentElementCount;
            mostCommon = list.get(list.size()-1);
        }



        return mostCommon;
    }

}
