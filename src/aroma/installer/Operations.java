/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aroma.installer;

import java.awt.Component;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.commons.collections.map.MultiValueMap;

/**
 *
 * @author Nikhil
 */
public class Operations {
    
    String lastActionCommand = "";
    String updateBinaryPath = "";
    String zipDestination = "";
    String tempFolderPath = "";
    String selectedDevice = "";
    String aroma_config = "";
    String updater_script = "";
    
    ArrayList<String> CSDArrayList;
    ArrayList<String> groupArrayList = new ArrayList<>();
    ArrayList<String> systemList = new ArrayList<>();
    ArrayList<String> dataList = new ArrayList<>();
    ArrayList<String> bootAnimList = new ArrayList<>();
    ArrayList<String> ringtoneList = new ArrayList<>();
    ArrayList<String> notifList = new ArrayList<>();
    ArrayList<String> kernelList = new ArrayList<>();
    ArrayList<String> advancedList = new ArrayList<>();
    ArrayList<String> deleteApkList = new ArrayList<>();
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayList<String> jarFileList = new ArrayList<>();
    
    MultiValueMap map = new MultiValueMap();
    
    
    
    Operations(){
        
    }
    
    public void createZipAt(String destination) throws IOException{
        byte[] buffer = new byte[1024];
        File fileDest = new File(destination);
        System.out.println("Entered Create Zip");
        if(!fileDest.exists()){
            fileDest.createNewFile();
            System.out.println("File Created");
        }
        InputStream in = null;
        OutputStream out = null;
            out = new FileOutputStream(fileDest);
            ZipOutputStream zos = new ZipOutputStream(out);
        System.out.println("Output To : " + destination);
        
        //Write Apk, Zip, etc files to ZIP..
        
        for(String groupName: this.groupArrayList){
            for(String file: returnPathArray(groupName, map)){
                FileInputStream fin = new FileInputStream(new File(file));
                file = getNameFromPath(file);
                file = "customize/" + groupName + "/" + removeExtension(file) + "/" + file;
                ZipEntry ze = new ZipEntry(file);
                zos.putNextEntry(ze);
                int len;
                while ((len = fin.read(buffer)) > 0) {
                    zos.write(buffer, 0, len);
                }
                fin.close();
            }
        }
        
        //Write Jar Files to ZIP..
        
        for(String jarFileName : jarFileList()){
            System.out.println("File Name : " + jarFileName);
            in = this.getClass().getResourceAsStream(jarFileName);
            ZipEntry ze = new ZipEntry(jarFileName);
            zos.putNextEntry(ze);
            int len;
            while ((len = in.read(buffer)) > 0) {
                zos.write(buffer, 0, len);
            }
        }
        in.close();
        //Write updater script, aroma config, update binary file to ZIP..
        this.createAromaConfigFile();
        this.createUpdaterScriptFile();
        buffer = this.updater_script.getBytes();
        InputStream is = new ByteArrayInputStream(this.updater_script.getBytes());
        ZipEntry ze = new ZipEntry("META-INF/com/google/android/updater-script");
            zos.putNextEntry(ze);
            int len;
            while ((len = is.read(buffer)) > 0) {
                zos.write(buffer, 0, len);
            }
         buffer = this.aroma_config.getBytes();
         is = new ByteArrayInputStream(this.aroma_config.getBytes());
         ze = new ZipEntry("META-INF/com/google/android/aroma-config");
         zos.putNextEntry(ze);
         while ((len = is.read(buffer)) > 0) {
             zos.write(buffer, 0, len);
         }
         is.close();
         if(!this.selectedDevice.equals("")){
             in = this.getClass().getResourceAsStream("META-INF/com/google/android/binary files/" + this.selectedDevice + "/update-binary-installer");
         }
         else{
             in = new FileInputStream(new File(this.updateBinaryPath));
         }
         ze = new ZipEntry("META-INF/com/google/android/update-binary-installer");
         zos.putNextEntry(ze);
         while ((len = in.read(buffer)) > 0) {
             zos.write(buffer, 0, len);
         }
         in.close();
        //Closing Zip file..
        zos.closeEntry();
        zos.close();
        System.out.println("Folder successfully compressed");
    }
    
    public String removeExtension(String str){
        String tempString[] = str.split("\\.");
        for(int i = 1; i < tempString.length - 1 ; i++){
            tempString[0] = tempString[0] + "." + tempString[i];
        }
        return tempString[0];
    }
    
