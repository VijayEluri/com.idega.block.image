package com.idega.block.image.data;

import java.sql.SQLException;
import com.idega.core.data.ICFile;
//import com.idega.data.BlobWrapper;


public class ImageEntity extends ICFile{
  public ImageEntity(){
    super();
  }

  public ImageEntity(int id)throws SQLException{
    super(id);
  }

  public void insertStartData()throws Exception{
    ImageEntity image = new ImageEntity();
    image.setName("Default no image");
    image.insert();
  }


  public void setDefaultValues() {
    super.setCreationDate(new com.idega.util.idegaTimestamp().getTimestampRightNow());
  }

  public String getImageLink(){
    return (String) this.getMetaData("image_link");
  }

  public String getLink(){
    return getImageLink();
  }

  public void setImageLink(String imageLink){
    this.setMetaData("image_link", imageLink);
  }

  public String getWidth(){
    return (String) this.getMetaData("width");
  }

  public String getHeight(){
    return (String) this.getMetaData("height");
  }

  public void setWidth(String imageWidth){
    this.setMetaData("width", imageWidth);
  }

  public void setHeight(String imageHeight){
    this.setMetaData("height", imageHeight);
  }

  public String getImageLinkOwner(){
    return (String) this.getMetaData("image_link_owner");
  }

  /*
  * possible option image/text/both/none
  */
  public void setImageLinkOwner(String imageLinkOwner){
    this.setMetaData("image_link_owner", imageLinkOwner);
  }

  public int getParentId() {
    ImageEntity parent = (ImageEntity) this.getParentNode();
    if( parent == null ) return -1;
    else return parent.getNodeID();
  }

}
