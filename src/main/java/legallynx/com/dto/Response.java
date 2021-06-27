package legallynx.com.dto;

import lombok.Value;

@Value
public class Response<T> {
    String code;
    String description;
    T data;


    public Response(String code, String description, T data) {
        this.code = code;
        this.description = description;
        this.data = data;
    }
}
