/**
 * La Clase Mezcla contiene las características necesarias para crear una mezcla de café con diversas subespecies de granos de café.
 * @author: Zurisadai Granados Montoya carné B53177, Fabián Orozco Chaves carné B95690.
 * @version: 14/05/2020/
 */

public class Mezcla
{
    private String nombre; //String nombre de la mezcla
    private int[] cantPorcentajeMezcla; //Vector de tipo int que contiene en cada celda la cantidad en porcentaje de cada subespecie(0:arábica),(1:catuaí),(2:caturra)
    private int[] pesoRequerido; //Vector de tipo int que contiene en cada celda el peso en gramos de cada subespecie según el porcentaje(0:arábica),(1:catuaí),(2:caturra)
    private int pesoMezcla; //int que contiene el peso total en kilos de la mezcla
    
    /**
    * Constructor de la Clase Mezcla, recibe 5 parámetros.
    * Inicializa atributos de la clase y almacena otros tipos de información necesarias para ejecutar los métodos de clase.
    *@param nombre String que se usa para asignarle un nombre a esta receta / mezcla
    *@param porcentajeArabiga Entero que se contiene la proporción de granos arábica que debe usarse en esta receta / mezcla
    *@param porcentajeCatuai Entero que se contiene la proporción de granos catuaí que debe usarse en esta receta / mezcla
    *@param porcentajeCaturra Entero que se contiene la proporción de granos caturra que debe usarse en esta receta / mezcla
    *@param kilos Entero que dice la cantidad de kilos de café que se producen al utilizar esta receta / mezcla.
    */
    public Mezcla(String nombre, int porcentajeArabiga, int porcentajeCatuai, int porcentajeCaturra, int kilos)
    {
        this.nombre = nombre;
        pesoMezcla = kilos;

        cantPorcentajeMezcla = new int[3];
        cantPorcentajeMezcla[0] = porcentajeArabiga;
        cantPorcentajeMezcla[1] = porcentajeCatuai;
        cantPorcentajeMezcla[2] = porcentajeCaturra;

        pesoRequerido = new int[3];
        pesoRequerido [0] = (int)( ((porcentajeArabiga / 100.0) * pesoMezcla) *   (1000));
        pesoRequerido [1] = (int)( ((porcentajeCatuai / 100.0) * pesoMezcla) *   (1000));
        pesoRequerido [2] = (int)( ((porcentajeCaturra / 100.0) * pesoMezcla) *   (1000));
    }

    /**
    * Método que devuelve el nombre con el que se creó esta receta / mezcla
    */
    public String getNombre(){
        return nombre;  /** @return retorna un String que contiene el nombre de la receta / mezcla */
    }

/**
* Método que devuelve un vector con el peso en granos, que se necesita para crear esta receta, cada indice del vector contiene el peso necesario por separado de una de las subespecies
* @param indiceVector parámetro de tipo entero que especifíca cual peso se desea devolver. 1 = Arábica 2 = Catuaí 3 = Caturra
*/
    public int getPesoRequerido(int indiceVector){
        return pesoRequerido[indiceVector]; /** @return Retorna un entero con el peso en gramos según el parámetro introducido de tipo entero(0:arábica, 1: catuaí,2: caturra) */ 
    }

    /**
    * Método que retorna el peso en kilos, que se generan al realizar esta receta / mezcla.
    */
    public int getPesoMezcla(){
        return pesoMezcla; /** @return retorna un entero con el peso de la mezcla */
    }
    
    /**
    * Método toString que se usa para imprimir el estado del objeto de esta clase.
    */
    public String toString(){
        String respuesta = "";
        respuesta += "Nombre: " + nombre + "\n" +
        "Peso: " + pesoMezcla + " kilogramos \n" +
        "Porcentaje de grano Arábica: " + cantPorcentajeMezcla[0] + "% \n" +
        "Porcentaje de grano Catuaí: " + cantPorcentajeMezcla[1] + "% \n"+
        "Porcentaje de grano Caturra: " + cantPorcentajeMezcla[2] + "% \n" +

        "Se ocupan: " + pesoRequerido[0] + " gramos de café Arábica\n" +
        "Se ocupan: " + pesoRequerido[1] + " gramos de café Catuaí\n" +
        "Se ocupan: " + pesoRequerido[2] + " gramos de café Caturra\n\n";
        return respuesta; /** @return Retorna un String de una variable que concatena las caracteristicas de la mezcla */
    }
    
    /**
     * Método toString que no recibe parámetros. Imprime los datos esenciales de una mezcla.
     * Muestra el porcentaje del peso requerido de cada subespecie para producir la mezcla,
     * así como el o los kilos de mezcla que se hayan definido para tal mezcla.
     */
    public String toStringReducido(){
        String respuesta = "";
        respuesta += nombre + "(Arábica:" + cantPorcentajeMezcla[0] + "%, " +
        "Catuaí:" + cantPorcentajeMezcla[1] + "%, " +
        "Caturra:" + cantPorcentajeMezcla[2] + "%, " +
        pesoMezcla + "KG)"; 
        return respuesta; /** @return Retorna un String de una variable que concatena las caracteristicas esenciales de la mezcla */
    }
}
