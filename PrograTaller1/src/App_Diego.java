import java.io.IOException;
import ucn.*;
public class App_Diego {

	public static void main(String[] args) throws IOException {

		ArchivoEntrada socios = new ArchivoEntrada("Socios.txt");	//Lee el archivo Socios.txt
		int cant_Lineas_Socios = 0;
		while(!socios.isEndFile()) {
			Registro reg = socios.getRegistro();
			cant_Lineas_Socios++;	//suma la cantidad de lineas para poder determinar el largo que tendrán los vectores del archivo Socios.txt
			StdOut.println(cant_Lineas_Socios); //testing
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
			String rut = reg.getString().replaceAll(" ", "");
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
			
			//Agrega cada variable registrada dentro de cada vector designado.
			vec_Rut[aux_Socios] = rut;
			vec_Nombre[aux_Socios] = nombre;
			vec_Apellido[aux_Socios] = apellido;
			vec_Activo1[aux_Socios] = activo_1;
			vec_Activo2[aux_Socios] = activo_2;
			
			StdOut.println(vec_Rut[aux_Socios]); //testing para ver si funciona 
			StdOut.println(vec_Activo2[aux_Socios]); //same
			aux_Socios++;
		}
		StdOut.println("---------------------------------------------------------------");
		
		int cant_Lineas_Libros = 0;
		ArchivoEntrada libros = new ArchivoEntrada("Libros.txt");
		while(!libros.isEndFile()) {
			Registro reg = libros.getRegistro();
			cant_Lineas_Libros++;	//Suma para obtener la cantidad de lineas que tiene el archivo Libros.txt
			StdOut.println(cant_Lineas_Libros); //testing
		}
		
		String vec_CodigoLibro[] = new String[cant_Lineas_Libros];
		String vec_Titulo[] = new String[cant_Lineas_Libros];
		String vec_NombreAutor[] = new String[cant_Lineas_Libros];
		String vec_ApellidoAutor[] = new String[cant_Lineas_Libros];
		String vec_Categoria[] = new String[cant_Lineas_Libros];
		String vec_SumaLibros[] = new String[cant_Lineas_Libros];
		
		//Lee el archivo Libros.txt y designa cada palabra o frase separada por comas como una variable
		//Se agrego un .replaceAll(" ", "") para eliminar los espacios posibles entre datos a excepcion de los titulos
		
		int aux_Libros = 0;
		libros = new ArchivoEntrada("Libros.txt");
		while(!libros.isEndFile()) {
			Registro reg = libros.getRegistro();
			String cod_Libro = reg.getString().replaceAll(" ", "");
			String titulo = reg.getString();
			String nom_Autor = reg.getString().replaceAll(" ", "");
			String apell_Autor = reg.getString().replaceAll(" ", "");
			String categoria = reg.getString().replaceAll(" ", "");
			
			vec_CodigoLibro[aux_Libros] = cod_Libro;
			vec_Titulo[aux_Libros] = titulo;
			vec_NombreAutor[aux_Libros] = nom_Autor;
			vec_ApellidoAutor[aux_Libros] = apell_Autor;
			vec_Categoria[aux_Libros] = categoria;
			//vec_SumaLibros[aux_Libros] = ;
			StdOut.println(vec_CodigoLibro[aux_Libros]); //testing
			aux_Libros++;
		}
		
		StdOut.println("---------------------------------------------------------------");

		
		int cant_Lineas_Prestamos = 0;
		ArchivoEntrada prestamos = new ArchivoEntrada("Prestamos.txt");
		while(!prestamos.isEndFile()) {
			Registro reg = prestamos.getRegistro();
			cant_Lineas_Prestamos++; //Suma que determinará la cantidad de lineas que tiene el archivo Prestamos.txt
			StdOut.println(cant_Lineas_Prestamos);
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
			String cod_Libro = reg.getString().replaceAll(" ", "");
			String rut_Socio = reg.getString().replaceAll(" ", "");
			String fecha_Prestamo = reg.getString().replaceAll(" ", "");
			String fecha_Devolucion = reg.getString().replaceAll(" ", "");
			
			vec_CodigoPrestamo[aux_Prestamos] = cod_Prestamo;
			vec_CodigoLibroP[aux_Prestamos] = cod_Libro;
			vec_RutSocio[aux_Prestamos] = rut_Socio;
			vec_FechaPrestamo[aux_Prestamos] = fecha_Prestamo;
			vec_FechaDevolucion[aux_Prestamos] = fecha_Devolucion;
			StdOut.println(vec_CodigoPrestamo[aux_Prestamos]); //testing

			aux_Prestamos++;
		}
		
		StdOut.println("---------------------------------------------------------------");

		
		//Se inicia el primer menu del programa con 4 posibles opciones
		int opcionRequerida_1 = 0;
		while(opcionRequerida_1 != 4) {
			
			opcionRequerida_1 = 0;
			do {
				try {
					StdOut.println("[1] Socios.");
					StdOut.println("[2] Libros.");
					StdOut.println("[3] Prestamos.");
					StdOut.println("[4] Salir.");
					
					StdOut.println("Ingrese una opcion.");
					String opcionIngresada_1 = StdIn.readString();
					opcionRequerida_1 = Integer.parseInt(opcionIngresada_1);
					if(opcionRequerida_1 < 0 || opcionRequerida_1 > 4) {	//Se delimitan las opciones ingresadas por el usuario
						StdOut.println("Opcion no valida.");
					}
					break;
				}catch(NumberFormatException exc) 		//Se agrega una excepcion para caracteres que no son numeros
				{
					StdOut.println("Se ha ingresado una opcion no valida");
				}
			}while(opcionRequerida_1 == 0);
		
			switch(opcionRequerida_1) {
			case 1:
				break;
				
			case 2:
				break;
				
			case 3:
				break;
			}
		}
	}
}
//el definitivo
//ahora si? 
//prueba 1