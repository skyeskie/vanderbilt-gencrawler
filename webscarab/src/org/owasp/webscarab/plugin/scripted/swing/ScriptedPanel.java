/*
 * ScriptedPanel.java
 *
 * Created on 03 January 2005, 07:44
 */

package org.owasp.webscarab.plugin.scripted.swing;

import org.owasp.webscarab.model.Preferences;
import org.owasp.webscarab.plugin.scripted.Scripted;
import org.owasp.webscarab.plugin.scripted.ScriptedUI;

import org.owasp.webscarab.ui.swing.SwingPluginUI;
import org.owasp.webscarab.util.swing.ColumnDataModel;
import org.owasp.webscarab.util.swing.DocumentOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Action;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.io.PrintStream;
import java.io.File;
import java.io.IOException;

import java.util.logging.Logger;

/**
 *
 * @author  rogan
 */
public class ScriptedPanel extends javax.swing.JPanel implements ScriptedUI, SwingPluginUI {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -5126009853771604406L;
	private static ColumnDataModel[] NO_COLUMNS = new ColumnDataModel[0];
    private static Action[] NO_ACTIONS = new Action[0];
    
    private Scripted _scripted = null;
    
    private PrintStream _printStream;
    
    private Logger _logger = Logger.getLogger(getClass().getName());
    
