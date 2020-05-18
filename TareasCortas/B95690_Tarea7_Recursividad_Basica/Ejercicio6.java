import javax.swing.JOptionPane;
public class Ejercicio6
{
    public void ejercicio6(String sustantivosSeparadosPorComa){
        String[] singular = sustantivosSeparadosPorComa.split(","); //contiene los sustantivos de la hilera, esto lo hace gracias a un split que separa cada sustantivo.
        String[] plural = new String[singular.length]; //a futuro va a contener los sustantivos del vector anterior pero en plural.

        int contador = 0; //contador para recorrer vectores e ir trabajando con cada palabra
        System.out.print("Original:\n");
        System.out.print(muestreVector(singular,contador) + "\n\n");

        char ultima = 'e'; //inicializa en cualquier letra, en el método pluralice cambia con la última letra de la palabra actual.
        char penultima = 'e'; //inicializa en cualquier letra, en el método pluralice cambia con la penúltima letra de la palabra actual.
        pluralice(contador,singular,plural,ultima,penultima);

        System.out.println("Pluralizado:"); //muestra el vector pluralizado
        System.out.print(muestreVector(plural,contador));
    }

    public String[] pluralice(int contador, String[] singular,String[] plural,char ultima,char penultima){
        if (contador == singular.length){ //si ya recorrió todos los sustantivos del vector singular
            return plural; //retorna el vector con los sustantivos en plural
        }
        else{ //debe recorrer el vector y ver qué tipo de sustantivo es de acuerdo a su última o penúltima letra.
            ultima = singular[contador].charAt(singular[contador].length()-1);
            penultima = singular[contador].charAt(singular[contador].length()-2);

            //para "ver dentro" de cada "ciclo" programa elimine comentario 33 y 34"
            //System.out.println("Ciclo: " + contador + "\nÚltima letra de " + singular[contador] + ": " + ultima +
            //"\nPenúltima letra de " + singular[contador] + ": " + penultima + "\n");
            if(ultima == 's' || ultima == 'x'){ //última es s o x
                plural[contador]=singular[contador];
                return pluralice(++contador,singular,plural,ultima,penultima);
            }

            else if(ultima == 'a' || ultima == 'e' || ultima == 'i' || ultima == 'o' || ultima == 'u'){ //última es alguna entre: a,e,i,o,u.
                plural[contador] = singular[contador] + "s";
                return pluralice(++contador,singular,plural,ultima,penultima);
            }
            else if(ultima == 'z'){//última es z
                plural[contador] = singular[contador].substring(0,singular[contador].length()-1)+"ces";
                return pluralice(++contador,singular,plural,ultima,penultima);
            }
            else if(penultima == 'á') { //penultima
                plural[contador] = singular[contador].substring(0,singular[contador].length()-2) + "a" + ultima + "es";
                return pluralice(++contador,singular,plural,ultima,penultima);
            }
            else if(penultima == 'é') { //penultima
                plural[contador] = singular[contador].substring(0,singular[contador].length()-2) + "e" + ultima + "es";
                return pluralice(++contador,singular,plural,ultima,penultima);
            }
            else if(penultima == 'í') { //penultima
                plural[contador] = singular[contador].substring(0,singular[contador].length()-2) + "i" + ultima + "es";
                return pluralice(++contador,singular,plural,ultima,penultima);
            }
            else if(penultima == 'ó') { //penultima
                plural[contador] = singular[contador].substring(0,singular[contador].length()-2) + "o" + ultima + "es";
                return pluralice(++contador,singular,plural,ultima,penultima);
            }
            else if(penultima == 'ú') { //penultima
                plural[contador] = singular[contador].substring(0,singular[contador].length()-2) + "u" + ultima + "es";
                return pluralice(++contador,singular,plural,ultima,penultima);
            }
            else{
                plural[contador] = singular[contador] + "es"; 
                return pluralice(++contador,singular,plural,ultima,penultima);
            }
        }
    }

    public String muestreVector(String[] vector, int contador){ //muestra un vector.
        if (contador == vector.length){ //si el contador ya recorrió todo el vector(indice+1)
            return ""; //retorna un vacío
        }
        else{
            System.out.print(vector[contador] + ", "); //imprime el sustantivo actual
            return muestreVector(vector, ++contador); //aumenta de índice para imprimir el siguiente sustantivo
        }
    }

    public static void main(String a[]){
        Ejercicio6 e6 = new Ejercicio6();
        //para prueba rápida,  elimine el comentario de la línea 84 y comente línea 85.
        //String sustantivosSeparadosPorComa = "vaca,casa,pez,maní,ladrón,rubí,canción,cráter,virus,carcaj,rosa"; //JOptionPane.showInputDialog(null,"Introduzca sustantivos separados por coma(,)","Sustantivos",JOptionPane.QUESTION_MESSAGE));
        String sustantivosSeparadosPorComa = JOptionPane.showInputDialog(null,"Introduzca sustantivos separados por coma(,)","Pluralizador",JOptionPane.QUESTION_MESSAGE);
        e6.ejercicio6(sustantivosSeparadosPorComa);
    }
}
