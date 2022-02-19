# SOFKA_crud-0-back

Esto es una aplicación de ejemplo que provee una API REST de TODOs

La API es un proyecto creado en Java utilizando Springboot como framework + JPA + Hibernate

## Ejecutar la app

    mvnw.cmd spring-boot:run

# API REST

La API REST de la aplicación se explica a continuación


| METODO HTTP               | POST                  | GET                                   | PUT                                     | DELETE                        |
| ------------------------- | --------------------- | ------------------------------------- | --------------------------------------- | ----------------------------- |
| CRUD OP                   | CREATE                | READ                                  | UPDATE                                  | DELETE                        |
| /todos                    | Crear nuevo TODO      | Listar TODOs                          | Error                                   | Eliminar todos los TODOs      |
| /todos/1                  | Error                 | Mostrar TODO por su id                | Modificar TODO. Si no existe error      | Eliminar TODO por su id       |
| /todos?name=clean code    | Error                 | Buscar TODOs por su nombre            | Error                                   | Error                         |
| /todos?completed=true     | Error                 | Buscar TODOs por su estado            | Error                                   | Eliminar TODO por su estado   |
_______________________________________________________________________________________________________________________________________________________________________