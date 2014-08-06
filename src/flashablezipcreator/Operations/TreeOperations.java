/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashablezipcreator.Operations;

import flashablezipcreator.Core.FileNode;
import flashablezipcreator.Core.GroupNode;
import flashablezipcreator.Core.ProjectItemNode;
import flashablezipcreator.Core.ProjectNode;
import flashablezipcreator.Core.SubGroupNode;
import flashablezipcreator.DiskOperations.Write;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Nikhil
 */
public class TreeOperations {

    Write w = new Write();
    ArrayList<ProjectItemNode> list = new ArrayList<>();
    ArrayList<ProjectItemNode> projectList = new ArrayList<>();
    ArrayList<ProjectItemNode> groupList = new ArrayList<>();
    ArrayList<ProjectItemNode> subGroupList = new ArrayList<>();
    ArrayList<ProjectItemNode> fileList = new ArrayList<>();

    ProjectItemNode rootNode;

    public TreeOperations(ProjectItemNode rootNode) {
        this.rootNode = rootNode;
    }

    public void addChildTo(ProjectItemNode node, String childTitle, int childType, DefaultTreeModel model) {
        switch (node.type) {
            case ProjectItemNode.NODE_ROOT:
                node.addChild(new ProjectNode(childTitle, childType, node), model);
                break;
            case ProjectItemNode.NODE_PROJECT:
                node.addChild(new GroupNode(childTitle, childType, (ProjectNode) node), model);
                break;
            case ProjectItemNode.NODE_GROUP:
                switch (((GroupNode) node).groupType) {
                    //Group of predefined locations
                    case GroupNode.GROUP_SYSTEM_APK:
                    case GroupNode.GROUP_SYSTEM_PRIV_APK:
                    case GroupNode.GROUP_SYSTEM_CSC:
                    case GroupNode.GROUP_SYSTEM_ETC:
                    case GroupNode.GROUP_SYSTEM_LIB:
                    case GroupNode.GROUP_SYSTEM_MEDIA_AUDIO_ALARMS:
                    case GroupNode.GROUP_SYSTEM_MEDIA_AUDIO_NOTIFICATIONS:
                    case GroupNode.GROUP_SYSTEM_MEDIA_AUDIO_RINGTONES:
                    case GroupNode.GROUP_SYSTEM_MEDIA_AUDIO_UI:
                    case GroupNode.GROUP_DATA_APP:
                    case GroupNode.GROUP_PRELOAD_SYMLINK_SYSTEM_APP:
                    case GroupNode.GROUP_SYSTEM_FRAMEWORK:
                        if (childType == ProjectItemNode.NODE_FILE) {
                            node.addChild(new FileNode(childTitle, (GroupNode) node), model);
                        } else {
                            System.out.println("You cannot add subgroup for this type..!!");
                        }
                        break;
                    //Group of predefined locations that need subgroups
                    case GroupNode.GROUP_SYSTEM_FONTS:
                    case GroupNode.GROUP_DATA_LOCAL:
                    case GroupNode.GROUP_SYSTEM_MEDIA:
                        switch (childType) {
                            case SubGroupNode.TYPE_SYSTEM_FONTS:
                            case SubGroupNode.TYPE_SYSTEM_MEDIA:
                            case SubGroupNode.TYPE_DATA_LOCAL:
                                node.addChild(new SubGroupNode(childTitle, childType, (GroupNode) node), model);
                                break;
                            case ProjectItemNode.NODE_FILE:
                                System.out.println("You cannot add files for this type..!!\nadd a subgroup and then files to it..!!");
                                break;
                        }
                        break;
                    //Group of custom location.
                    case GroupNode.GROUP_CUSTOM:
                        if (childType == SubGroupNode.TYPE_CUSTOM) {
                            node.addChild(new SubGroupNode(childTitle, childType, (GroupNode) node), model);
                        }
                        break;
                    case GroupNode.GROUP_OTHER:
                        //we need a way of preventing other group from displaying in tree. 
                        node.addChild(new FileNode(childTitle, (GroupNode) node), model);
                        break;
                    //here File Node can also act as child but due to different requirements of parameters,
                    //explicit call to another addChildTo function is required.
                }
                break;
            case ProjectItemNode.NODE_SUBGROUP:
                System.out.println(node.title);
                System.out.println(node.type);
                switch (((SubGroupNode) node).subGroupType) {
                    case SubGroupNode.TYPE_SYSTEM_FONTS:
                    case SubGroupNode.TYPE_SYSTEM_MEDIA:
                    case SubGroupNode.TYPE_DATA_LOCAL:
                        node.addChild(new FileNode(childTitle, (SubGroupNode) node), model);
                        break;
                }
            default:
                System.out.println("Entered Default.");
        }
    }

    public void addChildTo(ProjectItemNode node, String childTitle, String installLocation, String permission, DefaultTreeModel model) {
        if ((node.type == ProjectItemNode.NODE_GROUP && ((GroupNode) node).groupType == GroupNode.GROUP_CUSTOM)) {
            node.addChild(new FileNode(childTitle, installLocation, permission, (GroupNode) node), model);
        } else if ((node.type == ProjectItemNode.NODE_SUBGROUP && ((SubGroupNode) node).subGroupType == SubGroupNode.TYPE_CUSTOM)) {
            node.addChild(new FileNode(childTitle, installLocation, permission, (SubGroupNode) node), model);
        }
    }

