public class test {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My title!");
        frame.setVisible(true);
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        JPanel panel = new JPanel();
        frame.add(panel);
 
        JLabel label = new JLabel("my label");
        panel.add(label);
 
        JButton button = new JButton("my button");
        panel.add(button);
        button.addActionListener(new MyAction());
    }
 
    static class MyAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame2 = new JFrame("clicked");
            frame2.setVisible(true);
            frame2.setSize(200,200);
        }
    }
}
