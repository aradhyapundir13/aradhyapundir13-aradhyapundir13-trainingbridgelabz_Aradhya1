package Day16Progs.factory;

public class Main {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape shape1 = shapeFactory.createShape("CIRCLE");
        if(shape1 != null) {
            shape1.draw();
        } else {
            System.out.println("Invalid shape type");
        }
        Shape shape2 = shapeFactory.createShape("SQUARE");
        if(shape2 != null) {
            shape2.draw();
        } else {
            System.out.println("Invalid shape type");
        }
        Shape shape3 = shapeFactory.createShape("TRIANGLE");
        if(shape3 != null) {
            shape3.draw();
        } else {
            System.out.println("Invalid shape type");
        }
    }
}