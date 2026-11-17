public class Student {

    int id;
    String name;
    double grade;

    Student(int id, String name, double grade){
        this.id = id;
        this.name = name;
        this.grade = grade;


    }
    public String toString(){
        return id + " | " + name + " | " + grade + " | " + getGradeLetter();
    }

    public String toFileString(){
        return id + "," + name + "," + grade;
    }

    public String getGradeLetter(){
        if(grade >= 75){
            return "A";
        }
        else if(grade >= 65){
            return "B";
        }
        else if(grade >= 55){
            return "C";
        }
        else if(grade >= 35){
            return "S";
        }
        else{
            return "F";
        }
    }
}

