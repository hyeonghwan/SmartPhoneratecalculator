
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
//label.setOpaque(true); //Opaque값을 true로 미리 설정해 주어야 배경색이 적용된다.
//jlabel.setBackgroud(Color.pink);
import javax.swing.event.ListSelectionListener;


      

public class combo extends JFrame implements ListSelectionListener {
	 JPanel p;
     String[] label= {"통신사","제조사","구분","제품명","분류","기타"};
	 String[] mlabel=new String[36]; //{"1개월","2개월","3개월","4개월","5개월","6개월","7개월","8개월","9개월","10개월" }
     JButton b1,b2,b3,b4,b5,b6,calculation;
	 JLabel family;
	 JLabel month;
	 JLabel money;
	 JLabel contract;
	 JLabel iza;
	 JLabel stmoney;
	 JTextField stmoneytext;
	 
	 
	 
	 int index;
	// String[] wan= {"SKT","KT","LG U+"};
	 //String[] company= {"삼성전자","애플","LG"};
	// String[] samsung= {"갤럭시폴드/SM-F907N","갤럭시노트 10 5G/SM-N971N","갤럭시택S6(128GB)/SM-T865"};
	//	String[] apple= {"아이패드 7세대/iPad","아이폰11(64GB)/A221","아이폰11프로(64GB)/A2215"};
	//	String[] lg= {"V50s ThinQ/LM-v510N","Q70/LM-Q730N","X2 2019/LM-X220N"};
	// String[] nll= {"      "};
		 JList wirelist;      //통신사 리스트
		 JList comlist;       //회사 리스트
		 JList stafflist;    //제품 리스트
	     JList networklist;   //5g,lte,3g 등등 리스트
	     JList callingplanlist; //요금제 리스트
	     
	     Checkbox supportmoney,selectcontract,interest;
	     Checkbox familysale1,familysale2,familysale3,familysale4;
	     CheckboxGroup group;
	     JComboBox salemonth;
	    
	     DefaultListModel model=new DefaultListModel();
	     DefaultListModel wiremodel=new DefaultListModel();
	     DefaultListModel companymodel=new DefaultListModel();
	    // DefaultListModel callingmodel=new DefaultListModel();
	     
 	    
	    JScrollPane scroll,planscroll;
	    
