# Descripción del diseño del programa.
El programa fue realizado utilizando Java, Maven y JUnit para las pruebas.
Cuenta con archivos UsuarioManager.java, SalaManager.java y ReservaManager.java que se encargan de implemmentar la lógica para obtener, actualizar y eliminar datos.
# Instrucciones ejecución.
Accede a la direccion ````\tarea3 pruebas\my-junit-project\demo>```` 
Para ejecutar programa principal:
````
mvn compile
java -cp target/classes com.example.App
````
Para realizar pruebas ejecuta:
````
mvn compile
mvn test
````
# Reporte de resultados de las pruebas unitarias.
Se realizaron 9 test, 3 para cada una de las áreas (usuarios, sala y reservas) y cada uno con un test para creación, actualización y eliminación.
Todos los tests implementados resultaron exitosos.
````
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.example.ReservaManagerTest
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.067 s - in com.example.ReservaManagerTest
[INFO] Running com.example.SalaManagerTest
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.001 s - in com.example.SalaManagerTest
[INFO] Running com.example.UsuarioManagerTest
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.001 s - in com.example.UsuarioManagerTest
[INFO] 
[INFO] Results:
[INFO]
[INFO] Tests run: 9, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.824 s
````
