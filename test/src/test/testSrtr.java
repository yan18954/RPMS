package test;

import java.io.*;
import java.util.Scanner;

public class testSrtr {

	public static void main(String[] args) {
		
		String myStr = getRunCmd("ipconfig");
		System.out.println(myStr);
		
		
		
	}
	
	static String getRunCmd(String cmd) {
		String line = "";
		String rtnText = "";
		try {

			Runtime r = Runtime.getRuntime();
			Process p = r.exec(cmd);
			System.out.println("cmd : "+cmd);
			p.waitFor();
			BufferedReader b = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((line = b.readLine()) != null) {
				System.out.println("line = "+line);
				rtnText = line;
				// return line;
			}
			b.close();
		} catch (IOException i) {
			System.out.println("IOException");
		} catch (InterruptedException e) {
			System.out.println("InterruptedException");
		}
		System.out.println("return txt :"+rtnText);
		return rtnText;
	}
	
	
	
	
	
	

	static String convertFormat(String portCfg) {

		switch (portCfg) {
		case "Hx16":
			portCfg = "Host: x16";
			break;
		case "Hx8x8":
			portCfg = "Host: x8x8";
			break;

		case "Dx16":
			portCfg = "Device: x16";
			break;
		case "Dx8x8":
			portCfg = "Device: x8x8";
			break;
		default:
			break;
		}

		return portCfg;

	}

	public static void fileReader(String filePath) {
		try {
			FileReader fr = new FileReader(filePath);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				if (line.compareTo("[PORT LIST START]") != 0) {

					System.out.println(line);
				}
				if (line.compareTo("[PORT LIST END]") == 0) {
					System.out.println("Port List End ... Break now");
					break;
				}
			}
		} catch (IOException e) {
			System.out.println(e);
		}

	}

	public static int[] swap(int[] value) {
		int temp = value[0];
		value[0] = value[1];
		value[1] = temp;
		return value;
	}

	public static void nine(int i, int j) {
		if (i < 10) {
			if (j < 10) {
				System.out.printf("%d * %d =%2d  ", i, j, i * j);
				nine(i, ++j);
			} else {
				System.out.printf("\n");
				nine(++i, 1);
			}
		}
	}

}
