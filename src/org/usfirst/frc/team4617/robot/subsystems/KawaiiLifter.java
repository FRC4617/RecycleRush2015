package org.usfirst.frc.team4617.robot.subsystems;

import org.usfirst.frc.team4617.robot.RobotMap;
import org.usfirst.frc.team4617.robot.commands.ElevatorManualCtrl;
import org.usfirst.frc.team4617.robot.commands.TestElevator;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class KawaiiLifter extends PIDSubsystem {

	private static final double Kp = 0.001/2; //might be negative
	private static final double Ki = 0.0;
	private static final double Kd = 0.0;

	public static final int ZERO_LVL = 0;

	public Encoder liftEnc;
	/*SpeedController  liftMotor1 = new Victor(RobotMap.lifter[0]);
	SpeedController  liftMotor2 = new Victor(RobotMap.lifter[1]);*/
	double count = 0;

	// Initialize your subsystem here
	public KawaiiLifter() {
		super("KawaiiLifter", Kp, Ki, Kd);
		//liftEnc = new Encoder(RobotMap.liftEncPort[0], RobotMap.liftEncPort[1], true);

		// Use these to get going:
		// setSetpoint() -  Sets where the PID controller should move the system
		//                  to (when powered on)
		setSetpoint(ZERO_LVL);
		// Enable the PID controller.
		enable();
	}

	public void initDefaultCommand() {
		// No need for default command, goes to whatever last setpoint was
		//$$$$***$$$$
		//setDefaultCommand(new ElevatorManualCtrl());
	}

	protected double returnPIDInput() {
		// Return your input value for the PID loop
		// e.g. a sensor, like a potentiometer:
		// yourPot.getAverageVoltage() / kYourMaxVoltage;
		//return liftEnc.getDistance();
		return 0;
	}

	protected void usePIDOutput(double output) {
		// Use output to drive your system, like a motor
		// e.g. yourMotor.set(output);
		//liftMotor1.set(output);
		//liftMotor2.set(output);

	}
	public void setSpeed(double speed){
		//liftMotor1.set(-speed);
		//liftMotor2.set(speed);
	}

	public void setState (double count){
		if (count > 0 && count < 5)
			this.count = count;
	}

	public double getState (){
		return count;
	}
}
