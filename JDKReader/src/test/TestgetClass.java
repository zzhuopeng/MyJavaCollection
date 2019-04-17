public class TestgetClass {
    public static void main(String[] args) {
        Animal cat = new Cat("小花猫", "female");
        Animal animal = new Animal("小动物");

        System.out.println(cat.equals(animal));//这里输出false，由于对象内存不同
        System.out.println(cat.getClass());//这里输出Cat，获取的是运行时Class对象(堆存储)
        System.out.println(animal.getClass());//这里输出Animal，获取的是运行时Class对象(堆存储)

        Animal animal1 = new Animal("大动物");
        Class clazzLittleAnimal = animal.getClass();
        Class clazzBigAnimal = animal1.getClass();
        //这里输出true，因为其对应的Class字节码文件都是Animal.class对象。
        System.out.println(clazzBigAnimal.equals(clazzLittleAnimal));
    }
}

/**
 * 动物类
 */
class Animal {

    private String name;

    public Animal() {

    }

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

/**
 * 猫，继承Animal类
 */
class Cat extends Animal {
    private String sex;

    public Cat(String sex) {
        this.sex = sex;
    }

    public Cat(String name, String sex) {
        super(name);
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
