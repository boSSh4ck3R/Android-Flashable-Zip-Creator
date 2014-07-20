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
public class SubGroupNode extends ProjectItemNode{
    
    String parentNodeName;
    String subGroupName;
    public String location;
    public String permissions;
    public int subGroupType;
    
    public static final int TYPE_SYSTEM_FONTS = GroupNode.GROUP_SYSTEM_FONTS;
    public static final int TYPE_SYSTEM_MEDIA = GroupNode.GROUP_SYSTEM_MEDIA;
    public static final int TYPE_DATA_LOCAL = GroupNode.GROUP_DATA_LOCAL;
    public static final int TYPE_CUSTOM = GroupNode.GROUP_CUSTOM;
    
    public SubGroupNode(String title, int type, GroupNode parent) {
        super(title, ProjectItemNode.NODE_SUBGROUP, parent);
        super.path = parent.path + File.separator + title;
        subGroupName = title;
        this.subGroupType = type;
        System.out.println("SubGroup Path is : " + path);
        switch(type){
            case TYPE_SYSTEM_FONTS:
                this.location = "system/fonts";
                this.permissions = "rwrr";
                break;
            case TYPE_SYSTEM_MEDIA:
                this.location = "system/media";
                this.permissions = "rwrr";
                break;
            case TYPE_DATA_LOCAL:
                this.location = "data/local";
                this.permissions = "rwrr";
                break;
            case TYPE_CUSTOM:
                //location and permissions shall remain null and let file node override this property.
                break;
        }
    }
    
    public String getLocation(){
        return location;
    }
    
    public String getPermissions(){
        return permissions;
    }
}
