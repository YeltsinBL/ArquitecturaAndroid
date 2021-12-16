# Arquitectura Android
## _Proyecto donde utilizaré las arquitecturas de Arquitectura: MVC - MVP - MVVM_

Iré creando por ramas todas las arquitecturas y al final, cuando terminde de hacer
las 3 arquitecturas, dejaré en master la que más me he adaptado y gustado para seguir aprendiendo.

- MVVM: Proyecto terminado (16/12/2021)
    - Eliminé la carpeta Presenter porque utilizaría los Observers y creé la carpeta ViewModel que este sería el puente para conectar los datos con el Observable.
- MVP: Proyecto terminado (27/10/2021)
    - Creé una carpeta Presenter donde Agregué el puente de conexión entre la Vista y el Modelo de datos.
    - Se movió el código que estaba en el Main hacia el repositorio que es donde se hará la conexión que traerá los datos.
- MVC : Proyecto terminado (25/10/2021)
    - Creé una carpeta Model  donde Agregué el Api Adapter para hacer la petición a un servidor o para leer un archivo json y, Api Service para agregar el metodo GET de la conexión http.

## Estoy utilizando

- [Intellij IDEA](https://www.jetbrains.com/idea/download/#section=windows) -  2021.2.2 Community Edition!
- [Android - Kotlin] - : 212-1.5.10-release-IJ5284.40
- [Retrofit](https://square.github.io/retrofit/) - HTTP client
- [Picasso](https://square.github.io/picasso/) - Imagenes
- [CircleImageView](https://github.com/hdodenhof/CircleImageView) - Imagen Circular
- [Gson](https://javadoc.io/doc/com.google.code.gson/gson/latest/com.google.gson/com/google/gson/Gson.html) - Leer archivo Json

