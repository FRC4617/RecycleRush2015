/*
 tote lvl: -3264
 bin lvl: -4865
 Max lvl: -7118
 Min lvl: 0
 */
package org.usfirst.frc.team4617.robot;

import org.usfirst.frc.team4617.autocommands.DoNothing;

import org.usfirst.frc.team4617.autocommands.DriveForward1;
import org.usfirst.frc.team4617.autocommands.DriveTime;
import org.usfirst.frc.team4617.autocommands.OneBin1;
import org.usfirst.frc.team4617.autocommands.OneTote1;
import org.usfirst.frc.team4617.autocommands.OneToteBin1;
import org.usfirst.frc.team4617.autocommands.ThreeTote;
import org.usfirst.frc.team4617.autocommands.TwoToteBin;
import org.usfirst.frc.team4617.robot.subsystems.Chassis;
import org.usfirst.frc.team4617.robot.subsystems.ChassisPID;
import org.usfirst.frc.team4617.robot.subsystems.Elevator;
import org.usfirst.frc.team4617.robot.subsystems.Intake;
import org.usfirst.frc.team4617.robot.subsystems.KawaiiLifter;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
//************Add in drive solenoid button!!!!
public class Robot extends IterativeRobot {
	public static Chassis chassis;
	public static ChassisPID chassisPID;
	public static Elevator elevator;
	public static KawaiiLifter  kawaiilifter;
	public static Intake intake;      
	public static OI oi;

	Command autonomousCommand;
	//CommandGroup autonomousCommand;
	SendableChooser autoChooser;
	//Command updateCommand = new UpdateSDB();
	boolean autoStarted = false;
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		chassis = new Chassis();
		// chassisPID = new ChassisPID();
		elevator = new Elevator();
		kawaiilifter = new KawaiiLifter ();
		intake = new Intake();
		// show what command your subsystem is running on the smartDashBoard
		autoChooser = new SendableChooser();
		autoChooser.addDefault("DoNothing", new DoNothing());
		autoChooser.addObject("Drive Time", new DriveTime(0.5, 0.715, true));
		autoChooser.addObject("Drive Forward", new DriveForward1());
		autoChooser.addObject("One Tote", new OneTote1());
		autoChooser.addObject("One Bin", new OneBin1());
		autoChooser.addObject("One Tote One Bin", new OneToteBin1());
		autoChooser.addObject("Two Tote Two Bin", new TwoToteBin());
		autoChooser.addObject("Three Tote", new ThreeTote());
		SmartDashboard.putData("Auto Chooser", autoChooser);  
		SmartDashboard.putData(kawaiilifter);  
		SmartDashboard.putData(intake);  
		SmartDashboard.putData(chassis);
		SmartDashboard.putNumber("Elevator State", kawaiilifter.getState());
		SmartDashboard.putData("*Current Command: ", Scheduler.getInstance());

		oi = new OI();
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		autonomousCommand = (Command) autoChooser.getSelected();
		autonomousCommand.start();
		chassis.driveLEnc.reset();
		chassis.driveREnc.reset();
		elevator.liftEnc.reset();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		if (autonomousCommand != null) autonomousCommand.cancel();
		chassis.driveLEnc.reset();
		chassis.driveREnc.reset();
		kawaiilifter.setState(0); //*****$$$$$change
		//kawaiilifter.liftEnc.reset();
	}

	/**
	 * This function is called when the disabled button is hit.
	 * You can use it to reset subsystems before shutting down.
	 */
	public void disabledInit(){
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
		Scheduler.getInstance().run();
	}
}



