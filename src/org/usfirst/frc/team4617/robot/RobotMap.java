package org.usfirst.frc.team4617.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static final int leftJoystickPort = 0;
    public static final int rightJoystickPort = 1;
    public static final int operatorJoystickPort = 2;    
    public static final int[] intake = {2, 8}; //change
    public static final int[] lifter = {0, 1};
    public static final int[] liftEncPort = {0, 1};
    public static final int[] driveEncPort = {2, 3, 4, 5};
    public static final int[] driveControllersPort = {4, 5, 6, 7};
}


