package Frame;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import DataBase.LoginConn;

public class Login extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	LoginConn conn=new LoginConn();
	JButton login = new JButton("��¼");
	JButton exit = new JButton("�˳�");
	JLabel  name = new JLabel("�û�����");
	JLabel password = new JLabel("���룺"); 
	JTextField JName = new JTextField(10); //�����˺�����
	JPasswordField JPassword = new JPasswordField(10); // �������������룻
	
	public Login() 
	{
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(3,2));  //3��2�е����jp�����񲼾֣�
		
		name.setHorizontalAlignment(SwingConstants.RIGHT);  //���ø�����Ķ��뷽ʽΪ���Ҷ���
		password.setHorizontalAlignment(SwingConstants.RIGHT);
		
		jp.add(name);   //�����ݼӵ����jp��
		jp.add(JName);  
		jp.add(password);
		jp.add(JPassword);  
		jp.add(login);
		jp.add(exit);
		
		login.addActionListener(this); //��¼�����¼�����
		exit.addActionListener(this);	//�˳������¼�����
		
		this.add(jp,BorderLayout.CENTER);	//��������嶨�����м�
		
		this.setTitle("��¼����");
		this.setLocationRelativeTo(null);
		this.pack();  		//��ʾ��������Զ�������С
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e)  // ��ʱ����д���
	{
		String sql;
		if(e.getSource() == exit)
		{
			int i = JOptionPane.showConfirmDialog(null,"ȷ��Ҫ�˳���", "ȷ��", JOptionPane.YES_NO_OPTION);
			// ��ʾѡ��Ի���
			if(i == JOptionPane.YES_OPTION);
			System.exit(0);
		}
		else
		{
			sql="SELECT password FROM login.user where username='"+JName.getText()+"';";
			if(String.valueOf(JPassword.getPassword()).equals(conn.searchpassword(sql)))
			{
				JOptionPane.showMessageDialog(null, "��¼�ɹ�����ӭ������");
				//��ʾ��Ϣ��ʾ��
				this.setVisible(false);
				MenuFrame frame=new MenuFrame();
		        frame.go();
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "�û���������������µ�¼��");
				//��ʾ��Ϣ��ʾ��
				JName.setText(""); 
				JPassword.setText("");
			}
		}
	}
}
	