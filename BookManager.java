package com.example.app;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.SwingConstants;

import com.example.domain.BookVO;
import com.example.repository.BookDAO;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JLayeredPane;

public class BookManager extends JFrame {

	private BookDAO bookDAO = new BookDAO();
	private ImageIcon bookIcon = new ImageIcon("C:\\Users\\admin\\eclipse-workspace\\portfolio\\image\\BOOK.jpg");

	private JTabbedPane tabbedPane;
	private JPanel panel1;
	private JPanel panel5;
	private JSplitPane splitPane;
	private JPanel panel2;
	private JLabel lblName;
	private JLabel lblWriter;
	private JLabel lblPublisher;
	private JLabel lblCount;
	private JLabel lblRegDate;
	private JTextField tfName;
	private JTextField tfWriter;
	private JTextField tfPublisher;
	private JTextField tfCount;
	private JTextField tfRegDate;
	private JButton btnRegister;
	private JPanel panel3;
	private JSplitPane splitPane_1;
	private JPanel panel4;
	private JComboBox comboBox;
	private JTextField tfSearch;
	private JButton btnSearch;
	private JLabel lblKategorie;
	private JTextField tfKategorie;
	private JLabel lblTotal;
	private JPanel panelBottom;
	private JButton btnTotal;
	private JButton btnModify;
	private JButton btnRemove;
	private JPanel panelWest;
	private JPanel panel_1;
	private JLabel lblName1;
	private JTextField tfName1;
	private JPanel panel_2;
	private JLabel lblWriter1;
	private JTextField tfWriter1;
	private JPanel panel;
	private JLabel lblPublisher1;
	private JTextField tfPublisher1;
	private JPanel panel_3;
	private JLabel lblKategorie1;
	private JTextField tfKategorie1;
	private JPanel panel_4;
	private JLabel lblCount1;
	private JTextField tfCount1;
	private JScrollPane scrollPane;
	private JPanel panel_5;
	private JTextField tfNum;
	private JLabel lblNum;
	private JPanel panel_6;
	private JLabel lblBackImage;
	private JLabel lblStorage;
	private JPanel panel_7;
	private JTextField tfNum1;
	private JLabel lblNum1;
	private JScrollPane scrollPane_2;
	private JTextArea textArea;
	private JScrollPane scrollPane_3;
	private JTextArea textArea_1;

	public static void main(String[] args) {
		new BookManager();

	}// main

