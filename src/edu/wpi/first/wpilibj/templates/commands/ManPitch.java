

package edu.wpi.first.wpilibj.templates.commands;

/**
 *
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
