
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.subsystems.Vision;

/**
 *
 * @author Lauren Dierker
 */
public class NewTestVision extends CommandBase {
    boolean top;
    boolean middle;
    boolean processing;

    public NewTestVision(boolean top, boolean middle, boolean processing) {
        this.middle = middle;
        this.top = top;
        this.processing = processing;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(top){
            pitch.setPosition(vision.getAimPitchTop());
        } else if(middle){
            pitch.setPosition(vision.getAimPitchTop());
        } else if(processing){
            vision.imageProcessing();
        }
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
