package com.yunbao.xmlparse.springboot_xmlparse.parse;

import java.util.Properties;


public class VariableTokenHandler {

    private final String name;



    public VariableTokenHandler(String name) {
        this.name = name;
    }



    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        VariableTokenHandler variableTokenHandler = new VariableTokenHandler("aa");
        System.out.println(variableTokenHandler.getName());
    }
}
