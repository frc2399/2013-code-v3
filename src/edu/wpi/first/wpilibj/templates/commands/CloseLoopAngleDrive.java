
package edu.wpi.first.wpilibj.templates.commands;


import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.templates.PIDOutputTranslator;
/**
 * The purpose of CloseLoopAngleDrive is to be able to drive the robot with 
 * the joysticks while it stays at one constant angle.  This command uses a PID 
 * Controller to force the robot to stay at one angle, and if the robot is jostled,
 * it will move back to the set angle.  However, this means that although the 
 * drivers are in control of most of the robot controls, they are unable to turn
 * it manually, and twisting the joystick will do absolutely nothing.  If you 
 * want to return to regular driving, you must implement a command that takes 
 * away the subsystems of CloseLoopAngleDrive (AKA driveTrain), or else it will 
 * never end.  You cannot kill it in any way other than overriding it.  Once again, 
 * to YOU CANNOT KILL IT, YOU CAN ONLY TAKE AWAY ITS SUBSYSTEMS AND IT WILL STOP!
 * @author Jessie
 */
public class CloseLoopAngleDrive extends CommandBase {
    PIDController controller;
    PIDOutputTranslator translator;
    double angle;
    double initialAngle;
    
    /**
     * Creates a new CloseLoopAngleDrive
     * @param angle The angle at which you want the robot to consistently stay at.
     */
    public CloseLoopAngleDrive(double angle) {
        //change parameters so P can be adjusted according to function
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(driveTrain);
        this.angle = angle;
        
    }
    

    // Called just before this Command runs the first time
    protected void initialize() {
        
        translator = new PIDOutputTranslator();
        
        //controller = new PIDController(oi.getLeftStickThrottle(), 0, 0, driveTrain.gyro, translator);
        
        // 2/14/13 we tested and got: P 0.005554872047244094 I 2.8125000000000003E-4
        //THESE ARE SLIGHTLY TOO BIG!!!!!
        //controller = new PIDController((oi.getDriveyStickThrottle() + 1.0) * 0.00546875, (oi.getLeftStickThrottle() + 1.0) * 0.001, 0, driveTrain.gyro, translator);
        // P = 0.00546875
        initialAngle = driveTrain.getGyroAngle();
        controller.setSetpoint(initialAngle + angle);
        controller.setPercentTolerance(1);
        controller.setInputRange(-360, 360);
        controller.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //System.out.println("Translator: " + translator.getValue() + "P " + controller.getP() + "I " + controller.getI());
        
        //controller.setSetpoint(initialAngle + 180 * oi.getTwistSpeed());
        driveTrain.drive.mecanumDrive_Cartesian(oi.getSideSpeed(), oi.getForwardSpeed(), -translator.getValue(), 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        controller.disable();
        controller.free();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        controller.disable();
        controller.free();
    }
}

