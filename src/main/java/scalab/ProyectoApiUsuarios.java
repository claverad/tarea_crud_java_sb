package scalab;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Proyecto CRUD API Escalab", version = "1.0", description = "API-CRUD de usuarios con telefono"))
public class ProyectoApiUsuarios {
    public static void main(String[] args) {
        SpringApplication.run(ProyectoApiUsuarios.class, args);
    }
}
