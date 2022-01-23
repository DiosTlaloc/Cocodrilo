import edu.duke.FileResource;

/**
 * This is the class that controls Kiva's actions. Implement the <code>run()</code>
 * method to deliver the pod and avoid the obstacles.
 *
 * This is starter code that may or may not work. You will need to update the code to
 * complete the project.
 */
public class RemoteControl {
    KeyboardResource keyboardResource;

    /**
     * Build a new RemoteControl.
     */
    public RemoteControl() {
        keyboardResource = new KeyboardResource();
    }

    /**
     * The controller that directs Kiva's activity. Prompts the user for the floor map
     * to load, displays the map, and asks the user for the commands for Kiva to execute.
     *
     * [Here's the method you'll execute from within BlueJ. It may or may not run successfully
     * as-is, but you'll definitely need to add more to complete the project.]
     */
    public void run() {
        System.out.println("Please select a map file.");
        //FileResource fileResource = null;
        //fileResource = new FileResource("sample_floor_map1.txt");
        FileResource fileResource = new FileResource();
        String inputMap = fileResource.asString();
        FloorMap floorMap = new FloorMap(inputMap);
        System.out.println(floorMap);
        
        Kiva kiva = new Kiva(floorMap);
        System.out.println();
        System.out.println(String.format("Current Kiva Robot location: %s", kiva.getCurrentLocation()));
        System.out.println(String.format("Facing: %s", kiva.getDirectionFacing()));

        System.out.println("Please enter the directions for the Kiva Robot to take.");
        String directions = keyboardResource.getLine();
        System.out.println();
        
        KivaCommand[] commands = convertToKivaCommand(directions);
        
        try {
            for (int i=0; i<commands.length; i++)
            {
                kiva.move(commands[i]);
            }
            if (kiva.isSuccessfullyDropped() && (commands[commands.length-1] == KivaCommand.DROP)) {
                System.out.println("Successfully picked up the pod and dropped it off. Thank you!");
            } else {
                System.out.println("I'm Sorry. The Kiva Robot did not pick up the pod then dropped it off in the right place.");
            }
        }
        catch (NoPodException ne) {
            System.out.println(ne.toString());
        }
        catch (IllegalDropZoneException de) {
            System.out.println(de.toString());
        }
        catch (IllegalMoveException me) {
            System.out.println(me.toString());
        }
        
        //System.out.println("Directions that you typed in: " + directions);
    }
    
    /**
     * Converts a string of comads given by the user into KivaCommands
     * @param String, the input from the user as a chain of KivaComand one-letter abreviation
     * @return KivaCommand[], an array of KivaCommand.
     */
    public KivaCommand[] convertToKivaCommand(String commands)
    {
        KivaCommand[] comandos = new KivaCommand[commands.length()];
        
        for (int i=0; i<commands.length(); i++) {
            boolean legalArgument = commands.charAt(i) == 'F';
            legalArgument = legalArgument || commands.charAt(i) == 'L';
            legalArgument = legalArgument || commands.charAt(i) == 'R';
            legalArgument = legalArgument || commands.charAt(i) == 'T';
            legalArgument = legalArgument || commands.charAt(i) == 'D';
            
            for(KivaCommand cmd : KivaCommand.values()) {
                if(legalArgument) {
                    if (commands.charAt(i) == cmd.getDirectionKey()) {
                        comandos[i] = cmd;
                        break;
                    }
                } else {
                    throw new IllegalArgumentException(String.format("Character '%c' does not correspond to a command!", commands.charAt(i)));
                }
            }
        }
        
        return comandos;
    }
    
}
