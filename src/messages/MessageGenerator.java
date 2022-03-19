package messages;

import java.util.List;

public interface MessageGenerator {
	public abstract String getRandomMessage();
	public abstract List<String> getAllMessages();
}
