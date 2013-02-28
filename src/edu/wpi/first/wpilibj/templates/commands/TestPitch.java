
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Jessie
 */
public class TestPitch extends CommandBase {

    double speed;
    
    public TestPitch(double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(pitch);
        this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        try{
            pitch.pitchMot.setX(speed);
        } catch(Exception e){
            
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        boolean isDone = false;
        try{
            isDone = pitch.pitchMot.getX() == speed;
        }catch(Exception e){
            isDone = true;
            //e.printStackTrace();
        }
        return isDone;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
