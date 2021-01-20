/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package argumen;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *
 * @author warnaagung
 */
public class Argumen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /////
        try {

		// -- Linux --

		// Run a shell command
		// Process process = Runtime.getRuntime().exec("ls /home/mkyong/");

		// Run a shell script
		// Process process = Runtime.getRuntime().exec("path/to/hello.sh");

		// -- Windows --

		// Run a command
		//Process process = Runtime.getRuntime().exec("cmd /c dir C:\\Users\\mkyong");

		//Run a bat file
		Process process = Runtime.getRuntime().exec( "cmd /c WinDump.exe -i \\Device\\NPF_{02BA5D3A-3D33-46F5-9599-C4B1A050004D} dst host 192.168.6.170 and dst port 80", null, new File("C:\\temp\\"));

		StringBuilder output = new StringBuilder();

		BufferedReader reader = new BufferedReader(
				new InputStreamReader(process.getInputStream()));

		String line;
		while ((line = reader.readLine()) != null) {
			output.append(line + "\n");
                        System.out.println(line);
		}

		int exitVal = process.waitFor();
		if (exitVal == 0) {
			System.out.println("Success!");
			System.out.println(output);
			System.exit(0);
		} else {
			//abnormal...
		}

	} catch (IOException e) {
		e.printStackTrace();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
        /////
    }
    
}
