import javax.swing.JOptionPane;
public class Covid19
{
    int estado[][];//day,month,cases,deaths
    //pob 2020, 5022000

    private int casosTotales; //utiliza un recorrido para ir sumando los valores de la columna 3, índice 2
    private String histograma; 
    private String meses[] = {"enero","febrero","marzo","abril","mayo","junio","julio","agosto","setiembre","octubre","noviembre","diciembre"};
    private String mes=""; //ocupa el indice del mes del vector <<meses[]>> según el valor del mes de <<estado[f][1]>> en la comprobación de mayores o menores casos por día.
    public Covid19(){
        estado=new int [][]
        {
            {7,3,1,0},{9,3,4,0},{10,3,4,0},{11,3,4,0},
            {12,3,9,0} ,{13,4,1,0},{14,3,3,0},{15,3,1,0},
            {16,3,8,0},{17,3,6,0},{18,3,9,0},{19,3,19,1},
            {20,3,18,0},{21,3,26,1},{22,3,4,0},{23,3,17,0},
            {24,3,24,0},{25,3,19,0},{26,3,24,0},{27,3,30,0},
            {28,3,32,0},{29,3,32,0},{30,3,19,0},{31,3,16,0},
            {1,4,17,0},{2,4,28,0},{3,4,21,0},{4,4,20,0},
            {5,4,19,0},{6,4,19,0},{7,4,13,0},{8,4,16,0},
            {9,4,19,0},{10,4,37,1},{11,4,19,0},{12,4,19,0},
            {13,4,18,0},{14,4,17,0},{15,4,6,0},{16,4,8,1},
            {17,4,16,0},{18,4,7,0},{19,4,6,0},{20,4,5,0},
            {21,4,2,2},{22,4,7,0}
        };
    }

    public int sumeCasos(){
        //Recorre solamente la columa 2 de cada fila y va sumando sus valores almacenandolos en casosTotales
        for (int indiceFila=0;indiceFila<estado.length; indiceFila++){ //por cada fila 
            for (int indiceColumna=2;indiceColumna<estado[0].length-1;indiceColumna++){ //suma la columna 2 y la guarda en casosTotales
                casosTotales+=estado[indiceFila][indiceColumna]; 
            }
        }
        return casosTotales;
    }

    public String casosMinimos(){
        String respuesta="Día(s) con menor cantidad de casos:\n"; //Variable para retornar junto con la concatenación de la(s) fechas
        int valorMenor = estado[0][2]; //el valor menor inicia con la primer fila columna 2 como mínimo y va comparándose con un for

        //el suguiente for halla el valor más bajo en la columna 3 índice 2 (casos), comparando <<valorMenor>> con cada valor de dicha columna 
        for (int indiceFila = 0; indiceFila < estado.length; indiceFila++){ //recorre todas las filas
            for (int indiceColumnas = 0; indiceColumnas < estado[0].length; indiceColumnas++){ //recorre todas las columnas
                if (estado[indiceFila][2] < valorMenor ){ 
                    valorMenor=estado[indiceFila][2];
                }
            }
        }

        //el siguiente for busca entre las filas los días que contengan el valorMenor de casos y los concatena según su valor de día y mes
        for (int indiceFila = 0; indiceFila < estado.length; indiceFila++){ //Recorre las filas 
            for (int indiceColumnas = 0; indiceColumnas < estado[0].length; indiceColumnas++){ //Recorre las columnas
                if (indiceColumnas==2){ //Si está en la columna 2 entonces:
                    if (estado[indiceFila][2] == valorMenor){ //si el valor de la columna que está es igual al valor menor
                        int n = estado[indiceFila][1]; //guarde el valor del mes en la variable n
                        mes = meses[n-1];  //el mes pasa a ser la posición (n-1) del arreglo meses (para que calze)
                        respuesta+=estado[indiceFila][0] + " de " + mes + " del 2020 "; //al mensaje de salida se le agrega ese día
                        respuesta+="\t" + valorMenor + " caso(s) nuevo(s)\n"; //al mensaje de salida se le agrega el # de casos mínimos en esos días
                    }
                }
            }
        }
        return respuesta;
    }

    public String casosMaximos(){
        String respuesta="\nDía(s) con mayor cantidad de casos:\n"; //Variable para retornar junto con la concatenación de la(s) fechas
        int valorMayor=0; //el valor menor inicia con 0 como mínimo y va comparándose con un for

        //el suguiente for halla el valor más alto en la columna 3 índice 2 (casos), comparando <<valorMayor>> con cada valor de dicha columna 
        for (int indiceFila = 0; indiceFila < estado.length; indiceFila++){ //el funcionamiento interno es similar al primer for de casosMínimos
            for (int indiceColumnas = 0; indiceColumnas < estado[0].length; indiceColumnas++){
                if (valorMayor < estado[indiceFila][2]){
                    valorMayor=estado[indiceFila][2];
                }
            }
        }

        //el siguiente for busca entre las filas los días que contengan el valorMayor de casos y los concatena según su valor de día y mes
        for (int indiceFila = 0; indiceFila < estado.length; indiceFila++){ //el funcionamiento interno es similar al segundo for de casosMínimos
            for (int indiceColumnas = 0; indiceColumnas < estado[0].length; indiceColumnas++){
                if (indiceColumnas==2){
                    if (estado[indiceFila][2] == valorMayor){
                        int n = estado[indiceFila][1];
                        mes = meses[n-1]; 
                        respuesta+=estado[indiceFila][0] + " de " + mes + " del 2020";
                        respuesta+="\t" + valorMayor + " caso(s) nuevo(s)\n";
                    }
                }
            }
        }
        return respuesta;
    }

    public void creeHistograma(int valorDeColumna){ //recibe como parametro la posición en que se se encuentra el caso
        String asteriscos = ""; //declara variable que contendrá la cantidad de asteríscos según la cantidad de casos
        int contador = 0; 
        while (contador!=valorDeColumna){ //agrega '*' mientras un contador inicializado en 0 no sea igual a la cantidad de casos
            asteriscos += "*"; 
            contador++;
        }
        histograma = asteriscos; //se pasa el dato de asteriscos a histograma para restablecer a asteriscos
        asteriscos = ""; //se reestablece asteriscos para que no afecte al siguiente numero de casos
    }

    public void muestre(){
        String resultado="Día\tMes\tCasos\tMuertes\t\tHistograma\n";
        String asterisco="";

        for (int indiceFila=0;indiceFila<estado.length; indiceFila++){
            for (int indiceColumna=0;indiceColumna<estado[0].length;indiceColumna++){
                resultado += estado[indiceFila][indiceColumna]+"\t";

                if(indiceColumna==2){creeHistograma(estado[indiceFila][2]);} //le envía al metodo creeHistograma el valor de casos
            }
            resultado+="\t" + histograma;
            resultado+="\n";
        }
        System.out.println(resultado);
    }

    public static void main (String ar[]){
        Covid19 c=new Covid19();
        c.muestre();
        System.out.println("Total de casos: " + c.sumeCasos());
        System.out.println(c.casosMaximos());
        System.out.println(c.casosMinimos());
    }
}