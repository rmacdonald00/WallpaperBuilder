package messages;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.json.simple.JSONValue;

public class MessageOptions implements MessageGenerator {
	private List<List<String>> phraseBuildingBlocks;
	private List<String> allMessages = null;
	
	public MessageOptions() {
		this.phraseBuildingBlocks = getPhraseBuildingBlocksFromFile("./src/config/messageData/AffirmationMessageOptions.json");
	}
	
	public MessageOptions (String messageDataFilepath) {
		this.phraseBuildingBlocks = getPhraseBuildingBlocksFromFile(messageDataFilepath);
	}
	
	public MessageOptions (List<List<String>> phraseBuildingBlocks) {
		this.phraseBuildingBlocks = phraseBuildingBlocks;
	}
	
	@SuppressWarnings("unchecked")
	private List<List<String>> getPhraseBuildingBlocksFromFile (String filepath) {
		String jsonFromFile = getFileContents(filepath);
		return (List<List<String>>) JSONValue.parse(jsonFromFile);
	}
	
	private String getFileContents(String filepath) {
		Scanner s = null;
		StringBuilder text = new StringBuilder();
		try {
			s = new Scanner(new File(filepath));
			while(s.hasNextLine()) {
				text.append(s.nextLine());
			}
		} catch (Exception e) {
			System.out.println("oops");
		}
		return text.toString();
	}

	@Override
	public String getRandomMessage() {
		if(allMessages == null) {
			setAllMessages();
		}
		Random random = new Random();
		return allMessages.get(random.nextInt(allMessages.size()));
	}

	@Override
	public List<String> getAllMessages() {
		if(allMessages == null) {
			setAllMessages();
		}
		return allMessages;
	}
	
	private void setAllMessages() {
		allMessages = new ArrayList<>();

		List<String> allMessages = getMessageCombinations(phraseBuildingBlocks);
		this.allMessages = allMessages;
	}


	private List<String> getMessageCombinations(List<List<String>> combinationOptions) {
		if(combinationOptions.size() == 1) {
			return combinationOptions.get(0);
		}
		
		List<String> newAdditions = new ArrayList<>();
		List<String> topLevelOpts = combinationOptions.get(0);
		for(String phrase : topLevelOpts) {
			List<String> suffixesToAppend = getMessageCombinations(combinationOptions.subList(1, combinationOptions.size()));
			for(String suffix : suffixesToAppend) {
				newAdditions.add((!phrase.isEmpty() && !suffix.isEmpty()) ? phrase + "\n" + suffix : phrase + suffix);
			}
		}
		return newAdditions;
	}
}
