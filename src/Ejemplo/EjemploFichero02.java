package Ejemplo;

/**
* Ejemplo de uso de la clase File
* Escritura en un fichero de texto
*
* @author Luis José Sánchez
*/
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class EjemploFichero02{ 

	public static void main(String[] args){
		try{
			FileWriter fichero = new FileWriter("fruta.txt");
			BufferedWriter bw = new BufferedWriter(fichero);
			
			bw.write("naranja\n");
			bw.write("mango\n");
			bw.write("chirimoya\n");
			
			bw.close();
			
		}catch(IOException e){
			System.out.println("No se ha podido escribir en el fichero");
		}
	}
}

