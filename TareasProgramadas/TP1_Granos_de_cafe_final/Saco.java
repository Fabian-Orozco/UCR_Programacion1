import java.util.ArrayList;

/**
 * Esta clase se encarga de definir los sacos y gestionar los métodos de la Clase Saco. Llena los sacos de granos de café (instancias de la Clase Grano).
 * @author: Zurisadai Granados Montoya carné B53177, Fabián Orozco Chaves carné B95690.
 * @version: 14/05/2020/
 */

class Saco{

    private ArrayList <Grano> granoDeCafe; //ArrayList que contiene todos los granos de cafe de este saco(objetos).
    private double[] porcentajesCantGrano; //vector que contiene el porcentaje de cada subespecie de grano.
    private String nombre; //nombre de cada saco

    //se copio a mezcladora
    private int[] pesoPorTipo; //t3: contiene el peso de cada subespecie en orden: arábica, catuai, caturra.
    private int[] cantidadPorTipo; //3: contiene la cantidad de granos de cada tipo de grano de café: arábica, catuai.
    private int[] cantGranoPorTamaño; //3: contiene la cantidad por tamaño: pequeño/mediano/grande.
    private int[] cantGranoPorCategoria; //[5,6]categoria 1, [7,8]categoria 2, [9,10]categoria 3
    public ArrayList<Grano> canasta; //ArrayListque contiene los granos escogidos por el usuario.
    private int pesoSaco; //Variable de tipo entero que contiene el peso total en gramos de este saco.

    /**
    * Constructor de la Clase Saco, se encarga de asignar el espacio en memoria
    * y de invocar el constructor de la clase Grano, que se usa para llenar el saco de granos de café.
    * @param nombre recibe un parámetro de tipo String con el nombre para este saco
    */
    public Saco(String nombre){
        canasta = new ArrayList<Grano>();
        porcentajesCantGrano = new double[3];
        pesoPorTipo = new int[3];
        cantidadPorTipo = new int[3];
        cantGranoPorTamaño = new int[3];
        cantGranoPorCategoria = new int[3];
        //crea valores random de [1000,5000] para saber la capacidad del saco
        int cantGranosEnSacoRand = (int) (1000 + Math.random() * (4001));
        granoDeCafe = new ArrayList<>(cantGranosEnSacoRand);
        //agrega los granos al arrayList aleatoriamente
        for (int i = 0; i <= cantGranosEnSacoRand; i++){
            granoDeCafe.add(new Grano());
        }
        calcularPesoTipo();
        pesoSaco = pesoPorTipo[0] + pesoPorTipo[1] + pesoPorTipo[2];
        this.nombre=nombre;
    }

    /**
    * Método que devuelve un String que muestra al usuario toda la información
    * importante recopilada en el método toString() de la Clase Saco.
    */
    public String getArrayListGC(){
        String respuesta= "";
        for(Grano g : granoDeCafe){
            respuesta += g.toString() + "\n";
        }
        return respuesta; /** @return retorna el String con la información */
    }

    /**
    * Método que calcula el peso en gramos de cada subespecie de grano de café.
    */
    public void calcularPesoTipo(){
        int temporalArabiga = 0;
        int temporalCatuai = 0;
        int temporalCaturra = 0;
        for(int i = 0; i < granoDeCafe.size(); i++){
            if(granoDeCafe.get(i).getTipoGrano().equalsIgnoreCase("Arábica")){
                temporalArabiga += granoDeCafe.get(i).getPesoGrano();
            }
            if(granoDeCafe.get(i).getTipoGrano().equalsIgnoreCase("Catuaí")){
                temporalCatuai+= granoDeCafe.get(i).getPesoGrano();
            }
            if(granoDeCafe.get(i).getTipoGrano().equalsIgnoreCase("Caturra")){
                temporalCaturra += granoDeCafe.get(i).getPesoGrano();
            }
        }
        pesoPorTipo[0] = temporalArabiga;
        pesoPorTipo[1] = temporalCatuai;
        pesoPorTipo[2] = temporalCaturra;
    }

