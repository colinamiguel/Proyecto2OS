/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author luism
 */
public class Queue {
    int size;
    Node head;
    Node tail;
    
    public Queue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
        
    }
    
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    public int getSize() {
        return size;
    }
    
    public void insert(Car car) {
        Node n = new Node(car);
        if (this.isEmpty()) {
            this.head = n;
            this.tail = n;
        } else {
            this.tail.next = n;
            this.tail = n;
        }
        this.size++;
    }
    
    public Car get() {
        if (!this.isEmpty()){
            Car car = this.head.car;
            if (this.head == this.tail) {
                this.head = null;
                this.tail = null;            
            } else {
                this.head = this.head.next;
            }
            this.size--;
            return car;
        } else {
            return null;
        }
    }
    
    public String viewList(){
        Node aux;
        aux = this.head;
        String str = "";
        while(aux != null){
            str +=  aux.car.id + " Calidad: " + aux.car.getStrQuality() +",";
            aux = aux.next;   
        }
        return str;
    }
    
    
}
