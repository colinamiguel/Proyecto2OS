/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.Random;
import Interface.main;


/**
 *
 * @author luism
 */
public final class Processor {
    private final Random rand = new Random();
    Admin[] admins = new Admin[2];
    Car[] cars = new Car[2];
    String winners = "";
    main interfase;
    int speed = 10;
    
    public Processor (main interfase) {
       this.interfase = interfase;
       this.admins[0] = new Admin("Bugatti");
       this.admins[1] = new Admin("lamborghini");
       
       this.admins[0].createCars(10);
       this.admins[1].createCars(10);
       this.printQueues();
       this.assignRacers();
       this.printQueues();
       this.Race();
                
        
        
    }
    
    public void assignRacers () {
        for (int i = 0; i < 2; i++) {
            this.cars[i] = this.admins[i].getNextCar();
            if (i == 0) {
                this.interfase.setRacer1(this.admins[i].company + ' ' + this.cars[i].id);
            } else {
                this.interfase.setRacer2(this.admins[i].company + ' ' +this.cars[i].id);
            }
        }
        
    }
    
    public void printQueues() {
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                String queue = this.admins[i].priority1.viewList();
                this.interfase.setQueue11(queue);
                queue = this.admins[i].priority2.viewList();
                this.interfase.setQueue21(queue);
                queue = this.admins[i].priority2.viewList();
                this.interfase.setQueue21(queue);
                queue = this.admins[i].priority3.viewList();
                this.interfase.setQueue31(queue);
                queue = this.admins[i].reinforcement.viewList();
                this.interfase.setQueuer1(queue);
            } else {
                String queue = this.admins[i].priority1.viewList();
                this.interfase.setQueue12(queue);
                queue = this.admins[i].priority2.viewList();
                this.interfase.setQueue22(queue);
                queue = this.admins[i].priority2.viewList();
                this.interfase.setQueue22(queue);
                queue = this.admins[i].priority3.viewList();
                this.interfase.setQueue32(queue);
                queue = this.admins[i].reinforcement.viewList();
                this.interfase.setQueuer2(queue);
            }
        }
    }
    
    public void Race () {
        // Add Interface here
        try {
            Thread.sleep(this.speed * 1000);
            float number = rand.nextFloat();
            if (number < 0.4) {
                this.setWinner();
            } else if (number >= 0.4 && number < 0.67) {
                this.setTie();
            } else {
                this.raceCanceled();
            }
            this.aftermath();
        } catch (InterruptedException e) {
            
            
        }
    }
    
    public void setWinner() {
        if (this.cars[0].quality > this.cars[1].quality) {
            this.winners += this.admins[0].getCompany() + " " + this.cars[0].id + " Calidad: " + this.cars[0].getStrQuality() + ",";
            this.admins[0].wins++;
            this.interfase.setBWins(this.admins[0].wins);
            
        } else {
            this.winners += this.admins[1].getCompany() + " " + this.cars[1].id + " Calidad: " + this.cars[1].getStrQuality() + ",";
            this.admins[1].wins++;
            this.interfase.setLWins(this.admins[1].wins);
        }
        this.interfase.setResult("Ganador");
        this.interfase.setWinner(this.winners);
    }
    
    public void setTie() {
        for (int i = 0; i < 2; i++) {
            this.admins[i].priority1.insert(this.cars[i]);
        }
        this.interfase.setResult("Empate");
    }
    
    public void raceCanceled() {
        for (int i = 0; i < 2; i++) {
            this.admins[i].reinforcement.insert(this.cars[i]);
        }
        this.interfase.setResult("No se corre");
    }
    
    public void aftermath() {
        for (int i = 0; i < 2; i++) {
            this.admins[i].aftermath();
        }
        int newSpeed = this.interfase.getSpeed();
        if (newSpeed > 0) this.speed = newSpeed;
        this.printQueues();
        this.assignRacers();
        this.printQueues();
        this.Race();
    }
    
}
