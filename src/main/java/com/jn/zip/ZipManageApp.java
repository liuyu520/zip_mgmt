package com.jn.zip;

import com.common.util.CompressZipUtil;
import com.common.util.SystemHWUtil;
import com.jn.zip.dialog.PreviewDialog;
import com.jn.zip.listen.MyMenuActionListener;
import com.string.widget.util.ValueWidget;
import com.swing.component.ComponentUtil;
import com.swing.dialog.DialogUtil;
import com.swing.dialog.GenericFrame;
import com.swing.menu.MenuUtil2;
import com.swing.messagebox.GUIUtil23;
import org.apache.commons.compress.archivers.ArchiveException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class ZipManageApp extends GenericFrame {

	private static final long serialVersionUID = -3714870214517749783L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField compressFolderTF;
	private JButton button;
	private JButton browserButton;
	private JPanel panel;
	private JButton compressButton_2;
	private JLabel label_1;
	private JTextField zipNameTF;
	private JPanel panel_1;
	private JButton deCompressButton_1;
	private JLabel label_2;
	private JTextField decompressLocTF;
	private JButton browserButton_1;
	private JLabel label_3;
	private JComboBox encodingComboBox;
	private JSeparator separator;

	/**
	 * Create the frame.
	 */
	public ZipManageApp() {
		DialogUtil.lookAndFeel2();
		setMenu();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initialize2();

		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(600, 280);
		Dimension framesize = getSize();
		int x = (int) screensize.getWidth() / 2 - (int) framesize.getWidth() / 2;
		int y = (int) screensize.getHeight() / 2 - (int) framesize.getHeight() / 2;
		setLocation(x, y);


//		setBounds(100, 100, );
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0,
				Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		JLabel lblZip = new JLabel("待解压的zip 文件路径");
		GridBagConstraints gbc_lblZip = new GridBagConstraints();
		gbc_lblZip.anchor = GridBagConstraints.WEST;
		gbc_lblZip.insets = new Insets(0, 0, 5, 5);
		gbc_lblZip.gridx = 1;
		gbc_lblZip.gridy = 0;
		contentPane.add(lblZip, gbc_lblZip);

		// 要解压的zip文件
		textField = new JTextField();
		drag(textField);
		MenuUtil2.setPopupMenu(textField);
		textField.setText("D:\\Temp\\a\\a\\b\\c.zip");
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 0;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		ComponentUtil.assistantTF(textField);

		button = new JButton("浏览");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 4;
		gbc_button.gridy = 0;
		contentPane.add(button, gbc_button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* boolean isSuccess = */
				DialogUtil.browser3(textField,
						JFileChooser.FILES_ONLY, ZipManageApp.this);
			}
		});

		label_2 = new JLabel("解压到");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.WEST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 1;
		contentPane.add(label_2, gbc_label_2);

		decompressLocTF = new JTextField();
		drag(decompressLocTF);
		MenuUtil2.setPopupMenu(decompressLocTF);
		decompressLocTF.setText("D:\\Temp\\a\\c\\dd");
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 1;
		contentPane.add(decompressLocTF, gbc_textField_1);
		decompressLocTF.setColumns(10);
		ComponentUtil.assistantTF(decompressLocTF);

		browserButton_1 = new JButton("浏览");
		browserButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* boolean isSuccess = */
				DialogUtil.browser3(decompressLocTF,
						JFileChooser.DIRECTORIES_ONLY, ZipManageApp.this);
			}
		});
		GridBagConstraints gbc_browserButton_1 = new GridBagConstraints();
		gbc_browserButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_browserButton_1.gridx = 4;
		gbc_browserButton_1.gridy = 1;
		contentPane.add(browserButton_1, gbc_browserButton_1);

		label_3 = new JLabel("编码");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.WEST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 1;
		gbc_label_3.gridy = 2;
		contentPane.add(label_3, gbc_label_3);

		encodingComboBox = new JComboBox();
		//设置下拉框中的选项
		for (int i = 0; i < SystemHWUtil.CHARSET_ARRAY.length; i++) {
			String charSet = SystemHWUtil.CHARSET_ARRAY[i];
			encodingComboBox.addItem(charSet);
		}
		//设置默认选中的项
		encodingComboBox.setSelectedIndex(0);
		GridBagConstraints gbc_encodingComboBox = new GridBagConstraints();
		gbc_encodingComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_encodingComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_encodingComboBox.gridx = 3;
		gbc_encodingComboBox.gridy = 2;
		contentPane.add(encodingComboBox, gbc_encodingComboBox);

		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 3;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 3;
		contentPane.add(panel_1, gbc_panel_1);

		deCompressButton_1 = new JButton("解压(D)");
		deCompressButton_1.setMnemonic('D');//助记键,按Alt+D 就会触发按钮的单击事件
		panel_1.add(deCompressButton_1);

		//解压缩
		deCompressButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 解压后的文件所在目录
				String decompressLocStr = decompressLocTF.getText();
				String zipFile = textField.getText();
				if (!validate2()) {
					return;
				}
				// 若解压后的所在目录不存在，则创建
				File decompressLocFolder = new File(decompressLocStr);
				if (!decompressLocFolder.exists()) {
					decompressLocFolder.mkdirs();
				}
				String charset = (String) encodingComboBox.getSelectedItem();
				System.out.println("encoding :" + charset);
				try {
					boolean isSuccess = CompressZipUtil.deCompressRecursion(zipFile,
							decompressLocFolder, charset);
					if (isSuccess) {
						GUIUtil23.infoDialog("解压成功!");
					}
				} catch (ArchiveException e1) {
					e1.printStackTrace();
					GUIUtil23.errorDialog(e1.getMessage());
				} catch (IOException e2) {
					e2.printStackTrace();
					GUIUtil23.errorDialog(e2.getMessage());
				}
			}
		});

		JButton previewBtn = new JButton("预览");
		panel_1.add(previewBtn);
		previewBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String zipFileStr = textField.getText();
				if (!validate2()) {
					return;
				}
				File zipFile = new File(zipFileStr);

				PreviewDialog previewDialog = new PreviewDialog(true, zipFile);
				previewDialog.setVisible(true);
			}
		});

		separator = new JSeparator();
		separator.setToolTipText("");
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.gridwidth = 5;
		gbc_separator.insets = new Insets(0, 0, 5, 5);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 4;
		contentPane.add(separator, gbc_separator);

		JLabel label = new JLabel("要压缩的目录");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 5;
		contentPane.add(label, gbc_label);

		compressFolderTF = new JTextField();
		drag(compressFolderTF);
		MenuUtil2.setPopupMenu(compressFolderTF);
		compressFolderTF.setText("D:\\Temp\\a\\c");
		GridBagConstraints gbc_compressFolderTF = new GridBagConstraints();
		gbc_compressFolderTF.insets = new Insets(0, 0, 5, 5);
		gbc_compressFolderTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_compressFolderTF.gridx = 3;
		gbc_compressFolderTF.gridy = 5;
		contentPane.add(compressFolderTF, gbc_compressFolderTF);
		compressFolderTF.setColumns(10);
		ComponentUtil.assistantTF(compressFolderTF);

		browserButton = new JButton("浏览");
		GridBagConstraints gbc_browserButton = new GridBagConstraints();
		gbc_browserButton.insets = new Insets(0, 0, 5, 0);
		gbc_browserButton.gridx = 4;
		gbc_browserButton.gridy = 5;
		contentPane.add(browserButton, gbc_browserButton);
		browserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* boolean isSuccess = */
				DialogUtil.browser3(compressFolderTF,
						JFileChooser.DIRECTORIES_ONLY, ZipManageApp.this);
			}
		});

		label_1 = new JLabel("zip 压缩包名称");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.WEST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 6;
		contentPane.add(label_1, gbc_label_1);

		zipNameTF = new JTextField();
		drag(zipNameTF);
		MenuUtil2.setPopupMenu(zipNameTF);
		zipNameTF.setText("D:\\Temp\\a\\a\\b\\bb.zip");
		GridBagConstraints gbc_zipNameTF = new GridBagConstraints();
		gbc_zipNameTF.insets = new Insets(0, 0, 5, 5);
		gbc_zipNameTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_zipNameTF.gridx = 3;
		gbc_zipNameTF.gridy = 6;
		contentPane.add(zipNameTF, gbc_zipNameTF);
		zipNameTF.setColumns(10);

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 7;
		contentPane.add(panel, gbc_panel);

		compressButton_2 = new JButton("压缩(C)");
		compressButton_2.setMnemonic('C');
		//压缩
		compressButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String compressFolder = compressFolderTF.getText();
				File compressFile = new File(compressFolder);
				if (!compressFile.exists()) {
					GUIUtil23.warningDialog("File \"" + compressFolder
							+ "\" does not exist.");
					DialogUtil.focusSelectAllTF(compressFolderTF);
					return;
				}
				if (!compressFile.isDirectory()) {
					GUIUtil23.warningDialog("File \"" + compressFolder
							+ "\" Must be folder.");
					DialogUtil.focusSelectAllTF(compressFolderTF);
					return;
				}

				String zipPath = zipNameTF.getText();
				File zipFile = new File(zipPath);
				if (zipFile.exists()) {
					GUIUtil23.errorDialog("File has exist");
					return;
				}
				String fatherFolderStr = SystemHWUtil.getParentDir(zipPath);
				File fatherFolder = new File(fatherFolderStr);
				if (!fatherFolder.exists()) {//创建父目录
					fatherFolder.mkdirs();
				}
				try {
					// ZipUtil.compress(new File(zipName), compressFolder);
					CompressZipUtil.compressZipRecursion(zipPath, compressFolder);
				} catch (IOException e1) {
					e1.printStackTrace();
					GUIUtil23.errorDialog(e1.getMessage());
					return;
				} catch (ArchiveException e1) {
					e1.printStackTrace();
					GUIUtil23.errorDialog(e1.getMessage());
					return;
				}
				GUIUtil23.infoDialog("Compress successfully.");

			}
		});
		panel.add(compressButton_2);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZipManageApp frame = new ZipManageApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void initialize2() {
		setTitle("Java zip解压缩助手");
		init33(this);
	}

	private boolean validate2() {
		String zipName = textField.getText();
		if (ValueWidget.isNullOrEmpty(zipName)) {
			GUIUtil23.warningDialog("要解压的zip文件路径不能为空.");
			DialogUtil.focusSelectAllTF(textField);
			return false;
		}
		File zipFile = new File(zipName);
		if (!zipFile.exists()) {
			GUIUtil23.warningDialog("要解压的zip文件必须是已存在的.");
			DialogUtil.focusSelectAllTF(textField);
			return false;
		}

		String decompressLoc = decompressLocTF.getText();
		if (ValueWidget.isNullOrEmpty(decompressLoc)) {
			GUIUtil23.warningDialog("解压的目的目录不能为空.");
			DialogUtil.focusSelectAllTF(decompressLocTF);
			return false;
		}

		return true;
	}

	/***
	 * 增加菜单
	 */
	private void setMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileM = new JMenu("File");
//		JMenuItem fileM_test = new JMenuItem("测试");
//		fileM_test.setActionCommand("test");
//		fileM.add(fileM_test);

		JMenuItem fileM_exit = new JMenuItem(MenuUtil2.ACTION_STR_EXIT);
		fileM_exit.setActionCommand(MenuUtil2.ACTION_STR_EXIT);
		fileM.add(fileM_exit);

		menuBar.add(fileM);

		MyMenuActionListener myMenuListener = new MyMenuActionListener(this);

//		fileM_test.addActionListener(myMenuListener);
		fileM_exit.addActionListener(myMenuListener);

		JMenuItem helpM = new JMenuItem("帮助");
		helpM.setActionCommand(MenuUtil2.ACTION_HELP);
		helpM.addActionListener(myMenuListener);
		menuBar.add(helpM);
		this.setJMenuBar(menuBar);
	}
}
