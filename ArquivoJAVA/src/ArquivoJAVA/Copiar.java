package ArquivoJAVA;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class Copiar extends JFrame{
	JButton copiar, limpar;
	JTextField origin, destiny, name;
	JLabel mensagem = new JLabel("Inforrme o endereco, nome e extencao do arquivo");
	JLabel mensagem2 = new JLabel("Exemplo: 'C:\\Users\\Joao\\Documents\\teste.txt'");
	JLabel origem = new JLabel("Origem:");
	JLabel destino = new JLabel("Destino:");
	JLabel nome = new JLabel("Nome do Arquivo (exemplo: 'novo.txt'):");
	Handler listener = new Handler();
	Scanner ler;
	String frase = "";
	Formatter novo;
	int x=0;
	Copiar(){
		super("Copiar Arquivo");
		setLayout(new FlowLayout());
		setSize(300,225);
		setVisible(true);
		
		copiar = new JButton("COPIAR");
		limpar = new JButton("LIMPAR");
		origin = new JTextField(20);
		//para fins de teste informe o seguinte endereço na caixa de texto "C:\Users\<nome_do_usuario>\Documents\teste.txt". Crie tambem o arquivo teste.txt e escreva algo nele
		destiny = new JTextField(20);//C:\Users\Gabriel\Documents\teste.txt
		//na caixa de texto de destino digite "C:\Users\<nome_do_usuario>\Documents\novo.txt". "novo.txt" pode ser substituido pelo nome que desejar que o arquivo seja nomeado
		name = new JTextField(5);
		copiar.addActionListener(listener);
		limpar.addActionListener(listener);
		
		add(mensagem);
		add(mensagem2);
		add(origem);
		add(origin);
		add(nome);
		add(name);
		add(destino);
		add(destiny);
		add(copiar);
		add(limpar);
	}
	
	class Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent evento) {
			if(evento.getSource()==copiar){
				//processo de leitura do arquivo existente
				abrir();
				ler();
				fechar();
				//processo de criação do novo arquivo com os dados do primiro
				criar();
				editar();
				fechando();
			}
			if(evento.getSource()==limpar){
				origin.setText("");
				destiny.setText("");
				name.setText("");
			}
		}
		
	}
	//processo de leitura do arquivo existente
	void abrir(){
		try{
			ler = new Scanner(new File(origin.getText()));
		}
		catch(FileNotFoundException x){
			System.err.println("Arquivo inacessivel");
			System.exit(1);
		}
	}
	
	void ler(){
		try{
			while(ler.hasNext()){//enquanto ouver algo para ler o laço o fará
				//no metodo abrir(), "ler" recebeu todo o conteudo do arquivo indicado pelo usuario
				//no comando abaixo definimos o que vai ser mostrado, no caso , Strings (ler.nextLine)
				frase +=  ler.nextLine() + "\r\n";//frase = frase + <proxima_linha>
			}
		}
		catch(NoSuchElementException e){
			System.err.println("Entrada diferente da esperada");
			System.exit(1);
		}
	}
	
	void fechar(){
		ler.close();
	}
	//processo de criação do novo arquivo com os dados do primiro
	void criar(){
		try{
			//destiny.setText(destiny.getText()+"\\"+name.getText());
			novo = new Formatter(destiny.getText()+"\\"+name.getText());
		}
		catch(FileNotFoundException s){
			System.err.println("Arquivo nao encontrado ou inacessivel");
			System.exit(1);
		}
	}
	
	void editar(){
		try{
			novo.format(frase);
		}
		catch(SecurityException sec){
			System.err.println("Arquivo nao editavel");
			System.exit(1);
		}
	}
	
	void fechando(){
		novo.close();
	}
	
}
