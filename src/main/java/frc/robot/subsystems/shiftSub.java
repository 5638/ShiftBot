/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.shiftCom;

/**
 * Add your docs here.
 */
public class shiftSub extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private final DoubleSolenoid shiftSol = RobotMap.shiftSol;
  private final WPI_TalonSRX left = RobotMap.leftMaster;
  private final WPI_TalonSRX right = RobotMap.rightMaster;
  private final Joystick xbox = Robot.OI.xbox;

  double aV = (left.getSelectedSensorVelocity(0) + right.getSelectedSensorVelocity(0)) / 2;

  double t1 = 0;
  double t2 = System.currentTimeMillis()/1000;
  double dT = t2 - t1;

  double throttle = xbox.getRawAxis(3) - xbox.getRawAxis(2);

  boolean isTurn = Math.abs(xbox.getRawAxis(0)) > .1;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new shiftCom());
  }

  public void hi(){
    shiftSol.set(Value.kForward);
  }

  public void lo(){
    shiftSol.set(Value.kReverse);
  }

  public void auto(){
    if(Math.abs(aV) > 30000 && dT > 2 && Math.abs(throttle) > .9 && isTurn == false){
      hi();
    }else if(Math.abs(aV) < 30000 && dT > 2 && Math.abs(throttle) < .9 && isTurn == false){
      lo();
    }else{
      lo();
    }
  }
}
