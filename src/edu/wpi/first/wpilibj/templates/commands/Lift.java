
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Jessie
 */
public class Lift extends CommandBase {

    double speed; 
    
    /**
     * Moves the lifting hooks up and down.  
     * @param speed the speed at which you want the lift motors to move at. -1 <= speed <= 1.
     */
    public Lift(double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(climbing);
        this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        climbing.setSpeed(speed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
