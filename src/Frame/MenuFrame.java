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
		panel=new JFrame("车辆技术综合管理平台");
		frame=new JPanel();
		CarInfor=new JButton("车辆基础信息");
		CarCare=new JButton("车辆保养信息");
		CarFix=new JButton("车辆小修信息");
		CarReturn=new JButton("车辆返修");
		CarMaterial=new JButton("车辆材料费");
		ChangeUser=new JButton("更改用户");
		exit=new JButton("退出");		
		
		//按钮响应事件
            CarInfor.addActionListener(new ActionListener() {  //车辆基础信息  CarInfor
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CarInfor carinfor = new CarInfor();
				carinfor.go();
			}
            });
            CarCare.addActionListener(new ActionListener() {   //车辆保养信息   CarCare
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				// TODO Auto-generated method stub
    				CarCare carcare = new CarCare();
    				carcare.go();
    			}
                });
            CarFix.addActionListener(new ActionListener() {   //车辆小修信息   CarFix
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				// TODO Auto-generated method stub
    				CarFix carfix=new CarFix();
    				carfix.go();
    			}
                });
            CarReturn.addActionListener(new ActionListener() {   //车辆返修   CarReturn
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				// TODO Auto-generated method stub
    				CarReturn carreturn = new CarReturn();
    				carreturn.go();
    			}
                });
            CarMaterial.addActionListener(new ActionListener() {  //车辆材料费   CarMaterial
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				// TODO Auto-generated method stub
    				CarMaterial carmaterial = new CarMaterial();
    				carmaterial.go();
    			}
                });
            ChangeUser.addActionListener(new ActionListener() {  //更改用户  ChangeUser
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				// TODO Auto-generated method stub
    				panel.setVisible(false);
    				new Login();
    			}
                });
            exit.addActionListener(new ActionListener() {  //退出 exit
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
		frame.setLocation(500,300);	//设置初始位置
		panel.setSize(600, 150);
		panel.setVisible(true);
		panel.setLocationRelativeTo(null);
	}
	
}


