# lab3ArqSoft
Al hacer uso de JavaServer Faces para desarrollar esta aplicación se adopta una arquitectura MVC.
La capa de Presentación ​(formularios XHTML manipulados por Java, AJAX y PrimeFaces) de la
aplicación, a la cual los clientes accederán a través de sus navegadores​, tenemos también una
capa de control que será la encargada manejar, por medio de Managed Beans o Backing Beans, las
peticiones que haga el usuario a través de la capa web, aplicar las reglas propias de la aplicación
(haciendo uso de EJBs de JSF) y representar los objetos del dominio; por último está la capa de
datos que será la encargada de interactuar con el servidor de base de datos ​(a través del uso de
JPA).

#Configuracion Base de datos Sakila
Para el funcionamiento de la aplicacion se debe tener en cuenta los siguientes aspectos:
-> Usamos las tablas "Film" y "Languege". 
-> La tabla film tiene una clave foranea hacia lenguaje.
->El campo "release_year"(Año realizacion) de la tabla "Film" es de tipo "YEAR" en la base de datos.

Teniendo esto en cuanta para que nuestro CRUD funcione perfectamente se debe apreciar que el borrado en cascada, al manejar claves foraneas, es completamente necesario.Tambien hay un error de compatibilidad entre el tipo "DATE"  y "YEAR" el cual solucionamos cambiando el tipo de valor "YEAR" por un "VARCHAR", esto con el fin de que funcione el aplicativo. 
->Ejecute los siguientes comandos antes de iniciar la aplicacion:

ALTER TABLE film  MODIFY release_year varchar(20);

ALTER TABLE film_actor
ADD CONSTRAINT fk_film_actor_film2
FOREIGN KEY (film_id)
REFERENCES film (film_id)
ON DELETE CASCADE;

ALTER TABLE film_category
ADD CONSTRAINT fk_film_category_film2
FOREIGN KEY (film_id)
REFERENCES film (film_id)
ON DELETE CASCADE;

ALTER TABLE inventory
ADD CONSTRAINT fk_inventory_film2
FOREIGN KEY (film_id)
REFERENCES film (film_id)
ON DELETE CASCADE;

ALTER TABLE rental
ADD CONSTRAINT fk_rental_inventory2
FOREIGN KEY (inventory_id)
REFERENCES inventory (inventory_id)
ON DELETE CASCADE;

