import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students= new ArrayList<>();

        loadFromFile(students);

        System.out.println("*** STUDENT MANAGEMENT ***");
        while(true){

            System.out.println("1. Add Student");
            System.out.println("2. View All");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Show Stats");
            System.out.println("6. Sort by Grade");
            System.out.println("7. Exit");
            int choice = getIntInPut(scanner, "Choice: ");

            if(choice == 1){
                int id;
                while(true){
                    id = getIntInPut(scanner, "ID: ");

                    boolean exists = false;
                    for (Student s : students){
                        if(s.id == id){
                            exists = true;
                            break;
                        }
                    }
                    if(exists){
                        System.out.println("This ID already used.");
                    }
                    else {
                        break;
                    }
                }

                String name;
                while(true){
                    System.out.print("Name: ");
                    name = scanner.nextLine().toLowerCase();
                    if(name.trim().isEmpty()){
                        System.out.println("plz enter name.");
                    }
                    else{
                        break;
                    }
                }

                double grade;
                while(true){
                    grade = getDoubleInput(scanner, "Grade(0-100): ");
                    if(grade < 0 || grade > 100){
                        System.out.println("Enter valued grade between 0 and 100.");
                    }
                    else{
                        break;
                    }
                }

                students.add(new Student(id,name, grade));
                saveToFile(students);

                System.out.println("Saved!");

            }
            else if(choice == 2){
                if(students.isEmpty()){
                    System.out.println("Empty!");
                }
                System.out.println("-----------------------------------");
                for(Student s: students){
                    System.out.println(s);
                }
                System.out.println("-----------------------------------");
            }
            else if(choice == 3){

                int searchId = getIntInPut(scanner, "Search ID: ");

                boolean found = false;
                for(Student s : students){
                    if(s.id == searchId){
                        System.out.println("Found: " + s);
                        found = true;
                    }
                }
                if(!found){
                    System.out.println("Not found!");
                }
            }
            else if(choice == 4){

                int deleteID = getIntInPut(scanner, "Delete ID: ");

                boolean removed = students.removeIf(s -> s.id == deleteID);
                if(removed){
                    saveToFile(students);
                    System.out.println("Deleted!");
                }
                else{
                    System.out.println("Not found this ID. Use valued ID.");
                }

            }
            else if(choice == 5){
                if(students.isEmpty()){
                    System.out.println("Empty");
                }
                else{
                    double total = 0;
                    Student top = students.get(0);
                    for(Student s : students) {
                        total += s.grade;
                        if(s.grade > top.grade){
                            top = s;
                        }
                    }
                    double avg = total / students.size();
                    System.out.println("-----------------------------------");
                    System.out.println("Total Students : " + students.size());
                    System.out.printf("Average Grade: %.2f" , avg);
                    System.out.println();
                    System.out.println("Top Student: " + top);
                    System.out.println("-----------------------------------");
                }
            }
            else if (choice == 6) {
                students.sort((a,b) ->Double.compare(b.grade, a.grade));
                System.out.println("Sorted by using maximum to minimum.");
                System.out.println("-----------------------------------");
                for (Student s : students){
                    System.out.println(s);
                }
                System.out.println("-----------------------------------");
            }
            else if(choice == 7){
                System.out.println("End");
                break;
            }
            else{
                System.out.println("invalid choice.");
            }
        }



    }
    public static void saveToFile(ArrayList<Student> students){
        try{
            FileWriter writer = new FileWriter("students.txt");
            for(Student s: students){
                writer.write(s.toFileString() + "\n");
            }
            writer.close();
        }
        catch(IOException e){
            System.out.println("can't save" + e.getMessage());
        }
    }
    public static void loadFromFile(ArrayList<Student> students){
        try{
            File file = new File("students.txt");
            if(!file.exists()) return;
            Scanner fileScanner = new Scanner(file);
            while(fileScanner.hasNextLine()){
                String line = fileScanner.nextLine();
                if(line.trim().isEmpty()) continue;

                try{
                    String[] parts = line.split(",");
                    if(parts.length == 3){
                        int id = Integer.parseInt(parts[0].trim());
                        String name = parts[1].trim();
                        double grade = Double.parseDouble(parts[2].trim());
                        students.add(new Student(id, name, grade));
                    }
                    else {
                        System.out.println("wrong line skipped." + line);
                    }
                }
                catch(Exception e){
                    System.out.println("wrong line skipped." + line);
                }
            }
            fileScanner.close();
        }
        catch (Exception e){
            System.out.println("Can't load.");
        }
    }

    public static int getIntInPut(Scanner scanner, String message){
        while(true){
            System.out.print(message);
            try{
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            }
            catch(Exception e){
                System.out.println("Use Integer numbers.");
                scanner.nextLine();
            }
        }
    }

    public static double getDoubleInput(Scanner scanner, String message){
        while(true){
            System.out.print(message);
            try{
                double value = scanner.nextDouble();
                scanner.nextLine();
                return value;
            }
            catch(Exception e){
                System.out.println("Use double numbers.");
                scanner.nextLine();
            }

        }
    }

}
