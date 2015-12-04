/**
 * 
 */
package org.usfirst.frc.team1510.robot.oi;

import edu.wpi.first.wpilibj.Joystick;

/**
 * @author Stephen
 *
 */
public final class Gamepad extends Joystick {

	/**
	 * @param port The USB port of the gamepad
	 */
	public Gamepad(int port) {
		super(port, 6, 10);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Returns a Vector2D object representing the location of the left stick in rectangular space
	 * @return a Vector2D object representing the location of the left stick in rectangular space
	 */
	public Vector2D getStick1() {
		return new Vector2D(getRawAxis(0),getRawAxis(1));
	}
	
	/**
	 * Returns a Vector2D object representing the location of the right stick in rectangular space
	 * @return a Vector2D object representing the location of the right stick in rectangular space
	 */
	public Vector2D getStick2() {
		return new Vector2D(getRawAxis(3),getRawAxis(4));
	}
	
	/**
	 * Returns the -1 -> 1 value of the left trigger
	 * @return the -1 -> 1 value of the left trigger
	 */
	public double getLeftTrigger() {
		return getRawAxis(2);
	}
	
	/**
	 * Returns the -1 -> 1 value of the right trigger
	 * @return the -1 -> 1 value of the right trigger
	 */
	public double getRightTrigger() {
		return getRawAxis(5);
	}
	
	/**
	 * Returns an array of the states of all buttons on the gamepad
	 * @return an array of the states of all buttons on the gamepad
	 */
	public boolean[] getButtons() {
		boolean[] result = new boolean[getButtonCount()];
		for (int i = 1; i <= getButtonCount(); i++) {
			result[i-1] = getRawButton(i);
		}
		return result;
	}

}
