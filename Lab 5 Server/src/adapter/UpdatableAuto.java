package adapter;

public interface UpdatableAuto {
	
	public void updateOptionSetName(String carName,
			String optionSetName, String newOptionSetName);
	
	public void updateOptionPrice(String carName,
			String optionSetName, String optionName, 
			double price);
	
}
