package com.driver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Gmail extends Email {

    int inboxCapacity; //maximum number of mails inbox can store

//    public Gmail(String password, int inboxCapacity){
//        super(password) ;
//        this.inboxCapacity = inboxCapacity ;
//    }

    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
//        super.setEmailId(emailId);
        this.inboxCapacity = inboxCapacity ;
    }

    List<Mail> Inbox = new ArrayList<>();
    List<Mail> Trash = new ArrayList<>();


    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)


    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.

        if(!Inbox.isEmpty() && Inbox.size() == inboxCapacity){
            Trash.add( Inbox.remove(0) ) ;
        }
//        else{
            Mail m = new Mail(date,sender,message) ;
            Inbox.add(m) ;
//        }

    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing

        for(int i=0; i<Inbox.size(); i++){
            if( Inbox.get(i).message.equals(message) ){
                Trash.add( Inbox.remove(i) ) ;
            }
        }

    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox

        if(Inbox.isEmpty()) return null ;
        else{
            return Inbox.get(Inbox.size()-1).message ;
        }

    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox

        if(Inbox.isEmpty()) return null ;
        else{
            return Inbox.get(0).message ;
        }

    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date

        int count = 0 ;

        for(int i=0; i<Inbox.size(); i++){
//            if(Inbox.get(i).date.compareTo(start) >=0 && Inbox.get(i).date.compareTo(end) <=0)
            if( ( (Inbox.get(i).date).after(start) || (Inbox.get(i).date).equals(start) ) && ( Inbox.get(i).date.before(end) || (Inbox.get(i).date).equals(end) ) ){
                count++ ;
            }

        }
        return count ;

    }

    public int getInboxSize(){
        // Return number of mails in inbox

        if(Inbox.isEmpty()) return 0 ;
        else{
            return Inbox.size() ;
        }

    }

    public int getTrashSize(){
        // Return number of mails in Trash

        if(Trash.isEmpty()) return 0 ;
        else{
            return Trash.size() ;
        }

    }

    public void emptyTrash(){
        // clear all mails in the trash

        for(int i=0; i<Inbox.size(); i++){
            Inbox.remove(0) ;
        }

    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox

        return inboxCapacity ;

    }
}
