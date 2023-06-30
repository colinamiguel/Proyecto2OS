
package proyecto2so;
import Classes.Processor;
import Interface.main;

/**
 *
 * @author luism
 */
public class Proyecto2SO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        main inter = new main();
        inter.setVisible(true);
        Processor processor = new Processor(inter);
        
    }
    
}
