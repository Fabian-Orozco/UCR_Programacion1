import javax.swing.JOptionPane;
public class Ejercicio2
{
    public int sumatoria(int numero){
        if (numero < 10)
            return numero;
        else{
            return sumatoria(numero/10)+(numero%10);
        }
    }

    public static void main(String a[]){
        Ejercicio2 e2 = new Ejercicio2();
        int num = Integer.parseInt(JOptionPane.showInputDialog(null,"Digíte el número del cual quiere saber la sumatoria de sus dígitos","Número entero",JOptionPane.QUESTION_MESSAGE));
        //int num = 385; // para prueba rápida comente línea 14 y quite primer comentario de línea 15
        System.out.println("Suma de los digitos de " + num + ":\n" + e2.sumatoria(num));
    }
}
