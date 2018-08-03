package test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class getDefaultBrowser {
	
	public static String get_windwos_browser() {
		try {
			// Get registry where we find the default browser
			Process process = Runtime.getRuntime().exec("REG QUERY HKEY_CLASSES_ROOT\\http\\shell\\open\\command");
			Scanner kb = new Scanner(process.getInputStream());
			while (kb.hasNextLine()) {
				// Get output from the terminal, and replace all '\' with '/' (makes regex a bit
				// more manageable)
				String registry = (kb.nextLine()).replaceAll("\\\\", "/").trim();
				
				// Extract the default browser
				Matcher matcher = Pattern.compile("/(?=[^/]*$)(.+?)[.]").matcher(registry);
				if (matcher.find()) {
					// Scanner is no longer needed if match is found, so close it
					kb.close();
					String defaultBrowser = matcher.group(1);

					// Capitalize first letter and return String
					defaultBrowser = defaultBrowser.substring(0, 1).toUpperCase()
							+ defaultBrowser.substring(1, defaultBrowser.length());
					return defaultBrowser;
				}
			}
			// Match wasn't found, still need to close Scanner
			kb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Have to return something if everything fails
		return "Error: Unable to get default browser";
	}
	
	
	public static String get_linux_browser() {
		Runtime r = Runtime.getRuntime();
		Process p;
		try {
			p = r.exec("xdg-settings get default-web-browser");
			//p.waitFor();
			BufferedReader b = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line ="";
			while ((line = b.readLine()) != null) {
				//System.out.println(line);
				return line;
			}
			b.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Error: Unable to get default browser";
	}
}
