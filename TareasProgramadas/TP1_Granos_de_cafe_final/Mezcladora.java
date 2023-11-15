import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Esta clase se encarga de definir las mezclas, mover granos filtrados desde el o los sacos hacia una canasta(selección),
 * elegir la mezcla a producir, comprobar que se pueda hacer la mezcla seleccionada, guardarla en Stock y
 * además mostrar las que ya se han producido.
 * @author: Zurisadai Granados Montoya carné B53177, Fabián Orozco Chaves carné B95690.
 * @version: 14/05/2020/
 */
public class Mezcladora
{
    //Campos de clase
    private ArrayList <Saco> saco; //permite manejar inventario
    private ArrayList <Mezcla> mezcla; //permite definir y guardar mezclas
    private ArrayList <Grano> canastaMezcladora; //permite almacenar los granos filtrados por el usuario
    private Mezcla mezclaSeleccionada; //Almacena la receta/mezcla que acaba de escoger el usuario
    private double[] porcentajesPesoGrano; //vector que contiene el porcentaje de peso por subespecie.
    private int[] pesoPorTipo; //t3: contiene el peso de cada subespecie en orden: arábica, catuai, caturra. en la canasta mezcladora
    private int pesoCanastaMezcladora; //Se utiliza para almacenar el peso en gramos, de los granos actualmente en la canasta mezcladora.
    private ArrayList <String> stock = new ArrayList <String>(); //contiene el nombre y el peso de cada mezcla creada.
    private String sacoSeleccionado; //String que contiene el nombre del saco seleccionado.
    private int contSacos; //contador que sirve como indice para recorrer el ArrayList saco.
    /**
     * Método constructor de la Clase Mezcladora que se encarga de llamar y gestionar los métodos y crear instancias de las Clases Grano, Saco, Mezcla.
     * No recibe parámetros. Contiene el método static main, principal, que controla el flujo del programa.
     */
    public Mezcladora()
    {
        porcentajesPesoGrano = new double[3]; //asigna el espacio requerido para el vector porcentajesPesoGrano.
        pesoPorTipo = new int[3]; //Asigna el espacio requerido al vector pesoPorTipo.
        mezcla = new ArrayList <Mezcla>(); //Asigna una cantidad inicial de mezclas, al Arraylist
        canastaMezcladora = new ArrayList <Grano>();
        saco = new ArrayList <Saco> ();
        mezclaSeleccionada = null;
        contSacos=1;
    } //cierre del constructor

    /**
     * Método que se encarga de crear nuevos sacos, el usuario puede volver a llamar a este método para agregar aún más sacos.
     * Este método no retorna datos.
     */
    public void creeSacos(){
        int cantidadSacos = Integer.parseInt(JOptionPane.showInputDialog(null,"Defina la cantidad de sacos para crear","Sacos",JOptionPane.QUESTION_MESSAGE));
        for (int i = 0; i < cantidadSacos; i++){ //crea sacos utilizando el constructor de la Clase Saco. A cada saco le da un nombre genérico sucesivo.
            saco.add(new Saco("Saco "+contSacos));
            contSacos++; //aumenta el contador para que el próximo saco creado tenga un número mayor y sucesivo en el nombre
        }
    }

    /**
     * Método que cálcula el peso total en gramos por subespecie de la canasta mezcladora.
     * Crea variables temporales por subespecie que van guardando el peso de cada grano correspondiente a la subespecie.
     * Asigna el valor de las variables al vector pesoPorTipo para que contenga en cada celda el peso de cada subespecie en orden: 0: arábica, 1: catuaí, 2: caturra.
     */
    public void calcularPesoTipo(){
        int temporalArabica = 0;
        int temporalCatuai = 0;
        int temporalCaturra = 0;
        for(int i = 0; i < canastaMezcladora.size(); i++){
            if(canastaMezcladora.get(i).getTipoGrano().equalsIgnoreCase("Arábica")){
                temporalArabica += canastaMezcladora.get(i).getPesoGrano();
            }
            if(canastaMezcladora.get(i).getTipoGrano().equalsIgnoreCase("Catuaí")){
                temporalCatuai+= canastaMezcladora.get(i).getPesoGrano();
            }
            if(canastaMezcladora.get(i).getTipoGrano().equalsIgnoreCase("Caturra")){
                temporalCaturra += canastaMezcladora.get(i).getPesoGrano();
            }
        }
        pesoPorTipo[0] = temporalArabica;
        pesoPorTipo[1] = temporalCatuai;
        pesoPorTipo[2] = temporalCaturra;
    }

