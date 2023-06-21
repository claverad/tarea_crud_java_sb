package scalab.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;
public class ResponseHandler {

    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("mensaje", message);
        map.put("estado", status.value());

        return new ResponseEntity<Object>(map,status);
    }
}
