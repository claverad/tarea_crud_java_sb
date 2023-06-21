package scalab.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import scalab.exceptions.DetalleError;
import scalab.exceptions.ResponseHandler;
import scalab.exceptions.UsuarioExceptionHandler;
import scalab.model.dto.UsuarioRequest;
import scalab.model.entity.Usuario;
import scalab.service.impl.UsuarioServiceImpl;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    UsuarioServiceImpl usuarioService;

    public UsuarioController(UsuarioServiceImpl usuarioService){
        this.usuarioService = usuarioService;
    }


    //GET localhost:8080/usuarios/
    @GetMapping("/")
    @Operation(summary = "Retorna los usuarios creados")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(schema = @Schema(implementation = Usuario.class), mediaType = "application/json")
            }),
            @ApiResponse(responseCode = "204", description = "NO CONTENT", content = {
                    @Content(schema = @Schema(implementation = Usuario.class), mediaType = "application/json")
            }),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = {
                    @Content(schema = @Schema())
            })
    })
    public ResponseEntity<Object> getUsuarios(){
        List<UsuarioRequest> usuarios = usuarioService.getUsuarios();

        if(usuarios.size() > 0){
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        }
        return ResponseHandler.generateResponse("sin usuarios",HttpStatus.NO_CONTENT);


    }

    //post localhost:8080/usuarios/
    @PostMapping("/")
    @Operation(summary = "Crea usuarios")
    public ResponseEntity<?> insertarUsuario (@Valid @RequestBody UsuarioRequest cursoRequest){

        UsuarioRequest usuario = usuarioService.insertarUsuario(cursoRequest);
        if( usuario == null ) {
            return  ResponseHandler.generateResponse("Correo ya registrado, favor cambiar.",HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtiene usuario por id")
    public ResponseEntity getUsuario(@PathVariable("id") String id){
        UsuarioRequest usuario = usuarioService.getUsuarios(id);

        if(usuario == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(usuario, HttpStatus.OK);

    }

    @GetMapping(path="/", params = {"correo"})
    @Operation(summary = "Obtiene usuario por correo")
    public ResponseEntity<UsuarioRequest> getUsuarioByCorreo(@RequestParam String correo){
        UsuarioRequest usuario = usuarioService.getUsuarioByCorreo(correo);
        if(usuario == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(usuario, HttpStatus.OK);

    }
    @PutMapping("/")
    @Operation(summary = "Actualiza usuarios pasando usuarios_id, telefonos_id")
    public ResponseEntity<Usuario> actualizarUsuario( @RequestBody Usuario usuario){

        Usuario usuarioResponse = usuarioService.actualizarUsuario(usuario);

        return new ResponseEntity<>(usuarioResponse, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina usuarios por id")
    public ResponseEntity<?> eliminarCurso(@PathVariable("id") String id){

        boolean usuario = usuarioService.eliminarUsuario(id);
        System.out.println("usuario: "+usuario);
        if(!usuario){return new ResponseEntity<>(HttpStatus.NOT_FOUND);}

        return ResponseHandler.generateResponse("usuario eliminado",HttpStatus.OK);
    }

}
