/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashablezipcreator.Core;

import java.io.File;

/**
 *
 * @author Nikhil
 */
public class GroupNode extends ProjectItemNode {

    public String groupName;
    public String location = "";
    public String permissions = "";
    public int groupType;
    public String prop;
    public boolean isSelectBox = false;

    public static final int GROUP_SYSTEM_APK = 1;
    public static final int GROUP_SYSTEM_PRIV_APK = 2;
    public static final int GROUP_SYSTEM_LIB = 3;
    public static final int GROUP_PRELOAD_SYMLINK_SYSTEM_APP = 4;
    public static final int GROUP_SYSTEM_ETC = 5;
    public static final int GROUP_SYSTEM_CSC = 6;
    public static final int GROUP_SYSTEM_MEDIA_AUDIO_ALARMS = 7;
    public static final int GROUP_SYSTEM_MEDIA_AUDIO_NOTIFICATIONS = 8;
    public static final int GROUP_SYSTEM_MEDIA_AUDIO_RINGTONES = 9;
    public static final int GROUP_SYSTEM_MEDIA_AUDIO_UI = 10;
    public static final int GROUP_SYSTEM_MEDIA = 11;
    public static final int GROUP_SYSTEM_FONTS = 12;
    public static final int GROUP_SYSTEM_FRAMEWORK = 13;
    public static final int GROUP_DATA_APP = 14;
    public static final int GROUP_DATA_LOCAL = 15;
    public static final int GROUP_CUSTOM = 16;
    public static final int GROUP_OTHER = 17;
    public static final int GROUP_AROMA_THEMES = 18;
    public static final int GROUP_AROMA_KERNEL = 19;
    public static final int GROUP_DELETE_FILES = 20;
    public static final int GROUP_DPI = 21;

    public GroupNode(String title, int type, ProjectNode parent) {
        super(title, ProjectItemNode.NODE_GROUP, parent);
        this.groupType = type;
        this.groupName = title;
        super.path = parent.path + File.separator + title;
        //System.out.println("Group Path is : " + path);

        switch (type) {
            case GROUP_SYSTEM_APK:
                this.location = "/system/app";
                this.prop = getProp("system_app");
                break;
            case GROUP_SYSTEM_PRIV_APK:
                this.location = "/system/priv-app";
                this.prop = getProp("system_priv");
                break;
            case GROUP_SYSTEM_LIB:
                this.location = "/system/lib";
                this.prop = getProp("system_lib");
                break;
            case GROUP_PRELOAD_SYMLINK_SYSTEM_APP:
                this.location = "/preload/symlink/system/app";
                this.prop = getProp("system_preload");
                break;
            case GROUP_SYSTEM_ETC:
                this.location = "/system/etc";
                this.prop = getProp("system_etc");
                break;
            case GROUP_SYSTEM_CSC:
                this.location = "/system/csc";
                this.prop = getProp("system_csc");
                break;
            case GROUP_SYSTEM_MEDIA_AUDIO_ALARMS:
                this.location = "/system/media/audio/alarms";
                this.prop = getProp("system_media_alarms");
                break;
            case GROUP_SYSTEM_MEDIA_AUDIO_NOTIFICATIONS:
                this.location = "/system/media/audio/notifications";
                this.prop = getProp("system_media_notifications");
                break;
            case GROUP_SYSTEM_MEDIA_AUDIO_RINGTONES:
                this.location = "/system/media/audio/ringtones";
                this.prop = getProp("system_media_ringtones");
                break;
            case GROUP_SYSTEM_MEDIA_AUDIO_UI:
                this.location = "/system/media/audio/ui";
                this.prop = getProp("system_media_ui");
                break;
            case GROUP_SYSTEM_MEDIA:
                this.location = "/system/media";
                this.prop = getProp("system_media");
                this.isSelectBox = true;
                break;
            case GROUP_SYSTEM_FONTS:
                this.location = "/system/fonts";
                this.prop = getProp("system_fonts");
                this.isSelectBox = true;
                break;
            case GROUP_SYSTEM_FRAMEWORK:
                this.location = "/system/framework";
                this.prop = getProp("system_framework");
                break;
            case GROUP_DATA_APP:
                this.location = "/data/app";
                this.prop = getProp("data_app");
                break;
            case GROUP_DATA_LOCAL:
                this.location = "/data/local";
                this.prop = getProp("data_local");
                this.isSelectBox = true;
                break;
            case GROUP_AROMA_KERNEL:
//                this.location = "";
//                this.permissions = "";
                this.prop = getProp("kernels");
                this.isSelectBox = true;
                break;
            case GROUP_CUSTOM:
//                this.location = "/custom";
//                this.permissions = "";
                this.prop = getProp("custom");
                this.isSelectBox = false;
                break;
            case GROUP_OTHER:
//                this.location = "";
//                this.permissions = "";
                //following properties not needed but added.
                this.prop = getProp("other");
                this.isSelectBox = false;
                break;
            case GROUP_AROMA_THEMES:
//                this.location = "";
//                this.permissions = "";
                this.prop = "themes.prop";
                this.isSelectBox = true;
                super.path = "META-INF/com/google/android/aroma/themes" + File.separator + title;
                break;
            case GROUP_DELETE_FILES:
                this.prop = getProp("delete");
                this.isSelectBox = false;
                break;
            case GROUP_DPI:
                this.prop = getProp("dpi");
                this.isSelectBox = true;
                break;
        }
    }

    public boolean isSelectBox() {
        return isSelectBox;
    }

    public boolean isCheckBox() {
        return !isSelectBox;
    }

    public void setLocation(String location){
        this.location = location;
    }
    
    public String getLocation() {
        return location;
    }
//
//    public String getPermissions() {
//        return permissions;
//    }

    public String getProp(String str) {
        return str + "_" + groupName.replaceAll(" ", "_") + "_" + parent.title.replaceAll(" ", "_") + ".prop";
    }
//
//    public void setPermissions(int i, int j, int k, String path) {
//        this.permissions = i + ", " + j + ", " + k + ", " + path;
//    }

}
