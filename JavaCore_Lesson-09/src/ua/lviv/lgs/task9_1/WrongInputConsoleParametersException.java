package ua.lviv.lgs.task9_1;

public class WrongInputConsoleParametersException extends Exception {

	private String message;

	public WrongInputConsoleParametersException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
		
}
