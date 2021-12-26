

import java.awt.Dimension;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class test extends JFrame{
	String []str= {"HTML","xMl","c","c+","java","oracle","갤럭시노트","갤럭시노트10","갤럭시s10","갤럭시노트","갤럭시노트10","갤럭시s10","HTML","xMl","c","c+","java","oracle","갤럭시노트","갤럭시노트10","갤럭시s10","갤럭시노트","갤럭시노트10","갤럭시s10"};
	String []str1 = {"갤럭시노트","갤럭시노트10","갤럭시s10"};
	String []str2 = {"iphon10","iphoneXR","iPhoneXS"};
	String []str3 = {"lg10","lgxnote10","lgman"};
	
	Vector vec;
	JList list;
   JPanel p;
	public test() {
		p=new JPanel();
		p.setLayout(null);
		
		vec=new Vector();
		samsung s=new samsung(); //삼성 클래스에서 백터로 스마트폰을 추가 후 삼성 객체 생성
		list=new JList();//jlist 객체 생성
	    
		//for(int i=0; i<str.length; i++) //vector에 요소 추가
			//vec.addElement(str[i]);
		//list.setListData(new samsung()); //jlist 컴포넌트에 아이템을 추가한다
		
		list.setListData(s.sam);
		
		list.setSelectedIndex(0); //리스트 컴포넌트의 첫번째 항목이 선택되도록 한다
		list.setSize(200, 50);
		list.setLocation(500,500);
		
		JScrollPane scroll=new JScrollPane(list);
		scroll.setPreferredSize(new Dimension(200,50));
	    scroll.setSize(300,100);
		scroll.setLocation(700,500);
		//p.add(list);
		p.add(scroll);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(2000,1500);
		setVisible(true);
		add(p);
		
	}
	
	
}
