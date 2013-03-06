
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.templates.PIDOutputTranslator;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.templates.AccelerometerPosition;
/**
 *
 * @author Jessie
 */
public class PIDStrafe extends CommandBase {

    
    PIDController controller;
    PIDOutputTranslator translator;
    
    AccelerometerPosition accelerometerPosition;
    
    double dist;
    
    /**
     * 
     * @param dist the desired distance in meters
     */
    public PIDStrafe(double dist) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(driveTrain);
        this.dist = dist;
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        
        translator = new PIDOutputTranslator();
        accelerometerPosition = new AccelerometerPosition();
        accelerometerPosition.reset();
        
        //use this for testing P constant
        //controller = new PIDController((oi.getDriveyStickThrottle() + 1.0) / 20.0, 0, 0, driveTrain.gyro, translator);
        
        controller = new PIDController(0.001, 0.0, 0.0, accelerometerPosition, translator);
        
        controller.setSetpoint(dist);
        controller.setPercentTolerance(5);
        controller.enable();
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        driveTrain.drive.mecanumDrive_Cartesian(translator.getValue(), 0, 0, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return controller.onTarget();
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
