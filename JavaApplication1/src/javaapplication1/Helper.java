/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;
import java.awt.Image;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Blob;
import java.io.*;

import java.sql.Connection;
import javax.imageio.ImageIO;

import javax.swing.ImageIcon;

/**
 *
 * @author abushahmaansari
 */
public class Helper {
    public static ImageIcon getImageIconById(int id, Connection con)
    {
        ImageIcon icon = null;

        try{
            
            String query = "select pic from images where id=?";
            PreparedStatement pstmt =  con.prepareStatement(query);
            
            pstmt.setInt(1, id);
            
            ResultSet set = pstmt.executeQuery();
            
            if (set.next()) {
                Blob b = set.getBlob("pic");
                InputStream is = b.getBinaryStream();
                
                Image image = ImageIO.read(is);
                
                icon = new ImageIcon(image);
            }
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        
        return icon;
    }
    
}
