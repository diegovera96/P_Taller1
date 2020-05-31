import java.io.IOException;
import ucn.*;
public class App {

	public static void main(String[] args) throws IOException {

		ArchivoEntrada socios = new ArchivoEntrada("Socios.txt");	//Lee el archivo Socios.txt
		int cant_Lineas_Socios = 0;
		while(!socios.isEndFile()) {
			Registro reg = socios.getRegistro();
			String cant_Lineas = reg.getString();
			//StdOut.println(cant_Lineas_Socios); //testing
			if(!cant_Lineas.isEmpty()) {
				cant_Lineas_Socios++;	//suma la cantidad de lineas para poder determinar el largo que tendrán los vectores del archivo Socios.txt
			}
		}
		
		//Se crean los vectores del archivo Socios.txt
		String vec_Rut[] = new String[cant_Lineas_Socios];
		String vec_Nombre[] = new String[cant_Lineas_Socios];
		String vec_Apellido[] = new String[cant_Lineas_Socios];
		String vec_Activo1[] = new String[cant_Lineas_Socios];
		Boolean vec_Activo2[] = new Boolean[cant_Lineas_Socios];	//Se designo la columna de activos_2 como un boolean

		int aux_Socios = 0;
		socios = new ArchivoEntrada("Socios.txt");	//Lee el archivo Socios.txt y designa cada palabra o frase separada por comas como una variable
		while(!socios.isEndFile()) {
			Registro reg = socios.getRegistro();	//Se agrego un .replaceAll(" ", "") para eliminar los espacios posibles entre datos
			String rut = reg.getString().replaceAll(" ", "").replaceAll("-", "");
			if(!rut.isEmpty()) {
				String nombre = reg.getString().replaceAll(" ", "");
				String apellido = reg.getString().replaceAll(" ", "");
				String activo_1 = reg.getString().replaceAll(" ", "");
				Boolean activo_2;
				if(activo_1.equalsIgnoreCase("SI")) {
					activo_2 = true;
				}
				else {
					activo_2 = false;
				}
				vec_Rut[aux_Socios] = rut;
				vec_Nombre[aux_Socios] = nombre;
				vec_Apellido[aux_Socios] = apellido;
				vec_Activo1[aux_Socios] = activo_1;
				vec_Activo2[aux_Socios] = activo_2;
			}

			
			//Agrega cada variable registrada dentro de cada vector designado.

			
			//StdOut.println(vec_Rut[aux_Socios]); //testing para ver si funciona 
			//StdOut.println(vec_Activo2[aux_Socios]); //same
			aux_Socios++;

		}
		//StdOut.println("---------------------------------------------------------------");
		
		int cant_Lineas_Libros = 0;
		ArchivoEntrada libros = new ArchivoEntrada("Libros.txt");
		while(!libros.isEndFile()) {
			Registro reg = libros.getRegistro();
			String cant_Lineas = reg.getString();
			//StdOut.println(cant_Lineas_Socios); //testing
			if(!cant_Lineas.isEmpty()) {
				cant_Lineas_Libros++;	//Suma para obtener la cantidad de lineas que tiene el archivo Libros.txt
			}
			//StdOut.println(cant_Lineas_Libros); //testing
		}
		
		String vec_CodigoLibro[] = new String[cant_Lineas_Libros];
		String vec_Titulo[] = new String[cant_Lineas_Libros];
		String vec_NombreAutor[] = new String[cant_Lineas_Libros];
		String vec_ApellidoAutor[] = new String[cant_Lineas_Libros];
		String vec_Categoria[] = new String[cant_Lineas_Libros];
		int vec_SumaLibros[] = new int[cant_Lineas_Libros];
		
		//Lee el archivo Libros.txt y designa cada palabra o frase separada por comas como una variable
		//Se agrego un .replaceAll(" ", "") para eliminar los espacios posibles entre datos a excepcion de los titulos
		
		int aux_Libros = 0;
		libros = new ArchivoEntrada("Libros.txt");
		while(!libros.isEndFile()) {
			Registro reg = libros.getRegistro();
			String cod_Libro = reg.getString().replaceAll(" ", "");
			if(!cod_Libro.isEmpty()) {
				String titulo = reg.getString();
				String nom_Autor = reg.getString().replaceAll(" ", "");
				String apell_Autor = reg.getString().replaceAll(" ", "");
				String categoria = reg.getString().replaceAll(" ", "");
				
				vec_CodigoLibro[aux_Libros] = cod_Libro;
				vec_Titulo[aux_Libros] = titulo;
				vec_NombreAutor[aux_Libros] = nom_Autor;
				vec_ApellidoAutor[aux_Libros] = apell_Autor;
				vec_Categoria[aux_Libros] = categoria;

				aux_Libros++;
			}
		}

		//vec_SumaLibros[aux_Libros] = ;
		//StdOut.println(vec_CodigoLibro[aux_Libros]); //testing
		
		//StdOut.println("---------------------------------------------------------------");

		
		int cant_Lineas_Prestamos = 0;
		ArchivoEntrada prestamos = new ArchivoEntrada("Prestamos.txt");
		while(!prestamos.isEndFile()) {
			Registro reg = prestamos.getRegistro();
			String cant_Lineas = reg.getString();
			//StdOut.println(cant_Lineas_Socios); //testing
			if(!cant_Lineas.isEmpty()) {
				cant_Lineas_Prestamos++; //Suma que determinará la cantidad de lineas que tiene el archivo Prestamos.txt
			}
			//StdOut.println(cant_Lineas_Prestamos);
		}
		
		String vec_CodigoPrestamo[] = new String[cant_Lineas_Prestamos];
		String vec_CodigoLibroP[] = new String[cant_Lineas_Prestamos];
		String vec_RutSocio[] = new String[cant_Lineas_Prestamos];
		String vec_FechaPrestamo[] = new String[cant_Lineas_Prestamos];
		String vec_FechaDevolucion[] = new String[cant_Lineas_Prestamos];
				 
		//Lee el archivo Prestamos.txt y designa cada palabra o frase separada por comas como una variable
		//Se agrego un .replaceAll(" ", "") para eliminar los espacios posibles entre datos
		int aux_Prestamos = 0;
		prestamos = new ArchivoEntrada("Prestamos.txt");
		while(!prestamos.isEndFile()) {
			Registro reg = prestamos.getRegistro();
			String cod_Prestamo = reg.getString().replaceAll(" ", "");
			if(!cod_Prestamo.isEmpty()) {
				String cod_Libro = reg.getString().replaceAll(" ", "");
				String rut_Socio = reg.getString().replaceAll(" ", "").replaceAll("-", "");
				String fecha_Prestamo = reg.getString().replaceAll(" ", "");
				String fecha_Devolucion = reg.getString().replaceAll(" ", "");
				
				vec_CodigoPrestamo[aux_Prestamos] = cod_Prestamo;
				vec_CodigoLibroP[aux_Prestamos] = cod_Libro;
				vec_RutSocio[aux_Prestamos] = rut_Socio;
				vec_FechaPrestamo[aux_Prestamos] = fecha_Prestamo;
				vec_FechaDevolucion[aux_Prestamos] = fecha_Devolucion;
				//StdOut.println(vec_CodigoPrestamo[aux_Prestamos]); //testing

				aux_Prestamos++;
			}
		}
		
		
		//2 for anidados que permite comparar la lista libros con la lista libros prestados
		//mediante sus respectivos codigos, al ser iguales va sumando en 1 unidad
		//y almacenandolas en el vector suma de libros
		String aux_CodigoLibro = "";
		for(int i = 0; i < cant_Lineas_Libros; i++) {
			aux_CodigoLibro = vec_CodigoLibro[i];
			for(int j = i; j < cant_Lineas_Prestamos; j++) {
				if(vec_CodigoLibroP[j].equalsIgnoreCase(aux_CodigoLibro)) {
					vec_SumaLibros[i]++;
				}
			}
			//StdOut.print("[" + vec_SumaLibros[i] + "]"); //testing
		}
		//StdOut.println("");
		
		//StdOut.println("---------------------------------------------------------------");

		
		//Se inicia el primer menu del programa con 4 posibles opciones
		int opcionRequerida_1 = 0;
		int opcionRequerida_2 = 0;
		while(opcionRequerida_1 != 4) {
			
			opcionRequerida_1 = 0;
			do {
				try {
					StdOut.println("[1] Socios.");
					StdOut.println("[2] Libros.");
					StdOut.println("[3] Prestamos.");
					StdOut.println("[4] Salir.");
					
					StdOut.println("Ingrese una opcion.");
					String opcionIngresada_1 = StdIn.readLine();
					opcionRequerida_1 = Integer.parseInt(opcionIngresada_1);
					if(opcionRequerida_1 < 0 || opcionRequerida_1 > 4) {	//Se delimitan las opciones ingresadas por el usuario
						StdOut.println("Opcion no valida.");
					}
				}catch(NumberFormatException exc) 		//Se agrega una excepcion para caracteres que no son numeros
				{
					StdOut.println("Se ha ingresado una opcion no valida");
				}
			}while(opcionRequerida_1 == 0);
		
			switch(opcionRequerida_1) {
			case 1:
				opcionRequerida_2 = 0;
				while(opcionRequerida_2 != 4) {
					opcionRequerida_2 = 0;
					do {
						try {
							StdOut.println("[1] Lista de socios activos.");
							StdOut.println("[2] Cantidad de socios no activos.");
							StdOut.println("[3] Buscar estado de socio por RUT.");
							StdOut.println("[4] Volver.");	
							
							StdOut.println("Ingrese una opcion.");
							String opcionIngresada_1 = StdIn.readLine();
							opcionRequerida_2 = Integer.parseInt(opcionIngresada_1);
							if(opcionRequerida_2 < 0 || opcionRequerida_2 > 4) {	//Se delimitan las opciones ingresadas por el usuario
								StdOut.println("Opcion no valida.");
							}
							
						}catch(NumberFormatException exc) {
							StdOut.println("Se ha ingresado una opcion no valida");
						}
					}while(opcionRequerida_2 == 0);
					
					switch(opcionRequerida_2) {
					case 1:
						desplegar_Activos(cant_Lineas_Socios, vec_Activo2, vec_Nombre, vec_Apellido);
						break;
					case 2:
						StdOut.print("La cantidad de socios no activos es de: ");
						int contador_NoActivos = 0;
						for(int i = 0; i < cant_Lineas_Socios; i++) { //for que permite recorrer el vector no activos y desplegar su cantidad no activa
							if(vec_Activo2[i] == false) {
								contador_NoActivos++;
							}
						}
						StdOut.println(contador_NoActivos + " Usuarios no activos.");
						break;
					case 3:
						String rut_Ingresado = "";
						int rut_Requerido = 0;
						try {
							StdOut.println("Ingrese un rut sin puntos.");
							StdOut.println("Si termina en K, reemplace por un 0.");
							rut_Ingresado = StdIn.readString().replaceAll("-", "").replaceAll("k", "0").replaceAll("K", "0"); //reemplaza por un 0 a los ruts terminados en k ingresados por el usuario.
							rut_Requerido = Integer.parseInt(rut_Ingresado);

						}catch(NumberFormatException exc) {
							StdOut.println("Se ha ingresado un rut con formato no valida"); //manejo de excepcion para un rut no valido
						}
						
						int i = 0;
						int aux = 0;
						Boolean rut_Encontrado = false;
						for(i = 0; i < cant_Lineas_Socios; i++) {
							if(Integer.parseInt(vec_Rut[i].replaceAll("k", "0").replaceAll("K", "0")) == (rut_Requerido) && rut_Requerido > 0) { //reemplaza por un 0 a los ruts terminados en k del vector vec_Rut
								rut_Encontrado = true;
								aux = i;
							}
						}
						if(rut_Encontrado == true) {
							if(vec_Activo2[aux] == true) {
								StdOut.println("El estado actual del rut " + vec_Rut[aux] + " es Activo.");
							}
							else {
								StdOut.println("El estado actual del rut " + vec_Rut[aux] + " es No Activo.");
							}
						}
						else {
							StdOut.println("Rut no encontrado.");
						}
						break;
					case 4:
						break;
					}
				}
				break;
				
			case 2:
				opcionRequerida_2 = 0;
				while(opcionRequerida_2 != 3) {
					
					opcionRequerida_2 = 0;
					do {
						try {
							StdOut.println("[1] Lista de libros.");
							StdOut.println("[2] Buscar libro por codigo.");
							StdOut.println("[3] Volver.");

							StdOut.println("Ingrese una opcion.");
							String opcionIngresada2 = StdIn.readLine();
							opcionRequerida_2 = Integer.parseInt(opcionIngresada2);
							if(opcionRequerida_2 < 0 || opcionRequerida_2 > 3) {
								StdOut.println("Ingrese una opcion valida");
							}
						
						}catch(NumberFormatException exc) {
							StdOut.println("Se ha ingresado una opcion no valida");
						}
					}while(opcionRequerida_2 == 0);
					
					switch(opcionRequerida_2){
					case 1:
						//despliega por pantalla los libros que estan registrados en el sistema
						desplegar_Libros_Registrados(vec_CodigoLibro, vec_Titulo, vec_NombreAutor, vec_ApellidoAutor, vec_Categoria, cant_Lineas_Libros);
						break;
					case 2:
						//al ingresar el codigo del libro, busca en el sistema e imprime por pantalla el libro
						String codigoIngresado = "";
						try {
							StdOut.println("Ingrese el codigo del libro: ");
							codigoIngresado = StdIn.readLine();
						buscar_Libro_Codigo(vec_CodigoLibro, vec_Titulo, vec_NombreAutor, vec_ApellidoAutor, vec_Categoria, cant_Lineas_Libros, codigoIngresado);
						}catch(IllegalArgumentException exec){
							StdOut.println("Formato de codigo no valido: ");
						}
						break;
					case 3:
						break; //volver
					}

				}
				
				//libros
				break;
				
			case 3:
				opcionRequerida_2 = 0;
				while(opcionRequerida_2 != 5) {
					opcionRequerida_2 = 0;
					do {
						try {
							StdOut.println("[1] Lista de libros prestados.");
							StdOut.println("[2] Cantidad de libros prestados.");
							StdOut.println("[3] Libro mas solicitado.");
							StdOut.println("[4] Libro menos solicitado.");
							StdOut.println("[5] Volver.");

							StdOut.println("Ingrese una opcion.");
							String opcionIngresada2 = StdIn.readLine();
							opcionRequerida_2 = Integer.parseInt(opcionIngresada2);
							if(opcionRequerida_2 < 0 || opcionRequerida_2 > 5) {
								StdOut.println("Ingrese una opcion valida");
							}
						}catch(NumberFormatException exc) {
							StdOut.println("Se ha ingresado una opcion no valida");
						}
					}while(opcionRequerida_2 == 0);
					
					switch(opcionRequerida_2) {
					case 1:
						//Lista de libros prestados.
						lista_Libros_Prestados(cant_Lineas_Socios, cant_Lineas_Prestamos, cant_Lineas_Libros, vec_CodigoLibro, 
												vec_Titulo,  vec_Activo2, vec_Rut, vec_RutSocio, vec_CodigoLibroP);
						break;
					case 2:
						//Cantidad de libros prestados.
						cantidad_Libros_Prestados(cant_Lineas_Socios, cant_Lineas_Prestamos, cant_Lineas_Libros, vec_CodigoLibro, vec_Titulo,  
								vec_Activo2, vec_Rut, vec_RutSocio, vec_CodigoLibroP);
						break;
					case 3:
						libro_Mas_Prestado(cant_Lineas_Libros, vec_SumaLibros, vec_CodigoLibro, vec_Titulo);
						//Libro mas solicitado.
						break;
					case 4:
						libro_Menos_Prestado(cant_Lineas_Libros, vec_SumaLibros, vec_CodigoLibro, vec_Titulo);
						//Libro menos solicitado.
						break;
					case 5:
						break; //volver
					}
				}
				break;
			}
		}
	}

	
	//metodo que permite despelgar los usuarios activos
	public static void desplegar_Activos(int cant_Lineas_Socios, Boolean vec_Activo2[], String vec_Nombre[], String vec_Apellido[]) { 
		StdOut.println("Los usuarios actualemente activos son:");
		for(int i = 0; i < cant_Lineas_Socios; i++) {
			if(vec_Activo2[i] == true) {
				StdOut.println("Nombre: "+ vec_Nombre[i] +" "+ vec_Apellido[i]);
			}
		}
	}
	
	
	
