/*
public void leerLocales(){
    try{
      double sup = 0, precio = 0;
      String dir="";
      int i = 0;
      FileReader miFichero = new FileReader("Locales.txt");
      BufferedReader bf = new BufferedReader(miFichero);
      String linea = bf.readLine();
      while(linea != null){
        switch (i) {
          case 0:
            sup = Double.parseDouble(linea);
            i++;
            break;
          case 1:
            dir = linea;
            i++;
            break;
          case 2:
            precio = Double.parseDouble(linea);
            Local miLocal = new Local(sup, dir, precio);
            altaInmueble(miLocal);
            i=0;
            break;
          default:
        }
        linea = bf.readLine();
      }
      bf.close();
    }catch(Exception e){
      System.out.println("Error");
    }
  }

  public void leerViviendas(){
    try{
      double sup = 0, precio = 0;
      int numHabitaciones = 0, numBaños = 0, plazasGarajes = 0, planta = 0, i = 0;
      boolean ascensor = false;
      String dir = "";
      FileReader miFichero = new FileReader("Viviendas.txt");
      BufferedReader bf = new BufferedReader(miFichero);
      String linea = bf.readLine();
      while(linea != null){
        switch (i) {
          case 0:
            sup = Double.parseDouble(linea);
            i++;
            break;
          case 1:
            dir = linea;
            i++;
            break;
          case 2:
            precio = Double.parseDouble(linea);
            i++;
            break;
          case 3:
            numHabitaciones = Integer.parseInt(linea);
            i++;
            break;
          case 4:
            numBaños = Integer.parseInt(linea);
            i++;
            break;
          case 5:
            plazasGarajes = Integer.parseInt(linea);
            i++;
            break;
          case 6:
            ascensor = false;
            switch (linea.charAt(0)) {
              case 's':
              case 'S':
                ascensor = true;
            }
            i++;
            break;
          case 7:
            planta = Integer.parseInt(linea);
            Inmueble miInmueble = new Vivienda(numHabitaciones, numBaños, plazasGarajes, ascensor, planta, sup, dir, precio);
            altaInmueble(miInmueble);
            i=0;
            break;
          default:
        }
        linea = bf.readLine();
      }
      bf.close();
    }catch(Exception e){
      System.out.println("Error");
    }
  }
  
  public void leerAticos(){
    try{
      double sup = 0, precio = 0, terraza = 0;
      int numHabitaciones = 0, numBaños = 0, plazasGarajes = 0, planta = 0, i = 0;
      boolean ascensor = false;
      String dir = "";
      FileReader miFichero = new FileReader("Aticos.txt");
      BufferedReader bf = new BufferedReader(miFichero);
      String linea = bf.readLine();
      while(linea != null){
        switch (i) {
          case 0:
            sup = Double.parseDouble(linea);
            i++;
            break;
          case 1:
            dir = linea;
            i++;
            break;
          case 2:
            precio = Double.parseDouble(linea);
            i++;
            break;
          case 3:
            numHabitaciones = Integer.parseInt(linea);
            i++;
            break;
          case 4:
            numBaños = Integer.parseInt(linea);
            i++;
            break;
          case 5:
            plazasGarajes = Integer.parseInt(linea);
            i++;
            break;
          case 6:
            ascensor = false;
            switch (linea.charAt(0)) {
              case 's':
              case 'S':
                ascensor = true;
            }
            i++;
            break;
          case 7:
            planta = Integer.parseInt(linea);
            i++;
            break;
          case 8:
            terraza = Double.parseDouble(linea);
            Inmueble miInmueble = new Atico(terraza, numHabitaciones, numBaños, plazasGarajes, ascensor, planta, sup, dir, precio);
            altaInmueble(miInmueble);
            i=0;
            break;
          default:
        }
        linea = bf.readLine();
      }
      bf.close();
    }catch(Exception e){
      System.out.println("Error");
    }
  }   
  
  
public void grabarLocales() {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("Locales.txt");
            pw = new PrintWriter(fichero);

            for (Inmueble inm : inmuebles) {
                if (inm instanceof Local) {
                    pw.println(inm.getSuperficie());
                    pw.println(inm.getDireccion());
                    pw.println(inm.getPrecio());
                }
            }

        } catch (Exception e) {
            System.out.println("Error grabando Locales.txt");
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                System.out.println("Error grabando Locales.txt");
            }
        }
    }  */