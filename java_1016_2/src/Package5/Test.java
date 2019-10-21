package Package5;

class Shape{
    public void draw(){

    }
}
class Cycle extends Shape{
    @Override
    public void draw(){
        System.out.println("⚪");
    }
}
class Rect extends Shape{
    @Override
    public void draw() {
        System.out.println("口");
    }
}
class Flower extends Shape{
    @Override
    public void draw() {
        System.out.println("♣");
    }
}
public class Test {
    public static void main(String[] args) {
        drawShape();
    }
//        Shape shape1 = new Flower();
//        Shape shape2 = new Rect();
//        Shape shape3 = new Cycle();
//        drawShape(shape1);
//        drawShape(shape2);
//        drawShape(shape3);
//    }
//    public static void drawShape(Shape shape){
//        shape.draw();
//    }
        public static void drawShape() {
            Shape[] shapes = {new Cycle(),new Rect(),new Flower()};
            for(Shape shape:shapes){
                shape.draw();
            }
        }
    }

