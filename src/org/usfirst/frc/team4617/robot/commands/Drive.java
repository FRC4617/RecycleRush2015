package org.usfirst.frc.team4617.robot.commands;

import org.usfirst.frc.team4617.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Drive extends Command{
	public boolean check;
    public Drive() {
   	 // Use requires() here to declare subsystem dependencies
   	 requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
   	 SmartDashboard.putBoolean("Halo", true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.chassis.drive(-Robot.oi.joyL.getDeadX(), -Robot.oi.joyR.getDeadY());
   	// Robot.chassisPID.drive(-Robot.oi.joyL.getDeadX(), -Robot.oi.joyR.getDeadY());
  /* 	double LeftEncRate = Robot.chassis.driveLEnc.getRate(); //Use encoder rate (speed, aka pulses per second)
	double RightEncRate = Robot.chassis.driveREnc.getRate();
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
	Robot.chassis.drive(LeftEncRate, RightEncRate); //Drive at same values calculated
	
	if (check)
		Robot.chassis.drive(LeftEncRate, RightEncRate*lowerEncRateCoeff ); //Drive at same values calculated
	else
		Robot.chassis.drive(LeftEncRate*lowerEncRateCoeff, RightEncRate);
   	 //driveTrain.drive(-oi.leftJoystick.getY(), -oi.rightJoystick.getY());*/
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
   	 return false;
    }

    // Called once after isFinished returns true
    protected void end() {
   	 Robot.chassis.drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}


