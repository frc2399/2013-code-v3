
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Jessie
 */
public class TestPitchOff extends CommandBase {

    
    public TestPitchOff() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(pitch);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        try{
            pitch.pitchMot.setX(0.0);
        }catch(Exception e){
            
        }
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