	//Este metodo permite desplegar los libros prestados
	//utilizando 3 for anidados que recorren los 3 documentos txt
	public static void lista_Libros_Prestados(int cant_Lineas_Socios, int cant_Lineas_Prestamos, int cant_Lineas_Libros, String vec_CodigoLibro[], String vec_Titulo[],  
												Boolean vec_Activo2[], String vec_Rut[], String vec_RutSocio[], String vec_CodigoLibroP[]) {
		int i;
		String aux_Rut = "";
		StdOut.println("Lista de libros prestados:");

		for(i = 0; i < cant_Lineas_Socios; i++) {
			if(vec_Activo2[i] == true) {
				aux_Rut = vec_Rut[i];
				int j;
				String aux_CodigoLibroP = "";
				for(j = 0; j < cant_Lineas_Prestamos; j++) {
					if((vec_RutSocio[j]).equalsIgnoreCase(aux_Rut)) {
						aux_CodigoLibroP = vec_CodigoLibroP[j];
						int k;
						for(k = 0; k < cant_Lineas_Libros; k++) {
							if(vec_CodigoLibro[k].equalsIgnoreCase(aux_CodigoLibroP)) {
								StdOut.println("Codigo del libro: " + vec_CodigoLibro[k] + " " + "Titulo del libro: " + vec_Titulo[k]);
							}
						}
					}
				}
			}
		}	
	}

