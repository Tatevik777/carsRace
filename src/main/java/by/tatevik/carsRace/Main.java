package by.tatevik.carsRace;

public class Main {
    public static void main(String[] args) {
        int distance = 20; // Заданное расстояние для гонки
        //Создаем два объекта Car с именами "Машина 1" и "Машина 2", передавая заданное расстояние.
        Car car1 = new Car("Машина 1", distance);
        Car car2 = new Car("Машина 2", distance);
        //Запускаем оба потока, что приводит к вызову метода run() в каждом из них.
        car1.start();
        car2.start();
        //Используем join(), чтобы основной поток дождался завершения
        // обоих потоков машин перед выполнением следующего кода. Если поток
        // будет прерван, обрабатываем исключение.
        try {
            car1.join();
            car2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Гонка завершена!");
    }
}
