/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.commands.*;
import frc.robot.subsystems.pidcontroller.*;
import frc.robot.subsystems.*;

public class Robot extends TimedRobot {
  //subsystem
  public static DriveSubsystem driveSubsystem;

  public static LiftSubsystem liftSubsystem;
  public static LiftPID liftPID;

  //command
  Command autoCommand;
  public static DriveCommand driveCommand;
  public static LiftCommand LiftCommand;

  @Override
  public void robotInit() {
    RobotMap.init();
    OI.init();
    driveSubsystem = new DriveSubsystem();
    driveCommand = new DriveCommand();
    liftSubsystem = new LiftSubsystem();
    liftPID = new LiftPID();
    LiftCommand = new LiftCommand();
    //m_chooser.setDefaultOption("Default Auto", driveCommand);
    // chooser.addOption("My Auto", new MyAutoCommand());
    //SmartDashboard.putData("Auto mode", m_chooser);
    RobotMap.liftEncoder.setDistancePerPulse(Constant.liftDistancePerPulse);
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
    driveCommand.isAuto = true;
  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    driveCommand.isAuto = false;
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void testInit(){
  }
  
  @Override
  public void testPeriodic(){
  }
}