    /** Creates new form ScriptedPanel */
    public ScriptedPanel(Scripted scripted) {
        initComponents();
        _scripted = scripted;
        
        DocumentOutputStream dos = new DocumentOutputStream(10240);
        _printStream = new PrintStream(dos);
        outputTextArea.setDocument(dos.getDocument());
        
        _scripted.setUI(this);
        _scripted.setOut(_printStream);
        _scripted.setErr(_printStream);
        
        saveButton.setEnabled(_scripted.getScriptFile() != null);
        scriptLanguageTextField.setText(_scripted.getScriptLanguage());
        scriptTextPane.setText(_scripted.getScript());
        
        setEnabled(_scripted.isRunning());
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;

        scriptToolBar = new javax.swing.JToolBar();
        newButton = new javax.swing.JButton();
        loadButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        saveAsButton = new javax.swing.JButton();
        startButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        scriptLanguageTextField = new javax.swing.JTextField();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        scriptTextPane = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        outputTextArea = new javax.swing.JTextArea();

        setLayout(new java.awt.BorderLayout());

        newButton.setText("New");
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });

        scriptToolBar.add(newButton);

        loadButton.setText("Load");
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });

        scriptToolBar.add(loadButton);

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        scriptToolBar.add(saveButton);

        saveAsButton.setText("Save As");
        saveAsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsButtonActionPerformed(evt);
            }
        });

        scriptToolBar.add(saveAsButton);

        scriptToolBar.addSeparator();
        startButton.setText("Start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        scriptToolBar.add(startButton);

        stopButton.setText("Stop");
        stopButton.setEnabled(false);
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });

        scriptToolBar.add(stopButton);

        add(scriptToolBar, java.awt.BorderLayout.NORTH);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Language : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel2.add(jLabel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        gridBagConstraints.weightx = 1.0;
        jPanel2.add(scriptLanguageTextField, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jPanel2, gridBagConstraints);

        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setResizeWeight(0.7);
        jScrollPane1.setMinimumSize(new java.awt.Dimension(400, 100));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(400, 100));
        scriptTextPane.setFont(new java.awt.Font("Monospaced", 0, 14));
        scriptTextPane.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jScrollPane1.setViewportView(scriptTextPane);

        jSplitPane1.setLeftComponent(jScrollPane1);

        jScrollPane2.setMinimumSize(new java.awt.Dimension(400, 64));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(400, 64));
        outputTextArea.setBackground(new java.awt.Color(204, 204, 204));
        outputTextArea.setEditable(false);
        outputTextArea.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jScrollPane2.setViewportView(outputTextArea);

        jSplitPane1.setRightComponent(jScrollPane2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jSplitPane1, gridBagConstraints);

        add(jPanel1, java.awt.BorderLayout.CENTER);

    }//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        _scripted.setScript(scriptLanguageTextField.getText(), scriptTextPane.getText());
        try {
            _scripted.saveScript(_scripted.getScriptFile());
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, new String[] {"Error saving script: ", ioe.getMessage()}, "Error", JOptionPane.ERROR_MESSAGE);
            _logger.warning("Error saving script: " + ioe.getMessage());
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void saveAsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsButtonActionPerformed
        _scripted.setScript(scriptLanguageTextField.getText(), scriptTextPane.getText());
        JFileChooser jfc = new JFileChooser(Preferences.getPreference("Scripted.DefaultDirectory"));
        jfc.setDialogTitle("Save as");
        int returnVal = jfc.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File script = jfc.getSelectedFile();
            try {
                _scripted.saveScript(script);
            } catch (IOException ioe) {
                JOptionPane.showMessageDialog(null, new String[] {"Error saving script: ", ioe.getMessage()}, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        Preferences.setPreference("Scripted.DefaultDirectory", jfc.getCurrentDirectory().getAbsolutePath());
    }//GEN-LAST:event_saveAsButtonActionPerformed

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
        JFileChooser jfc = new JFileChooser(Preferences.getPreference("Scripted.DefaultDirectory"));
        jfc.setDialogTitle("Load script");
        int returnVal = jfc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File script = jfc.getSelectedFile();
            try {
                _scripted.loadScript(script);
            } catch (IOException ioe) {
                JOptionPane.showMessageDialog(null, new String[] {"Error loading script: ", ioe.getMessage()}, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        Preferences.setPreference("Scripted.DefaultDirectory", jfc.getCurrentDirectory().getAbsolutePath());
    }//GEN-LAST:event_loadButtonActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        try {
            _scripted.loadScript(null);
        } catch (IOException ioe) {} // can't throw an exception here
    }//GEN-LAST:event_newButtonActionPerformed
    
    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        _scripted.stopScript();
    }//GEN-LAST:event_stopButtonActionPerformed
    
    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        _scripted.setScript(scriptLanguageTextField.getText(), scriptTextPane.getText());
        _scripted.runScript();
    }//GEN-LAST:event_startButtonActionPerformed
    
    public Action[] getConversationActions() {
        return NO_ACTIONS;
    }
    
    public ColumnDataModel[] getConversationColumns() {
        return NO_COLUMNS;
    }
    
    public Action[] getUrlActions() {
        return NO_ACTIONS;
    }
    
    public ColumnDataModel[] getUrlColumns() {
        return NO_COLUMNS;
    }
    
    public PrintStream getErrorStream() {
        return _printStream;
    }
    
    public PrintStream getOutputStream() {
        return _printStream;
    }
    
    public javax.swing.JPanel getPanel() {
        return this;
    }
    
    public String getPluginName() {
        return _scripted.getPluginName();
    }
    
    public void scriptError(final String reason, final Throwable error) {
        if (SwingUtilities.isEventDispatchThread()) {
            // "The application script threw an exception: java.net.ConnectException: Connection refused BSF info: Scripted at line: 0 column: columnNo"
            String message = error.getMessage();
            try {
                int eStart = message.indexOf(":");
                int eEnd = message.indexOf("BSF info:");
                String info = message.substring(eEnd + 18);
                String ex = message.substring(eStart + 2, eEnd - 1);
                message = ex + "\n" + info;
            } catch (Exception e) {}
            JTextArea ta = new JTextArea(message);
            ta.setEditable(false);
            ta.setLineWrap(true);
            ta.setWrapStyleWord(true);
            ta.setBackground(new java.awt.Color(204,204,204));
            JScrollPane sp = new JScrollPane(ta);
            sp.setPreferredSize(new java.awt.Dimension(600,300));
            sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            JOptionPane.showMessageDialog(ScriptedPanel.this, sp, "Script execution error", JOptionPane.ERROR_MESSAGE);
        } else {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    scriptError(reason, error);
                }
            });
        }
    }
    
    public void scriptStarted() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                startButton.setEnabled(false);
                stopButton.setEnabled(true);
                scriptTextPane.setEnabled(false);
            }
        });
    }
    
    public void scriptStopped() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                startButton.setEnabled(true);
                stopButton.setEnabled(false);
                scriptTextPane.setEnabled(true);
            }
        });
    }
    
    public void scriptFileChanged(File file) {
        saveButton.setEnabled(file != null);
    }
    
    public void scriptChanged(String script) {
        if (! scriptTextPane.getText().equals(script)) {
            scriptTextPane.setText(script);
            scriptTextPane.setCaretPosition(0);
        }
    }
    
    public void scriptLanguageChanged(String language) {
        scriptLanguageTextField.setText(language);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton loadButton;
    private javax.swing.JButton newButton;
    private javax.swing.JTextArea outputTextArea;
    private javax.swing.JButton saveAsButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField scriptLanguageTextField;
    private javax.swing.JTextPane scriptTextPane;
    private javax.swing.JToolBar scriptToolBar;
    private javax.swing.JButton startButton;
    private javax.swing.JButton stopButton;
    // End of variables declaration//GEN-END:variables
    
}
