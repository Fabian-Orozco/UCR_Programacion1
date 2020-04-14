import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * The LabClass class represents an enrolment list for one lab class. It stores
 * the time, room and participants of the lab, as well as the instructor's name.
 * 
 * @author Michael Kölling and David Barnes
 * @version 2016.02.29
 */
public class LabClass
{
    private String instructor;
    private String room;
    private String timeAndDay;
    private ArrayList<Student> students; //Conjunto de estudiantes
    private int capacity;
    private String courseName; //setCoursetName(nombre), getCourseName(), showCourseName()

    /**
     * Create a LabClass with a maximum number of enrolments. All other details
     * are set to default values.
     */
    public LabClass(int maxNumberOfStudents)
    {
        instructor = "unknown";
        room = "unknown";
        timeAndDay = "unknown";
        courseName = "unknown";
        students = new ArrayList<Student>();
        capacity = maxNumberOfStudents;
    }

    public void setCourseName(String courseName)
    {
        this.courseName = courseName;
    }
    
    public void setCapacityLab(int capacity)
    {
        this.capacity = capacity;
    }
    
    /**
     * Add a student to this LabClass.
     */
    public void enrollStudent(Student newStudent)
    {
        if(students.size() == capacity) {
            System.out.println("The class is full, you cannot enrol.");
        }
        else {
            students.add(newStudent);
        }
    }

    /**
     * Return the number of students currently enrolled in this LabClass.
     */
    public int numberOfStudents()
    {
        return students.size();
    }

    /**
     * Set the room number for this LabClass.
     */
    public void setRoom(String roomNumber)
    {
        room = roomNumber;
    }

    /**
     * Set the time for this LabClass. The parameter should define the day
     * and the time of day, such as "Friday, 10am".
     */
    public void setTime(String timeAndDayString)
    {
        timeAndDay = timeAndDayString;
    }

    /**
     * Set the name of the instructor for this LabClass.
     */
    public void setInstructor(String instructorName)
    {
        instructor = instructorName;
    }

    /**
     * Print out a class list with other LabClass details to the standard
     * terminal.
     */
    public void printList()
    {
        System.out.println("Lab class: " + courseName + "\nCapacity: " + capacity + "\nDatetime: "+timeAndDay);
        System.out.println("Room: " + room + "\nInstructor: " + instructor);
        System.out.println("\nClass list:");
        for(Student student : students) {
            student.print2();
        }
        System.out.println("\nNumber of students: " + numberOfStudents());
    }

    public static void main (String args[]){
        String menu="1.Definir datos del curso\n2.Definir datos del docente"+
            "\n3.Inscribir estudiantes\n4.Mostrar la lista\n5.Terminar";
        int op=0;
        String instructor="";
        String room="";
        String timeAndDay="";
        String courseName="";
        Student st=null; //Conjunto de estudiantes
        int capacity=0;
        String name="";
        // the student ID
        String id="";
        // the amount of credits for study taken so far
        int credits=0;

        // modificaciones
        String email=""; //correo electrónico
        double ira=0;
        LabClass group = new LabClass(20);

        do{
            op=Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (op){
                case 1://definir datos del curso
                courseName = JOptionPane.showInputDialog(null,"Defina el nombre del curso","Curso",JOptionPane.QUESTION_MESSAGE);
                capacity = Integer.parseInt(JOptionPane.showInputDialog(null,"Defina la papacidad del curso: " + courseName,"Capacidad",JOptionPane.QUESTION_MESSAGE));
                timeAndDay = JOptionPane.showInputDialog(null,"Defina día y hora del curso: "+ courseName,"Horario",JOptionPane.QUESTION_MESSAGE);
                room = JOptionPane.showInputDialog(null,"Defina el número de aula que ocupará el curso: " + courseName,"Aula",JOptionPane.QUESTION_MESSAGE);
                
                group.setCourseName(courseName);
                group.setCapacityLab(capacity);
                group.setTime(timeAndDay);
                group.setRoom(room);
                break;

                case 2://definir datos del docente
                instructor = JOptionPane.showInputDialog(null,"Defina el nombre del docente que impartirá el curso: " + courseName,"Docente",JOptionPane.QUESTION_MESSAGE);
                group.setInstructor(instructor);
                break;
                
                case 3://inscribir estudiantes
                name=JOptionPane.showInputDialog("nombre?");
                id=JOptionPane.showInputDialog("carne?");
                email=JOptionPane.showInputDialog("email?"); //correo electrónico
                ira=Double.parseDouble(JOptionPane.showInputDialog("ira?"));
                st = new Student(name,id);
                st.setEmail(email);
                st.setIra(ira);
                group.enrollStudent(st);
                break;
                case 4://Mostrar la lista
                group.printList();
                break;
                default: //Terminar
                break;
            }
        }while(op!=5);
    }
}
