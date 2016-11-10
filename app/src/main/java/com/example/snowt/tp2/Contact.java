package com.example.snowt.tp2;

/**
 * Created by Gabriel on 09/11/2016.
 */
public class Contact {

    public Contact(){ }
    public Contact(String name, String phoneNumber, String email){
        this.Name=name;
        this.PhoneNumber=phoneNumber;
        this.Email=email;
    }

    private String Name;
    private String PhoneNumber;
    private String Email;

    public void setName(String name){
        Name = name;
    }
    public String getName(){
        return Name;
    }
    public void setPhoneNumber(String phoneNumber){
        PhoneNumber = phoneNumber;
    }
    public String getPhoneNumber(){
        return PhoneNumber;
    }
    public void setEmail(String email){
        Email = email;
    }
    public String getEmail(){
        return Email;
    }
}
