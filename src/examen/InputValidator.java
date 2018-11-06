package examen;

public class InputValidator {
	
	private String[] data;
	private boolean is_valid;
	
	
	public boolean is_valid() {
		return this.is_valid;
	}
	public boolean validate(String line) {
		try {
			assert line != null;
			this.data = line.split(",");
			//for(int i=0; i<8;i++) System.out.println(data[i]);
			this.is_valid = true;
			return this.is_valid;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			this.is_valid = false;
			return this.is_valid;
		}
	}
	
	public String[] getData() {
		return this.data;
	}
}
