
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.image.BinaryImage;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.CriteriaCollection;
import edu.wpi.first.wpilibj.image.NIVision.MeasurementType;
import edu.wpi.first.wpilibj.image.NIVisionException;
import edu.wpi.first.wpilibj.image.ParticleAnalysisReport;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author Lauren Dierker
 */
public class PyramidAim extends CommandBase {
    
    AxisCamera camera;
    CriteriaCollection cc;

    
    BinaryImage newFilteredImage;
    int i = 0;
    int blobWeWant;
    int blobHeight;
    ParticleAnalysisReport report;
    

    public PyramidAim() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(vision);
        requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
         camera = AxisCamera.getInstance("10.23.99.11");
         camera.writeMaxFPS(30);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        //System.out.println("Execute Pyramid Aim is running is running.");
        
        if( camera.freshImage()){
            
            cc = new CriteriaCollection(); 
            cc.addCriteria(MeasurementType.IMAQ_MT_AREA, 500, 65535, false); //this might change, MUST BE TESTED with pyramid tape

            camera.writeResolution(AxisCamera.ResolutionT.k320x240);   //will not work with a lower reolution


            try {

                ColorImage image = camera.getImage();  //gets image for processing; if no image, camera not ready, then axis camera exception
                BinaryImage thresholdImage = image.thresholdHSV(0, 255, 0, 255, 223, 255);    //testing these valus now...
                BinaryImage convexHullImage = thresholdImage.convexHull(false);          // fill in occluded rectangles
                BinaryImage filteredImage = convexHullImage.particleFilter(cc);           // filter out small particles
                newFilteredImage = convexHullImage.particleFilter(cc);


                //prints out the number of particles (red blobs) it sees after filtering
                //number of particles should be the number of targets in your viewing angle
                //if more or less blobs than than targets, check processing >> thresholdHSV/RGB
                int numBlobs = filteredImage.getNumberParticles();

                System.out.println("Number of Particles: " + numBlobs + "\n" + "\n");

                //finds information for each blob found
                for (int i = 0; i < numBlobs; i++) {
                    report = filteredImage.getParticleAnalysisReport(i);
  
                }
             
                System.out.println( getDistance(report.boundingRectHeight, 35.5));
                
                //Always free every image you make!!!!
                image.free();
                thresholdImage.free();
                convexHullImage.free();
                filteredImage.free();
                newFilteredImage.free();

            } catch (AxisCameraException ex) {
                ex.printStackTrace();
            } catch (NIVisionException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    //finds the distance from robot to pyramid
    public double getDistance( double pixelHeight, double degrees) {
       double targetHeightIn = 20.0;

       double distance = ((320.0 * (targetHeightIn / pixelHeight)) / 2.0) / Math.tan(degrees * (Math.PI / 180.0));
       return distance;
   }
    
}
