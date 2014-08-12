/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashablezipcreator.Operations;

import flashablezipcreator.DiskOperations.Read;
import flashablezipcreator.FlashableZipCreator;
import flashablezipcreator.Protocols.Jar;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.jar.JarFile;
import javax.swing.JOptionPane;

/**
 *
 * @author nikhil
 */
public class JarOperations {

    public static ArrayList<String> themesList = new ArrayList<>();
    public static ArrayList<String> themesFileList = new ArrayList<>();
    public static ArrayList<String> otherList = new ArrayList<>();
    public static ArrayList<String> binaryList = new ArrayList<>();
    public static byte[] neon_binary = null;
    public static byte[] non_neon_binary = null;
    public static String supported_devices = null;

    public static InputStream getInputStream(String path) {
        return FlashableZipCreator.class.getResourceAsStream(path.replaceAll("\\\\", "/"));
    }

    public static void setJarFileList() throws IOException {
        Read r = new Read();
        if (Jar.isExecutingThrough()) {
            System.out.println("Executing Through Jar..!!");
            try {
                try (JarFile jarFile = new JarFile(Jar.getFileName())) {
                    for (Enumeration em = jarFile.entries(); em.hasMoreElements();) {
                        String s = em.nextElement().toString();
                        if (s.startsWith("flashablezipcreator/META-INF/")) {
                            s = s.substring("flashablezipcreator/".length(), s.length());
                            String theme = "META-INF/com/google/android/aroma/themes";
                            if (s.startsWith(theme) && (s.endsWith(".prop") || s.endsWith(".png"))) {
                                if (s.endsWith(".prop")) {
                                    theme = s.substring(theme.length() + 1, s.length());
                                    theme = theme.substring(0, theme.indexOf("/"));
                                    themesList.add(theme);
                                }
                                themesFileList.add(s);
                            } else if (s.endsWith(".ttf") || s.endsWith(".png") || s.endsWith(".lang") || s.endsWith(".txt")
                                    || s.endsWith(".edify") || s.endsWith(".sh") || s.contains("displaycapture") || s.contains("sleep")) {
                                otherList.add(s);
                            } else if (s.equals("META-INF/com/google/android/neon")) {
                                neon_binary = r.getBytesFromFile(getInputStream(s));
                            } else if (s.equals("META-INF/com/google/android/nonneon")) {
                                non_neon_binary = r.getBytesFromFile(getInputStream(s));
                            } else if (s.endsWith("Supported Devices")) {
                                supported_devices = r.getStringFromFile(getInputStream(s));
                            } else if (s.startsWith("META-INF/com/google/android/binary-files/")){
                                binaryList.add(s);
                            }
                        }
                    }
                }
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("Executing Through Netbeans..!!");
        }
    }

    //this will be shifted to appropriate class later.
    public void getSystemOS() {
        String OS = "";
        if (Jar.isExecutingThrough()) {
            String path[] = this.getClass().getResource("META-INF/com/google/android/Supported Devices").getPath().split("!");
            if (path[0].startsWith("file:/home") || path[0].startsWith("file:/media")) {
                OS = "Linux";
            } else {
                OS = "Windows";
            }
        } else {
            File f = new File("src");
            if (f.getAbsolutePath().contains("/")) {
                OS = "Linux";
            } else {
                OS = "Windows";
            }
        }
        System.out.println(OS + " Operating System Found..!!");
    }

    public String getKernelMountPoint() {
        String selectedDevice = "";
        try {
            InputStream is;
            BufferedReader br;
            is = this.getClass().getResourceAsStream("META-INF/com/google/android/mount-points/" + selectedDevice);
            br = new BufferedReader(new InputStreamReader(is));
            String mp = br.readLine();
            br.close();
            is.close();
            System.out.println("Returning mount point : " + mp);
            return mp;
        } catch (NullPointerException npe) {
            //this.isMountPointAvailable = false;
            System.out.println("Mount Point Not Found..!!");
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }
        return null;
    }
}
