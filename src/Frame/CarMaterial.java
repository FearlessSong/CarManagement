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
		frame=new JFrame("�������Ϸ�");
		panel=new JPanel();
		lb_carnumber = new JLabel("�����복��orʱ��:");
		tf_carnumber = new JTextField(15);
		jb_search = new JButton("���Ų�ѯ");
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
					//��������
					if(care.isEmpty())
					{
						System.out.println("û�н��");
					}
					else
					{
						System.out.println(tf_carnumber.getText());
						for(int i=0;i<care.size();i++)
						{
							JLabel lb_caredate=new JLabel("�������ڣ�"+care.get(i).getDate()); //���˹�˾
							JLabel lb_fee=new JLabel("���Ϸѣ�"+care.get(i).getFee()); //���˹�˾
							panel.add(lb_caredate);
							panel.add(lb_fee);
							frame.setSize(460, 200);
							frame.validate();
						}
					}
					//�������� 
				}
			}
		});
		jb_datesearch= new JButton("ʱ���ѯ");
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
						JLabel lb_carnumber=new JLabel("���ţ�"+care.get(i).getCarNumber());//����
						JLabel lb_fee=new JLabel("���Ϸѣ�"+care.get(i).getFee());//����
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
