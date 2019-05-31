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
		frame=new JFrame("����С����Ϣ");
		panel=new JPanel();
		lb_carnumber = new JLabel("�����복��:");
		tf_carnumber = new JTextField(15);
		jb_search = new JButton("��ѯ");
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
						System.out.println("û�н��");
					}
					else
					{
						System.out.println(tf_carnumber.getText());
						for(int i=0;i<care.size();i++)
						{
							JLabel lb_fixdate=new JLabel("�������ڣ�"+care.get(i).getFixDate()); //���˹�˾
							JLabel lb_worker=new JLabel("�����ˣ�"+care.get(i).getWorker());//��·
							JLabel lb_tester=new JLabel("����Ա��"+care.get(i).getTester());//����
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
