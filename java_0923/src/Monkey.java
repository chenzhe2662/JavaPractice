public class Monkey {
    private String name;
    private String feature;
    public Monkey(){
        name = "长尾猴";
        feature = "尾巴长";
        System.out.println("我是使用无参构造产生的猴子：");
        System.out.println("名称："+name);
        System.out.println("特征："+feature);
    }

    public Monkey(String name, String feature) {
        this.name = name;
        this.feature = feature;
        System.out.println("我是使用带参构造产生的猴子：");
        System.out.println("名称："+this.name);
        System.out.println("特征："+this.feature);
    }
}
