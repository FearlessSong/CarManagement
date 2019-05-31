package Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DataBase.FixConn;
import Eneity.Fix;

public class CarFix {
	FixConn returnConn;
	JFrame frame;
	JPanel panel;
	JLabel lb_carnumber;
	JTextField tf_carnumber;
	JButton jb_search;
	public CarFix(){
		frame=new JFrame("车辆小修信息");
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
					returnConn=new FixConn();
					Vector<Fix> care=returnConn.searchCarCare(tf_carnumber.getText());
					if(care.isEmpty())
					{
						System.out.println("没有结果");
					}
					else
					{
						System.out.println(tf_carnumber.getText());
						for(int i=0;i<care.size();i++)
						{
							JLabel lb_fixdate=new JLabel("保养日期："+care.get(i).getFixDate()); //客运公司
							JLabel lb_worker=new JLabel("工作人："+care.get(i).getWorker());//车路
							JLabel lb_tester=new JLabel("检验员："+care.get(i).getTester());//车型
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
		frame.add(panel);
		frame.setSize(500, 200);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
}
