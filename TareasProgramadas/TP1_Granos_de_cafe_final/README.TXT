@univer Universidad de Costa Rica
@escuela Escuela de Ciencias de la Computación e Informática
@sigla ECCI
@nombre Fabián Orozco Chaves
@email fabian7orozco@gmail.com
@nombre Zurisadai Granados Montoya
@email zurigamer1234@gmail.com
@grupo 01
@semestre I-2020
@fecha 14/5/20

Título del proyecto: TP1-Mezclas de Granos de Café.
Propósito y acerca de este proyecto: Este proyecto es la primer tarea programa del curso Programación I, impartido por el profesor Javier Vásquez Morera.
    El propósito de este programa es simular la producción de mezclas de granos de café, anteriormente definidas con los granos de café que el usuario eligió guardar en una canasta.
    
    En síntesis, se simula una especie de almacen de sacos de café. La cantidad de sacos de café es proporcionada por el usuario, de todos ellos el usuario primeramente elige
    un saco y según ciertos filtros, los granos que desea de este.
    Los granos que cumplan esos fltros son movidos a una "canasta" y es apartir de esta canasta que se preparan recetas o mezclas definidas por el usuario, siempre y cuando se cumpla 
    con los requisitos de la receta; se usan los granos de la canasta para verterlos en la "mezcladora de granos de café" que "los muele" y prepara las mezclas que una vez listas se guardan
    en las estanterías, o sea, el stock de café que tiene este usuario.
    
Limitaciones del proyecto y problemas no resueltos:
- No se puede escoger más de un saco a la vez, aunque esto fue una decisión ya que el enunciado para realizar este trabajo no lo explicaba del todo..
- Solo se crea una mezcla a la vez, se debe volver a llamar esa opción en el menú cada vez que se quiera ejecutar la producción de la mezcla.    
- No hay problemas sin resolver.

Formato de los datos:
- Se deben respetar las tildes en las palabras que se requiera (Categoría, Arábica, Catuaí; y al nombrar una mezcla, se debe también respetar
al momento de elegir/buscar una mezcla para seleccionarla).    
- Por el diseño que tiene el menú y el programa en general, nunca se solicita más de un conjunto de datos a la vez.
- El programa se hizo para que el uso de mayúsculas o minúsculas no influya o cause un error.
- El programa utiliza valores enteros, o sea, números sin decimales y mayores o iguales que cero (0).
- Si se deja el espacio vacío a la hora de filtrar los granos, el programa entiende que no se quiere utilizar ese filtro. Pero se le dice al usuario que
 utilice un (0) en las instrucciones cada vez que se le pide un dato.  
- La unica excepción al punto anterior es, cuando se pide el filtro por peso. El usuario no debe dejar vacío este espacio, se le indica que introduzca un 0 si
 no quiere usar este filtro. Esto porque el peso se trabaja como un tipo de dato int (entero) por lo que no puede tomar un valor nulo (null).
- En cada ventana al pedir un dato al usuario, se presentan algunas instrucciones necesarias así como valores posibles con los que se puede filtrar.
- No introducir espacios que no sean necesarios

Resultados obtenidos desde nuestra perspectiva:

- Pusimos en práctica nuevas formas de manejar arrays en general.
- Logramos controlar el sistema de filtros de granos, el cual se nos hizo muy complejo al inicio.
- Simplificamos el código una vez lo tuvimos casi resuelto.
- Logramos aclarar dudas sobre problemas de dirección e indirección al asignar valores a una variable con los operadores "--" dentro de un ciclo.
- Aprendimos a manejar el ciclo <for each> para ciertas ocasiones.

Logros:

- Logramos completar el programa con éxito antes de la hora de entrega asignada.
- Eficacia y funcionalidad del método moverGrano(), el cuál realiza una serie de operaciones con condicionales para cubrir todas las posibilidades
 según los filtros que decida emplear el usuario para su Selección de granos de café.
- El programa realiza de forma correcta todas las funcionalidades que se pidieron en el enunciado.

Versión y fecha: v1.0 - 14 de mayo 2020
Autores: Zurisadai Granados Montoya carné B53177; Fabián Orozco Chaves carné B95690.

Cómo arrancar el proyecto: Ejecutar el método main de la clase Mezcladora.

Instrucciones para el usuario: Introduzca el número correspondiente a la acción que desea realizar del menú principal y siga las indicaciones,
    que el programa le presente.

Primero se debe asignar la cantidad de sacos utilizando la opción del menú principal (Introduzca 1 para ejecutarlo).

Se deben guardar las recetas para cada mezcla, aquí se pueden crear cuantas recetas se necesiten,
sea el caso que el usuario tenga varias, solo debe ingresar una a la vez y al terminar de guardarla, volver a elegir la opción en el menú principal.

Una vez creadas todas las recetas que desea, el usuario deberá escoger la receta/mezcla que desee ejecutar para producir una mezcla. 
Debe introducir el nombre que tiene la mezcla, por ejemplo si la mezcla se creó con el nombre PuroCat, debe introducir PuroCat cuando se elija mezcla.

Posteriormente, en caso que no recuerde qué granos se ocupan para esa mezcla o cualquier otra carácteristica, puede usar la opción de mostrar mezclas definidas para ver los datos de todas las recetas guardadas.

El usuario debe elegir un saco (opción 6 del menú), el cuál se usará posteriormente para mover los granos hacia la canasta. Puede ver el nombre y existencias de todos los sacos con la opción 5.

Luego usando el saco elegido, debe proceder a pedir granos (opción 7 del menú) según filtros que el usuario desee. Los granos que cumplen esos filtros, se sacan del saco y se guardan en la canasta. Esta canasta contendrá cualquier grano que elija.

Si el usuario quiere saber qué granos contiene la canasta actualmente, puede elegir la opción 8.

La opción 9 le permite al usuario conocer, según lo que contiene canasta, cuantas veces podría ejecutar la mezcla; y cuantos kilos de la mezcla se producen.

Para ejecutar la mezcla, luego de seguir los pasos anteriores, el usuario debe accesar a la opción 10. Cuando todos los datos son correctos, se crea la mezcla y esta mezcla es enviada a las estanterias.

Para ver el stock (existencias de producto), el usuario puede accesar a la opción 11 del menú.

Cuando todas las acciones que el usuario desee sean satisfechas, utilice la opción 12 para terminar el programa y cerrar el mismo.