package org.usfirst.frc.team4617.robot.subsystems;

import org.usfirst.frc.team4617.robot.RobotMap;
import org.usfirst.frc.team4617.robot.commands.HaloDrive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ChassisPID extends Subsystem {
	//public RobotDrive driveBase;
	public Encoder driveLEnc;
	public Encoder driveREnc;
	//public Gyro driveGyro;
	public double distancePerPulse;
	public double outputL;
	public double outputR;
	public double distance;
	private static final double Kp = 0.001/2; //might be negative
    private static final double Ki = 0.0;
    private static final double Kd = 0.0;
    
    //SpeedController  driveMotor1 = new Victor(RobotMap.driveControllersPort[0]);
    //SpeedController  driveMotor2 = new Victor(RobotMap.driveControllersPort[1]);
    //SpeedController  driveMotor3 = new Victor(RobotMap.driveControllersPort[2]);
    //SpeedController  driveMotor4 = new Victor(RobotMap.driveControllersPort[3]);
    
    //RobotDrive driveBase = new RobotDrive (driveMotor1, driveMotor2, driveMotor3, driveMotor4);      


    public ChassisPID(){
    	 /*PIDController controllerL = new PIDController(Kp, Ki, Kd, driveLEnc.getDistance(), output);
    	 PIDController controllerR = new PIDController(Kp, Ki, Kd, driveLEnc.getDistance(), output);*/
    	 //       to (when powered on)
    	 //controllerR.setSetpoint(0);
    	 // Enable the PID controller.
    	 //controllerL.enable();
    	 //c/ontrollerR.enable();
		//driveBase = new RobotDrive(RobotMap.driveControllersPort[0], RobotMap.driveControllersPort[1], RobotMap.driveControllersPort[2], RobotMap.driveControllersPort[3]);
		//driveLEnc = new Encoder(RobotMap.driveEncPort[0], RobotMap.driveEncPort[1], true);    
		//driveREnc = new Encoder(RobotMap.driveEncPort[2], RobotMap.driveEncPort[3], true);
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	//command, get distance of 2 motors if one is higher lower the speed
	//-1.0 to 1.0
	public void drive(double leftPow, double rightPow) {
				//driveBase.tankDrive(leftPow, rightPow);
	}

	public void setEncCount(double distancePerPulse){
		this.distancePerPulse = distancePerPulse;
	}

	public double getEncPulse(){
		double formula = 8*3.1415/distancePerPulse; //set distance
		return formula;
	}
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	setDefaultCommand(new HaloDrive());
    }
}

