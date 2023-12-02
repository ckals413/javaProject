


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MainFrame extends JFrame {
	private MainPanel mainPanel = null; 
	private JMenu helpMenu = new JMenu("도움말");
	private JMenuItem helpItem = new JMenuItem("게임 방법");
	
	public MainFrame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("buble boble");
		setSize(800,600);
		makeMenu();
		mainPanel = new MainPanel();
		getContentPane().add(mainPanel);
		setResizable(false);
		setVisible(true);
	}
	
	private void makeMenu() {
		JMenuBar menuB = new JMenuBar();
		this.setJMenuBar(menuB); //add가 아니라 set인 이유= 메뉴바가 한개라서
		
		helpMenu.add(helpItem);
		menuB.add(helpMenu);
		
		helpItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(MainFrame.this, 
                                              "추억의 버블보블입니다.\n 각각의 몬스터 마다 능력이 다 다릅니다.\n"
                                              + " 텍스트를 맞춰 점수를 높게 얻으세요!", 
                                              "게임 정보", 
                                              JOptionPane.INFORMATION_MESSAGE);
            }
        });
		
	}

}
