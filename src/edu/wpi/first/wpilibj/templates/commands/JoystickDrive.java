
package edu.wpi.first.wpilibj.templates.commands;



/**
 * This is the default state of the robot.  JoystickDrive means that Otto is 
 * currently controlled by the fancy joystick (the one on the right side of the 
 * driver station), and is in the proper mode to drive on his mecanum wheels.  
 * This means that he will move forward and backward if the joystick is pushed 
 * forward or pulled back, turn left and right based on the joystick input, and 
 * strafe left and right based on joystick inputs.  This command never ends, so
 * if you want to change the settings for how it drives, you would need to override
 * the subsystems of JoystickDrive (AKA driveTrain).  If you don't override the 
 * subsystems, IT WILL NEVER END.  Likewise, if there is another command being used
 * to drive Otto and you want to kill it, just enable JoystickDrive and it will 
 * instantly get you back to a regular driving platform.  This is very useful for 
 * KILLING DRIVETRAIN PID'S!  If Otto starts spinning out of control, ENABLE 
 * JOYSTICKDRIVE!  There is a button for this in the OI.
 * @author Lauren Dierker and Jessie Adkins
 */
public class JoystickDrive extends CommandBase {

    int dir;
    boolean fieldOrient;
    
    /**
     * Creates a new JoystickDrive command.  This command always runs, unless it's
     * subsystems are taken away.  There are a few different ways to drive using 
     * this command.  If FieldOriented is false, it is driven normally, but if it 
     * is set to true, FieldOriented driving is enabled.  Field oriented driving
     * means that the direction the robot is facing when it is enabled is set to 
     * forward, and whatever inputs the joystick gives are used to move the robot
     * in relation to that.  Basically, the robot has a defined forward, back, left,
     * and right, and the joystick now conforms to those controls instead of the 
     * actual facing of the robot.  In order to designate a new forward, you must 
     * reset the gyro, but that is not hard because you can use the command 
     * GyroReset(), and there is a button for that in the OI.  Field Oriented driving
     * is all about driver preference, so it is very easy to switch between the 
     * two modes.  All you have to do is override one JoystickDrive with the other,
     * and the new one will cancel out the old one.  
     * @param direction decides if the controls are inverted or not. Input 1 if normal, and -1 if inverted
     * @param fieldOriented set to true if you want field oriented driving.  This requires a gyro.
     */
    public JoystickDrive(int direction, boolean fieldOriented) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(driveTrain);
        requires(colorSensor);
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
        
        //System.out.println("color: " + colorSensor.colorSensor.getColor());
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
