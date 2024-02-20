package fr.norsys.stringcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Calculator {
    public int add(String numbers){
        if(numbers.isEmpty()) return 0;
        if(numbers.length()>2 && numbers.substring(0,2).equals("//")){
            int index = numbers.indexOf("\n");
            List<String> delimiters = findDelimiters(numbers);
            return add(numbers.substring(index+1),String.join("|",delimiters));
        }
        return add(numbers,"[,\n]");

    }
   private int add(String numbers , String delimiter){
        String[] nums = numbers.split(delimiter);
        List<Integer> negativeNumbers = checkNegativeNumbers(nums);
       if(!negativeNumbers.isEmpty())throw new RuntimeException("negative not allowed"+negativeNumbers);
       int s=0;
        for(String str:nums){
            int n =Integer.parseInt(str);
            s+=(n<=1000?n:0);
        }
        return s;
   }

   public List<String> findDelimiters(String numbers){
        List<String> delimiters = new ArrayList<>();
        String str = numbers.substring(2).split("\n")[0];
        String[] dels = str.split("]");
        for(String s:dels) {
            String strDelimiter=s.substring(1).trim();
            if(strDelimiter.equals("*")) delimiters.add("\\*");
            else delimiters.add(strDelimiter);
        }
        return  delimiters;
   }

   private List<Integer> checkNegativeNumbers(String[] numbers){
        List<Integer> list = new LinkedList<>();
        for(String s: numbers) {
            int n = Integer.parseInt(s);
            if(n<0)list.add(n);
        }
        return list;
   }
}
