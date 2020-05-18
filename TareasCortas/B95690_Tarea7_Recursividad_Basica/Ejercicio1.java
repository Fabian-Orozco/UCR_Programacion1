import javax.swing.JOptionPane;
public class Ejercicio1
{
    //ejercicio 1:
    private String[] numero; //contiene las notas en String
    private int[] nota;      //contiene las notas en int, convertidas del vector anterior

    public void ejercicio1(String numerosSeparadosPorComa){
        numero = numerosSeparadosPorComa.split(","); //pone en un vector de tipo hilera cada número 
        nota = new int[numero.length]; //inicializa otro vector con el mismo tamaño del vector anterior.

        int contador = 0; //funciona como un salto de número en número
        lleneVector(contador,numero,nota); //método recursivo que llena el vector int notas por medio de un casteo del vector String numero.        
        System.out.print("Notas:\n");
        imprimeNotas(contador, numero, nota); //imprime las notas.
        System.out.println("Cantidad de notas superiores o iguales a siete: " + mayorOIgualASiete(0,0)); //llama al método que hace el cálculo recursivo para saber la cantidad de notas superiores o iguales a 7 
    }

    public int[] lleneVector(int contador,String[] numero, int[] nota){
        if(contador == numero.length){
            return nota;
        }
        else{
            nota[contador]=Integer.parseInt(numero[contador]);
            return lleneVector(++contador, numero, nota);
        }
    }

    public int[] imprimeNotas(int contador,String[] numero, int[] nota){
        if(contador == numero.length){
            System.out.print("\n");
            return nota;
        }
        else{
            System.out.print(nota[contador] + ", ");
            return imprimeNotas(++contador, numero, nota);
        }
    }

    public int mayorOIgualASiete(int contador,int indice){
        if(indice == nota.length){
            return contador;
        }
        else{
            if(nota[indice] >= 7){
                return mayorOIgualASiete(++contador,++indice);
            }
            else {
                return mayorOIgualASiete(contador,++indice);
            }
        }
    }

    public static void main(String a[]){
        //ejercicio 1: Cuenta la cantidad de valores mayores o iguales a 7 de una lista de notas.
        Ejercicio1 e1 = new Ejercicio1();
        //String numerosSeparadosPorComa = "1,2,3,4,5,6,7,8,9,10"; //Para prueba rápida, quite primer comentario y comente línea 58.
        String numerosSeparadosPorComa = JOptionPane.showInputDialog(null,"Introduzcla los números/notas separadas por coma(,)","Números",JOptionPane.QUESTION_MESSAGE);
        e1.ejercicio1(numerosSeparadosPorComa);
    }
}
