package fi.gosu.ika.ennatys.exception;

/**
 * Created by Aikain on 2.3.2017.
 */
public class GeneralException extends Throwable {

    private String msg;

    public GeneralException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
