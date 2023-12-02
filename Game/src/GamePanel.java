import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class GamePanel extends JPanel {
    private ScorePanel scorePanel;
    private GameGround gameGround;
    private String selectedOption; // selectedOption을 멤버 변수로 추가

    public GamePanel(String selectedOption) {
        this.selectedOption = selectedOption; // 생성자를 통해 selectedOption 초기화
        scorePanel = new ScorePanel();
        setBackground(Color.yellow);    
        setLayout(new BorderLayout());
        splitPanel();
    }

    public void setPlayerId(String id) {
        scorePanel.setPlayerId(id);
    }

    private void splitPanel() {
        JSplitPane hPane = new JSplitPane();
        hPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        hPane.setDividerLocation(800);
        hPane.setEnabled(false); // 못움직이게 하는 설정
        add(hPane);
        
        JSplitPane vPane = new JSplitPane();
        vPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        vPane.setEnabled(false); // 못움직이게 하는 설정
        vPane.setDividerLocation(300);
        vPane.setTopComponent(scorePanel);
        vPane.setBottomComponent(new EditPanel());
        
        hPane.setRightComponent(vPane);
        // GameGround 객체를 생성할 때 selectedOption 값을 전달합니다.
        hPane.setLeftComponent(new GameGround(scorePanel, selectedOption));
    }
}