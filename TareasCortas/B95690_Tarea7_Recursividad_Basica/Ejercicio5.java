import javax.swing.JOptionPane;
public class Ejercicio5
{
    public void ejercicio5(int base, int exponente){
        if(exponente == 0){ 
            System.out.println("Resultado/potencia de:\n" + 
                base + " a la " + exponente + " = " + 1);
        }
        else if(exponente == 1){
            System.out.println("Resultado/potencia de:\n" + 
                base + " a la " + exponente + " = " + base);
        }
        else if(exponente%2 == 0){ //es par
            System.out.println("El exponente " + exponente + " es par");
            System.out.println("Resultado/potencia de:\n" + 
                base + " a la " + exponente + " = " + potencie(base,exponente,0));
        }
        else{ //es impar
            System.out.println("El exponente " + exponente + " es impar");
            System.out.println("Resultado/potencia de:\n" + 
                base + " a la " + exponente + " = " + potencie(base,exponente,0));
        }
    }

    public int potencie(int base, int exponente, int resultado){
        if(exponente == 1){
            return resultado;
        }
        else{
            if(resultado == 0){ //si es la primer vez que se realiza la operación
                resultado = base * base;
                return potencie(base,--exponente,resultado);
            }
            else{
                resultado = resultado * base;
                return potencie(base,--exponente,resultado);
            }
        }
    }

    public static void main(String a[]){
        Ejercicio5 e5 = new Ejercicio5();
        //int base = 6; //quite primer comentario para prueba rápida. Comente línea 45 y 46.
        //int exponente = 2; //quite primer comentario para prueba rápida. Comente línea 45 y 46.
        int base = Integer.parseInt(JOptionPane.showInputDialog(null,"Digíte el número base","Potenciar",JOptionPane.QUESTION_MESSAGE));
        int exponente = Integer.parseInt(JOptionPane.showInputDialog(null,"Digíte el número exponente","Potenciar",JOptionPane.QUESTION_MESSAGE));

        e5.ejercicio5(base, exponente);
    }
}