	//Permite calcular la cantidad de libros prestados
	//me diante 3 for anidados que verifican cada rut activo
	//y posteriormente almacenando un contador de libros prestados
	public static void cantidad_Libros_Prestados(int cant_Lineas_Socios, int cant_Lineas_Prestamos, int cant_Lineas_Libros, String vec_CodigoLibro[], String vec_Titulo[],  
													Boolean vec_Activo2[], String vec_Rut[], String vec_RutSocio[], String vec_CodigoLibroP[]) {
		int i;
		String aux_Rut = "";
		int contador_Libros = 0;
		StdOut.print("La cantidad de libros prestados es de: ");

		for(i = 0; i < cant_Lineas_Socios; i++) {
			if(vec_Activo2[i] == true) {
				aux_Rut = vec_Rut[i];
				int j;
				String aux_CodigoLibroP = "";
				for(j = 0; j < cant_Lineas_Prestamos; j++) {
					if((vec_RutSocio[j]).equalsIgnoreCase(aux_Rut)) {
						aux_CodigoLibroP = vec_CodigoLibroP[j];
						int k;
						for(k = 0; k < cant_Lineas_Libros; k++) {
							if(vec_CodigoLibro[k].equalsIgnoreCase(aux_CodigoLibroP)) {
								contador_Libros++;
							}
						}
					}
				}
			}
		}
		
		StdOut.println(contador_Libros);
	}
	
	
	