	public BookManager() {
		super("å����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(435, 700);
		setLocationByPlatform(true);

		Container c = getContentPane();

		c.add(getTabbedPane(), BorderLayout.CENTER);

		setVisible(true);
	}// public BookManager
	
	
	private void clearInput() {
		tfName.setText("");
		tfWriter.setText("");
		tfPublisher.setText("");
		tfKategorie.setText("");
		tfCount.setText("");
	} // clearInput
	

	private void clearInput_1() {
		tfNum1.setText("");
		tfName1.setText("");
		tfWriter1.setText("");
		tfPublisher1.setText("");
		tfKategorie1.setText("");
		tfCount1.setText("");
	} // clearInput
	
	
	

	private JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.addTab("����", null, getPanel_6_1(), null);
			tabbedPane.addTab("���", null, getPanel1(), null);
			tabbedPane.addTab("��ü����", null, getPanel5(), null);
		}
		return tabbedPane;
	}

	private JPanel getPanel1() {
		if (panel1 == null) {
			panel1 = new JPanel();
			panel1.setLayout(new BorderLayout(0, 0));
			panel1.add(getSplitPane_1(), BorderLayout.CENTER);
		}
		return panel1;
	}

	private JPanel getPanel5() {
		if (panel5 == null) {
			panel5 = new JPanel();
			panel5.setForeground(new Color(51, 51, 51));
			panel5.setLayout(new BorderLayout(0, 0));
			panel5.add(getLblTotal(), BorderLayout.NORTH);
			panel5.add(getPanelBottom(), BorderLayout.SOUTH);
			panel5.add(getPanelWest(), BorderLayout.WEST);
			panel5.add(getScrollPane_3(), BorderLayout.CENTER);
		}
		return panel5;
	}

	private JSplitPane getSplitPane_1() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setBackground(new Color(102, 102, 102));
			splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPane.setLeftComponent(getPanel2());
			splitPane.setRightComponent(getPanel3());
			splitPane.setDividerLocation(180);
		}
		return splitPane;
	}

	private JPanel getPanel2() {
		if (panel2 == null) {
			panel2 = new JPanel();
			panel2.setForeground(new Color(255, 204, 153));
			panel2.setLayout(null);
			panel2.add(getLblName());
			panel2.add(getLblWriter());
			panel2.add(getLblPublisher());
			panel2.add(getLblCount());
			panel2.add(getLblRegDate());
			panel2.add(getTfName());
			panel2.add(getTfWriter());
			panel2.add(getTfPublisher());
			panel2.add(getTfCount());
			panel2.add(getTfRegDate());
			panel2.add(getBtnRegister());
			panel2.add(getLblKategorie());
			panel2.add(getTfKategorie());
		}
		return panel2;
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("å����");
			lblName.setHorizontalAlignment(SwingConstants.CENTER);
			lblName.setBounds(0, 12, 55, 18);
		}
		return lblName;
	}

	private JLabel getLblWriter() {
		if (lblWriter == null) {
			lblWriter = new JLabel("�۰�");
			lblWriter.setHorizontalAlignment(SwingConstants.LEFT);
			lblWriter.setBounds(10, 43, 55, 18);
		}
		return lblWriter;
	}

	private JLabel getLblPublisher() {
		if (lblPublisher == null) {
			lblPublisher = new JLabel("���ǻ�");
			lblPublisher.setHorizontalAlignment(SwingConstants.CENTER);
			lblPublisher.setBounds(0, 73, 55, 18);
		}
		return lblPublisher;
	}

	private JLabel getLblCount() {
		if (lblCount == null) {
			lblCount = new JLabel("����");
			lblCount.setHorizontalAlignment(SwingConstants.LEFT);
			lblCount.setBounds(182, 43, 55, 18);
		}
		return lblCount;
	}

	private JLabel getLblRegDate() {
		if (lblRegDate == null) {
			lblRegDate = new JLabel("������ ��¥");
			lblRegDate.setHorizontalAlignment(SwingConstants.CENTER);
			lblRegDate.setBounds(180, 73, 72, 18);
		}
		return lblRegDate;
	}

	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setBounds(48, 10, 114, 22);
			tfName.setColumns(10);
		}
		return tfName;
	}

	private JTextField getTfWriter() {
		if (tfWriter == null) {
			tfWriter = new JTextField();
			tfWriter.setBounds(48, 42, 114, 22);
			tfWriter.setColumns(10);
		}
		return tfWriter;
	}

	private JTextField getTfPublisher() {
		if (tfPublisher == null) {
			tfPublisher = new JTextField();
			tfPublisher.setBounds(48, 71, 114, 22);
			tfPublisher.setColumns(10);
		}
		return tfPublisher;
	}

	private JTextField getTfCount() {
		if (tfCount == null) {
			tfCount = new JTextField();
			tfCount.setBounds(251, 41, 114, 22);
			tfCount.setColumns(10);
		}
		return tfCount;
	}

	private JTextField getTfRegDate() {
		if (tfRegDate == null) {
			tfRegDate = new JTextField();
			tfRegDate.setBounds(251, 71, 114, 22);
			tfRegDate.setColumns(10);
		}
		return tfRegDate;
	}

	private JButton getBtnRegister() {
		if (btnRegister == null) {
			btnRegister = new JButton("����ϱ�");
			btnRegister.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					String name = tfName.getText();
					if (name.length() == 0) {
						JOptionPane.showMessageDialog(BookManager.this, "�Է����ּ���", "error", JOptionPane.ERROR_MESSAGE);
						tfName.requestFocus();
						return;
					} // IF

					BookVO bookVO = new BookVO();
					bookVO.setName(tfName.getText());
					bookVO.setWriter(tfWriter.getText());
					bookVO.setPublisher(tfPublisher.getText());
					bookVO.setKategorie(tfKategorie.getText());
					bookVO.setCount(tfCount.getText());
					bookVO.setRegdate(new Timestamp(System.currentTimeMillis()));

					bookDAO.insertBook(bookVO);// DB INSERT

					JOptionPane.showMessageDialog(BookManager.this, "��ϿϷ�Ǿ����ϴ�", "��ϿϷ�",
							JOptionPane.INFORMATION_MESSAGE);

					// ����
					clearInput();

				}// action
			});
			btnRegister.setFont(new Font("HY������B", Font.BOLD, 15));
			btnRegister.setForeground(new Color(102, 102, 102));
			btnRegister.setBackground(new Color(204, 204, 204));
			btnRegister.setBounds(139, 121, 98, 28);
		}
		return btnRegister;
	}

	private JPanel getPanel3() {
		if (panel3 == null) {
			panel3 = new JPanel();
			panel3.setLayout(new BorderLayout(0, 0));
			panel3.add(getSplitPane_1_1(), BorderLayout.CENTER);
		}
		return panel3;
	}

	private JSplitPane getSplitPane_1_1() {
		if (splitPane_1 == null) {
			splitPane_1 = new JSplitPane();
			splitPane_1.setRightComponent(getPanel4());
			splitPane_1.setLeftComponent(getScrollPane_2());
			splitPane_1.setDividerLocation(180);
		}
		return splitPane_1;
	}

	private JPanel getPanel4() {
		if (panel4 == null) {
			panel4 = new JPanel();
			panel4.setLayout(null);
			panel4.add(getComboBox());
			panel4.add(getTfSearch());
			panel4.add(getBtnSearch());

			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(329, 115, 2, 2);
			panel4.add(scrollPane_1);
		}
		return panel4;
	}

	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] { "����..", "����", "���ǻ�", "�۰�", "ī�װ�" }));
			comboBox.setBounds(12, 26, 65, 27);
		}
		return comboBox;
	}

	private JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.setBounds(12, 72, 162, 27);
			tfSearch.setColumns(10);
		}
		return tfSearch;
	}

	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("�˻��ϱ�");
			btnSearch.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					int selectedIndex = comboBox.getSelectedIndex();
					if (selectedIndex == 0) {
						JOptionPane.showMessageDialog(BookManager.this, "�˻��׸��� �������ּ���", "error",
								JOptionPane.ERROR_MESSAGE);
						return;
					} // if
					String word = tfSearch.getText();
					if (word.isEmpty()) {
						JOptionPane.showMessageDialog(BookManager.this, "�˻��� �Է����ּ���", "error",
								JOptionPane.ERROR_MESSAGE);
						return;
					} // if

					String field = "";
					switch (selectedIndex) {
					case 1:
						field = "name";
						break;
					case 2:
						field = "publisher";
						break;
					case 3:
						field = "writer";
						break;
					case 4:
						field = "kategorie";
						break;
					}

					List<BookVO> list = bookDAO.search(field, word);
					textArea.setText("");

					if (list.size() > 0) {
						for (BookVO book : list) {
							textArea.append("å�̸�:" + book.getName());
							textArea.append("���ǻ�:" + book.getPublisher());
							textArea.append("�۰�:" + book.getWriter());
							textArea.append("ī�װ�:" + book.getKategorie());
							
							
						
						}

					} else {// size()=0
						textArea.append("����� �������� �ʽ��ϴ�");
						
					
					}

				}// action
			});
			btnSearch.setFont(new Font("HY������B", Font.BOLD, 15));
			btnSearch.setBackground(new Color(204, 204, 204));
			btnSearch.setBounds(50, 153, 98, 28);
		}
		return btnSearch;
	}

	private JLabel getLblKategorie() {
		if (lblKategorie == null) {
			lblKategorie = new JLabel("ī�װ�");
			lblKategorie.setBounds(182, 12, 55, 18);
		}
		return lblKategorie;
	}

	private JTextField getTfKategorie() {
		if (tfKategorie == null) {
			tfKategorie = new JTextField();
			tfKategorie.setBounds(251, 10, 114, 22);
			tfKategorie.setColumns(10);
		}
		return tfKategorie;
	}

	private JLabel getLblTotal() {
		if (lblTotal == null) {
			lblTotal = new JLabel("��ü���");
			lblTotal.setFont(new Font("HY������B", Font.BOLD, 15));
			lblTotal.setForeground(new Color(0, 0, 0));
			lblTotal.setOpaque(true);
			lblTotal.setBackground(new Color(51, 102, 255));
			lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblTotal;
	}

	private JPanel getPanelBottom() {
		if (panelBottom == null) {
			panelBottom = new JPanel();
			panelBottom.add(getBtnTotal());
			panelBottom.add(getBtnModify());
			panelBottom.add(getBtnRemove());
		}
		return panelBottom;
	}

	private JButton getBtnTotal() {
		if (btnTotal == null) {
			btnTotal = new JButton("��ƺ���");
			btnTotal.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					textArea_1.setText("");

					List<BookVO> list = bookDAO.getBooks();

					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");

					for (BookVO book : list) {
						textArea_1.append(String.format("��ȣ:%d\n", book.getNum()));
						textArea_1.append(String.format("å����:%s\n", book.getName()));
						textArea_1.append(String.format("�۰�:%s\n", book.getWriter()));
						textArea_1.append(String.format("���ǻ�:%s\n", book.getPublisher()));
						textArea_1.append(String.format("ī�װ�:%s\n", book.getKategorie()));
						textArea_1.append(String.format("����:%s\n", book.getCount()));
						String strRegDate = sdf.format(book.getRegdate());
						textArea_1.append(String.format("��ϳ�¥ : %s\n\n", strRegDate));
					} // for

				}
			});
		}
		return btnTotal;
	}

	private JButton getBtnModify() {
		if (btnModify == null) {
			btnModify = new JButton("�����ϱ�");
			btnModify.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					BookVO bookVO = new BookVO();
					bookVO.setNum(Integer.parseInt(tfNum1.getText()));
					bookVO.setName(tfName1.getText());
					bookVO.setWriter(tfWriter1.getText());
					bookVO.setPublisher(tfPublisher1.getText());
					bookVO.setKategorie(tfKategorie1.getText());
					bookVO.setCount(tfCount1.getText());
					bookVO.setRegdate(new Timestamp(System.currentTimeMillis()));

					bookDAO.updateBooks(bookVO);
					
					clearInput_1();

					btnTotal.doClick();// ��ü����
				}
			});
		}
		return btnModify;
	}
	
	

	private JButton getBtnRemove() {
		if (btnRemove == null) {
			btnRemove = new JButton("�����ϱ�");
			btnRemove.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					int num = Integer.parseInt(tfNum1.getText());

					int result = JOptionPane.showConfirmDialog(BookManager.this, "���� ���� �Ͻðڽ��ϱ�", "Delete",
							JOptionPane.YES_NO_OPTION);

					if (result == JOptionPane.YES_OPTION) {
						bookDAO.removeByNum(num);
						
						clearInput_1();

						btnTotal.doClick();// ��ü����
						
						
						
					}//if
					
					

				}
			});
		}
		return btnRemove;
	}

	private JPanel getPanelWest() {
		if (panelWest == null) {
			panelWest = new JPanel();
			panelWest.setLayout(new GridLayout(0, 1, 0, 0));
			panelWest.add(getPanel_7());
			panelWest.add(getPanel_1());
			panelWest.add(getPanel_2());
			panelWest.add(getPanel());
			panelWest.add(getPanel_3());
			panelWest.add(getPanel_4());
			panelWest.add(getPanel_5());
		}
		return panelWest;
	}

	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.add(getLblName1());
			panel_1.add(getTextField_2());
		}
		return panel_1;
	}

	private JLabel getLblName1() {
		if (lblName1 == null) {
			lblName1 = new JLabel("å����");
		}
		return lblName1;
	}

	private JTextField getTextField_2() {
		if (tfName1 == null) {
			tfName1 = new JTextField();
			tfName1.setColumns(10);
		}
		return tfName1;
	}

	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.add(getLblWriter1());
			panel_2.add(getTextField_1_1());
		}
		return panel_2;
	}

	private JLabel getLblWriter1() {
		if (lblWriter1 == null) {
			lblWriter1 = new JLabel("�۰�");
		}
		return lblWriter1;
	}

	private JTextField getTextField_1_1() {
		if (tfWriter1 == null) {
			tfWriter1 = new JTextField();
			tfWriter1.setColumns(10);
		}
		return tfWriter1;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getLblPublisher1());
			panel.add(getTextField_2_1());
		}
		return panel;
	}

	private JLabel getLblPublisher1() {
		if (lblPublisher1 == null) {
			lblPublisher1 = new JLabel("���ǻ�");
		}
		return lblPublisher1;
	}

	private JTextField getTextField_2_1() {
		if (tfPublisher1 == null) {
			tfPublisher1 = new JTextField();
			tfPublisher1.setColumns(10);
		}
		return tfPublisher1;
	}

	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.add(getLblKategorie1());
			panel_3.add(getTfKategorie1());
		}
		return panel_3;
	}

	private JLabel getLblKategorie1() {
		if (lblKategorie1 == null) {
			lblKategorie1 = new JLabel("ī�װ�");
		}
		return lblKategorie1;
	}

	private JTextField getTfKategorie1() {
		if (tfKategorie1 == null) {
			tfKategorie1 = new JTextField();
			tfKategorie1.setColumns(10);
		}
		return tfKategorie1;
	}

	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.add(getLblCount1());
			panel_4.add(getTfCount1());
		}
		return panel_4;
	}

	private JLabel getLblCount1() {
		if (lblCount1 == null) {
			lblCount1 = new JLabel("����");
		}
		return lblCount1;
	}

	private JTextField getTfCount1() {
		if (tfCount1 == null) {
			tfCount1 = new JTextField();
			tfCount1.setColumns(10);
		}
		return tfCount1;
	}

	private JPanel getPanel_5() {
		if (panel_5 == null) {
			panel_5 = new JPanel();
			panel_5.add(getLblNum());
			panel_5.add(getTfNum());
		}
		return panel_5;
	}

	private JTextField getTfNum() {
		if (tfNum == null) {
			tfNum = new JTextField();
			tfNum.setColumns(10);
		}
		return tfNum;
	}

	private JLabel getLblNum() {
		if (lblNum == null) {
			lblNum = new JLabel("��ȣ");
		}
		return lblNum;
	}

	private JPanel getPanel_6_1() {
		if (panel_6 == null) {
			panel_6 = new JPanel();
			panel_6.setLayout(new BorderLayout(0, 0));
			panel_6.add(getLblBackImage(), BorderLayout.CENTER);
			panel_6.add(getLblStorage(), BorderLayout.NORTH);
		}
		return panel_6;
	}

	private JLabel getLblBackImage() {
		if (lblBackImage == null) {
//			Image img = bookIcon.getImage();
//			Image changedImg = img.getScaledInstance(435, 700, Image.SCALE_SMOOTH);
//			ImageIcon icon = new ImageIcon(changedImg);
			
			lblBackImage = new JLabel("", bookIcon, SwingConstants.CENTER);
		}
		return lblBackImage;
	}

	private JLabel getLblStorage() {
		if (lblStorage == null) {
			lblStorage = new JLabel("å����");
			lblStorage.setBackground(new Color(255, 248, 220));
			lblStorage.setFont(new Font("���Ļ�浸��", Font.BOLD, 16));
			lblStorage.setHorizontalAlignment(SwingConstants.CENTER);
			lblStorage.setOpaque(true);// ������
		}
		return lblStorage;
	}

	private JPanel getPanel_7() {
		if (panel_7 == null) {
			panel_7 = new JPanel();
			panel_7.add(getLblNum1());
			panel_7.add(getTfNum1());
		}
		return panel_7;
	}

	private JTextField getTfNum1() {
		if (tfNum1 == null) {
			tfNum1 = new JTextField();
			tfNum1.setColumns(10);
		}
		return tfNum1;
	}

	private JLabel getLblNum1() {
		if (lblNum1 == null) {
			lblNum1 = new JLabel("��ȣ");
		}
		return lblNum1;
	}

	private JScrollPane getScrollPane_2() {
		if (scrollPane_2 == null) {
			scrollPane_2 = new JScrollPane();
			scrollPane_2.setViewportView(getTextArea());
		}
		return scrollPane_2;
	}

	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}

	private JScrollPane getScrollPane_3() {
		if (scrollPane_3 == null) {
			scrollPane_3 = new JScrollPane();
			scrollPane_3.setViewportView(getTextArea_1());
		}
		return scrollPane_3;
	}

	private JTextArea getTextArea_1() {
		if (textArea_1 == null) {
			textArea_1 = new JTextArea();
		}
		return textArea_1;
	}
}// class