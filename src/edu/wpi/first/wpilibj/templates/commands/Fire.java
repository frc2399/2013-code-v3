
package edu.wpi.first.wpilibj.templates.commands;

/**
 * Fire controls the movement of the trigger.  It is used to shoot push the Frisbee
 * in the lowest spot (sitting on the pitch plate) into the spinning wheel shooter.
 * In order to fire, make sure the wheel is spinning first, or else you will not
 * actually fire the disk, and when you do start the wheel, the disk will just 
 * kind of drop out and not really fly at all.  In order to actually use this to 
 * fire things, you MUST call this command twice.  Due to stupid Brad Miller reasons,
 * it is not possible to make this servo move forward and back in one command 
 * without the use of more sensors, which are pretty much impossible to mount on
 * the pitch plate with our current setup.  This is really no big deal, because 
 * in the OI, it is set up so that whatever button is assigned to fire the disk
 * calls two Fire commands instead of one.  When the fire button is pressed, it 
 * moves the trigger forward, and when it is released, it moves the trigger back.
 * I am aware that it does not move that fast, but because the trigger is a servo,
 * there is really nothing I can do about it.  
 * @author Jessie
 */
public class Fire extends CommandBase {

    boolean leftSwitch;
    
    /**
     * Moves the trigger to the specified angle.
     * @param angle The angle you want the trigger to move to.  0 = full Left, 1 = full right.
     */
    public Fire() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(trigger);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        leftSwitch = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        trigger.setSpeed(.5);
        //System.out.println(trigger.triggerSensor.get());
        if(trigger.triggerSensor.get() == false){
            leftSwitch = true;
        }
        
        //trigger.triggerMot.getAngle();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return trigger.triggerSensor.get() && leftSwitch;
    }

    // Called once after isFinished returns true
    protected void end() {
        trigger.setSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        trigger.setSpeed(0);
    }
}
