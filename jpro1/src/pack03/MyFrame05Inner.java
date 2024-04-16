package pack03;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame05Inner extends Frame {
	private Wevent event = new Wevent();
	int x, y; // mouseClicked 에서 발생한 x, y 좌표를 기억

	private String names[] = { "가", "나", "다", "라", "마" };

	public MyFrame05Inner() {
		setTitle("내부 클래스"); // super.

		setSize(300, 250); // super.
		setLocation(200, 200); // super.
		setVisible(true); // super.

		addWindowListener(event); // super.
//		addWindowListener(new Wevent()); // 가능 (이렇게 사용할 경우 위 선언도 필요없음)

		addMouseListener(new Mevent());
	}

	// WindowListener 를 상속받은 WindowAdapter 를 상속하는 내부 클래스를 생성하여 운영
	class Wevent extends WindowAdapter { // 내부 클래스
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}

	class Mevent extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
//			setTitle("클릭");
//			int x = e.getX(); // 지역 변수에 값을 치환한 것
//			int y = e.getY();

			x = e.getX(); // 멤버필드에 값을 치환한 것
			y = e.getY();
			setTitle("x: " + x + ", y : " + y);

			paint(getGraphics()); // 자동으로 호출되는 paint()를 명시적으로 호출
			repaint(); // Graphics 객체를 가진 paint() 를 호출
		}
	}

	@Override
	public void paint(Graphics g) { // 자동 호출 (기본)
		// Graphics : Frame 이 제공하는 그림 그리기 객체
		g.setFont(new Font("굴림", Font.BOLD, (int) (Math.random() * 50 + 8)));
		int n = (int) (Math.random() * 5);
		g.drawString(names[n], x, y);
	}

	public static void main(String[] args) {
		new MyFrame05Inner();
	}
}