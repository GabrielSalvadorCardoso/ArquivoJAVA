package ArquivoJAVA;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class Index extends JFrame{
	JButton copiar, criar;
	JLabel texto = new JLabel("O que deseja fazer?");
	Handler listener = new Handler();
	Index(){
		super("Manipulador de Arquivos");
		setLayout(new FlowLayout());
		
		copiar = new JButton("COPIAR ARQUIVO");
		criar = new JButton("CRIAR ARQUIVO");
		
		copiar.addActionListener(listener);
		criar.addActionListener(listener);
		
		add(texto);
		add(criar);
		add(copiar);
	}
	
	class Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent evento) {
			if(evento.getSource()==copiar){
				new Copiar();
			}
			if(evento.getSource()==criar){
				System.out.println("Criar Arquivo");
			}
		}
		
	}
	
}
