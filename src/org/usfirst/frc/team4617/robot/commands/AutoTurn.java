package org.usfirst.frc.team4617.robot.commands;

import org.usfirst.frc.team4617.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoTurn extends Command {
	public double speed;
	public double angle;
	public double distance;
	public boolean rightDirection;
	double leftPow;
	double rightPow;

	public AutoTurn(double speed, double angle, boolean rightDirection) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.chassisPID);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		distance = (24 * 3.1415 * angle)/360; //distance for one turn of the motor is 24pi/360, so multiply by given angle for different angle
		if(rightDirection){
			leftPow = speed;
			rightPow = -speed;
		}
		else{
			leftPow = -speed;
			rightPow = speed;
		}

		Robot.chassisPID.drive(leftPow, rightPow);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() { 
		//if only want one to turn, add both enc values and average (divide by 2)
		if(Robot.chassisPID.driveLEnc.getDistance() > distance*0.9 && Robot.chassisPID.driveREnc.getDistance() > distance*0.9)
			return true;
		else
			return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.chassisPID.drive(0,0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
