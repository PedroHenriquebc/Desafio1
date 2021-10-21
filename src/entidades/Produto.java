package entidades;

public class Produto {
	
	Integer codigo;
	String nome;
	Double pre�o;
	Integer estoque;
	
	public Produto() {
		
	}
	
	public Produto(Integer codigo, String nome, Double pre�o, Integer estoque) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.pre�o = pre�o;
		this.estoque = estoque;
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPre�o() {
		return pre�o;
	}
	public void setPre�o(Double pre�o) {
		this.pre�o = pre�o;
	}
	public Integer getEstoque() {
		return estoque;
	}
	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}

	@Override
	public String toString() {
		return "["+codigo+"]" +"	    " + nome + "	       	  " + pre�o + "	       		" +  estoque;
	}
	
	
}