    /**
    * Método que calcula la cantidad de granos que hay por cada subespecie.
    */
    public void calcularPorTipo(){
        int arabiga=0;
        int catuai=0;
        int caturra=0;
        for(int i = 0 ; i < granoDeCafe.size() ; i++){
            arabiga += (((granoDeCafe.get(i)).getTipoGrano()).equalsIgnoreCase("Arábica")) ? 1 : 0;
            catuai += (((granoDeCafe.get(i)).getTipoGrano()).equalsIgnoreCase("Catuaí")) ? 1 : 0;
            caturra += (((granoDeCafe.get(i)).getTipoGrano()).equalsIgnoreCase("Caturra")) ? 1 : 0;
        }
        cantidadPorTipo[0] = arabiga;
        cantidadPorTipo[1] = catuai;
        cantidadPorTipo[2] = caturra;
    }

    /**
    * Método que calcula la cantidad de granos según el tamaño
    */
    public void calcularPorTamaño(){
        int pequeño=0;
        int mediano=0;
        int grande=0;
        for(int i = 0 ; i < granoDeCafe.size() ; i++){
            pequeño += (((granoDeCafe.get(i)).getTamañoGrano()).equalsIgnoreCase("pequeño")) ? 1 : 0;
            mediano += (((granoDeCafe.get(i)).getTamañoGrano()).equalsIgnoreCase("mediano")) ? 1 : 0;
            grande += (((granoDeCafe.get(i)).getTamañoGrano()).equalsIgnoreCase("grande")) ? 1 : 0;
        }
        cantGranoPorTamaño[0] = pequeño;
        cantGranoPorTamaño[1] = mediano;
        cantGranoPorTamaño[2] = grande;
    }

    /**
    * Método que calcula la cantidad de granos que hay por categoria (catoegorías según el peso del grano de café)
    */
    public void calcularPorCategoria(){
        int categoria1=0; //[5,6]
        int categoria2=0; //[7,8]
        int categoria3=0; //[9,10]

        for(int i = 0 ; i < granoDeCafe.size() ; i++){
            categoria1 += (((granoDeCafe.get(i)).getCategoriaPeso()).equalsIgnoreCase(("Categoría 1"))) ? 1 : 0;
            categoria2 += (((granoDeCafe.get(i)).getCategoriaPeso()).equalsIgnoreCase(("Categoría 2"))) ? 1 : 0;
            categoria3 += (((granoDeCafe.get(i)).getCategoriaPeso()).equalsIgnoreCase(("Categoría 3"))) ? 1 : 0;
        }
        cantGranoPorCategoria[0] = categoria1;
        cantGranoPorCategoria[1] = categoria2;
        cantGranoPorCategoria[2] = categoria3;
    }

     /**
     * Método que devuelve una matríz de tipo double, realiza el cálculo del porcentaje de granos según la subespecie, comparado con el total de granos que hay en el Saco.
     */
    public double[] porcentajesCantidadGrano(){
        calcularPorTipo();
        porcentajesCantGrano[0] =  ((cantidadPorTipo[0] * 100.0) / (granoDeCafe.size()));
        porcentajesCantGrano[1] =  ((cantidadPorTipo[1] * 100.0) / (granoDeCafe.size()));
        
        porcentajesCantGrano[2] =  ((cantidadPorTipo[2] * 100.0) / (granoDeCafe.size()));
        return porcentajesCantGrano; /** @return devuelve una matriz double con los datos de porcentaje */
    }

