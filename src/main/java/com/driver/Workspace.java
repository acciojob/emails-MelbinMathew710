package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar = new ArrayList<>(); // Stores all the meetings

    public Workspace(String emailId) {
        super(emailId, Integer.MAX_VALUE);
        // The inboxCapacity is equal to the maximum value an integer can store.
//        super.setEmailId(emailId);
//        super.inboxCapacity = Integer.MAX_VALUE ;s
    }

    public void setCalender(Meeting meeting){
        calendar.add( meeting ) ;
    }

    public ArrayList<Meeting> getCalendar() {
        return calendar;
    }

    public void addMeeting(Meeting meeting) {
        //add the meeting to calendar
        setCalender(meeting);
    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am

        if(getCalendar().size() == 1)
            return 1 ;

        Meeting[] m = new Meeting[getCalendar().size()] ;

        int j = 0 ;
        for(Meeting i : getCalendar() ){

            m[j] = i ;
            j += 1 ;
        }

        Arrays.sort(m, new SortByEndTime()) ;

        List<Meeting> maxMeeting = new ArrayList<>() ;
        LocalTime time_limit = m[0].getEndTime() ;
        maxMeeting.add(m[0]) ;

        for(Meeting m1 : m){
            if (m1.getStartTime().isAfter(time_limit)) {
//            if(m1.getStartTime().compareTo(time_limit)>0){
                maxMeeting.add(m1) ;
                time_limit = m1.getEndTime() ;
            }
        }
        return maxMeeting.size() ;



//        int count = 1 ;

//        LocalTime e = m[0].getEndTime() ;
//        LocalTime s = m[1].getStartTime() ;

//        for(int i=1; i<(m.length)-1; i++){
//
//            int val =  s.compareTo(e) ;
//            if(val>0) {
//                count += 1;
//                s = m[i+1].getStartTime() ;
//                e = m[i].getEndTime() ;
//            }else{
//                s = m[i+1].getStartTime() ;
//            }
//
//        }

//        return count ;

    }
}
