package com.org.atomikos.entity.ds1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;


public class   Test  {

    public static void main(String[] args) {
        reverseStr("123jk");
        String nice="789".substring(0,1);
       // System.out.println(nice);
    }



//    public String reverseStr(String str){
//        char[] c = str.toCharArray();
//        StringBuilder sb = new StringBuilder();
//        for(int i=c.length-1;i>=0;i--){
//            sb.append(c[i]);
//        }
//        return sb.toString();
//    }

    public static String reverseStr(String str){
        if(str.length() <= 1){
            return str;
        }
        String f=reverseStr(str.substring(1)) + str.charAt(0);
        System.out.println(f);
        return reverseStr(str.substring(1)) + str.charAt(0);
    }



    public void back(){
        List<Integer> a= Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13) ;
        a.removeIf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer<10;
            }
        });
        System.out.println(a.toString());
    }


}
