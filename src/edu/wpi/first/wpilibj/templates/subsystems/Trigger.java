
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.Fire;
import edu.wpi.first.wpilibj.HiTechnicColorSensor;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 * @author Jessie
 */
public class Trigger extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
 
    public CANJaguar triggerMot; 
    public HiTechnicColorSensor colorSensor = new HiTechnicColorSensor(RobotMap.colorSensor);
    public DigitalInput triggerSensor = new DigitalInput(RobotMap.triggerSensor);
    
    boolean leftSwitch;
    
    
    public Trigger(){
        try{
            triggerMot = new CANJaguar(RobotMap.testTriggerMot);
        }catch(Exception e){
            
        }
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setSpeed(double speed){
        try{
            triggerMot.setX(speed);
        }catch(Exception e){
            
        }
    }
    
}