	    samsung sam=new samsung();
    	apple app=new apple();
    	LG lg=new LG();
    	//appleprice aprice=new appleprice();
    	SKT wireskt=new SKT();
    	KT wirekt=new KT();
    	LG wirelg=new LG();
    	SKT_5G skt5g=new SKT_5G();
    	KT_5G kt5g=new KT_5G();
    	LG_5G lg5g=new LG_5G();
    	SKT_4G skt4g=new SKT_4G();
    	KT_4G kt4g=new KT_4G();
    	LG_4G lg4g=new LG_4G();
    	SKT_3G skt3g=new SKT_3G();
    	KT_3G kt3g=new KT_3G();
    	LG_3G lg3g=new LG_3G();
    	
	
    public combo() {
		setSize(1050,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		p =new JPanel();
		p.setLayout(null);
		  b1=new JButton(label[0]);
		  b2=new JButton(label[1]);
		  b3=new JButton(label[2]);
		  b4=new JButton(label[3]);
		  b5=new JButton(label[4]);
		  b6=new JButton(label[5]);
		
		 b1.setBounds(0,0,100,70);
		 b2.setBounds(100,0,100,70);
		 b3.setBounds(200,0,100,70);
		 b4.setBounds(300,0,200,70);
		 b5.setBounds(500,0,150,70);
		 b6.setBounds(650,0,400,70);
		 
		    b1.setBackground(new Color(255,255,0));	
		 	b2.setBackground(new Color(255,255,0));
		 	b3.setBackground(new Color(255,255,0));
		 	b4.setBackground(new Color(255,255,0));
		 	b5.setBackground(new Color(255,255,0));
		 	b6.setBackground(new Color(255,255,0));
		 
		wirelist=new JList(wiremodel);             //통신사 jlist 생성
		wiremodel=(DefaultListModel) wirelist.getModel();
		wiremodel.addElement(wireskt);
		wiremodel.addElement(wirekt);
		wiremodel.addElement(wirelg);
		 wirelist.setBounds(0,100,100,100);
		 wirelist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 wirelist.setSelectedIndex(0);
		 wirelist.addListSelectionListener(this);
		 p.add(wirelist);
		 
		 comlist=new JList(companymodel);              //제품 회사 jlist 생성
		 companymodel=(DefaultListModel) comlist.getModel();
		 companymodel.addElement(sam);
		 companymodel.addElement(app);
		 companymodel.addElement(lg);
		 comlist.setBounds(100, 100, 100, 100);
		 comlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 comlist.setSelectedIndex(0);
		comlist.addListSelectionListener(this);        // 회사를 선택했을 때 이벤트 발생하여 stafflist에 제품을 추가함
		 p.add(comlist);
		 
		    stafflist=new JList(sam.sam);
		    stafflist.setSize(200, 50);
			stafflist.setLocation(300,100); 
			stafflist.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			stafflist.addListSelectionListener(this); 
			JScrollPane scroll=new JScrollPane(stafflist);         //scrollpane에 Stafflist 추가
			
			scroll.setPreferredSize(new Dimension(200,50));
		    scroll.setSize(200,100);
			scroll.setLocation(300,100);
		
			//p.add(list);
			p.add(scroll);
			
		
			networklist=new JList(model);
			model=(DefaultListModel) networklist.getModel();
			model.addElement("5G");
			model.addElement("LTE");
			model.addElement("3G");
			networklist.setBounds(200,100,100,100);
			networklist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			networklist.addListSelectionListener(this); 
			// networklist.setSelectedIndex(0);
			p.add(networklist);
			
			callingplanlist=new JList();
			callingplanlist.setBounds(500,100,150,100);
			//p.add(callingplanlist);
			callingplanlist.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			callingplanlist.addListSelectionListener(this); 
			JScrollPane planscroll=new JScrollPane(callingplanlist);         //scrollpane에 Stafflist 추가
			planscroll.setPreferredSize(new Dimension(200,50));
			planscroll.setSize(150,100);
			planscroll.setLocation(500,100);
			//p.add(list);
			p.add(planscroll);
			
			for(int i=0; i<36; i++) {
				mlabel[i]= (i+1)+ " 개월";

			}
			
			supportmoney=new Checkbox();
			selectcontract=new Checkbox();
			interest=new Checkbox();
			salemonth=new JComboBox(mlabel);
			month=new JLabel("할부개월");
			money=new JLabel("공시지원");
			iza=new JLabel("할부이자");
			contract=new JLabel("선택약정");
			
			
			calculation=new JButton("요금계산");
			calculation.setBackground(new Color(15,223,0));
			calculation.addActionListener(e->{
					new subFrame();                  //요금 계산 버튼을 눌렀을때 새로운 프레임 생성
			}
			);
			stmoneytext=new JTextField(20);
			stmoney=new JLabel("출고가");
		    stmoney.setBounds(650, 320, 100, 100);
		    stmoneytext.setBounds(710, 350, 150, 40);
			
		  supportmoney.setBounds(770, 80, 50, 50);
		         money.setBounds(700, 80, 50, 50);
			  contract.setBounds(850, 80, 50, 50);
	   	selectcontract.setBounds(920, 80, 50, 50);
			       iza.setBounds(700, 150, 50, 50);
			  interest.setBounds(770, 150, 100, 50);
		   	 salemonth.setBounds(800, 250, 100, 80);
			     month.setBounds(700, 250, 100, 80);
		   calculation.setBounds(930, 350, 100, 50);
		 	
			p.add(money); p.add(contract); p.add(iza); p.add(calculation); p.add(stmoney); p.add(stmoneytext);
			p.add(supportmoney); p.add(selectcontract); p.add(interest); p.add(salemonth); p.add(month);
			
		 	index=wirelist.getSelectedIndex();
		 	if(index==0) {
		 		family=new JLabel("온가족할인");
		 		group=new CheckboxGroup();
		 		familysale1 =new Checkbox("0",group,false);
		 		familysale2 =new Checkbox("10",group,false);
		 		familysale3 =new Checkbox("30",group,false);
		 		familysale4 =new Checkbox("50",group,false);
		 		family.setBounds(700, 200, 100, 50);
		 		familysale1.setBounds(800, 200, 50, 50);
		 		familysale2.setBounds(850, 200, 50, 50);
		 		familysale3.setBounds(900, 200, 50, 50);
		 		familysale4.setBounds(950, 200, 50, 50);
		      
		       p.add(family);  p.add(familysale1);  p.add(familysale2);  p.add(familysale3);  p.add(familysale4);
		       
		 	}

		 p.add(b1); p.add(b2);p.add(b3);p.add(b4);p.add(b5);p.add(b6);       //분류 버튼 생성 	
	   add(p);
	   setVisible(true);
	}
public String toString(){                                     // 스마트폰에 가격을 반환하는 함수
	int index5 = comlist.getSelectedIndex();
	//  System.out.println(stafflist.getLeadSelectionIndex());
	  int index4 = stafflist.getLeadSelectionIndex();
	  if(index4==0&&index5==0) {        //삼성 제품 가격
			return "2398000";
		  }
	  if(index4==1&&index5==0) {
			return "799700";
		  }
	  if(index4==2&&index5==0) {
			return "1248500";
		  }
	  if(index4==3&&index5==0) {        
			return "1397000";
		  }
	  if(index4==0&&index5==1) {         //애플 제품 가격
		return "990000";
	  }
	  if(index4==1&&index5==1) {
			return "1056000";
		  }
	  if(index4==2&&index5==1) {
			return "1188000";
		  }
	  if(index4==3&&index5==1) {
			return "1375000";
		  }
	  if(index4==0&&index5==2) {           //엘지 제품 가격
			return "1375000";
		  }
	  if(index4==1&&index5==2) {
			return "1375000";
	  }
	  if(index4==2&&index5==2) {
			return "1375000";
		  }
	  if(index4==3&&index5==2) {
			return "1375000";
		  }
	return null;
	  
	  
	  
	}
    public void valueChanged(ListSelectionEvent e) {
    	
    	  
    	 int index1 = wirelist.getSelectedIndex();
    	 int index2 = networklist.getSelectedIndex();
    	 index=wirelist.getSelectedIndex();
    	 
    	 if(index1==0 &&index2==0) {
    		 callingplanlist.setListData(skt5g.skt5g);    		 
    	 }
    	 if(index1==0 && index2==1) {
    		 callingplanlist.setListData(skt4g.skt4g);    	
    	 }
         if(index1==0 && index2==2) {
        	 callingplanlist.setListData(skt3g.skt3g);  
    	 }
         if(index1==1 && index2==0) {
        	 callingplanlist.setListData(kt5g.kt5g);    
    	 }
         if(index1==1 && index2==1) {
        	 callingplanlist.setListData(kt4g.kt4g);
    	 }
         if(index1==1 && index2==2) {
        	 callingplanlist.setListData(kt3g.kt3g);
    	 }
         if(index1==2 && index2==0) {
        	 callingplanlist.setListData(lg5g.lg5g);   
    	 }
         if(index1==2 && index2==1) {
        	 callingplanlist.setListData(lg4g.lg4g); 
    	 }
         if(index1==2 && index2==2) {
        	 callingplanlist.setListData(lg3g.lg3g); 
    	 }

    	 
    	 
    	
    	
    
    	  int index3 = comlist.getSelectedIndex();
    	  if(index3 == 0) {
    		  stafflist.setListData(sam.sam);
    	  }
    	  if(index3 == 1) {
    		  stafflist.setListData(app.app);
    	  }
    	  if(index3 == 2) {
    		  stafflist.setListData(lg.lg);
    	  }
    	  
    	  int index5 = comlist.getSelectedIndex();
    	//  System.out.println(stafflist.getLeadSelectionIndex());             //제품 출고가를 toString 함수에서 가져옴
    	  int index4 = stafflist.getLeadSelectionIndex();
    	 // if(index4==0&&index5==0) {
    		  stmoneytext.setText(toString());
    		 // stmoneytext.getText();
    	        
    		//System.out.println("dkssud");
    		  
    	//  }
    	
    	  
    	  if(index==0) {
    		  family.setVisible(true);                 //온가족 할인 체크박스 보이기 || 숨기기
		 	   familysale1.setVisible(true);
		 	   familysale2.setVisible(true);
		 	   familysale3.setVisible(true);
		       familysale4.setVisible(true);
    	  }
    	  else {
    		  family.setVisible(false); 
		 	   familysale1.setVisible(false);
		 	   familysale2.setVisible(false);
		 	   familysale3.setVisible(false);
		       familysale4.setVisible(false);
    	  }
    	
    	  
    	  
    	  
    	
}
    
    
	class subFrame extends JFrame{
		JLabel la1,la2,la3,la4,la5,la6,la7,la8,la9,la10;  //구분 라벨
		JLabel s5Gla1,s5Gla2,s5Gla3,s5Gla4;  //요금제 라벨
		JLabel[] sellectlabel;    //약정 구분 라벨
		JLabel[] grant;       //공시지원금 라벨
		JLabel[] addgrant;      //추가 지원금 라벨
		JLabel[] installment;   //할부원금 라벨
		JLabel[] monthinstallment;   //월할부금 라벨
        JLabel[] installinterst;    //할부 이자라벨
        JLabel[] baserate;      //기본요금 라벨
        JLabel[] mdiscount;      //월요금할인 라벨
        JLabel[] mcharge;    //월청구액 라벨
        
		JPanel subp;
		
		
		
		subFrame(){
	
		setSize(1330,450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//jlabel.setOpaque(true); //Opaque값을 true로 미리 설정해 주어야 배경색이 적용된다.
		//jlabel.setBackgroud(Color.pink);
		subp=new JPanel();
		subp.setLayout(null);
		//"요금제"
		la1 =new JLabel();
		la1.setText("<html><body>a<br>요금제</body></html>");
		la1.setOpaque(true);
		la1.setBackground(Color.black);
		la1.setForeground(Color.white);
		
		
		
		la2 =new JLabel("약정 구분");
		la2.setText("<html><body> <br>약정구분</body></html>");
		la2.setOpaque(true);
		la2.setBackground(Color.black);
		la2.setForeground(Color.white);
		la3 =new JLabel("공시지원금");
		la3.setText("<html><body>b<br>공시지원금</body></html>");
		la3.setOpaque(true);
		la3.setBackground(Color.black);
		la3.setForeground(Color.white);
		la4 =new JLabel("추가지원금");
		la4.setText("<html><body>c<br>추가지원금</body></html>");
		la4.setOpaque(true);
		la4.setBackground(Color.black);
		la4.setForeground(Color.white);
		la5 =new JLabel("총 할부원금");
		la5.setText("<html><body>d=a-b-c<br>총 할부원금</body></html>");
		la5.setOpaque(true);
		la5.setBackground(Color.black);
		la5.setForeground(Color.white);
		la6 =new JLabel("월 할부금");
		la6.setText("<html><body>e=d/24<br>월 할부금</body></html>");
		la6.setOpaque(true);
		la6.setBackground(Color.black);
		la6.setForeground(Color.white);
		la7 =new JLabel("할부이자");
		la7.setText("<html><body>f<br>할부이자</body></html>");
		la7.setOpaque(true);
		la7.setBackground(Color.black);
		la7.setForeground(Color.white);
		la8 =new JLabel("월기본요금");
		la8.setText("<html><body>g<br>월기본요금</body></html>");
		la8.setOpaque(true);
		la8.setBackground(Color.black);
		la8.setForeground(Color.white);
		la9 =new JLabel("월요금할인");
		la9.setText("<html><body>h<br>월요금할인</body></html>");
		la9.setOpaque(true);
		la9.setBackground(Color.black);
		la9.setForeground(Color.white);
		la10 =new JLabel("월청구액");
		la10.setText("<html><body>e+f+g-h<br>월 청구액</body></html>");
		la10.setOpaque(true);
		la10.setBackground(Color.black);
		la10.setForeground(Color.white);
		
		
		long in_month=salemonth.getSelectedIndex();      //할부개월 추출
		in_month+=1;
		String temp_stmoney = stmoneytext.getText();   //할부원금 추출
		long  temp_installment=Long.parseLong(temp_stmoney); //할부원금 정수형으로 변환
		long m_installment=temp_installment/in_month;
		String installmenttext,m_installmentext;
		//System.out.println(temp_long);
		
		int x=130,y=35,w=129,h=35,yt=46;                                   ///
		sellectlabel=new JLabel[10];                                      // 약
		for(int i=0; i<8; i++) {                                          // 정
			 yt+=y;                                                       // 구
			sellectlabel[i]=new JLabel();                                 // 분 설정
			if((i+1)%2==1) {
			sellectlabel[i].setText("공시할인");
			}
			else {
				sellectlabel[i].setText("선택약정");
			}
			sellectlabel[i].setBorder(new LineBorder(Color.white));
			sellectlabel[i].setOpaque(true);
			sellectlabel[i].setBackground(Color.GREEN);
			sellectlabel[i].setForeground(Color.black);
			sellectlabel[i].setBounds(x, yt, w, h);
			subp.add(sellectlabel[i]);            
		}          
		x=260;y=35;w=129;h=35;yt=46;     
		grant=new JLabel[10];
		for(int i=0; i<8; i++)  {                            //  할인 액 라벨 설정              
			 yt+=y;                                                       
			 grant[i]=new JLabel();                                
			if((i+1)%2==1) {
				grant[i].setText("                               0");
			}
			else {
				grant[i].setText("                               0");
			}
			grant[i].setBorder(new LineBorder(Color.white));
			grant[i].setOpaque(true);
			grant[i].setBackground(Color.yellow);
			grant[i].setForeground(Color.black);
			grant[i].setBounds(x, yt, w, h);
			subp.add(grant[i]);            
		}  
		x=390;y=35;w=129;h=35;yt=46;     
		addgrant=new JLabel[10];
		for(int i=0; i<8; i++)  {                                       //추가 지원금 라벨 설정
			 yt+=y;                                                       
			 addgrant[i]=new JLabel();                                
			if((i+1)%2==1) {
				addgrant[i].setText("                               0");
			}
			else {
				addgrant[i].setText("                               0");
			}
			addgrant[i].setBorder(new LineBorder(Color.white));
			addgrant[i].setOpaque(true);
			addgrant[i].setBackground(Color.pink);
			addgrant[i].setForeground(Color.black);
			addgrant[i].setBounds(x, yt, w, h);
			subp.add(addgrant[i]);            
		}
		
		x=520;y=35;w=129;h=35;yt=46;     
		installment=new JLabel[10];                               //할부원금 라벨 설정
		for(int i=0; i<8; i++)  {                                     
			 yt+=y;                                                       
			 installment[i]=new JLabel();
			 installmenttext=Long.toString(temp_installment);
			if((i+1)%2==1) {
				installment[i].setText("                "+installmenttext);
			}
			else {
				installment[i].setText("                "+installmenttext);
			}
			installment[i].setBorder(new LineBorder(Color.white));
			installment[i].setOpaque(true);
			installment[i].setBackground(Color.yellow);
			installment[i].setForeground(Color.black);
			installment[i].setBounds(x, yt, w, h);
			subp.add(installment[i]);            
		}
		
		x=650;y=35;w=129;h=35;yt=46;     
		monthinstallment=new JLabel[10];                                 //월 할부원금 라벨 설정
		for(int i=0; i<8; i++)  {                                     
			 yt+=y;                                                       
			 monthinstallment[i]=new JLabel();   
			 m_installmentext=Long.toString(m_installment);
			if((i+1)%2==1) {
				
				
				monthinstallment[i].setText("             "+m_installmentext);
			}
			else {
				monthinstallment[i].setText("             "+m_installmentext);
			}
			monthinstallment[i].setBorder(new LineBorder(Color.white));
			monthinstallment[i].setOpaque(true);
			monthinstallment[i].setBackground(Color.BLUE);
			monthinstallment[i].setForeground(Color.black);
			monthinstallment[i].setBounds(x, yt, w, h);
			subp.add(monthinstallment[i]);            
		}
		x=780;y=35;w=129;h=35;yt=46;     
		installinterst=new JLabel[10];                                 //할부이자 라벨 설정
		for(int i=0; i<8; i++)  {                                     
			 yt+=y;                                                       
			 installinterst[i]=new JLabel();                                
			if((i+1)%2==1) {
				installinterst[i].setText("                               0");
			}
			else {
				installinterst[i].setText("                               0");
			}
			installinterst[i].setBorder(new LineBorder(Color.white));
			installinterst[i].setOpaque(true);
			installinterst[i].setBackground(Color.cyan);
			installinterst[i].setForeground(Color.black);
			installinterst[i].setBounds(x, yt, w, h);
			subp.add(installinterst[i]);            
		}
		x=910;y=35;w=129;h=35;yt=46;     
		baserate=new JLabel[10];                                 //기본요금 라벨 설정
		for(int i=0; i<8; i++)  {                                     
			 yt+=y;                                                       
			 baserate[i]=new JLabel();                                
			if((i+1)%2==1) {
				baserate[i].setText("                               0");
			}
			else {
				baserate[i].setText("                               0");
			}
			baserate[i].setBorder(new LineBorder(Color.white));
			baserate[i].setOpaque(true);
			baserate[i].setBackground(Color.LIGHT_GRAY);
			baserate[i].setForeground(Color.black);
			baserate[i].setBounds(x, yt, w, h);
			subp.add(baserate[i]);            
		}
		x=1040;y=35;w=129;h=35;yt=46;     
		mdiscount=new JLabel[10];                                 //월요금할인 라벨 설정
		for(int i=0; i<8; i++)  {                                     
			 yt+=y;                                                       
			 mdiscount[i]=new JLabel();                                
			if((i+1)%2==1) {
				mdiscount[i].setText("                               0");
			}
			else {
				mdiscount[i].setText("                               0");
			}
			mdiscount[i].setBorder(new LineBorder(Color.white));
			mdiscount[i].setOpaque(true);
			mdiscount[i].setBackground(Color.orange);
			mdiscount[i].setForeground(Color.black);
			mdiscount[i].setBounds(x, yt, w, h);
			subp.add(mdiscount[i]);            
		}
		x=1170;y=35;w=129;h=35;yt=46;     
		mcharge=new JLabel[10];                                 //월청구액 라벨 설정
		for(int i=0; i<8; i++)  {                                     
			 yt+=y;                                                       
			 mcharge[i]=new JLabel();                                
			if((i+1)%2==1) {
				mcharge[i].setText("                               0");
			}
			else {
				mcharge[i].setText("                               0");
			}
			mcharge[i].setBorder(new LineBorder(Color.white));
			mcharge[i].setOpaque(true);
			mcharge[i].setBackground(Color.red);
			mcharge[i].setForeground(Color.black);
			mcharge[i].setBounds(x, yt, w, h);
			subp.add(mcharge[i]);            
		}
		
		
		
		
		int windex=wirelist.getSelectedIndex();
		int cindex=callingplanlist.getLeadSelectionIndex();
		if(windex==0&&cindex==0) {
			
			s5Gla1=new JLabel();
			s5Gla1.setText("<html><body>슬림<br>데이터:9GB<br>음성:무제한</body></html>");
			s5Gla1.setBorder(new LineBorder(Color.white));
			s5Gla1.setOpaque(true);
			s5Gla1.setBackground(Color.yellow);
			s5Gla1.setForeground(Color.black);
			
			s5Gla2=new JLabel();
			s5Gla2.setText("<html><body>5GX스탠다드<br>데이터:200GB<br>음성:무제한</body></html>");
			s5Gla2.setBorder(new LineBorder(Color.white));
			s5Gla2.setOpaque(true);
			s5Gla2.setBackground(Color.yellow);
			s5Gla2.setForeground(Color.black);
			
			s5Gla3=new JLabel();
			s5Gla3.setText("<html><body>5GX프라임<br>데이터:무제한<br>음성:무제한</body></html>");
	        s5Gla3.setBorder(new LineBorder(Color.white));
			s5Gla3.setOpaque(true);
			s5Gla3.setBackground(Color.yellow);
			s5Gla3.setForeground(Color.black);
			
			s5Gla4=new JLabel();
			s5Gla4.setText("<html><body>5GX플래티넘<br>데이터:무제한<br>음성:무제한</body></html>");
			s5Gla4.setBorder(new LineBorder(Color.white));
			s5Gla4.setOpaque(true);
			s5Gla4.setBackground(Color.yellow);
			s5Gla4.setForeground(Color.black);
			
			s5Gla1.setBounds(0, 81, 129, 70);
            s5Gla2.setBounds(0, 152, 129, 70);
            s5Gla3.setBounds(0, 223, 129, 70);
            s5Gla4.setBounds(0, 294, 129, 70);
            subp.add(s5Gla1);subp.add(s5Gla2);subp.add(s5Gla3);subp.add(s5Gla4);
			
			
		}
		
		
		
		
		
		
		
		
		la1.setBounds(0, 0, 129, 80);
		la2.setBounds(130, 0, 129, 80);
		la3.setBounds(260, 0, 129, 80);
		la4.setBounds(390, 0, 129, 80);
		la5.setBounds(520, 0, 129, 80);
		la6.setBounds(650, 0, 129, 80);
		la7.setBounds(780, 0, 129, 80);
		la8.setBounds(910, 0, 129, 80);
		la9.setBounds(1040, 0, 129, 80);
		la10.setBounds(1170, 0, 129, 80);
		
		
		
		
		subp.add(la1);subp.add(la2);subp.add(la3);subp.add(la4);
		subp.add(la5);subp.add(la6);subp.add(la7);subp.add(la8);
		subp.add(la9);subp.add(la10);
		add(subp);
		setVisible(true);
		
		
		}
		
	}
    	
	
	
	
    public static void main(String args[]) {
		
		new combo();
		
	
		
	}
	
	
	

}
