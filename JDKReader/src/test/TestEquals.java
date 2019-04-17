import java.util.Objects;

/**
 * Object类
 * 测试equals()方法：判断equals的准则
 * 　　①、自反性：对于任何非空引用值 x，x.equals(x) 都应返回 true。
 * 　　②、对称性：对于任何非空引用值 x 和 y，当且仅当 y.equals(x) 返回 true 时，x.equals(y) 才应返回 true。
 * 　　③、传递性：对于任何非空引用值 x、y 和 z，如果 x.equals(y) 返回 true，并且 y.equals(z) 返回 true，那么 x.equals(z) 应返回 true。
 * 　　④、一致性：对于任何非空引用值 x 和 y，多次调用 x.equals(y) 始终返回 true 或始终返回 false，前提是对象上 equals 比较中所用的信息没有被修改
 * 　　⑤、对于任何非空引用值 x，x.equals(null) 都应返回 false。
 */
public class TestEquals {
    public static void main(String[] args) {
        checkEquals();
    }

    /**
     * 检查object是否满足equals准则
     *
     * @return
     */
    public static void checkEquals() {
        Person A = new Person(15, "小明");
        Person B = new Person(15, "小明");
        Person C = new Person(15, "小明");
        //1.自反性
        if (A.equals(A))
            System.out.println("满足自反性");
        else
            System.out.println("不满足自反性");
        //2.对称性
        if (A.equals(B) && B.equals(A))
            System.out.println("满足对称性");
        else
            System.out.println("不满足对称性");
        //3.传递性
        if (A.equals(B) && B.equals(C) && A.equals(C))
            System.out.println("满足传递性");
        else
            System.out.println("不满足传递性");
        //4.一致性
        if (A.equals(B)) {
            for (int i = 0; i < 500; i++)
                if (!A.equals(B)){
                    System.out.println("不满足一致性");
                    break;
                }
            System.out.println("满足一致性");
        }
        //5. x.equals(null) 都应返回 false
        if (!A.equals(null))
            System.out.println("满足条件");
        else
            System.out.println("不满足条件");
    }
}

class Person {
    private int age;
    private String name;

    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }
}
