/**
 * 
 */
package org.usfirst.frc.team1510.robot.subsystems;

import edu.wpi.first.wpilibj.command.*;
import edu.wpi.first.wpilibj.*;
import org.usfirst.frc.team1510.robot.commands.*;

/**
 * @author Stephen
 */
public final class Drive extends Subsystem {
	
	private static final int PULSE_PER_ROT_ENCODER = 8;
	private static final CANTalon frontLeft = new CANTalon(3);
	private static final CANTalon frontRight = new CANTalon(4);
	private static final CANTalon rearRight = new CANTalon(2);
	private static final CANTalon rearLeft = new CANTalon(1);
	private static final RobotDrive drive = new RobotDrive(frontLeft,rearLeft,frontRight,rearRight);
	private static final Encoder[] encoders = {new Encoder(1,2),new Encoder(3,4),new Encoder(5,6),new Encoder(7,8)};
	private final double wheelSize;

	/**
	 * Constructor for the Drive subsystem
	 * @param wheelSize The size of the mecanum wheels in inches
	 */
	public Drive(double wheelSize) {
		this.wheelSize = wheelSize;
		reset();
		for (Encoder e : encoders) {
			e.setDistancePerPulse(PULSE_PER_ROT_ENCODER/(12.5*(Math.PI*this.wheelSize)));
		}
	}
	

	/**
	 * Constructor for the Drive subsystem
	 * @param name What to name this subsystem
	 */
	public Drive(String name) {
		super(name);
		this.wheelSize = 0;
		reset();
	}
	
	/**
	 * Moves based on the joystick values.
	 * @param joystick
	 */
	public void move(GenericHID joystick) {
		drive.mecanumDrive_Cartesian(joystick.getX(), joystick.getY(), joystick.getRawAxis(4), 0);
	}
	
	/**
	 * Moves forward at magnitude <code>x</code> and left at magnitude <code>y</code>. Rotates clockwise with speed <code>rotation</code>.
	 * Negative values will result in reverse directions (reverse, right, and counterclockwise respectively).
	 * @param x The forward speed
	 * @param y The left speed
	 * @param rotation The rotation speed
	 */
	public void move(double x, double y, double rotation) {
		drive.mecanumDrive_Cartesian(x,y,rotation,0);
	}
	
	/**
	 * Stops all motors.
	 */
	public void stop() {
		drive.stopMotor();
	}
	
	/**
	 * Resets distance on all encoders.
	 */
	public void reset() {
		for (Encoder e : encoders) {
			e.reset();
		}
	}
	
	/**
	 * The moveDistance method uses polar coordinates to determine where to go and how fast to get there.
	 * The distance parameter is how far you want the robot to go. Call this in some sort of loop, it has no
	 * internal one.
	 * @param distance The distance to travel
	 * @param direction The direction in degrees
	 * @param speed The magnitude of the motors to travel at
	 * @return Whether or not the target distance was reached
	 */
	public boolean moveDistance(double distance, double direction, double speed) {
		if (getAvgDistance() < distance) {
			drive.mecanumDrive_Polar(speed, direction, 0);
			return false;
		} else {
			stop();
			return true;
		}
	}
	
	private double getAvgDistance() {
		double avg = 0.0;
		for (Encoder e : encoders) {
			avg += e.getDistance();
		}
		avg /= encoders.length;
		
		return avg;
	}

	/* (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.command.Subsystem#initDefaultCommand()
	 */
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new DriveDefaultCommand());
	}

}
