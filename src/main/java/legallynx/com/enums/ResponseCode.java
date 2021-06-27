package legallynx.com.enums;

import lombok.Data;
import org.springframework.http.HttpStatus;


public enum ResponseCode {
    DUPLICATE_RECORD(HttpStatus.CONFLICT,"E40901","Already exist"),
    DUPLICATE_DOCUMENT(HttpStatus.CONFLICT,"E40902","Document Already exist"),
    RECORD_NOT_FOUND(HttpStatus.NOT_FOUND,"E40903","Record Not found"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST,"E40904","Bad Request"),
    SUCCESS(HttpStatus.ACCEPTED,"E40905","Successful"),

    ;

    final HttpStatus status;
    final String code;
    final  String description;

    ResponseCode(HttpStatus status, String code, String description) {
        this.status = status;
        this.code = code;
        this.description = description;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
