package legallynx.com.exceptions;


import legallynx.com.enums.ResponseCode;
import lombok.Value;
import org.springframework.http.HttpStatus;

@Value
public class ServerExceptions extends  RuntimeException{
    private final HttpStatus status;
    private final String code;

    public ServerExceptions(ResponseCode code){
        super(code.getDescription());
        this.code = code.getCode();
        this.status = code.getStatus();
    }

    public ServerExceptions(Throwable s, ResponseCode code){
        super(code.getDescription());
        this.code = code.getCode();
        this.status = code.getStatus();
    }

    public ServerExceptions(Throwable e,ResponseCode code, String description){
        super(description, e);
        this.code = code.getCode();
        this.status = code.getStatus();
    }

}
