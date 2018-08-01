package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class CombineDemo {
    public long allCombine(int[] array)
    {
        HashSet<Integer> set = new HashSet<>();
        for(Integer eleInt:array)
        {
            set.add(eleInt);
        }

        HashSet<HashSet<Integer>> allSets = allCombine(set);

        allSets.forEach(obj->System.out.println(obj));

        return allSets.size();
    }

    public static HashSet<HashSet<Integer>> allCombine(HashSet<Integer> set)
    {
        HashSet<HashSet<Integer>> allSets = new HashSet<>();
        allSets.add(new HashSet<>());

        for(Integer ele:set)
        {
            HashSet<HashSet<Integer>> newSets = new HashSet<>();
            for(HashSet<Integer> s:allSets)
            {
                newSets.add(new HashSet<>(s));
                HashSet<Integer> newSet = new HashSet<>(s);
                newSet.add(ele);
                newSets.add(newSet);
            }
            allSets = newSets;
        }
        return allSets;
    }

    public long allCombineRecur(int[] array)
    {
        HashSet<Integer> set = new HashSet<>();
        for(Integer eleInt:array)
        {
            set.add(eleInt);
        }
        HashSet<HashSet<Integer>> allSets = allCombineRecur(set);
        allSets.forEach(obj->System.out.println(obj));
        return allSets.size();
    }

    public HashSet<HashSet<Integer>> allCombineRecur(HashSet<Integer> set)
    {
        HashSet<HashSet<Integer>> allSets = new HashSet<>();
        if(set.isEmpty())
        {
            allSets.add(new HashSet<>());
            return allSets;
        }
        if(set.size() == 1)
        {
            allSets.add(new HashSet<>());
            allSets.add(new HashSet<>(set));
            return allSets;
        }

        for(Integer eleInt:set)
        {
            HashSet<Integer> newSet = new HashSet<>(set);
            newSet.remove(eleInt);
            HashSet<HashSet<Integer>> subSets = allCombineRecur(newSet);
            for(HashSet<Integer> s:subSets)
            {
                allSets.add(new HashSet<>(s));
                HashSet<Integer> tmpSet = new HashSet<>(s);
                tmpSet.add(eleInt);
                allSets.add(tmpSet);
            }
        }
        return allSets;
    }

    public long allCombineBinary(int[] array)
    {
        HashSet<Integer> set = new HashSet<>();
        for(Integer eleInt:array)
        {
            set.add(eleInt);
        }

        HashSet<HashSet<Integer>> allSets = allCombineBinary(set);

        System.out.println("allCombineBinary:");
        allSets.forEach(obj->System.out.println(obj));

        return allSets.size();
    }

    public HashSet<HashSet<Integer>> allCombineBinary(HashSet<Integer> set)
    {
        HashSet<HashSet<Integer>> allSets = new HashSet<>();
        allSets.add(new HashSet<>());

        ArrayList<Integer> al = new ArrayList<>(set);

        for(int i=0; i<Math.pow(2,set.size()); i++)
        {
            char[] bits = String.format("%"+set.size()+"s",Integer.toBinaryString(i))
                    .replace(" ","0").toCharArray();

            HashSet<Integer> tmpSet = new HashSet<>();
            for(int j=0; j<bits.length; j++)
            {
                if(bits[j]=='1')
                {
                    tmpSet.add(al.get(j));
                }
            }
            allSets.add(tmpSet);
        }

        return allSets;
    }

    public long combine(int[] array, int n)
    {
        HashSet<Integer> set = new HashSet<>();
        for(Integer eleInt:array)
        {
            set.add(eleInt);
        }
        HashSet<HashSet<Integer>> allSets = allCombine(set);
        HashSet<HashSet<Integer>> subSets = new HashSet<>();

        for(HashSet<Integer> s:allSets)
        {
            if(s.size() == n)
            {
                subSets.add(new HashSet<>(s));
            }
        }
        subSets.forEach(obj->System.out.println(obj));
        return subSets.size();
    }

    public long combineBinaryInc(int[] array, int n)
    {
        HashSet<Integer> set = new HashSet<>();
        for(int i:array)
        {
            set.add(i);
        }

        HashSet<HashSet<Integer>> subSets = combineBinaryInc(set,n);

        System.out.println("combineBinaryInc:");
        subSets.forEach(obj->System.out.println(obj));

        return subSets.size();

    }

    private HashSet<HashSet<Integer>> combineBinaryInc(HashSet<Integer> set, int n) {
        HashSet<HashSet<Integer>> subSets = new HashSet<>();

        ArrayList<Integer> al = new ArrayList<>(set);

        for(int i=0; i<Math.pow(2,set.size()); i++)
        {
            char[] bits = String.format("%"+set.size()+"s",Integer.toBinaryString(i))
                    .replace(" ","0").toCharArray();

            if(numsOfOne(bits) != n)
            {
                continue;
            }

            HashSet<Integer> tmpSet = new HashSet<>();
            for(int j=0; j<bits.length; j++)
            {
                if(bits[j]=='1')
                {
                    tmpSet.add(al.get(j));
                }
            }
            subSets.add(tmpSet);
        }
        return subSets;
    }

    private int numsOfOne(char[] bits) {
        int cnt=0;
        for(char ch:bits)
        {
            if(ch == '1')
            {
                cnt++;
            }
        }
        return cnt;
    }

    public long combineBinaryQuery(int[] array, int n)
    {
        HashSet<Integer> set = new HashSet<>();
        for(int i:array)
        {
            set.add(i);
        }

        HashSet<HashSet<Integer>> subSets = combineBinaryQuery(set,n);

        System.out.println("combineBinaryQuery:");
        subSets.forEach(obj->System.out.println(obj));

        return subSets.size();
    }

    private HashSet<HashSet<Integer>> combineBinaryQuery(HashSet<Integer> set, int n) {
        HashSet<HashSet<Integer>> subSets = new HashSet<>();

        ArrayList<Integer> al = new ArrayList<>(set);

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%" + set.size() + "s", Integer.toBinaryString(0))
                .replace(" ","0"));
        for(int i=0; i<n; i++) sb.replace(i,i+1,"1");
        System.out.println(sb.toString());
        System.out.println();



        do
        {
            System.out.println(sb);

            HashSet<Integer> tmpSet = new HashSet<>();
            for(int j=0; j<sb.length(); j++)
            {
                if(sb.charAt(j) == '1')
                {
                    tmpSet.add(al.get(j));
                }
            }
            subSets.add(tmpSet);

            sb = new StringBuilder(next(sb));
        }while(hasNext(sb));

        return subSets;
    }

    private String next(StringBuilder sb) {
        int index = sb.indexOf("10");
        StringBuilder sbLeft = new StringBuilder(sb.substring(0,index));
        StringBuilder sbRight = new StringBuilder(sb.substring(index));
        sbRight.replace(0,2,"01");
        return sbLeft.reverse() + sbRight.toString();
    }

    private boolean hasNext(StringBuilder sb) {
        return sb.indexOf("1") != sb.lastIndexOf("0")+1;
    }
}
