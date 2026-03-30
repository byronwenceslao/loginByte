---------------------------------
    HERRAMIENTAS UTILIZADAS
---------------------------------
- Android Studio Panda 2
- JDK 11
- Dispositivo móvil para emular

----------------------------------
INSTRUCCIONES A EJECUTAR
----------------------------------
1. Descargar el repositorio
2. Abrir Android Studio
3. Seleccionar la carpeta del proyecto
4. Esperar a que Android Studio cargue todo el proyecto
5. Conectar un dispositivo Android por USB con la depuración USB activa o bien iniciar un emulador con AVD Manager
6. Presionar el botón RUN para correr la app

----------------------------------
	COMO USAR LA APP
----------------------------------
1. Primero deberá Registrase - Presionar el botón "Registrase" para crear un usuario.
2. Luego debe completar el formulario de registro:
	- Ingresar nombre de usuario. (El usuario debe tener mínimo 8 caracteres)
	- Ingresar contraseña. (La contraseña debe tener mínimo 6 caracteres y 1 letra Mayúscula)
	- Ingresar la contraseña nuevamente para confirmarla. 
3. Una vez se haya registrado con éxito lo llevará a la pantalla principal. (Login)
4. Ingresar las credenciales correctamente.
5. Una vez logeado podrá ver un listado de Donas, al presionar alguna de ellas podrá ver las características.
6. Para salir de la aplicación, presionar el botón salir que se encuentra arriba.

NOTA: Los datos registrados se almacenan en la memoria del dispositivo y no en una base de datos externa.

-----------------------------------
      TECNOLOGIAS UTILIZADAS
-----------------------------------
- Kotlin
- Material Desing 3
- Fragments
- Retrofit 2
- SharedPreferences
- API https://private-1ca53c-training45.apiary-mock.com/donuts

-----------------------------------
	LOGICA DEL PROYECTO
-----------------------------------
- LoginActivity.kt 	   = 	Es la pantalla principal para iniciar sesión.
- RegisterActivity.kt 	   =	Es la pantalla para registrar nuevos usuarios.
- HomeActivity.kt	   =	Es la pantalla donde se mostrará el listado de donas.
- DonutsFragment.kt	   =	Acá se obtiene el lista de donas de la API.
- DonutDetailFragmente.kt  =	Acá se obtienen los detalles que componen a las donas.
- DonutAdapter.kt	   =	Acá se encuentra la lógica de como se debe mostrar los datos de las donas.
- DonutsAPI.kt		   =	Acá se hace la petición GET.
- Donuts.kt		   =	Acá se crean las variables que recibirán los datos de la API. (Deben ser iguales)

--------------------------------------------------------------------------------------------------------------------
