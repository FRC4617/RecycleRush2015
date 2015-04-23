package org.usfirst.frc.team4617.robot.commands;

import org.usfirst.frc.team4617.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BinUp extends Command {
	public static double eleLvl;
	public static final int BIN_LVL = -4865;
	public static final int MAX_LVL = -7118;
	public static final int ZERO_LVL = 0;
	public static final int TOTE_LVL = -3264;
	private double setpoint;

	//Allow only one bin level??
	public BinUp (/*double setpoint*/) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.kawaiilifter);
		//this.setpoint = setpoint;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		eleLvl = 0;
		//Sets default setpoint for this command 
		//Robot.kawaiilifter.setSetpoint(setpoint);
		eleLvl = Robot.kawaiilifter.getState() + 1;//Increase count when button pressed
		Robot.kawaiilifter.setState(eleLvl);//Set count in set state function correspondingly

	}
	
	

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		setpoint = BIN_LVL + Robot.kawaiilifter.getState()*TOTE_LVL;
		Robot.kawaiilifter.setSetpoint(setpoint);	

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if ((Math.abs(Robot.kawaiilifter.getPosition()) - setpoint) <0.08)
			return true;

		//If conditions are not met for command to finish (unless interrupted by other elevator command), 
		//then continue command until they are
		else
			return false; 
	}	// Called once after isFinished returns true

	protected void end() {
		Robot.kawaiilifter.setSpeed(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
