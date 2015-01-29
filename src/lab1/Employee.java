package lab1;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * In this lab your challenge is to fix the code in both classes to use proper
 * encapsulation and the other best practices as explained by your instructor.
 *
 * @author Jim Lombardo, WCTC Instructor
 * @version 1.01
 */
public class Employee {

    private String firstName;
    private String lastName;
    private String ssn;
//focus above     

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        //needs validation
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        //needs validation
        this.lastName = lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        //needs validation
        this.ssn = ssn;
    }

//above firstName,lastName,and ssn setters    
    private Date birthDate;
    private boolean metWithHr;
    private boolean metDeptStaff;
    private boolean reviewedDeptPolicies;
    private boolean movedIn;
    private String cubeId;
    private Date currentDate;

    public Employee(String firstName, String lastName, String ssn) {
        setFirstName(firstName);
        setLastName(firstName);
        setSsn(ssn);
        meetDepartmentStaff();
        meetWithHrForBenefitAndSalryInfo();
        reviewDeptPolicies();
        currentDate = new Date();
    }

    // Assume this must be performed first
    public void meetWithHrForBenefitAndSalryInfo() {
        System.out.println("Met with Hr on " + formatDateAndReturn());
        metWithHr = true;
    }

    // Assume this is must be performed second
    public void meetDepartmentStaff() {
        if (metWithHr) {
            System.out.println("Met with Dept. Staff on " + formatDateAndReturn());
            metDeptStaff = true;
        } else {
            System.out.println("Sorry, you cannot meet with "
                    + "department staff until you have met with HR.");
        }
    }

    // Assume this must be performed third
    public void reviewDeptPolicies() {
        if (metWithHr && metDeptStaff) {
            System.out.println("Reviewed Dept. Policies on " + formatDateAndReturn());
            reviewedDeptPolicies = true;
        } else {
            System.out.println("Sorry, you cannot review "
                    + " department policies until you have first met with HR "
                    + "and then with department staff.");
        }
    }

    // Assume this must be performed 4th
    public void moveIntoCubicle(String cubeId) {
        if (metWithHr && metDeptStaff && reviewedDeptPolicies) {
            System.out.println("Moved into cube on " + formatDateAndReturn());
            this.cubeId = cubeId;
            this.movedIn = true;
        } else {
            System.out.println("Sorry, you cannot move in to a "
                    + "cubicle until you have first met with HR "
                    + "and then with department staff, and then reviewed"
                    + "department policies.");
        }

    }

    public String getStatus() {
        if (metWithHr && metDeptStaff
                && reviewedDeptPolicies && movedIn) {
            return "Orientation is completed on: " + formatDateAndReturn();
        } else {
            return formatDateAndReturn() + ": Orientation in progress...";
        }
    }

    private String formatDateAndReturn() {
        //New date format
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        String fmtDate = sdf.format(currentDate);
        return fmtDate;
        
    }

}
