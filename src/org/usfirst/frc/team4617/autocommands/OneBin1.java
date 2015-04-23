package org.usfirst.frc.team4617.autocommands;

import org.usfirst.frc.team4617.robot.commands.AutoBin;
import org.usfirst.frc.team4617.robot.commands.AutoDrive;
import org.usfirst.frc.team4617.robot.commands.ZeroElevator;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class OneBin1 extends CommandGroup {
    
    public  OneBin1() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	
    	addSequential(new AutoBin(0.6, 1));//double speed, int numBins
    	addSequential(new AutoDrive(-7118*3.9252336449)); //distance in inches
    	addSequential(new ZeroElevator());
        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
