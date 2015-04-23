package org.usfirst.frc.team4617.robot;

import org.usfirst.frc.team4617.robot.commands.BinUp;
import org.usfirst.frc.team4617.robot.commands.ElevatorDown;
import org.usfirst.frc.team4617.robot.commands.FeedIn;
import org.usfirst.frc.team4617.robot.commands.FeedOut;
import org.usfirst.frc.team4617.robot.commands.HalfToteDown;
import org.usfirst.frc.team4617.robot.commands.StopIntake;
import org.usfirst.frc.team4617.robot.commands.TestEncCount;
import org.usfirst.frc.team4617.robot.commands.ToteUp;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.tools.Attack3Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	public static Attack3Joystick joyL = new Attack3Joystick (RobotMap.leftJoystickPort);
	public static Attack3Joystick joyR = new Attack3Joystick (RobotMap.rightJoystickPort);
	public static Attack3Joystick joyOP = new Attack3Joystick (RobotMap.operatorJoystickPort);
   // public JoystickButton testEle = new JoystickButton (joyOP, 8);
    public JoystickButton testDriveEnc = new JoystickButton (joyOP, 7);
	public JoystickButton feedIn = new JoystickButton (joyR, 1);
    public JoystickButton feedOut = new JoystickButton (joyR, 2);
    public JoystickButton toteUp = new JoystickButton (joyOP, 3);
    public JoystickButton stop = new JoystickButton (joyR, 4);
	public JoystickButton eleDown = new JoystickButton (joyOP, 2);
	public JoystickButton binUp = new JoystickButton (joyOP, 4);
	public JoystickButton halfToteDown = new JoystickButton (joyOP, 5);

	public OI(){
        //testIntake.whenPressed(new TestIntake());
		toteUp.whenPressed(new ToteUp());
		eleDown.whenPressed(new ElevatorDown());
		testDriveEnc.whenPressed(new TestEncCount());
		binUp.whenPressed(new BinUp());
        halfToteDown.whenPressed(new HalfToteDown());
        feedIn.whenReleased(new FeedIn());
        feedOut.whenPressed(new FeedOut());
        stop.whenPressed(new StopIntake());
                       
	}
}


