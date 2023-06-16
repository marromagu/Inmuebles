package Ejemplo;

/**
* Ejemplo de uso de la clase File
* Lectura de un fichero de texto
*
* @author Luis José Sánchez
*/
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class EjemploFichero01{
	
	public static void main(String[] args){
		try{
			FileReader fichero = new FileReader("malaga1.txt");
			BufferedReader bf = new BufferedReader(fichero);
			
			String linea = bf.readLine();
			
			while(linea != null) {
				System.out.println(linea);
				linea=bf.readLine();
			}
			
			bf.close();
			
		}catch(FileNotFoundException e) {//qué hacer si no se encuentra el fichero
			System.out.println("No se encuentra el fichero malaga.txt");
		}catch(IOException e) {//qué hacer si hay un error en la lectura del fichero
			System.out.println("No se puede leer el fichero malaga.txt");
		}
	}
}
