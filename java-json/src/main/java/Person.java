import java.io.Serializable;

/**
 * Description:实体
 * Created  2015/11/5 15:55  by xinghaifang
 */
public class Person  implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private String address;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

}
