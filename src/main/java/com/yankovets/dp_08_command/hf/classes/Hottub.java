package com.yankovets.dp_08_command.hf.classes;

public class Hottub {

    public void on(){
        System.out.println("Hottub is bubbling!");
    }

    public void off(){
        System.out.println("Hottub is off");
    }

    public void circulate(){
        System.out.println("Hottub is ");
    }

    public void jestOn(){
        System.out.println("Hottub chennel is set for DVD");
    }

    public void jestOff(){
        System.out.println("Hottub chennel is set for DVD");
    }

    public void setTemperature(int i){
        System.out.println("Hottub is cooling to " + i + " degree");
    }
}
