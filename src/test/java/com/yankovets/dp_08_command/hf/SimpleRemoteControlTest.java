package com.yankovets.dp_08_command.hf;

import com.yankovets.dp_08_command.hf.classes.GarageDoor;
import com.yankovets.dp_08_command.hf.classes.Light;
import com.yankovets.dp_08_command.hf.command.GarageDoorUpCommand;
import com.yankovets.dp_08_command.hf.command.LightOnCommand;

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
