import javax.swing.JOptionPane;
public class Ejercicio4
{
    public void ejercicio4(int numero){
        int contador = 1; //el valor que se imprime. Empieza en 1.
        int resta = numero; //se usa como "contador" de "filas/impresiones".

        System.out.println("Número: " + numero + "\n");

        piramide1(numero, contador, resta); //pirámide 1
        numero = 2; //"restablece" el número para que funcione el primer print.
        piramide2(numero, contador, resta); //pirámide 2(imprime del [12, en adelante])
    }

    public int piramide1(int numero, int contador, int resta){
        if(resta == 0){ //si se ha impreso <numero-1> cantidad de veces.
            return contador;
        }
        else{
            //mientras el contador se menor al número, imprima el contador hasta llegar al número.
            if(contador <= numero){
                System.out.print(contador);  
                return piramide1(numero,++contador,resta);
            }
            else {//si el contador llega a ser == numero 
                System.out.println(); //salta de linea   
                return piramide1(--numero,1,--resta); //retorna un número menos, que el contador se restablece y que lleva 1 hilera(resta)
            }
        }
    }

    public int piramide2(int numero, int contador, int resta){
        //numero viene en <numero> por defecto, se cambia a 2 en método principal
        //contador viene en 1 por defecto
        //resta viene en <resta> por defecto
        if(resta == 1){ //si se ha impreso <numero-2> cantidad de veces.
            return contador;
        }
        else{
            //mientras el contador se menor al número, imprima el contador hasta llegar al número.
            if(contador <= numero){
                System.out.print(contador);
                return piramide2(numero,++contador,resta);
            }
            else {//si llega a ser == numero 
                System.out.println(); //salta de linea   
                return piramide2(++numero,1,--resta); //retorna un número más, que el contador se restablece y que lleva 1 hilera(resta)
            }
        }
    }

    public static void main(String a[]){
        Ejercicio4 e4 = new Ejercicio4();
        //int numero = 4; //Para prueba rápida quite primer comentario y comente línea 55.
        int numero = Integer.parseInt(JOptionPane.showInputDialog(null,"Digíte el número límite de la serie","Número",JOptionPane.QUESTION_MESSAGE));
        e4.ejercicio4(numero);
    }
}
