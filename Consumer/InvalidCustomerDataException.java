package Consumer;
public class InvalidCustomerDataException extends RuntimeException
{
    public InvalidCustomerDataException(String message) {
        super(message);
    }
}