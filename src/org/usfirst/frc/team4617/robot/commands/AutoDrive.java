package org.usfirst.frc.team4617.robot.commands;

import org.usfirst.frc.team4617.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDrive extends Command {
	private double distance;
	double p;
	public AutoDrive(double distance) {
		// Use requires() here to declare subsystem dependencies
		//requires(Robot.chassisPID);
		this.distance = distance;
	}


	// Called just before this Command runs the first time
	protected void initialize() {
		
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		/*double LeftEncRate = Robot.chassisPID.driveLEnc.getRate(); //Use encoder rate (speed, aka pulses per second)
		double RightEncRate = Robot.chassisPID.driveREnc.getRate();
		double lowerEncRate = 0.0000000000;
		double base = 0.00000000000;
		//See how much motor with lower power needs to be increased to match motor of higher power 
		if(LeftEncRate > RightEncRate){ //Find motor that has lowest power 
			base = RightEncRate;
			lowerEncRate = RightEncRate; 

		}
		else {
			base = LeftEncRate;
			lowerEncRate = LeftEncRate;
		}                    

		while (LeftEncRate != RightEncRate){ 
			lowerEncRate *= 1.1;//trial rate
			System.out.println("Lower rate: " +lowerEncRate);//get this rate and then set to this rate
		}                

		double lowerEncRateCoeff = lowerEncRate/base; //lower encoder rate constant 
		System.out.println("while loop done, original rate is: " +base);   
		Robot.chassisPID.drive(LeftEncRate, RightEncRate); //Drive at same values calculated
		
		

		 */
		//if (Robot.chassisPID.driveLEnc.getDistance() - distance < 5 && Robot.chassisPID.driveREnc.getDistance() - distance < 5)
			




	}
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (Robot.chassisPID.driveLEnc.getDistance() - distance < 5 && Robot.chassisPID.driveREnc.getDistance() - distance < 5)
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
