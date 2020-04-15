package medea.gui;
import java.awt.*;

public class ImagePanel extends Panel {
  Image image;
  int   imageLenght;
  int   imageWidth;

  public ImagePanel(String imageFile, int imageWidth, int imageLenght) {
       image = this.getToolkit().getImage(imageFile); 
       this.imageLenght = imageLenght;
       this.imageWidth = imageWidth;  
  }
  
 public void paint (Graphics g){
      g.drawImage(image, 0,0, imageWidth, imageLenght, this);  
 }

}
