import java.text.SimpleDateFormat;
import java.util.Date;

public class MyLogger implements Cloneable {

    private Date logTime_;
    private String msg_;

    public MyLogger() {
        logTime_ = new Date();
        msg_ = "Default message.";
    }

    public MyLogger(Date logTime, String msg) {
        logTime_ = logTime;
        msg_ = msg;
    }

    public String getLogTime() {
        SimpleDateFormat formatTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatTime.format(logTime_);
    }

    public String getMsg() {
        return msg_;
    }

    public Date setLogTime(Date logTime) {
        return logTime_ = logTime;
    }

    public void setMsg(String msg_) {
        this.msg_ = msg_;
    }

    @Override
    public String toString() {
        return "MyLogger [" +
                "LogTime=" + getLogTime() +
                ", msg=" + getMsg() +
                "]";
    }

    @Override
    public MyLogger clone() {
        try {
            // 深拷贝 TODO: copy mutable state here, so the clone can't change the internals of the original
//            MyLogger clone = (MyLogger) super.clone();
//            clone.msg_ = new String(msg_);
//            return clone;
            // 浅拷贝
            return (MyLogger) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
