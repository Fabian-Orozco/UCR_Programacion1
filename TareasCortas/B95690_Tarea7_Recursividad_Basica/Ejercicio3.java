import javax.swing.JOptionPane;
public class Ejercicio3
{
    public void piramideInversa(int numero){
        int contador = 1; //el valor que se imprime. 
        int resta = numero; //se usa como "contador" de "filas/impresiones".
        System.out.println("Número: " + numero + "\n");
        piramide1(contador, contador, resta); //pirámide 1
        piramide2(numero, contador, resta); //pirámide 2.
    }

    public int piramide1(int numero, int contador, int resta){
        if(resta == 1){ 
            return contador;
        }
        else{
            if(contador <= numero){
                System.out.print(contador);
                return piramide1(numero,++contador,resta);
            }
            else {
                System.out.println(); 
                return piramide1(++numero,1,--resta);
            }
        }
    }

    public int piramide2(int numero, int contador, int resta){
        if(resta == 0){ 
            return contador;
        }
        else{
            if(contador <= numero){
                System.out.print(contador);  
                return piramide2(numero,++contador,resta);
            }
            else {
                System.out.println(); 
                return piramide2(--numero,1,--resta); 
            }
        }
    }

    public static void main(String a[]){
        Ejercicio3 e3 = new Ejercicio3();
        //int numero = 5; //Para prueba rápida quite primer comentario y comente línea 47.
        int numero = Integer.parseInt(JOptionPane.showInputDialog(null,"Digíte el número límite de la pirámide","Número",JOptionPane.QUESTION_MESSAGE));
        e3.piramideInversa(numero);
    }
}
