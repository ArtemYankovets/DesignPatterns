package com.yankovets.hfdp.command;

import com.yankovets.hfdp.command.receivers.Hottub;
import com.yankovets.hfdp.command.receivers.Light;
import com.yankovets.hfdp.command.receivers.Stereo;
import com.yankovets.hfdp.command.receivers.TV;
import com.yankovets.hfdp.command.command.Command;
import com.yankovets.hfdp.command.command.HottubOffCommand;
import com.yankovets.hfdp.command.command.HottubOnCommand;
import com.yankovets.hfdp.command.command.LightOffCommand;
import com.yankovets.hfdp.command.command.LightOnCommand;
import com.yankovets.hfdp.command.command.MacroCommand;
import com.yankovets.hfdp.command.command.StereoOffCommand;
import com.yankovets.hfdp.command.command.StereoOnWithCDCommand;
import com.yankovets.hfdp.command.command.TVOffCommand;
import com.yankovets.hfdp.command.command.TVOnCommand;

public class Client_RemoteLoader {
    public static void main(String[] args) {
        Invoker_RemoteControlWithUndo remoteControl = new Invoker_RemoteControlWithUndo();

        Light light = new Light("Living Room");
        TV tv = new TV("Living Room");
        Stereo stereo = new Stereo("Living Room");
        Hottub hottub = new Hottub();

//        Light livingRoomLight = new Light("Living Room");
//        Light kitchenLight = new Light("Kitchen");
//        CeilingFan ceilingFan = new CeilingFan("Living Room");
//        GarageDoor garageDoor = new GarageDoor();
//        Stereo stereo = new Stereo("Living Room");

//        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
//        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
//        LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
//        LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);

        LightOnCommand lightOn = new LightOnCommand(light);
        StereoOnWithCDCommand stereoOn = new StereoOnWithCDCommand(stereo);
        TVOnCommand tvOn = new TVOnCommand(tv);
        HottubOnCommand hottubOn = new HottubOnCommand(hottub);

        LightOffCommand lightOff = new LightOffCommand(light);
        StereoOffCommand stereoOff = new StereoOffCommand(stereo);
        TVOffCommand tvOff = new TVOffCommand(tv);
        HottubOffCommand hottubOff = new HottubOffCommand(hottub);


//        CeilingFanMediumCommand ceilingFanMedium = new CeilingFanMediumCommand(ceilingFan);
//        CeilingFanHighCommand ceilingFanHigh = new CeilingFanHighCommand(ceilingFan);
//        CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);

//        GarageDoorUpCommand garageDoorUp = new GarageDoorUpCommand(garageDoor);
//        GarageDoorDownCommand garageDoorDown = new GarageDoorDownCommand(garageDoor);

//        StereoOnWithCDCommand stereoOnWithCD = new StereoOnWithCDCommand(stereo);
//        StereoOffCommand stereoOff = new StereoOffCommand(stereo);

        Command[] partyOn = {lightOn, stereoOn, tvOn, hottubOn};
        Command[] partyOff = {lightOff, stereoOff, tvOff, hottubOff};

        MacroCommand partyOnMacro = new MacroCommand(partyOn);
        MacroCommand partyOffMacro = new MacroCommand(partyOff);

//        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
//        remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
//        remoteControl.setCommand(2, ceilingFanOn, ceilingFanOff);
//        remoteControl.setCommand(0, ceilingFanMedium, ceilingFanOff);
//        remoteControl.setCommand(1, ceilingFanHigh, ceilingFanOff);
//        remoteControl.setCommand(3, stereoOnWithCD, stereoOff);

//        System.out.println(remoteControl);

//        remoteControl.onButtonWasPushed(0);
//        remoteControl.offButtonWasPushed(0);
//        System.out.println(remoteControl);
//        remoteControl.undoButtonWasPushed();

//        remoteControl.onButtonWasPushed(1);
//        System.out.println(remoteControl);
//        remoteControl.undoButtonWasPushed();


//        remoteControl.onButtonWasPushed(1);
//        remoteControl.offButtonWasPushed(1);
//        remoteControl.onButtonWasPushed(2);
//        remoteControl.offButtonWasPushed(2);
//        remoteControl.onButtonWasPushed(3);
//        remoteControl.offButtonWasPushed(3);

        remoteControl.setCommand(0, partyOnMacro, partyOffMacro);

        System.out.println(remoteControl);
        System.out.println("--- Pushing Macro On ---");
        remoteControl.onButtonWasPushed(0);
        System.out.println();
        System.out.println("--- Pushing Macro Off ---");
        remoteControl.offButtonWasPushed(0);
    }
}
