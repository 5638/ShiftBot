/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

  public static WPI_TalonSRX leftMaster; 
  public static WPI_VictorSPX leftSlave;

  public static WPI_TalonSRX rightMaster;
  public static WPI_VictorSPX rightSlave;

  public static SpeedControllerGroup leftGearBox;
  public static SpeedControllerGroup rightGearBox;

  public static DifferentialDrive finalDrive;

  public static DoubleSolenoid shiftSol;

  public static void init(){

    leftMaster = new WPI_TalonSRX(1); 
    leftSlave = new WPI_VictorSPX(2); 
                                      
    leftSlave.follow(leftMaster); 

    rightMaster = new WPI_TalonSRX(3);
    rightSlave = new WPI_VictorSPX(4);
    rightSlave.follow(rightMaster); 

    leftGearBox = new SpeedControllerGroup(leftMaster, leftSlave);    
    rightGearBox = new SpeedControllerGroup(rightMaster, rightSlave);

    finalDrive = new DifferentialDrive(leftGearBox, rightGearBox);  

    shiftSol = new DoubleSolenoid(0, 0, 1);
  }
} 