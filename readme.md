# Mi Proyecto de Jetpack Compose

Este es un proyecto de ejemplo en Android utilizando Jetpack Compose. La aplicación muestra una lista de publicaciones que se cargan desde un repositorio simulado. La aplicación incluye una pantalla de carga, manejo de errores, y una funcionalidad de refresh para actualizar los datos.

## Características

- **Jetpack Compose**: Implementación de una interfaz de usuario moderna y declarativa.
- **Manejo de Estados**: Utiliza `StateFlow` de Kotlin para manejar estados de la UI de manera efectiva.
- **Pantallas de Carga y Error**: Pantallas dedicadas para el estado de carga y error.
- **Swipe to Refresh**: Funcionalidad de "arrastrar para actualizar" para recargar la lista de publicaciones.
- **Arquitectura Limpia**: Separación de la lógica de presentación y los datos mediante el uso de ViewModel y Repositorio.
- **Código Limpio**: Buenas prácticas de programación, con un código fácil de entender y mantener.

## Requisitos

- Android Studio Flamingo o superior.
- Conexión a Internet para descargar las dependencias.
- Android Nougat o superior

## Instrucciones para Configurar y Ejecutar el Proyecto

1. **Clonar el Repositorio:**

   Clona el repositorio en tu máquina local usando el siguiente comando:
   ```bash
   git clone https://gitlab.com/isacel97/pruebaKotlin

2**Abrir el Proyecto en Android Studio:**
    Abre Android Studio, selecciona "Open an Existing Project" y navega hasta la carpeta donde clonaste el repositorio.

3**Abrir el Proyecto en Android Studio:**
    Android Studio debería instalar automáticamente todas las dependencias necesarias. Asegúrate de que tu proyecto esté sincronizado con Gradle (File > Sync Project with Gradle Files).


## Estructura del Proyecto
- **MainActivity.kt**: Actividad principal que gestiona la navegación y la UI.
- **PostViewModel.kt**: ViewModel que maneja la lógica de negocio y la carga de datos.
- **PostRepository.kt**: Repositorio simulado que devuelve una lista de publicaciones.
- **model/Post.kt**: Modelo de datos para las publicaciones.

## Dependencias Clave
- **Retrofit**: Para realizar llamadas de red (actualmente simulado).
- **Kotlin Coroutines**: Para manejar operaciones asíncronas.
- **Jetpack Compose**: Para la construcción de la UI.
- **Accompanist SwipeRefresh**: Para la funcionalidad de "Swipe to Refresh".
