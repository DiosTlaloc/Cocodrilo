
/**
 * Write a description of KivaMotorLifetimeTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class KivaMotorLifetimeTester {
    
    // Define the FloorMap we'll use for all the tests
    String defaultLayout = ""
                            + "-----\n"
                            + "|K D|\n"
                            + "| P |\n"
                            + "|* *|\n"
                            + "-----\n";
    FloorMap defaultMap = new FloorMap(defaultLayout);
    
    public void testMotorLifetime()
    {
        
        Kiva kiva = new Kiva(defaultMap);
        
        System.out.println(kiva.getMotorLifetime());
        
        kiva.move(KivaCommand.TURN_RIGHT);
        System.out.println(kiva.getMotorLifetime());
        
        kiva.move(KivaCommand.FORWARD);
        System.out.println(kiva.getMotorLifetime());
        
        kiva.move(KivaCommand.TURN_RIGHT);
        System.out.println(kiva.getMotorLifetime());
        
        kiva.move(KivaCommand.FORWARD);
        System.out.println(kiva.getMotorLifetime());
        
        kiva.move(KivaCommand.TAKE);
        System.out.println(kiva.getMotorLifetime());
        
    }

}
