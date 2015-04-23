package org.usfirst.frc.team4617.robot.subsystems;
import org.usfirst.frc.team4617.robot.RobotMap;
import org.usfirst.frc.team4617.robot.commands.TestIntake;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	Victor motor1, motor2;
	public boolean active;

	public Intake() {
		motor1 = new Victor(RobotMap.intake[0]);
		motor2 = new Victor(RobotMap.intake[1]);
	}

	public void setSpeed (double speed){
		motor1.set(speed);
		motor2.set(speed);
	}

	public void feedIn() {
		active = true;
		motor1.set(0.8);
		motor2.set(-0.8);
	}
	public void feedOut() {
		active = true;
		motor1.set(-0.8);
		motor2.set(0.8);
	}
	public void stop() {
		active = false;
		motor1.set(0);
		motor2.set(0);
	}
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new TestIntake());
	}
}


