import javax.swing.JOptionPane;
import java.io.IOException;

public class MaquinaDeTiquetes
{
    private String nS1=""; //Nombre de sección 1
    private double pS1; //Precio de sección 1
    private int cS1; //Cantidad de tiquetes en sección 1
    private int vS1; //Contador de : Tiquetes vendidos en sección 1

    private String nS2=""; //Nombre de sección 2
    private double pS2; //Precio de sección 2
    private int cS2; //Cantidad de tiquetes en seccion 2
    private int vS2; //Contador de : Tiquetes vendidos en seccion 2

    private String nS3=""; //Nombre de sección 3
    private double pS3;//Precio de sección 3
    private int cS3; //Cantidad de tiquetes en seccion 3
    private int vS3; //Contador de : Tiquetes vendidos en seccion 3

    private String moneda; //Nombre de la moneda
    private double saldo; //Cantidad de dinero ingresado
    private double total; //Cantidad de dinero recolectada por la máquina

    private String seccion; //Variable que ocupa el nombre de la sección en la cual se decida comprar los tiquetes
    private double precio; //Variable que ocupa el precio de la sección en la cual se decida comprar los tiquetes

    boolean puedeVender=false; //Permite vender o no dependiendo de las condiciones


    public MaquinaDeTiquetes() 
    {
        do{
            nS1 = JOptionPane.showInputDialog(null,"Defina nombre de la sección 1","Nombre de sección",JOptionPane.QUESTION_MESSAGE);
            if (nS1.length() < 1){JOptionPane.showMessageDialog(null,"Agregue un nombre a la sección 1 para continuar","Error",JOptionPane.ERROR_MESSAGE);}
        }while(nS1.length() < 1);
        pS1 = ingresePrecio(pS1,nS1);
        cS1 = ingreseTiquetes(cS1,nS1);

        do{
            nS2 = JOptionPane.showInputDialog(null,"Defina nombre de la sección 2","Nombre de sección",JOptionPane.QUESTION_MESSAGE);
            if (nS2.length() < 1 || nS2.equals(nS1)){JOptionPane.showMessageDialog(null,"Agregue un nombre original a la sección 2 para continuar","Error",JOptionPane.ERROR_MESSAGE);}
        }while(nS2.length() < 1 || nS2.equals(nS1));       
        pS2 = ingresePrecio(pS2,nS2);
        cS2 = ingreseTiquetes(cS2,nS2);

        do{
            nS3 = JOptionPane.showInputDialog(null,"Defina nombre de la sección 3","Nombre de sección",JOptionPane.QUESTION_MESSAGE);
            if (nS3.length() < 1 || nS3.equals(nS1) || nS3.equals(nS2)){JOptionPane.showMessageDialog(null,"Agregue un nombre original a la sección 3 para continuar","Error",JOptionPane.ERROR_MESSAGE);}
        }while(nS3.length() < 1 || nS3.equals(nS1) || nS3.equals(nS2));
        pS3 = ingresePrecio(pS3,nS3);
        cS3 = ingreseTiquetes(cS3,nS3);

        moneda = JOptionPane.showInputDialog(null,"Defina el nombre de la moneda","Nombre de moneda",JOptionPane.QUESTION_MESSAGE);

        saldo = ingreseDinero();
    }

    public double ingresePrecio(double precioSeccion, String nombreSeccion)
    {
        double cantP = 0; //variable que guarda temporalmente el valor de precio para después otorgarselo
        boolean precioAdmitido = false; //para terminar el do cuando se admita el precio(sea verdadero)
        do{
            try{
                cantP = Double.parseDouble(JOptionPane.showInputDialog(null, "Defina el precio de cada tiquete para " + nombreSeccion,"Precio de "+nombreSeccion,JOptionPane.QUESTION_MESSAGE));
                if (cantP > 0) 
                {
                    precioAdmitido = true;
                    precioSeccion = cantP;
                }
                else 
                {
                    JOptionPane.showMessageDialog(null,"Ingrese una cantidad mayor a cero","Error",JOptionPane.ERROR_MESSAGE);
                }
            }           
            catch(NumberFormatException e){JOptionPane.showMessageDialog(null,"Ingrese un valor numérico","Error",JOptionPane.ERROR_MESSAGE);
            }
            catch(NullPointerException a){JOptionPane.showMessageDialog(null,"No puede cancelar o aceptar sin haber definido el precio de cada tiquete","Error",JOptionPane.ERROR_MESSAGE);
            }
        }while(precioAdmitido == false);
        return precioSeccion;
    }

