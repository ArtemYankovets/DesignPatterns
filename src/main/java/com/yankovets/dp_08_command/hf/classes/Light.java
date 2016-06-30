package com.yankovets.dp_08_command.hf.classes;

public class Light {
    String typeOfRoom;

    public Light(final String typeOfRoom) {
        this.typeOfRoom = typeOfRoom;
    }

    public Light() {

    }

    public void on(){
        System.out.println(typeOfRoom + " light is on");
    }

    public void off(){
        System.out.println(typeOfRoom + " light is off");
    }
}
