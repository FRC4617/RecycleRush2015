package org.usfirst.frc.team4617.autocommands;

import org.usfirst.frc.team4617.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class OneBin extends Command {
	public static final int BIN_LVL = -4865;
	public OneBin() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.kawaiilifter.setSpeed(0.6);
		//.chassis.drive(-1, -1);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		/*if (Robot.kawaiilifter.liftEnc.get() <= BIN_LVL){
			if(Robot.chassis.driveLEnc.get()==-7118*3.9252336449 && Robot.chassis.driveLEnc.get()==-7118*3.9252336449){
			return true;
			}
			else
				return false;
		}
		else*/
			return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