    public ArrayList<String> returnPathArray(String str, MultiValueMap mvm){
        Set entrySet = mvm.entrySet();
            Iterator it = entrySet.iterator();
            while(it.hasNext()){
                Map.Entry mapEntry = (Map.Entry) it.next();
                if(str.equals(mapEntry.getKey())){
                arrayList = (ArrayList<String>) map.get(mapEntry.getKey());
                }
            }
            return arrayList;
    }
    
    public void displayListInAroma(String heading, ArrayList<String> arrayList){
        
        if(!arrayList.isEmpty()){
            this.aroma_config = this.aroma_config + heading;
            for(String list : this.arrayList){
                this.aroma_config = this.aroma_config + ",\n\"" + list + "\", \"\", 2";
                //System.out.println("................" + this.returnPathArray(data_list, map));
                for(String list_files : this.returnPathArray(list, map)){
                    this.aroma_config = this.aroma_config + ",\n\"" + this.removeExtension(getNameFromPath(list_files)) + "\", \"\", 0";
                }
            }
            this.aroma_config = this.aroma_config + ");\n";
        }
    }
    
    public void createAromaConfigFile(){
        this.aroma_config = "fontresload(\"0\", \"ttf/Roboto-Regular.ttf\", \"12\");\n" +
                "fontresload(\"1\", \"ttf/Roboto-Regular.ttf\", \"18\");\n" +
                "theme(\"miui4\");\n";
        
        displayListInAroma("checkbox(\"App List\",\"Choose the apps to be installed to data\","+
                    "\"@personalize\",\"app_choices.prop\"", this.dataList);
        
        displayListInAroma("checkbox(\"System App List\",\"Choose the apps to be installed to system\","+
                    "\"@personalize\",\"system_app_choices.prop\"", this.systemList);
        
        displayListInAroma("selectbox(\"Boot Animations List\",\"Select Boot Animation to be used in current ROM\","+
                    "\"@default\",\"boot_anim_choices.prop\"", this.bootAnimList);
        
        displayListInAroma("selectbox(\"Kernel List\",\"Select Kernel to be flashed\","+
                    "\"@default\",\"kernel_choices.prop\"", this.kernelList);
                
        displayListInAroma("checkbox(\"Ringtone List\",\"Choose Ringtones to include in Rom\","+
                    "\"@personalize\",\"ringtone_choices.prop\"", this.ringtoneList);
        
        displayListInAroma("checkbox(\"Notification tone List\",\"Choose Notification Tones to include in Rom\","+
                    "\"@personalize\",\"notification_choices.prop\"", this.notifList);
        
        displayListInAroma("checkbox(\"Remove System Apps List\",\"Choose Apps To Remove\","+
                    "\"@personalize\",\"delete_choices.prop\"", this.deleteApkList);
        
        this.aroma_config = this.aroma_config + "setvar(\"installer_title\",\"You are about to install the following:\");\n" +
                "appendvar(\"installer_title\",\"\\n\\n\");\n";
        
        int s = 1, d = 1, k = 1, ba = 1, r = 1, n = 1, da = 1;
        
        for(String grouplist : groupArrayList){
            int i = 1;
            if(systemList.contains(grouplist)){
                for(String system_list: this.returnPathArray(grouplist, map)){
                    this.aroma_config = this.aroma_config + "appendvar(\"installer_title\",iif(prop(\"system_app_choices.prop\",\"item." + s + "." + i + "\")==\"1\",\"" + this.removeExtension(getNameFromPath(system_list)) + "\",\"\"));\n";
                    i++;
                }
                s++;
            }
            
            i = 1;
            if(dataList.contains(grouplist)){
                for(String data_list: this.returnPathArray(grouplist, map)){
                    this.aroma_config = this.aroma_config + "appendvar(\"installer_title\",iif(prop(\"app_choices.prop\",\"item." + d + "." + i + "\")==\"1\",\"" + this.removeExtension(getNameFromPath(data_list)) + "\",\"\"));\n";
                    i++;
                }
                d++;
            }
            
            i = 1;
            if(bootAnimList.contains(grouplist)){
                for(String list: this.returnPathArray(grouplist, map)){
                    this.aroma_config = this.aroma_config + "appendvar(\"installer_title\",iif(prop(\"boot_anim_choices.prop\",\"item." + ba + "." + i + "\")==\"1\",\"" + this.removeExtension(getNameFromPath(list)) + "\",\"\"));\n";
                    i++;
                }
                ba++;
            }
            
            i = 1;
            if(kernelList.contains(grouplist)){
                for(String list: this.returnPathArray(grouplist, map)){
                    this.aroma_config = this.aroma_config + "appendvar(\"installer_title\",iif(prop(\"kernel_choices.prop\",\"item." + k + "." + i + "\")==\"1\",\"" + this.removeExtension(getNameFromPath(list)) + "\",\"\"));\n";
                    i++;
                }
                k++;
            }
            
            i = 1;
            if(ringtoneList.contains(grouplist)){
                for(String list: this.returnPathArray(grouplist, map)){
                    this.aroma_config = this.aroma_config + "appendvar(\"installer_title\",iif(prop(\"ringtone_choices.prop\",\"item." + d + "." + i + "\")==\"1\",\"" + this.removeExtension(getNameFromPath(list)) + "\",\"\"));\n";
                    i++;
                }
                r++;
            }
            
            i = 1;
            if(notifList.contains(grouplist)){
                for(String list: this.returnPathArray(grouplist, map)){
                    this.aroma_config = this.aroma_config + "appendvar(\"installer_title\",iif(prop(\"notification_choices.prop\",\"item." + d + "." + i + "\")==\"1\",\"" + this.removeExtension(getNameFromPath(list)) + "\",\"\"));\n";
                    i++;
                }
                n++;
            }
            
            i = 1;
            if(deleteApkList.contains(grouplist)){
                for(String list: this.returnPathArray(grouplist, map)){
                    this.aroma_config = this.aroma_config + "appendvar(\"installer_title\",iif(prop(\"delete_choices.prop\",\"item." + d + "." + i + "\")==\"1\",\"" + this.removeExtension(getNameFromPath(list)) + "\",\"\"));\n";
                    i++;
                }
                da++;
            }
        }
        this.aroma_config = this.aroma_config + "writetmpfile(\"app_choices.prop\",readtmpfile(\"app_choices.prop\"));\n";
        this.aroma_config = this.aroma_config + "writetmpfile(\"system_app_choices.prop\",readtmpfile(\"system_app_choices.prop\"));\n";
        this.aroma_config = this.aroma_config + "writetmpfile(\"boot_anim_choices.prop\",readtmpfile(\"boot_anim_choices.prop\"));\n";
        this.aroma_config = this.aroma_config + "writetmpfile(\"kernel_choices.prop\",readtmpfile(\"kernel_choices.prop\"));\n";
        this.aroma_config = this.aroma_config + "writetmpfile(\"ringtone_choices.prop\",readtmpfile(\"ringtone_choices.prop\"));\n";
        this.aroma_config = this.aroma_config + "writetmpfile(\"notification_choices.prop\",readtmpfile(\"notification_choices.prop\"));\n";
        this.aroma_config = this.aroma_config + "writetmpfile(\"delete_choices.prop\",readtmpfile(\"delete_choices.prop\"));\n";
        this.aroma_config = this.aroma_config + "if confirm(\"Installing\",getvar(\"installer_title\") + \"\\n\\nStart Installation?\", \"@confirm\")==\"no\" then back(1);\n";
        this.aroma_config = this.aroma_config + "endif;\ninstall(\"Installing\", \"Your selected files are being installed. Please Wait...\", \"@install\");";
    }
    
