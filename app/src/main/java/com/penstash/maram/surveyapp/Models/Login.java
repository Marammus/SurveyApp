package com.penstash.maram.surveyapp.Models;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

/**
 * Created by maram on 05/04/2018.
 */
@Table
public class Login extends SugarRecord{
    private long id;

    String UserName;
    String Password;

    public Login(){}

    public Login(String userName, String password){
        this.UserName = userName;
        this.Password = password;
    }

    public String getUserName(){
        return UserName;
    }

    public String getPassword(){
        return Password;
    }

}
