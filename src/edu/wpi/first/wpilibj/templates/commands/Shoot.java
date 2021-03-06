
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.subsystems.Shooter;

/**
 *
 * @author Jessie, Lauren, and Amanda
 */
public class Shoot extends CommandBase {

    double speed;
    int i;
    
    public Shoot(double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(shooter);
        this.speed = -speed;
        i = 0;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        //shooter.setSetpoint(speed);
        try{
            shooter.shootMot.enableControl();
        }catch(Exception e){
            
        }
        shooter.setShooterSpeed(speed * 3000);
        //System.out.println("Shooter encoder " + shooter.shootEncoder.get());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        /**
        if(i < 15){
            i++;
        }else{
            //System.out.println("sent to shooter jag: " + shooter.getSpeed() + " taken from shooter encoder: " + shooter.getSpeedSetpoint());
            i = 0;
        }
         */ 
    }

    // Make this return true when this Command no longer needs to run execute()
    //ends command if the speed of the shooter is greater than or equal to the input speed
    protected boolean isFinished() {
        //return shooter.onTarget();\
        return shooter.isReady();
    }

    // Called once after isFinished returns true
    protected void end() {
        /**
        try{
            //shooter.shootMot.disableControl();
        }catch(Exception e){
            
        }
         */ 
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        /**
        try{
            shooter.shootMot.disableControl();
        }catch(Exception e){
            
        }
         */ 
    }
}
