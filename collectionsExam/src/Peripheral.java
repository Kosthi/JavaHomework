import java.util.Date;
import java.util.Objects;

public class Peripheral {
    private String name;
    private String serial;
    private Date produceDate;

    public Peripheral(String name, String serial, Date produceDate) {
        this.name = name;
        this.serial = serial;
        this.produceDate = produceDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Date getProduceDate() {
        return produceDate;
    }

    public void setProduceDate(Date produceDate) {
        this.produceDate = produceDate;
    }

    @Override
    public int hashCode() {
        // 利用成员变量生成hash值
        return Objects.hash(name, serial, produceDate);
    }

    @Override
    public boolean equals(Object obj) {
        // 地址相同
        if (this == obj) {
            return true;
        }
        // 空指针或者类不同
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        // 成员变量值相同，类相同
        Peripheral other = (Peripheral) obj;
        return this.name.equals(other.name) && this.produceDate.equals(other.getProduceDate()) && this.serial.equals(other.serial);
    }

    @Override
    public String toString() {
        return "Peripheral{" +
                "name='" + name + '\'' +
                ", serial='" + serial + '\'' +
                ", produceDate=" + produceDate +
                '}';
    }
}
