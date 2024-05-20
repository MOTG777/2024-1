package banco.bd;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;

	public class Pessoa {
		private int codigo;
		private String nome;
		private String fone;
		private String email;
		
		public Pessoa() {
			this.codigo = -1;
			this.nome = "";
			this.fone = "";
			this.email = "";
		}
		public Pessoa(String n, String f, String e) {
			this.nome = n;
			this.fone = f;
			this.email = e;
		}
	
	public void inserir (){
		//1: Definir o comando SQL
		String sql = "INSERT INTO tb_empregados(nome, fone, email) VALUES (?, ?, ?);";
		//2: Abrir uma conexão
		ConexaoBD factory = new ConexaoBD();
		try (Connection c = factory.obtemConexao()){
		//3: Pré compila o comando
		PreparedStatement ps = c.prepareStatement(sql);
		//4: Preenche os dados faltantes "?"
		ps.setString(1, nome);
		ps.setString(2, fone);
		ps.setString(3, email);
		//5: Executa o comando
		ps.execute();
		}
		catch (Exception e){
		e.printStackTrace();
		}
	}
	public void atualizar(){
		//1: Definir o comando SQL
		String sql = "UPDATE tb_empregados SET nome = ?, fone = ?, email = ? WHERE codigo = ?;";
		//2: Abrir uma conexão
		ConexaoBD factory = new ConexaoBD();
		try (Connection c = factory.obtemConexao()){
		//3: Pré compila o comando
		PreparedStatement ps = c.prepareStatement(sql);
		//4: Preenche os dados faltantes "?"
		ps.setString(1, nome);
		ps.setString(2, fone);
		ps.setString(3, email);
		ps.setInt(4, codigo);
		//5: Executa o comando
		ps.execute();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		}
	public void apagar (){
		//1: Definir o comando SQL
		String sql = "DELETE FROM tb_empregados WHERE codigo = ?;";
		//2: Abrir uma conexão
		ConexaoBD factory = new ConexaoBD();
		try (Connection c = factory.obtemConexao()){
		//3: Pré compila o comando
		PreparedStatement ps = c.prepareStatement(sql);
		//4: Preenche os dados faltantes "?"
		ps.setInt(1, codigo);
		//5: Executa o comando
		ps.execute();
		}
		catch (Exception e){
		e.printStackTrace();
		}
		}
	public void listar (){
		//1: Definir o comando SQL
		String sql = "SELECT * FROM tb_empregados;";
		//2: Abrir uma conexão
		ConexaoBD factory = new ConexaoBD();
		try (Connection c = factory.obtemConexao()){
			//3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			//4: Executa o comando e guarda
			//o resultado em um ResultSet
			ResultSet rs = ps.executeQuery();
			//5: itera sobre o resultado
			int cod;
			String n, f, e, aux; 
			while (rs.next()){
			cod = rs.getInt("codigo_empregado");
			n = rs.getString("nome");
			f = rs.getString("fone");
			e = rs.getString("email");
			aux = String.format("Código: %d, Nome: %s, Fone: %s, Email: %s", cod, n, f, e);
			System.out.printf("\n%s", aux);
		}
		System.out.printf("\n");
		}
		catch (Exception e){
			e.printStackTrace();
		}
		}
	public Pessoa mostraPorId(int codigo) {
		String sql = "SELECT * FROM tb_empregados WHERE codigo = ?;";
		String nome = "";
		String fone = "";
		String email = "";
		//2: Abrir uma conexao
		ConexaoBD factory = new ConexaoBD();
		try (Connection c = factory.obtemConexao()){
			//3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement
			(sql);
			//4: Preenche os dados faltantes
			ps.setInt(1, codigo);
			//5: Executa o comando e guarda
			//o resultado em um ResultSet
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
			nome = rs.getString("nome");
			fone = rs.getString("fone");
			email = rs.getString("email");
		}
		else {
			System.out.printf("\nPessoa não encontrada!");
		}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		Pessoa p2 = new Pessoa(nome,fone,email);
		p2.setCodigo(codigo);
		return p2;
		}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}

