import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Base64;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import java.awt.Window.Type;
import java.awt.Toolkit;


public class Encoder {

	private JFrame frmEncrypt;
	private JButton Decrypt;
	private JButton Encrypt;
	private JTextPane Input;
	private JTextPane Output;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Encoder window = new Encoder();
					window.frmEncrypt.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Encoder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEncrypt = new JFrame();
		frmEncrypt.setType(Type.UTILITY);
		frmEncrypt.setTitle("Encryptor");
		frmEncrypt.getContentPane().setBackground(Color.WHITE);
		frmEncrypt.setBounds(100, 100, 450, 241);
		frmEncrypt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEncrypt.getContentPane().setLayout(null);
		
		Decrypt = new JButton("Decrypt");
		Decrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				byte[] input = Base64.getDecoder().decode(Input.getText().getBytes());
				Output.setText(new String(input));
			}
		});
		Decrypt.setBounds(10, 92, 89, 23);
		frmEncrypt.getContentPane().add(Decrypt);
		
		Encrypt = new JButton("Encrypt");
		Encrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String input = Input.getText();
				String encodedBytes = Base64.getEncoder().encodeToString(input.getBytes());//encode(input.getBytes());
				//new Base64.Encoder.encode();
				System.out.println(encodedBytes);
				Output.setText(encodedBytes);
			}
		});
		Encrypt.setBounds(335, 92, 89, 23);
		frmEncrypt.getContentPane().add(Encrypt);
		
		Input = new JTextPane();
		Input.setBounds(10, 11, 414, 70);
		Input.setBorder(new LineBorder(new Color(0, 0, 0)));
		frmEncrypt.getContentPane().add(Input);
		
		Output = new JTextPane();
		Output.setBorder(new LineBorder(new Color(0, 0, 0)));
		Output.setBounds(10, 126, 414, 70);
		frmEncrypt.getContentPane().add(Output);
	}
}
