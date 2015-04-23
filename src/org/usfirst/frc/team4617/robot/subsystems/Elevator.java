package org.usfirst.frc.team4617.robot.subsystems;

import org.usfirst.frc.team4617.robot.RobotMap;
import org.usfirst.frc.team4617.robot.commands.ElevatorManualCtrl;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {

	Victor liftMotor1;    
	Victor liftMotor2;
	public Encoder liftEnc;
	int value = 0;   
	int count = 0;

	public Elevator () {
		liftMotor1 = new Victor(RobotMap.lifter[0]);    
		liftMotor2 = new Victor(RobotMap.lifter[1]);

		//The first channel sensor in the encoder, the second and the direction (a boolean)
		liftEnc = new Encoder(RobotMap.liftEncPort[0], RobotMap.liftEncPort[1], true);
	}

	public void setSpeed(double speed){
		liftMotor1.set(-speed);
		liftMotor2.set(speed);
	}
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public void initDefaultCommand() {
		setDefaultCommand(new ElevatorManualCtrl());
	}
	
	public void setState (int count){
		this.count += count;
	}
	
	public int getState (){
		return count;
	}
}


