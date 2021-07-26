public interface Listavel {
	
	//anexa(insere ao final da lista) a lista o novo dado fornecido
	void anexar(Object elemento) throws Exception;
	
	//insere o novo dado fornecido na lista, numa posicao logica informada 
	void inserir(int posicao, Object elemento) throws Exception;
	
	//retorna o elemento que está numa posicao logica informada
	Object selecionarUm(int posicao) throws Exception;
	
	//substitui o elemento de uma posicao logica informada,
	//pelo novo elemento fornecido
	void atualizar(int posicao, Object novoElemento) throws Exception;
	
	//remove o elemento de uma posicao logica informada
	Object apagar(int posicao) throws Exception;
	
	//métodos auxiliares
	boolean estaCheia();
	boolean estaVazia();
	String imprimir();
}