    public void extractFilesUpdaterScript(ArrayList<String> arrayList, String title, String propFile, String location){
        if(!arrayList.isEmpty()){
            this.updater_script = this.updater_script + "ui_print(\"@" + title + "\");\n";
            int s = 1;
            for(String list : arrayList){
                int i = 1;
                for(String system_list_files : this.returnPathArray(list, map)){
                    this.updater_script = this.updater_script + "if (file_getprop(\"/tmp/aroma/" + propFile + "\", \"item." + s + "." + i + "\")==\"1\") then ui_print(\"Installing " + this.removeExtension(getNameFromPath(system_list_files)) + "\");\n";
                    this.updater_script = this.updater_script + "package_extract_dir(\"customize/" + list + "/" + this.removeExtension(getNameFromPath(system_list_files)) + "\", \"" + location + "\");\n";
                    this.updater_script = this.updater_script + "endif;\n";
                    i++;
                }
                s++;
            }
        }
    }
    
    public void createUpdaterScriptFile(){
        this.updater_script = "ui_print(\"@Starting the install process\");\n" +
                "ui_print(\"Setting up required tools...\");\n" +
                "package_extract_file(\"utils/mount\", \"/tmp/mount\");\n" +
                "set_perm(0, 0, 0755, \"/tmp/mount\");\n" +
                "ui_print(\"Mounting...\");\n" +
                "ui_print(\" \");\n" +
                "run_program(\"/tmp/mount\", \"/data\");\n" +
                "run_program(\"/tmp/mount\", \"/system\");\n";
        
        if(!this.systemList.isEmpty())
        extractFilesUpdaterScript(this.systemList, "Installing System Apps", "system_app_choices.prop", "/system/app");
        
        if(!this.dataList.isEmpty())
        extractFilesUpdaterScript(this.dataList, "Installing Apps", "app_choices.prop", "/data/app");
        
        if(!this.bootAnimList.isEmpty())
        extractFilesUpdaterScript(this.bootAnimList, "Installing Boot Animation", "boot_anim_choices.prop", "/system/media");
        
        //if(!this.kernelList.isEmpty())
        //extractFilesUpdaterScript(this.kernelList, "Flashing Kernel", "kernel_choices.prop", aroma_config);
        
        if(!this.ringtoneList.isEmpty())
        extractFilesUpdaterScript(this.ringtoneList, "Adding Ringtones", "ringtone_choices.prop", "/system/media/audio/ringtones");
        
        if(!this.notifList.isEmpty())
        extractFilesUpdaterScript(this.notifList, "Adding Notification Tones", "notification_choices.prop", "/system/media/audio/notifications");
        
        this.updater_script = this.updater_script + "set_perm_recursive(1000, 1000, 0771, 0644, \"/data/app\");\n";
        this.updater_script = this.updater_script + "set_perm_recursive(1000, 1000, 0775, 0644, \"/system/app\");\n";
        this.updater_script = this.updater_script + "set_perm_recursive(1000, 1000, 0775, 0644, \"/system/media\");\n";
        
        this.updater_script = this.updater_script + "ui_print(\"@Wiping dalvik-cache\");\n" +
                "delete_recursive(\"/data/dalvik-cache\");\n";
        this.updater_script = this.updater_script + "unmount(\"/data\");\n";
        this.updater_script = this.updater_script + "unmount(\"/system\");\n";
        this.updater_script = this.updater_script + "ui_print(\"@Finished Install\");\n";
        this.updater_script = this.updater_script + "set_progress(1);\n";
    }
    
