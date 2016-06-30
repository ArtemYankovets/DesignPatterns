package com.yankovets.hfdp.command;

import com.yankovets.hfdp.command.receivers.GarageDoor;
import com.yankovets.hfdp.command.receivers.Light;
import com.yankovets.hfdp.command.command.GarageDoorUpCommand;
import com.yankovets.hfdp.command.command.LightOnCommand;

public class SimpleRemoteControlTest {
    public static void main(String[] args) {
        SimpleRemoteControl remote = new SimpleRemoteControl();
        Light light = new Light();
        GarageDoor garageDoor = new GarageDoor();
        LightOnCommand lightOn = new LightOnCommand(light);
        GarageDoorUpCommand garageOpen = new GarageDoorUpCommand(garageDoor);

        remote.setCommand(lightOn);
        remote.buttonWasPressed();
        remote.setCommand(garageOpen);
        remote.buttonWasPressed();
    }
}
