package ArquivoJAVA;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.NoSuchElementException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class Criar extends JFrame {
	JLabel mens1 = new JLabel("Digite um breve texto para ser inserido no arquivo");
	JLabel mens2 = new JLabel("Digite o nome e extensão do arquivo");
	JLabel mens3 = new JLabel("Onde deseja salvar o arquivo");
	JButton criar, limpar;
	JTextField texto, end, nome;	
	Handler listener = new Handler();
	Formatter arquivo;
	
	Criar(){
		super("Criar Aquivo");
		setLayout(new FlowLayout());
		setSize(300,200);
		setVisible(true);
		
		texto = new JTextField(25);
		nome = new JTextField(5);
		end = new JTextField(20);//C:\Users\Gabriel\Music\Celular
		criar = new JButton("CRIAR");
		limpar = new JButton("LIMPAR");
		
		criar.addActionListener(listener);
		limpar.addActionListener(listener);
		
		add(mens1);
		add(texto);
		add(mens2);
		add(nome);
		add(mens3);
		add(end);
		add(criar);
		add(limpar);
	}
	
	class Handler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evento) {
			if(evento.getSource()==limpar){
				texto.setText("");
				nome.setText("");
				end.setText("");
			}
			if(evento.getSource()==criar){
				criar();
				editar();
				fechar();
			}
			
	}
		
		void criar(){

			try{
				end.setText(end.getText()+"\\"+nome.getText());
				arquivo = new Formatter(end.getText());
			}
			catch(FileNotFoundException x){
				System.err.println("Arquivo nao pode ser criado");
			}
		}
		
		void editar(){
			try{
				arquivo.format(texto.getText());
			}
			catch(NoSuchElementException e){
				System.err.println("Arquivo nao pode ser criado");
			}
		}
		
		void fechar(){
			arquivo.close();
		}
		
	}	
	
}