    public void fillListModelWithArrayList(DefaultListModel model, ArrayList<String> list){
        for(String temp : list){
            model.addElement(temp);
        }
    }
    
    public String getNameFromPath(String str){
        String tempString[] = str.split("\\\\");
        System.out.println("Successfully Splitted from " + str + " to " + tempString[tempString.length-1]);
        return tempString[tempString.length-1];
    }
    
    public void updateFileListWithSelectedGroupList(String str, DefaultListModel model, MultiValueMap mvm){
        ArrayList<String> arrayList = new ArrayList<>();
        Set entrySet = mvm.entrySet();
        Iterator it = entrySet.iterator();
        while(it.hasNext()){
            Map.Entry mapEntry = (Map.Entry) it.next();
            if(str.equals(mapEntry.getKey())){
                arrayList = (ArrayList<String>) mvm.get(mapEntry.getKey());
                for (int j = 0; j < arrayList.size(); j++) {
                    System.out.println("Testing.. "+getNameFromPath(arrayList.get(j)));
                    System.out.println("\t" + mapEntry.getKey() + "\t  " + getNameFromPath(arrayList.get(j)));
                    model.addElement(getNameFromPath(arrayList.get(j)));
                }
            }
        }
    }
    
    public void filterFile(JFileChooser fileChooser, Component cmpnt, JList groupList,DefaultListModel fileModel){
        
        int returnVal = fileChooser.showOpenDialog(cmpnt);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
        File[] file = fileChooser.getSelectedFiles();
                for(int i=0; i<file.length; i++){
                    this.map.put(groupList.getSelectedValue(), file[i].getAbsolutePath());
                    System.out.println(file[i].getAbsolutePath());
                }
                fileModel.removeAllElements();
                updateFileListWithSelectedGroupList(groupList.getSelectedValue().toString(), fileModel, this.map);
        } else {
        System.out.println("File access cancelled by user.");
        }
    }
    
    public boolean keyExistInMap(String str, MultiValueMap mvm){
        try{
            Set entrySet = mvm.entrySet();
            Iterator it = entrySet.iterator();
            while(it.hasNext()){
                Map.Entry mapEntry = (Map.Entry) it.next();
                if(str.equals(mapEntry.getKey())){
                    return true;
                }
            }
        }catch (NullPointerException npe){
            System.out.println("Exception Caught");
            return false;
        }
        return false;
    }
    
    public void removeGroup(String groupName){
        if(this.groupArrayList.contains(groupName)){
            this.groupArrayList.remove(groupName);
            Boolean flag = this.systemList.contains(groupName)?this.systemList.remove(groupName):this.dataList.contains(groupName)?this.dataList.remove(groupName):false;
            flag = (!flag)?this.ringtoneList.contains(groupName)?this.ringtoneList.remove(groupName):this.notifList.contains(groupName)?this.notifList.remove(groupName):false:false;
            flag = (!flag)?this.kernelList.contains(groupName)?this.kernelList.remove(groupName):this.advancedList.contains(groupName)?this.advancedList.remove(groupName):false:false;
            flag = (!flag)?(this.deleteApkList.contains(groupName)?this.deleteApkList.remove(groupName):true):false;
            if(flag){
                JOptionPane.showMessageDialog(null, "Group Removed..");
            }
            //this.aromaGroupModel.removeAllElements();
            for(String group: this.groupArrayList){
            //    this.aromaGroupModel.addElement(group);
            }
            
        }
        else{
            JOptionPane.showMessageDialog(null, "No Group Exists, Add Group First..!!");
        }
    }
    
    public void writeStringToFile(String script, File scriptFile) throws IOException{
        if(!scriptFile.exists()){
            scriptFile.createNewFile();
        }
        BufferedWriter writer = null;
        writer = new BufferedWriter(new FileWriter(scriptFile));
        writer.write(script);
        if(writer!= null){
            writer.close();
        }
        System.out.println("String Written Successfully..!!");
    }
    
    public ArrayList<String> jarFileList() throws IOException{
        this.jarFileList.add("utils/umount");
        this.jarFileList.add("utils/mount");

        this.jarFileList.add("META-INF/com/google/android/update-binary");
        this.jarFileList.add("META-INF/com/google/android/aroma/fonts/big.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/fonts/small.png");
        
        this.jarFileList.add("META-INF/com/google/android/aroma/icons/agreement.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/icons/alert.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/icons/apps.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/icons/confirm.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/icons/customize.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/icons/default.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/icons/info.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/icons/install.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/icons/license.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/icons/personalize.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/icons/update.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/icons/welcome.png");
        
        this.jarFileList.add("META-INF/com/google/android/aroma/langs/ar.lang");
        this.jarFileList.add("META-INF/com/google/android/aroma/langs/cn.lang");
        this.jarFileList.add("META-INF/com/google/android/aroma/langs/de.lang");
        this.jarFileList.add("META-INF/com/google/android/aroma/langs/en.lang");
        this.jarFileList.add("META-INF/com/google/android/aroma/langs/fr.lang");
        this.jarFileList.add("META-INF/com/google/android/aroma/langs/he.lang");
        this.jarFileList.add("META-INF/com/google/android/aroma/langs/id.lang");
        this.jarFileList.add("META-INF/com/google/android/aroma/langs/it.lang");
        this.jarFileList.add("META-INF/com/google/android/aroma/langs/ru.lang");
        this.jarFileList.add("META-INF/com/google/android/aroma/langs/es.lang");
        
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/bg.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/button.9.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/button_focus.9.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/button_press.9.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/cb.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/cb_focus.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/cb_on.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/cb_on_focus.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/cb_on_press.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/cb_press.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/dialog.9.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/dialog_titlebar.9.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/font.roboto.big.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/font.roboto.small.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/icon.agreement.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/icon.alert.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/icon.apps.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/icon.confirm.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/icon.customize.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/icon.default.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/icon.info.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/icon.install.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/icon.license.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/icon.personalize.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/icon.update.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/icon.welcome.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/list.9.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/navbar.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/radio.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/radio_focus.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/radio_on.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/radio_on_focus.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/radio_on_press.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/radio_press.png");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/theme.prop");
        this.jarFileList.add("META-INF/com/google/android/aroma/themes/miui4/titlebar.9.png");
        
        this.jarFileList.add("META-INF/com/google/android/aroma/ttf/DroidSans.ttf");
        this.jarFileList.add("META-INF/com/google/android/aroma/ttf/DroidSansArabic.ttf");
        this.jarFileList.add("META-INF/com/google/android/aroma/ttf/DroidSansFallback.ttf");
        this.jarFileList.add("META-INF/com/google/android/aroma/ttf/Roboto-Regular.ttf");
        return this.jarFileList;
    }
}
