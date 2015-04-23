package edu.wpi.first.wpilibj.tools;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DebugValue {
	String name;
	public DebugValue (String name, double value){
		this.name = name;
		SmartDashboard.putNumber(name, value);
	}
	public DebugValue (String name, int value){
		this.name = name;
		SmartDashboard.putNumber(name, value);
	}
	public double getNumber(){
	return SmartDashboard.getNumber(name);	
	}
	
	public void putNumber(double value){
		SmartDashboard.putNumber(name, value);
	}
}
