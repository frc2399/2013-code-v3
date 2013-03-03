
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.TestVision;
import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.image.BinaryImage;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.CriteriaCollection;
import edu.wpi.first.wpilibj.image.NIVision.MeasurementType;
import edu.wpi.first.wpilibj.image.NIVisionException;
import edu.wpi.first.wpilibj.image.ParticleAnalysisReport;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Solenoid;

/**
 *
 * @author Lauren Dierker
 */
public class Vision extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public Solenoid SolenoidRed = new Solenoid(1);
    public Solenoid SolenoidBlue = new Solenoid(2);
    public Solenoid SolenoidGreen = new Solenoid(3);
    public Solenoid SolenoidAmber = new Solenoid(4);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        
        //setDefaultCommand( new TestVision());
    }
    
    /**
     * sets different colour LED lights to on or off
     * @param red the boolean for red LEDs being on or off
     * @param blue the boolean for blue LEDs being on or off
     * @param green the boolean for green LEDs being on or off
     * @param amber the boolean for amber LEDs being on or off
     */
    public void setLEDLights(boolean red, boolean blue, boolean green, boolean amber){
        SolenoidRed.set(red);
        SolenoidBlue.set(blue);
        SolenoidGreen.set(green);
        SolenoidAmber.set(amber);
    }
    
}

