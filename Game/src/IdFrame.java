

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class IdFrame extends JFrame {
	private JTextField textField;

	public IdFrame() {
		setTitle("게임 회원가입");
		setSize(300, 400);
		Container c = getContentPane();
		c.setLayout(null);
		 c.setBackground(new Color(0, 0, 80));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null); // 화면 정중앙 출력
		

		JLabel registerLabel = new JLabel("ID:");
		registerLabel.setFont(new Font("휴먼엑스포", Font.BOLD, 12));
		registerLabel.setForeground(Color.WHITE); 
		registerLabel.setLocation(10,13);
		registerLabel.setSize(40, 15);
		c.add(registerLabel);
		
		textField = new JTextField();
		textField.setLocation(40, 10);
		textField.setSize(120, 21);
		c.add(textField);
		textField.requestFocus();
		
		ImageIcon p1Icon = new ImageIcon("registerP1.png");
	    ImageIcon p2Icon = new ImageIcon("registerP2.png");

        // 라디어 버튼 
        JRadioButton p1 = new JRadioButton("P1", p1Icon,true);
        p1.setSize(120,120);
        p1.setLocation(40,50);
        p1.setBorderPainted(true);

        JRadioButton p2 = new JRadioButton("P2", p2Icon);
        p2.setSize(120,120);
        p2.setLocation(40,180);
        p2.setBorderPainted(true);
 
        ButtonGroup group = new ButtonGroup(); //버튼 그룹
        group.add(p1);
        group.add(p2);
        
        c.add(p1);
        c.add(p2);
 
	    
		
        //회원가입 버튼
		JButton registerButton = new JButton("회원 가입");
		registerButton.setFont(new Font("휴먼엑스포", Font.BOLD, 16));
		registerButton.setLocation(40, 320);
		registerButton.setSize(120, 35);
		c.add(registerButton);

		registerButton.addActionListener(new ActionListener() {
			String id = (String) textField.getText();

			public void actionPerformed(ActionEvent e) {
				String id = textField.getText().trim();//아이디 공백제거
				String selectedOption = "";
				
		        if (id.equals("")) {
		            return; // 아이디가 비어있으면 동작 안함
		        }
				
			    if (p1.isSelected()) {
			    	selectedOption = "P1";
			    } else if (p2.isSelected()) {
			        selectedOption = "P2";
			    }
				
				
				System.out.println("id : " + id +"  Player: "+selectedOption );
				GameFrame gameFrame = new GameFrame(id, selectedOption);
				//**************게임 실행*****************//
				setVisible(false);
			}
		});

	
		
		
		setResizable(false);
		setVisible(true);

	}

}