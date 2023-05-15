package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public boolean passwordSize(String newPassword){
        if(newPassword.length() >= 8){
            return true ;
        }
        return false ;
    }

    public boolean upper(String newPassword){
        for(int i=0; i<newPassword.length(); i++){
            if(newPassword.charAt(i)-'A' >= 0 && newPassword.charAt(i)-'A' <= 25){
                return true ;
            }
        }
        return false ;
    }

    public boolean lower(String newPassword){
        for(int i=0; i<newPassword.length(); i++){
            if(newPassword.charAt(i)-'a' >= 0 && newPassword.charAt(i)-'a' <= 25){
                return true ;
            }
        }
        return false ;
    }

    public boolean digit(String newPassword){
        for(int i=0; i<newPassword.length(); i++){
            if(newPassword.charAt(i)-'0' >= 0 && newPassword.charAt(i)-'0' <= 10){
                return true ;
            }
        }
        return false ;
    }

    public boolean specialChar(String newPassword){
        for(int i=0; i<newPassword.length(); i++) {
            String str = String.valueOf(newPassword.charAt(i));
            if (!upper(str) && !lower(str) && !digit(str)) {
                return true;
            }
        }
        return false ;
    }


    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character

        if( oldPassword.equals(this.password) ){

            if(passwordSize(newPassword) && upper(newPassword) && lower(newPassword) && digit(newPassword) && specialChar(newPassword)){
                this.password = newPassword ;
                System.out.println("Password successfully changed") ;
                return;
            }
            else{
                System.out.println("Please enter password with proper requirements") ;
                return ;
            }

        }
        else{
            System.out.println("Current Password does not match Old Password") ;
            return ;
        }

    }
}
