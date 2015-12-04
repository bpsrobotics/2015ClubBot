package org.usfirst.frc.team1510.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1510.robot.subsystems.Drive;
import org.usfirst.frc.team1510.robot.*;

public class AutoDrive extends Command {

	private static Drive drivetrain = Robot.drivetrain;
	private boolean complete = false;
	private double distance = 0.0;
	private double angle = 0.0;
	private double speed = 0.0;
	
	public AutoDrive(double distance, double angle, double speed) {
		this("Automatic Drive");
		this.distance = distance;
		this.angle = angle;
		this.speed = speed;
	}

	protected AutoDrive(String name) {
		this(name,15);
	}

	protected AutoDrive(String name, double timeout) {
		super(name, timeout);
		requires(drivetrain);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		complete = drivetrain.moveDistance(distance, angle, speed);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return complete;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
