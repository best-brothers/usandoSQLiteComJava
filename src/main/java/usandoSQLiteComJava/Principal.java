package usandoSQLiteComJava;

public class Principal {

	public static void main(String[] args) {
		Banco.conectar();
		Banco.criarTabela("CREATE TABLE IF NOT EXISTS RC_TEST( ID INTEGER, NOME VARCHAR )");
		Banco.inserirRegistro();
		Banco.lendoRegistro();
	}

}
