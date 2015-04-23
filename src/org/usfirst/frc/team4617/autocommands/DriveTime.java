package org.usfirst.frc.team4617.autocommands;



import org.usfirst.frc.team4617.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveTime extends Command {
public double speed;
public double time;
    public DriveTime(double time, double speed, boolean direction) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot .chassis);
        this.time = time;
        setTimeout(time);
        this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Robot.chassis.drive(speed, speed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.chassis.drive(-speed, -speed);
    	System.out.println(Robot.chassis.driveLEnc.getDistance());
    	System.out.println(Robot.chassis.driveREnc.getDistance());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassis.drive(0,0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
