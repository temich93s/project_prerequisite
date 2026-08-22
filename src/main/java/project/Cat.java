package project;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Cat {
    private String message;

    String getMessage() {
        return message;
    }

    void setMessage(String message) {
       this.message = message;
    }
}
