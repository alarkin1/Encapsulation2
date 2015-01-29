package startup.gui.fix.srp;

/**
 * This class represents a simulation of a real part (product).
 * 
 * @author      Jim Lombardo, WCTC Lead Java Instructor
 * @version     1.00
 */
public class Part {
    private String partNumber;
    private String partDesc;
    private double partPrice;
    
    private final String PARTNO_ERR_MSG = 
            "Part Number is a mandatory field";
    private final String PARTDESC_ERR_MSG = 
            "Part Description is a mandatory field";

    public Part() {
    }

    public Part(String partNumber, String partDesc, double partPrice) {
        this.partNumber = partNumber;
        this.partDesc = partDesc;
        this.partPrice = partPrice;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        if(partNumber == null || partNumber.length() == 0) {
            throw new IllegalArgumentException(PARTNO_ERR_MSG);
        }
        this.partNumber = partNumber;
    }

    public String getPartDesc() {
        return partDesc;
    }

    public void setPartDesc(String partDesc) {
        if(partDesc == null || partDesc.length() == 0) {
            throw new IllegalArgumentException(PARTDESC_ERR_MSG);
        }
        this.partDesc = partDesc;
    }

    public double getPartPrice() {
        return partPrice;
    }

    public void setPartPrice(double partPrice) {
        this.partPrice = partPrice;
    }
    
    
}
