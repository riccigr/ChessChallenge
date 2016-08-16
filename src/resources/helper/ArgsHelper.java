package resources.helper;

/**
 * Class created to support arguments validation.
 * 
 * @author Guilherme Ricci
 *
 */
public class ArgsHelper {

	String[] args;
	
	public ArgsHelper(String[] args){
		this.args = args;
	}

	/**
	 * Validate if all current 7 elements was included.
	 * 
	 * @return boolean
	 */
	public boolean hasEnoughParams() {
		if(args.length == 7){
			return true;
		}
		return false;
	}

	
	/**
	 * Validate if parameter exists and can be converted to Integer without exception.
	 * 
	 * @param index
	 * @return
	 */
	public boolean isNumeric(int index) {
	     try {  
	         Integer.parseInt(args[index]);  
	         return true;  
	      } catch (NumberFormatException e) {  
	    	  throw new NumberFormatException();
	      } catch (IndexOutOfBoundsException e) {  
	    	  throw new NumberFormatException();
	      }
	}

	/**
	 * Convert String parameter in Integer, but return 0 in case of exception.
	 * 
	 * @param index
	 * @return
	 */
	public int convertStringToInteger(int index) {
		if(isNumeric(index)){
			return Integer.parseInt(args[index]);
		}
		return 0;
	}
	
}
