
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class showPhoto extends JPanel{
    JLabel pic;
    Timer tm;
    int x = 0;


    //Images Path In Array
    String[] list = {
                      "welcom_photo.jpg",//0
                      "welcom_photo2.jpg",//1
                      "welcom_photo3.jpg",//2
                    };
    
    public showPhoto(){
   //     super("Java SlideShow");
        pic = new JLabel();
        pic.setBounds(0,0,1000,700);



        //Call The Function SetImageSize
        SetImageSize(2);
        

       //set a timer
        tm = new Timer(5000,new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SetImageSize(x);
                x += 1;
                if(x >= list.length )
                    x = 0; 
            }
        });
        add(pic);
        tm.start();
        setLayout(null);
        setSize(1000, 700);
     //   getContentPane().setBackground(Color.decode("#bdb67b"));
      //  setLocationRelativeTo(null);
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    //create a function to resize the image 
    public void SetImageSize(int i){
        ImageIcon icon = new ImageIcon(getClass().getResource(list[i]));
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);
        pic.setIcon(newImc);
    }

}





////////////OUTPUT:
