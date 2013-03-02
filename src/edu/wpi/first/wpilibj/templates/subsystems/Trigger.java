
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.Fire;
import edu.wpi.first.wpilibj.HiTechnicColorSensor;

/**
 * if things start breaking, check the RobotMap to make sure port #'s are correct!
 * @author Jessie
 */
public class Trigger extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public Servo triggerMot = new Servo(RobotMap.triggerMot);
    public HiTechnicColorSensor colorSensor = new HiTechnicColorSensor(RobotMap.colorSensor);
    
    

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new Fire(0.4));
    }
    
    public void setSpeed(double speed){
        triggerMot.set(speed);
    }
    
    public double getPosition(){
        return triggerMot.get();
    }
}