    /**
    * Método que devuelve un entero, muestra al usuario la cantidad de granos por tipo / subespecie de grano de café
    */
    public int imprimirCantidadPorTipo(String tipo){
        calcularPorTipo();
        if(tipo.equalsIgnoreCase("Arábica")){
            return cantidadPorTipo[0]; /** @return retorna la cantidad de granos para la subespecie: Arábica */
        }
        else if(tipo.equalsIgnoreCase("Catuaí")){
            return cantidadPorTipo[1]; /** @return retorna la cantidad de granos para la subespecie: Catuaí */
        }
        else if (tipo.equalsIgnoreCase("Caturra")){
            return cantidadPorTipo[2]; /** @return retorna la cantidad de granos para la subespecie: Caturra */
        }
        return 0; /** @return retorna 0 si no hay granos de niguna de las subespecies actualmente */
    }

    /**
    * Método que devuelve un entero, muestra al usuario el peso por cada tipo/subespecie de granos de café
    */
    public int imprimirPesoPorTipo(String tipo){
        calcularPesoTipo();
        if(tipo.equalsIgnoreCase("Arábica")){
            return pesoPorTipo[0]; /** @return retorna el peso de los granos para la subespecie: Arábica */
        }
        else if(tipo .equalsIgnoreCase("Catuaí")){
            return pesoPorTipo[1]; /** @return retorna el peso de los granos para la subespecie: Catuaí */
        }
        else if(tipo.equalsIgnoreCase("Caturra")){
            return pesoPorTipo[2]; /** @return retorna el peso de los granos para la subespecie: Caturra */
        }
        return 0; /** @return retorna 0 si no hay granos de niguna de las subespecies actualmente */
    }

    /**
    * Método que devuelve un entero, muestra al usuario la cantidad de granos por cada tamaño de grano de café
    */
    public int imprimirTamaños(String tipo){
        calcularPorTamaño();
        if(tipo.equalsIgnoreCase("pequeño")){
            return cantGranoPorTamaño[0];  /** @return retorna la cantidad de granos del tamaño: pequeño */
        }
        else if(tipo.equalsIgnoreCase("mediano")){
            return cantGranoPorTamaño[1]; /** @return retorna la cantidad de granos del tamaño: mediano */
        }
        else if(tipo.equalsIgnoreCase("grande")){
            return cantGranoPorTamaño[2]; /** @return retorna la cantidad de granos del tamaño: grande */
        }
        return 0; /** @return retorna 0 si no hay granos de niguna de las subespecies actualmente */
    }
    
    /**
    * Método que devuelve un entero, muestra al usuario la cantidad de granos según la categoría a la que pertenece el grano
    */
    
    public int imprimirPorCategoria(String tipo){ //devuelve la cantidad
        calcularPorCategoria();
        if(tipo.equalsIgnoreCase("Categoría 1")){
            return cantGranoPorCategoria[0]; /** @return retorna la cantidad de granos de la categoría de peso: categoría 1 */
        }
        else if(tipo.equalsIgnoreCase("Categoría 2")){
            return cantGranoPorCategoria[1]; /** @return retorna la cantidad de granos de la categoría de peso: categoría 2 */
        }
        else if(tipo.equalsIgnoreCase("Categoría 3")){ /** @return retorna la cantidad de granos de la categoría de peso: categoría 3 */
            return cantGranoPorCategoria[2];
        }
        return 0; /** @return retorna 0 si no hay granos de niguna de las subespecies actualmente */
    }

    /**
    * Método que devuelve un arreglo de enteros, retorna el peso en gramos de cada una de los tipos o subespecies de grano de café
    */
    public int[] getPesoPorTipo(){
        calcularPesoTipo();
        return pesoPorTipo; /** @return retorna el arreglo de enteros con el peso en gramos de cada tipo o subespecie*/
    }

    /**
    * Método que devuelve una hilera de texto con el nombre de este saco.
    */
    public String getNombreSaco(){
        return nombre; /** @return retorna el String con el nombre asignado al Saco*/
    }

    /**
    * Método que devuelve una arreglo de enteros la cantidad de granos por categoría.
    */
    public int[] getTamañoPorCategoria(){
        calcularPorTamaño();
        return cantGranoPorCategoria; /** @return retorna el arreglo de enteros que contiene la cantidad de granos de cada categoria*/
    }