    public int ingreseTiquetes(int tiquetesSeccion, String nombreSeccion)
    {
        int cantT = 0;
        boolean tiqueteAdmitido = false;
        do{
            try{
                cantT = Integer.parseInt(JOptionPane.showInputDialog(null, "Defina la cantidad de tiquetes disponibles para " + nombreSeccion,"Tiquetes de "+nombreSeccion,JOptionPane.QUESTION_MESSAGE));
                if (cantT > 0) 
                {
                    tiqueteAdmitido = true;
                    tiquetesSeccion = cantT;
                }
                else 
                {
                    cantT = 0; JOptionPane.showMessageDialog(null,"Ingrese una cantidad mayor a cero","Error",JOptionPane.ERROR_MESSAGE);
                }
            }           
            catch(NumberFormatException e){cantT = 0; JOptionPane.showMessageDialog(null,"Ingrese un valor numérico","Error",JOptionPane.ERROR_MESSAGE);
            }
            catch(NullPointerException a){JOptionPane.showMessageDialog(null,"No puede cancelar o aceptar sin haber definido la cantidad de tiquetes","Error",JOptionPane.ERROR_MESSAGE);
            }
        }while(tiqueteAdmitido == false);
        return tiquetesSeccion;
    }

    public double ingreseDinero() //Ingresa el saldo con el cual se comprarán los tiquetes
    {
        double cantS = 0;
        boolean saldoAdmitido = false;
        do{
            try{
                cantS = Double.parseDouble(JOptionPane.showInputDialog
                    (null, "\nSaldo actual: " + saldo + "\nCantidad de dinero para ingresar","Saldo a ingresar",JOptionPane.QUESTION_MESSAGE));
                if (cantS > 0) {
                    saldoAdmitido = true;
                    saldo += cantS;
                    JOptionPane.showMessageDialog(null,"Cantidad agregada al saldo\nSaldo actual: " + saldo,"Ingreso de dinero exitoso",JOptionPane.INFORMATION_MESSAGE);
                }
                else 
                {
                    cantS = 0; JOptionPane.showMessageDialog(null,"Ingrese una cantidad mayor a cero","Error",JOptionPane.ERROR_MESSAGE);
                }
            }           
            catch(NumberFormatException e){cantS = 0;JOptionPane.showMessageDialog(null,"Ingrese un valor numérico","Error",JOptionPane.ERROR_MESSAGE);
            }
            catch(NullPointerException a){JOptionPane.showMessageDialog(null,"No puede cancelar o aceptar sin haber ingresado el saldo","Error",JOptionPane.ERROR_MESSAGE);
            }
        }while(saldoAdmitido == false);
        return saldo;
    }

    public String toStringInfo() //Imprime el estado de un objeto máquina creado.
    {
        return "Información en la máquina\n\nEn " + nS1 + " hay " + cS1 + " tiquetes, cada uno vale " + pS1 +
        "\nEn " + nS2 + " hay " + cS2 + " tiquetes, cada uno vale " + pS2 +
        "\nEn " + nS3 + " hay " + cS3 + " tiquetes, cada uno vale " + pS3 +
        "\n\nMoneda: " + moneda +
        "\nSaldo: " + saldo; 
    }

    public String toStringPromo(){ //Imprime que hay una promoción
        return "Es válido por cada compra\nCada tiquete a partir del quinto comprado(inclusive).\n4 descuentos máximos por compra.\n\n-5% por tiquete en palco\n-10% por tiquete en butaca\n-15% por tiquete en galeria";
    }

