/**
 * 
 */
package org.usfirst.frc.team1510.robot.oi;

import edu.wpi.first.wpilibj.Joystick;

/**
 * @author Stephen
 *
 */
public final class TwistJoystick extends Joystick {

	/**
	 * @param port The port for this TwistJoystick.
	 */
	public TwistJoystick(int port) {
		super(port, 4, 12);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param port
	 * @param numAxisTypes
	 * @param numButtonTypes
	 */
	private TwistJoystick(int port, int numAxisTypes, int numButtonTypes) {
		super(port, numAxisTypes, numButtonTypes);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double getTwist() {
		return getRawAxis(2);
	}
	
	@Override
	public double getThrottle() {
		return getRawAxis(3);
	}

}
