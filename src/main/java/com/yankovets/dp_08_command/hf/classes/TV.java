package com.yankovets.dp_08_command.hf.classes;

public class TV {
    String location;

    public TV(final String location) {
        this.location = location;
    }

    public void on(){
        System.out.println(location + " TV is on");
    }

    public void off(){
        System.out.println(location + " TV is off");
    }

    public void setInputChennel(){
        System.out.println(location + " TV chennel is set for DVD");
    }

    public void setVolume(int i){
        System.out.println(location + " volume set to " + i);
    }
}