    public boolean permisoVenta() //Permite vender entradas dependiendo de si tiene el dinero suficiente y si hay entradas disponibles
    {
        if (saldo < pS1 && saldo < pS2 && saldo < pS3) //Si no hay dinero suficiente entonces llama al método ingreseDinero()
        {
            puedeVender = false;
            JOptionPane.showMessageDialog(null,"Saldo insuficiente, ingrese dinero para poder realizar la compra\nSaldo: "+saldo+
                "\n\nPrecios:\n" + nS1 + " (" + pS1 + " c/u)\n" +
                nS2 + " (" + pS2 + " c/u)\n" + 
                nS3 + " (" + pS3 + " c/u)");
            ingreseDinero();
        }
        else {puedeVender = true;}   //Si hay dinero suficiente entonces llama al método ingreseDinero()

        if (cS1 <= 0 && cS2 <= 0 && cS3 <= 0) //Si no hay entradas disponibles entonces no puede vender, debe elegir opc 3 en menú.
        {            
            puedeVender = false;
            JOptionPane.showMessageDialog(null,"No quedan tiquetes.\nVuelva otro día o administre la cantidad(opción 3 en menú)");
        }
        else {puedeVender = true;} //Si hay entradas entonces puede comprar.
        return puedeVender;
    }

    public void compreTiquete()
    {
        String inputCant="Seleccione la cantidad de entradas que desea comprar\n" +
            "\nDisponibles:\n" + nS1 + ": "+ cS1 + " tiquetes ("+pS1 + " c/u)" +
            "\n" + nS2 + ": "+ cS2 + " tiquetes ("+pS2 + " c/u)" +
            "\n" + nS3 + ": "+ cS3 + " tiquetes ("+pS3 + " c/u)";

        int cant = 0;
        do{
            try{
                cant = Integer.parseInt(JOptionPane.showInputDialog
                    (null,inputCant,"Cantidad",JOptionPane.QUESTION_MESSAGE));

                if (cant <= 0){JOptionPane.showMessageDialog(null,"Ingrese una cantidad positiva","Error",JOptionPane.ERROR_MESSAGE);}
            }
            catch(NumberFormatException a){JOptionPane.showMessageDialog(null,"Ingrese un valor numérico","Error",JOptionPane.ERROR_MESSAGE);}
        }while(cant <= 0);

        int opc = 0;
        do{
            try{
                opc = Integer.parseInt(JOptionPane.showInputDialog(null,"Seleccione la sección"+
                        "\n1." + nS1 + " (" + pS1 + " c/u)" + "\n2." + nS2 + " (" + pS1 + " c/u)" + "\n3." + nS3 +  " (" + pS3 + " c/u)","Sección",JOptionPane.QUESTION_MESSAGE));

                if (opc <= 0 || opc >= 4){JOptionPane.showMessageDialog(null,"Ingrese una opción válida","Error",JOptionPane.ERROR_MESSAGE);}
            }
            catch(NumberFormatException a){JOptionPane.showMessageDialog(null,"Ingrese un valor numérico","Error",JOptionPane.ERROR_MESSAGE);}
        }while(opc <= 0 || opc >= 4);

        switch(opc){
            case 1: //Elijen comprar de la sección 1
            if (cant <= cS1){puedeVender=true;}  //Evalúa si puede o no vender dependiendo de la cantidad requerida y la disponible
            else{JOptionPane.showMessageDialog(null,"La cantidad ingresada para comprar es mayor a los tiquetes disponibles en "+nS1+"\nIngrese una cantidad menor o igual a "+cS1,"Error en la compra",JOptionPane.ERROR_MESSAGE);
                puedeVender=false;}

            if (puedeVender && saldo >= pS1*cant){puedeVender=true;}  //Evalúa si puede o no vender dependiendo del precio y saldo disponible
            else{JOptionPane.showMessageDialog(null,"No tiene saldo suficiente para comprar tiquetes de " + nS1 + "\nIngrese más dinero para continuar\nSaldo: "+saldo+"\nPrecio cada uno: "+pS1+"\nPrecio total: "+pS1*cant,"Error en la compra",JOptionPane.ERROR_MESSAGE);
                puedeVender=false;}

            precio = (puedeVender) ? pS1*cant : precio; //Si se puede vender entonces precio va a ser multiplicado por la cantidad, sino entonces queda igual
            seccion = (puedeVender) ? nS1 : seccion; //Si se puede vender entonces la sección se llamará como la sección 1
            vS1 += (puedeVender) ? cant : 0; //Si se puede vender entonces se suma la cantidad a los vendidos y sino no se le suma nada
            cS1 -= (puedeVender) ? cant : 0; //A disponibles se resta la cantidad si se puede vender y sino no le restan nada

            if (puedeVender && cant >=5) //Evalúa si se aplica o no el descuento dependiendo de la condición anterior y de si hay 5 o más tiquetes comprados
            {calculePromocion(nS1,cant,precio);} //Lleva al método el nombre, la cantidad y el precio de la sección

            break;

            case 2: //Elijen comprar de la sección 2
            if (cant <= cS2){puedeVender=true;}  //Evalúa si puede o no vender dependiendo de la cantidad requerida y la disponible
            else{JOptionPane.showMessageDialog(null,"La cantidad ingresada para comprar es mayor a los tiquetes disponibles en "+nS2+"\nIngrese una cantidad menor o igual a "+cS2,"Error en la compra",JOptionPane.ERROR_MESSAGE);
                puedeVender=false;}

            if (puedeVender && saldo >= pS2*cant){puedeVender=true;}  //Evalúa si puede o no vender dependiendo del precio y saldo disponible
            else{JOptionPane.showMessageDialog(null,"No tiene saldo suficiente para comprar tiquetes de " + nS2 + "\nIngrese más dinero para continuar\nSaldo: "+saldo+"\nPrecio cada uno: "+pS2+"\nPrecio total: "+pS2*cant,"Error en la compra",JOptionPane.ERROR_MESSAGE);
                puedeVender=false;}

            precio = (puedeVender) ? pS2*cant : precio; //Si se puede vender entonces precio va a ser multiplicado por la cantidad, sino entonces queda igual
            seccion = (puedeVender) ? nS2 : seccion; //Si se puede vender entonces la sección se llamará como la sección 2
            vS2 += (puedeVender) ? cant : 0; //Si se puede vender entonces se suma la cantidad a los vendidos y sino no se le suma nada
            cS2 -= (puedeVender) ? cant : 0; //A disponibles se resta la cantidad si se puede vender y sino no le restan nada

            if (puedeVender && cant >=5)
            {calculePromocion(nS2,cant,precio);}

            break;

            case 3:
            if (cant<=cS3){puedeVender=true;}  //Evalúe si puede o no vender dependiendo de la cantidad requerida y la disponible
            else{JOptionPane.showMessageDialog(null,"La cantidad ingresada para comprar es mayor a los tiquetes disponibles en "+nS3+"\nIngrese una cantidad menor o igual a "+cS3,"Error en la compra",JOptionPane.ERROR_MESSAGE);
                puedeVender=false;}

            if (puedeVender && saldo >= pS3*cant){puedeVender=true;}  //Evalúa si puede o no vender dependiendo del precio y saldo disponible
            else{JOptionPane.showMessageDialog(null,"No tiene saldo suficiente para comprar tiquetes de " + nS3 + "\nIngrese más dinero para continuar\nSaldo: "+saldo+"\nPrecio cada uno: "+pS3+"\nPrecio total: "+pS3*cant,"Error en la compra",JOptionPane.ERROR_MESSAGE);
                puedeVender=false;}

            precio = (puedeVender) ? pS3*cant : precio; //Si se puede vender entonces precio va a ser multiplicado por la cantidad, sino entonces queda igual
            seccion = (puedeVender) ? nS3 : seccion; //Si se puede vender entonces la sección se llamará como la sección 3
            vS3 += (puedeVender) ? cant : 0;//Si se puede vender entonces se suma la cantidad a los vendidos y sino no se le suma nada
            cS3 -= (puedeVender) ? cant : 0; //A disponibles se resta la cantidad si se puede vender y sino no le restan nada

            if (puedeVender && cant >=5)
            {calculePromocion(nS3,cant,precio);}

            break;
        }

        if(saldo >= precio && puedeVender) { //Imprime tiquete si se puede vender(boolean) y si hay suficiente saldo
            total += precio; //Se suma el precio de lo comprado al total recolectado por la máquina
            saldo -= precio; //Se resta el precio de lo comprado al total al saldo
            String compra="###############\n# Compra exitosa\n# Sección: " + seccion + "\n# Precio: " + precio + "\n# Cantidad: " + cant + "\n# Saldo actual: " + saldo + "\n###############";
            JOptionPane.showMessageDialog(null,compra,"Información de la compra",JOptionPane.INFORMATION_MESSAGE);
            cant = 0; //La cantidad se reinicia en cada compra
        }

    }    

