import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;

import static java.lang.StackWalker.Option.RETAIN_CLASS_REFERENCE;

public class Log {

    static void logLine(String b){
        StackWalker walker = StackWalker.getInstance(RETAIN_CLASS_REFERENCE);
        Class<?> callerClass = walker.getCallerClass();
        String a = callerClass.getName();
        System.out.println("[" + time() + "|" + a + "]" + " " + b);
    }
    static void logLine(int b){
        StackWalker walker = StackWalker.getInstance(RETAIN_CLASS_REFERENCE);
        Class<?> callerClass = walker.getCallerClass();
        String a = callerClass.getName();
        System.out.println("[" + time() + "|" + a + "]" + " " + b);
    }
    static void logLine(boolean b){
        StackWalker walker = StackWalker.getInstance(RETAIN_CLASS_REFERENCE);
        Class<?> callerClass = walker.getCallerClass();
        String a = callerClass.getName();
        System.out.println("[" + time() + "|" + a + "]" + " " + b);
    }
    static void log(String b){
        StackWalker walker = StackWalker.getInstance(RETAIN_CLASS_REFERENCE);
        Class<?> callerClass = walker.getCallerClass();
        String a = callerClass.getName();
        System.out.print("[" + time() + "|" + a + "]" + " " + b);
    }
    private static void logLine(String a, String b){
        System.out.println("[" + time() + "|" + a + "]" + " " + b);
    }
    static void log(String[] b){
        StackWalker walker = StackWalker.getInstance(RETAIN_CLASS_REFERENCE);
        Class<?> callerClass = walker.getCallerClass();
        String a = callerClass.getName();
        Log.logLine("#############################################################");
        for(int c = 0; c < b.length; c++){
            Log.logLine(a, "[" + c + "/" + (b.length - 1) + "]" + b[c]);
        }
        Log.logLine("#############################################################");
    }
    static String time(){
        return "" + java.time.LocalTime.now();
    }
    private static void saveFile(String file, String[][] data) {

        FileWriter fr;
        BufferedWriter br;
        try {
            File f = new File(Log.class.getResource("").getFile() + file);
            Log.logLine("Saving data to " + f);
            fr = new FileWriter(f);
            br = new BufferedWriter(fr);
            for (String[] dat:
                    data) {
                for (String da:
                        dat) {
                    String a = da + "~~";
                    br.append(a);
                }
                br.append("\n");
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void log(String b, String[] c) {
        StackWalker walker = StackWalker.getInstance(RETAIN_CLASS_REFERENCE);
        Class<?> callerClass = walker.getCallerClass();
        String a = callerClass.getName();
        Log.logLine("#############################################################");
        for(int d = 0; d < c.length; d++){
            Log.logLine(a, "[" + b + "]" + "[" + d + "/" + (c.length - 1) + "]" + c[d]);
        }
        Log.logLine("#############################################################");
    }
    public static void logLine(InetAddress address) {
        StackWalker walker = StackWalker.getInstance(RETAIN_CLASS_REFERENCE);
        Class<?> callerClass = walker.getCallerClass();
        String a = callerClass.getName();
        System.out.println("[" + time() + "|" + a + "]" + " " + address);
    }
}
