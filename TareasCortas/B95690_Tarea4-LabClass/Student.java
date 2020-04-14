import javax.swing.JOptionPane;

/**
 * The Student class represents a student in a student administration system.
 * It holds the student details relevant in our context.
 * 
 * @author Michael Kölling and David Barnes
 * @version 2016.02.29
 */
public class Student
{
    // the student's full name
    private String name;
    // the student ID
    private String id;
    // the amount of credits for study taken so far
    private int credits;

    // modificaciones
    private String email; //correo electrónico
    private double ira;   //indice de rendimiento académico

    /**
     * Create a new student with a given name and ID number.
     */
    public Student(String fullName, String studentID)
    {
        name = fullName;
        id = studentID;
        credits = 0;
    }

    /**
     * Return the full name of this student.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Set a new name for this student.
     */
    public void changeName(String replacementName)
    {
        name = replacementName;
    }

    /**
     * Return the student ID of this student.
     */
    public String getStudentID()
    {
        return id;
    }

    /**
     * Add some credit points to the student's accumulated credits.
     */
    public void addCredits(int additionalPoints)
    {
        credits += additionalPoints;
    }

    /**
     * Return the number of credit points this student has accumulated.
     */
    public int getCredits()
    {
        return credits;
    }

    /**
     * Return the login name of this student. The login name is a combination
     * of the first four characters of the student's name and the first three
     * characters of the student's ID number.
     */
    public String getLoginName()
    {
        return name.substring(0,4) + id.substring(0,3);
    }

    /**
     * Print the student's name and ID number to the output terminal.
     */
    public void print()
    {
        System.out.println(name + ", student ID: " + id + ", credits: " + credits);
    }

    // Modificaciones
    /*
     * Set the email of this student.
     */
    public void setEmail(String e){
        email=e;
    }

    /**
     * Return the email of this student.
     */
    public String getEmail()
    {
        return email;
    }

    /*
     * set the average grade of this student.
     */
    public void setIra(double i)
    {
        ira=i;
    }

    /**
     * Return the average grade of this student.
     */
    public double getIra(){
        return ira;
    }

    /**
     * Print the student's name and ID number to the output terminal.
     */
    public void print2()
    {
        System.out.println(name + ", ID: " + id + ", credits: " 
        + credits + ", email: " + email + ", Average grade: " + ira);
    }

    public static void main (String a[]){
        Student e1=null; //Objeto solo tiene un tipo
        Student e2=null;
        Student e3=null;

        String name;
        // the student ID
        String id;
        // the amount of credits for study taken so far
        int credits;

        // modificaciones
        String email; //correo electrónico
        double ira;

        for (int i=0;i<3;i++){
            name=JOptionPane.showInputDialog("nombre?");
            id=JOptionPane.showInputDialog("carne?");
            email=JOptionPane.showInputDialog("email?"); //correo electrónico
            ira=Double.parseDouble(JOptionPane.showInputDialog("ira?"));

            switch (i){
                case 0:
                e1=new Student(name, id); //se reserva espacio para este objeto
                e1.setEmail(email);
                e1.setIra(ira);
                break;
                case 1:
                e2=new Student(name, id);
                e2.setEmail(email);
                e2.setIra(ira);
                break;
                default:
                e3=new Student(name, id);
                e3.setEmail(email);
                e3.setIra(ira);
            }
        }
        for (int i=0;i<3;i++){
            switch (i){
                case 0:
                e1.print2();
                break;
                case 1:
                e2.print2();
                break;
                default:;
                e3.print2();
            }
        }
        
    }
}
