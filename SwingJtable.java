      
    
 import java.awt.event.ActionEvent;
import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.ResultSet;
 import java.sql.Statement;
 import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
 import javax.swing.table.TableModel;
 public class SwingJtable extends javax.swing.JFrame {

 
	 private javax.swing.JButton jButton_Delete;
	    private javax.swing.JButton jButton_Insert;
	    private javax.swing.JButton jButton_Update;
	    private javax.swing.JButton jButton_Exit;

	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JLabel jLabel4;
	    private javax.swing.JLabel jLabel5;
	    private javax.swing.JLabel jLabel6;
	    private javax.swing.JLabel jLabel7;
	    private javax.swing.JLabel jLabel8;
	    private javax.swing.JLabel jLabel9;
	 
		
	    private javax.swing.JPanel jPanel1;
	    private javax.swing.JScrollPane jScrollPane1;
	    private javax.swing.JTable jTable_Display_Users;
	    private javax.swing.JTextField jTextField_Flight_Id;
		private javax.swing.JTextField jTextField_Flight_Name;
		private javax.swing.JTextField jTextField_Source;
		private javax.swing.JTextField jTextField_Departure;
		private javax.swing.JTextField jTextField_Destination;
		private javax.swing.JTextField jTextField_Arrived_Time;
		private javax.swing.JTextField jTextField_Flight_Charges;
		private javax.swing.JTextField jTextField_Flight_Class;
		private javax.swing.JTextField jTextField_Seats;
	
		
	 
     public SwingJtable() {
         initComponents();
         Show_Users_In_JTable();
     }
     
      // get the connection
    public Connection getConnection()
    {
        Connection con;
        try {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
            return con;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
         

  // get a list of users from mysql database
    public ArrayList<User1> getUsersList()
    {
        ArrayList<User1> usersList = new ArrayList<User1>();
        Connection connection = getConnection();
        
        String query = "SELECT * FROM  User1 ";
        Statement st;
        ResultSet rs;
        
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            User1 user;
            while(rs.next())
            {
                user = new User1(rs.getString("Flight_Id"),rs.getString("Flight_Name"),rs.getString("Source"),rs.getString("Departure"),rs.getString("Destination"),rs.getString("Arrived_Time"),rs.getString("Flight_Class"),rs.getString("Flight_Charges"),rs.getString("Seats"));
                usersList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usersList;
    }
   
 
    public void Show_Users_In_JTable()
    {
        ArrayList<User1> list = getUsersList();
        DefaultTableModel model = (DefaultTableModel)jTable_Display_Users.getModel();
        Object[] row = new Object[9];
        for(int i = 0; i < list.size(); i++)
        {
            row[0] = list.get(i).getFlight_id();       //.getFlight_ID();
            row[1] = list.get(i).getFlight_name();
            row[2] = list.get(i).getSource();
            row[3] = list.get(i).getDeparture();
            row[4] = list.get(i).getDestination();
            row[5] = list.get(i).getArrived_Time();
            row[6] = list.get(i).getFlight_class();
            row[7] = list.get(i).getFlight_charges();
            row[8] = list.get(i).getSeats();


            
            
            model.addRow(row);
        }
     }
         
    // Execute The Insert Update And Delete Querys
    public void executeSQlQuery(String query, String message)
    {
        Connection con = getConnection();
        Statement st;
        try{
            st = con.createStatement();
            if((st.executeUpdate(query)) == 1)
            {
                // refresh jtable data
                DefaultTableModel model = (DefaultTableModel)jTable_Display_Users.getModel();
                model.setRowCount(0);
                Show_Users_In_JTable();
                
                JOptionPane.showMessageDialog(null, "Data "+message+" Succefully");
            }else{
                JOptionPane.showMessageDialog(null, "Data Not "+message);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
     /**
      * This method is called from within the constructor to initialize the form.
      * WARNING: Do NOT modify this code. The content of this method is always
      * regenerated by the Form Editor.
      */
     @SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
     private void initComponents() {

         jPanel1 = new javax.swing.JPanel();
         jLabel1 = new javax.swing.JLabel();
         jLabel2 = new javax.swing.JLabel();
         jLabel3 = new javax.swing.JLabel();
         jLabel4 = new javax.swing.JLabel();
         jLabel5 = new javax.swing.JLabel();
         jLabel6 = new javax.swing.JLabel();
         jLabel7 = new javax.swing.JLabel();
         jLabel8 = new javax.swing.JLabel();
         jLabel9 = new javax.swing.JLabel();
         jTextField_Flight_Id = new javax.swing.JTextField();
         jTextField_Flight_Name = new javax.swing.JTextField();
         jTextField_Source = new javax.swing.JTextField();
         jTextField_Departure = new javax.swing.JTextField();
         jTextField_Destination = new javax.swing.JTextField();
         jTextField_Arrived_Time = new javax.swing.JTextField();
         jTextField_Flight_Class = new javax.swing.JTextField();
         jTextField_Flight_Charges= new javax.swing.JTextField();
         jTextField_Seats = new javax.swing.JTextField();        
         jScrollPane1 = new javax.swing.JScrollPane();
         jTable_Display_Users = new javax.swing.JTable();
         jButton_Insert = new javax.swing.JButton();
         jButton_Update = new javax.swing.JButton();
         jButton_Delete = new javax.swing.JButton();
         jButton_Exit = new javax.swing.JButton();

         setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

         jPanel1.setBackground(new java.awt.Color(204, 204, 204));

         jLabel1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
         jLabel1.setText("Flight_Id:");

         jLabel2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
         jLabel2.setText("Flight_Name:");

         jLabel3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
         jLabel3.setText("Source:");

         jLabel4.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
         jLabel4.setText("Departure:");
         
         jLabel5.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
         jLabel5.setText("Destination:");
         
         jLabel6.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
         jLabel6.setText("Arrived_Time:");
         
         jLabel7.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
         jLabel7.setText("Flight_Class:");
         
         jLabel8.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
         jLabel8.setText("Flight_Charges:");
         
         jLabel9.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
         jLabel9.setText("Seats:");


         jTextField_Flight_Id.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

         jTextField_Flight_Name.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
         jTextField_Flight_Name.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 jTextField_Flight_NameActionPerformed(evt);
             }
         });

         jTextField_Source.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
         jTextField_Source.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 jTextField_SourceActionPerformed(evt);
             }
         });

         jTextField_Departure.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
         jTextField_Departure.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 jTextField_DepartureActionPerformed(evt);
             }
         });
         jTextField_Destination.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
         jTextField_Destination.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 jTextField_DestinationActionPerformed(evt);
             }
         });
         jTextField_Arrived_Time.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
         jTextField_Arrived_Time.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 jTextFieldArrived_TimeActionPerformed(evt);
                 
             }

			//private void jTextField_Arrived_TimeActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				
			//}
         });
         
         jTextField_Flight_Class.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
         jTextField_Flight_Class.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 jTextField_Flight_ClassActionPerformed(evt);
             }
         });
         
         jTextField_Flight_Charges.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
         jTextField_Flight_Charges.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 jTextField_Flight_ChargesActionPerformed(evt);
             }
         });
         jTextField_Seats.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
         jTextField_Seats.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 jTextField_SeatsActionPerformed(evt);
             }
         });
         jTable_Display_Users.setModel(new javax.swing.table.DefaultTableModel(
             new Object [][] {

             },
             new String [] {
                 "Flight_Id", "Flight_Name", "Source", "Departure","Destination","Arrived_Time","Flight_Class","Flight_Charges","Seats"
             }
         ));
         jTable_Display_Users.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseClicked(java.awt.event.MouseEvent evt) {
                 jTable_Display_UsersMouseClicked(evt);
             }
         });
         jScrollPane1.setViewportView(jTable_Display_Users);

         jButton_Insert.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        // jButton_Insert.setIcon(new javax.swing.ImageIcon(getClass().getResource("K:/talentsculptors/Imgs/apple.jpeg"))); // NOI18N
         jButton_Insert.setText("Insert");
         jButton_Insert.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 jButton_InsertActionPerformed(evt);
             }
         });

         jButton_Update.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        // jButton_Update.setIcon(new javax.swing.ImageIcon(getClass().getResource("K:/talentsculptors/Imgs/apple.jpeg"))); // NOI18N
         jButton_Update.setText("Update");
         jButton_Update.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 jButton_UpdateActionPerformed(evt);
             }
         });

         jButton_Delete.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
         //jButton_Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("K:/talentsculptors/Imgs/apple.jpeg"))); // NOI18N
         jButton_Delete.setText("Delete");
         jButton_Delete.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 jButton_DeleteActionPerformed(evt);
             }
         });
         jButton_Exit.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
         //jButton_Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("K:/talentsculptors/Imgs/apple.jpeg"))); // NOI18N
         jButton_Exit.setText("Exit");
         jButton_Exit.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
            	 MenuTable mt= new MenuTable();
           	  mt.setVisible(true);
           	  dispose();
                
            	 
                 jButton_ExitActionPerformed(evt);
             }
         });

         javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
         jPanel1.setLayout(jPanel1Layout);
         jPanel1Layout.setHorizontalGroup(
             jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(jPanel1Layout.createSequentialGroup()
                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel1Layout.createSequentialGroup()
                         .addGap(33, 33, 33)
                         .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                             .addGroup(jPanel1Layout.createSequentialGroup()
                                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                		 .addComponent(jLabel9)
                                		 .addComponent(jLabel8)
                                		 .addComponent(jLabel7)
                                		 .addComponent(jLabel6)
                                     .addComponent(jLabel5))
                                 .addGap(12, 12, 12))
                             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                     .addComponent(jLabel4)
                                     .addComponent(jLabel3)
                                 .addComponent(jLabel2)
                                 .addComponent(jLabel1))
                                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                         .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                             .addComponent(jTextField_Flight_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                             .addComponent(jTextField_Flight_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                             .addComponent(jTextField_Source, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                             .addComponent(jTextField_Departure, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                             .addComponent(jTextField_Destination, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                             .addComponent(jTextField_Arrived_Time, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                             .addComponent(jTextField_Flight_Class, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                             .addComponent(jTextField_Flight_Charges, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                             .addComponent(jTextField_Seats, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                     .addGroup(jPanel1Layout.createSequentialGroup()
                         .addContainerGap()
                         .addComponent(jButton_Insert)
                         .addGap(18, 18, 18)
                         .addComponent(jButton_Update)
                         .addGap(18, 18, 18)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                         .addComponent(jButton_Delete)
                         .addGap(18, 18, 18)
                         .addComponent(jButton_Exit)

                         ))
                 .addGap(18, 18, 18)

                 .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addContainerGap())
         );
         jPanel1Layout.setVerticalGroup(
             jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(jPanel1Layout.createSequentialGroup()
                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel1Layout.createSequentialGroup()
                         .addGap(36, 36, 36)
                         .addComponent(jLabel1))
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                         .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addComponent(jTextField_Flight_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                 .addGap(18, 18, 18)
                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(jLabel2)
                     .addComponent(jTextField_Flight_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addGap(18, 18, 18)
                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(jLabel3)
                     .addComponent(jTextField_Source, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(jLabel4)
                     .addComponent(jTextField_Departure, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addGap(18, 18, 18)
                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel5)
                         .addComponent(jTextField_Destination, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addGap(18, 18, 18)

                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel6)
                         .addComponent(jTextField_Arrived_Time, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addGap(18, 18, 18)

                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel7)
                         .addComponent(jTextField_Flight_Class, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addGap(18, 18, 18)
                 
                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addGap(18, 18, 18)
                         .addComponent(jLabel8)
                         .addComponent(jTextField_Flight_Charges, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addGap(18, 18, 18)

                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addGap(18, 18, 18)

                		 .addComponent(jLabel9)
                       

                		 .addComponent(jTextField_Seats, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addGap(18, 18, 18)

                     .addComponent(jButton_Insert, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(jButton_Update, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(jButton_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addComponent(jButton_Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                   
                 .addGap(192, 192, 192))
             .addGroup(jPanel1Layout.createSequentialGroup()
                 .addContainerGap()
                 .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
         );
  
         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
         getContentPane().setLayout(layout);
         layout.setHorizontalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         );
         layout.setVerticalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         );

         pack();
     }// </editor-fold>                        

     private void jButton_ExitActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}

	private void jTextFieldArrived_TimeActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}

	private void jTextField_DestinationActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}

	private void jTextField_Flight_IDActionPerformed(java.awt.event.ActionEvent evt) {                                                     
         // TODO add your handling code here:
     }                                                    

     private void jTextField_Flight_NameActionPerformed(java.awt.event.ActionEvent evt) {                                                    
         // TODO add your handling code here:
     }                                                   

     private void jTextField_SourceActionPerformed(java.awt.event.ActionEvent evt) {                                               
         // TODO add your handling code here:
     } 
     private void jTextField_DepartureActionPerformed(java.awt.event.ActionEvent evt) {                                               
         // TODO add your handling code here:
     }
     private void jTextField_Flight_ClassActionPerformed(java.awt.event.ActionEvent evt) {                                               
         // TODO add your handling code here:
     }
     private void jTextField_Flight_ChargesActionPerformed(java.awt.event.ActionEvent evt) {                                               
         // TODO add your handling code here:
     }
     private void jTextField_SeatsActionPerformed(java.awt.event.ActionEvent evt) {                                               
         // TODO add your handling code here:
     }
     private void jTable_Display_UsersMouseClicked(java.awt.event.MouseEvent evt) {                                                  
         // Get The Index Of The Slected Row 
          int i = jTable_Display_Users.getSelectedRow();

          TableModel model = jTable_Display_Users.getModel();
          
           // Display Slected Row In JTexteFields
          jTextField_Flight_Id.setText(model.getValueAt(i,0).toString());
          jTextField_Flight_Name.setText(model.getValueAt(i,1).toString());
          jTextField_Source.setText(model.getValueAt(i,2).toString());
          jTextField_Departure.setText(model.getValueAt(i,3).toString());
          jTextField_Destination.setText(model.getValueAt(i,4).toString());
          jTextField_Arrived_Time.setText(model.getValueAt(i,5).toString());
          jTextField_Flight_Class.setText(model.getValueAt(i,6).toString());
          jTextField_Flight_Charges.setText(model.getValueAt(i,7).toString());
          jTextField_Seats.setText(model.getValueAt(i,8).toString());

      }                                                 

   // Button Insert
      private void jButton_InsertActionPerformed(java.awt.event.ActionEvent evt) {                                               
          String query = "INSERT INTO User1(Flight_Id,Flight_Name,Source,Departure,Destination,Arrived_Time,Flight_Class,Flight_Charges,Seats) VALUES ('"+jTextField_Flight_Id.getText()+"','"+jTextField_Flight_Name.getText()+"','"+jTextField_Source.getText()+"','"+jTextField_Departure.getText()+"','"+jTextField_Destination.getText()+"','"+jTextField_Arrived_Time.getText()+"','"+jTextField_Flight_Class.getText()+"','"+jTextField_Flight_Charges.getText()+"','"+jTextField_Seats.getText()+"')";
          
          executeSQlQuery(query, "Inserted");
        
      }                                              


   // Button Update
      private void jButton_UpdateActionPerformed(java.awt.event.ActionEvent evt) {                                               
         String query = "UPDATE User1 SET  Flight_ID = '"+jTextField_Flight_Id.getText()+"',Flight_Name='"+jTextField_Flight_Name.getText()+"',Source='"+jTextField_Source.getText()+"',Departure='"+jTextField_Departure.getText()+"',Destination='"+jTextField_Destination.getText()+"',flight_class='"+jTextField_Flight_Class.getText()+"',flight_charges='"+jTextField_Flight_Charges.getText()+"',seats='"+jTextField_Seats.getText()+"' WHERE Flight_ID = "+jTextField_Flight_Id.getText();
         executeSQlQuery(query, "Updated");
      }                                              


   // Button Delete
      private void jButton_DeleteActionPerformed(java.awt.event.ActionEvent evt) {                                               
          String query = "DELETE FROM User1 WHERE Flight_Id = "+jTextField_Flight_Id.getText();
           executeSQlQuery(query, "Deleted");
      }  
      // void jButton_ExitActionPerformed1(java.awt.event.ActionEvent evt) {
    	//  MenuTable mt= new MenuTable();
    	  //mt.setVisible(true);
    	  //dispose();
         
      //}//                                              


      //private MenuTable MenuTable() {
		// TODO Auto-generated method stub
		//return null;
	//}

	/**
       * @param args the command line arguments
       */
      public static void main(String args[]) {
          /* Set the Nimbus look and feel */
          //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
          /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
           * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
           */
          try {
              for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                  if ("Nimbus".equals(info.getName())) {
                      javax.swing.UIManager.setLookAndFeel(info.getClassName());
                      break;
                  }
              }
          } catch (ClassNotFoundException ex) {
              java.util.logging.Logger.getLogger(SwingJtable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (InstantiationException ex) {
              java.util.logging.Logger.getLogger(SwingJtable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (IllegalAccessException ex) {
              java.util.logging.Logger.getLogger(SwingJtable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (javax.swing.UnsupportedLookAndFeelException ex) {
              java.util.logging.Logger.getLogger(SwingJtable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
          //</editor-fold>

          /* Create and display the form */
          java.awt.EventQueue.invokeLater(new Runnable() {
              public void run() {
                  new SwingJtable().setVisible(true);
              }
          });
      }
}
