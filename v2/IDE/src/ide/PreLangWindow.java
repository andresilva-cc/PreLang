/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ide;

import gals.LexicalError;
import gals.Lexico;
import gals.SemanticError;
import gals.Semantico;
import gals.Sintatico;
import gals.Symbol;
import gals.SyntaticError;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author croisebeck
 */
public class PreLangWindow extends javax.swing.JFrame {

    private File arquivoAberto = null;
    private Lexico lexico;
    private Sintatico sintatico;
    private Semantico semantico;
    
    private ArrayList<Symbol> symbolTable;
    private String assemblyCode;
    
    /**
     * Creates new form PreLangWindow
     */
    public PreLangWindow() {
        initComponents();
        addListeners();
    }

    private void addListeners() {
      this.mniSymbolTable.addActionListener(e -> openSymbolTable());
      this.mniAssemblyCode.addActionListener(e -> openAssemblyCode());
    }
    
    private void openSymbolTable() {
      SymbolTableWindow symbolTableWindow = new SymbolTableWindow();
      symbolTableWindow.setVisible(true);
      symbolTableWindow.loadTable(symbolTable);
    }
    
    private void openAssemblyCode() {
      AssemblyCodeWindow assemblyCodeWindow = new AssemblyCodeWindow();
      assemblyCodeWindow.setVisible(true);
      assemblyCodeWindow.loadCode(assemblyCode);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    java.awt.GridBagConstraints gridBagConstraints;

    centro = new javax.swing.JPanel();
    editorScrollPane = new javax.swing.JScrollPane();
    editor = new javax.swing.JTextArea();
    status1 = new javax.swing.JPanel();
    btnRodar1 = new javax.swing.JButton();
    console = new javax.swing.JPanel();
    status = new javax.swing.JPanel();
    labelStatus = new javax.swing.JLabel();
    consoleScrollPane = new javax.swing.JScrollPane();
    consoleContent = new javax.swing.JTextArea();
    menu = new javax.swing.JMenuBar();
    arquivo = new javax.swing.JMenu();
    abrir = new javax.swing.JMenuItem();
    salvar = new javax.swing.JMenuItem();
    sair = new javax.swing.JMenuItem();
    mnuTools = new javax.swing.JMenu();
    mniSymbolTable = new javax.swing.JMenuItem();
    mniAssemblyCode = new javax.swing.JMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("PreLang IDE");
    setBackground(new java.awt.Color(0, 0, 0));
    setLocationByPlatform(true);
    setPreferredSize(new java.awt.Dimension(800, 600));
    getContentPane().setLayout(new java.awt.GridBagLayout());

    centro.setLayout(new java.awt.GridBagLayout());

    editorScrollPane.setBackground(new java.awt.Color(51, 51, 51));

    editor.setBackground(new java.awt.Color(51, 51, 51));
    editor.setColumns(20);
    editor.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
    editor.setForeground(new java.awt.Color(238, 238, 238));
    editor.setRows(5);
    editor.setTabSize(2);
    editor.setCaretColor(new java.awt.Color(255, 255, 255));
    editor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    editor.setDisabledTextColor(new java.awt.Color(238, 238, 238));
    editor.setInheritsPopupMenu(true);
    editor.setMargin(new java.awt.Insets(10, 10, 10, 10));
    editorScrollPane.setViewportView(editor);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 1.0;
    centro.add(editorScrollPane, gridBagConstraints);

    status1.setBackground(java.awt.Color.darkGray);
    status1.setLayout(new java.awt.GridBagLayout());

    btnRodar1.setForeground(new java.awt.Color(18, 47, 60));
    btnRodar1.setText("Run");
    btnRodar1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnRodar1ActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 1.0;
    status1.add(btnRodar1, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 1.0;
    centro.add(status1, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 0.85;
    getContentPane().add(centro, gridBagConstraints);

    console.setForeground(java.awt.Color.darkGray);
    console.setLayout(new java.awt.GridBagLayout());

    status.setBackground(java.awt.Color.darkGray);
    status.setLayout(new java.awt.GridBagLayout());

    labelStatus.setBackground(new java.awt.Color(151, 149, 149));
    labelStatus.setForeground(new java.awt.Color(255, 255, 255));
    labelStatus.setText("Output");
    labelStatus.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    status.add(labelStatus, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 1.0;
    console.add(status, gridBagConstraints);

    consoleContent.setEditable(false);
    consoleContent.setBackground(new java.awt.Color(51, 51, 51));
    consoleContent.setColumns(20);
    consoleContent.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
    consoleContent.setForeground(new java.awt.Color(238, 238, 238));
    consoleContent.setRows(7);
    consoleContent.setCaretColor(new java.awt.Color(255, 255, 255));
    consoleContent.setMargin(new java.awt.Insets(10, 10, 10, 10));
    consoleScrollPane.setViewportView(consoleContent);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 1.0;
    console.add(consoleScrollPane, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 0.15;
    getContentPane().add(console, gridBagConstraints);

    menu.setBackground(new java.awt.Color(51, 51, 51));
    menu.setForeground(java.awt.Color.darkGray);
    menu.setBorderPainted(false);

    arquivo.setBackground(new java.awt.Color(51, 51, 51));
    arquivo.setForeground(new java.awt.Color(255, 255, 255));
    arquivo.setText("Arquivo");

    abrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
    abrir.setText("Abrir");
    abrir.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        abrirActionPerformed(evt);
      }
    });
    arquivo.add(abrir);

    salvar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
    salvar.setText("Salvar");
    salvar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        salvarActionPerformed(evt);
      }
    });
    arquivo.add(salvar);

    sair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
    sair.setText("Sair");
    sair.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        sairActionPerformed(evt);
      }
    });
    arquivo.add(sair);

    menu.add(arquivo);

    mnuTools.setBackground(new java.awt.Color(51, 51, 51));
    mnuTools.setForeground(new java.awt.Color(255, 255, 255));
    mnuTools.setText("Ferramentas");

    mniSymbolTable.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
    mniSymbolTable.setText("Tabela de Símbolos");
    mniSymbolTable.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mniSymbolTableActionPerformed(evt);
      }
    });
    mnuTools.add(mniSymbolTable);

    mniAssemblyCode.setText("Código Assembly");
    mnuTools.add(mniAssemblyCode);

    menu.add(mnuTools);

    setJMenuBar(menu);

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void setArquivoAberto(File arquivo){
        arquivoAberto = arquivo;
        this.setTitle("PreLang - "+arquivoAberto.getAbsolutePath());
    }
    
    private void abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirActionPerformed
        JFileChooser fileChooser = new JFileChooser(System.getProperty("user.home"));
        fileChooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) return true;
                return f.getName().endsWith(".pre");
            }

            @Override public String getDescription() { return "Arquivos PreLang"; }
        });
        fileChooser.showOpenDialog(this);
        File file = fileChooser.getSelectedFile();
        try {
            InputStream fis = new FileInputStream(file);
            fis = new BufferedInputStream(fis);
            int l;
            String content = "";
            while ( (l = fis.read()) != -1 ){
                content += (char) l;
            }
            fis.close();
            editor.setText(content);
            setArquivoAberto(file);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PreLangWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PreLangWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_abrirActionPerformed

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_sairActionPerformed

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
        if (arquivoAberto == null){
            JFileChooser fileChooser = new JFileChooser(System.getProperty("user.home"));
            fileChooser.setFileFilter(new FileFilter() {
                @Override
                public boolean accept(File f) {
                    if (f.isDirectory()) return true;
                    return f.getName().endsWith(".plg");
                }

                @Override public String getDescription() { return "Arquivos PreLang"; }
            });
            fileChooser.showSaveDialog(this);
            setArquivoAberto(fileChooser.getSelectedFile());
        }
        try {
            OutputStream fos = new FileOutputStream(arquivoAberto);
            fos = new BufferedOutputStream(fos);
            String text = editor.getText();
            for (int i = 0; i < text.length(); ++i){
                fos.write(text.charAt(i));
            }
            fos.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PreLangWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PreLangWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_salvarActionPerformed

    private void btnRodar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRodar1ActionPerformed
        lexico = new Lexico(editor.getText());        
        sintatico = new Sintatico();
        semantico = new Semantico();
        try {
            consoleContent.setText("");
            sintatico.parse(lexico, semantico);
            consoleContent.append("OK");
        } catch (LexicalError | SyntaticError | SemanticError ex) {
            consoleContent.append(ex.getMessage());
        } finally {
          this.symbolTable = semantico.symbolTable;
          this.assemblyCode = semantico.getAssemblyCode();
        }
    }//GEN-LAST:event_btnRodar1ActionPerformed

  private void mniSymbolTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniSymbolTableActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_mniSymbolTableActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JMenuItem abrir;
  private javax.swing.JMenu arquivo;
  private javax.swing.JButton btnRodar1;
  private javax.swing.JPanel centro;
  private javax.swing.JPanel console;
  private javax.swing.JTextArea consoleContent;
  private javax.swing.JScrollPane consoleScrollPane;
  public static javax.swing.JTextArea editor;
  private javax.swing.JScrollPane editorScrollPane;
  private javax.swing.JLabel labelStatus;
  private javax.swing.JMenuBar menu;
  private javax.swing.JMenuItem mniAssemblyCode;
  private javax.swing.JMenuItem mniSymbolTable;
  private javax.swing.JMenu mnuTools;
  private javax.swing.JMenuItem sair;
  private javax.swing.JMenuItem salvar;
  private javax.swing.JPanel status;
  private javax.swing.JPanel status1;
  // End of variables declaration//GEN-END:variables
}