	//Permite encontrar y almacenar en un vector, el o los libros mas prestados
	public static void libro_Mas_Prestado(int cant_Lineas_Libros, int vec_SumaLibros[], String vec_CodigoLibro[], String vec_Titulo[]) {
		int aux_Min = -1;
		String aux_Vector[] = new String[cant_Lineas_Libros];
		StdOut.println("El o los libro(s) mas prestados son:");
		for(int i = 0; i < cant_Lineas_Libros; i++) {
			if(aux_Vector[i] == null) {
				aux_Vector[i] = "";
			}
			if(vec_SumaLibros[i] > aux_Min) {
				aux_Min = vec_SumaLibros[i];
				aux_Vector[0] = vec_CodigoLibro[i];
			}
			else {
				if(vec_SumaLibros[i] == aux_Min) {
					aux_Vector[i] = vec_CodigoLibro[i];
				}
				else {
					aux_Vector[i] = "";
				}
			}

		}
		
		for(int j = 0; j < cant_Lineas_Libros; j++) {
			for(int k = 0; k < cant_Lineas_Libros; k++) {
				if(aux_Vector[j].equalsIgnoreCase(vec_CodigoLibro[k]) /*&& !aux_Vector[j].equals("") && aux_Vector[j] != null*/) {
					StdOut.println("Titulo del libro: " + vec_Titulo[k] + " Codigo del libro: " + aux_Vector[j]);
				}
			}
		}
	}
	
	
	//Permite encontrar y almacenar en un vector, el o los libros menos prestados
	public static void libro_Menos_Prestado(int cant_Lineas_Libros, int vec_SumaLibros[], String vec_CodigoLibro[], String vec_Titulo[]) {
		int aux_Max = 999;
		String aux_Vector[] = new String[cant_Lineas_Libros];
		StdOut.println("El o los libro(s) menos prestados son:");
		for(int i = 0; i < cant_Lineas_Libros; i++) {
			if(aux_Vector[i] == null) {
				aux_Vector[i] = "";
			}
			if(vec_SumaLibros[i] < aux_Max) {
				aux_Max = vec_SumaLibros[i];
				aux_Vector[0] = vec_CodigoLibro[i];
			}
			else {
				if(vec_SumaLibros[i] == aux_Max) {
					aux_Vector[i] = vec_CodigoLibro[i];
				}
				else {
					aux_Vector[i] = "";
				}
			}

		}
		
		for(int j = 0; j < cant_Lineas_Libros; j++) {
			for(int k = 0; k < cant_Lineas_Libros; k++) {
				if(aux_Vector[j].equalsIgnoreCase(vec_CodigoLibro[k]) /*&& !aux_Vector[j].equals("") && aux_Vector[j] != null*/) {
					StdOut.println("Titulo del libro: " + vec_Titulo[k] + " Codigo del libro: " + aux_Vector[j]);
				}
			}
		}
	}
	
