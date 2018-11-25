
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {
	private boolean DEBUG = false;

	private String[] columnNames = DataLoader.getHeader();
	private Object[][] data = DataLoader.getData();

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return data.length;
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public Object getValueAt(int row, int col) {
		return data[row][col];
	}

	public Object getRowData(int row) {
		return data[row];
	}

	public void setData(Object[][] data) {
		this.data = data;
	}

	public void frequency() {
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

	public void kTOx() {
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
		data = aux;

	}

	public void populacaoInferior() {
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
		data = aux;
	}
	public void contPopulacaoInferior() {
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
	/*
	 * JTable uses this method to determine the default renderer/ editor for each
	 * cell. If we didn't implement this method, then the last column would contain
	 * text ("true"/"false"), rather than a check box.
	 */
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

	/*
	 * Don't need to implement this method unless your table's editable.
	 */
	public boolean isCellEditable(int row, int col) {
		// Note that the data/cell address is constant,
		// no matter where the cell appears onscreen.
		if (col < 2) {
			return false;
		} else {
			return true;
		}
	}

	/*
	 * Don't need to implement this method unless your table's data can change.
	 */
	public void setValueAt(Object value, int row, int col) {
		if (DEBUG) {
			System.out.println("Setting value at " + row + "," + col + " to " + value + " (an instance of "
					+ value.getClass() + ")");
		}

		data[row][col] = value;
		fireTableCellUpdated(row, col);

		if (DEBUG) {
			System.out.println("New value of data:");
			printDebugData();
		}
	}

	private void printDebugData() {
		int numRows = getRowCount();
		int numCols = getColumnCount();

		for (int i = 0; i < numRows; i++) {
			System.out.print("    row " + i + ":");
			for (int j = 0; j < numCols; j++) {
				System.out.print("  " + data[i][j]);
			}
			System.out.println();
		}
		System.out.println("--------------------------");
	}
}
