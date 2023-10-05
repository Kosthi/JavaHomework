import java.text.SimpleDateFormat;
import java.util.Date;

public class MyLogger {

    private final Date logTime_;
    private final String msg_;

    public MyLogger() {
        logTime_ = new Date();
        msg_ = "";
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

    @Override
    public String toString() {
        return "MyLogger [" +
                "LogTime=" + getLogTime() +
                ", msg=" + getMsg() +
                "]";
    }
}
