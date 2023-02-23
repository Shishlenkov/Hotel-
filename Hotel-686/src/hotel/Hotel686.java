package hotel;

import java.util.Random;
import java.util.Scanner;

public class Hotel686 {

    static String help = "Клавиша: \n1- показывает оставшиеся свободные комнаты в нашем отели\n" +
            "2- Позволяет забронировать свободный номер, для бронирования нажмите клавишу 2, затем введите номер комнаты";

    public static void main(String[] args) {
        System.out.println("        Добро пожаловать в Наш Отель 686");
        System.out.println("Для бронирования выбирете команду:\n 1- Свободные номера\n 2- Бронирование\n " +
                "3- Забронированные номера\n 4- help\n 5- EXIT");
//       Создали массив комнат в нашем отели
        Room[] rooms = {
                new Room(11, 2, true, false, true),
                new Room(12, 3, true, false, true),
                new Room(13, 1, false, false, true),
                new Room(21, 3, true, false, true),
                new Room(22, 2, true, false, true),
                new Room(23, 3, true, true, true),
                new Room(31, 2, true, true, true),
                new Room(32, 2, true, true, false),
                new Room(33, 4, true, true, true),
        };
        Scanner scn = new Scanner(System.in);
        String comander;
//        Создали цикл While- бесконечный
        while (true) {
            System.out.println("Введите команду:");
            comander = scn.nextLine();

            if (comander.equals("1")) {
// #Свободные номера. вызываем при помощи метода printFreeRooms(rooms);- чтобы был меньше код
                System.out.println("Свободные комнаты в нашем отели ");
                printFreeRooms(rooms);

            } else if (comander.equals("2"))
// #Бронирование.  вызываем метод reservedRoom(rooms)-- чтобы был меньше код
                reservedRoom(rooms);

//Уже забронированно
            else if (comander.equals("3")) {
                System.out.println("На сегодня забронированые комнаты:");
                for (Room room : rooms) {
                    if (room.isReserved()) {
                        System.out.println(room.getNumber());
                    }
                }

//Вызываем ПОМОЩЬ!
            } else if (comander.equals("4"))
                System.out.println(help);

//Для выхода из цикла можно использовать return или break
            else if (comander.equals("5")) {
                System.out.println("EXIT");
                return;

            } else {
                System.err.println("ВНИМАНИЕ! Неверная команда, нажмите клавишу 4- help");
            }
        }
    }

    //Создали статичный метод для вызова (поиска) СВОБОДНЫХ КОМНАТ
    static void printFreeRooms(Room[] rooms) {
        //через цикл(foreach) выводим все комнаты  которые свободные у нас!
        for (Room room : rooms) {
            if (!room.isReserved()) {
                System.out.println(room.getNumber());
            }
        }
    }

    //Создали статичный метод для (БРОНИРОВАНИЯ)
    static void reservedRoom(Room[] rooms) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите номер комнаты:");

        int num = scn.nextInt();

        for (Room room : rooms) {
// Сперва проверяем введенная комната есть ли в нашем массиве, и тутже проверяем ее стату.
            if (num == room.getNumber() && room.isReserved()) {
                System.err.println("Данная комната уже забронированна");
                return;//выходим из цикла проверки есть ли комната
            }
            if (num == room.getNumber()) {
                room.setReserved(true);//переписываем номер комнаты в статус забронированно!
                System.out.println("Комната: № " + num + " Вами успешно ЗАБРОНИРОВАННА");
            }
        }
    }
}


