
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Jessie
 */
public class Autonomous extends CommandGroup{

    public Autonomous() {
     
        //ask Lauren how this works so as to get it right the first time
        //MAKE SURE VISION ENDS
        //addSequential(new TestVision());
        
        
        addParallel(new PIDPitch(0.2, false, false));
        //addParallel(new PIDPitch(0.3, false, false));
        addSequential(new Shoot(1));
        addSequential(new Fire());
        addSequential(new Fire());
        addSequential(new Fire());
        addSequential(new PIDPitch(0.2, false, true));
        //addSequential(new PIDPitch(0.3, false, true));
        addSequential(new Shoot(0));
    }
}
