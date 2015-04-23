package org.usfirst.frc.team4617.robot.commands;
import org.usfirst.frc.team4617.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class HalfToteDown extends Command {
	public static double eleLvl;
	public static final int TOTE_LVL = -3264;
	public static final int MAX_LVL = -7118;
	public static final int ZERO_LVL = 0;        private double setpoint;

	public HalfToteDown (/*double setpoint*/) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.kawaiilifter);
		//this.setpoint = setpoint;  
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		eleLvl = 0;
		//Sets default setpoint for this command 
		//Robot.kawaiilifter.setSetpoint(setpoint);
		eleLvl = Robot.kawaiilifter.getState() - 0.5;//Increase count when button pressed
		Robot.kawaiilifter.setState(eleLvl);//Set count in set state function correspondingly

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		
	/*	if (Robot.kawaiilifter.liftEnc.get() < ZERO_LVL){//If encoder more negative than zero level (more)
			//If encoder more negative, then target tote height*number of existing totes
			if (Robot.kawaiilifter.liftEnc.get() < TOTE_LVL*Robot.kawaiilifter.getState()){     */  //This is the target setpoint 
				setpoint = TOTE_LVL*Robot.kawaiilifter.getState();
				Robot.kawaiilifter.setSetpoint(setpoint);
							
		

		//else //If max value is reached, set elevator level to 4617 ;)
			//eleLvl = 4617;
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		//int lvlState = 0;
		//for (int i=1; i<5; i++){
			//Check if encoder is at a valid tote level, TOTE_LVL*i will be the setpoint of the pid 
			if ((Math.abs(Robot.kawaiilifter.getPosition()) - setpoint) <5)
				return true;
		
		//If conditions are not met for command to finish (unless interrupted by other elevator command), 
		//then continue command until they are
			else
				return false; 
	}

	protected void end() {
		Robot.kawaiilifter.setSpeed(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
