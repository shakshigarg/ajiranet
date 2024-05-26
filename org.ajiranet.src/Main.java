import models.*;
import services.AjiraNetService;
import utils.ValidationUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        AjiraNetService ajiraNetService = new AjiraNetService();
        List<String> commandList=Arrays.asList("ADD COMPUTER A1","ADD COMPUTER A2","ADD COMPUTER A3","ADD","ADD PHONE A1","ADD COMPUTER A1","ADD COMPUTER A4","ADD COMPUTER A5","ADD COMPUTER A6","ADD REPEATER R1","SET_DEVICE_STRENGTH A1 HELLOWORLD","SET_DEVICE_STRENGTH A1 2","CONNECT A1 A2","CONNECT A1 A3","CONNECT A1 A1","CONNECT A1 A2","CONNECT A5 A4","CONNECT R1 A2","CONNECT R1 A5","CONNECT A1","CONNECT","CONNECT A8 A1","CONNECT A2 A4","INFO_ROUTE A1 A4","INFO_ROUTE A1 A5","INFO_ROUTE A4 A3","INFO_ROUTE A1 A1","INFO_ROUTE A1 A6","INFO_ROUTE A2 R1","INFO_ROUTE A3","INFO_ROUTE","INFO_ROUTE A1 A10");

        if(commandList.size()!=0){
            int i=0;
            while (i<commandList.size()){
                String commandStr=commandList.get(i);
                try {
                    Command command = ValidationUtils.validateAndGet(commandStr);
                    switch (command.getCommandType()) {
                        case ADD:
                            AddCommand addCommand = (AddCommand) command;
                            ajiraNetService.addDevice(addCommand.getDeviceType(), addCommand.getDeviceId());
                            break;
                        case CONNECT:
                            ConnectCommand connectCommand = (ConnectCommand) command;
                            ajiraNetService.addConnection(connectCommand.getDeviceA(), connectCommand.getDeviceB());
                            break;
                        case INFO_ROUTE:
                            InfoRouteCommand infoRouteCommand = (InfoRouteCommand) command;
                            ajiraNetService.getRouteInfo(infoRouteCommand.getDeviceA(), infoRouteCommand.getDeviceB());
                            break;
                        case SET_DEVICE_STRENGTH:
                            SetDeviceStrengthCommand setDeviceStrengthCommand = (SetDeviceStrengthCommand) command;
                            ajiraNetService.setDeviceStrength(setDeviceStrengthCommand.getDeviceId(), setDeviceStrengthCommand.getStrength());


                    }

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                i++;
            }
        }

//        while (true) {
//            Scanner sc = new Scanner(System.in);
//            String commandStr = sc.nextLine();
//            try {
//                Command command = ValidationUtils.validateAndGet(commandStr);
//                switch (command.getCommandType()) {
//                    case ADD:
//                        AddCommand addCommand = (AddCommand) command;
//                        ajiraNetService.addDevice(addCommand.getDeviceType(), addCommand.getDeviceId());
//                        break;
//                    case CONNECT:
//                        ConnectCommand connectCommand = (ConnectCommand) command;
//                        ajiraNetService.addConnection(connectCommand.getDeviceA(), connectCommand.getDeviceB());
//                        break;
//                    case INFO_ROUTE:
//                        InfoRouteCommand infoRouteCommand = (InfoRouteCommand) command;
//                        ajiraNetService.getRouteInfo(infoRouteCommand.getDeviceA(), infoRouteCommand.getDeviceB());
//                        break;
//                    case SET_DEVICE_STRENGTH:
//                        SetDeviceStrengthCommand setDeviceStrengthCommand = (SetDeviceStrengthCommand) command;
//                        ajiraNetService.setDeviceStrength(setDeviceStrengthCommand.getDeviceId(), setDeviceStrengthCommand.getStrength());
//
//
//                }
//
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        }

//        ajiraNetService.addDevice(DeviceType.Computer, "A1");
//        ajiraNetService.addDevice(DeviceType.Computer, "A2");
//        ajiraNetService.addDevice(DeviceType.Computer, "A1");
//
//        ajiraNetService.addDevice(DeviceType.Repeater, "R1");
//        ajiraNetService.addDevice(DeviceType.Repeater, "R2");
//        ajiraNetService.addDevice(DeviceType.Repeater, "R1");
//
//        ajiraNetService.addDevice(DeviceType.Repeater, "A1");
//
//        ajiraNetService.getAllDevices();
//
//
//        ajiraNetService.addConnection("A1","A2");
//        ajiraNetService.addConnection("A1","A1");
//        ajiraNetService.addConnection("A2","A1");
//        ajiraNetService.addConnection("A2","A3");
//
//        ajiraNetService.addConnection("R2","R3");
//        ajiraNetService.addConnection("R1","R2");
//
//        ajiraNetService.setDeviceStrength("A1",  2);
//
//        ajiraNetService.setDeviceStrength("A1",  -2);
//
//        ajiraNetService.setDeviceStrength("A3",  2);
//
//        ajiraNetService.setDeviceStrength("R1",  2);
//
//        ajiraNetService.getRouteInfo("A1", "A5");
    }
}