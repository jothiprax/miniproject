import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.text.DateFormat;
import java.util.Vector;
public class Cab {
private JTextField nameData;
private JTextField sourceData;
private JTable table1;
private JButton SEARCHButton;
private JButton BOOKButton;
private JPanel airPanel;
private JTextField fee;
private JTextField exp;
private JTextField destination;
private JPanel doj;
private JTextArea boardDetails;
private JLabel fare;
private JButton RESETButton;
JFrame planeF = new JFrame();
JDateChooser bookingDate = new JDateChooser();
public Cab(){


planeF.setContentPane(airPanel);
planeF.pack();
planeF.setLocationRelativeTo(null);
planeF.setVisible(true);
doj.add(bookingDate);
fare.setText("0");
SEARCHButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
if(destination.getText().equals("")|| sourceData.getText().equals("")){
JOptionPane.showMessageDialog(null,"Please Fill SOURCE & DESTINATION TO SEARCH.");
}else{
try {
String sql = "select * from cab WHERE SOURCE= '"+sourceData.getText()+"' AND DESTINATION= '"+destination.getText()+"'";
Class.forName("com.mysql.cj.jdbc.Driver");
Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/intern","root","root");
Statement statement = connection.createStatement();
ResultSet queryResult = statement.executeQuery(sql);
if(!queryResult.next())
JOptionPane.showMessageDialog(null,"NO CAB AVAILABLE");
else{
ResultSet queryResult1 = statement.executeQuery(sql);
table1.setModel(buildTableModel(queryResult1));
}
}catch (Exception ex){
JOptionPane.showMessageDialog(null,ex.getMessage());
}
}
}
});
BOOKButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
JOptionPane.showMessageDialog(null,"FIND YOUR CAB DETAILS ATTACHED");
printPass();
}
});
table1.addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent e) {
DefaultTableModel dm = (DefaultTableModel)table1.getModel();
int selectedRow = table1.getSelectedRow();
int a =(int)dm.getValueAt(selectedRow,4);
fare.setText(String.valueOf(a));
}
});
RESETButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
planeF.dispose();
new Cab();
}
});
}
public void printPass(){
DefaultTableModel dms = (DefaultTableModel)table1.getModel();
int selectedRow1 = table1.getSelectedRow();
String date = DateFormat.getDateInstance().format(bookingDate.getDate());
boardDetails.setText(boardDetails.getText() + " CAB DETAILS"+"\n");
boardDetails.setText(boardDetails.getText() + " ------***------"+"\n");
boardDetails.setText(boardDetails.getText() + "\n");
boardDetails.setText(boardDetails.getText() +"PASSENGER NAME: "+nameData.getText()+"\n");
boardDetails.setText(boardDetails.getText() +"DRIVER NAME: "+dms.getValueAt(selectedRow1,0)+"\n");
boardDetails.setText(boardDetails.getText() +"VEHICLE NO: "+dms.getValueAt(selectedRow1,1).toString()+"\n");
boardDetails.setText(boardDetails.getText() +"SOURCE: "+sourceData.getText()+"\n");
boardDetails.setText(boardDetails.getText() +"DESTINATION: "+destination.getText()+"\n");
boardDetails.setText(boardDetails.getText() +"DATE: "+ date+"\n");
boardDetails.setText(boardDetails.getText() +"TOTAL AMOUNT: "+"₹"+fare.getText()+"\n");
boardDetails.setText(boardDetails.getText() +"ARRIVING IN: "+"15 MINUTES");
}
public static DefaultTableModel buildTableModel(ResultSet rs)
throws SQLException {
ResultSetMetaData metaData = rs.getMetaData();
// names of columns
Vector<String> columnNames = new Vector<String>();
int columnCount = metaData.getColumnCount();
for (int column = 1; column <= columnCount; column++) {
columnNames.add(metaData.getColumnName(column));
}
// data of the table
Vector<Vector<Object>> data = new Vector<Vector<Object>>();
while (rs.next()) {
Vector<Object> vector = new Vector<Object>();
for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
vector.add(rs.getObject(columnIndex));
}
data.add(vector);
}
return new DefaultTableModel(data, columnNames);
}
}