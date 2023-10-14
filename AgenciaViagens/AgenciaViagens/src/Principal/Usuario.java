package Principal;

public class Usuario {
	private int usuId;

	private String nomeUsuario;
	private String celular;
	private String cpf;
	private String email;
	private String senha;
	private String genero;
	private String endereco;

	public Usuario(int usuId, String celular, String nomeUsuario, String cpf, String email, String senha,
			String genero) {
		super();
		this.usuId = usuId;
		this.celular = celular;
		this.nomeUsuario = nomeUsuario;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		this.genero = genero;
	}

	public Usuario() {
	}

	public int getusuId() {
		return usuId;
	}

	public void setusuId(int usuId) {
		this.usuId = usuId;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getnomeUsuario() {
		return nomeUsuario;
	}

	public void setnomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
