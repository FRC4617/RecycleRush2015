package org.usfirst.frc.team4617.robot.commands;

import org.usfirst.frc.team4617.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


/**
 *
 */
public class HaloDrive extends Command{
	public double speed;
	public HaloDrive() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {


	}

	// Called repeatedly when this Command is scheduled to run
	//
	protected void execute() {		
		if (!Robot.oi.joyL.getRawButton(3))
			speed = -Robot.oi.joyL.getDeadY();
		else
			speed = -Robot.oi.joyL.getDeadY();
		double rPow = Robot.oi.joyR.getDeadX();

		double rightAcc = speed*0.5;
		double leftAcc = speed*0.5;

		if (speed < 0){
			if (rPow > 0)
				rightAcc *= Math.abs(1-rPow);
			else
				leftAcc *= Math.abs(1-rPow);

		}    

		else if (speed > 0){    
			if (rPow > 0)

				leftAcc *= Math.abs(1-rPow);
			else
				rightAcc *= Math.abs(1-rPow);
		}

		else{
			leftAcc = rPow;
			rightAcc = -rPow;
		}


		Robot.chassis.drive(leftAcc, rightAcc);
		//System.out.println(Robot.chassis.driveLEnc.get() +"*");
		System.out.println(Robot.chassis.driveREnc.get());
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.chassis.drive (0.0, 0.0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}


