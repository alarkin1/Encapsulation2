package startup.gui.fix.srp;

import java.util.TreeMap;

/**
 * This class represents a fictional part manager that can operate on
 * part objects.
 * 
 * @author      Jim Lombardo, WCTC Lead Java Instructor
 * @version     1.00
 */
public class PartManager {
    private Part[] parts;  // in-memory storage

    /** default constructor */
    public PartManager() {
        // initialize array to zero size
        parts = new Part[0];

    }

    /** Gets all parts in an array */
    public Part[] getParts() {
        return parts;
    }
  
    /**
     * New parts are added to the in-memory array. But since arrays in Java
     * are fixed in size we need to create a new, temporary array that is 
     * one size larger than the real array of parts. Then copy everything
     * from the real array into the temp. The assign the real array to the 
     * temp and add the new part to now empty free space.
     * 
     * @param partNum - the part number
     * @param partDesc - the description
     * @param partPrice - the price of the part
     */
    public void addNewPart(String partNum, String partDesc, double partPrice) {
        if(partNum == null || partDesc == null || partNum.length() == 0 || partDesc.length() == 0) {
            throw new IllegalArgumentException("All fields manadatory when adding a part.");
        }
        Part part = new Part(partNum, partDesc, partPrice);
        Part[] temp = new Part[parts.length + 1];
        System.arraycopy(parts, 0, temp, 0, parts.length);
        parts = temp;
        parts[parts.length-1] = part;
    }
    
    public Part findByPartNumber(String partNumber) {
        if(partNumber == null || partNumber.length() == 0) {
            throw new IllegalArgumentException("Seach term for part number is mandatory");
        }
        Part part = null;
        
        for(Part p : parts) {
            if(p.getPartNumber().equalsIgnoreCase(partNumber)) {
                part = p;
                break;
            }
        }
        
        return part;
    }
    
    /**
     * Sorts the parts by part number. It does this by using a TreeMap,
     * which automatically sorts by the key. We'll use part number as that
     * key and store the actual part object as the value in the map. Then we
     * can retrieve all the values (in sorted order) as a collection, then
     * covert the colletion to an array and assign
     * that to the original parts array.
     */
    public void sortPartsByPartNumber() {
        if(parts.length > 0) {
            TreeMap<String,Part> map = new TreeMap<String,Part>();
            for(Part p: parts) {
                map.put(p.getPartNumber(),p);
            }
            parts = map.values().toArray(parts);
            
        }
    }

}
