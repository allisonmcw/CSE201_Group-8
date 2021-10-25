
import java.util.Arrays;
public class NameSort{ 
	public static void main(String[] args) { 
		String[] appNames = new String[10];
		
		appNames[0] = "spotify";
		appNames[1] = "canvas";
		appNames[2] = "subway surfers";
		appNames[3] = "candy crush";
		appNames[4] = "sound cloud";
		appNames[5] = "roblox";
		appNames[6] = "youtube";
		appNames[7] = "netflix";
		appNames[8] = "snapchat";
		appNames[9] = "instagram";
		
		for (String name: appNames) { 
			System.out.println(name); 
		}
		
		System.out.println(); 
		String[] sorted = sortNames(appNames); 
		for (String name: sorted) { 
			System.out.println(name); 
		}
	} 
	
	
	
	public static String[] sortNames(String[] names) { 
		String[] sorted = Arrays.copyOf(names, 10); 
		Arrays.sort(sorted);
		return sorted; 
	}
}


	
	

