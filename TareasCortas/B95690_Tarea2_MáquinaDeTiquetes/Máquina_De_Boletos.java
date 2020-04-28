import javax.swing.JOptionPane;
/**
 * Máquina que vende boletos, permite ingresar dinero a un tipo 
 * de monedero(saldo) para que con él se compren boletos; el dinero del saldo
 * se puede retirar/reembolzar a conveniencia(cantidad y momento).
 * El estado(cantidad de boletos y dinero) se puede apreciar en cada compra 
 * del boleto.
 * 
 * @author Fabián Orozco Chaves 
 * @version 1.0
 */
public class Máquina_De_Boletos
{
    private int precio;
    private int saldo;
    private int total;
    private int totalBoletos;     //campos totales
    private int vendidosBoletos; 
    
    public Máquina_De_Boletos(int costo){
        precio=costo;
        saldo=0;
        total=0;
        totalBoletos=20;
        vendidosBoletos=0;
    }
    
    public int getPrecio(){
       return precio;
    }
    
    public int getSaldo(){
        return saldo;
    }
    
    public void inserteDinero(int cantidad){
        if(cantidad>0) {
            saldo+=cantidad;
        }
        else {
            System.out.print("Ingrese una cantidad positiva, no algo como: "
                             +cantidad);
        }
    }
    
    public void compreTiquete(){
        if (saldo >= precio && vendidosBoletos<20){
            vendidosBoletos+=1;
            saldo = saldo - precio;
            total = total + precio;
            
            System.out.println("*************************");
            System.out.println("** Boleto comprado");
            System.out.println("** Precio: ‎₡"+precio);
            System.out.println("** Gracias por su compra");
            System.out.println("*************************\n");
            
            System.out.println("Estado:"); //Estado actual de la máquina-compra
            System.out.println("Cantidad de boletos totales:"+totalBoletos);
            System.out.println("Cantidad de boletos comprados:"+vendidosBoletos);
            System.out.println("Cantidad de boletos restantes:"+
            (totalBoletos-vendidosBoletos));
            System.out.println("Saldo: "+saldo);
            System.out.println("Ingresos de máquina ₡"+total+"\n\n\n");
        }
        else if (saldo < precio){
            System.out.println("________________X________________");
            System.out.println("Cantidad insuficiente de dinero");
            System.out.println("Debes insertar ₡"+(precio-saldo)+" más");
            System.out.println("________________X________________\n\n\n");
        }    
        else if (vendidosBoletos>=20){
            System.out.println("_______X_______");
            System.out.println("Boletos agotados");
            System.out.println("_______X_______\n\n\n");    
        }
    }
    
    public void retireSaldo(){       //da la elección de cuánto reembolzar
        if (saldo>0){
          int cantidad1=Integer.parseInt(JOptionPane.showInputDialog
          ("Cantidad que desea reembolzar:"));  
          int cantidadReembolsada;          
          cantidadReembolsada=cantidad1;
          saldo-=cantidadReembolsada;
          JOptionPane.showMessageDialog(null,"Cantidad reembolzada: ₡"+
          cantidadReembolsada,"Reembolzo",JOptionPane.INFORMATION_MESSAGE);
          }
        else{
            System.out.println("No tiene dinero en saldo");
        }
        
    }
}