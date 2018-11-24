

import java.util.List;
import java.util.StringTokenizer;

public class DataLoader{
	// atributos
	private static String[] header;
	private static Object[][] data;
	private static String path = "C:\\Users\\paulo\\eclipse-workspace\\IBGE-2\\src\\br\\Dados\\Atividade_T2_dados_IBGE.txt";
	private static String separator = "*";

	static{
		convertData(SuporteArquivo.leArquivo(path));
		convertHeader(SuporteArquivo.getHeader()); 		
	}
	
	// getters & setters
	public static String[] getHeader() {
		return header;
	}
	private static void setHeader(String[] header) {
		DataLoader.header = header;
	}
	public static Object[][] getData() {
		return data;
	}
	private static void setData(Object[][] data) {
		DataLoader.data = data;
	}

	// helper methods
	private static void convertHeader(String header) {
		setHeader(new String[5]);
		StringTokenizer st = new StringTokenizer(header, separator);
		int i = 0;
		while (st.hasMoreTokens()){
			DataLoader.header[i++] = st.nextToken();
		}
//		for (int k=0;k<this.columnNames.length;k++){
//			System.out.print(DataLoader.header[k]+" ");
//		}
	}
	private static void convertData(List<Municipio>municipios){
		data = new String[municipios.size()][5];
		int i = 0;
		for (Municipio municipio: municipios) {
			data[i]    = new String[5];
			data[i][0] = municipio.getSiglaUF();
			data[i][1] = municipio.getCodUF();
			data[i][2] = municipio.getCodMun();
			data[i][3] = municipio.getMunicipio();
			data[i][4] = municipio.getPopulacao(); 
			i++;
		}
//		System.out.println("============================= data.lenght: "+data.length);
//		for (int k=0;k<data.length;k++){
//			for (int m=0;m<data[k].length;m++){
//				System.out.print(data[k][m]+" ");				
//			}
//			System.out.println("\n");
//		}
	}
}
