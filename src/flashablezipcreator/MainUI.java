/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashablezipcreator;

import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.commons.collections4.map.MultiValueMap;

/**
 *
 * @author Nikhil
 */
public class MainUI extends javax.swing.JFrame {

    MainUI() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        op.CSDmap = new HashMap<>();
        try {
            op.generateDeviceList();
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        initcomponents();
    }

    public void initcomponents() {
        //frame = new JFrame();
        mainPanel = new javax.swing.JPanel();
        headingPanel = new javax.swing.JPanel();
        lblHeading = new javax.swing.JLabel();
        lblSubHeading = new javax.swing.JLabel();
        btnSelectDevice = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        textFieldUpdateBinary = new javax.swing.JTextField();
        btnBrowseUpdateBinary = new javax.swing.JButton();
        btnBrowseZipDestination = new javax.swing.JButton();
        textFieldZipDestination = new javax.swing.JTextField();
        lblZipDestination = new javax.swing.JLabel();
        topButtonPanel = new javax.swing.JPanel();
        btnApkGroup = new javax.swing.JButton();
        btnRingtonesGroup = new javax.swing.JButton();
        btnNotifGroup = new javax.swing.JButton();
        btnKernelGroup = new javax.swing.JButton();
        btnDeleteSystemFilesGroup = new javax.swing.JButton();
        btnFontsGroup = new javax.swing.JButton();
        btnBootAnimGroup = new javax.swing.JButton();
        contentPanel = new javax.swing.JPanel();
        fileModel = new DefaultListModel();
        fileListScrollPane = new JScrollPane();
        fileList = new JList(fileModel);
        groupListScrollPane = new JScrollPane();
        groupModel = new DefaultListModel();
        groupList = new JList(groupModel);
        groupList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                groupListSelection(lse);
            }
        });
        fileList = new JList(fileModel);
        fileList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                fileListSelection(lse);
            }
        });
        lblNote = new javax.swing.JLabel();
        btnAddFile = new javax.swing.JButton();
        btnRemoveFile = new javax.swing.JButton();
        lblGroup = new javax.swing.JLabel();
        btnAddGroup = new javax.swing.JButton();
        btnRemoveGroup = new javax.swing.JButton();
        btnAddDescription = new javax.swing.JButton();
        sideButtonPanel = new javax.swing.JPanel();
        btnLoadAromaFlashableZip = new javax.swing.JButton();
        btnResetAll = new javax.swing.JButton();
        btnAdvancedGroup = new javax.swing.JButton();
        btnSaveProject = new javax.swing.JButton();
        btnAddSplash = new javax.swing.JButton();
        btnPreferences = new javax.swing.JButton();
        btnCreateNormalZip = new javax.swing.JButton();
        btnCreateAromaZip = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        loadMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Android Flashable Zip Creator 2.0");

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setToolTipText("Android Flashable Zip Creator 2.0");

        headingPanel.setBackground(new java.awt.Color(75, 60, 57));
        headingPanel.setForeground(new java.awt.Color(255, 255, 255));

        lblHeading.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblHeading.setForeground(new java.awt.Color(255, 255, 255));
        lblHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeading.setText("Android Flashable Zip Creator");

        lblSubHeading.setForeground(new java.awt.Color(204, 204, 204));
        lblSubHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubHeading.setText("By Nikhil Menghani And Rajat Patel");

        javax.swing.GroupLayout headingPanelLayout = new javax.swing.GroupLayout(headingPanel);
        headingPanel.setLayout(headingPanelLayout);
        headingPanelLayout.setHorizontalGroup(
                headingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(headingPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(headingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblSubHeading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblHeading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
        );
        headingPanelLayout.setVerticalGroup(
                headingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(headingPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSubHeading)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSelectDevice.setText("Select Your Device From Here");
        btnSelectDevice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectDeviceActionPerformed(evt);
            }
        });

        lblTitle.setText("Device not in list? Then Select Working Update Binary For Your Device : ");

        textFieldUpdateBinary.setText("Click Here To Select update-binary....");
        textFieldUpdateBinary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //textFieldUpdateBinaryActionPerformed(evt);
            }
        });

        btnBrowseUpdateBinary.setText("Browse..");
        btnBrowseUpdateBinary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseUpdateBinaryActionPerformed(evt);
            }
        });

        btnBrowseZipDestination.setText("Browse..");
        btnBrowseZipDestination.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseZipDestinationActionPerformed(evt);
            }
        });

        textFieldZipDestination.setText("Click Here To Select Zip Destination....");

        lblZipDestination.setText("Select Zip Destination : ");

        topButtonPanel.setBackground(new java.awt.Color(229, 229, 229));
        topButtonPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnApkGroup.setBackground(new java.awt.Color(153, 180, 209));
        btnApkGroup.setText("APKs Group");
        btnAddGroup.setActionCommand("APKs Group");
        btnApkGroup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnApkGroup.setContentAreaFilled(true);
        btnApkGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApkGroupActionPerformed(evt);
            }
        });

        btnRingtonesGroup.setBackground(new java.awt.Color(153, 180, 209));
        btnRingtonesGroup.setText("Ringtones Group");
        btnRingtonesGroup.setActionCommand("Ringtones Group");
        btnRingtonesGroup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnRingtonesGroup.setContentAreaFilled(false);
        btnRingtonesGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRingtonesGroupActionPerformed(evt);
            }
        });

        btnNotifGroup.setBackground(new java.awt.Color(153, 180, 209));
        btnNotifGroup.setText("Notifications Group");
        btnNotifGroup.setActionCommand("Notifications Group");
        btnNotifGroup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnNotifGroup.setContentAreaFilled(false);
        btnNotifGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotifGroupActionPerformed(evt);
            }
        });

        btnKernelGroup.setBackground(new java.awt.Color(153, 180, 209));
        btnKernelGroup.setText("Kernel Group");
        btnKernelGroup.setActionCommand("Kernel Group");
        btnKernelGroup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnKernelGroup.setContentAreaFilled(false);
        btnKernelGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKernelGroupActionPerformed(evt);
            }
        });

        btnDeleteSystemFilesGroup.setBackground(new java.awt.Color(153, 180, 209));
        btnDeleteSystemFilesGroup.setText("Delete System Files Group");
        btnDeleteSystemFilesGroup.setActionCommand("Delete System Files Group");
        btnDeleteSystemFilesGroup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnDeleteSystemFilesGroup.setContentAreaFilled(false);
        btnDeleteSystemFilesGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteSystemFilesGroupActionPerformed(evt);
            }
        });

        btnFontsGroup.setBackground(new java.awt.Color(153, 180, 209));
        btnFontsGroup.setText("Fonts Group");
        btnFontsGroup.setActionCommand("Fonts Group");
        btnFontsGroup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnFontsGroup.setContentAreaFilled(false);
        btnFontsGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFontsGroupActionPerformed(evt);
            }
        });

        btnBootAnimGroup.setBackground(new java.awt.Color(153, 180, 209));
        btnBootAnimGroup.setText("Boot Animaton Group");
        btnBootAnimGroup.setActionCommand("Boot Animation Group");
        btnBootAnimGroup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnBootAnimGroup.setContentAreaFilled(false);
        btnBootAnimGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBootAnimGroupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout topButtonPanelLayout = new javax.swing.GroupLayout(topButtonPanel);
        topButtonPanel.setLayout(topButtonPanelLayout);
        topButtonPanelLayout.setHorizontalGroup(
                topButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(topButtonPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnApkGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRingtonesGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnNotifGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnKernelGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteSystemFilesGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFontsGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBootAnimGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
        );
        topButtonPanelLayout.setVerticalGroup(
                topButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topButtonPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(topButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnApkGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnRingtonesGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnNotifGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnKernelGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnDeleteSystemFilesGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnFontsGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnBootAnimGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
        );

        contentPanel.setBackground(new java.awt.Color(243, 243, 243));
        contentPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        fileListScrollPane.setViewportView(fileList);

        groupListScrollPane.setViewportView(groupList);

        fileList.setFont(new java.awt.Font("Tahoma", 0, 14));

        groupList.setFont(new java.awt.Font("Tahoma", 1, 24));

        lblNote.setText("Create Group and select items to add into the group...");

        btnAddFile.setBackground(new java.awt.Color(153, 180, 209));
        btnAddFile.setText("Add File...");
        btnAddFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFileActionPerformed(evt);
            }
        });

        btnRemoveFile.setText("Remove File...");
        btnRemoveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveFileActionPerformed(evt);
            }
        });

        lblGroup.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblGroup.setText("Apk Group");

        btnAddGroup.setText("Add Group...");
        btnAddGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddGroupActionPerformed(evt);
            }
        });

        btnRemoveGroup.setText("Remove Group...");
        btnRemoveGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveGroupActionPerformed(evt);
            }
        });

        btnAddDescription.setText("Modify Description...");
        btnAddDescription.setActionCommand("Add Description");
        btnAddDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDescriptionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
                contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(contentPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnAddGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRemoveGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                        .addComponent(groupListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblNote, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(fileListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnAddFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRemoveFile, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                .addComponent(btnAddDescription, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
        );
        contentPanelLayout.setVerticalGroup(
                contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(contentPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                        .addComponent(groupListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAddGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnRemoveGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                        .addComponent(lblGroup)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblNote)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(fileListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(contentPanelLayout.createSequentialGroup()
                                                        .addComponent(btnAddFile, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(btnRemoveFile, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(btnAddDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(20, Short.MAX_VALUE))
        );

        sideButtonPanel.setBackground(new java.awt.Color(243, 243, 243));
        sideButtonPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnLoadAromaFlashableZip.setBackground(new java.awt.Color(153, 180, 209));
        btnLoadAromaFlashableZip.setText("Load Aroma Flashable Zip");
        btnLoadAromaFlashableZip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadAromaFlashableZipActionPerformed(evt);
            }
        });

        btnResetAll.setText("Reset Everything");
        btnResetAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetAllActionPerformed(evt);
            }
        });

        btnAdvancedGroup.setText("Switch to Advanced Group");
        btnAdvancedGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //btnAdvancedGroupActionPerformed(evt);
            }
        });

        btnSaveProject.setText("Save Project");
        btnSaveProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //btnSaveProjectActionPerformed(evt);
            }
        });

        btnAddSplash.setText("Set Custom Splash Screen");
        btnAddSplash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSplashActionPerformed(evt);
            }

            private void btnAddSplashActionPerformed(ActionEvent evt) {
                browseSplashScreen();
            }
        });

        btnPreferences.setText("Other Preferences");
        btnPreferences.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //btnPreferencesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sideButtonPanelLayout = new javax.swing.GroupLayout(sideButtonPanel);
        sideButtonPanel.setLayout(sideButtonPanelLayout);
        sideButtonPanelLayout.setHorizontalGroup(
                sideButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sideButtonPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(sideButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnSaveProject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLoadAromaFlashableZip, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAdvancedGroup, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnResetAll, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAddSplash, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnPreferences, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
        );
        sideButtonPanelLayout.setVerticalGroup(
                sideButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(sideButtonPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnLoadAromaFlashableZip, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSaveProject, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdvancedGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnResetAll, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddSplash, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(btnPreferences, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
        );

        btnCreateNormalZip.setText("Create Normal Flashable Zip");
        btnCreateNormalZip.setActionCommand("Create Normal Flashable Zip");
        btnCreateNormalZip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnCreateNormalZipActionPerformed(evt);
                } catch (IOException ex) {
                    Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        btnCreateAromaZip.setText("Create Aroma Flashable Zip");
        btnCreateAromaZip.setActionCommand("Create Flashable Zip With Aroma Installer");
        btnCreateAromaZip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnCreateAromaZipActionPerformed(evt);
                } catch (IOException ex) {
                    Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(mainPanelLayout.createSequentialGroup()
                                                        .addComponent(btnSelectDevice)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(lblTitle))
                                                .addComponent(lblZipDestination))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(textFieldZipDestination)
                                                .addComponent(textFieldUpdateBinary))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(btnBrowseZipDestination, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                                .addComponent(btnBrowseUpdateBinary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(headingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(topButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnCreateNormalZip, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(btnCreateAromaZip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(sideButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(headingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblTitle)
                                .addComponent(textFieldUpdateBinary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnBrowseUpdateBinary)
                                .addComponent(btnSelectDevice))
                        .addGap(13, 13, 13)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(textFieldZipDestination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnBrowseZipDestination)
                                .addComponent(lblZipDestination))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(topButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(sideButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnCreateNormalZip, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnCreateAromaZip, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(18, Short.MAX_VALUE))
        );

        fileMenu.setText("File");

        loadMenuItem.setText("Load Project");
        loadMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadMenuItemActionPerformed(evt);
            }

            private void loadMenuItemActionPerformed(ActionEvent evt) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        fileMenu.add(loadMenuItem);

        saveMenuItem.setText("Save Project");
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
            }

            private void saveMenuItemActionPerformed(ActionEvent evt) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        fileMenu.add(saveMenuItem);
        
        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText("Help");

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        frame.setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        mainPanel.getAccessibleContext().setAccessibleName("");
        mainPanel.getAccessibleContext().setAccessibleDescription("");

        //frame.add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void supportedDeviceUI() {

        dialog = new JDialog(frame, "Currently Supported Devices", true);
        CSDPanel = new javax.swing.JPanel();
        CSD_headingPanel = new javax.swing.JPanel();
        lblCSDHeading1 = new javax.swing.JLabel();
        DefaultListModel CSDModel = new DefaultListModel();
        CSDList = new JList(CSDModel);

        JScrollPane CSDScrollPanel = new JScrollPane();
        CSDScrollPanel.setViewportView(CSDList);

        for (String deviceName : op.CSDmap.keySet()) {
            CSDModel.addElement(deviceName);
        }

        CSDList.setFont(new java.awt.Font("Tahoma", 0, 14));
        CSDList.setSelectedValue(op.selectedDeviceName, true);
        CSD_continue = new javax.swing.JButton();
        CSD_cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CSD_headingPanel.setBackground(new java.awt.Color(0, 0, 0));

        lblCSDHeading1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        lblCSDHeading1.setForeground(new java.awt.Color(255, 255, 255));
        lblCSDHeading1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCSDHeading1.setText("Currently Supported Devices");

        javax.swing.GroupLayout CSD_headingPanelLayout = new javax.swing.GroupLayout(CSD_headingPanel);
        CSD_headingPanel.setLayout(CSD_headingPanelLayout);
        CSD_headingPanelLayout.setHorizontalGroup(
                CSD_headingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CSD_headingPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblCSDHeading1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
        );
        CSD_headingPanelLayout.setVerticalGroup(
                CSD_headingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CSD_headingPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblCSDHeading1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
        );

        CSD_continue.setText("Continue!");
        CSD_continue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CSD_continueActionPerformed(evt);
            }

            private void CSD_continueActionPerformed(ActionEvent evt) {
                op.selectedDevice = op.CSDmap.get(CSDList.getSelectedValue().toString());
                op.selectedDeviceName = CSDList.getSelectedValue().toString();
                op.kernelMountPoint = op.getKernelMountPoint();
                System.out.println(op.selectedDevice);
                System.out.println(op.kernelMountPoint);
                textFieldUpdateBinary.setText("update-binary of " + op.selectedDevice + " Imported Successfully..!");
                dialog.dispose();
            }
        });

        CSD_cancel.setText("Cancel");
        CSD_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CSD_cancelActionPerformed(evt);
            }

            private void CSD_cancelActionPerformed(ActionEvent evt) {
                dialog.dispose();
            }
        });

        javax.swing.GroupLayout CSDPanelLayout = new javax.swing.GroupLayout(CSDPanel);
        CSDPanel.setLayout(CSDPanelLayout);
        CSDPanelLayout.setHorizontalGroup(
                CSDPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CSDPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(CSDPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(CSD_headingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CSDScrollPanel))
                        .addContainerGap())
                .addGroup(CSDPanelLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(CSD_continue, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(CSD_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CSDPanelLayout.setVerticalGroup(
                CSDPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CSDPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(CSD_headingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CSDScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(CSDPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(CSD_continue)
                                .addComponent(CSD_cancel))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(CSDPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(CSDPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        dialog.setContentPane(CSDPanel);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dialog.dispose();
            }
        });
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    public void addApkGroupUI() {

        dialog = new JDialog(frame, "Create Group Name", true);

        addApkGroupPanel = new javax.swing.JPanel();
        AddApkGroup_headingPanel = new javax.swing.JPanel();
        lblAddApkGroupHeading = new javax.swing.JLabel();
        addGroupTitle = new javax.swing.JLabel();
        addGroupNameTitle = new javax.swing.JLabel();
        groupName = new javax.swing.JTextField();
        addApkGroupRadSystem = new javax.swing.JRadioButton();
        addApkGroupRadSystem.setActionCommand("Add System Apk Group");

        addApkGroupRadData = new javax.swing.JRadioButton();
        addApkGroupRadData.setActionCommand("Add Data Apk Group");

        addApkGroupRadPrivApp = new javax.swing.JRadioButton();
        addApkGroupRadPrivApp.setActionCommand("Add Priv Apk Group");

        btnContinue = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        buttonGroup = new ButtonGroup();
        buttonGroup.add(addApkGroupRadSystem);
        buttonGroup.add(addApkGroupRadData);
        buttonGroup.add(addApkGroupRadPrivApp);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        AddApkGroup_headingPanel.setBackground(new java.awt.Color(0, 0, 0));

        lblAddApkGroupHeading.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        lblAddApkGroupHeading.setForeground(new java.awt.Color(255, 255, 255));
        lblAddApkGroupHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAddApkGroupHeading.setText("Add Group");

        javax.swing.GroupLayout AddApkGroup_headingPanelLayout = new javax.swing.GroupLayout(AddApkGroup_headingPanel);
        AddApkGroup_headingPanel.setLayout(AddApkGroup_headingPanelLayout);
        AddApkGroup_headingPanelLayout.setHorizontalGroup(
                AddApkGroup_headingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AddApkGroup_headingPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblAddApkGroupHeading, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                        .addContainerGap())
        );
        AddApkGroup_headingPanelLayout.setVerticalGroup(
                AddApkGroup_headingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AddApkGroup_headingPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblAddApkGroupHeading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
        );

        addGroupTitle.setText("Enter the name of group in which apks will be added.");

        addGroupNameTitle.setText("Group Name :");

        addApkGroupRadSystem.setText("Installs to /system/app");
        addApkGroupRadSystem.setSelected(true);

        addApkGroupRadData.setText("Installs to /data/app");

        addApkGroupRadPrivApp.setText("Installs to /system/priv-app");

        btnContinue.setText("Continue");
        btnContinue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateGroupList(lastSelected);
                dialog.dispose();
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.out.println("Button clicked is : " + evt.getActionCommand());
                dialog.dispose();
            }
        });

        javax.swing.GroupLayout addApkGroupPanelLayout = new javax.swing.GroupLayout(addApkGroupPanel);
        addApkGroupPanel.setLayout(addApkGroupPanelLayout);
        addApkGroupPanelLayout.setHorizontalGroup(
                addApkGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(addApkGroupPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(AddApkGroup_headingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addApkGroupPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(addApkGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(addApkGroupRadSystem)
                                .addComponent(addApkGroupRadData)
                                .addComponent(addApkGroupRadPrivApp))
                        .addGap(95, 95, 95))
                .addGroup(addApkGroupPanelLayout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(btnContinue, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(addApkGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(addApkGroupPanelLayout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addGroup(addApkGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(addGroupTitle)
                                        .addGroup(addApkGroupPanelLayout.createSequentialGroup()
                                                .addComponent(addGroupNameTitle)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(groupName, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(74, Short.MAX_VALUE)))
        );
        addApkGroupPanelLayout.setVerticalGroup(
                addApkGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(addApkGroupPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(AddApkGroup_headingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                        .addComponent(addApkGroupRadSystem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addApkGroupRadData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addApkGroupRadPrivApp)
                        .addGap(18, 18, 18)
                        .addGroup(addApkGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnContinue)
                                .addComponent(btnCancel))
                        .addGap(35, 35, 35))
                .addGroup(addApkGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(addApkGroupPanelLayout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(addGroupTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(addApkGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(addGroupNameTitle)
                                        .addComponent(groupName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(161, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(addApkGroupPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(addApkGroupPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();

        dialog.getContentPane().add(addApkGroupPanel);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                //JOptionPane.showMessageDialog(null, "Thwarted user attempt to close window.");
                dialog.dispose();
            }
        });
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);

    }

    public void addGroupUI() {

        dialog = new JDialog(frame, "Create Group Name", true);

        addGroupPanel = new javax.swing.JPanel();
        AddGroup_headingPanel = new javax.swing.JPanel();
        lblAddGroupHeading = new javax.swing.JLabel();
        addGroupTitle = new javax.swing.JLabel();
        addGroupNameTitle = new javax.swing.JLabel();
        groupName = new javax.swing.JTextField();
        btnContinue = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        AddGroup_headingPanel.setBackground(new java.awt.Color(0, 0, 0));

        lblAddGroupHeading.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        lblAddGroupHeading.setForeground(new java.awt.Color(255, 255, 255));
        lblAddGroupHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAddGroupHeading.setText("Add Group");

        javax.swing.GroupLayout AddGroup_headingPanelLayout = new javax.swing.GroupLayout(AddGroup_headingPanel);
        AddGroup_headingPanel.setLayout(AddGroup_headingPanelLayout);
        AddGroup_headingPanelLayout.setHorizontalGroup(
                AddGroup_headingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AddGroup_headingPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblAddGroupHeading, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                        .addContainerGap())
        );
        AddGroup_headingPanelLayout.setVerticalGroup(
                AddGroup_headingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AddGroup_headingPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblAddGroupHeading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
        );

        addGroupTitle.setText("Enter the name of group in which files will be added.");

        addGroupNameTitle.setText("Group Name :");

        btnContinue.setText("Continue");

        btnCancel.setText("Cancel");

        btnContinue.setText("Continue");
        btnContinue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateGroupList(lastSelected);
                dialog.dispose();
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.out.println("Button clicked is : " + evt.getActionCommand());
                dialog.dispose();
            }
        });

        javax.swing.GroupLayout addGroupPanelLayout = new javax.swing.GroupLayout(addGroupPanel);
        addGroupPanel.setLayout(addGroupPanelLayout);
        addGroupPanelLayout.setHorizontalGroup(
                addGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addGroupPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(AddGroup_headingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                .addGroup(addGroupPanelLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(addGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(addGroupPanelLayout.createSequentialGroup()
                                        .addComponent(addGroupNameTitle)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(groupName, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(addGroupTitle))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(addGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(addGroupPanelLayout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(btnContinue, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(84, Short.MAX_VALUE)))
        );
        addGroupPanelLayout.setVerticalGroup(
                addGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(addGroupPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(AddGroup_headingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(addGroupTitle)
                        .addGap(23, 23, 23)
                        .addGroup(addGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(addGroupNameTitle)
                                .addComponent(groupName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(100, Short.MAX_VALUE))
                .addGroup(addGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(addGroupPanelLayout.createSequentialGroup()
                                .addGap(176, 176, 176)
                                .addGroup(addGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnContinue)
                                        .addComponent(btnCancel))
                                .addContainerGap(48, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(addGroupPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(addGroupPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        dialog.getContentPane().add(addGroupPanel);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                //JOptionPane.showMessageDialog(null, "Thwarted user attempt to close window.");
                dialog.dispose();
            }
        });
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    public void deleteSystemApkUI() {

        dialog = new JDialog(frame, "Delete System Apk", true);

        DSAPanel = new javax.swing.JPanel();
        DSA_headingPanel = new javax.swing.JPanel();
        lblDSAHeading = new javax.swing.JLabel();
        lbl_deleteSystemTitle = new javax.swing.JLabel();
        lbl_deleteFileName = new javax.swing.JLabel();
        deleteApkName = new javax.swing.JTextField();
        lbl_deleteSystemExtension = new javax.swing.JLabel();
        deleteSystemScrollPane = new javax.swing.JScrollPane();
        deleteSystemFileList = new javax.swing.JList();
        btnAddDeleteFile = new javax.swing.JButton();
        btnRemoveDeleteFile = new javax.swing.JButton();
        btnResetDeleteFile = new javax.swing.JButton();
        deletefileModel = new DefaultListModel();
        btnDoneDeleteFile = new javax.swing.JButton();

        try {
            deletefileModel.removeAllElements();
            for (String fileName : op.deleteApkList) {
                System.out.println("File Added To List is : " + fileName);
                deletefileModel.addElement(fileName);
            }
        } catch (NullPointerException npe) {
            System.out.println("Exception Caught while opening delete system apk UI");
        }
        deleteSystemFileList = new JList(deletefileModel);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        DSA_headingPanel.setBackground(new java.awt.Color(0, 0, 0));

        lblDSAHeading.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        lblDSAHeading.setForeground(new java.awt.Color(255, 255, 255));
        lblDSAHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDSAHeading.setText("Remove Unwanted Apps");

        javax.swing.GroupLayout DSA_headingPanelLayout = new javax.swing.GroupLayout(DSA_headingPanel);
        DSA_headingPanel.setLayout(DSA_headingPanelLayout);
        DSA_headingPanelLayout.setHorizontalGroup(
                DSA_headingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DSA_headingPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblDSAHeading, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                        .addContainerGap())
        );
        DSA_headingPanelLayout.setVerticalGroup(
                DSA_headingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DSA_headingPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblDSAHeading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
        );

        lbl_deleteSystemTitle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_deleteSystemTitle.setText("Enter Exact Name of apk file which you want to delete from system");

        lbl_deleteFileName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_deleteFileName.setText("Enter File Name : ");

        deleteApkName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lbl_deleteSystemExtension.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_deleteSystemExtension.setText(".apk");

        deleteSystemFileList.setFont(new java.awt.Font("Tahoma", 0, 14));
        deleteSystemFileList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                deleteSystemFileListValueChanged(evt);
            }
        });
        deleteSystemScrollPane.setViewportView(deleteSystemFileList);

        btnAddDeleteFile.setText("Add");
        btnAddDeleteFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDeleteFileActionPerformed(evt);
            }
        });

        btnRemoveDeleteFile.setText("Remove");
        btnRemoveDeleteFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveDeleteFileActionPerformed(evt);
            }
        });

        btnResetDeleteFile.setText("Reset");
        btnResetDeleteFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetDeleteFileActionPerformed(evt);
            }
        });

        btnDoneDeleteFile.setText("Done!");
        btnDoneDeleteFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneDeleteFileActionPerformed(evt);
                dialog.dispose();
            }
        });

        javax.swing.GroupLayout DSAPanelLayout = new javax.swing.GroupLayout(DSAPanel);
        DSAPanel.setLayout(DSAPanelLayout);
        DSAPanelLayout.setHorizontalGroup(
                DSAPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DSAPanelLayout.createSequentialGroup()
                        .addGroup(DSAPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(DSAPanelLayout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addGroup(DSAPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(DSAPanelLayout.createSequentialGroup()
                                                        .addComponent(deleteSystemScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addGroup(DSAPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(btnRemoveDeleteFile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(btnAddDeleteFile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(btnDoneDeleteFile, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(btnResetDeleteFile, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addComponent(lbl_deleteSystemTitle)
                                                .addGroup(DSAPanelLayout.createSequentialGroup()
                                                        .addComponent(lbl_deleteFileName)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(deleteApkName, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(lbl_deleteSystemExtension))))
                                .addGroup(DSAPanelLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(DSA_headingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DSAPanelLayout.setVerticalGroup(
                DSAPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DSAPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(DSA_headingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_deleteSystemTitle)
                        .addGap(18, 18, 18)
                        .addGroup(DSAPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbl_deleteFileName)
                                .addComponent(deleteApkName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_deleteSystemExtension, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(DSAPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(DSAPanelLayout.createSequentialGroup()
                                        .addComponent(btnAddDeleteFile, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnRemoveDeleteFile, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(11, 11, 11)
                                        .addComponent(btnResetDeleteFile, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnDoneDeleteFile, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(deleteSystemScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(DSAPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(DSAPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        dialog.getContentPane().add(DSAPanel);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                //JOptionPane.showMessageDialog(null, "Thwarted user attempt to close window.");
                dialog.dispose();
            }
        });
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    public void importZipUI() {

        dialog = new JDialog(frame, "Import Zip", true);

        importZipPanel = new javax.swing.JPanel();
        IZheader_panel = new javax.swing.JPanel();
        lblIZheader = new javax.swing.JLabel();
        lblSelectZip = new javax.swing.JLabel();
        textFieldSelectZip = new javax.swing.JTextField();
        btnBrowseZip = new javax.swing.JButton();
        progressImportZip = new javax.swing.JProgressBar();
        lblProgress = new javax.swing.JLabel();
        scrollPaneImportZip = new javax.swing.JScrollPane();
        textAreaImportZipLog = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        IZheader_panel.setBackground(new java.awt.Color(0, 0, 0));

        lblIZheader.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblIZheader.setForeground(new java.awt.Color(255, 255, 255));
        lblIZheader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIZheader.setText("Import Previously Created Zip");

        javax.swing.GroupLayout IZheader_panelLayout = new javax.swing.GroupLayout(IZheader_panel);
        IZheader_panel.setLayout(IZheader_panelLayout);
        IZheader_panelLayout.setHorizontalGroup(
                IZheader_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(IZheader_panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblIZheader, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                        .addContainerGap())
        );
        IZheader_panelLayout.setVerticalGroup(
                IZheader_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(IZheader_panelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblIZheader, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                        .addContainerGap())
        );

        lblSelectZip.setText("Select Zip : ");

        textFieldSelectZip.setEditable(false);
        textFieldSelectZip.setText("Click Browse To Select Zip File...");

        btnBrowseZip.setText("Browse..");
        btnBrowseZip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseZipActionPerformed(evt);
            }
        }
        );

        lblProgress.setText(
                "Progress : ");

        textAreaImportZipLog.setColumns(
                20);
        textAreaImportZipLog.setRows(
                5);
        scrollPaneImportZip.setViewportView(textAreaImportZipLog);

        javax.swing.GroupLayout importZipPanelLayout = new javax.swing.GroupLayout(importZipPanel);

        importZipPanel.setLayout(importZipPanelLayout);

        importZipPanelLayout.setHorizontalGroup(
                importZipPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(importZipPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(importZipPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(IZheader_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(importZipPanelLayout.createSequentialGroup()
                                        .addComponent(lblSelectZip)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textFieldSelectZip)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBrowseZip))
                                .addGroup(importZipPanelLayout.createSequentialGroup()
                                        .addComponent(lblProgress)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(progressImportZip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(scrollPaneImportZip))
                        .addContainerGap())
        );
        importZipPanelLayout.setVerticalGroup(
                importZipPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(importZipPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(IZheader_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(importZipPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblSelectZip)
                                .addComponent(textFieldSelectZip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnBrowseZip))
                        .addGap(17, 17, 17)
                        .addGroup(importZipPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(importZipPanelLayout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(lblProgress))
                                .addComponent(progressImportZip, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(scrollPaneImportZip, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());

        getContentPane()
                .setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(importZipPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(importZipPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();

        dialog.setContentPane(importZipPanel);

        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

        dialog.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent we) {
                if (IZtask != null) {
                    if (IZtask.close) {
                        dialog.dispose();
                    } else {
                        dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                    }
                } else {
                    dialog.dispose();
                }
            }
        }
        );
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    public void createZipUI() {

        dialog = new JDialog(frame, "Creating ZIP", true);

        CZPanel = new javax.swing.JPanel();
        CZ_headingPanel9 = new javax.swing.JPanel();
        lblCZHeading = new javax.swing.JLabel();
        tabbedPaneCZ = new javax.swing.JTabbedPane();
        runPanel = new javax.swing.JPanel();
        runScrollPaneCZ = new javax.swing.JScrollPane();
        runTextAreaCZ = new javax.swing.JTextArea();
        progressCZ = new javax.swing.JProgressBar();
        debugPanel = new javax.swing.JPanel();
        debugScrollPaneCZ = new javax.swing.JScrollPane();
        debugTextAreaCZ = new javax.swing.JTextArea();
        btnClearLogCZ = new javax.swing.JButton();
        btnSaveLogCZ = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CZ_headingPanel9.setBackground(new java.awt.Color(0, 0, 0));

        lblCZHeading.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        lblCZHeading.setForeground(new java.awt.Color(255, 255, 255));
        lblCZHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCZHeading.setText("Creating Flashable ZIP");

        javax.swing.GroupLayout CZ_headingPanel9Layout = new javax.swing.GroupLayout(CZ_headingPanel9);
        CZ_headingPanel9.setLayout(CZ_headingPanel9Layout);
        CZ_headingPanel9Layout.setHorizontalGroup(
                CZ_headingPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CZ_headingPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblCZHeading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
        );
        CZ_headingPanel9Layout.setVerticalGroup(
                CZ_headingPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CZ_headingPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblCZHeading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
        );

        runTextAreaCZ.setColumns(20);
        runTextAreaCZ.setRows(5);
        runScrollPaneCZ.setViewportView(runTextAreaCZ);

        javax.swing.GroupLayout runPanelLayout = new javax.swing.GroupLayout(runPanel);
        runPanel.setLayout(runPanelLayout);
        runPanelLayout.setHorizontalGroup(
                runPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(runScrollPaneCZ, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                .addComponent(progressCZ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        runPanelLayout.setVerticalGroup(
                runPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(runPanelLayout.createSequentialGroup()
                        .addComponent(runScrollPaneCZ, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(progressCZ, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                        .addGap(0, 0, 0))
        );

        tabbedPaneCZ.addTab("Running", runPanel);

        debugTextAreaCZ.setColumns(20);
        debugTextAreaCZ.setRows(5);
        debugScrollPaneCZ.setViewportView(debugTextAreaCZ);

        btnClearLogCZ.setText("Clear All");
        btnClearLogCZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearLogCZActionPerformed(evt);
            }

            private void btnClearLogCZActionPerformed(ActionEvent evt) {
                debugTextAreaCZ.setText("");
            }
        });

        btnSaveLogCZ.setText("Save Logs");
        btnSaveLogCZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveLogCZActionPerformed(evt);
            }

            private void btnSaveLogCZActionPerformed(ActionEvent evt) {
                BufferedWriter writer = null;
                try {
                    writer = new BufferedWriter(new FileWriter("log.config"));
                    writer.write(debugTextAreaCZ.getText().toString());

                } catch (IOException e) {
                } finally {
                    try {
                        if (writer != null) {
                            writer.close();
                        }
                    } catch (IOException e) {
                    }
                }
            }
        });

        javax.swing.GroupLayout debugPanelLayout = new javax.swing.GroupLayout(debugPanel);
        debugPanel.setLayout(debugPanelLayout);
        debugPanelLayout.setHorizontalGroup(
                debugPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(debugScrollPaneCZ)
                .addGroup(debugPanelLayout.createSequentialGroup()
                        .addContainerGap(276, Short.MAX_VALUE)
                        .addComponent(btnClearLogCZ, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSaveLogCZ))
        );
        debugPanelLayout.setVerticalGroup(
                debugPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, debugPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(debugPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnSaveLogCZ, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnClearLogCZ, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(debugScrollPaneCZ, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7))
        );

        tabbedPaneCZ.addTab("Debug", debugPanel);

        javax.swing.GroupLayout CZPanelLayout = new javax.swing.GroupLayout(CZPanel);
        CZPanel.setLayout(CZPanelLayout);
        CZPanelLayout.setHorizontalGroup(
                CZPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CZPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(CZPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tabbedPaneCZ, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(CZ_headingPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
        );
        CZPanelLayout.setVerticalGroup(
                CZPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CZPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CZ_headingPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tabbedPaneCZ, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(CZPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(CZPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();

        dialog.setContentPane(CZPanel);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                CZwindowOpened(evt);
            }
        });
        dialog.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                if (CZtask != null) {
                    if (CZtask.close) {
                        frame.dispose();
                    } else {
                        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                    }
                } else {
                    frame.dispose();
                }
            }
        });
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    public void addDescriptionUI() {

        String initDesc = "";
        try {
            if (op.getDescription(groupList.getSelectedValue().toString() + "??" + fileList.getSelectedValue().toString() + "??", op.descriptionList).equals("")) {
                if (!op.getDescription(groupList.getSelectedValue().toString() + "?_?", op.descriptionList).equals("")) {
                    initDesc = op.getDescription(groupList.getSelectedValue().toString() + "?_?", op.descriptionList);
                } else {
                    initDesc = "";
                }
            } else {
                initDesc = op.getDescription(groupList.getSelectedValue().toString() + "??" + fileList.getSelectedValue().toString() + "??", op.descriptionList);
            }
        } catch (NullPointerException npe) {
            if (!op.getDescription(groupList.getSelectedValue().toString() + "?_?", op.descriptionList).equals("")) {
                initDesc = op.getDescription(groupList.getSelectedValue().toString() + "?_?", op.descriptionList);
            } else {
                initDesc = "";
            }
        }

        dialog = new JDialog(frame, "Add Description", true);
        ADPanel = new javax.swing.JPanel();
        AD_headingPanel = new javax.swing.JPanel();
        lblADHeading = new javax.swing.JLabel();
        addDescriptionScrollPane = new javax.swing.JScrollPane();

        textAreaAddDescription = new javax.swing.JTextArea();
        textAreaAddDescription.setText(initDesc);

        btnDoneDescription = new javax.swing.JButton();
        btnResetDescription = new javax.swing.JButton();
        btnCancelDescription = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        AD_headingPanel.setBackground(new java.awt.Color(0, 0, 0));

        lblADHeading.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        lblADHeading.setForeground(new java.awt.Color(255, 255, 255));
        lblADHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblADHeading.setText("Add Description");

        javax.swing.GroupLayout AD_headingPanelLayout = new javax.swing.GroupLayout(AD_headingPanel);
        AD_headingPanel.setLayout(AD_headingPanelLayout);
        AD_headingPanelLayout.setHorizontalGroup(
                AD_headingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AD_headingPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblADHeading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
        );
        AD_headingPanelLayout.setVerticalGroup(
                AD_headingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AD_headingPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblADHeading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
        );

        textAreaAddDescription.setColumns(20);
        textAreaAddDescription.setRows(5);
        addDescriptionScrollPane.setViewportView(textAreaAddDescription);

        btnDoneDescription.setText("Done");
        btnDoneDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneDescriptionActionPerformed(evt);
            }

            private void btnDoneDescriptionActionPerformed(ActionEvent evt) {
                String descEntry = "";
                switch (lastSelected) {
                    case "APKs Group":
                    case "Ringtones Group":
                    case "Notifications Group":
                        System.out.println("Description Added : " + op.getDescription(groupList.getSelectedValue().toString() + "??" + fileList.getSelectedValue().toString() + "??" + textAreaAddDescription.getText()));
                        descEntry = groupList.getSelectedValue().toString() + "??" + fileList.getSelectedValue().toString() + "??" + op.getDescription(groupList.getSelectedValue().toString() + "??" + fileList.getSelectedValue().toString() + "??", op.descriptionList);
                        if (op.descriptionList.contains(descEntry)) {
                            System.out.println("Removing : " + descEntry);
                            op.descriptionList.remove(descEntry);
                        }
                        op.descriptionList.add(groupList.getSelectedValue().toString() + "??" + fileList.getSelectedValue().toString() + "??" + textAreaAddDescription.getText());
                        break;
                    case "Kernel Group":
                    case "Boot Animation Group":
                    case "Fonts Group":
                        System.out.println("Description Added : " + op.getDescription(groupList.getSelectedValue().toString() + "?_?" + fileList.getSelectedValue().toString() + "?_?" + textAreaAddDescription.getText()));
                        descEntry = groupList.getSelectedValue().toString() + "?_?" + op.getDescription(groupList.getSelectedValue().toString() + "?_?", op.descriptionList);
                        if (op.descriptionList.contains(descEntry)) {
                            System.out.println("Removing : " + descEntry);
                            op.descriptionList.remove(descEntry);
                        }
                        op.descriptionList.add(groupList.getSelectedValue().toString() + "?_?" + textAreaAddDescription.getText());
                        break;
                    default:
                        System.out.println("Something Went Wrong..!!");
                }

                dialog.dispose();
            }
        });

        btnResetDescription.setText("Reset");
        btnResetDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetDescriptionActionPerformed(evt);
            }

            private void btnResetDescriptionActionPerformed(ActionEvent evt) {
                textAreaAddDescription.setText("");
            }
        });

        btnCancelDescription.setText("Cancel");
        btnCancelDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelDescriptionActionPerformed(evt);
            }

            private void btnCancelDescriptionActionPerformed(ActionEvent evt) {
                dialog.dispose();
            }
        });

        javax.swing.GroupLayout ADPanelLayout = new javax.swing.GroupLayout(ADPanel);
        ADPanel.setLayout(ADPanelLayout);
        ADPanelLayout.setHorizontalGroup(
                ADPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ADPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(ADPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(AD_headingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(ADPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(addDescriptionScrollPane, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(ADPanelLayout.createSequentialGroup()
                                                .addComponent(btnDoneDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnResetDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnCancelDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ADPanelLayout.setVerticalGroup(
                ADPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ADPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(AD_headingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addDescriptionScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ADPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnDoneDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnCancelDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnResetDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(ADPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(ADPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        dialog.getContentPane().add(ADPanel);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                //JOptionPane.showMessageDialog(null, "Thwarted user attempt to close window.");
                dialog.dispose();
            }
        });
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void CZwindowOpened(WindowEvent evt) {
        //op.removeEmptyGroup();
        System.out.println("Create Zip Window Opened");
        CZtask = new CreateZip(this, this.op);
        System.out.println("CZtask Object Created..!!");
        CZtask.execute();
    }

    private void btnSelectDeviceActionPerformed(ActionEvent evt) {
        supportedDeviceUI();
    }

    private void btnAddGroupActionPerformed(ActionEvent evt) {
        if ("Kernel Group".equals(this.lastSelected) && "".equals(op.selectedDevice) && !"".equals(op.updateBinaryPath)) {
            JOptionPane.showMessageDialog(null, "Feature Not Available For Custom Update-Binary");
        } else {
            System.out.println(this.lastSelected + " Clicked Add Group");
            displayAddGroupUI(lastSelected);
        }
    }

    private void btnApkGroupActionPerformed(ActionEvent evt) {
        System.out.println("Add Apk Group Clicked.. " + evt.getActionCommand());
        removeHighlight(this.lastSelected);
        btnApkGroup.setContentAreaFilled(true);
        this.lastSelected = evt.getActionCommand();
        refreshGroupList(this.lastSelected);
        this.lblGroup.setText("Apk Group");
        updateFileList();
    }

    private void btnRingtonesGroupActionPerformed(ActionEvent evt) {
        System.out.println("Add Ringtones Group Clicked..");
        removeHighlight(this.lastSelected);
        btnRingtonesGroup.setContentAreaFilled(true);
        this.lastSelected = evt.getActionCommand();

        refreshGroupList(this.lastSelected);
        this.lblGroup.setText("Ringtones Group");

        updateFileList();
    }

    private void btnNotifGroupActionPerformed(ActionEvent evt) {
        System.out.println("Add Notifications Group Clicked..");
        removeHighlight(this.lastSelected);
        btnNotifGroup.setContentAreaFilled(true);
        this.lastSelected = evt.getActionCommand();

        refreshGroupList(this.lastSelected);
        this.lblGroup.setText("Notifications Group");

        updateFileList();
    }

    private void btnKernelGroupActionPerformed(ActionEvent evt) {
        if ("".equals(op.selectedDevice) && "".equals(op.updateBinaryPath)) {
            JOptionPane.showMessageDialog(null, "Please Select Your Device First...!!!");
        } else if ("".equals(op.selectedDevice) && !"".equals(op.updateBinaryPath)) {
            JOptionPane.showMessageDialog(null, "Sorry, This Feature is only available for Supported Devices");
        } else {
            System.out.println("Add Kernel Group Clicked..");
            removeHighlight(this.lastSelected);
            btnKernelGroup.setContentAreaFilled(true);
            this.lastSelected = evt.getActionCommand();

            refreshGroupList(this.lastSelected);
            this.lblGroup.setText("Kernel Group");

            updateFileList();
        }
    }

    private void btnDeleteSystemFilesGroupActionPerformed(ActionEvent evt) {
        System.out.println("Add Delete System Files Group Clicked..");
        this.deleteSystemApkUI();
    }

    private void btnFontsGroupActionPerformed(ActionEvent evt) {
        System.out.println("Add Fonts Group Clicked..");
        removeHighlight(this.lastSelected);
        btnFontsGroup.setContentAreaFilled(true);
        this.lastSelected = evt.getActionCommand();

        refreshGroupList(this.lastSelected);
        this.lblGroup.setText("Fonts Group");

        updateFileList();
    }

    private void btnBootAnimGroupActionPerformed(ActionEvent evt) {
        System.out.println("Add Boot Animation Group Clicked..");
        removeHighlight(this.lastSelected);
        btnBootAnimGroup.setContentAreaFilled(true);
        this.lastSelected = evt.getActionCommand();

        refreshGroupList(this.lastSelected);
        this.lblGroup.setText("Boot Animations Group");

        updateFileList();
    }

    private void groupListSelection(ListSelectionEvent lse) {
        System.out.println("Group List Clicked..");
        try {
            if (!lse.getValueIsAdjusting()) {
                updateFileList();
            }
        } catch (NullPointerException npe) {
            System.out.println("Exception Caught....");
            //aromaFileModel.removeAllElements();
        }
    }

    private void fileListSelection(ListSelectionEvent lse) {
        System.out.println();
    }

    private void btnAddDeleteFileActionPerformed(ActionEvent evt) {
        System.out.println("Add Delete File Button Clicked..!!");
        if (!deleteApkName.getText().equals("")) {
            if (deleteApkName.getText().equals(".apk")) {
                JOptionPane.showMessageDialog(this, "Add Proper File Name..!!");
                deleteApkName.setText(".apk");
            } else {
                if (deleteApkName.getText().endsWith(".apk")) {
                    if (!deletefileModel.contains(deleteApkName.getText())) {
                        deletefileModel.addElement(deleteApkName.getText());
                    } else {
                        JOptionPane.showMessageDialog(this, "File Name Already Exists..");
                    }
                } else {
                    if (!deletefileModel.contains(deleteApkName.getText() + ".apk")) {
                        deletefileModel.addElement(deleteApkName.getText() + ".apk");
                    } else {
                        JOptionPane.showMessageDialog(this, "File Name Already Exists..");
                    }

                }
                deleteApkName.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Add File Name First..!!");
        }
    }

    private void btnDoneDeleteFileActionPerformed(ActionEvent evt) {
        System.out.println("Done Delete File Button Clicked..!!");
        op.deleteApkList = new ArrayList<>();
        for (int i = 0; i < deletefileModel.getSize(); i++) {
            op.deleteApkList.add(deletefileModel.getElementAt(i).toString());
        }
        System.out.println("Delete File List is : " + op.deleteApkList);
        //frame.dispose();
    }

    private void btnRemoveDeleteFileActionPerformed(ActionEvent evt) {
        System.out.println("Remove Delete File Button Clicked..!!");
        if (!deleteSystemFileList.isSelectionEmpty()) {
            //op.deleteApkList.remove(deleteSystemFileList.getSelectedValue());
            deletefileModel.removeElement(deleteSystemFileList.getSelectedValue());
        } else {
            JOptionPane.showMessageDialog(this, "Select File Name First..!!");
        }
    }

    private void btnResetDeleteFileActionPerformed(ActionEvent evt) {
        deletefileModel.removeAllElements();
        op.deleteApkList = new ArrayList<String>();
        deleteSystemFileList.removeAll();
        deleteApkName.setText("");
    }

    private void deleteSystemFileListValueChanged(ListSelectionEvent evt) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void btnAddFileActionPerformed(ActionEvent evt) {
        System.out.println("Add File Clicked");
        if (!groupList.isSelectionEmpty()) {
            if (this.lastSelected.equals("Boot Animation Group") && op.map.containsKey("BootAnimations_" + groupList.getSelectedValue())) {
                JOptionPane.showMessageDialog(null, "There can be only one file per one Boot Animation group..!!\nAdd more groups to add more files..!!");
            } else if (this.lastSelected.equals("Kernel Group") && op.map.containsKey("Kernel_" + groupList.getSelectedValue())) {
                JOptionPane.showMessageDialog(null, "There can be only one file per one Kernel group..!!\nAdd more groups to add more files..!!");
            } else {
                chooseFile(this.lastSelected);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select one group from Group List to add Files!!");
        }
    }

    private void btnRemoveFileActionPerformed(ActionEvent evt) {
        System.out.println("Remove File Clicked..!!");
        //this.lastSelected = evt.getActionCommand();
        try {
            removeFile(this.fileList.getSelectedValue().toString());
        } catch (NullPointerException npe) {
            JOptionPane.showMessageDialog(this, "Select File To Remove..!!");
        }
    }

    private void btnRemoveGroupActionPerformed(ActionEvent evt) {
        System.out.println(this.lastSelected + " Clicked Remove Group");
        try {
            removeGroup(this.groupList.getSelectedValue().toString());
        } catch (NullPointerException npe) {
            System.out.println("Exception Caught while Removing Group..!!");
            JOptionPane.showMessageDialog(this, "Select Group First..!!");
        }
    }

    private void btnLoadAromaFlashableZipActionPerformed(java.awt.event.ActionEvent evt) {
//        if(op.selectedDevice == "" && op.updateBinaryPath == ""){
//            JOptionPane.showMessageDialog(null, "Please Select Your Device First...!!!");
//        }else{
        this.importZipUI();
        //}
    }

    public void browseUpdateBinary() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int returnVal = fileChooser.showOpenDialog(btnBrowseUpdateBinary);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            System.out.println("update-binary File Location : " + file.getAbsolutePath());
            if (!file.getName().equals("update-binary")) {
                JOptionPane.showMessageDialog(null, "Selected File May not be update-binary file..!!\nYou are using this file at your own risk..!");
            }
            textFieldUpdateBinary.setText(file.getAbsolutePath());
            op.updateBinaryPath = file.getAbsolutePath();
            op.selectedDevice = "";
            op.selectedDeviceName = "";
            JOptionPane.showMessageDialog(null, "Please note that Devices not included in Supported List won't avail the feature of Kernel Flashing.\nSorry for inconvenience");
        } else {
            System.out.println("File access cancelled by user.");
        }
    }

    private void btnBrowseUpdateBinaryActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Browse Update Binary Clicked..!!");
        browseUpdateBinary();
    }

    public void browseSplashScreen(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.removeChoosableFileFilter(fileChooser.getFileFilter());
        FileFilter filter = new FileNameExtensionFilter(".png", "png");
        fileChooser.addChoosableFileFilter(filter);
        int returnVal = fileChooser.showOpenDialog(btnBrowseZipDestination);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            System.out.println("Zip File Destination Location : " + file.getAbsolutePath());
            op.splashPath = file.getAbsolutePath();
            //op.splashPath = op.splashPath.replaceAll("\\\\", "/");
            System.out.println("Splash Screen Path : " + op.splashPath);
        } else {
            System.out.println("File access cancelled by user.");
        }
    }
    
    public void browseZipDestination() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.removeChoosableFileFilter(fileChooser.getFileFilter());
        FileFilter filter = new FileNameExtensionFilter(".zip", "zip");
        fileChooser.addChoosableFileFilter(filter);
        int returnVal = fileChooser.showOpenDialog(btnBrowseZipDestination);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            System.out.println("Zip File Destination Location : " + file.getAbsolutePath());
            if (!file.getAbsolutePath().endsWith(".zip")) {
                op.zipDestination = file.getAbsolutePath() + ".zip";
            } else {
                op.zipDestination = file.getAbsolutePath();
            }
            textFieldZipDestination.setText(op.zipDestination);
            op.tempFolderPath = file.getParent() + "\\temp$$folder";
            System.out.println("Temp Folder Path : " + op.tempFolderPath);
        } else {
            System.out.println("File access cancelled by user.");
        }
    }

    private void btnBrowseZipDestinationActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Browse Zip Destination Clicked..");
        browseZipDestination();
    }

    public void btnResetAllActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Reset All Button Clicked..");
        resetAll();

    }

    public void btnCreateNormalZipActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        System.out.println("normal Zip Action Performed..");
        if (op.getGroupCount(op.bootAnimList) > 1) {
            JOptionPane.showMessageDialog(this, "Including more than one Boot Animation groups in Normal Zip can cause Undesirable results..!!\nJust keep one group and remove others..!!");
        } else if (op.getGroupCount(op.kernelList) > 1) {
            JOptionPane.showMessageDialog(this, "Including more than one kernel is risky..!!\nKindly keep one group and remove others..!!");
        } else if (this.checkIfEverythingIsOkay()) {
            op.flashableZipType = evt.getActionCommand();
            //CZtask = new createZipTask();
            createZipUI();
            //JOptionPane.showMessageDialog(this, "Zip File Successfully Created..!! Enjoy..!!");
        }
    }

    public void btnCreateAromaZipActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        System.out.println("Create Aroma Zip Clicked..");
        if (this.checkIfEverythingIsOkay()) {
            op.flashableZipType = evt.getActionCommand();
            createZipUI();
        }
    }

    public void btnBrowseZipActionPerformed(ActionEvent evt) {
        if (setExistingZipPath()) {
            //setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            IZtask = new ImportZip(this, this.op);
            IZtask.execute();
            //this.textFieldZipDestination.setText(op.zipDestination);
        } else {
            setLog("Cancelled By User", textAreaImportZipLog);
        }
    }

    private void btnAddDescriptionActionPerformed(ActionEvent evt) {
        System.out.println("Add Descrition Button Clicked..");
        switch (lastSelected) {
            case "APKs Group":
            case "Ringtones Group":
            case "Notifications Group":
                if (!this.fileList.isSelectionEmpty()) {
                    addDescriptionUI();
                } else {
                    JOptionPane.showMessageDialog(null, "Select File First..!!");
                }
                break;
            case "Kernel Group":
            case "Boot Animation Group":
            case "Fonts Group":
                if (!this.groupList.isSelectionEmpty()) {
                    addDescriptionUI();
                } else {
                    JOptionPane.showMessageDialog(null, "Select Group First..!!");
                }
                break;
            default:
                System.out.println("Something Went Wrong..!!");
        }

    }

    public boolean setExistingZipPath() {
        System.out.println("Load Flashable Zip Clicked..!!");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setMultiSelectionEnabled(false);
        fileChooser.removeChoosableFileFilter(fileChooser.getFileFilter());
        FileFilter filter = new FileNameExtensionFilter(".zip", "zip");
        fileChooser.addChoosableFileFilter(filter);
        int returnVal = fileChooser.showOpenDialog(btnBrowseZip);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            System.out.println("Existing Zip File Location : " + file.getAbsolutePath());
            if (file.isDirectory() || returnVal == JFileChooser.CANCEL_OPTION) {
                JOptionPane.showMessageDialog(this, "Invalid File Type..!!\n Try Again..!!");
                return false;
            } else {
                op.existingZipPath = file.getAbsolutePath();
                return true;
            }
        } else {
            JOptionPane.showMessageDialog(this, "File access cancelled by user.");
            return false;
        }
    }

    public void setLog(String message, JTextArea textArea) {
        textArea.append(message + "\n");
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }

    public boolean isAnyGroupEmpty() {
        for (String groups : op.groupArrayList) {
            if (!op.map.containsKey(groups)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkIfEverythingIsOkay() {
        if (op.selectedDevice.equals("") && this.textFieldUpdateBinary.getText().equals("Click Here To Select update-binary....")) {
            JOptionPane.showMessageDialog(this, "update-binary not imported..!!");
            return false;
        } else if (op.zipDestination.equals("")) {
            JOptionPane.showMessageDialog(this, "You forgot to enter destination path of zip file..!!");
            return false;
        } else if (op.deleteApkList.isEmpty()) {
            if (op.groupArrayList.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Zip cannot be created without group..\nFirst create one..!!");
                return false;
            } else if (isAnyGroupEmpty()) {
                JOptionPane.showMessageDialog(this, "One of the group is left empty..!!\n Kindly add items to that group or remove group..!!");
                return false;
            } else if (op.map.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Add Files to group..\nWithout files, nothing can be done with Zip file..!!");
                return false;
            }
        }
        return true;
    }

    public void resetAll() {
        op.lastActionCommand = "";
        op.updateBinaryPath = "";
        op.zipDestination = "";
        op.tempFolderPath = "";
        op.selectedDevice = "";
        op.selectedDeviceName = "";
        op.aroma_config = "";
        op.updater_script = "";
        op.flashableZipType = "";
        op.jarFileName = "";
        op.existingZipPath = "";
        op.deleteApkConfigList = "";
        op.appConfigPath = "customize/DeleteSystemApps/app-config";
        op.kernelMountPoint = "";

        op.groupArrayList = new ArrayList<>();
        op.systemList = new ArrayList<>();
        op.privAppList = new ArrayList<>();
        op.dataList = new ArrayList<>();
        op.bootAnimList = new ArrayList<>();
        op.ringtoneList = new ArrayList<>();
        op.notifList = new ArrayList<>();
        op.kernelList = new ArrayList<>();
        op.advancedList = new ArrayList<>();
        op.deleteApkList = new ArrayList<>();
        op.fontsList = new ArrayList<>();
        op.arrayList = new ArrayList<>();
        op.jarFileList = new ArrayList<>();

        op.map = new MultiValueMap();

        removeHighlight(this.lastSelected);

        this.lastSelected = "APKs Group";
        this.btnApkGroup.setContentAreaFilled(true);

        this.refreshGroupList(this.lastSelected);

        textFieldUpdateBinary.setText("Click Here To Select update-binary....");
        textFieldZipDestination.setText("Click Here To Select Zip Destination....");
    }

    public void displayAddGroupUI(String lastSelected) {
        switch (lastSelected) {
            case "APKs Group":
                addApkGroupUI();
                break;
            case "Boot Animation Group":
                addGroupUI();
                break;
            case "Ringtones Group":
                addGroupUI();
                break;
            case "Notifications Group":
                addGroupUI();
                break;
            case "Kernel Group":
                addGroupUI();
                break;
            case "Fonts Group":
                addGroupUI();
                break;
            case "Advanced Group":
                btnAdvancedGroup.setSelected(false);
                break;
            case "Delete System Files Group":
                btnDeleteSystemFilesGroup.setSelected(false);
            default:
                System.out.println("Something Went Wrong..!!");
        }
    }

    public void removeHighlight(String lastSelected) {
        switch (lastSelected) {
            case "APKs Group":
                btnApkGroup.setContentAreaFilled(false);
                break;
            case "Boot Animation Group":
                btnBootAnimGroup.setContentAreaFilled(false);
                break;
            case "Ringtones Group":
                btnRingtonesGroup.setContentAreaFilled(false);
                break;
            case "Notifications Group":
                btnNotifGroup.setContentAreaFilled(false);
                break;
            case "Kernel Group":
                btnKernelGroup.setContentAreaFilled(false);
                break;
            case "Fonts Group":
                btnFontsGroup.setContentAreaFilled(false);
                break;
            case "Delete System Files Group":
                btnDeleteSystemFilesGroup.setContentAreaFilled(false);
            default:
                System.out.println("Something Went Wrong..!!");
        }

    }

    public void refreshGroupList(String lastSelected) {
        try {
            System.out.println("Group model empty is : " + groupModel.isEmpty());
            this.groupModel.removeAllElements();
            System.out.println("Group model empty is : " + groupModel.isEmpty());
            switch (lastSelected) {
                case "APKs Group":
                    if (!op.systemList.isEmpty()) {
                        op.fillListModelWithArrayList(groupModel, op.systemList, "APKs-System");
                    }
                    if (!op.dataList.isEmpty()) {
                        op.fillListModelWithArrayList(groupModel, op.dataList, "APKs-Data");
                    }
                    if (!op.privAppList.isEmpty()) {
                        op.fillListModelWithArrayList(groupModel, op.privAppList, "APKs-PrivApp");
                    }
                    groupList.setSelectedIndex(0);
                    //System.out.println("Button Group is : " + this.buttonGroup.getSelection().getActionCommand());
                    break;
                case "Boot Animation Group":
                    op.fillListModelWithArrayList(groupModel, op.bootAnimList, "BootAnimations");
                    groupList.setSelectedIndex(0);
                    System.out.println("Button Group Added in : " + op.bootAnimList);
                    break;
                case "Ringtones Group":
                    op.fillListModelWithArrayList(groupModel, op.ringtoneList, "Ringtones");
                    groupList.setSelectedIndex(0);
                    System.out.println("Button Group Added in : " + op.ringtoneList);
                    break;
                case "Fonts Group":
                    op.fillListModelWithArrayList(groupModel, op.fontsList, "Fonts");
                    groupList.setSelectedIndex(0);
                    System.out.println("Button Group Added in : " + op.fontsList);
                    break;
                case "Notifications Group":
                    op.fillListModelWithArrayList(groupModel, op.notifList, "Notifications");
                    groupList.setSelectedIndex(0);
                    System.out.println("Button Group Added in : " + op.lastActionCommand);
                    break;
                case "Kernel Group":
                    op.fillListModelWithArrayList(groupModel, op.kernelList, "Kernel");
                    groupList.setSelectedIndex(0);
                    System.out.println("Button Group Added in : " + op.lastActionCommand);
                    break;
                case "Advanced Group":
                    op.fillListModelWithArrayList(groupModel, op.advancedList, "Advanced");
                    groupList.setSelectedIndex(0);
                    System.out.println("Button Group Added in : " + op.lastActionCommand);
                    break;
                case "Delete System Files Group":
                    op.fillListModelWithArrayList(groupModel, op.deleteApkList, "DeleteSystemApk");
                    groupList.setSelectedIndex(0);
                    System.out.println("Button Group Added in : " + op.lastActionCommand);
//                        op.deleteApkList.add(this.groupName.getText());
//                        System.out.println("Button Group Added in : " + op.lastActionCommand);
                default:
                    System.out.println("Something Went Wrong..!!");
            }

            //This will close/dispose current dialogbox..
            //frame.dispose();
        } catch (NullPointerException npe) {
            System.out.println("Exception caught in refreshGroupList");
            npe.printStackTrace();
        }
    }

    public void updateFileList() {
        try {
            switch (lastSelected) {
                case "APKs Group":
                    if (op.groupArrayList.contains("APKs-System_" + this.groupList.getSelectedValue().toString()) && op.groupArrayList.contains("APKs-Data_" + this.groupList.getSelectedValue().toString())) {
                        //BIG FAULT HERE......NO SOLUTION AVAILABLE
                        break;
                    }
                    if (op.map.containsKey("APKs-System_" + this.groupList.getSelectedValue().toString()) || op.groupArrayList.contains("APKs-System_" + this.groupList.getSelectedValue().toString())) {
                        System.out.println("Working!!");
                        this.fileModel.removeAllElements();
                        op.updateFileListWithSelectedGroupList("APKs-System_" + groupList.getSelectedValue().toString(), this.fileModel, op.map);
                    } else if (op.map.containsKey("APKs-Data_" + this.groupList.getSelectedValue().toString()) || op.groupArrayList.contains("APKs-Data_" + this.groupList.getSelectedValue().toString())) {
                        System.out.println("Working!!");
                        this.fileModel.removeAllElements();
                        op.updateFileListWithSelectedGroupList("APKs-Data_" + groupList.getSelectedValue().toString(), this.fileModel, op.map);
                    } else if (op.map.containsKey("APKs-PrivApp_" + this.groupList.getSelectedValue().toString()) || op.groupArrayList.contains("APKs-PrivApp_" + this.groupList.getSelectedValue().toString())) {
                        System.out.println("Working!!");
                        this.fileModel.removeAllElements();
                        op.updateFileListWithSelectedGroupList("APKs-PrivApp_" + groupList.getSelectedValue().toString(), this.fileModel, op.map);
                    } else {
                        this.fileModel.removeAllElements();
                    }
                    break;
                case "Boot Animation Group":
                    if (op.map.containsKey("BootAnimations_" + this.groupList.getSelectedValue().toString())) {
                        System.out.println("Working!!");
                        fileModel.removeAllElements();
                        op.updateFileListWithSelectedGroupList("BootAnimations_" + groupList.getSelectedValue().toString(), fileModel, op.map);
                    } else {
                        this.fileModel.removeAllElements();
                    }
                    break;
                case "Ringtones Group":
                    if (op.map.containsKey("Ringtones_" + this.groupList.getSelectedValue().toString())) {
                        System.out.println("Working!!");
                        fileModel.removeAllElements();
                        op.updateFileListWithSelectedGroupList("Ringtones_" + groupList.getSelectedValue().toString(), fileModel, op.map);
                    } else {
                        this.fileModel.removeAllElements();
                    }
                    break;
                case "Notifications Group":
                    if (op.map.containsKey("Notifications_" + this.groupList.getSelectedValue().toString())) {
                        System.out.println("Working!!");
                        fileModel.removeAllElements();
                        op.updateFileListWithSelectedGroupList("Notifications_" + groupList.getSelectedValue().toString(), fileModel, op.map);
                    } else {
                        this.fileModel.removeAllElements();
                    }
                    break;
                case "Fonts Group":
                    if (op.map.containsKey("Fonts_" + this.groupList.getSelectedValue().toString())) {
                        System.out.println("Working!!");
                        fileModel.removeAllElements();
                        op.updateFileListWithSelectedGroupList("Fonts_" + groupList.getSelectedValue().toString(), fileModel, op.map);
                    } else {
                        this.fileModel.removeAllElements();
                    }
                    break;
                case "Kernel Group":
                    if (op.map.containsKey("Kernel_" + this.groupList.getSelectedValue().toString())) {
                        System.out.println("Working!!");
                        fileModel.removeAllElements();
                        op.updateFileListWithSelectedGroupList("Kernel_" + groupList.getSelectedValue().toString(), fileModel, op.map);
                    } else {
                        this.fileModel.removeAllElements();
                    }
                    break;
                case "Advanced Group":
                    if (op.map.containsKey("Advanced_" + this.groupList.getSelectedValue().toString())) {
                        System.out.println("Working!!");
                        fileModel.removeAllElements();
                        op.updateFileListWithSelectedGroupList("Advanced_" + groupList.getSelectedValue().toString(), fileModel, op.map);
                    }
                    break;
                case "Delete System Files Group":
//                    if(op.map.containsKey("DeleteApk_"+this.groupList.getSelectedValue().toString())){
//                        System.out.println("Working!!" );
//                        fileModel.removeAllElements();
//                        op.updateFileListWithSelectedGroupList("DeleteApk_"+groupList.getSelectedValue().toString(), fileModel, op.map);
//                    }
                    break;
                default:
                    System.out.println("in Default....");
                    fileModel.removeAllElements();
                    System.out.println("Not Working!!");
            }
        } catch (NullPointerException npe) {
            System.out.println("Exception Caught in updateFileList");
            //npe.printStackTrace();
            fileModel.removeAllElements();
        }
    }

    public void updateGroupList(String lastSelected) {
        JOptionPane.showMessageDialog(null, this.buttonGroup.getSelection().getActionCommand());
        if (op.groupArrayList.toString().toLowerCase().contains(this.groupName.getText().toLowerCase())) {
            JOptionPane.showMessageDialog(null, "Group Name Already Exists..!!");
        } else if (!this.groupName.getText().equals("") && !this.groupName.getText().contains("_")) {
            switch (lastSelected) {
                case "APKs Group":
                    if (op.groupArrayList.contains("APKs-System_" + this.groupName.getText()) || op.groupArrayList.contains("APKs-Data_" + this.groupName.getText()) || op.groupArrayList.contains("APKs-Priv App_" + this.groupName.getText())) {
                        JOptionPane.showMessageDialog(null, "Group Name Already Exists..!!");
                        break;
                    } else if (this.buttonGroup.getSelection().getActionCommand().equals("Add System Apk Group")) { //&& !op.groupArrayList.contains("APKs-System_"+this.groupName.getText())
                        op.groupArrayList.add("APKs-System_" + this.groupName.getText());
                        System.out.println(op.groupArrayList.toString());
                        op.systemList.add("APKs-System_" + this.groupName.getText());
                        groupModel.addElement(this.groupName.getText());
                        groupList.setSelectedIndex(groupModel.getSize() - 1);
                        //frame.dispose();
                        break;
                    } else if (this.buttonGroup.getSelection().getActionCommand().equals("Add Data Apk Group")) {//&& !op.groupArrayList.contains("APKs-Data_"+this.groupName.getText())){
                        op.groupArrayList.add("APKs-Data_" + this.groupName.getText());
                        System.out.println(op.groupArrayList.toString());
                        op.dataList.add("APKs-Data_" + this.groupName.getText());
                        groupModel.addElement(this.groupName.getText());
                        groupList.setSelectedIndex(groupModel.getSize() - 1);
                        //frame.dispose();
                        break;
                    } else if (this.buttonGroup.getSelection().getActionCommand().equals("Add Priv Apk Group")) {//&& !op.groupArrayList.contains("APKs-Data_"+this.groupName.getText())){
                        op.groupArrayList.add("APKs-PrivApp_" + this.groupName.getText());
                        System.out.println(op.groupArrayList.toString());
                        op.privAppList.add("APKs-PrivApp_" + this.groupName.getText());
                        groupModel.addElement(this.groupName.getText());
                        groupList.setSelectedIndex(groupModel.getSize() - 1);
                        //frame.dispose();
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Group Name Already Exists..!!");
                        break;
                    }
                case "Boot Animation Group":
                    if (!op.groupArrayList.contains("BootAnimations_" + this.groupName.getText())) {
                        op.groupArrayList.add("BootAnimations_" + this.groupName.getText());
                        System.out.println(op.groupArrayList.toString());
                        op.bootAnimList.add("BootAnimations_" + this.groupName.getText());
                        groupModel.addElement(this.groupName.getText());
                        groupList.setSelectedIndex(groupModel.getSize() - 1);
                        //frame.dispose();
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Group Name Already Exists..!!");
                        break;
                    }

                case "Ringtones Group":
                    if (!op.groupArrayList.contains("Ringtones_" + this.groupName.getText())) {
                        op.groupArrayList.add("Ringtones_" + this.groupName.getText());
                        System.out.println(op.groupArrayList.toString());
                        op.ringtoneList.add("Ringtones_" + this.groupName.getText());
                        groupModel.addElement(this.groupName.getText());
                        groupList.setSelectedIndex(groupModel.getSize() - 1);
                        //frame.dispose();
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Group Name Already Exists..!!");
                        break;
                    }
                case "Notifications Group":
                    if (!op.groupArrayList.contains("Notifications_" + this.groupName.getText())) {
                        op.groupArrayList.add("Notifications_" + this.groupName.getText());
                        System.out.println(op.groupArrayList.toString());
                        op.notifList.add("Notifications_" + this.groupName.getText());
                        groupModel.addElement(this.groupName.getText());
                        groupList.setSelectedIndex(groupModel.getSize() - 1);
                        //frame.dispose();
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Group Name Already Exists..!!");
                        break;
                    }
                case "Kernel Group":
                    if (!op.groupArrayList.contains("Kernel_" + this.groupName.getText())) {
                        op.groupArrayList.add("Kernel_" + this.groupName.getText());
                        System.out.println(op.groupArrayList.toString());
                        op.kernelList.add("Kernel_" + this.groupName.getText());
                        groupModel.addElement(this.groupName.getText());
                        groupList.setSelectedIndex(groupModel.getSize() - 1);
                        //frame.dispose();
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Group Name Already Exists..!!");
                        break;
                    }
                case "Fonts Group":
                    if (!op.groupArrayList.contains("Fonts_" + this.groupName.getText())) {
                        op.groupArrayList.add("Fonts_" + this.groupName.getText());
                        System.out.println(op.groupArrayList.toString());
                        op.fontsList.add("Fonts_" + this.groupName.getText());
                        groupModel.addElement(this.groupName.getText());
                        groupList.setSelectedIndex(groupModel.getSize() - 1);
                        //frame.dispose();
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Group Name Already Exists..!!");
                        break;
                    }
                case "Advanced Group":
                    op.advancedList.add(this.groupName.getText());
                    groupModel.addElement(this.groupName.getText());
                    groupList.setSelectedIndex(groupModel.getSize() - 1);
                    //frame.dispose();
                    break;
                case "Delete System Files Group":
                    op.deleteApkList.add(this.groupName.getText());
                    groupModel.addElement(this.groupName.getText());
                    groupList.setSelectedIndex(groupModel.getSize() - 1);
                //frame.dispose();
                default:
                    System.out.println("Something Went Wrong..!!");
            }
        } else {
            if (this.groupName.getText().contains("_")) {
                JOptionPane.showMessageDialog(null, "Sorry, You Cannot Have Underscore(_) in Group Name..!!");
            } else {
                JOptionPane.showMessageDialog(null, "You Cannot Continue Without Setting Group Name..!!");
            }
        }
    }

    public void chooseFile(String lastSelected) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setMultiSelectionEnabled(true);
        fileChooser.removeChoosableFileFilter(fileChooser.getFileFilter());
        //FileFilter filter = new FileNameExtensionFilter("." + extension, extension);
        FileFilter filter;

        switch (lastSelected) {
            case "APKs Group":
                filter = new FileNameExtensionFilter(".apk", "apk");
                fileChooser.addChoosableFileFilter(filter);
                if (op.groupArrayList.contains("APKs-System_" + groupList.getSelectedValue().toString())) {
                    op.filterFile(fileChooser, btnAddFile, groupList, fileModel, "APKs-System");
                    System.out.println("Map contains : " + op.map);
                } else if (op.groupArrayList.contains("APKs-Data_" + groupList.getSelectedValue().toString())) {
                    op.filterFile(fileChooser, btnAddFile, groupList, fileModel, "APKs-Data");
                    System.out.println("Map contains : " + op.map);
                } else {
                    op.filterFile(fileChooser, btnAddFile, groupList, fileModel, "APKs-PrivApp");
                    System.out.println("Map contains : " + op.map);
                }
                break;
            case "Boot Animation Group":
                filter = new FileNameExtensionFilter(".zip", "zip");
                fileChooser.addChoosableFileFilter(filter);
                op.filterFile(fileChooser, btnAddFile, groupList, fileModel, "BootAnimations");
                System.out.println("Aroma Map contains : " + op.map);
                break;
            case "Ringtones Group":
                //filter = new FileNameExtensionFilter(".apk", "apk");
                fileChooser.addChoosableFileFilter(new AudioFilter());
                op.filterFile(fileChooser, btnAddFile, groupList, fileModel, "Ringtones");
                System.out.println("Aroma Map contains : " + op.map);
                break;
            case "Notifications Group":
                //filter = new FileNameExtensionFilter(".apk", "apk");
                //fileChooser.addChoosableFileFilter(filter);
                fileChooser.addChoosableFileFilter(new AudioFilter());
                op.filterFile(fileChooser, btnAddFile, groupList, fileModel, "Notifications");
                System.out.println("Aroma Map contains : " + op.map);
                break;
            case "Fonts Group":
                filter = new FileNameExtensionFilter(".ttf", "ttf");
                fileChooser.addChoosableFileFilter(filter);
                op.filterFile(fileChooser, btnAddFile, groupList, fileModel, "Fonts");
                System.out.println("Aroma Map contains : " + op.map);
                break;
            case "Kernel Group":
                filter = new FileNameExtensionFilter(".img", "img");
                fileChooser.addChoosableFileFilter(filter);
                op.filterFile(fileChooser, btnAddFile, groupList, fileModel, "Kernel");
                System.out.println("Aroma Map contains : " + op.map);
                break;
            case "Advanced Group":
                //filter = new FileNameExtensionFilter(".apk", "apk");
                //fileChooser.addChoosableFileFilter(filter);
                //this.filterFile(fileChooser, "zip", aroma_addBootAnimFiles, aroma_groupList, aromaFileModel, op.map);
                System.out.println("Aroma Map contains : " + op.map);
                break;
            case "Delete System Files Group":
            default:
                System.out.println("Something Went Wrong..!!");
        }
    }

    public void removeFile(String fileName) {
        if (!this.fileList.isSelectionEmpty()) {
            //this.fileList.setSelectionModel(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            switch (lastSelected) {
                case "APKs Group":
                    if (op.map.containsKey("APKs-System_" + this.groupList.getSelectedValue().toString())) {// && op.map.values().contains(fileName)){
                        op.map.removeMapping("APKs-System_" + this.groupList.getSelectedValue().toString(), op.getFilePath("APKs-System_" + this.groupList.getSelectedValue().toString(), fileName, op.map));
                        this.fileModel.removeAllElements();
                        op.updateFileListWithSelectedGroupList("APKs-System_" + this.groupList.getSelectedValue().toString(), this.fileModel, op.map);
                    } else if (op.map.containsKey("APKs-Data_" + this.groupList.getSelectedValue().toString())) {
                        op.map.removeMapping("APKs-Data_" + this.groupList.getSelectedValue().toString(), op.getFilePath("APKs-Data_" + this.groupList.getSelectedValue().toString(), fileName, op.map));
                        this.fileModel.removeAllElements();
                        op.updateFileListWithSelectedGroupList("APKs-Data_" + this.groupList.getSelectedValue().toString(), this.fileModel, op.map);
                    } else {
                        op.map.removeMapping("APKs-PrivApp_" + this.groupList.getSelectedValue().toString(), op.getFilePath("APKs-PrivApp_" + this.groupList.getSelectedValue().toString(), fileName, op.map));
                        this.fileModel.removeAllElements();
                        op.updateFileListWithSelectedGroupList("APKs-PrivApp_" + this.groupList.getSelectedValue().toString(), this.fileModel, op.map);
                    }
                    break;
                case "Boot Animation Group":
                    op.map.removeMapping("BootAnimations_" + this.groupList.getSelectedValue().toString(), op.getFilePath("BootAnimations_" + this.groupList.getSelectedValue().toString(), fileName, op.map));
                    this.fileModel.removeAllElements();
                    op.updateFileListWithSelectedGroupList("BootAnimations_" + this.groupList.getSelectedValue().toString(), this.fileModel, op.map);
                    break;
                case "Ringtones Group":
                    op.map.removeMapping("Ringtones_" + this.groupList.getSelectedValue().toString(), op.getFilePath("Ringtones_" + this.groupList.getSelectedValue().toString(), fileName, op.map));
                    this.fileModel.removeAllElements();
                    op.updateFileListWithSelectedGroupList("Ringtones_" + this.groupList.getSelectedValue().toString(), this.fileModel, op.map);
                    break;
                case "Notifications Group":
                    op.map.removeMapping("Notifications_" + this.groupList.getSelectedValue().toString(), op.getFilePath("Notifications_" + this.groupList.getSelectedValue().toString(), fileName, op.map));
                    this.fileModel.removeAllElements();
                    op.updateFileListWithSelectedGroupList("Notifications_" + this.groupList.getSelectedValue().toString(), this.fileModel, op.map);
                    break;
                case "Kernel Group":
                    op.map.removeMapping("Kernel_" + this.groupList.getSelectedValue().toString(), op.getFilePath("Kernel_" + this.groupList.getSelectedValue().toString(), fileName, op.map));
                    this.fileModel.removeAllElements();
                    op.updateFileListWithSelectedGroupList("Kernel_" + this.groupList.getSelectedValue().toString(), this.fileModel, op.map);
                    break;
                case "Fonts Group":
                    op.map.removeMapping("Fonts_" + this.groupList.getSelectedValue().toString(), op.getFilePath("Fonts_" + this.groupList.getSelectedValue().toString(), fileName, op.map));
                    this.fileModel.removeAllElements();
                    op.updateFileListWithSelectedGroupList("Fonts_" + this.groupList.getSelectedValue().toString(), this.fileModel, op.map);
                    break;
                case "Advanced Group":
                    op.map.removeMapping(this.groupList.getSelectedValue().toString(), op.getFilePath(this.groupList.getSelectedValue().toString(), fileName, op.map));
                    this.fileModel.removeAllElements();
                    op.updateFileListWithSelectedGroupList(this.groupList.getSelectedValue().toString(), this.fileModel, op.map);
                    break;
                case "Delete System Files Group":
                    op.map.removeMapping(this.groupList.getSelectedValue().toString(), op.getFilePath(this.groupList.getSelectedValue().toString(), fileName, op.map));
                    this.fileModel.removeAllElements();
                    op.updateFileListWithSelectedGroupList(this.groupList.getSelectedValue().toString(), this.fileModel, op.map);
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select Group First..!!");
        }
    }

    public void removeGroup(String groupName) {
        System.out.println(this.lastSelected + " is last selected");
        System.out.println("Map Before : " + op.map);
        System.out.println("Group List Contains : " + op.groupArrayList);
        if (!this.groupList.isSelectionEmpty()) {
            switch (this.lastSelected) {
                case "APKs Group":
                    if (op.systemList.contains("APKs-System_" + groupName)) {
                        op.systemList.remove("APKs-System_" + groupName);
                        op.groupArrayList.remove("APKs-System_" + groupName);
                        op.map.remove("APKs-System_" + groupName);
                    }
                    if (op.dataList.contains("APKs-Data_" + groupName)) {
                        op.dataList.remove("APKs-Data_" + groupName);
                        op.groupArrayList.remove("APKs-Data_" + groupName);
                        op.map.remove("APKs-Data_" + groupName);
                    }
                    if (op.privAppList.contains("APKs-PrivApp_" + groupName)) {
                        op.privAppList.remove("APKs-PrivApp_" + groupName);
                        op.groupArrayList.remove("APKs-PrivApp_" + groupName);
                        op.map.remove("APKs-PrivApp_" + groupName);
                    }
                    break;
                case "Boot Animation Group":
                    op.bootAnimList.remove("BootAnimations_" + groupName);
                    op.groupArrayList.remove("BootAnimations_" + groupName);
                    op.map.remove("BootAnimations_" + groupName);
                    break;
                case "Ringtones Group":
                    op.ringtoneList.remove("Ringtones_" + groupName);
                    op.groupArrayList.remove("Ringtones_" + groupName);
                    op.map.remove("Ringtones_" + groupName);
                    break;
                case "Notifications Group":
                    op.notifList.remove("Notifications_" + groupName);
                    op.groupArrayList.remove("Notifications_" + groupName);
                    op.map.remove("Notifications_" + groupName);
                    break;
                case "Kernel Group":
                    op.kernelList.remove("Kernel_" + groupName);
                    op.groupArrayList.remove("Kernel_" + groupName);
                    op.map.remove("Kernel_" + groupName);
                    break;
                case "Fonts Group":
                    op.fontsList.remove("Fonts_" + groupName);
                    op.groupArrayList.remove("Fonts_" + groupName);
                    op.map.remove("Fonts_" + groupName);
                    break;
                case "Advanced Group":
                    op.advancedList.remove(groupName);
                    op.map.remove(groupName);
                    break;
                case "Delete System Files Group":
                    op.deleteApkList.remove(groupName);
                    op.map.remove(groupName);
                default:
                    System.out.println("Something Went Wrong..!!");
            }
            //op.groupArrayList.remove(groupName);
            refreshGroupList(this.lastSelected);
            System.out.println("Map After : " + op.map);
            System.out.println("Group List Contains : " + op.groupArrayList);
        } else {
            JOptionPane.showMessageDialog(this, "Select Group First..!!");
        }
    }

    JFrame frame = new JFrame();
    ;
    Operations op = new Operations();
    ImportZip IZtask;// = new ImportZip(this, this.op);
    String lastSelected = "APKs Group";

    public CreateZip CZtask;
    boolean isZipLoaded = false;
    JDialog dialog;

    private javax.swing.JList CSDList;
    private javax.swing.JPanel CSDPanel;
    private javax.swing.JButton CSD_cancel;
    private javax.swing.JButton CSD_continue;
    private javax.swing.JPanel CSD_headingPanel;
    private javax.swing.JLabel lblCSDHeading1;

    private javax.swing.JPanel AddApkGroup_headingPanel;
    private javax.swing.JPanel addApkGroupPanel;
    private javax.swing.JRadioButton addApkGroupRadData;
    private javax.swing.JRadioButton addApkGroupRadPrivApp;
    private javax.swing.JRadioButton addApkGroupRadSystem;
    private javax.swing.JLabel addGroupNameTitle;
    private javax.swing.JLabel addGroupTitle;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnContinue;
    private javax.swing.JTextField groupName;
    private javax.swing.JLabel lblAddApkGroupHeading;

    private javax.swing.JPanel AddGroup_headingPanel;
    private javax.swing.JPanel addGroupPanel;
    private javax.swing.JLabel lblAddGroupHeading;

    public DefaultListModel groupModel;
    public DefaultListModel fileModel;
    public DefaultListModel deletefileModel;
    ButtonGroup buttonGroup;

    private javax.swing.JPanel DSAPanel;
    private javax.swing.JPanel DSA_headingPanel;
    private javax.swing.JButton btnAddDeleteFile;
    private javax.swing.JButton btnDoneDeleteFile;
    private javax.swing.JButton btnRemoveDeleteFile;
    private javax.swing.JButton btnResetDeleteFile;
    private javax.swing.JTextField deleteApkName;
    private javax.swing.JList deleteSystemFileList;
    private javax.swing.JScrollPane deleteSystemScrollPane;
    private javax.swing.JLabel lblDSAHeading;
    private javax.swing.JLabel lbl_deleteFileName;
    private javax.swing.JLabel lbl_deleteSystemExtension;
    private javax.swing.JLabel lbl_deleteSystemTitle;

    private javax.swing.JPanel IZheader_panel;
    public javax.swing.JButton btnBrowseZip;
    private javax.swing.JPanel importZipPanel;
    private javax.swing.JLabel lblIZheader;
    private javax.swing.JLabel lblProgress;
    private javax.swing.JLabel lblSelectZip;
    public javax.swing.JProgressBar progressImportZip;
    private javax.swing.JScrollPane scrollPaneImportZip;
    public javax.swing.JTextArea textAreaImportZipLog;
    public javax.swing.JTextField textFieldSelectZip;

    public javax.swing.JPanel CZPanel;
    private javax.swing.JPanel CZ_headingPanel9;
    private javax.swing.JButton btnClearLogCZ;
    private javax.swing.JButton btnSaveLogCZ;
    private javax.swing.JPanel debugPanel;
    private javax.swing.JScrollPane debugScrollPaneCZ;
    public javax.swing.JTextArea debugTextAreaCZ;
    private javax.swing.JLabel lblCZHeading;
    public javax.swing.JProgressBar progressCZ;
    private javax.swing.JPanel runPanel;
    private javax.swing.JScrollPane runScrollPaneCZ;
    public javax.swing.JTextArea runTextAreaCZ;
    private javax.swing.JTabbedPane tabbedPaneCZ;

    private javax.swing.JPanel ADPanel;
    private javax.swing.JPanel AD_headingPanel;
    private javax.swing.JScrollPane addDescriptionScrollPane;
    private javax.swing.JButton btnDoneDescription;
    private javax.swing.JButton btnCancelDescription;
    private javax.swing.JButton btnResetDescription;
    private javax.swing.JLabel lblADHeading;
    private javax.swing.JTextArea textAreaAddDescription;

    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JButton btnAddDescription;
    private javax.swing.JButton btnAddFile;
    private javax.swing.JButton btnAddGroup;
    private javax.swing.JButton btnAddSplash;
    private javax.swing.JButton btnAdvancedGroup;
    private javax.swing.JButton btnApkGroup;
    private javax.swing.JButton btnBootAnimGroup;
    private javax.swing.JButton btnBrowseUpdateBinary;
    private javax.swing.JButton btnBrowseZipDestination;
    private javax.swing.JButton btnCreateAromaZip;
    private javax.swing.JButton btnCreateNormalZip;
    private javax.swing.JButton btnDeleteSystemFilesGroup;
    private javax.swing.JButton btnFontsGroup;
    private javax.swing.JButton btnKernelGroup;
    private javax.swing.JButton btnLoadAromaFlashableZip;
    private javax.swing.JButton btnNotifGroup;
    private javax.swing.JButton btnPreferences;
    private javax.swing.JButton btnRemoveFile;
    private javax.swing.JButton btnRemoveGroup;
    private javax.swing.JButton btnResetAll;
    private javax.swing.JButton btnRingtonesGroup;
    private javax.swing.JButton btnSaveProject;
    private javax.swing.JButton btnSelectDevice;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JList fileList;
    private javax.swing.JScrollPane fileListScrollPane;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem loadMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JList groupList;
    private javax.swing.JScrollPane groupListScrollPane;
    private javax.swing.JPanel headingPanel;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel lblGroup;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblNote;
    private javax.swing.JLabel lblSubHeading;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblZipDestination;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPanel sideButtonPanel;
    private javax.swing.JTextField textFieldUpdateBinary;
    private javax.swing.JTextField textFieldZipDestination;
    private javax.swing.JPanel topButtonPanel;

}