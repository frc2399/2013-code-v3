
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.image.BinaryImage;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.NIVision.MeasurementType;
import edu.wpi.first.wpilibj.image.NIVisionException;
import edu.wpi.first.wpilibj.image.ParticleAnalysisReport;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.image.CriteriaCollection;
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
    
    AxisCamera camera;
    CriteriaCollection cc;
    
    int numBlobs = 0;
    BinaryImage newFilteredImage;
    int blobWeWant;
    int blobHeight;
    ParticleAnalysisReport newReport;
    

    final double topWidth = 62;
    final double middleWidth = 62;
    final double lowWidth = 29;
    final double topHeight = 20;
    final double middleHeight = 29;
    


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
    
    public double getDistance(int particleNumber, double pixelWidth, double degrees) {
        double targetWidthIn = 64.0;

        double distance = ((320.0 * (targetWidthIn / pixelWidth)) / 2.0) / Math.tan(degrees * (Math.PI / 180.0));
        SmartDashboard.putNumber("Distance From Targets", distance);
        return distance;
    }
    
    public String getTargetType(int particle) {

        String target = "not set";
        try {
            ParticleAnalysisReport report = newFilteredImage.getParticleAnalysisReport(particle);

            int blobWidth = report.boundingRectWidth;
            int blobHeight = report.boundingRectHeight;

            if (blobWidth / blobHeight > (topWidth / topHeight - 1) && blobWidth / blobHeight < (topWidth / topHeight + 1)) {
                target = "Top target";
            } else if (blobWidth / blobHeight > (middleWidth / middleHeight - 1) && blobWidth / blobHeight < (middleWidth / middleHeight + 1)) {
                target = "Middle Target";
            } else {
                target = "Not Top/Middle";
            }
        } catch (NIVisionException ex) {
            ex.printStackTrace();
        }
        return target;

    }
    
    public int getNumParticles(){
        if(numBlobs == 0){
            imageProcessing();
        }
        return numBlobs;
    }
    
    public double getAimPitch(){
        
        return 0.0;
    }
    
     public void imageProcessing(){
        camera = AxisCamera.getInstance("10.23.99.11");
        camera.writeMaxFPS(30); 
         
        cc = new CriteriaCollection(); 
        cc.addCriteria(MeasurementType.IMAQ_MT_AREA, 500, 65535, false);
        camera.writeResolution(AxisCamera.ResolutionT.k320x240);
        
         try {
            ColorImage image = camera.getImage();

            
            BinaryImage thresholdImage = image.thresholdHSV(0, 255, 0, 255, 223, 255);    //testing these valus now...
            BinaryImage convexHullImage = thresholdImage.convexHull(false);          // fill in occluded rectangles
            BinaryImage filteredImage = convexHullImage.particleFilter(cc);           // filter out small particles
            newFilteredImage = convexHullImage.particleFilter(cc);
            
            //prints out the number of particles (red blobs) it sees after filtering
            //number of particles should be the number of targets in your viewing angle
            numBlobs = filteredImage.getNumberParticles();

            SmartDashboard.putNumber("Number of Targets", numBlobs);

            for (int i = 0; i < numBlobs; i++) {
                ParticleAnalysisReport report = filteredImage.getParticleAnalysisReport(i);
                if( i == 0){
                    blobWeWant = i;
                    blobHeight = report.boundingRectHeight;
                } else if( blobHeight > report.boundingRectHeight){
                    blobWeWant = i;
                }
             }
            
             newReport = filteredImage.getParticleAnalysisReport(blobWeWant);

             //Always free every image you make!!!!
             image.free();
             thresholdImage.free();
             convexHullImage.free();
             filteredImage.free();

         } catch (AxisCameraException ex) {
             ex.printStackTrace();
         } catch (NIVisionException ex) {
             ex.printStackTrace();
         }  
    }
    
}

