

import java.awt.Dimension;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class test extends JFrame{
	String []str= {"HTML","xMl","c","c+","java","oracle","�����ó�Ʈ","�����ó�Ʈ10","������s10","�����ó�Ʈ","�����ó�Ʈ10","������s10","HTML","xMl","c","c+","java","oracle","�����ó�Ʈ","�����ó�Ʈ10","������s10","�����ó�Ʈ","�����ó�Ʈ10","������s10"};
	String []str1 = {"�����ó�Ʈ","�����ó�Ʈ10","������s10"};
	String []str2 = {"iphon10","iphoneXR","iPhoneXS"};
	String []str3 = {"lg10","lgxnote10","lgman"};
	
	Vector vec;
	JList list;
   JPanel p;
	public test() {
		p=new JPanel();
		p.setLayout(null);
		
		vec=new Vector();
		samsung s=new samsung(); //�Ｚ Ŭ�������� ���ͷ� ����Ʈ���� �߰� �� �Ｚ ��ü ����
		list=new JList();//jlist ��ü ����
	    
		//for(int i=0; i<str.length; i++) //vector�� ��� �߰�
			//vec.addElement(str[i]);
		//list.setListData(new samsung()); //jlist ������Ʈ�� �������� �߰��Ѵ�
		
		list.setListData(s.sam);
		
		list.setSelectedIndex(0); //����Ʈ ������Ʈ�� ù��° �׸��� ���õǵ��� �Ѵ�
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
