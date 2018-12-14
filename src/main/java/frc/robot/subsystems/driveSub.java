package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.driveCom;

public class driveSub extends Subsystem {

  private final DifferentialDrive driveTrain = RobotMap.finalDrive;

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new driveCom());
  }

  public void drive(Joystick xbox){
    driveTrain.arcadeDrive(xbox.getRawAxis(3) - xbox.getRawAxis(2), xbox.getRawAxis(0));
  }

  public void driveStop(){
    driveTrain.arcadeDrive(0, 0);
  }
}