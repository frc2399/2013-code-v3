
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
        addSequential(new Shoot(1));
        addSequential(new Fire());
        addSequential(new Shoot(0));
    }
}
