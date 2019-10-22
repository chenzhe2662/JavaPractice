public class Test {
    public static void main(String[] args) {
        Ishape shape = new Cycle();
        shape.draw();
    }
}

interface Ishape {
    void draw();
}

abstract class shape {
    abstract public void draw();

    void func() {
        System.out.println("func");
    }
}

class Rect extends shape {
    @Override
    public void draw() {
        System.out.println("口");
    }
}

class Cycle extends shape implements Ishape {
    @Override
    public void draw() {
        System.out.println("⚪");
    }
}