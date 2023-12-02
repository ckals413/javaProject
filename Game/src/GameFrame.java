import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class GameFrame extends JFrame {
	  private GamePanel gamePanel;
	  private String selectedOption;

	    public GameFrame(String id, String selectedOption) {
	    this.selectedOption = selectedOption;
		setTitle("게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1050,600);
		makeMenu();
		makeToolbar();
		gamePanel = new GamePanel(selectedOption);
		gamePanel.setPlayerId(id);
		getContentPane().add(gamePanel,BorderLayout.CENTER);
		setVisible(true);
		
		
	}
	//메뉴바 만들기
	private void makeMenu() {
		JMenuBar mb = new JMenuBar(); //jframe에 메뉴바가 붙는 위치가 정해져있음. 
		//add가 아니라 set인 이유= 메뉴바가 한개라서 
		this.setJMenuBar(mb);
		JMenu fileMenu = new JMenu("File");
		fileMenu.add(new JMenuItem("Open"));
		fileMenu.add(new JMenuItem("Save"));
		fileMenu.add(new JMenuItem("Save As"));
		//분리 선그리기
		fileMenu.addSeparator();
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener() {//리스너 달기
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0); //종료
			}
		});
		fileMenu.add(exitItem);
		mb.add(fileMenu);
		//프로젝트에서도 메뉴바 만들어서 액션 리스너로 반응하게하기
		JMenu editMenu = new JMenu("Edit");
		editMenu.add(new JMenuItem("instert"));
		editMenu.add(new JMenuItem("replace"));
		mb.add(editMenu);	
	}
	
	public void makeToolbar() {
		//기본 툴바가 움직임
		JToolBar bar = new JToolBar();
		//bar.setBackground(Color.green);
		getContentPane().add(bar,BorderLayout.NORTH);
		JButton b = new JButton("Play");
		bar.add(b);
		//이미지 버튼
		ImageIcon normalIcon = new ImageIcon("normal.png");
		ImageIcon rolloverIcon = new ImageIcon("rollover.png");
		ImageIcon pressedIcon = new ImageIcon("pressed.png");
		JButton imageBtn = new JButton(normalIcon);
		imageBtn.setRolloverIcon(rolloverIcon);
		imageBtn.setPressedIcon(pressedIcon);
		bar.add(imageBtn);
		
		bar.setFloatable(false);//툴바 고정
	
	}
	
	

}