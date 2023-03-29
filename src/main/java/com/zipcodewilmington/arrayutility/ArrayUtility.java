package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.ArrayList;


/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    ArrayList<T> array = new ArrayList<>();


    public ArrayUtility(Object[] inputArray) {
        for(Object o: inputArray){
            array.add((T) o);
        }
    }

    public Integer countDuplicatesInMerge(Object[] arrayToMerge, Object valueToEvaluate) {
        int count = 0;

        for(Object o1 : arrayToMerge){
            if(o1.equals(valueToEvaluate)){
                count++;
            }
        }

        count+=getNumberOfOccurrences(valueToEvaluate);

        return count;
    }

    public <E> E getMostCommonFromMerge(T[] arrayToMerge) {

        for(T t: arrayToMerge){
            array.add(t);
        }
        int max = 0;
        E common = null;

        for(T t: array){
            if(getNumberOfOccurrences(t) > max){
                max = getNumberOfOccurrences(t);
                common = (E) t;
            }
        }


        return common;
    }

    public Integer getNumberOfOccurrences(Object valueToEvaluate) {
        int count = 0;
        for(Object o1 : array){
            if(o1.equals(valueToEvaluate)){
                count++;
            }
        }
        return count;
    }

    public <T> T[] removeValue(T valueToRemove) { //this feels like really bad code for some reason
        while(array.contains(valueToRemove)){
            array.remove(valueToRemove);
        }

        T[] items = (T[]) Array.newInstance(array.get(0).getClass(), array.size());

        for (int i = 0; i < array.size(); i++) {
            items[i] = (T) array.get(i);
        }

        return items;
    }
}
