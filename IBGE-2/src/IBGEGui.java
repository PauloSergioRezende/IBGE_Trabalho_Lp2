

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
//import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JToggleButton;

public class IBGEGui implements WindowListener, ActionListener, ListSelectionListener{

	private JFrame frame;
	private JPanel mainPanel;
	private JPanel topPanel;
	private JPanel middlePanel;
	private JPanel queryPanel;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblC1;
	private JLabel lblC2;
	private JLabel lblC3;
	private JLabel lblC4;
	private JLabel lblC5;
	private JTextField tftC1;
	private JTextField tftC2;
	private JTextField tftC3;
	private JTextField tftC4;
	private JTextField tftC5;
	private TableModel tableModel;
	private int linhaSel;
	private JButton btnPrimeiro;
	private JButton btnAnterior;
	private JButton btnProximo;
	private JButton btnUltimo;
	private JToggleButton tglbtnOrdena;
	private JButton btnOcorrencias;
	private JToggleButton tglbtnKtoX;
	private JToggleButton tglbtnPopulation;
	private JButton btnEntereE;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IBGEGui window = new IBGEGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IBGEGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("IBGE");
		frame.setSize(450, 540);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addWindowListener(this);

		mainPanel = new JPanel();
		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(null);

		topPanel = new JPanel();
		topPanel.setBorder(new TitledBorder(null, "IBGE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		topPanel.setBounds(10, 11, 414, 149);
		mainPanel.add(topPanel);
		GridBagLayout gbl_topPanel = new GridBagLayout();
		gbl_topPanel.columnWidths = new int[] {95, 280};
		gbl_topPanel.rowHeights = new int[] {25, 25, 25, 25, 25};
		gbl_topPanel.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_topPanel.rowWeights = new double[]{Double.MIN_VALUE};
		topPanel.setLayout(gbl_topPanel);

		lblC1 = new JLabel("Sigla:");
		GridBagConstraints gbc_lblC1 = new GridBagConstraints();
		gbc_lblC1.anchor = GridBagConstraints.WEST;
		gbc_lblC1.insets = new Insets(0, 0, 5, 5);
		gbc_lblC1.gridx = 0;
		gbc_lblC1.gridy = 0;
		topPanel.add(lblC1, gbc_lblC1);

		tftC1 = new JTextField();
		GridBagConstraints gbc_tftC1 = new GridBagConstraints();
		gbc_tftC1.fill = GridBagConstraints.HORIZONTAL;
		gbc_tftC1.insets = new Insets(0, 0, 5, 0);
		gbc_tftC1.gridx = 1;
		gbc_tftC1.gridy = 0;
		topPanel.add(tftC1, gbc_tftC1);
		tftC1.setColumns(10);

		lblC2 = new JLabel("Cód. UF:");
		GridBagConstraints gbc_lblC2 = new GridBagConstraints();
		gbc_lblC2.anchor = GridBagConstraints.WEST;
		gbc_lblC2.insets = new Insets(0, 0, 5, 5);
		gbc_lblC2.gridx = 0;
		gbc_lblC2.gridy = 1;
		topPanel.add(lblC2, gbc_lblC2);

		tftC2 = new JTextField();
		GridBagConstraints gbc_tftC2 = new GridBagConstraints();
		gbc_tftC2.fill = GridBagConstraints.HORIZONTAL;
		gbc_tftC2.insets = new Insets(0, 0, 5, 0);
		gbc_tftC2.gridx = 1;
		gbc_tftC2.gridy = 1;
		topPanel.add(tftC2, gbc_tftC2);
		tftC2.setColumns(10);

		lblC3 = new JLabel("Cód. Mun.:");
		GridBagConstraints gbc_lblC3 = new GridBagConstraints();
		gbc_lblC3.anchor = GridBagConstraints.WEST;
		gbc_lblC3.insets = new Insets(0, 0, 5, 5);
		gbc_lblC3.gridx = 0;
		gbc_lblC3.gridy = 2;
		topPanel.add(lblC3, gbc_lblC3);

		tftC3 = new JTextField();
		GridBagConstraints gbc_tftC3 = new GridBagConstraints();
		gbc_tftC3.fill = GridBagConstraints.HORIZONTAL;
		gbc_tftC3.insets = new Insets(0, 0, 5, 0);
		gbc_tftC3.gridx = 1;
		gbc_tftC3.gridy = 2;
		topPanel.add(tftC3, gbc_tftC3);
		tftC3.setColumns(10);

		lblC4 = new JLabel("Município:");
		GridBagConstraints gbc_lblC4 = new GridBagConstraints();
		gbc_lblC4.anchor = GridBagConstraints.WEST;
		gbc_lblC4.insets = new Insets(0, 0, 5, 5);
		gbc_lblC4.gridx = 0;
		gbc_lblC4.gridy = 3;
		topPanel.add(lblC4, gbc_lblC4);

		tftC4 = new JTextField();
		GridBagConstraints gbc_tftC4 = new GridBagConstraints();
		gbc_tftC4.fill = GridBagConstraints.HORIZONTAL;
		gbc_tftC4.insets = new Insets(0, 0, 5, 0);
		gbc_tftC4.gridx = 1;
		gbc_tftC4.gridy = 3;
		topPanel.add(tftC4, gbc_tftC4);
		tftC4.setColumns(10);

		lblC5 = new JLabel("População:");
		GridBagConstraints gbc_lblC5 = new GridBagConstraints();
		gbc_lblC5.anchor = GridBagConstraints.WEST;
		gbc_lblC5.insets = new Insets(0, 0, 0, 5);
		gbc_lblC5.gridx = 0;
		gbc_lblC5.gridy = 4;
		topPanel.add(lblC5, gbc_lblC5);

		tftC5 = new JTextField();
		GridBagConstraints gbc_tftC5 = new GridBagConstraints();
		gbc_tftC5.fill = GridBagConstraints.HORIZONTAL;
		gbc_tftC5.gridx = 1;
		gbc_tftC5.gridy = 4;
		topPanel.add(tftC5, gbc_tftC5);
		tftC5.setColumns(10);

		middlePanel = new JPanel();
		middlePanel.setBounds(0, 171, 434, 32);
		mainPanel.add(middlePanel);

		btnPrimeiro = new JButton("|<");
		btnPrimeiro.addActionListener(this);
		middlePanel.add(btnPrimeiro);

		btnAnterior = new JButton("<<");
		btnAnterior.addActionListener(this);
		middlePanel.add(btnAnterior);

		btnProximo = new JButton(">>");
		btnProximo.addActionListener(this);
		middlePanel.add(btnProximo);

		btnUltimo = new JButton(">|");
		btnUltimo.addActionListener(this);
		middlePanel.add(btnUltimo);

		queryPanel = new JPanel();
		queryPanel.setBorder(new TitledBorder(null, "Minhas Queries", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		queryPanel.setBounds(0, 205, 434, 112);
		
		tglbtnOrdena = new JToggleButton("Ordem Alfabetica");
		tglbtnOrdena.addActionListener(this);
		queryPanel.add(tglbtnOrdena);
		mainPanel.add(queryPanel);
		
		btnOcorrencias = new JButton("Ocorrencias");
		queryPanel.add(btnOcorrencias);
		btnOcorrencias.addActionListener(this);
		
		tglbtnKtoX = new JToggleButton("KtoX");
		queryPanel.add(tglbtnKtoX);
		tglbtnKtoX.addActionListener(this);
		
		tglbtnPopulation = new JToggleButton("Menos de 100.000");
		queryPanel.add(tglbtnPopulation);
		tglbtnPopulation.addActionListener(this);
		
		btnEntereE = new JButton("Entere 150.000 e 50.000");
		queryPanel.add(btnEntereE);
		btnEntereE.addActionListener(this);

		tableModel = new TableModel();
		table = new JTable(tableModel);
		table.setFillsViewportHeight(true);      					//<<---
		table.getSelectionModel().addListSelectionListener(this);	//<<---

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 318, 434, 175);
		mainPanel.add(scrollPane);
		scrollPane.setViewportView(table);
		configTableColumns();

	}
	private void configTableColumns(){
		// para Cod. UF.
		DefaultTableCellRenderer cr_1 = new DefaultTableCellRenderer();
		cr_1.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(1).setCellRenderer(cr_1);
		// para Município
		DefaultTableCellRenderer cr_2 = new DefaultTableCellRenderer();
		cr_2.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(2).setCellRenderer(cr_2);
		// para Município
		DefaultTableCellRenderer cr_3 = new DefaultTableCellRenderer();
		cr_3.setHorizontalAlignment(JLabel.LEFT);
		table.getColumnModel().getColumn(3).setCellRenderer(cr_3);
		// para POPULAÇÃO
		DefaultTableCellRenderer cr_4 = new DefaultTableCellRenderer();
		cr_4.setHorizontalAlignment(JLabel.RIGHT);
		table.getColumnModel().getColumn(4).setCellRenderer(cr_4);
		// para todos
		//		DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
		//		cr.setHorizontalAlignment(JLabel.CENTER);
		//		table.setDefaultRenderer(String.class, cr);
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// obtem 1a linha da tabela
		String [] rData = (String[]) tableModel.getRowData(0);
		System.out.println("\nWindowActivated(): "+rData[0]+", "+
				rData[1]+", "+
				rData[2]+", "+
				rData[3]+", "+
				rData[4]);
		// carrega os campos do formulário
		tftC1.setText(rData[0]);
		tftC2.setText(rData[1]);
		tftC3.setText(rData[2]);
		tftC4.setText(rData[3]);
		tftC5.setText(rData[4]);
		// selecionar 1a linha
		linhaSel = 0;
		table.setRowSelectionInterval(0, 0);
		// posicionar o foco na 1a linha
		table.requestFocus();
		table.changeSelection(linhaSel, 0, false, false);
		// habilita navegação -> implementar ...
//		table.setAutoCreateRowSorter(true);
		habilitaSelecao();
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnPrimeiro){
			linhaSel = 0;
			table.requestFocus();
			table.changeSelection(linhaSel, 0, false, false);
		}
		if (e.getSource() == btnUltimo){
			linhaSel = table.getRowCount()-1;
			table.requestFocus();
			table.changeSelection(linhaSel, 0, false, false);
		}
		if (e.getSource() == btnProximo){
			linhaSel++;
			table.requestFocus();
			table.changeSelection(linhaSel, 0, false, false);
		}
		if (e.getSource() == btnAnterior){
			linhaSel--;
			table.requestFocus();
			table.changeSelection(linhaSel, 0, false, false);
		}
		if(e.getSource() == btnOcorrencias) {
			frequency(tableModel.getData());
		}
		if(e.getSource() == tglbtnOrdena) {
			if(tglbtnOrdena.isSelected()) {
				tableModel.setData(DataLoader.ordenaDados());
				atualizaTabela();
			}else {
				resetTableModle();
			}
		}
		if(e.getSource() == tglbtnKtoX) {
			if(tglbtnKtoX.isSelected()) {
				tableModel.setData(kTOx(tableModel.getData()));
				atualizaTabela();
			}else {
				resetTableModle();
			}
		}
		if(e.getSource() == tglbtnPopulation) {
			if(tglbtnPopulation.isSelected()) {
				tableModel.setData(populacaoInferior(tableModel.getData()));
				atualizaTabela();
			}else {
				resetTableModle();
			}
		}
		if(e.getSource() == btnEntereE) {
			contPopulacaoInferior(tableModel.getData());
			atualizaTabela();
		}
	}

	private void contPopulacaoInferior(Object[][] data) {
			int cont = 0;
			for (int i = 0; i < data.length; i++) {
				switch ((String) data[i][0]) {
				case "DF":
				case "GO":
				case "MT":
				case "MS":
					String aux = "";
					StringTokenizer aux2 = new StringTokenizer((String)data[i][4], ".");
					while(aux2.hasMoreTokens()) {
						aux += aux2.nextToken();
					}
				
					if(Double.valueOf(aux)<=150000 && Double.valueOf(aux)>=50000) {
						cont++;
					}
				default:
					break;
				}
			}
			System.out.println("Quantidade de municípios da região centro-oestecom"
					+ " população entre 50.000 e 150.000 habitantes: "+cont);
	}

	private Object[][] populacaoInferior(Object[][] data) {
			Stack<Object> pilha = new Stack<Object>();
			for (int i = 0; i < data.length; i++) {
				switch ((String) data[i][0]) {
				case "DF":
				case "GO":
				case "MT":
				case "MS":
					String aux = "";
					StringTokenizer aux2 = new StringTokenizer((String)data[i][4], ".");
					while(aux2.hasMoreTokens()) {
						aux += aux2.nextToken();
					}
				
					if(Double.valueOf(aux)<=100000) {
						pilha.push(data[i]);
					}
				default:
					break;
				}
			}
			Object[][] aux = new String[pilha.size()][5];
			int cont = pilha.size() - 1;
			while (!pilha.empty()) {
				aux[cont] = (Object[]) pilha.pop();
				cont--;
			}
		return aux;
	}

	public Object[][] kTOx(Object[][] data) {
		Stack<Object> pilha = new Stack<Object>();
		for (int i = 0; i < data.length; i++) {
			switch ((String) data[i][0]) {
			case "PR":
			case "SC":
			case "RS":
				if (((String) data[i][3]).toLowerCase().charAt(0) >= 'k'
						&& ((String) data[i][3]).toLowerCase().charAt(0) <= 'x') {
					pilha.push(data[i]);
				}
			default:
				break;
			}
		}
		Object[][] aux = new String[pilha.size()][5];
		int cont = pilha.size() - 1;
		while (!pilha.empty()) {
			aux[cont] = (Object[]) pilha.pop();
			cont--;
		}
		return aux;
	}

	public void frequency(Object[][] data) {
		Map<String, Integer> mapa = new HashMap<String, Integer>();
		String buffer = "";
		for (int i = 1; i < data.length; i++) {
			buffer += (String) data[i][3] + ",";
		}
		StringTokenizer tokenizer = new StringTokenizer(buffer, ",");
		while (tokenizer.hasMoreTokens()) {
			String word = tokenizer.nextToken().toLowerCase();
			if (mapa.containsKey(word)) {
				mapa.put(word, mapa.get(word) + 1);
			} else
				mapa.put(word, 1);
		}
		TreeSet<String> chavesOrdenadas = new TreeSet<String>(mapa.keySet());
		System.out.println("Ocorrencias:");
		for (String key : chavesOrdenadas)
			System.out.printf("%-21s%10s\n", key, mapa.get(key));
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// ler os valores da linha selecionada
		String [] rData = (String[]) tableModel.getRowData(table.getSelectedRow());
		System.out.println("\nvalueChanged(): "+
				rData[0]+", "+
				rData[1]+", "+
				rData[2]+", "+
				rData[3]+", "+
				rData[4]);
		// popular formulario
		tftC1.setText(rData[0]);
		tftC2.setText(rData[1]);
		tftC3.setText(rData[2]);
		tftC4.setText(rData[3]);
		tftC5.setText(rData[4]);
		// habilita seleção
		linhaSel = table.getSelectedRow();
		habilitaSelecao();
	}

	private void habilitaSelecao() {
		if (linhaSel == 0){
			btnPrimeiro.setEnabled(false);
			btnAnterior.setEnabled(false);
			btnProximo.setEnabled(true);
			btnUltimo.setEnabled(true);
		}
		else if (linhaSel == table.getRowCount()-1){
			btnPrimeiro.setEnabled(true);
			btnAnterior.setEnabled(true);
			btnProximo.setEnabled(false);
			btnUltimo.setEnabled(false);			
		}
		else{
			btnPrimeiro.setEnabled(true);
			btnAnterior.setEnabled(true);
			btnProximo.setEnabled(true);
			btnUltimo.setEnabled(true);			
		}
	}
	
	public void resetTableModle() {
		tableModel.setData(DataLoader.getData());;
		scrollPane.setViewportView(table);
		habilitaSelecao();
	}
	
	public void	atualizaTabela() {
		scrollPane.setViewportView(table);
		habilitaSelecao();
	}
}