    /**
    * Método que devuelve una arreglo de enteros la cantidad de granos por tipo / subespecie.
    */
    public int[] getCantidadPorTipo(){
        calcularPorTipo();
        return cantidadPorTipo; /**@return retorna el arreglo de enteros que contiene la cantidad de granos por subespecie */
    }

     /**
     * Método que devuelve una hilera de texto con el porcentaje correspondiente a la cantidad de grano por cada tipo / subespecie.
     */
    public String getPorcentajesCantidadGrano(){
        String respuesta="";
        respuesta += "Porcentaje por cantidad de grano arábica: " + porcentajesCantGrano[0] + "\n";
        respuesta += "Porcentaje por cantidad de grano catuaí: " + porcentajesCantGrano[1] + "\n";
        respuesta += "Porcentaje por cantidad de grano caturra: " + porcentajesCantGrano[2] + "\n";
        return respuesta; /**@return retorna una hilera con la cantidad en porcentajes por subespecie */
    }

    /**
    * Método que devuelve una Arraylist de tipo grano, con todos los granos de la canasta (Saco)
    */
    public ArrayList<Grano> getCanasta(){
        return this.canasta;
    }
    
    /**
     * Método que se encarga de mover los granos que cumplan con los filtros que desea el usuario, retorna un Arraylist con los granos escogidos.
     */
    public ArrayList moverGranos(String tamaño, String categoria, int peso, String subespecie){ //filtro de eleccion de granos para la canasta
        int contador = 0; //contador de indice granoDeCafe
        ArrayList <Grano> canasta = new ArrayList <Grano>();

        //mientras hayan suficientes granos y todavía falten  por seleccionar
        while(contador < granoDeCafe.size()){
            if (categoria != null && !categoria.equalsIgnoreCase("0")) { //1) se filtra por categoria

                if((granoDeCafe.get(contador).getCategoriaPeso()).equalsIgnoreCase(categoria)){ //2) si el grano cumple

                    if(tamaño != null && !tamaño.equalsIgnoreCase("0")){ //3) si el usuario deja en blanco o pone 0, no se ejecuta el código de seleccion por categoria, en cambio si introduce un dato, se ejecuta el filtro por categoria

                        if((granoDeCafe.get(contador).getTamañoGrano()).equalsIgnoreCase(tamaño)){ //4

                            if (subespecie != null && !subespecie.equalsIgnoreCase("0")){  //5) si el usuario deja en blanco o pone 0, no se ejecuta el código de seleccion por subespecie, en cambio si introduce un dato, se ejecuta el filtro por subespecie
                                if((granoDeCafe.get(contador).getTipoGrano()).equalsIgnoreCase(subespecie)){ //6) si el grano actual es pequeño
                                    canasta.add(granoDeCafe.get(contador)); //pasa el grano del saco original a la seleccion deseada
                                    granoDeCafe.remove(granoDeCafe.get(contador)); //elimina el grano del saco original.
                                }
                                else{//6 si el grano no cumple la subespecie deseada, avanza al siguiente grano del saco
                                    contador++;
                                }
                            }
                            else{//5) Si param subespecie == 0; es decir, que no se requiere filtrar entonces se agrega el grano sin importar su subespecie
                                canasta.add(granoDeCafe.get(contador)); //pasa el grano del saco original a la seleccion deseada
                                granoDeCafe.remove(granoDeCafe.get(contador)); //elimina el grano del saco original.
                            }
                        }
                        else{ //4) si el grano no cumple con el tamaño deseado, avanza al siguiente grano del saco
                            contador++;
                        }
                    }
                    else{ //3) SI EL TAMAÑO ES NULO
                        if (subespecie != null && !subespecie.equalsIgnoreCase("0")){  //3a) si el usuario deja en blanco o pone 0, no se ejecuta el código de seleccion por subespecie, en cambio si introduce un dato, se ejecuta el filtro por subespecie
                            if((granoDeCafe.get(contador).getTipoGrano()).equalsIgnoreCase(subespecie)){ //3b) si el grano actual es pequeño
                                canasta.add(granoDeCafe.get(contador)); //pasa el grano del saco original a la seleccion deseada
                                granoDeCafe.remove(granoDeCafe.get(contador)); //elimina el grano del saco original.
                            }
                            else{//3b  si el grano no cumple la subespecie deseada, avanza al siguiente grano del saco
                                contador++;
                            }
                        }
                        else {//3a Si param subespecie == 0; es decir, que no se requiere filtrar entonces se agrega el grano sin importar su subespecie
                            canasta.add(granoDeCafe.get(contador)); //pasa el grano del saco original a la seleccion deseada
                            granoDeCafe.remove(granoDeCafe.get(contador)); //elimina el grano del saco original.
                        }
                    }
                }
                else{ //2 si el grano no cumple la categoría deseada, avanza al siguiente grano del saco
                    contador++;
                }
            }
            else { //1) de arriba FILTRAR POR PESO Y NO POR CATEGORÍA
                if (peso != 0) { //1) se filtra por peso

                    if((granoDeCafe.get(contador).getPesoGrano()) >= (peso)){ //2 si el grano cumple

                        if(tamaño != null && !tamaño.equalsIgnoreCase("0")){ //3 si el usuario deja en blanco o pone 0, no se ejecuta el código de seleccion por categoria, en cambio si introduce un dato, se ejecuta el filtro por categoria

                            if((granoDeCafe.get(contador).getTamañoGrano()).equalsIgnoreCase(tamaño)){ //4

                                if (subespecie != null && !subespecie.equalsIgnoreCase("0")){//5 si el usuario deja en blanco o pone 0, no se ejecuta el código de seleccion por subespecie, en cambio si introduce un dato, se ejecuta el filtro por subespecie
                                    if((granoDeCafe.get(contador).getTipoGrano()).equalsIgnoreCase(subespecie)){//6 si el grano actual es pequeño
                                        canasta.add(granoDeCafe.get(contador)); //pasa el grano del saco original a la seleccion deseada
                                        granoDeCafe.remove(granoDeCafe.get(contador)); //elimina el grano del saco original.
                                    }
                                    //si no se cumple por subespecie
                                    else{//6
                                        contador++;
                                    }
                                }
                                else{//5
                                    canasta.add(granoDeCafe.get(contador)); //pasa el grano del saco original a la seleccion deseada
                                    granoDeCafe.remove(granoDeCafe.get(contador)); //elimina el grano del saco original.
                                }
                            }
                            else{ //4) si el grano no cumple con el tamaño deseado, avanza al siguiente grano del saco
                                contador++;
                            }
                        }
                        else{ //3) Si no desea filtrar tamaño
                            if (subespecie != null && !subespecie.equalsIgnoreCase("0")){  //3a) si el usuario deja en blanco o pone 0, no se ejecuta el código de seleccion por subespecie, en cambio si introduce un dato, se ejecuta el filtro por subespecie
                                if((granoDeCafe.get(contador).getTipoGrano()).equalsIgnoreCase(subespecie)){ //3b) si el grano actual es pequeño
                                    canasta.add(granoDeCafe.get(contador)); //pasa el grano del saco original a la seleccion deseada
                                    granoDeCafe.remove(granoDeCafe.get(contador)); //elimina el grano del saco original.
                                }
                                else{//3b  si el grano no cumple la subespecie deseada, avanza al siguiente grano del saco
                                    contador++;
                                }
                            }
                            else {//3a Si param subespecie == 0; es decir, que no se requiere filtrar entonces se agrega el grano sin importar su subespecie
                                canasta.add(granoDeCafe.get(contador)); //pasa el grano del saco original a la seleccion deseada
                                granoDeCafe.remove(granoDeCafe.get(contador)); //elimina el grano del saco original.
                            }
                        }
                    }
                    else{//2 si el grano no cumple con el peso deseado, avanza de grano en el saco.
                        contador++;
                    }
                }
                //1 de arriba
                else{//SI NO IMPORTA EL PESO O LA CATEGORÍA
                    if(tamaño != null && !tamaño.equalsIgnoreCase("0")){ //1 si el usuario deja en blanco o pone 0, no se ejecuta el código de seleccion por categoria, en cambio si introduce un dato, se ejecuta el filtro por categoria

                        if((granoDeCafe.get(contador).getTamañoGrano()).equalsIgnoreCase(tamaño)){ //2

                            if (subespecie != null && !subespecie.equalsIgnoreCase("0")){//3 si el usuario deja en blanco o pone 0, no se ejecuta el código de seleccion por subespecie, en cambio si introduce un dato, se ejecuta el filtro por subespecie
                                if((granoDeCafe.get(contador).getTipoGrano()).equalsIgnoreCase(subespecie)){//4 si el grano actual es pequeño
                                    canasta.add(granoDeCafe.get(contador)); //pasa el grano del saco original a la seleccion deseada
                                    granoDeCafe.remove(granoDeCafe.get(contador)); //elimina el grano del saco original.
                                }
                                //si no se cumple por subespecie
                                else{//4
                                    contador++;
                                }
                            }
                            else{//3
                                canasta.add(granoDeCafe.get(contador)); //pasa el grano del saco original a la seleccion deseada
                                granoDeCafe.remove(granoDeCafe.get(contador)); //elimina el grano del saco original.
                            }
                        }
                        else{ //2) si el grano no cumple con el tamaño deseado, avanza al siguiente grano del saco
                            contador++;
                        }
                    }

                    else{ //1) Si no desea filtrar tamaño
                        if(subespecie != null && !subespecie.equalsIgnoreCase("0")){  //1a) si el usuario deja en blanco o pone 0, no se ejecuta el código de seleccion por subespecie, en cambio si introduce un dato, se ejecuta el filtro por subespecie
                            if((granoDeCafe.get(contador).getTipoGrano()).equalsIgnoreCase(subespecie)){ //1b) si el grano actual es pequeño
                                canasta.add(granoDeCafe.get(contador)); //pasa el grano del saco original a la seleccion deseada
                                granoDeCafe.remove(granoDeCafe.get(contador)); //elimina el grano del saco original.
                            }
                            else{//1b  si el grano no cumple la subespecie deseada, avanza al siguiente grano del saco
                                contador++;
                            }
                        }
                        else {//1a Si param subespecie == 0; es decir, que no se requiere filtrar entonces se agrega el grano sin importar su subespecie
                            canasta.add(granoDeCafe.get(contador)); //pasa el grano del saco original a la seleccion deseada
                            granoDeCafe.remove(granoDeCafe.get(contador)); //elimina el grano del saco original.
                        }
                    }
                }
            }
        } //se termina while
        return canasta; /** @return devuelve ArrayList de tipo grano, que contiene los granos seleccionados */
    }//termina el metodo

    /**
    * Método toString que devuelve una hilera con los datos principales del saco.
    */
    public String toString(){
        String respuesta="";
        respuesta += "Nombre: " + nombre + "\n";
        respuesta += "Cantidad de granos de arábica: " + imprimirCantidadPorTipo("Arábica") + "\n";
        respuesta += "Cantidad de granos de catuaí: " + imprimirCantidadPorTipo("Catuaí") + "\n";
        respuesta += "Cantidad de granos de caturra: " + imprimirCantidadPorTipo("Caturra") + "\n";
        respuesta += "Peso del saco: " + pesoSaco + "g\n";
        respuesta += "Cantidad de granos totales: " + granoDeCafe.size() + "\n";
        return respuesta; /**@return Retorna una hilera con los datos principales del saco.*/
    }
}
