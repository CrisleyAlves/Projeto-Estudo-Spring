package com.estudojavaspring.ProjetoEstudoSpring.Error;

/**
 * Created by Crisley on 23/09/2017.
 */

public class CustomErrorType {

    private  String errorMessage;

    public CustomErrorType(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
