package exception;

public class ResourceException extends Exception {
	private static final long serialVersionUID = 5600944845164027916L;

	public ResourceException() {
		super();
	}

	public ResourceException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public ResourceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public ResourceException(String arg0) {
		super(arg0);
	}

	public ResourceException(Throwable arg0) {
		super(arg0);
	}
}
