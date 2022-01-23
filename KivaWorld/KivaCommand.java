
/**
 * KivaCommand describes the moves that a Kiva Robot can make.
 * Turning Left, turning Right, going forward, tanking the pod and dropping the pod.
 * It also contains one-letter abreviation for each move,
 *
 * 
 * @author (Gustavo Ordaz) 
 * @version (9/27/2021)
 */
public enum KivaCommand {
    /**
     * KivaCommand enum constants
     */
    /**
     * FORWARD, referenced also as 'F'
     */
    FORWARD('F'), 
    /**
     * TURN_LEFT, referenced also as 'L'
     */
    TURN_LEFT('L'), 
    /**
     * TURN_RIGHT, refeenced also as 'R'
     */
    TURN_RIGHT('R'), 
    /**
     * TAKE, referenced also as 'T'
     */
    TAKE('T'), 
    /**
     * DROP, referenced also as 'D'
     */
    DROP('D');
    
    private char directionKey;
    
    private KivaCommand(char directionKey)
    {
        this.directionKey = directionKey;
    }
    
    /**
     * METHODS
     */
    /**
     * Gives the one-letter abreviation of the command
     * @return one-letter abreviation of the command;
     */
    public char getDirectionKey()
    {
        return this.directionKey;
    }
}
