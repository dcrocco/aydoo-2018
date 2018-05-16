# Informe

El ejercicio cumple tanto en su mayor parte con la consigna de fibo3 como con las convenciones java.

Con respecto a la consigna:
  - No contempla el caso de utilizar los argumentos en distintas posiciones (ej: java -jar fibo.jar -m=s -o=hd 5 en lugar de java -jar fibo.jar -o=hd -m=s 5).
  - Solo valida el caso de opciones inválidas en el caso de los argumentos de fibo2, pero no está extendido para los nuevos casos.

Con respecto a Solid se detectó:
   - Violación del principio de única responsabilidad, principalmente en las clases Program y Fibonacci: La clase Program valida argumentos e imprime el output. La clase Fibonacci calcula la sucesión y también la invierte.
   - Violación del principio de abierto/cerrado, por ejemplo en la clase ArgumentValidator, la cual tiene atributos para cada argumento lo cual genera que hay que agregar un atributo por cada argumento nuevo.

Con respecto a los tests, en general hay tests que validan el cálculo de Fibonacci y el caso de la sucesión invertida, y tests para la validación de argumentos:
  - Faltan tests sobre las impresiones en general.
  - Faltan tests sobre las clases que se encargan de impresiones vertical/horizontal/archivo.

Otros detalles:
  - Se validan argumentos en más de una clase (ArgumentValidator y Program).