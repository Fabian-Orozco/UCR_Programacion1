import java.util.StringTokenizer;
public class ManejoHileras
{
    private String blancosIniciales;
    
    //Inicio ejercicio 1
    public void palabra(String palabra){
        //condicionar a 10 caracteres máximos
        String palabraUsada = (palabra.length() > 10) ? palabra.trim().substring(0,10) : palabra.trim();
        System.out.println("palabra introducida: " + palabra + " (" + palabra.length() + ")");
        System.out.println("palabra transformada: " + palabraUsada + " (" + palabraUsada.length() + ")");
        //llama al método para que genere el string con la cantidad de espacios
        blancosIniciales = blancos(palabraUsada,"");
        System.out.println("Después de agregar blancos:" + blancosIniciales + "(" + blancosIniciales.length() + " máximo)");
        System.out.println("Diamante:\n");
        int porRecorrer = 1;
        int recorrido = blancosIniciales.length();
        muestrePiramide1(palabraUsada, recorrido,porRecorrer);

        recorrido = 1;
        porRecorrer = blancosIniciales.length();
        muestrePiramide2(palabraUsada, recorrido,porRecorrer);
    }

    //hace un string con la cantidad de espacios
    public String blancos(String palabra,String blancosIniciales){
        if(blancosIniciales.length() == palabra.length()-1){
            return blancosIniciales;
        }
        else{
            blancosIniciales += " ";
            return blancos(palabra,blancosIniciales);
        }
    }

    public String muestrePiramide1(String palabra, int recorrido,int porRecorrer){
        if(recorrido == 0){ //
            System.out.println(blancosIniciales.substring(0,recorrido) + palabra.substring(0,porRecorrer)+palabra.substring(0,porRecorrer-1));
            return palabra;
        }
        else{
            System.out.println(blancosIniciales.substring(0,recorrido) + palabra.substring(0,porRecorrer)+palabra.substring(0,porRecorrer-1));
            return muestrePiramide1(palabra,--recorrido,++porRecorrer);
        }
    }

    public String muestrePiramide2(String palabra, int recorrido, int porRecorrer){
        if(recorrido == palabra.length()-1){ //
            System.out.println(blancosIniciales.substring(0,recorrido) + palabra.substring(0,porRecorrer)+palabra.substring(0,porRecorrer-1));
            return palabra;
        }
        else{
            System.out.println(blancosIniciales.substring(0,recorrido) + palabra.substring(0,porRecorrer)+palabra.substring(0,porRecorrer-1));
            return muestrePiramide2(palabra, ++recorrido, --porRecorrer);
        }
    }//fin ejercicio 1.

    //inicio ejercicio 2a.
    public boolean esPalindromo(String palabra){
        boolean respuesta=false;
        String derecho="";
        String reves="";
        for(int i = 0 ; i < palabra.length() ; i++){
            derecho += palabra.charAt(i);
        }
        for(int f = palabra.length()-1 ; f != -1 ; f--){
            reves += palabra.charAt(f);
        }
        if(derecho.equalsIgnoreCase(reves)){
            respuesta = true;
        }
        return respuesta;
    }//fin ejercicio 2a.

    //inicio ejercicio 2b.
    public boolean fraseEsPalindromo(String frase){
        boolean respuesta=false;
        //normales:       º'¡`+´-.,<
        //shift:         ª!"·$%&/()=?¿^*¨Ç;:_>
        //alt:           \|@#¢∞¬÷“”≠´‚[]{}„…–≤
        //alt+shift:     °ı˝•£‰ ⁄‘’≈¸˛ˆ±«»…—≥

        //crea tokens/divisiones de la variable enviada en el primer parámetro(separa la frase),
        //cada vez que reconoce uno de los signos pasados por el segundo parámetro.
        StringTokenizer st = new StringTokenizer(frase," º'¡`+´-.,<ª!·$%&/()=?¿^*¨Ç;:_>\"|@#¢∞¬÷“”≠´‚[]{}„…–≤°ı˝•£‰ ⁄‘’≈¸˛ˆ±«»…—≥");
        String fraseConvertida = "";
        while(st.hasMoreTokens()){
            fraseConvertida += (st.nextToken()); //asigna a una nueva frase la frase pasada por parámetro pero sin signos gracias al StringTokenizer
        }
        System.out.println("Frase original: " + frase);
        System.out.println("Frase sin signos: " + fraseConvertida);

        String derecho = "";
        String reves = "";
        for(int i = 0 ; i < fraseConvertida.length() ; i++){ //recorre la nueva frase de izquierda a derecha
            derecho += fraseConvertida.charAt(i); //guarda la frase en una variable
        }
        for(int f = fraseConvertida.length()-1 ; f != -1 ; f--){//recorre la nueva frase de derecha a izquierda
            reves += fraseConvertida.charAt(f); //guarda la frase en una variable
        }

        if(derecho.equalsIgnoreCase(reves)){//compara si ambas variables son iguales
            respuesta=true; //de ser iguales, significa que es un palíndromo
        }
        System.out.println("Frase leída al derecho: " + derecho);
        System.out.println("Frase leída al revés: " + reves);
        return respuesta;
    }//fin ejercicio 2b.

    public static void main(String[] a){
        ManejoHileras m1 = new ManejoHileras();
        //ejercicio 1.
        //m1.palabra("ALEJANDRINO");

        //ejercicio 2a.
        //System.out.println(m1.esPalindromo("Ana"));
        //System.out.println(m1.esPalindromo("arribalabirra"));
        //System.out.println(m1.esPalindromo("ventana"));
        //System.out.println(m1.esPalindromo("manzana"));

        //ejercicio 2b.
        //System.out.println("Es palíndromo: " + m1.fraseEsPalindromo( "A man, a plan, a canal: Panama!") + "\n");
        //System.out.println("Es palíndromo: " + m1.fraseEsPalindromo("an aan a") + "\n");
        //System.out.println("Es palíndromo: " + m1.fraseEsPalindromo(" º'¡`+´-.,a<ª!·$ %&/()=n?¿^*¨Ç;:_>\"|@#¢∞¬÷“”≠a´‚[]{}„…–≤°ı˝•£‰a ⁄‘’≈¸˛ˆ±«n»…—a≥") + "\n");
        //System.out.println("Es palíndromo: " + m1.fraseEsPalindromo("Una! fresa r.oj-a") + "\n");
    }
}
