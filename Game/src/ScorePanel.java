import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScorePanel extends JPanel {
    private int score = 0;
    private double lives = 5.0; // 총 목숨 수 (반 목숨을 표현하기 위해 double 타입 사용)
    private JLabel scoreLabel = new JLabel(Integer.toString(score));
    private JLabel[] lifeLabels = new JLabel[5]; // 목숨을 표시할 라벨 배열
    private JLabel timeLabel = new JLabel("Timer : 00");
    private JLabel playerIdLabel; // 사용자 ID를 표시할 레이블
    private String playerId; // 사용자 ID를 저장할 필드
    private JLabel levelLabel = new JLabel(); // 레벨 이미지를 표시할 라벨

	
    public ScorePanel() {
        setBackground(Color.yellow);
        setLayout(null); // 레이아웃 매니저 비활성화

        // 하트 이미지 라벨 초기화 및 배치
        int heartX = 10; // 시작 x 위치
        for (int i = 0; i < 5; i++) {
            lifeLabels[i] = new JLabel(new ImageIcon("heart1.png"));
            lifeLabels[i].setBounds(heartX, 10, 30, 30); // 위치와 크기 설정
            add(lifeLabels[i]);
            heartX += 35; // 다음 하트의 x 위치
        }

        // 점수 라벨 배치
        JLabel scoreText = new JLabel("Score: ");
        scoreText.setBounds(10, 50, 50, 30); // 위치와 크기 설정
        add(scoreText);

        scoreLabel.setBounds(60, 50, 100, 30); // 위치와 크기 설정
        add(scoreLabel);
        
        timeLabel.setFont(new Font("맑은고딕", Font.BOLD, 18));
		timeLabel.setForeground(Color.blue);
		timeLabel.setBounds(20, 80, 200, 26);
		//timeLabel.setText());
		add(timeLabel);
		
		 // 사용자 ID 레이블 초기화 및 배치
	    playerIdLabel = new JLabel("ID: ");
	    playerIdLabel.setBounds(10, 110, 200, 30); // 위치와 크기 설정
	    add(playerIdLabel);

	    levelLabel.setBounds(10, 130, 120, 120); // 위치와 크기 설정
        add(levelLabel);
        updateLevelImage(); // 초기 레벨 이미지 설정
        
    }
    private void updateLevelImage() {
        // 점수에 따라 다른 레벨 이미지 설정
        if (score < 20) {
            levelLabel.setIcon(new ImageIcon("level1.png"));
        } else if (score < 100) {
            levelLabel.setIcon(new ImageIcon("level2.png"));
        } else if (score < 150) {
            levelLabel.setIcon(new ImageIcon("level3.png"));
        } else {
            levelLabel.setIcon(new ImageIcon("level4.png"));
        }
    }
    
 // 사용자 ID를 설정하는 메소드
    public void setPlayerId(String id) {
    	this.playerId = id;
        playerIdLabel.setText("ID: " + playerId);
    }

    
    public void gameTime(int time) {
    	timeLabel.setText("Timer : " + Integer.toString(time)); // 시간 업데이트
    }

    public synchronized void increase() {
        score += 10;
        scoreLabel.setText(Integer.toString(score));
        updateLevelImage();
    }

    public synchronized  void increase(int n) {
        score += n;
        scoreLabel.setText(Integer.toString(score));
        updateLevelImage();
    }

    public synchronized void decrease() {
        score -= 10;
        if (score < 0)
            score = 0;
        scoreLabel.setText(Integer.toString(score));
        updateLevelImage();
    }
    public synchronized  void decrease(int n) {
        score -= n;
        if (score < 0)
            score = 0;
        scoreLabel.setText(Integer.toString(score));
        updateLevelImage();
    }
    
    public synchronized int getScore() {
		return score;
	}

    public void loseHalfLife() {
        if (lives > 0) {
            lives -= 0.5;
            int lifeIndex = (int)Math.floor(lives); // 반 목숨 처리를 위한 인덱스 계산 변경

            if (lives >= lifeIndex + 0.5 && lives < lifeIndex + 1) { // 반 목숨 남았을 경우
                lifeLabels[lifeIndex].setIcon(new ImageIcon("halfHeart.png"));
            } else if (lives == lifeIndex) { // 전체 목숨을 잃은 경우
                lifeLabels[lifeIndex].setVisible(false);
            }
            repaint();
        }
    }
    public void increaseLife() {
        if (lives < 5.0) { // 최대 목숨 수를 초과하지 않도록 확인
            if (lives % 1.0 == 0.5) { // 현재 반 목숨 상태라면
                lives += 1; // 1.5 개 증가시키기
            } else {
                lives += 1.5; // 1.5 개 증가시키기
            }

            if (lives > 5.0) {
                lives = 5.0; // 최대 목숨 수를 초과하지 않도록 조정
            }

            // 목숨 라벨 업데이트
            for (int i = 0; i < 5; i++) {
                if (i < lives - 0.5) { // 전체 목숨 또는 반 목숨 상태
                    lifeLabels[i].setIcon(new ImageIcon("heart1.png"));
                    lifeLabels[i].setVisible(true);
                } else if (i < lives) { // 반 목숨 상태
                    lifeLabels[i].setIcon(new ImageIcon("halfHeart.png"));
                    lifeLabels[i].setVisible(true);
                } else { // 목숨이 없는 상태
                    lifeLabels[i].setVisible(false);
                }
            }

            repaint();
        }
    }


    public boolean isGameOver() {
        return lives <= 0;
    }

    public void repaintScore() {
        scoreLabel.getParent().repaint();
    }
}
