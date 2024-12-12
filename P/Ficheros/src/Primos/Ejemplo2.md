# Escribir en ficheros de texto
1. Crear un objeto FileWriter que apunte al archivo donde se desea escribir:

```java
FileWriter writer = new FileWriter("ruta/al/archivo.txt");
```
En este ejemplo, "ruta/al/archivo.txt" es la ruta relativa o absoluta del archivo donde se desea escribir.

Escribir los datos en el archivo utilizando el método write() del objeto FileWriter:

```java
writer.write("Hola, Mundo!\n");
writer.write("Esto es una línea de texto.\n");
```

En este ejemplo, se escriben dos líneas de texto en el archivo. Es importante incluir el carácter de salto de línea (\n) al final de cada línea para separarlas.

Cerrar el objeto FileWriter una vez que se ha terminado de escribir en el archivo:

```java
writer.close();
```
