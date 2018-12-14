package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.driveSub;
import frc.robot.subsystems.shiftSub;

public class Robot extends TimedRobot {
  public static driveSub driveTrain;
  public static shiftSub shiftSub;
  public static OI OI;

  @Override
  public void robotInit() {
    RobotMap.init();
    
    driveTrain = new driveSub();
    shiftSub = new shiftSub();
    
    
    
    
    OI = new OI();
  }

  @Override
  public void robotPeriodic() {

  }

  @Override
  public void disabledInit() {

  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
    
  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic() {
    
  }
}