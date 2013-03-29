
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Lauren Dierker
 */
public class SetLEDColourRotation extends CommandBase {


    public int count = 0;

    /**
     * 
     * @param red the boolean for red LEDs being on or off
     * @param blue the boolean for blue LEDs being on or off
     * @param green the boolean for green LEDs being on or off
     * @param amber the boolean for amber LEDs being on or off
     */
    public SetLEDColourRotation() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(vision);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(count == 0){
          vision.setLEDLights(true, false, false, false); 
          count++;
        }else if(count == 1){
            vision.setLEDLights(false, true, false, false); 
            count++;
        }else if(count == 2){
            vision.setLEDLights(false,false, true, false); 
            count++;
        }else if(count == 3){
            vision.setLEDLights(false, false, false, true); 
            count++;
        }else if(count == 4){
            vision.setLEDLights(true, true, false, false); 
            count++;
        }else if(count == 5){
            vision.setLEDLights(true, false, true, false);
            count++;
        }else if(count == 6){
            vision.setLEDLights(true, false, false, true); 
            count++;
        }else if(count == 7){
            vision.setLEDLights(false, true, true, false); 
            count++;
        }else if(count == 8){
            vision.setLEDLights(false, true, false, true); 
            count++;
        }else if(count == 9){
            vision.setLEDLights(false, false, true, true); 
            count++;
        }
        
        else if(count == 10){
            vision.setLEDLights(true, true, true, false);
            count++;
        }else if(count == 11){
            vision.setLEDLights(true, false, true, true); 
            count++;
        }else if(count == 12){
            vision.setLEDLights(true, true, false, true); 
            count++;
        }else if(count == 13){
            vision.setLEDLights(true, true, true, false); 
            count++;
        }
        
        else if(count == 14){
            vision.setLEDLights(true, true, true, true); 
            count++;
        }
        
        else{
            count = 0;
        }
        
        
    }

    // Make this return true when this Command no longer needs to run execute()
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
