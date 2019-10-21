package Package2;

 public class Bird extends Animal {
     public Bird(String name) {
         super(name);
     }
     //    public String name;
//
//    public Bird(String name) {
//        this.name = name;
//    }
    public void eat(String food){
        System.out.println("我是一只小鸟");
        System.out.println(this.name+"eat"+food);
    }
//    public void Fly(){
//        System.out.println("我是一只小鸟");
//        System.out.println(this.name+"正在飞！");
//    }
}
