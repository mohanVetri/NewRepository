package com.login;

public class RegistrationDetails {
    public String firstName;
    public String lastName;
    public String userName;
    public String password;
    public String emailId;
    public RegistrationDetails(String firstName, String lastName, String userName, String password, String emailId){
        this.firstName=firstName;
        this.lastName=lastName;
        this.userName=userName;
        this.password=password;
        this.emailId=emailId;
    }
}
