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
		frame=new JFrame("����������Ϣ");
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
					returnConn=new ReturnConn();
					@SuppressWarnings("unchecked")
					Vector<String> care=returnConn.searchCare(tf_carnumber.getText());
					@SuppressWarnings("unchecked")
					Vector<String> fix=returnConn.searchFix(tf_carnumber.getText());
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
							JLabel lb_caredate=new JLabel("�������ڣ�"+care.get(i)); //���˹�˾
							panel.add(lb_caredate);
							frame.setSize(460, 200);
							frame.validate();
						}
					}
					//��������
					if(fix.isEmpty())
					{
						System.out.println("û�н��");
					}
					else
					{
						System.out.println(tf_carnumber.getText());
						for(int i=0;i<fix.size();i++)
						{
							JLabel lb_fixdate=new JLabel("С�����ڣ�"+care.get(i)); //���˹�˾
							panel.add(lb_fixdate);
							frame.setSize(460, 200);
							frame.validate();
						}
					}
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
					dateconn=new DateConn();
					@SuppressWarnings("unchecked")
					Vector<CarCareInfo> care=dateconn.searchCare(tf_carnumber.getText());
					System.out.println(tf_carnumber.getText());
					for(int i=0;i<care.size();i++)
					{
						JLabel lb_carnumber=new JLabel("���ţ�"+care.get(i).getCarNumber());//����
						JLabel lb_caredate=new JLabel("�������ڣ�"+care.get(i).getCareDate()); //���˹�˾
						JLabel lb_worker=new JLabel("�����ˣ�"+care.get(i).getWorker());//��·
						JLabel lb_tester=new JLabel("����Ա��"+care.get(i).getTester());//����
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
						System.out.println("û�н��");
					}
					else
					{
						System.out.println(tf_carnumber.getText());
						for(int i=0;i<fix.size();i++)
						{
							JLabel lb_carnumber=new JLabel("���ţ�"+fix.get(i).getCarNumber());//����
							JLabel lb_fixdate=new JLabel("С�����ڣ�"+fix.get(i).getFixDate()); //���˹�˾
							JLabel lb_worker=new JLabel("�����ˣ�"+fix.get(i).getWorker());//��·
							JLabel lb_tester=new JLabel("����Ա��"+fix.get(i).getTester());//����
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
