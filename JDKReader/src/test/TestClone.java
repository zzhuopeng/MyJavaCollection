/**
 * Object类
 * 测试clone()方法：浅拷贝，深拷贝
 */
public class TestClone {
    public static void main(String[] args) {
        try {
            //浅拷贝示例
            People XiaoMing = new People();
            XiaoMing.setName("小明");
            People CloneXiaoMing = (People) XiaoMing.clone();
            CloneXiaoMing.setName("Clone小明");
            System.out.println(XiaoMing + "|---------|" + CloneXiaoMing);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        try {
            //深拷贝拷贝示例
            Human XiaoMing = new Human();
            XiaoMing.setName("小明");
            XiaoMing.setPeople(new People("小明"));
            Human CloneXiaoMing = (Human) XiaoMing.clone();
            CloneXiaoMing.setName("Clone小明");
            CloneXiaoMing.setPeople(new People("Clone小明"));
            System.out.println(XiaoMing + "|---------|" + CloneXiaoMing);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 浅拷贝示例(Clone方法中只实现了super.clone())
 */
class People implements Cloneable {

    private String name;

    public People(String name) {
        this.name = name;
    }

    public People() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();//这里相当于只复制了name等值类型数据(浅拷贝)
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                '}';
    }
}

/**
 * 深拷贝示例(Clone方法中除了super.clone()，还有human.people=(People)people.clone())
 */
class Human implements Cloneable {

    private String name;//值类型
    private People people;//引用类型

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Human human = (Human) super.clone();//这里相当于只复制了name等值类型数据
        human.people = (People) people.clone();//还需要复制people引用类型数据（深拷贝）
        return human;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", people=" + people +
                '}';
    }
}