package com.yankovets.dp_08_command.hf.classes;

public class Stereo {
    String typeOfRoom;

    public Stereo(final String typeOfRoom) {
        this.typeOfRoom = typeOfRoom;
    }

    public void on(){
        System.out.println(typeOfRoom + " stereo is on");
    }

    public void off(){
        System.out.println(typeOfRoom + " stereo is off");
    }

    public void setCd(){
        System.out.println(typeOfRoom + " stereo is set from CD input");
    }

    public void setDVD(){
        System.out.println(typeOfRoom + " stereo is set from DVD input");
    }

    public void setRadio(){
        System.out.println(typeOfRoom + " stereo Radio is set");
    }

    public void setVolume(int i){
        System.out.println(typeOfRoom + " volume set to " + i);
    }
}
