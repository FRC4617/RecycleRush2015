package org.usfirst.frc.team4617.robot.commands;

import org.usfirst.frc.team4617.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ZeroElevator extends Command {
	public static double eleLvl;
	public static double setpoint;
	public ZeroElevator() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.kawaiilifter);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		//Sets default setpoint for this command 
		
		eleLvl = 0;//Increase count when button pressed
		Robot.kawaiilifter.setState(eleLvl);//Set count in set state function correspondingly

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		setpoint = Robot.kawaiilifter.getState();
		Robot.kawaiilifter.setSetpoint(setpoint);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if ((Math.abs(Robot.kawaiilifter.getPosition()) - setpoint) <5)
			return true;
		else
			return false; 
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.kawaiilifter.setSpeed(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
			end();
	}
}


