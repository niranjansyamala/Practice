package Access;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShellExecutor {

	public static void main(String[] args) throws IOException, InterruptedException {
		ProcessBuilder pb = new ProcessBuilder("sudo","-c", "sh","/home/niranjan/Practice/src/main/resources/update.sh");
		Process p = pb.start();
		BufferedReader reader = new BufferedReader(new InputStreamReader(p.getErrorStream()));
		String line = null;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);

		}
	}

}
