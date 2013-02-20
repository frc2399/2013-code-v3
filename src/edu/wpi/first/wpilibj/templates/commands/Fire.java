
package edu.wpi.first.wpilibj.templates.commands;



/**
 * Moves the trigger fully to the right then fully to the left in order to push a 
 * Frisbee.  
 * @author Jessie
 */
public class Fire extends CommandBase {
    double angle;

    /**
     * 
     */
    public Fire(double angle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(trigger);
        this.angle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        
        
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //THIS IS NOT DONE
        //WORK ON MORE WHEN YOU HAVE SENSORS
        //AND AN ACTUAL ROBOT
        //AND TESTING
        //YEAH
        //COOL
        //DON'T FORGET
        
        trigger.triggerMot.set(angle);
        //trigger.triggerMot.getAngle();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return trigger.triggerMot.get() == angle;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
