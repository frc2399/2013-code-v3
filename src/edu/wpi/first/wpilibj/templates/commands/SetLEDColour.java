
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.subsystems.Vision;

/**
 * used to set color for lights on LED light ring
 * @author Lauren Dierker
 */
public class SetLEDColour extends CommandBase {
    
    public boolean red;
    public boolean blue;
    public boolean green;
    public boolean amber;

    /**
     * 
     * @param red the boolean for red LEDs being on or off
     * @param blue the boolean for blue LEDs being on or off
     * @param green the boolean for green LEDs being on or off
     * @param amber the boolean for amber LEDs being on or off
     */
    public SetLEDColour( boolean red, boolean blue, boolean green, boolean amber ) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(vision);
        this.red = red;
        this.blue = blue;
        this.green = green;
        this.amber = amber;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        vision.setLEDLights(red, blue, green, amber);
        
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
