# CRUD API Escalab

Pasos previos a realizar:

  1.- Crear BBDD cursos con las siguiente tablas; usuarios, telefonos.

      CREATE TABLE usuarios (
      usuario_id INT NOT NULL AUTO_INCREMENT,
      nombre VARCHAR(50) NOT NULL,
      correo VARCHAR(50) NOT NULL,
      pass VARCHAR(10) NOT NULL,
      telefono_id INT NOT NULL,
      PRIMARY KEY (usuario_id),
      CONSTRAINT fk_usuarios_telefonos FOREIGN KEY(telefono_id) 
      REFERENCES telefonos(telefono_id),
      CONSTRAINT correo_usuario_unique UNIQUE (correo)
    );
    
    CREATE TABLE telefonos (
      telefono_id INT NOT NULL AUTO_INCREMENT,
      numero VARCHAR(10),
      codCiudad VARCHAR(6),
      codPais VARCHAR(4),
      PRIMARY KEY (telefono_id),
      CONSTRAINT numero_telefono_unique UNIQUE (numero)
    );
    
  2.- Luego de crear la bbdd,levantar el proyecto ejecutando el archivo principal.
  
  3.- Se adjunta collection con métodos postman permitidos por la api.
