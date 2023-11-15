class Grano{
    /**
     * Esta clase gestiona los métodos de Clase Grano, contiene la información referente a la subespecie, peso, categoría (por pesos) y el tamaño del grano.
     *
     * @author: Zurisadai Granados Montoya carné B53177, Fabián Orozco Chaves carné B95690.
     * @version: 14/05/2020/
     */
    private String tipoGrano; //Define el nombre de la subespecie de cada grano. Ya sea Arábica, Catuaí o Caturra (La subespecie se le asigna aleatoriamente)
    private int pesoGrano; //Define el peso de cada grano. Va de [5,10]. (El peso se le asigna aleatoriamente)
    private String tamañoGrano; //Define el tamaño de cada grano ya sea pequeño, mediano o grande. (el tamaño se le asigna aleatoriamente)
    private String categoriaPeso; //Define la categoría a la que pertenece el grano dependiendo del su peso. Categoría 1: peso 5 o 6. Categoría 2: peso 7 u 8. Categoría 3: peso 9 o 10.

    /**
     * Constructor de la clase Grano, se encarga de asignar valores aleatorios de tamaño, peso y tipo de grano de café.
     */
    public Grano(){
        int tipoGranoRandom = (int) (1+Math.random()*(3)); //Escoge un número aleatoria, entre 1 y 3; este numero se utiliza en el switch para determinar el tipo de grano de café.

        switch(tipoGranoRandom){
            case 1:
            tipoGrano = "Arábica";
            break;

            case 2:
            tipoGrano = "Catuaí";
            break;

            case 3:
            tipoGrano = "Caturra";
            break;
            default:
            break;
        }

        int numRandomTamaño = (int) (0+Math.random()*(3));//Escoge un número aleatoria, entre 0 y 2; este numero se utiliza en el switch para determinar el tamaño de grano de café.

        switch(numRandomTamaño){
            case 0:
            tamañoGrano = "pequeño";
            break;

            case 1:
            tamañoGrano = "mediano";
            break;

            case 2:
            tamañoGrano = "grande";
            break;
            default:
            break;
        }

        int numRandomPeso = (int) (5+Math.random()*(6)); //Escoge un número aleatoria, entre 5 y 10; este numero se utiliza en el switch para determinar el peso de grano de café.
        switch(numRandomPeso){
            case 5:
            pesoGrano=5;
            categoriaPeso="Categoría 1";
            break;

            case 6:
            pesoGrano=6;
            categoriaPeso="Categoría 1";
            break;

            case 7:
            pesoGrano=7;
            categoriaPeso="Categoría 2";
            break;

            case 8:
            pesoGrano=8;
            categoriaPeso="Categoría 2";
            break;

            case 9:
            pesoGrano=9;
            categoriaPeso="Categoría 3";
            break;

            case 10:
            pesoGrano=10;
            categoriaPeso="Categoría 3";
        }
    }

    /**
     * Método que retorna la categoría de peso almacenada en el atributo de clase, osea la Categoría a la que pertenece este grano.
     */
    public String getCategoriaPeso(){
        return categoriaPeso; /**@return Se retorna un String con la categoría de peso que tiene este grano de café*/
    }

    /**
     * Método que retorna la subespecie o tipo de grano a la que pertenece esta instancia/Grano
     */
    public String getTipoGrano(){
        return tipoGrano; /**@return Retorna la subespecie a la que pertenece el grano utilizando un String*/
    }

    /**
     * Método que retorna el peso de este grano
     */
    public int getPesoGrano(){
        return pesoGrano; /**@return Retorna el peso que posee el grano utilizando un int*/
    }

    /**
     * Método que retorna el tamaño del grano
     */
    public String getTamañoGrano(){
        return tamañoGrano; /**@return Retorna el tamaño que posee el grano utilizando un String*/
    }

    /**
     * Método toString que se usa para imprimir el estado del objeto de esta clase.
     */
    public String toString(){
        String respuesta= "";
        respuesta += "Tipo de grano: " + tipoGrano + "\nPeso del grano: " + pesoGrano +
        "\nTamaño del Grano: " + tamañoGrano + "\nCategoria peso: " + categoriaPeso + "\n";
        return respuesta; /**@return Retorna información general sobre este grano y que se utilizará para imprimir datps al usuario en la Clase Saco. */
    }
}
