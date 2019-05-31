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
import DataBase.ReturnConn;
import Eneity.CarCareInfo;
import Eneity.Fix;

public class CarReturn {
	ReturnConn returnConn;
	DateConn dateconn;
	JFrame frame;
	JPanel panel;
	JLabel lb_carnumber;
	JTextField tf_carnumber;
	JButton jb_search;
	JButton jb_datesearch;
	public CarReturn(){
		frame=new JFrame("车辆返修信息");
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
					returnConn=new ReturnConn();
					@SuppressWarnings("unchecked")
					Vector<String> care=returnConn.searchCare(tf_carnumber.getText());
					@SuppressWarnings("unchecked")
					Vector<String> fix=returnConn.searchFix(tf_carnumber.getText());
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
							JLabel lb_caredate=new JLabel("保养日期："+care.get(i)); //客运公司
							panel.add(lb_caredate);
							frame.setSize(460, 200);
							frame.validate();
						}
					}
					//修理日期
					if(fix.isEmpty())
					{
						System.out.println("没有结果");
					}
					else
					{
						System.out.println(tf_carnumber.getText());
						for(int i=0;i<fix.size();i++)
						{
							JLabel lb_fixdate=new JLabel("小修日期："+care.get(i)); //客运公司
							panel.add(lb_fixdate);
							frame.setSize(460, 200);
							frame.validate();
						}
					}
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
					dateconn=new DateConn();
					@SuppressWarnings("unchecked")
					Vector<CarCareInfo> care=dateconn.searchCare(tf_carnumber.getText());
					System.out.println(tf_carnumber.getText());
					for(int i=0;i<care.size();i++)
					{
						JLabel lb_carnumber=new JLabel("车号："+care.get(i).getCarNumber());//车号
						JLabel lb_caredate=new JLabel("保养日期："+care.get(i).getCareDate()); //客运公司
						JLabel lb_worker=new JLabel("工作人："+care.get(i).getWorker());//车路
						JLabel lb_tester=new JLabel("检验员："+care.get(i).getTester());//车型
						panel.add(lb_carnumber);
						panel.add(lb_caredate);
						panel.add(lb_worker);
						panel.add(lb_tester);
						frame.validate();
					}
					@SuppressWarnings("unchecked")
					Vector<Fix> fix=dateconn.searchFix(tf_carnumber.getText());
					if(fix.isEmpty())
					{
						System.out.println("没有结果");
					}
					else
					{
						System.out.println(tf_carnumber.getText());
						for(int i=0;i<fix.size();i++)
						{
							JLabel lb_carnumber=new JLabel("车号："+fix.get(i).getCarNumber());//车型
							JLabel lb_fixdate=new JLabel("小修日期："+fix.get(i).getFixDate()); //客运公司
							JLabel lb_worker=new JLabel("工作人："+fix.get(i).getWorker());//车路
							JLabel lb_tester=new JLabel("检验员："+fix.get(i).getTester());//车型
							panel.add(lb_carnumber);
							panel.add(lb_fixdate);
							panel.add(lb_worker);
							panel.add(lb_tester);
							frame.validate();
						}
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