	public static void desplegar_Libros_Registrados(String vec_CodigoLibro[], String vec_Titulo[], String vec_NombreAutor[], String vec_ApellidoAutor[], String vec_Categoria[], int cant_Lineas_Libros) {
		StdOut.println("Libros registrados: ");
		for(int i = 0; i < cant_Lineas_Libros; i++) {
			StdOut.println(vec_CodigoLibro[i] + " , " + vec_Titulo[i] + " , " + vec_NombreAutor[i] + " " + vec_ApellidoAutor[i] + " , " + vec_Categoria[i]);
		}		
	}
	
	//metodo que busca un libro por el codigo ingresado
	public static void buscar_Libro_Codigo(String vec_CodigoLibro[], String vec_Titulo[], String vec_NombreAutor[], String vec_ApellidoAutor[], String vec_Categoria[], int cant_Lineas_Libros, String codigoIngresado) {
		int i = 0;
		for(i = 0; i < cant_Lineas_Libros; i++) {
			if(vec_CodigoLibro[i].equalsIgnoreCase(codigoIngresado)) {
				StdOut.println(vec_CodigoLibro[i]+ " , " + vec_Titulo[i] + " , " + vec_NombreAutor[i] + " " + vec_ApellidoAutor[i] + " , " + vec_Categoria[i]);
			}
			else {
				if(i == cant_Lineas_Libros-1) {
					StdOut.println("Libro no encontrado.");
					break;
				}
			}
		}
	}
	
}