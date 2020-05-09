import java.io.IOException;
import ucn.*;
public class App {

	public static void main(String[] args) throws IOException {

		//Lee el archivo Socios.txt y designa cada palabra o frase separada por comas como una variable
		//Se agrego un .replaceAll(" ", "") para eliminar los espacios posibles entre datos
		//Se designo la columna de activos como un boolean
		ArchivoEntrada socios = new ArchivoEntrada("Socios.txt");
		while(!socios.isEndFile()) {
			Registro reg = socios.getRegistro();
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
		}
		
		//Lee el archivo Libros.txt y designa cada palabra o frase separada por comas como una variable
		//Se agrego un .replaceAll(" ", "") para eliminar los espacios posibles entre datos a excepcion de los titulos
		ArchivoEntrada libros = new ArchivoEntrada("Libros.txt");
		while(!libros.isEndFile()) {
			Registro reg = libros.getRegistro();
			String cod_Libro = reg.getString().replaceAll(" ", "");
			String titulo = reg.getString();
			String nom_Autor = reg.getString().replaceAll(" ", "");
			String apell_Autor = reg.getString().replaceAll(" ", "");
			String categoria = reg.getString().replaceAll(" ", "");
		}
		
		//Lee el archivo Prestamos.txt y designa cada palabra o frase separada por comas como una variable
		//Se agrego un .replaceAll(" ", "") para eliminar los espacios posibles entre datos
		ArchivoEntrada prestamos = new ArchivoEntrada("Prestamos.txt");
		while(!prestamos.isEndFile()) {
			Registro reg = prestamos.getRegistro();
			String cod_Prestamo = reg.getString().replaceAll(" ", "");
			String cod_Libro = reg.getString().replaceAll(" ", "");
			String rut_Socio = reg.getString().replaceAll(" ", "");
			String fecha_Prestamo = reg.getString().replaceAll(" ", "");
			String fecha_Devolucion = reg.getString().replaceAll(" ", "");
		}
		
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