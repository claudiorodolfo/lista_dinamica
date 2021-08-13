public interface Listavel {
	
	//anexa(insere ao final da lista) a lista o novo dado fornecido
	void anexar(Object elemento) throws OverflowException;
	
	//insere o novo dado fornecido na lista, numa posicao logica informada 
	void inserir(int posicao, Object elemento) throws OverflowException;
	
	//retorna o elemento que está numa posicao logica informada
	Object selecionarUm(int posicao);
	
	//substitui o elemento de uma posicao logica informada,
	//pelo novo elemento fornecido
	void atualizar(int posicao, Object novoElemento);
	
	//remove o elemento de uma posicao logica informada
	Object apagar(int posicao) throws UnderflowException;
	
	//métodos auxiliares
	boolean estaCheia();
	boolean estaVazia();
	String imprimir();
}