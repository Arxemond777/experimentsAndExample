package ch5_object_in_java;

public class Shape {


    public void draw() {
        //ничего не делаем
    }
}

class Square extends Shape {
    public void draw() {
        System.out.println("Квадрат");
    }
}

class Сircle extends Shape {
    public void draw() {
        System.out.println("Круг");
    }
}

class Triangle extends Shape {
    public void draw() {
        System.out.println("Треугольник");
    }
}