    /**
     * Método llama al método calcularPesoTipo() y luego muestra el porcentaje que representa el peso de cada grano comparado con el total de gramos en canasta.
     */
    public double[] porcentajesPesoGrano(){
        calcularPesoTipo();
        porcentajesPesoGrano[0] =  ((pesoPorTipo[0] * 100.0) / (pesoCanastaMezcladora));
        porcentajesPesoGrano[1] =  ((pesoPorTipo[1] * 100.0) / (pesoCanastaMezcladora));
        porcentajesPesoGrano[2] =  ((pesoPorTipo[2] * 100.0) / (pesoCanastaMezcladora));
        return porcentajesPesoGrano; /** @return retorna el array que contiene los porcentajes de peso por subespecie de grano */
    }

    /**
     * Método que se encarga de solicitar al usuario los datos para crear una nueva receta/mezcla
     * y la guarda en el array que contiene todas las mezclas que se crean
     **/
    public void definaMezclas(){
        String nombre = JOptionPane.showInputDialog(null,"Defina un nombre con el que desea guardar esta mezcla","Mezcla",JOptionPane.QUESTION_MESSAGE);
        int porcentajeArabica = Integer.parseInt(JOptionPane.showInputDialog(null,"Introduzca el porcentaje del peso en gramos de la subespecie arábica necesarios para producir "+ nombre +"\n\nPor ejemplo: se introduce 30 cuando se requiere que 30% del peso total sea en granos arábica","Arábica",JOptionPane.QUESTION_MESSAGE));
        int porcentajeCatuai = Integer.parseInt(JOptionPane.showInputDialog(null,"Introduzca el porcentaje del peso en gramos de la subespecie catuaí necesarios para producir "+ nombre + "\n\nPor ejemplo: se introduce 0 cuando se requiere que 0% del peso total sea en granos catuaí","Catuaí",JOptionPane.QUESTION_MESSAGE));
        int porcentajeCaturra = Integer.parseInt(JOptionPane.showInputDialog(null,"Introduzca el porcentaje del peso en gramos de la subespecie caturra necesarios para producir "+ nombre + "\n\nPor ejemplo: se introduce 70 cuando se requiere que 70% del peso total sea en granos caturra","Caturra",JOptionPane.QUESTION_MESSAGE));
        int kilos = Integer.parseInt(JOptionPane.showInputDialog(null,"Introduzca la cantidad de kilos que se generan con la proporción anteriormente definida","Kilos de la mezcla",JOptionPane.QUESTION_MESSAGE));
        mezcla.add(new Mezcla(nombre,porcentajeArabica,porcentajeCatuai,porcentajeCaturra,kilos)); //guarda una mezcla en el arraylist con los datos asignados anteriormente.
    }
    
    
    /**
     * Método que verifica si el usuario ha guardado al menos una receta o mezcla. Si lo anterior es cierto, entonces se muestra
     * al usuario todas las recetas/mezclas almacenadas. En caso contrario se le notifica al usuario que aun no hay mezclas guardadas y por lo tanto no se puede imprimir en consola.
     * El método no retorna datos.
     */
    public void muestreMezclasGuardadas(){
        if(mezcla.size() != 0){
            System.out.println("Recetas guardadas:\n");
            for(Mezcla m : mezcla){ //recorre todas las mezclas definidas por el usuario.
                System.out.println(m.toStringReducido() + "\n");
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"No hay mezclas definidas.\nPrimero debe definir una mezcla","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Método que no recibe parámetros que se encarga de mostrarle al usuario cuales recetas están guardadas
     * y le permite al usuario elegir una receta/mezcla la cual se guarda en mezclaSeleccionada.
     */
    public void elijaMezcla(){
        if(mezcla.size() != 0){
            String opcion = JOptionPane.showInputDialog(null,"Introduzca el nombre de la mezcla/receta que desea elegir para producir: ","Nombre de la mezcla",JOptionPane.QUESTION_MESSAGE);
            for(int a = 0 ; a < mezcla.size() ; a++){ //recorre las mezclas definidas por el usuario.
                if(mezcla.get(a).getNombre().equalsIgnoreCase(opcion)){ //compara si el nombre introducido por el usuario coincide con una mezcla ya definida.
                    this.mezclaSeleccionada = mezcla.get(a); //si el nombre coincide, entonces la asigna a mezclaSeleccionada(atributo).
                    System.out.println("Ha elegido:\n" + mezclaSeleccionada.getNombre());
                }
                else{
                    JOptionPane.showMessageDialog(null,"No se encontró una mezcla con el nombre introducido.\nVerifique que no introdujo un caractér extraño, espacios de más o dejó el campo vació","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    /**
     * Método que no recibe parámetros que se encarga de imprimir solamente la receta/mezcla que ya se definió y seleccionó con anterioridad.
     */
    public void muestreMezclaSeleccionada(){
        System.out.println(mezclaSeleccionada.toString());
    }

    /**
     * Método que no recibe parámetros que se encarga de mostrarle al usuario todos los granos que se encuentren en canastaMezcladora(selección).
     */
    public void muestreCanasta(){
        System.out.println("Canasta mezcladora:\n");
        for(Grano s : canastaMezcladora){ //recorre la canastaMezcladora(selección).
            System.out.println(s.toString()); //imprime cada grano dentro de ella.
        }
        System.out.println("Cantidad total de granos en canasta mezcladora: " + canastaMezcladora.size() + "\n");
    }

    /**
     * Método que pregunta al usuario con cual de los sacos desea trabajar. Este saco elegido se utiliza para pedir/filtrar granos
     */
    public void seleccioneSaco(){
        String nombreSaco = JOptionPane.showInputDialog(null,"Por favor introduzca el nombre del saco del que desea escoger granos","Saco",JOptionPane.QUESTION_MESSAGE);
        for(int h = 0 ; h < saco.size() ; h++){
            if(saco.get(h).getNombreSaco().equalsIgnoreCase(""+nombreSaco)){
                System.out.println("Saco seleccionado:\n\n"+
                    saco.get(h).toString());
                sacoSeleccionado = nombreSaco;
            }
        }
    }
    
    /**
     * Este método se utiliza para saber si el usuario ha creado sacos o no. En caso que se hayan definido 
     * sacos con anterioridad, entonces se devuelve un true, caso contrario un false.
     */
    public boolean sacosCreados(){
        if (saco.size() != 0 ){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Método que muestra al usuario todos los sacos con un pequeño resumen de sus características y contenido.
     */
    public void muestreSacos(){
        for(Saco s : saco){
            System.out.println(s.toString());
        }
    }

    /**
     * Toma granos de los sacos de café, según filtros que elija el usuario. Y le muestra el nuevo estado de canastaMezcladora.
     */
    public void pedirGranosParaLaCanasta(){ //Indice del Saco elegido por el usuario
        if(sacoSeleccionado != null){
            int contador = 0;
            for(Saco s : saco){ //recorre todos los sacos
                if(s.getNombreSaco().equalsIgnoreCase(sacoSeleccionado)){ //compara los nombres de los sacos de la clase con el seleccionado
                    contador = saco.indexOf(s); //asigna a contador, el número de celda en que se encuentra el saco seleccionado.
                }
            }

            ArrayList <Grano> canastaPreMezcladora = new ArrayList <Grano>();

            String tamañoSolicitado = JOptionPane.showInputDialog(null,"Por favor introduzca el tamaño del grano que desea escoger\nDisponibles: pequeño, mediano o grande\n\nSi no desea filtrar por tamaño digite un 0","Filtro por tamaño",JOptionPane.QUESTION_MESSAGE);
            String categoriaSolicitada = JOptionPane.showInputDialog(null,"¿Desea elegir el grano según su Categoría de Peso?\nDisponibles: categoría 1(5g o 6g), categoría 2(7g o 8g) o categoría 3(9g o 10g)\n\nEn caso de que quiera elegir el grano por su peso en gramos, por favor introduzca un 0","Filtro por categoría",JOptionPane.QUESTION_MESSAGE);
            int pesoSolicitado = 0;

            if(categoriaSolicitada.equals("0") || categoriaSolicitada == null){ //si no deciden filtrar por categoría se da la oportunidad de filtrar por peso.
                pesoSolicitado = Integer.parseInt(JOptionPane.showInputDialog(null,"Introduzca el peso mínimo en gramos del grano que desea\nDisponibles: 5, 6, 7, 8, 9, 10\n\nSi no desea filtrar por peso digite un 0","Filtro por peso",JOptionPane.QUESTION_MESSAGE));
            }
            String subespecieSolicitada = JOptionPane.showInputDialog(null,"Introduzca el nombre de la subespecie de café a elegir\nDisponibles: arábica, catuaí, caturra\n\nSi no desea filtrar por subespecie digite un 0","Filtro por subespecie",JOptionPane.QUESTION_MESSAGE);

            canastaPreMezcladora = (saco.get(contador).moverGranos(tamañoSolicitado, categoriaSolicitada, pesoSolicitado, subespecieSolicitada));
            canastaMezcladora.addAll(canastaPreMezcladora);
        }
        else{
            JOptionPane.showMessageDialog(null,"No se ha seleccionado un saco.\nVerifique que haya creado sacos y seleccionado uno","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Este método llama al método calcularPesoTipo para obtener los datos de los granos que estén contenidos 
     * en la canasta (la canasta contiene los granos que escoja el usuario) y los imprime en consola.
     */
    public void datosCanasta(){
        calcularPesoTipo(); //calcula el peso en gramos por cada subespecie en canastaMezcladora en orden: 0:arábica, 1:catuai, 2:caturra.
        pesoCanastaMezcladora = pesoPorTipo[0] + pesoPorTipo[1] + pesoPorTipo[2]; //asigna a pesoCanastaMezcladora(atributo), el peso total en gramos de la canastaMezcladora(selección).

        porcentajesPesoGrano(); //calcula el porcentaje del peso en gramos por cada subespecie en canastaMezcladora en orden: 0:arábica, 1:catuai, 2:caturra.
        double porcentajeTotal = porcentajesPesoGrano[0] + porcentajesPesoGrano[1] + porcentajesPesoGrano[2]; //asigna a pesoCanastaMezcladora(atributo), el peso total en gramos de la canastaMezcladora(selección).
        System.out.println("Selección:\n");

        System.out.println("Peso arábica: " + pesoPorTipo[0] + "g, lo que equivale al " + porcentajesPesoGrano[0] + "% de la selección");
        System.out.println("Peso catuaí: " + pesoPorTipo[1] + "g, lo que equivale al " + porcentajesPesoGrano[1] + "% de la selección");
        System.out.println("Peso caturra: " + pesoPorTipo[2] + "g, lo que equivale al " + porcentajesPesoGrano[2] + "% de la selección");
        System.out.println("Total canasta: " +pesoCanastaMezcladora + "g, lo que equivale al " + porcentajeTotal + "% de la selección\n");
    }

    /**
     * Método que devuelve un boolean dependiendo de si se puede realizar la mezcla
     * con los granos que el usuario ha seleccionado hasta el momento(canastaMezcladora)
     * y la mezcla/receta que también seleccionó(mezclaSeleccionada).
     * También se ejecuta un cálculo para decirle al usuario un aproximado del mínimo de
     * veces que puede repetir esta receta con los granos que actualmente hayan en la canastaMezcladora(selección).
     */
    public boolean SePuedeHacerMezcla(){ //se invoca cuando el usuario tiene seleccionada una mezcla/receta.
        boolean sePuedeHacerMezcla = false;
        if(mezclaSeleccionada != null){
            int temporalA = mezclaSeleccionada.getPesoRequerido(0); //se asigna a temporalA el valor peso requerido en gramos de subespecie arábica para producir la mezclaSeleccionada
            int temporalC = mezclaSeleccionada.getPesoRequerido(1); //se asigna a temporalC el valor peso requerido en gramos de subespecie catuaí para producir la mezclaSeleccionada
            int temporalCR = mezclaSeleccionada.getPesoRequerido(2); //se asigna a temporalCR el valor peso requerido en gramos de subespecie caturra para producir la mezclaSeleccionada

            if(mezclaSeleccionada != null){
                sePuedeHacerMezcla = true;
            }
            if(sePuedeHacerMezcla){
                if(pesoPorTipo[0] >= temporalA){ //1) si se tiene lo suficiente de arábica
                    if(pesoPorTipo[1] >= temporalC){ //2) si se tiene lo suficiente de catuai
                        if(pesoPorTipo[2] >= temporalCR){ //3) si se tiene lo suficiente de caturra
                            //sePuedeHacerMezcla ya es true.
                        }
                        else{//3 se tiene suficiente catuai y arábica pero no caturra.
                            sePuedeHacerMezcla = false;
                        }
                    }
                    else{//2 se tiene suficiente arábica, pero no catuai se cae
                        sePuedeHacerMezcla = false;
                    }
                }
                else{//1 si no se tiene lo suficiente de arábica
                    sePuedeHacerMezcla = false;
                }
            }
            return sePuedeHacerMezcla;
        }
        else{
            return sePuedeHacerMezcla;
        }
    }
    
    /**
     * Este método realiza el cálculo de las veces que es pposible realizar el método hagaMezcla() 
     * y la cantidad de kilos de mezcla que se podrían generar según la receta/mezcla seleccionada
     */
    public void kilosMaximos(){
        int[] contVecesPosibles = new int[3]; //contador para las veces que se podria hacer la mezcla según cada subespecie.
        int temporalA = mezclaSeleccionada.getPesoRequerido(0); //se asigna a temporalA el valor peso requerido en gramos de subespecie arábica para producir la mezclaSeleccionada
        int temporalC = mezclaSeleccionada.getPesoRequerido(1); //se asigna a temporalC el valor peso requerido en gramos de subespecie catuaí para producir la mezclaSeleccionada
        int temporalCR = mezclaSeleccionada.getPesoRequerido(2); //se asigna a temporalCR el valor peso requerido en gramos de subespecie caturra para producir la mezclaSeleccionada

        if (temporalA > 0){ //1) si se requiere arábica
            contVecesPosibles[0] = (pesoPorTipo[0] / temporalA);
            if (temporalC > 0){ //2) si se ocupa catuai
                contVecesPosibles[1] = (pesoPorTipo[1] / temporalC);
                if(temporalCR > 0){ //3) si se ocupa caturra
                    contVecesPosibles[2] = (pesoPorTipo[2] / temporalCR);
                }
                else{//3) no se ocupa caturra
                    contVecesPosibles[2] = -1;
                }
            }
            else{ //2) no se ocupa catuai
                contVecesPosibles[1] = -1;
                if(temporalCR > 0){ //3) si se ocupa caturra
                    contVecesPosibles[2] = (pesoPorTipo[2] / temporalCR);
                }
                else{//3) no se ocupa caturra
                    contVecesPosibles[2] = -1;
                }
            }
        }
        else{ //1) no se ocupa arábica
            contVecesPosibles[0] = -1;
            if (temporalC > 0){ //2) si se ocupa catuai
                contVecesPosibles[1] = (pesoPorTipo[1] / temporalC);
                if(temporalCR > 0){ //3) si se ocupa caturra
                    contVecesPosibles[2] = (pesoPorTipo[2] / temporalCR);
                }
                else{ //3) no se ocupa caturra
                    contVecesPosibles[2] = -1;
                }
            }
            else{ //2) no se ocupa catuai
                contVecesPosibles[1] = -1;
                if(temporalCR > 0){ //3) si se ocupa caturra
                    contVecesPosibles[2] = (pesoPorTipo[2] / temporalCR);
                }
                else{ //3) no se ocupa caturra
                    contVecesPosibles[2] = -1;
                }
            }
        }

        int[] seRequiere = new int[3]; //vector tipo int que contiene las subespecies que se requieren para producir la mezclaSeleccionada.Puede estar o no estar lleno.
        for(int f = 0 ; f < seRequiere.length ; f++){ //recorre el vector seRequiere
            seRequiere[f] = 0; //llena cada celda del vector seRequiere con ceros
        }

        int contador=0; //contador para avanzar cuando se asigna al vector seRequiere que se requiere una subespecie para producir la mezclaSeleccionada.
        for(int f = 0 ; f < contVecesPosibles.length ; f++){ //recorre el vector contVecesPosibles para verificar si una subespecie se requiere o no para producir la mezclaSeleccionada.
            if(contVecesPosibles[f] != -1){ //significa: si una subespecie se requiere
                seRequiere[contador] = contVecesPosibles[f]; //asigna a vector seRequiere la cantidad de veces posibles de una subespecie, si esta se requiere.
                contador++; //aumenta el contador de seRequiere para el futuro. Funciona para el caso de que haya otra subespecie requerida.
            }
        }

        int minimo = seRequiere[0]; //toma un supuesto como el mínimo valor del vector seRequiere
        for(int f = 0 ; f < seRequiere.length ; f++){ //recorre el vector seRequiere
            if(seRequiere[f] != 0 && seRequiere[f] < minimo){ //si encuentra un número menor y además es diferente de 0
                minimo = seRequiere[f]; //se asigna a mínimo ese valor. El cual serviría como el lá máxima cantidad de veces que se puede producir
            }                           //la mezclaSeleccionada.
        }
        System.out.println("La mezcla se puede producir " + (minimo) +
            " veces con los granos que están en la canasta de selección\nEn total se puede producir " + (minimo * mezclaSeleccionada.getPesoMezcla()) + "KG de " + mezclaSeleccionada.getNombre() + "\n");
    }

    /**
     * Método que realiza la mezcla / receta si se cumplen las condiciones.
     * Crea los kilos de mezcla según la receta y las guarda en Stock.
     * Al crearse la mezcla los grnaos dejan de "existir" en la canastaMezcladora.
     */
    public void hagaMezcla(){
        int[] pesoAcumulado = new int[3];  //vector de tipo int que contiene el peso en gramos de cada subespecie en orden: 0:arábica, 1:catuaí, 2:caturra.
        if(mezclaSeleccionada.getPesoRequerido(0) != 0){ //si se requiere arábica
            for(int grano = 0; pesoAcumulado[0] <= mezclaSeleccionada.getPesoRequerido(0) ;grano++){ //recorre los granos de la canastaMezcladora
                if(canastaMezcladora.get(grano).getTipoGrano().equalsIgnoreCase("Arábica")){ //compara que sean de la subespecie arábica
                    pesoAcumulado[0] += canastaMezcladora.get(grano).getPesoGrano(); //aumenta el peso de la subespecie arábica que se va produciendo.
                    canastaMezcladora.remove(grano); //remueve el grano de la canastaMezcladora, ya que este se encuentra en mezclado.
                    grano--; //si el grano encontrado se removió entonces se debe de comparar por esa misma celda en el próximo recorrido del for.
                }
            }
        }

        if(mezclaSeleccionada.getPesoRequerido(1) != 0){ //si se requiere catuaí
            for(int grano = 0; pesoAcumulado[1] <= mezclaSeleccionada.getPesoRequerido(1) ;grano++){ //recorre los granos de la canastaMezcladora
                if(canastaMezcladora.get(grano).getTipoGrano().equalsIgnoreCase("Catuaí")){ //compara que sean de la subespecie catuaí
                    pesoAcumulado[1] += canastaMezcladora.get(grano).getPesoGrano(); //aumenta el peso de la subespecie catuaí que se va produciendo.
                    canastaMezcladora.remove(grano); //remueve el grano de la canastaMezcladora, ya que este se encuentra mezclado.
                    grano--;//si el grano encontrado se removió entonces se debe de comparar por esa misma celda en el próximo recorrido del for.
                }
            }
        }

        if(mezclaSeleccionada.getPesoRequerido(2) != 0){ //si se requiere caturra
            for(int grano = 0; pesoAcumulado[2] <= mezclaSeleccionada.getPesoRequerido(2) ;grano++){ //recorre los granos de la canastaMezcladora
                if(canastaMezcladora.get(grano).getTipoGrano().equalsIgnoreCase("Caturra")){ //compara que sean de la subespecie caturra
                    pesoAcumulado[2] += canastaMezcladora.get(grano).getPesoGrano(); //aumenta el peso de la subespecie caturra que se va produciendo.
                    canastaMezcladora.remove(grano); //remueve el grano de la canastaMezcladora, ya que este se encuentra mezclado.
                    grano--; //si el grano encontrado se removió entonces se debe de comparar por esa misma celda en el próximo recorrido del for.
                }
            }
        }
        stock.add(mezclaSeleccionada.getPesoMezcla() + "KG de " + mezclaSeleccionada.getNombre());
        System.out.println("Se creó la mezcla " + mezclaSeleccionada.getNombre() + " y se guardó en el stock\n");
    }

    /**
     * Método que imprime al usuario todas las hileras que se encuentre en el Stock, muestra todos los kilos de mezcla que hay en Stock.
     */
    public void muestreStock(){
        if(stock.size() != 0){
            System.out.println("Stock:");
            for(String mezcla : stock){
                System.out.println(mezcla);
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"No se han producido mezclas.\nNo hay nada en stock","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Método static main que controla el menú de opciones presentado al usuario y el flujo general del programa.
     */
    public static void main(String a[]){
        Mezcladora m1 = new Mezcladora();
        String menu = "En el recuadro de abajo digite el número de la opción que desea activar " +
            "\n\n1.Agregar sacos\n2.Definir mezcla\n3.Mostrar mezclas definidas\n4.Elegir una mezcla\n5.Ver sacos" +
            "\n6.Elegir saco\n7.Seleccionar granos\n8.Ver selección\n9.Capacidad de producción de la mezcla seleccionada"
            +"\n10.Producir la mezcla seleccionada una vez\n11.Ver Stock\n12.Terminar";

        int opcion = 0;
        do{
            try{
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,menu,"Menú",JOptionPane.QUESTION_MESSAGE));
                switch(opcion){
                    case 1: //Si se escoge la opción 1, se ejecuta crea un objeto mezcladora
                    m1.creeSacos();
                    break;

                    case 2: //Si se escoge la opción 2, se ejecuta el código para definir la mezcla. 
                    m1.definaMezclas();
                    break;

                    case 3: //Si se escoge la opción 3, se ejecuta el código para mostrar las mezclas ya definidas. 
                    m1.muestreMezclasGuardadas();
                    break;

                    case 4: //Si se escoge la opción 4, se ejecuta el código para elegir una mezcla definida.
                    m1.elijaMezcla();
                    break;

                    case 5: //Si se escoge la opción 5, se ejecuta el código para ver todos los sacos creados.
                    if(m1.sacosCreados()){
                        m1.muestreSacos();
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"No se encontraron sacos.\nVerifique que haya creado sacos","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                    case 6://Si se escoge la opción 6, se ejecuta el código para seleccionar un saco creado.
                    if(m1.sacosCreados()){
                        m1.seleccioneSaco();
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"No se encontraron sacos.\nVerifique que haya creado sacos","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                    case 7: //Si se escoge la opción 7, se ejecuta el código para filtrar los granos deseados.
                    m1.pedirGranosParaLaCanasta();
                    break;

                    case 8: //Si se escoge la opción 8, se ejecuta el código para ver la seleccion.
                    m1.datosCanasta();
                    break;

                    case 9: //Si se escoge la opción 9, se ejecuta el código para ver la capacidad de producción de la mezcla seleccionada.
                    if(m1.SePuedeHacerMezcla()){
                        m1.kilosMaximos();
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"No se puede producir la mezcla.\nVerifique que ha seleccionado una receta y que hay suficientes granos en la selección","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                    case 10: //Si se escoge la opción 10, se ejecuta el código para producir/ejecutar la mezcla.
                    if(m1.SePuedeHacerMezcla()){
                        m1.hagaMezcla();
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"No se puede producir la mezcla.\nVerifique que ha seleccionado una receta y que hay suficientes granos en la selección","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                    case 11: //Si se escoge la opción 11, se ejecuta el código para ver el stock(mezclas producidas).
                    m1.muestreStock();
                    break;

                    default: //Si se elige otra opción no se ejecuta nada, dependiendo del valor de opción.
                }
            }
            catch(NumberFormatException m){JOptionPane.showMessageDialog(null,"Ingrese un valor númerico","Error",JOptionPane.ERROR_MESSAGE);
            }
        }while(opcion!=12); //la opción 12 del menú, termina el programa
    }
}