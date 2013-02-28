
package edu.wpi.first.wpilibj.templates.commands;



/**
 *
 * @author Lauren Dierker and Jessie Adkins
 */
public class JoystickDrive extends CommandBase {

    int dir;
    boolean fieldOrient;
    
    /**
     * 
     * @param direction decides if the controls are inverted or not. Input 1 if normal, and -1 if inverted
     * @param fieldOriented set to true if you want field oriented driving.  This requires a gyro.
     */
    public JoystickDrive(int direction, boolean fieldOriented) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(driveTrain);
        dir = direction;
        fieldOrient = fieldOriented;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        driveTrain.startTestEncoder();
        //driveTrain.resetGyro();
        
        //for some reason, when the timer is in use, the joysticks stop actually
        //driving the robot.  I don't know why, but we should remember this
        //for future reference, so we don't screw up a class later on.  
        //timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        
        if(fieldOrient == true){
            driveTrain.drive.mecanumDrive_Cartesian(dir * oi.getSideSpeed(), dir * oi.getForwardSpeed(), dir * oi.getTwistSpeed(), driveTrain.getGyroAngle());
        }else{
            driveTrain.drive.mecanumDrive_Cartesian(dir * oi.getSideSpeed(), dir * oi.getForwardSpeed(), dir * oi.getTwistSpeed(), 0);
        }
        
        
        //System.out.println("gyro: " + driveTrain.getGyroAngle());
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
