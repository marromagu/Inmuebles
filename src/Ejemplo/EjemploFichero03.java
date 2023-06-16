package Ejemplo;

/**
* Mezcla de dos ficheros
*
* @author Luis José Sánchez
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class EjemploFichero03{
	
	public static void main(String[] args){
		try{
			FileReader f1, f2;
			FileWriter f3;
			
			f1 = new FileReader("fichero1.txt");
			f2 = new FileReader("fichero2.txt");
			f3 = new FileWriter("mezcla.txt");
			
			BufferedReader bf1 = new BufferedReader(f1);
			BufferedReader bf2 = new BufferedReader(f2);
			BufferedWriter bw = new BufferedWriter(f3);
			
			String linea1 = bf1.readLine();
			String linea2 = bf2.readLine();
			
			while( (linea1 != null) || (linea2 != null)) {
				if(linea1 != null)
					bw.write(linea1+"\n");
				if(linea2 != null) 
					bw.write(linea2+"\n");
				linea1 = bf1.readLine();
				linea2 = bf2.readLine();
			}
			
			bf1.close();
			bf2.close();
			bw.close();
			
		}catch(IOException e){
			System.out.println("Seha producido un error de lectura/escritura");
			System.err.println(e.getMessage());
		}
	}
}


