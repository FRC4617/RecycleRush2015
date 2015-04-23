package org.usfirst.frc.team4617.robot.commands;

import org.usfirst.frc.team4617.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoTote extends Command {
	public static final int TOTE_LVL = -3264;
	public static double speed;
	public static int numTotes;
	public static double setpoint;
	public AutoTote(double speed, int numTotes) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.kawaiilifter);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.kawaiilifter.setSpeed(speed);

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		setpoint = TOTE_LVL*numTotes;
		Robot.kawaiilifter.setSetpoint(setpoint);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		//Check if encoder is at a valid tote level, TOTE_LVL*i will be the setpoint of the pid 
		if ((Math.abs(Robot.kawaiilifter.getPosition()) - setpoint) <5)
			return true;
		else
			return false; 
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
