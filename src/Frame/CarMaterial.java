package Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DataBase.DateConn;
import DataBase.FixConn;
import DataBase.MaterialConn;
import DataBase.ReturnConn;
import Eneity.CarCareInfo;
import Eneity.Fix;
import Eneity.Material;

public class CarMaterial {
	MaterialConn  materialConn;
	JFrame frame;
	JPanel panel;
	JLabel lb_carnumber;
	JTextField tf_carnumber;
	JButton jb_search;
	JButton jb_datesearch;
	public CarMaterial(){
		frame=new JFrame("车辆材料费");
		panel=new JPanel();
		lb_carnumber = new JLabel("请输入车号or时间:");
		tf_carnumber = new JTextField(15);
		jb_search = new JButton("车号查询");
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
					materialConn=new MaterialConn();
					Vector<Material> care=materialConn.searchCare(tf_carnumber.getText());
					//保养日期
					if(care.isEmpty())
					{
						System.out.println("没有结果");
					}
					else
					{
						System.out.println(tf_carnumber.getText());
						for(int i=0;i<care.size();i++)
						{
							JLabel lb_caredate=new JLabel("保养日期："+care.get(i).getDate()); //客运公司
							JLabel lb_fee=new JLabel("材料费："+care.get(i).getFee()); //客运公司
							panel.add(lb_caredate);
							panel.add(lb_fee);
							frame.setSize(460, 200);
							frame.validate();
						}
					}
					//修理日期 
				}
			}
		});
		jb_datesearch= new JButton("时间查询");
		jb_datesearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(tf_carnumber.getText()!=null)
				{
					panel.removeAll();
					
					panel.add(lb_carnumber);
					panel.add(tf_carnumber);
					panel.add(jb_search);
					materialConn=new MaterialConn();
					Vector<Material> care=materialConn.searchDate(tf_carnumber.getText());
					System.out.println(tf_carnumber.getText());
					for(int i=0;i<care.size();i++)
					{   
						JPanel panel1=new JPanel();
						JLabel lb_carnumber=new JLabel("车号："+care.get(i).getCarNumber());//车号
						JLabel lb_fee=new JLabel("材料费："+care.get(i).getFee());//车号
						panel1.add(lb_carnumber);
						panel1.add(lb_fee);
						panel1.setSize(500,10);
						panel.add(panel1);
						frame.validate();
					}
				}
			}
		});
	}
		public void go() {
		panel.add(lb_carnumber);
		panel.add(tf_carnumber);
		panel.add(jb_search);
		panel.add(jb_datesearch);
		frame.add(panel);
		frame.setSize(500, 200);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
	
}
