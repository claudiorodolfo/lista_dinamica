public class ListaDinamica implements Listavel {

	private int quantidade;
	private int tamanho;
	private NoDuplo ponteiroInicio;
	private NoDuplo ponteiroFim;

	public ListaDinamica() {
		this(10);
	}

	public ListaDinamica(int tamanho) {
		quantidade = 0;
		this.tamanho = tamanho;
		ponteiroInicio = null;
		ponteiroFim = null;
	}

	/*
	 * Adiciona um elemento ao fim da lista.
	 * Params: Recebe o dado a ser inserido na lista.
	 * Return: Não retorna nada.
	 * Exception: Caso se tente inserir um elemento na lista e ela já está cheia.
	 */
	public void anexar(Object dado) throws OverflowException {
		if(!estaCheia()) {
			NoDuplo noTemporario = new NoDuplo();
			noTemporario.setDado(dado);
			if (!estaVazia()) {
				ponteiroFim.setProximo(noTemporario);
			} else  {
				ponteiroInicio = noTemporario;
			}
			noTemporario.setAnterior(ponteiroFim);
			ponteiroFim = noTemporario;

			quantidade++;
		} else {
			throw new OverflowException("Fila Cheia!");
		}
	}

	/*
	 * Insere um elemento numa posicao específica da lista.
	 * Params: Recebe o dado a ser inserido na lista e a sua posição.
	 * Return: Não retorna nada.
	 * Exception: Caso tente inserir um elemento na lista e ela já está cheia.
	 */
	public void inserir(int posicao, Object dado) throws OverflowException {
		if(!estaCheia()) {
			if((posicao >= 0) && (posicao <= quantidade)) {
				NoDuplo noTemporario = new NoDuplo();
				noTemporario.setDado(dado);
				////////////////////////////////
				//Codigo de posicionamento do ponteiro auxiliar, no nodo
				//que serah feita alguma operacao. Lembrando que nesse metodo
				//auxiliar ira parar no nodo subsequente ao nodo que devera 
				//ser inserido				
				NoDuplo ponteiroAnterior = null;
				NoDuplo ponteiroAuxiliar = ponteiroInicio;
				NoDuplo ponteiroProximo = ponteiroAuxiliar;

				for (int i = 0; i < posicao; i++) {
					ponteiroAnterior = ponteiroAuxiliar;
					ponteiroAuxiliar = ponteiroAuxiliar.getProximo();
					ponteiroProximo = ponteiroAuxiliar;
				}

				if (ponteiroAnterior != null) {
					ponteiroAnterior.setProximo(noTemporario);
				//se o anterior é nulo é pq a insercao está sendo no inicio
				} else {
					ponteiroInicio = noTemporario;
				}

				if (ponteiroProximo != null) {
				ponteiroProximo.setAnterior(noTemporario);
				//se o proximo é nulo é pq a insercao está sendo no fim (append)
				} else {
					ponteiroFim = noTemporario;
				}
				
				noTemporario.setAnterior(ponteiroAnterior);
				noTemporario.setProximo(ponteiroProximo);

				quantidade++;
	        } else {
            	System.err.println("Indice Inválido");
            }
		} else {
			throw new OverflowException("Lista Cheia!");
		}
	}

	/*
	 * Seleciona o elemento que está numa posicao logica informada.
	 * Params: Recebe uma posição de um objeto da lista.
	 * Return: Retorna o objeto da posição indicada.
	 * Excetion: Não gera exceção.
	 */
	public Object selecionarUm(int posicao) {
		Object elementoTemporario = null;
		if (!estaVazia()) {
			if ((posicao >= 0) && (posicao < quantidade)) {
				////////////////////////////////
				//Codigo de posicionamento do ponteiro auxiliar, no nodo
				//que serah feita alguma operacao. Esse codigo eh o mesmo
				//para os metodos update, delete e select
				NoDuplo ponteiroAuxiliar = ponteiroInicio;
				for (int i = 0; i < posicao; i++) {
					ponteiroAuxiliar = ponteiroAuxiliar.getProximo();
				}
				///////////////////////////////
				elementoTemporario = ponteiroAuxiliar.getDado();
            } else {
               System.err.println("Indice Inválido");
            }
		} else {
			System.err.println("Lista Vazia");	
		}
		return elementoTemporario;
	}

	/*
	 * Atualiza o elemento de uma posicao logica informada por um novo.
	 * Params: Recebe uma posição de um objeto da lista, e o novo objeto.
	 * Return: Não retorno nada.
	 * Excetion: Não gera exceção.
	 */	
	public void atualizar(int posicao, Object novoDado) {
		if (!estaVazia()) {
			if ((posicao >= 0) && (posicao < quantidade)) {
				////////////////////////////////
				//Codigo de posicionamento do ponteiro auxiliar, no nodo
				//que serah feita alguma operacao. Esse codigo eh o mesmo
				//para os metodos update, delete e select
				NoDuplo ponteiroAuxiliar = ponteiroInicio;
				for (int i = 0; i < posicao; i++) {
					ponteiroAuxiliar = ponteiroAuxiliar.getProximo();
				}
				///////////////////////////////
				ponteiroAuxiliar.setDado(novoDado);
            } else {
               System.err.println("Indice Inválido");
            }
		} else {
			System.err.println("Lista Vazia");
		}
	}
	
	/*
	 * Apaga o elemento de uma posicao logica informada.
	 * Params: Recebe uma posição de um objeto da lista.
	 * Return: O objeto apagado.
	 * Excetion: Caso tente-se apagar um elemento de uma lista vazia.
	 */	 
	public Object apagar(int posicao) throws UnderflowException {
		Object noTemporario = null;
		if (!estaVazia()) {
			if ((posicao >=0) && (posicao < quantidade)) {
				////////////////////////////////
				//Codigo de posicionamento do ponteiro auxiliar, no nodo
				//que serah feita alguma operacao. Esse codigo eh o mesmo
				//para os metodos update, delete e select
				NoDuplo ponteiroAuxiliar = ponteiroInicio;
				for (int i = 0; i < posicao; i++) {
					ponteiroAuxiliar = ponteiroAuxiliar.getProximo();
				}
				///////////////////////////////
				noTemporario = ponteiroAuxiliar.getDado();

				NoDuplo ponteiroAnterior = ponteiroAuxiliar.getAnterior();
				NoDuplo ponteiroProximo = ponteiroAuxiliar.getProximo();

				if (ponteiroAnterior != null) {
					ponteiroAnterior.setProximo(ponteiroProximo);
				//remocao do inicio, joga o ponteiro de inicio para o proximo nodo.
				} else {
					ponteiroInicio = ponteiroInicio.getProximo();
				}
				if (ponteiroProximo != null) {
					ponteiroProximo.setAnterior(ponteiroAnterior);
				//remocao do fim, joga o ponteiro de fim para o nodo anterior.
				} else {
					ponteiroFim = ponteiroFim.getAnterior();
				}

				quantidade--;
            } else {
               System.err.println("Indice Inválido");
            } 
		} else {
			throw new UnderflowException("Lista Vazia!");	
		}	
		return noTemporario;	
	}

	/*
	 * Informa se a lista está cheia.
	 * Params: Não recebe nada.
	 * Return: Um valor lógico dizendo se a lista está cheia ou não.
	 * Excetion: Não gera exceção.
	 */	
	public boolean estaCheia() {
		return (quantidade == tamanho);
	}

	/*
	 * Informa se a lista está vazia.
	 * Params: Não recebe nada.
	 * Return: Um valor lógico dizendo se a lista está vazia ou não.
	 * Excetion: Não gera exceção.
	 */	
	public boolean estaVazia() {
		return (quantidade == 0);
	}

	/*
	 * Imprime o conteúdo da lista.
	 * Params: Não recebe nada.
	 * Return: Uma string com todos os elementos da lista separados por ",".
	 * Excetion: Não gera exceção.
	 */	
	public String imprimir() {
		NoDuplo ponteiroAuxiliar = ponteiroInicio;
		String conteudo = "[";
		for (int i = 0; i < quantidade; i++) {
		if (i == quantidade-1) {
				conteudo += ponteiroAuxiliar.getDado();
			} else {
				conteudo += ponteiroAuxiliar.getDado() + ",";
			}
			ponteiroAuxiliar = ponteiroAuxiliar.getProximo();
		}
		return conteudo + "]";
	}
}