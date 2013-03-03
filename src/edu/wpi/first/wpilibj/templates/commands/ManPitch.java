

package edu.wpi.first.wpilibj.templates.commands;

/**
 * ManPitch is used to control the pitch of the pitch plate using the joysticks.
 * The setpoint of the pitch is based off of the throttle control on the Driving 
 * Joystick.  It will always run, but if you take away its subsystems, it will stop.
 * @author Jessie
 */
public class ManPitch extends CommandBase {

    public ManPitch() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(pitch);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //IF YOU CHANGE THE JOYSTICK FOR THIS, PLEASE CHANGE THE JAVADOC, TOO!
        //pitch.setSetpoint(oi.getDriveyStickThrottle() * 180);
        System.out.println("regular pitch angle " + pitch.pitchEncoder.getValue());
        System.out.println("PID pitch angle " + pitch.pitchEncoder.pidGet());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
