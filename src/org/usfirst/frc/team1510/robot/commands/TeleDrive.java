/*
 * (c) 2015 FRC Team 1510. All rights reserved.
 */
package org.usfirst.frc.team1510.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1510.robot.subsystems.*;
import org.usfirst.frc.team1510.robot.*;
import org.usfirst.frc.team1510.robot.oi.*;

/**
 * @author Stephen
 * @version 1.0 May 2015
 */
public class TeleDrive extends Command {
	
	private static final Drive drivetrain = Robot.drivetrain;
	private static final Gamepad controller = OI.driver;

	/**
	 * 
	 */
	public TeleDrive() {
		super("Remote Drive");
		requires(drivetrain);
	}
	
	/**
	 * @see edu.wpi.first.wpilibj.command.Command#initialize()
	 */
	@Override
	protected void initialize() {
		// Not used, just here to complete the initialize() requirement of Command
	}

	/**
	 * @see edu.wpi.first.wpilibj.command.Command#execute()
	 */
	@Override
	protected void execute() {
		drivetrain.move(controller);
	}

	/**
	 * @see edu.wpi.first.wpilibj.command.Command#isFinished()
	 */
	@Override
	protected boolean isFinished() {
		return false;
	}

	/**
	 * @see edu.wpi.first.wpilibj.command.Command#end()
	 */
	@Override
	protected void end() {
		// Not used, just here to complete the end() requirement of Command
	}

	/**
	 * @see edu.wpi.first.wpilibj.command.Command#interrupted()
	 */
	@Override
	protected void interrupted() {
		// Not used, just here to complete the interrupted() requirement of Command
	}

}
