
package edu.wpi.first.wpilibj.templates.commands;

/**
 * Resets the gyro defined in the driveTrain subsystem.  
 * This can be used for updating positioning and field oriented driving.
 * If the gyro is left alone for too long (approx. 20 seconds), it will no longer
 * be accurate.  The drivers should reset the gyro regularly if they are using 
 * any commands that require the use of the gyro.  
 * This class ends.
 * @author Jessie
 */
public class GyroReset extends CommandBase {

    /**
     * Resets the gyro so that the direction the robot is currently facing is 
     * redefined as zero.  All other uses of the gyro will now update to use
     * this new zero position.  
     */
    public GyroReset() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(driveTrain);
    }

    // Called just before this Command runs the first time
    //resets the gyro made in the driveTrain subsystem
    protected void initialize() {
        driveTrain.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    //in this command, you only need to use initialize, so isFinished() will always
    //return true, so this ends promptly
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