    public void calculePromocion(String seccion, int cantidad, double precio)
    {
        double porcentaje = 0;
        double descuento = 0;
        JOptionPane.showMessageDialog(null,"Se hará un descuento al precio debido a que se realizó\n una compra de cinco o más tiquetes","Promoción efectuada",JOptionPane.INFORMATION_MESSAGE);
        if (seccion.length()==5) //palco
        {
            porcentaje=0.05;
            descuento=precio*porcentaje/cantidad;
        }
        else if (seccion.length()==6) //butaca
        {
            porcentaje=0.1;
            descuento=precio*porcentaje/cantidad;
        }
        else if (seccion.length()==7) //galeria
        {
            porcentaje=0.15;
            descuento=precio*porcentaje/cantidad;
        }

        if (cantidad==5){precio-=descuento;}
        if (cantidad==6){precio-=descuento*2;}
        if (cantidad==7){precio-=descuento*3;}
        if (cantidad>=8){precio-=descuento*4;}
        this.precio=precio;
    }

    public void registreNuevaMoneda(){ //Cambia el nombre de la moneda
        String monedaAnt = moneda;
        moneda = JOptionPane.showInputDialog(null,"Moneda actual: " + moneda + "\nElija la moneda nueva","Nueva moneda",JOptionPane.QUESTION_MESSAGE);
        JOptionPane.showMessageDialog(null,"Moneda antigua: " + monedaAnt + "\nMoneda actual: "+ moneda ,"Cambio de moneda",JOptionPane.INFORMATION_MESSAGE);
    }