    public void removeChildFrom(ProjectItemNode node, DefaultTreeModel model) {
        node.removeChild(node, model);
    }

    public void buildDirectory() throws IOException {
        buildDirectory(this.rootNode);
    }

    public void buildDirectory(ProjectItemNode node) throws IOException {
        if (!node.isLeaf()) {
            w.createFolder(((ProjectItemNode) node).path);
            for (int i = 0; i < node.getChildCount(); i++) {
                buildDirectory((ProjectItemNode) node.getChildAt(i));
            }
        } else {
            try {
                //this will create a file in project folder.
                w.writeFile(((FileNode) node).fileSourcePath, ((FileNode) node).fileDestPath);
                //this will make location of file from user selected location to project location.
                ((FileNode) node).fileSourcePath = ((FileNode) node).fileDestPath;
            } catch (ClassCastException cce) {
                System.out.println("Exception caught while casting..");
            }
        }
    }

    //this will iterate from given node to leaf node i.e. File Node and return list of FileNodes.
//    public ArrayList<ProjectItemNode> parseNode(ProjectItemNode node) {
//        if (!node.isLeaf()) {
//            for (int i = 0; i < node.getChildCount(); i++) {
//                parseNode((ProjectItemNode) node.getChildAt(i));
//            }
//        } else {
//            try {
//                list.add((FileNode) node);
//            } catch (ClassCastException cce) {
//                System.out.println("The node is of type " + node.type);
//            }
//        }
//        return list;
//    }

    public ArrayList<ProjectItemNode> parseNode(ProjectItemNode node, int type) {
        for (int i = 0; i < node.getChildCount(); i++) {
            if (((ProjectItemNode) node.getChildAt(i)).type == type) {
                switch (((ProjectItemNode) node.getChildAt(i)).type) {
                    case ProjectItemNode.NODE_PROJECT:
                        if (!list.contains((ProjectItemNode) node.getChildAt(i))) {
                            list.add((ProjectItemNode) node.getChildAt(i));
                        }
                        break;
                    case ProjectItemNode.NODE_GROUP:
                        if (!list.contains((ProjectItemNode) node.getChildAt(i))) {
                            list.add((ProjectItemNode) node.getChildAt(i));
                        }
                        break;
                    case ProjectItemNode.NODE_SUBGROUP:
                        if (!list.contains((ProjectItemNode) node.getChildAt(i))) {
                            list.add((ProjectItemNode) node.getChildAt(i));
                        }
                        break;
                    case ProjectItemNode.NODE_FILE:
                        if (!list.contains((ProjectItemNode) node.getChildAt(i))) {
                            list.add((ProjectItemNode) node.getChildAt(i));
                        }
                        break;
                }
            }
            parseNode((ProjectItemNode) node.getChildAt(i), type);
        }
        return list;
    }

    public ArrayList<ProjectItemNode> getNodeList(int nodeType) {
        list = new ArrayList<>();
        return parseNode(this.rootNode, nodeType);
    }

    public ProjectNode getProjectNode(String name, int projectType) {
        for (ProjectItemNode node : getNodeList(ProjectItemNode.NODE_PROJECT)) {
            if (node.title.equals(name) && ((ProjectNode) node).projectType == projectType) {
                return (ProjectNode) node;
            }
        }
        System.out.println("Returning null in search for " + name);
        return null;
    }

    public GroupNode getGroupNode(String name, int groupType, String projectName) {
        for (ProjectItemNode node : getNodeList(ProjectItemNode.NODE_GROUP)) {
            //System.out.println(projectName + ".. " + node.parent + " .. " + node.parent.title.equals(projectName));
            if (node.title.equals(name) && ((GroupNode) node).groupType == groupType && node.parent.title.equals(projectName)) {
                return (GroupNode) node;
            }
        }
        System.out.println("Returning null in search for " + name);
        return null;
    }

    public SubGroupNode getSubGroupNode(String name, int subGroupType, String groupName, String projectName) {
        for (ProjectItemNode node : getNodeList(ProjectItemNode.NODE_SUBGROUP)) {
            if (node.title.equals(name) && ((SubGroupNode) node).subGroupType == subGroupType && node.parent.title.equals(groupName) && node.parent.parent.title.equals(projectName)) {
                return (SubGroupNode) node;
            }
        }
        System.out.println("Returning null in search for " + name);
        return null;
    }

    public FileNode getFileNode(String name, String groupName, String projectName) {
        for (ProjectItemNode node : getNodeList(ProjectItemNode.NODE_FILE)) {
            if (node.title.equals(name) && node.parent.title.equals(groupName) && node.parent.parent.title.equals(projectName)) {
                return (FileNode) node;
            }
        }
        System.out.println("Returning null in search for " + name);
        return null;
    }

    public FileNode getFileNode(String name, String subGroupName, String groupName, String projectName) {
        for (ProjectItemNode node : getNodeList(ProjectItemNode.NODE_FILE)) {
            if (node.title.equals(name) && node.parent.title.equals(subGroupName) && node.parent.parent.title.equals(groupName) && node.parent.parent.parent.title.equals(projectName)) {
                return (FileNode) node;
            }
        }
        System.out.println("Returning null in search for " + name);
        return null;
    }

    public void expandDirectories(JTree tree) {
        for (int i = 0; i < tree.getRowCount(); i++) {
            tree.expandRow(i);
        }
    }
}
