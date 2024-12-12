Supongamos que tenemos un archivo llamado "datos.txt" que contiene lo siguiente:

```
Juan 25
María 30
Pedro 28
```

¿Cómo podemos leer y procesar en Java los datos? Tenemos dos formas.

- Método 1: leer un archivo utilizando BufferedReader.

1. Crear una instancia de la clase FileReader o InputStreamReader para abrir el archivo de entrada y crear un flujo de entrada. Ambas clases permiten leer caracteres de un archivo, pero FileReader está optimizado para leer caracteres de archivos de texto, mientras que InputStreamReader puede leer caracteres de cualquier flujo de entrada. De momento nosotros utilizaremos FileReader ya que leeremos archivos de texto.

```java
FileReader fr = new FileReader("archivo.txt");
```

2. Crear una instancia de la clase BufferedReader, que proporciona una forma eficiente de leer líneas de texto de un archivo. Esta clase es capaz de leer varias líneas de texto a la vez y almacenarlas en un búfer, lo que puede mejorar el rendimiento de la lectura de archivos.

```java
BufferedReader br = new BufferedReader(fr);
```

3. Utilizar el método readLine() de la clase BufferedReader para leer líneas de texto del archivo. Este método devuelve una cadena que contiene la línea de texto actual, o null si se ha alcanzado el final del archivo.

```java
String linea;
while ((linea = br.readLine()) != null) {
    // Hacer algo con la línea leída
}
```

4. Procesar los datos leídos. Se puede utilizar el método split() de la clase String para dividir las líneas de texto en campos o utilizar otros métodos de procesamiento de texto según sea necesario.

5. Cerrar el archivo utilizando los métodos close() del objeto BufferedReader y close() del objeto FileReader o InputStreamReader.

- Método 2: leer un archivo utilizando Sanner.
1. Crear un objeto Scanner que apunte al archivo que se desea leer:

```java
Scanner scanner = new Scanner(new File("ruta/al/archivo.txt"));
```

En este ejemplo, "ruta/al/archivo.txt" es la ruta relativa o absoluta del archivo que se desea leer.

Leer los datos del archivo utilizando los métodos de la clase Scanner. Por ejemplo, si el archivo contiene una lista de números enteros separados por comas, se puede leer de la siguiente manera:

```java
while (scanner.hasNextInt()) {
    int numero = scanner.nextInt();
    // Hacer algo con el número leído
}
```

En este ejemplo, la función hasNextInt() verifica si hay un número entero siguiente en el archivo y devuelve true si lo hay. El método nextInt() lee el número entero y lo asigna a la variable numero.

Podemos leer línea a línea y luego procesar los datos leídos con los tipos requeridos en nuestro programa:

```java
// Leer línea por línea y procesar los datos
while (scanner.hasNextLine()) {
    String linea = scanner.nextLine();
    // Hacer algo con la línea leída
}
```

Cerrar el objeto Scanner una vez que se ha terminado de leer el archivo:

```java
scanner.close();
```

Es importante cerrar el objeto Scanner para liberar los recursos y asegurarse de que el archivo se cierre correctamente.