    public void retireSaldo(){       //da la elección de cuánto reembolzar
        double cant = Double.parseDouble(JOptionPane.showInputDialog(null,"Cantidad que desea reembolzar\nSaldo actual: " + saldo,"Reembolzo del saldo",JOptionPane.QUESTION_MESSAGE));  
        if (saldo > 0 && cant <= saldo && cant > 0){
            saldo -= cant;
            JOptionPane.showMessageDialog(null,"Cantidad reembolzada: " + cant + "\nSaldo actual: "+saldo,"Reembolzo",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null,"No tiene dinero en saldo suficiente para reembolzar\n o ingresó una cantidad negativa","Error",JOptionPane.ERROR_MESSAGE);
        }

    }

    public String cantTiquetes(){ //Administra la cantidad de tiquetes en la máquina creada
        JOptionPane.showMessageDialog(null,"Información\n\nSección: " + nS1 + "\nTiquetes: " + cS1,"Administrar tiquetes",JOptionPane.INFORMATION_MESSAGE);
        cS1 = ingreseTiquetes(cS1,nS1);

        JOptionPane.showMessageDialog(null,"Información\n\nSección: " + nS2 + "\nTiquetes: " + cS2,"Administrar tiquetes",JOptionPane.INFORMATION_MESSAGE);
        cS2 = ingreseTiquetes(cS2,nS2);

        JOptionPane.showMessageDialog(null,"Información\n\nSección: " + nS3 + "\nTiquetes: " + cS3,"Administrar tiquetes",JOptionPane.INFORMATION_MESSAGE);
        cS3 = ingreseTiquetes(cS3,nS3);

        return "Cantidad de tiquetes en cada sección actualmente\n" +
        nS1 + ": "+cS1 + " tiquetes ("+pS1 + " c/u)\n" +
        nS2 + ": "+cS2 + " tiquetes ("+pS2 + " c/u)\n" + 
        nS3 + ": "+cS3 + " tiquetes ("+pS3 + " c/u)";
    }

