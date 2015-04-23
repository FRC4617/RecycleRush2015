package org.usfirst.frc.team4617.autocommands;

import org.usfirst.frc.team4617.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */ 
//coded by mariaaa <3... with CJ's help
public class DriveForward extends Command {
	public boolean check;
	public DriveForward() {
		// Use requires() here to declare subsystem dependencies
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		/*//double LeftEncRate = Robot.chassis.driveLEnc.getRate(); //Use encoder rate (speed, aka pulses per second)
		//double RightEncRate = Robot.chassis.driveREnc.getRate();
		double lowerEncRate = 0.0000000000;
		double base = 0.00000000000;
		//See how much motor with lower power needs to be increased to match motor of higher power 
		if(LeftEncRate > RightEncRate){ //Find motor that has lowest power 
			base = RightEncRate;
			lowerEncRate = RightEncRate;
			check = true;

		}
		else {
			base = LeftEncRate;
			lowerEncRate = LeftEncRate;
			check = false;
		}                    

		while (LeftEncRate != RightEncRate){ 
			lowerEncRate *= 1.1;//trial rate
			System.out.println("Lower rate: " +lowerEncRate);//get this rate and then set to this rate
		}                
		double lowerEncRateCoeff = lowerEncRate/base; //lower encoder rate constant 
		System.out.println("while loop done, original rate is: " +base);   */
		/*if (check)
			Robot.chassis.drive(LeftEncRate, RightEncRate*lowerEncRateCoeff ); //Drive at same values calculated
		else
			Robot.chassis.drive(LeftEncRate*lowerEncRateCoeff, RightEncRate);*/
		//System.out.println("drive!");
	}
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		/*if (Robot.chassis.driveLEnc.get()==-7118*3.9252336449 && Robot.chassis.driveLEnc.get()==-7118*3.9252336449)
			return true;
		else*/
			return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		//Robot.chassis.drive(0,0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}


