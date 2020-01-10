package cmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Crunchify.com
 * Execute Linux commands using Java. We are executing mkdir, ls -ltra and ping in this tutorial
 */

public class RunCommand {
    public printOutput getStreamWrapper(InputStream is) {
        return new printOutput(is);
    }

    public static void main(String[] args) {

        Runtime rt = Runtime.getRuntime();
        RunCommand rte = new RunCommand();
        printOutput errorReported, outputMessage;

        try {
            Process proc = rt.exec("git");
            errorReported = rte.getStreamWrapper(proc.getErrorStream());
            outputMessage = rte.getStreamWrapper(proc.getInputStream());
            errorReported.start();
            outputMessage.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Process proc = rt.exec("powershell dir");
            errorReported = rte.getStreamWrapper(proc.getErrorStream());
            outputMessage = rte.getStreamWrapper(proc.getInputStream());
            errorReported.start();
            outputMessage.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Process proc = rt.exec("ping localhost");
            errorReported = rte.getStreamWrapper(proc.getErrorStream());
            outputMessage = rte.getStreamWrapper(proc.getInputStream());
            errorReported.start();
            outputMessage.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static class printOutput extends Thread {
        InputStream is;

        printOutput(InputStream is) {
            this.is = is;
        }

        public void run() {
            String s;
            try {
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(is));
                while ((s = br.readLine()) != null) {
                    System.out.println(s);
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
}