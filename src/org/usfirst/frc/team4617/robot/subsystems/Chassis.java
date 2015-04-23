package org.usfirst.frc.team4617.robot.subsystems;

import org.usfirst.frc.team4617.robot.RobotMap;
import org.usfirst.frc.team4617.robot.commands.HaloDrive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Chassis extends Subsystem {

	public RobotDrive driveBase;
	public Encoder driveLEnc;
	public Encoder driveREnc;
	//public Gyro driveGyro;
	public double distancePerPulse;

	public Chassis () {
		driveBase = new RobotDrive(RobotMap.driveControllersPort[0], RobotMap.driveControllersPort[1], RobotMap.driveControllersPort[2], RobotMap.driveControllersPort[3]);
		driveLEnc = new Encoder(RobotMap.driveEncPort[0], RobotMap.driveEncPort[1], true);    
		driveREnc = new Encoder(RobotMap.driveEncPort[2], RobotMap.driveEncPort[3], true);
	}

	//command, get distance of 2 motors if one is higher lower the speed
	//-1.0 to 1.0
	public void drive(double leftPow, double rightPow) {
		driveBase.tankDrive(leftPow, rightPow);
	}

	public void setEncCount(double distancePerPulse){
		this.distancePerPulse = distancePerPulse;
	}

	public double getEncPulse(){
		double formula = 8*3.1415/distancePerPulse;
		return formula;
	}


	
	public void initDefaultCommand() {
		setDefaultCommand(new HaloDrive());
	}

}
