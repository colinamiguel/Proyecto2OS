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
public class Admin {
    
    String company;
    Queue priority1 = new Queue();
    Queue priority2 = new Queue();
    Queue priority3 = new Queue();
    Queue reinforcement = new Queue();
    Queue race = new Queue();
    private int id = 1;
    Random rand = new Random();
    int counter = 0;
    int rounds = 0;
    int tiempo;
    int cars = 0;
    int wins = 0;
    public Admin(String company) {
        this.company = company;
    }
    
    public void createCars(int number) {
        for (int i = 0; i <= number; i++) {
            this.cars++;
            Car newCar = new Car(this.cars);
            this.assignQueue(newCar);
        }
        
    }

    public String getCompany() {
        return company;
    }
    
    private void assignQueue(Car car) {
        if (car.getQuality() == 3) {
            this.priority1.insert(car);
        }
        if (car.getQuality() == 2) {
            this.priority2.insert(car);
        }
        
        if (car.getQuality() == 1 || car.getQuality() == 0) {
            this.priority3.insert(car);
        }
        this.reinforcement.insert(car);
        
    }
    
    public void revisionCycles() {
        this.counter++;
        if (this.counter == 2) {
            if (rand.nextFloat() <= 0.70 ) {
                this.createCars(1);
            }
            this.counter = 0;
        }
    }
    
  public void aftermath() {
      this.rounds++;
      this.revisionCycles();
      if (this.rounds >= 8) {
          this.updateQueues();
          this.rounds = 0;
      }
      this.takeOutReinforcements();
      
      
  }
  public void updateQueues() {
      for (int i = 0; i < this.priority2.size; i++) {
          Car car = this.priority2.get();
          this.priority1.insert(car);
      }
      
      for (int i = 0; i < this.priority3.size; i++) {
          Car car = this.priority3.get();
          this.priority2.insert(car);
      } 
          
  }
  public void takeOutReinforcements() {
      if (this.rand.nextFloat() < 0.4) {
          Car car = this.reinforcement.get();
          this.priority1.insert(car);
      }
  }
  
  public Car getNextCar() {
      if (this.priority1.getSize() > 0) {
          return this.priority1.get();
      } else if (this.priority2.getSize() > 0) {
          return this.priority2.get();
      } else {
          return this.priority3.get();
      }
          
  }
    
}
