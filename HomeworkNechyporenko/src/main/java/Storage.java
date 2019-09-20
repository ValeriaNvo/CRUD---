import java.util.Random;
import java.util.Scanner;

public class Storage {

    //Функция — это небольшая программа, которая выполняет определённые действия при вызове функции по имени.
    //В данном случае создаем функцию Add_NewCat, которая создает кота со случайным именем, возрастом и цветом
    static String Add_NewCat (){
        //Создаем массив с именами котов
        String [] catnames =  { "Vaska", "Petka", "Lizka", "Sharik", "Busiya", "Luna", "Borya" };
        //создаем массив с цветами для котов
        String [] catcolors = { "Red", "Black", "White" };
        Integer [] catage = {4, 7, 9};
        Random ran = new Random();

        //Генерируем случайные цифры
        int ran_name_num = ran.nextInt(catnames.length); //Цифра для случайного эелемента массива с именами
        int ran_color_num = ran.nextInt(catcolors.length); //Цифра для случаного элемента массива с цветами
        int ran_age = ran.nextInt(catage.length); //Цифра для случайного возраста кота

        Cat myCat = new Cat(); //Создаем экземпляр класа Cat
        //Заполняем экземляр класса Cat данными
        myCat.name = catnames[ran_name_num]; //Случайное имя из массива catnames
        myCat.age = catage[ran_age]; //Случайный возраст кота
        myCat.color = catcolors[ran_color_num]; //Случайный цвет из массива catcolors

        //Записываем полученного кота в переменную
        String cat = "Cat name:" + myCat.name + " | Age:" + myCat.age + " | Color:" + myCat.color;

        //Возвращаем созданного кота записанного в переменную cat
        return cat;
    }

    public static void main(String[] args) {
        Scanner user_input = new Scanner(System.in); //Создаем "слушателя" ввода пользователя
        System.out.println("Введите нужное число котов в комнате"); //Задаем ворос пользователю
        int number_of_cats = user_input.nextInt(); //Читаем ответ пользователя
        String [] CatStorage = new String[number_of_cats]; // Создаем массив который мы заполним котами

        //Заполнение (Создание котов) массива с котами с помощью функции Add_NewCat
        for (int i = 0; i < CatStorage.length; i++) {
            CatStorage [i] = Add_NewCat();
        }

        System.out.println("\nСписок доступных команд: " +
                "\n create - добавить еще одного кота " +
                "\n read - вывести список котов " +
                "\n update - обновить существющего кота из списка " +
                "\n delete - удалить кота из списка" +
                "\n exit - выход из программы"); //Задаем ворос пользователю


        while (true) {
            String user_command = user_input.nextLine();

            if (user_command.equals("create")) {
                System.out.println("\nСоздаю кота в комнате");
                String [] tempArray = new String[CatStorage.length + 1];

                for (int i = 0; i < CatStorage.length; i++) {
                    tempArray [i] = CatStorage [i];
                }

                CatStorage = new String[tempArray.length];

                for (int i = 0; i < CatStorage.length; i++) {
                    CatStorage [i] = tempArray [i];
                }
                CatStorage [CatStorage.length - 1] = Add_NewCat();

                System.out.println("Новый список котов в комнате:");
                for (int i = 0; i < CatStorage.length; i++) {
                    System.out.println(CatStorage [i]);
                }
            }

            if (user_command.equals("read")) {
                //Вывод всего массива с котами
                System.out.println("\nСписок всех котов в комнате:");
                for (int i = 0; i < CatStorage.length; i++) {
                    System.out.println(CatStorage [i]);
                }
            }
            if (user_command.equals("update")) {

                System.out.println("\n Обновление первого кота");
                CatStorage[0] = Add_NewCat();

                System.out.println("Новый список котов в комнате:");
                for (int i = 0; i < CatStorage.length; i++) {
                    System.out.println(CatStorage[i]);
                }
            }

            if (user_command.equals("delete")) {
                System.out.println("\nУдаление последнего кота из списка...");
                String [] tempArray = new String[CatStorage.length];

                for (int i = 0; i < CatStorage.length; i++) {
                    tempArray [i] = CatStorage [i];
                }
                if (CatStorage.length > 0) {
                    CatStorage = new String[CatStorage.length - 1];

                    for (int i = 0; i < CatStorage.length; i++) {
                        CatStorage [i] = tempArray [i];
                    }

                    System.out.println("Новый список котов в комнате:");
                    for (int i = 0; i < CatStorage.length; i++) {
                        System.out.println(CatStorage [i]);
                    }
                } else {
                    System.out.println("Ошибка: массив меньше 0");
                }
            }

             if (user_command.equals("exit")) {
                break;
            }
        }

    }
}
