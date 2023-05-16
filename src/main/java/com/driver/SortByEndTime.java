package com.driver;
import java.util.Comparator;

public class SortByEndTime implements Comparator<Meeting> {
    @Override
    public int compare(Meeting t1, Meeting t2) {

        return t1.getEndTime().compareTo(t2.getEndTime()) ;

//        int val = t1.getEndTime().compareTo(t2.getEndTime());

//        if(val>0) return +1 ;
//        else if (val<0) return -1 ;
//        else{
//            int val1 = t1.getStartTime().compareTo(t2.getStartTime());
//
//            if(val1>0) return +1 ;
//            else if (val1<0) return -1 ;
//            return 0 ;
//        }
    }
}
