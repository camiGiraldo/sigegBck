package co.edu.exceptions;

public class ZMessManager extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ZMessManager(String exception) {
		super(exception);
	}

	public static class InvalidEntityException extends ZMessManager {

		private static final long serialVersionUID = 1L;

		public InvalidEntityException(String exception) {
			super(exception);
		}

	}

	public static class TransactionException extends ZMessManager {
		private static final long serialVersionUID = 1L;

		public TransactionException(String exception) {
			super(exception);
		}
	}

}
