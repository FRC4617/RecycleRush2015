package org.usfirst.frc.team4617.robot.commands;

import org.usfirst.frc.team4617.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TestElevator extends Command {
	 
    public TestElevator() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.kawaiilifter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.kawaiilifter.setSpeed(Robot.oi.joyOP.getDeadY());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    Robot.kawaiilifter.setSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }	
}
