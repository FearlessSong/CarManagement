package Frame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import DataBase.CarInforConn;
import Eneity.Car;

public class CarInfor {
	CarInforConn carInforConn;
	JFrame frame;
	JPanel panel;
	JLabel lb_carnumber;
	JTextField tf_carnumber;
	JButton jb_search;
	public CarInfor(){
		frame=new JFrame("车辆基础信息");
		panel=new JPanel();
		lb_carnumber = new JLabel("请输入车号:");
		tf_carnumber = new JTextField(15);
		jb_search = new JButton("查询");
		jb_search.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(tf_carnumber.getText()!=null)
				{
					panel.removeAll();
					panel.add(lb_carnumber);
					panel.add(tf_carnumber);
					panel.add(jb_search);
					System.out.println(tf_carnumber.getText());
					carInforConn=new CarInforConn();
					Car car=carInforConn.searchCar(tf_carnumber.getText());
					JLabel lb_company=new JLabel("客运公司："+car.getCompany()+"           "); //客运公司
					JLabel lb_route=new JLabel("车       路："+car.getRoute()+"           ");//车路
					JLabel lb_type=new JLabel("车       型："+car.getType()+"           ");//车型
					JLabel lb_engine=new JLabel("发 动 机："+car.getEngine()+"           ");//发动机
					JLabel lb_box=new JLabel("变 速 箱："+car.getBox()+"           ");//变速箱
					JLabel lb_brige=new JLabel("车       桥："+car.getBrige()+"           ");//车桥
					panel.add(lb_company);
					panel.add(lb_route);
					panel.add(lb_type);
					panel.add(lb_engine);
					panel.add(lb_box);
					panel.add(lb_brige);
					frame.setSize(320,300);
					frame.setLocationRelativeTo(null);
					frame.validate();
				}
				
			}
		});
	}
		public void go() {
		panel.add(lb_carnumber);
		panel.add(tf_carnumber);
		panel.add(jb_search);
		frame.add(panel);
		frame.setSize(500, 200);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	

}
