package Draw;


import CircuitList.CompList;
import CircuitList.Node;
import static Draw.Lienzo.CalcData;
import static Draw.Lienzo.vectorNodos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;



public class MainGUI  extends javax.swing.JFrame implements ActionListener {

    public CompList CList = new CompList();
    public int index = 0;
    JButton jButton1 = new javax.swing.JButton();

    public MainGUI() {
        initComponents();
    }
    
    private void initComponents() {

        JPanel jPanel1 = new javax.swing.JPanel();
        JPanel jPanel2 = new javax.swing.JPanel();
        Lienzo Lnz = new Lienzo();
        Paleta LnzPaleta = new Paleta();
        JLabel jLabel2 = new javax.swing.JLabel();
        
        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Circuit Designer");
        setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setText("Paleta");
        
        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jButton1.setText("Simulate");
        jButton1.addActionListener(this);
        

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 629, Short.MAX_VALUE)
                .addComponent(Lnz)
                
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 629, Short.MAX_VALUE)
            
                .addComponent(Lnz)
            
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)                 
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)        
                            .addComponent(jButton1)
                            .addComponent(LnzPaleta, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())                 
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(20, 20, 20))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LnzPaleta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }                      

    private void TablaV(){
        JFrame miniventana;
        
        miniventana = new JFrame("Tabla de Verdad");
        miniventana.setBounds(300, 300, 400, 200);
        TableModel modeloT = new AbstractTableModel(){
            @Override
            public int getRowCount() {
                return 4;
            }

            @Override
            public int getColumnCount() {
                System.out.println(vectorNodos.size());
                int cols = vectorNodos.size();

                System.out.println(cols);
                return cols;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                if((rowIndex < 2 && columnIndex == 0) || (rowIndex%2 == 0 && columnIndex == 1) ){
                    return 0;
                
                }else if((rowIndex > 1 && columnIndex == 0) || (rowIndex%2 == 1 && columnIndex == 1) ){
                    return 1;
                }else if (rowIndex == 0){
                    vectorNodos.get(0).asNode.setData(0);
                    vectorNodos.get(1).asNode.setData(0);
                    CalcOut();
                    return vectorNodos.get(columnIndex).asNode.getData();
                }else if (rowIndex == 1){
                    vectorNodos.get(0).asNode.setData(0);
                    vectorNodos.get(1).asNode.setData(1);
                    CalcOut();
                    vectorNodos.get(1).asNode.setData(1);
                    return vectorNodos.get(columnIndex).asNode.getData();
                }else if (rowIndex == 2){
                    vectorNodos.get(0).asNode.setData(1);
                    vectorNodos.get(1).asNode.setData(0);
                    CalcOut();
                    return vectorNodos.get(columnIndex).asNode.getData();
                }else {
                    vectorNodos.get(0).asNode.setData(1);
                    vectorNodos.get(1).asNode.setData(1);
                    CalcOut();
                    return vectorNodos.get(columnIndex).asNode.getData();
                }
            }
            
            public String getColumnName(int c){
                return (String) vectorNodos.get(c).asNode.getName();
            }

        
        };
        JTable TablaV = new JTable(modeloT); 
        miniventana.add(new JScrollPane(TablaV));
        miniventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        miniventana.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButton1){
            JOptionPane.showMessageDialog(rootPane,"El resultado es: "+ CalcOut());
            this.TablaV();
        }
    }
    
    public int CalcOut(){
        Node curr = new Node();
        curr = vectorNodos.lastElement().getAsNode();
        curr.setData(CalcData(curr));
        
        //System.out.println("El dato es de salida: "+curr.getData());
        return (int) curr.getData();
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainGUI().setVisible(true);
            
        });
    }




                 
}
