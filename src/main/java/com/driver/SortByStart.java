package com.driver;
import java.util.Comparator;

public class SortByStartTime implements Comparator<Meeting> {
    @Override
    public int compare(Meeting t1, Meeting t2) {
        int val = t1.getStartTime().compareTo(t2.getStartTime());

        if(val>0) return 1 ;
        else if (val<0) return -1 ;
        else return 0 ;

    }
}