    public static void main(String a[])
    {
        String menu = "1.Crear máquina\n2.Venta de tiquetes\n3.Existencias por tipo\n4.Terminar";
        MaquinaDeTiquetes m1 = null;
        int opcion=0;
        do{
            try{
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,menu,"Menú",JOptionPane.INFORMATION_MESSAGE));
                switch(opcion){

                    case 1: //Crear máquina
                    m1 = new MaquinaDeTiquetes();
                    JOptionPane.showMessageDialog(null,m1.toStringInfo(),"Máquina creada",JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(null,m1.toStringPromo(),"Regalía",JOptionPane.INFORMATION_MESSAGE);
                    break;

                    case 2: //Permiso venta de tiquetes y venta de tiquetes
                    if (m1!=null)
                    {
                        if(m1.permisoVenta())
                        {
                            int opc=0;
                            do{
                                try{
                                    String inputVenta="1.Ingrese saldo\n2.Compre tiquete\n3.Lea promoción\n4.Cambie moneda\n5.Reembolzar saldo";                                   
                                    opc = Integer.parseInt(JOptionPane.showInputDialog(null,inputVenta,"Venta de tiquetes",JOptionPane.QUESTION_MESSAGE));

                                    switch(opc){
                                        case 1:
                                        m1.ingreseDinero();
                                        break;

                                        case 2:
                                        m1.compreTiquete();
                                        break;

                                        case 3:
                                        JOptionPane.showMessageDialog(null,m1.toStringPromo(),"Regalía",JOptionPane.INFORMATION_MESSAGE);
                                        break;

                                        case 4:
                                        m1.registreNuevaMoneda();
                                        break;

                                        case 5:
                                        m1.retireSaldo();
                                        break;
                                    }
                                }
                                catch(NumberFormatException e){JOptionPane.showMessageDialog(null,"Ingrese un valor numérico","Error",JOptionPane.ERROR_MESSAGE);
                                    ;}
                                catch(NullPointerException q){JOptionPane.showMessageDialog(null,"No puede cancelar o aceptar sin haber definido la cantidad de tiquetes","Error",JOptionPane.ERROR_MESSAGE);
                                    ;}
                                if (opc <= 0 || opc > 5){JOptionPane.showMessageDialog(null,"Ingrese una opción válida","ERROR",JOptionPane.ERROR_MESSAGE);}
                            }while(opc <= 0 || opc > 5);
                        }

                    } 

                    else{
                        JOptionPane.showMessageDialog(null,"Máquina no creada\nCree una máquina para acceder a venta de tiquetes","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                    case 3: //Controlar la cantidad de tiquetes que hay por cada sección
                    if (m1!=null)
                    {
                        m1.cantTiquetes();
                        JOptionPane.showMessageDialog(null,m1.toStringInfo(),"Estado al administrar tiquetes de m1",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else //Si la máquina no ha sido creada entonces no se puede administrar
                    {
                        JOptionPane.showMessageDialog(null,"Máquina no creada\nCree una máquina para poder administrar sus tiquetes","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                }
            }
            catch(NumberFormatException m){JOptionPane.showMessageDialog(null,"Ingrese un valor númerico","Error",JOptionPane.ERROR_MESSAGE);
            }

            if (opcion < 0 || opcion > 4){opcion = 0; JOptionPane.showMessageDialog(null,"Ingrese una opción válida","Error",JOptionPane.ERROR_MESSAGE);}
        }while (opcion != 4);
    }
}
