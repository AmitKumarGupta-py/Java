package Day5;
public class TransactionLimitExceededException extends Exception {
    public TransactionLimitExceededException(String msg) {
        super(msg);
  }
}
