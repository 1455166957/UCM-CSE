import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Match {

    public static int read(Student[] students) throws IOException {
        Scanner kbd = new Scanner(System.in);
        String filename = kbd.next();
        kbd.close();
        Scanner input = new Scanner(new FileReader(filename));
        int studentNum = 0;
        Scanner line;
        while(input.hasNextLine()) {
            line = new Scanner(input.nextLine());
            line.useDelimiter("[\t\r-]");
            while(line.hasNext()) {
                students[studentNum] = new Student(line);
                studentNum++;
            }
        }
        input.close();
        return studentNum;
    }
    public static void main(String[] args) throws IOException {
        Student[] students = new Student[100];
        int studentNum = read(students);
        int maxScore = 0;
        int currentScore = 0;
        int matchNum = -1;

        for (int i = 0; i < studentNum; i++) {
            if (!students[i].getMatched()) {
                for (int j = i + 1; j < studentNum; j++) {
                    if (!students[j].getMatched()) {
                        currentScore = students[i].compare(students[j]);
                        if (currentScore > maxScore) {
                            maxScore = currentScore;
                            matchNum = j;
                        }
                    }
                }
                if (maxScore > 0) {
                    students[i].setMatched();
                    students[matchNum].setMatched();
                    System.out.print(students[i].getName() + " matches with " + students[matchNum].getName());
                    System.out.println(" with the score " + maxScore);
                } else
                    System.out.println(students[i].getName() + " has no matches.");
            }
            maxScore = 0;
        }
    }
}
