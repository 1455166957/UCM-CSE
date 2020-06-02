import java.util.Scanner;

public class Student {
    private String name;
    private char gender;
    private Date birthdate;
    private Preference pref;
    private boolean matched = false;

    public Student(Scanner line) {
        name = line.next();
        String tmpStr = line.next();
        if (tmpStr.length() > 1) {
            name += " " + tmpStr;
            gender = line.next().charAt(0);
        }
        else {
            gender = tmpStr.charAt(0);
        }
        birthdate = new Date(line);
        pref = new Preference(line);
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public Preference getPref() {
        return pref;
    }

    public boolean getMatched() {
        return matched;
    }

    public void setMatched() {
        matched = true;
    }

    public int compare(Student st) {
        if (gender != st.gender)
            return 0;
        else {
            int ageDifference = birthdate.compare(st.birthdate);
            int prefDifference = pref.compare(st.pref);
            return (40 - prefDifference) + (60 - ageDifference);
        }
    }


}
