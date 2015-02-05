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
//focus above     

    private void setFirstName(String firstName) {
        //needs validation
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        //needs validation
        this.lastName = lastName;
    }

    private void setSsn(String ssn) {
        //needs validation
        this.ssn = ssn;
    }

    private void setCubeId(String cubeId) {
        this.cubeId = cubeId;
    }

    private void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    
    
    

//above firstName,lastName,and ssn setters    
    
    private String firstName;
    private String lastName;
    private String ssn;
    private Date birthDate;
    private boolean metWithHr;
    private boolean metDeptStaff;
    private boolean reviewedDeptPolicies;
    private boolean movedIn;
    private String cubeId;
    private Date currentDate;

    public Employee(String firstName, String lastName, String ssn,String cubeId) {
        setFirstName(firstName);
        setLastName(firstName);
        setSsn(ssn);
        setBirthDate(birthDate);
        setCubeId(cubeId);
        currentDate = new Date();
        
        meetWithHrForBenefitAndSalryInfo();
        meetDepartmentStaff();
        reviewDeptPolicies();
        moveIntoCubicle(cubeId);
        
        System.out.println("The employee's status is: " + getStatus());
    }

    // Assume this must be performed first
    private void meetWithHrForBenefitAndSalryInfo() {
        System.out.println("Met with Hr on " + formatDateAndReturn());
        metWithHr = true;
    }

    // Assume this is must be performed second
    private void meetDepartmentStaff() {
        if (metWithHr) {
            System.out.println("Met with Dept. Staff on " + formatDateAndReturn());
            metDeptStaff = true;
        } else {
            System.out.println("Sorry, you cannot meet with "
                    + "department staff until you have met with HR.");
        }
    }

    // Assume this must be performed third
    private void reviewDeptPolicies() {
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
    private void moveIntoCubicle(String cubeId) {
        if (metWithHr && metDeptStaff && reviewedDeptPolicies) {
            System.out.println("Moved into cube on " + formatDateAndReturn());
            this.cubeId = cubeId;
            movedIn = true;
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