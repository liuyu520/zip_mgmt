package com.jn.zip.dialog;

import com.common.bean.ZipFileBean;
import com.common.util.CompressZipUtil;
import com.common.util.SystemHWUtil;
import com.io.hw.file.util.FileUtils;
import com.swing.component.ComponentUtil;
import com.swing.menu.MenuUtil2;
import org.apache.commons.compress.archivers.ArchiveException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class PreviewDialog extends JDialog {

    private static final long serialVersionUID = -545913484169262557L;
    private final JPanel contentPanel = new JPanel();
    private JTextArea previewTextArea;

    /**
     * Create the dialog.
     */
    public PreviewDialog(boolean isModel, File zipFile) {
        this.setTitle("预览zip包内容");
        this.setModal(isModel);
        setBounds(200, 100, 450, 400);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));
        JScrollPane scrollPane = new JScrollPane();
        contentPanel.add(scrollPane, BorderLayout.CENTER);
        previewTextArea = new JTextArea();
        previewTextArea.setEditable(false);
        previewTextArea.setLineWrap(true);
        previewTextArea.setWrapStyleWord(true);
        previewTextArea.setFocusable(true);

        MenuUtil2.setPopupMenu(previewTextArea);

        scrollPane.setViewportView(previewTextArea);
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);
        JButton okButton = new JButton("OK");
        okButton.setActionCommand("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PreviewDialog.this.dispose();
            }
        });
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);
        // JButton cancelButton = new JButton("Cancel");
        // cancelButton.setActionCommand("Cancel");
        // buttonPane.add(cancelButton);
        init(zipFile);
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        // try {
        // PreviewDialog dialog = new PreviewDialog();
        // dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        // dialog.setVisible(true);
        // } catch (Exception e) {
        // e.printStackTrace();
        // }
    }

    private void init(File zipFile) {
        long length = zipFile.length();
        String sizeDesc = FileUtils.formatFileSize2(length);
        ComponentUtil.appendResult(previewTextArea, "zip包大小:" + sizeDesc, true);
        List<ZipFileBean> zipFiles;
        try {
            zipFiles = CompressZipUtil.deCompressRecursionFileList(zipFile,
                    SystemHWUtil.CHARSET_UTF, true/*isCloseZipInputStream*/);
            for (int i = 0; i < zipFiles.size(); i++) {
                ZipFileBean zipFileBean = zipFiles.get(i);
                // System.out.println(String.valueOf(!zipFileBean.isDir()) +
                // "\t\t"
                // + zipFileBean.getFileName());
                ComponentUtil.appendResult(previewTextArea,
                        zipFileBean.getFileName(), false);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ArchiveException e) {
            e.printStackTrace();
        }

    }

}
