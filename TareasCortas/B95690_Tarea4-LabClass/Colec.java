import java.util.ArrayList;

/**
 * Write a description of class Colec here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Colec
{
    public static void main (String a[]){ //ejemplo sin usar POO
        ArrayList <Integer> co= new ArrayList<Integer>();
        co.add(239);
        co.add(-2);
        co.add(555);
        for (Integer elemento : co) { //para cada elemento dentro de este conjunto
            System.out.println("# = " + elemento);
        }  
        ArrayList <String> coleccion= new ArrayList<String>();
        coleccion.add("Este");
        coleccion.add("Norte");
        coleccion.add("Sur");
        coleccion.add("Oeste");
        int ind=coleccion.indexOf("Sur");
        System.out.println("Posicion del elemento = "+ind);

        ArrayList <Character> abc=new ArrayList<Character>();
        abc.add('a');
        abc.add('b');
        abc.add('c');
        abc.add('d');
        abc.add('e');
        abc.add('f');
        abc.add('g');
        for (int i=0;i<abc.size();i++){
            System.out.print(abc.get(i)+"\t");
        }
    }
}
