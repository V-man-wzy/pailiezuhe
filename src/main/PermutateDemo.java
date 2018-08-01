package main;


import com.sun.javafx.image.impl.IntArgb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class PermutateDemo {
    public long allPermutate(int[] array)
    {
        ArrayList<Integer> al = new ArrayList<>();
        for(int ele:array)
        {
            al.add(ele);
        }

        ArrayList<ArrayList<Integer>> allLists = new ArrayList<>();
        allLists.add(al);

        for(int i=0;i<al.size();i++) {
            allLists = mySwap(allLists, i);
        }
        allLists.forEach(obj->System.out.println(obj));
        return allLists.size();
    }

    public long allPermutate(HashSet<Integer> set)
    {
        ArrayList<Integer> al = new ArrayList<>(set);

        ArrayList<ArrayList<Integer>> allLists = new ArrayList<>();
        allLists.add(al);

        for(int i=0;i<al.size();i++)
        {
            allLists = mySwap(allLists, i);
        }
        allLists.forEach(obj->System.out.println(obj));
        return allLists.size();
    }

    private ArrayList<ArrayList<Integer>> mySwap(ArrayList<ArrayList<Integer>> allLists, int index)
    {
        ArrayList<ArrayList<Integer>> newAllLists = new ArrayList<>();

        for(ArrayList<Integer> al:allLists)
        {
            for(int i=index;i<al.size();i++)
            {
                ArrayList<Integer> alCopy = new ArrayList<>(al);
                Collections.swap(alCopy,index,i);
                newAllLists.add(alCopy);
            }
        }
        return newAllLists;
    }

    public long allPermutateRecur(int[] array)
    {
        ArrayList<Integer> al = new ArrayList<>();
        for(int ele:array)
        {
            al.add(ele);
        }
        ArrayList<ArrayList<Integer>> allLists;

        allLists = allPermutateRecur(al);

        allLists.forEach(obj->System.out.println(obj));
        return allLists.size();
    }

    private ArrayList<ArrayList<Integer>> allPermutateRecur(ArrayList<Integer> array)
    {
        ArrayList<ArrayList<Integer>> allLists = new ArrayList<>();

        if(array.size() == 0){
            return null;
        }
        if(array.size() == 1)
        {
            allLists.add(new ArrayList<>(array));
            return allLists;
        }

        for(int i=0; i<array.size(); i++)
        {
            ArrayList<Integer> newArr = new ArrayList<>(array);
            newArr.remove(i);
            ArrayList<ArrayList<Integer>> lists = allPermutateRecur(newArr);
            for(ArrayList<Integer> list:lists)
            {
                list.add(0,array.get(i));
                allLists.add(list);
            }
        }
        return allLists;
    }

    public long permutate(int[] array, int n)
    {
        HashSet<Integer> set = new HashSet<>();
        for(Integer eleInt:array)
        {
            set.add(eleInt);
        }
        HashSet<HashSet<Integer>> allSets = CombineDemo.allCombine(set);
        HashSet<HashSet<Integer>> subSets = new HashSet<>();

        for(HashSet<Integer> s:allSets)
        {
            if(s.size() == n)
            {
                subSets.add(new HashSet<>(s));
            }
        }
        int count = 0;
        for(HashSet<Integer> s:subSets)
        {
            count += allPermutate(s);
        }
        return count;
    }
}