package com.john.internship.connection.db;

public class ShowUserTest {
    public static String showUser(UserTest user){

        int countPassword = user.getPassword()==null? 0: user.getPassword().length();
        String newPasswordShow = "";

        while ((--countPassword)>0)
            newPasswordShow+= "*";
        return "My name is " + user.getName() + "Email is " +user.getEmail()+ "Address is"+user.getAddress()+ "Password is"+newPasswordShow+"</br>";
    }
}
