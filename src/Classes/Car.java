/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;
import java.util.Random;
/**
 *
 * @author luism
 */
public class Car {
    int id;
    boolean chasis;
    boolean bodyWork;
    boolean engine;
    boolean wheel;
    int quality;
    private final Random rand = new Random();
    
    public Car (int id) {
      this.id = id;
      this.chasis = this.rand.nextFloat() <= 0.70;
      this.bodyWork = this.rand.nextFloat() <= 0.60;
      this.engine = this.rand.nextFloat() <= 0.50;
      this.wheel = this.rand.nextFloat() <=0.40;
      boolean[] parts = {this.bodyWork, this.chasis, this.engine, this.wheel}; 
      this.quality = this.getPriorityLevel(parts);
    }
    
    private int getPriorityLevel(boolean[] parts) {
        int trueCount = 0;
        
        for (int i = 0; i < parts.length; i++) {
            if (trueCount >= 3) break;
            if (parts[i]) trueCount += 1;
        }
        
        return trueCount;
    }

    public int getId() {
        return id;
    }

    public String getStrQuality() {
        switch (this.quality) {
            case 3:
                return "Alta";
            case 2:
                return "Media";
            default:
                return "Baja";
        }       
    }
    
    public int getQuality() {
        return this.quality;
    }
    
}
