package by.tatevik.carsRace;

import java.util.Random;

public class Car extends Thread{
    private String carName;//имя машины
    private int distanceToCover;//общее растояние, которое машине надо проехать
    private int currentDistance = 0;//текущее расстояние, котрое машина проехала
    //конструктор инициализирует имя машины и расстояние, которое надо проехать
    public Car(String carName, int distanceToCover) {
        this.carName = carName;
        this.distanceToCover = distanceToCover;
    }
    //логика гонки
    @Override
    public void run() {
        Random random = new Random();// Создаем объект random для генерации случайных чисел у каждой машины.
        //Цикл while будет выполняться до тех пор, пока текущая дистанция меньше нужной.
        while (currentDistance < distanceToCover) {
            int speed = random.nextInt(5) + 1; // Случайная скорость от 1 до 5 м/с
           //  Увеличиваем currentDistance на значение speed, тем самым обновляя пройденное расстояние.
            currentDistance += speed;
            System.out.println(carName + " проехал " + currentDistance + " метров.");
            try {
                Thread.sleep(1000); // Задержка на 1 секунду
            } catch (InterruptedException e) {
                System.out.println(carName + " был прерван.");
            }
        }
        System.out.println(carName + " финишировал!");
    }
}
