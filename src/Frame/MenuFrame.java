package Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuFrame {
	JFrame panel;
	JPanel frame;
	JButton CarInfor;
	JButton CarCare;
	JButton CarFix;
	JButton CarReturn;
	JButton CarMaterial;
	JButton ChangeUser;
	JButton destroyAccount;
	JButton exit;
	public MenuFrame(){
		panel=new JFrame("���������ۺϹ���ƽ̨");
		frame=new JPanel();
		CarInfor=new JButton("����������Ϣ");
		CarCare=new JButton("����������Ϣ");
		CarFix=new JButton("����С����Ϣ");
		CarReturn=new JButton("��������");
		CarMaterial=new JButton("�������Ϸ�");
		ChangeUser=new JButton("�����û�");
		exit=new JButton("�˳�");		
		
		//��ť��Ӧ�¼�
            CarInfor.addActionListener(new ActionListener() {  //����������Ϣ  CarInfor
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CarInfor carinfor = new CarInfor();
				carinfor.go();
			}
            });
            CarCare.addActionListener(new ActionListener() {   //����������Ϣ   CarCare
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				// TODO Auto-generated method stub
    				CarCare carcare = new CarCare();
    				carcare.go();
    			}
                });
            CarFix.addActionListener(new ActionListener() {   //����С����Ϣ   CarFix
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				// TODO Auto-generated method stub
    				CarFix carfix=new CarFix();
    				carfix.go();
    			}
                });
            CarReturn.addActionListener(new ActionListener() {   //��������   CarReturn
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				// TODO Auto-generated method stub
    				CarReturn carreturn = new CarReturn();
    				carreturn.go();
    			}
                });
            CarMaterial.addActionListener(new ActionListener() {  //�������Ϸ�   CarMaterial
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				// TODO Auto-generated method stub
    				CarMaterial carmaterial = new CarMaterial();
    				carmaterial.go();
    			}
                });
            ChangeUser.addActionListener(new ActionListener() {  //�����û�  ChangeUser
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				// TODO Auto-generated method stub
    				panel.setVisible(false);
    				new Login();
    			}
                });
            exit.addActionListener(new ActionListener() {  //�˳� exit
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				// TODO Auto-generated method stub
    				System.exit(0);
    			}
                });
}
	public void go() {
		frame.add(CarInfor);
		frame.add(CarCare);
		frame.add(CarFix);
		frame.add(CarReturn);
		frame.add(CarMaterial);
		frame.add(ChangeUser);
		frame.add(exit);
		panel.add(frame);
		frame.setLocation(500,300);	//���ó�ʼλ��
		panel.setSize(600, 150);
		panel.setVisible(true);
		panel.setLocationRelativeTo(null);
	}
	
}


