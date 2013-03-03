
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
 */
public class Vision extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public Solenoid SolenoidRed = new Solenoid(3, 0);
    public Solenoid SolenoidBlue = new Solenoid(3, 1);
    public Solenoid SolenoidGreen = new Solenoid(3, 2);
    public Solenoid SolenoidAmber = new Solenoid(3, 3);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        
        //setDefaultCommand( new TestVision());
    }
    
    public void setLEDLights(boolean red, boolean blue, boolean green, boolean amber){
        SolenoidRed.set(red);
        SolenoidBlue.set(blue);
        SolenoidGreen.set(green);
        SolenoidAmber.set(amber);
    }
    
}

